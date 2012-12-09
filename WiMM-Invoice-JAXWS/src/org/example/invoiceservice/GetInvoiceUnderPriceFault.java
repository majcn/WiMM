
package org.example.invoiceservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2012-12-09T15:36:12.609+01:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "getInvoiceUnderPriceFault", targetNamespace = "http://www.example.org/messages")
public class GetInvoiceUnderPriceFault extends Exception {
    
    private org.example.messages.GetInvoiceUnderPriceFaultType getInvoiceUnderPriceFault;

    public GetInvoiceUnderPriceFault() {
        super();
    }
    
    public GetInvoiceUnderPriceFault(String message) {
        super(message);
    }
    
    public GetInvoiceUnderPriceFault(String message, Throwable cause) {
        super(message, cause);
    }

    public GetInvoiceUnderPriceFault(String message, org.example.messages.GetInvoiceUnderPriceFaultType getInvoiceUnderPriceFault) {
        super(message);
        this.getInvoiceUnderPriceFault = getInvoiceUnderPriceFault;
    }

    public GetInvoiceUnderPriceFault(String message, org.example.messages.GetInvoiceUnderPriceFaultType getInvoiceUnderPriceFault, Throwable cause) {
        super(message, cause);
        this.getInvoiceUnderPriceFault = getInvoiceUnderPriceFault;
    }

    public org.example.messages.GetInvoiceUnderPriceFaultType getFaultInfo() {
        return this.getInvoiceUnderPriceFault;
    }
}
