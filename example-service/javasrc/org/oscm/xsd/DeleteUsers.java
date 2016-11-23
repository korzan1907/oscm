
/**
 * DeleteUsers.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

package org.oscm.xsd;

/**
 * DeleteUsers bean class
 */

public class DeleteUsers implements org.apache.axis2.databinding.ADBBean {
    /*
     * This type was generated from the piece of schema that had name =
     * deleteUsers Namespace URI = http://oscm.org/xsd Namespace Prefix = ns1
     */

    /**
     * field for InstanceId
     */

    protected java.lang.String localInstanceId;
    /*
     * This tracker boolean wil be used to detect whether the user called the
     * set method for this attribute. It will be used to determine whether to
     * include this field in the serialized XML
     */
    protected boolean localInstanceIdTracker = false;
    /**
     * field for Users This was an Array!
     */

    protected org.oscm.xsd.User[] localUsers;
    /*
     * This tracker boolean wil be used to detect whether the user called the
     * set method for this attribute. It will be used to determine whether to
     * include this field in the serialized XML
     */
    protected boolean localUsersTracker = false;
    /**
     * field for RequestingUser
     */

    protected org.oscm.xsd.User localRequestingUser;
    /*
     * This tracker boolean wil be used to detect whether the user called the
     * set method for this attribute. It will be used to determine whether to
     * include this field in the serialized XML
     */
    protected boolean localRequestingUserTracker = false;

    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("http://oscm.org/xsd")) {
            return "ns1";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * isReaderMTOMAware
     *
     * @return true if the reader supports MTOM
     */
    public static boolean isReaderMTOMAware(
            javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try {
            isReaderMTOMAware = java.lang.Boolean.TRUE
                    .equals(reader.getProperty(
                            org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        } catch (java.lang.IllegalArgumentException e) {
            isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
    }

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getInstanceId() {
        return localInstanceId;
    }

    /**
     * Auto generated setter method
     *
     * @param param
     *            InstanceId
     */
    public void setInstanceId(java.lang.String param) {

        if (param != null) {
            // update the setting tracker
            localInstanceIdTracker = true;
        } else {
            localInstanceIdTracker = false;

        }

        this.localInstanceId = param;

    }

    /**
     * Auto generated getter method
     *
     * @return org.oscm.xsd.User[]
     */
    public org.oscm.xsd.User[] getUsers() {
        return localUsers;
    }

    /**
     * Auto generated setter method
     *
     * @param param
     *            Users
     */
    public void setUsers(org.oscm.xsd.User[] param) {

        validateUsers(param);

        if (param != null) {
            // update the setting tracker
            localUsersTracker = true;
        } else {
            localUsersTracker = false;

        }

        this.localUsers = param;
    }

    /**
     * validate the array for Users
     */
    protected void validateUsers(org.oscm.xsd.User[] param) {

    }

    /**
     * Auto generated add method for the array for convenience
     *
     * @param param
     *            org.oscm.xsd.User
     */
    public void addUsers(org.oscm.xsd.User param) {
        if (localUsers == null) {
            localUsers = new org.oscm.xsd.User[] {};
        }

        // update the setting tracker
        localUsersTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
                .toList(localUsers);
        list.add(param);
        this.localUsers = (org.oscm.xsd.User[]) list
                .toArray(new org.oscm.xsd.User[list.size()]);

    }

    /**
     * Auto generated getter method
     *
     * @return org.oscm.xsd.User
     */
    public org.oscm.xsd.User getRequestingUser() {
        return localRequestingUser;
    }

    /**
     * Auto generated setter method
     *
     * @param param
     *            RequestingUser
     */
    public void setRequestingUser(org.oscm.xsd.User param) {

        if (param != null) {
            // update the setting tracker
            localRequestingUserTracker = true;
        } else {
            localRequestingUserTracker = false;

        }

        this.localRequestingUser = param;

    }

    /**
     *
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {

        org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                this, parentQName) {

            public void serialize(
                    org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                    throws javax.xml.stream.XMLStreamException {
                DeleteUsers.this.serialize(parentQName, factory, xmlWriter);
            }
        };
        return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                parentQName, factory, dataSource);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory,
            org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {
        serialize(parentQName, factory, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory,
            org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
            boolean serializeType) throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {

        java.lang.String prefix = null;
        java.lang.String namespace = null;

        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();

        if ((namespace != null) && (namespace.trim().length() > 0)) {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace,
                        parentQName.getLocalPart());
            } else {
                if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(),
                        namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        } else {
            xmlWriter.writeStartElement(parentQName.getLocalPart());
        }

        if (serializeType) {

            java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                    "http://oscm.org/xsd");
            if ((namespacePrefix != null)
                    && (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":deleteUsers", xmlWriter);
            } else {
                writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "deleteUsers", xmlWriter);
            }

        }
        if (localInstanceIdTracker) {
            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "instanceId",
                            namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "instanceId");
                }

            } else {
                xmlWriter.writeStartElement("instanceId");
            }

            if (localInstanceId == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "instanceId cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localInstanceId);

            }

            xmlWriter.writeEndElement();
        }
        if (localUsersTracker) {
            if (localUsers != null) {
                for (int i = 0; i < localUsers.length; i++) {
                    if (localUsers[i] != null) {
                        localUsers[i].serialize(
                                new javax.xml.namespace.QName("", "users"),
                                factory, xmlWriter);
                    } else {

                        // we don't have to do any thing since minOccures is
                        // zero

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException(
                        "users cannot be null!!");

            }
        }
        if (localRequestingUserTracker) {
            if (localRequestingUser == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "requestingUser cannot be null!!");
            }
            localRequestingUser.serialize(
                    new javax.xml.namespace.QName("", "requestingUser"),
                    factory, xmlWriter);
        }
        xmlWriter.writeEndElement();

    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
            java.lang.String namespace, java.lang.String attName,
            java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);

        }

        xmlWriter.writeAttribute(namespace, attName, attValue);

    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
            java.lang.String attName, java.lang.String attValue,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
            java.lang.String attName, javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {

        java.lang.String attributeNamespace = qname.getNamespaceURI();
        java.lang.String attributePrefix = xmlWriter
                .getPrefix(attributeNamespace);
        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }
        java.lang.String attributeValue;
        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attributeValue);
        }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
        java.lang.String namespaceURI = qname.getNamespaceURI();
        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":"
                        + org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(
                        org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }

        } else {
            xmlWriter.writeCharacters(
                    org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {

        if (qnames != null) {
            // we have to store this data until last moment since it is not
            // possible to write any
            // namespace data after writing the charactor data
            java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }
                namespaceURI = qnames[i].getNamespaceURI();
                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);
                    if ((prefix == null) || (prefix.length() == 0)) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":")
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                } else {
                    stringToWrite
                            .append(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qnames[i]));
                }
            }
            xmlWriter.writeCharacters(stringToWrite.toString());
        }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            java.lang.String namespace)
            throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);

        if (prefix == null) {
            prefix = generatePrefix(namespace);

            while (xmlWriter.getNamespaceContext()
                    .getNamespaceURI(prefix) != null) {
                prefix = org.apache.axis2.databinding.utils.BeanUtil
                        .getUniquePrefix();
            }

            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }

        return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     *
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
            javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {

        java.util.ArrayList elementList = new java.util.ArrayList();
        java.util.ArrayList attribList = new java.util.ArrayList();

        if (localInstanceIdTracker) {
            elementList.add(new javax.xml.namespace.QName("", "instanceId"));

            if (localInstanceId != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localInstanceId));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "instanceId cannot be null!!");
            }
        }
        if (localUsersTracker) {
            if (localUsers != null) {
                for (int i = 0; i < localUsers.length; i++) {

                    if (localUsers[i] != null) {
                        elementList.add(
                                new javax.xml.namespace.QName("", "users"));
                        elementList.add(localUsers[i]);
                    } else {

                        // nothing to do

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException(
                        "users cannot be null!!");

            }

        }
        if (localRequestingUserTracker) {
            elementList
                    .add(new javax.xml.namespace.QName("", "requestingUser"));

            if (localRequestingUser == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "requestingUser cannot be null!!");
            }
            elementList.add(localRequestingUser);
        }

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                qName, elementList.toArray(), attribList.toArray());

    }

    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {

        /**
         * static method to create the object Precondition: If this object is an
         * element, the current or next start element starts this object and any
         * intervening reader events are ignorable If this object is not an
         * element, it is a complex type and the reader is at the event just
         * after the outer start element Postcondition: If this object is an
         * element, the reader is positioned at its end element If this object
         * is a complex type, the reader is positioned at the end element of its
         * outer element
         */
        public static DeleteUsers parse(javax.xml.stream.XMLStreamReader reader)
                throws java.lang.Exception {
            DeleteUsers object = new DeleteUsers();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.getAttributeValue(
                        "http://www.w3.org/2001/XMLSchema-instance",
                        "type") != null) {
                    java.lang.String fullTypeName = reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type");
                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;
                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0,
                                    fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;

                        java.lang.String type = fullTypeName
                                .substring(fullTypeName.indexOf(":") + 1);

                        if (!"deleteUsers".equals(type)) {
                            // find namespace for the prefix
                            java.lang.String nsUri = reader
                                    .getNamespaceContext()
                                    .getNamespaceURI(nsPrefix);
                            return (DeleteUsers) org.oscm.xsd.ExtensionMapper
                                    .getTypeObject(nsUri, type, reader);
                        }

                    }

                }

                // Note all attributes that were handled. Used to differ normal
                // attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                java.util.ArrayList list2 = new java.util.ArrayList();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("", "instanceId")
                                .equals(reader.getName())) {

                    java.lang.String content = reader.getElementText();

                    object.setInstanceId(
                            org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                    reader.next();

                } // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("", "users")
                                .equals(reader.getName())) {

                    // Process the array and step past its final element's end.
                    list2.add(org.oscm.xsd.User.Factory.parse(reader));

                    // loop until we find a start element that is not part of
                    // this array
                    boolean loopDone2 = false;
                    while (!loopDone2) {
                        // We should be at the end element, but make sure
                        while (!reader.isEndElement())
                            reader.next();
                        // Step out of this element
                        reader.next();
                        // Step to next element event.
                        while (!reader.isStartElement()
                                && !reader.isEndElement())
                            reader.next();
                        if (reader.isEndElement()) {
                            // two continuous end elements means we are exiting
                            // the xml structure
                            loopDone2 = true;
                        } else {
                            if (new javax.xml.namespace.QName("", "users")
                                    .equals(reader.getName())) {
                                list2.add(org.oscm.xsd.User.Factory
                                        .parse(reader));

                            } else {
                                loopDone2 = true;
                            }
                        }
                    }
                    // call the converter utility to convert and set the array

                    object.setUsers(
                            (org.oscm.xsd.User[]) org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToArray(org.oscm.xsd.User.class,
                                            list2));

                } // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()
                        && new javax.xml.namespace.QName("", "requestingUser")
                                .equals(reader.getName())) {

                    object.setRequestingUser(
                            org.oscm.xsd.User.Factory.parse(reader));

                    reader.next();

                } // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement())
                    // A start element we are not expecting indicates a trailing
                    // invalid property
                    throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getLocalName());

            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

    }// end of factory class

}
