package org.example.invoiceservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2012-12-02T17:08:41.906+01:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://www.example.org/InvoiceService/", name = "InvoiceService")
@XmlSeeAlso({org.example.messages.ObjectFactory.class, org.example.businessschemas.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface InvoiceService {

    @WebResult(name = "addInvoiceResponse", targetNamespace = "http://www.example.org/messages", partName = "addInvoiceOutput")
    @WebMethod(action = "http://www.example.org/InvoiceService/addInvoice")
    public org.example.messages.AddInvoiceResponseType addInvoice(
        @WebParam(partName = "addInvoiceInput", name = "addInvoiceRequest", targetNamespace = "http://www.example.org/messages")
        org.example.messages.AddInvoiceRequestType addInvoiceInput
    ) throws AddInvoiceFault;
}
