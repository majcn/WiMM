
package org.example.invoiceservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2012-12-09T15:36:12.656+01:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "addInvoiceFault", targetNamespace = "http://www.example.org/messages")
public class AddInvoiceFault extends Exception {
    
    private org.example.messages.AddInvoiceFaultType addInvoiceFault;

    public AddInvoiceFault() {
        super();
    }
    
    public AddInvoiceFault(String message) {
        super(message);
    }
    
    public AddInvoiceFault(String message, Throwable cause) {
        super(message, cause);
    }

    public AddInvoiceFault(String message, org.example.messages.AddInvoiceFaultType addInvoiceFault) {
        super(message);
        this.addInvoiceFault = addInvoiceFault;
    }

    public AddInvoiceFault(String message, org.example.messages.AddInvoiceFaultType addInvoiceFault, Throwable cause) {
        super(message, cause);
        this.addInvoiceFault = addInvoiceFault;
    }

    public org.example.messages.AddInvoiceFaultType getFaultInfo() {
        return this.addInvoiceFault;
    }
}
