
package org.example.messages;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.messages package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddInvoiceResponse_QNAME = new QName("http://www.example.org/messages", "addInvoiceResponse");
    private final static QName _AddInvoiceRequest_QNAME = new QName("http://www.example.org/messages", "addInvoiceRequest");
    private final static QName _AddInvoiceFault_QNAME = new QName("http://www.example.org/messages", "addInvoiceFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.messages
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddInvoiceFaultType }
     * 
     */
    public AddInvoiceFaultType createAddInvoiceFaultType() {
        return new AddInvoiceFaultType();
    }

    /**
     * Create an instance of {@link AddInvoiceRequestType }
     * 
     */
    public AddInvoiceRequestType createAddInvoiceRequestType() {
        return new AddInvoiceRequestType();
    }

    /**
     * Create an instance of {@link AddInvoiceResponseType }
     * 
     */
    public AddInvoiceResponseType createAddInvoiceResponseType() {
        return new AddInvoiceResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddInvoiceResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "addInvoiceResponse")
    public JAXBElement<AddInvoiceResponseType> createAddInvoiceResponse(AddInvoiceResponseType value) {
        return new JAXBElement<AddInvoiceResponseType>(_AddInvoiceResponse_QNAME, AddInvoiceResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddInvoiceRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "addInvoiceRequest")
    public JAXBElement<AddInvoiceRequestType> createAddInvoiceRequest(AddInvoiceRequestType value) {
        return new JAXBElement<AddInvoiceRequestType>(_AddInvoiceRequest_QNAME, AddInvoiceRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddInvoiceFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "addInvoiceFault")
    public JAXBElement<AddInvoiceFaultType> createAddInvoiceFault(AddInvoiceFaultType value) {
        return new JAXBElement<AddInvoiceFaultType>(_AddInvoiceFault_QNAME, AddInvoiceFaultType.class, null, value);
    }

}
