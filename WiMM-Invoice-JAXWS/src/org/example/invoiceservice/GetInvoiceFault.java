
package org.example.invoiceservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2012-12-03T19:06:05.186+01:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "getInvoiceFault", targetNamespace = "http://www.example.org/messages")
public class GetInvoiceFault extends Exception {
    
    private org.example.messages.GetInvoiceFaultType getInvoiceFault;

    public GetInvoiceFault() {
        super();
    }
    
    public GetInvoiceFault(String message) {
        super(message);
    }
    
    public GetInvoiceFault(String message, Throwable cause) {
        super(message, cause);
    }

    public GetInvoiceFault(String message, org.example.messages.GetInvoiceFaultType getInvoiceFault) {
        super(message);
        this.getInvoiceFault = getInvoiceFault;
    }

    public GetInvoiceFault(String message, org.example.messages.GetInvoiceFaultType getInvoiceFault, Throwable cause) {
        super(message, cause);
        this.getInvoiceFault = getInvoiceFault;
    }

    public org.example.messages.GetInvoiceFaultType getFaultInfo() {
        return this.getInvoiceFault;
    }
}
