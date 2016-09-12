/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2016                                             
 *                                                                                                                                 
 *  Creation Date: 16.05.2013                                                      
 *                                                                              
 *******************************************************************************/

package org.oscm.ui.filter;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.oscm.internal.intf.ConfigurationService;
import org.oscm.internal.intf.TenantService;
import org.oscm.internal.types.enumtypes.AuthenticationMode;
import org.oscm.internal.types.enumtypes.ConfigurationKey;
import org.oscm.internal.types.exception.NotExistentTenantException;
import org.oscm.internal.types.exception.ObjectNotFoundException;
import org.oscm.internal.vo.VOConfigurationSetting;
import org.oscm.internal.vo.VOTenant;
import org.oscm.types.constants.Configuration;

/**
 * @author stavreva
 * 
 */
public class AuthenticationSettingsTest {

    private static final String ISSUER = "OSCM";
    private static final String IDP = "http://idp.de:9080/openam/SSORedirect/metaAlias/idp";
    private static final String IDP_UPPERCASE = IDP.toUpperCase();
    private static final String IDP_CONTEXT_ROOT = "http://idp.de:9080/openam";
    private static final String IDP_HTTP_METHOD = "POST";
    private static final String IDP_KEYSTORE_PASS = "changeit";
    private static final String BASE_URL = "http://www.example.de";

    private AuthenticationSettings authSettings;
    private ConfigurationService cfgMock;
    private TenantService tenantService;
    private VOTenant mockTenant;

    @Before
    public void setup() throws Exception {
        tenantService = mock(TenantService.class);
        mockTenant = mock(VOTenant.class);
        doReturn(ISSUER).when(mockTenant).getIssuer();
        doReturn(IDP).when(mockTenant).getIDPURL();
        doReturn(IDP_HTTP_METHOD).when(mockTenant).getIdpHttpMethod();
        doReturn(IDP_KEYSTORE_PASS).when(mockTenant).getSigningKeystorePass();
        doReturn(IDP_KEYSTORE_PASS).when(mockTenant).getSigningKeystore();
        doReturn(IDP_KEYSTORE_PASS).when(mockTenant).getSigningKeyAlias();
        doReturn(IDP_KEYSTORE_PASS).when(mockTenant).getLogoutURL();
        doReturn(mockTenant).when(tenantService).findByTkey(any(String.class));
        cfgMock = mock(ConfigurationService.class);
    }

    private void givenMock(AuthenticationMode authMode, String idpUrl) {
        doReturn(
                new VOConfigurationSetting(ConfigurationKey.AUTH_MODE,
                        Configuration.GLOBAL_CONTEXT, authMode.name())).when(
                cfgMock).getVOConfigurationSetting(ConfigurationKey.AUTH_MODE,
                Configuration.GLOBAL_CONTEXT);
        doReturn(
                new VOConfigurationSetting(ConfigurationKey.SSO_IDP_URL,
                        Configuration.GLOBAL_CONTEXT, idpUrl)).when(cfgMock)
                .getVOConfigurationSetting(ConfigurationKey.SSO_IDP_URL,
                        Configuration.GLOBAL_CONTEXT);
        doReturn(
                new VOConfigurationSetting(ConfigurationKey.BASE_URL,
                        Configuration.GLOBAL_CONTEXT, idpUrl)).when(cfgMock)
                .getVOConfigurationSetting(ConfigurationKey.BASE_URL,
                        Configuration.GLOBAL_CONTEXT);
        authSettings = new AuthenticationSettings(tenantService, cfgMock);
    }

    @Test
    public void constructor() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        verify(cfgMock, times(1)).getVOConfigurationSetting(
                ConfigurationKey.AUTH_MODE, Configuration.GLOBAL_CONTEXT);
    }

    @Test
    public void isServiceProvider() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertTrue(authSettings.isServiceProvider());
    }

    @Test
    public void isInternal() throws Exception {

        // given
        givenMock(AuthenticationMode.INTERNAL, IDP);

        // then
        assertTrue(authSettings.isInternal());
    }

    @Test
    public void getIssuer() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(ISSUER, authSettings.getIssuer("tenantID"));
    }

    @Test
    public void getIdentityProviderURL() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(IDP, authSettings.getIdentityProviderURL("tenantID"));
    }

    @Test
    public void getIdentityProviderURLContextRoot() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(IDP_CONTEXT_ROOT,
                authSettings.getIdentityProviderURLContextRoot("tenantID"));
    }

    @Test
    public void getIdentityProviderURLContextRoot_Uppercase() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP_UPPERCASE);

        // then
        assertEquals(IDP_CONTEXT_ROOT,
                authSettings.getIdentityProviderURLContextRoot("tenantID"));
    }

    @Test
    public void getConfigurationSetting_null() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);
        doReturn(null).when(cfgMock).getVOConfigurationSetting(
                ConfigurationKey.LOG_LEVEL, Configuration.GLOBAL_CONTEXT);

        // then
        assertNull(authSettings.getConfigurationSetting(cfgMock,
                ConfigurationKey.LOG_LEVEL));
    }

    @Test
    public void getConfigurationSetting() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals("SAML_SP", authSettings.getConfigurationSetting(cfgMock,
                ConfigurationKey.AUTH_MODE));
    }

    @Test
    public void getContextRoot_null() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertNull(authSettings.getContextRoot(null));
    }

    @Test
    public void getContextRoot_empty() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertNull(authSettings.getContextRoot(""));
    }

    @Test
    public void getContextRoot_lessTokens() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertNull(authSettings.getContextRoot("http://www.idp.de/"));
    }

    @Test
    public void getContextRoot() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(IDP_CONTEXT_ROOT, authSettings.getContextRoot(IDP));
    }

    @Test
    public void getIdentityProviderHttpMethod() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(IDP_HTTP_METHOD,
                authSettings.getIdentityProviderHttpMethod("tenantID"));
    }

    @Test
    public void getSigningKeystorePass() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(IDP_KEYSTORE_PASS,
                authSettings.getSigningKeystorePass("tenantID"));
    }

    @Test
    public void getSigningKeystore() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(IDP_KEYSTORE_PASS,
                authSettings.getSigningKeystore("tenantID"));
    }

    @Test
    public void getSigningKeyAlias() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(IDP_KEYSTORE_PASS,
                authSettings.getSigningKeyAlias("tenantID"));
    }

    @Test
    public void getLogoutURL() throws Exception {

        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);

        // then
        assertEquals(IDP_KEYSTORE_PASS,
                authSettings.getLogoutURL("tenantID"));
    }

    @Test
    public void getTenantBlank() throws Exception {
        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);
        authSettings = spy(authSettings);
        doReturn(IDP_KEYSTORE_PASS).when(authSettings).
                getConfigurationSetting(cfgMock, ConfigurationKey.SSO_SIGNING_KEYSTORE_PASS);

        // then
        assertEquals(IDP_KEYSTORE_PASS,
                authSettings.getSigningKeystorePass(null));
    }

    @Test(expected = NotExistentTenantException.class)
    public void findByTKey() throws ObjectNotFoundException, NotExistentTenantException {
        // given
        givenMock(AuthenticationMode.SAML_SP, IDP);
        doThrow(new ObjectNotFoundException()).when(tenantService).findByTkey(anyString());

        // then
        authSettings.getSigningKeystorePass("asdf");
    }

}
