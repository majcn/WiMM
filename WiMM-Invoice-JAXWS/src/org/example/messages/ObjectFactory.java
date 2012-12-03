
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

    private final static QName _GetInvoiceResponse_QNAME = new QName("http://www.example.org/messages", "getInvoiceResponse");
    private final static QName _DeleteInvoiceFault_QNAME = new QName("http://www.example.org/messages", "deleteInvoiceFault");
    private final static QName _DeleteInvoiceResponse_QNAME = new QName("http://www.example.org/messages", "deleteInvoiceResponse");
    private final static QName _AddInvoiceResponse_QNAME = new QName("http://www.example.org/messages", "addInvoiceResponse");
    private final static QName _GetInvoiceFault_QNAME = new QName("http://www.example.org/messages", "getInvoiceFault");
    private final static QName _AddInvoiceRequest_QNAME = new QName("http://www.example.org/messages", "addInvoiceRequest");
    private final static QName _AddInvoiceFault_QNAME = new QName("http://www.example.org/messages", "addInvoiceFault");
    private final static QName _DeleteInvoiceRequest_QNAME = new QName("http://www.example.org/messages", "deleteInvoiceRequest");
    private final static QName _GetInvoiceRequest_QNAME = new QName("http://www.example.org/messages", "getInvoiceRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.messages
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteInvoiceRequestType }
     * 
     */
    public DeleteInvoiceRequestType createDeleteInvoiceRequestType() {
        return new DeleteInvoiceRequestType();
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
     * Create an instance of {@link GetInvoiceRequestType }
     * 
     */
    public GetInvoiceRequestType createGetInvoiceRequestType() {
        return new GetInvoiceRequestType();
    }

    /**
     * Create an instance of {@link GetInvoiceFaultType }
     * 
     */
    public GetInvoiceFaultType createGetInvoiceFaultType() {
        return new GetInvoiceFaultType();
    }

    /**
     * Create an instance of {@link AddInvoiceResponseType }
     * 
     */
    public AddInvoiceResponseType createAddInvoiceResponseType() {
        return new AddInvoiceResponseType();
    }

    /**
     * Create an instance of {@link DeleteInvoiceResponseType }
     * 
     */
    public DeleteInvoiceResponseType createDeleteInvoiceResponseType() {
        return new DeleteInvoiceResponseType();
    }

    /**
     * Create an instance of {@link GetInvoiceResponseType }
     * 
     */
    public GetInvoiceResponseType createGetInvoiceResponseType() {
        return new GetInvoiceResponseType();
    }

    /**
     * Create an instance of {@link DeleteInvoiceFaultType }
     * 
     */
    public DeleteInvoiceFaultType createDeleteInvoiceFaultType() {
        return new DeleteInvoiceFaultType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInvoiceResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "getInvoiceResponse")
    public JAXBElement<GetInvoiceResponseType> createGetInvoiceResponse(GetInvoiceResponseType value) {
        return new JAXBElement<GetInvoiceResponseType>(_GetInvoiceResponse_QNAME, GetInvoiceResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteInvoiceFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "deleteInvoiceFault")
    public JAXBElement<DeleteInvoiceFaultType> createDeleteInvoiceFault(DeleteInvoiceFaultType value) {
        return new JAXBElement<DeleteInvoiceFaultType>(_DeleteInvoiceFault_QNAME, DeleteInvoiceFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteInvoiceResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "deleteInvoiceResponse")
    public JAXBElement<DeleteInvoiceResponseType> createDeleteInvoiceResponse(DeleteInvoiceResponseType value) {
        return new JAXBElement<DeleteInvoiceResponseType>(_DeleteInvoiceResponse_QNAME, DeleteInvoiceResponseType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInvoiceFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "getInvoiceFault")
    public JAXBElement<GetInvoiceFaultType> createGetInvoiceFault(GetInvoiceFaultType value) {
        return new JAXBElement<GetInvoiceFaultType>(_GetInvoiceFault_QNAME, GetInvoiceFaultType.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteInvoiceRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "deleteInvoiceRequest")
    public JAXBElement<DeleteInvoiceRequestType> createDeleteInvoiceRequest(DeleteInvoiceRequestType value) {
        return new JAXBElement<DeleteInvoiceRequestType>(_DeleteInvoiceRequest_QNAME, DeleteInvoiceRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInvoiceRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/messages", name = "getInvoiceRequest")
    public JAXBElement<GetInvoiceRequestType> createGetInvoiceRequest(GetInvoiceRequestType value) {
        return new JAXBElement<GetInvoiceRequestType>(_GetInvoiceRequest_QNAME, GetInvoiceRequestType.class, null, value);
    }

}
