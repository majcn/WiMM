
package org.example.invoiceservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2012-12-09T15:36:12.671+01:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "deleteInvoiceFault", targetNamespace = "http://www.example.org/messages")
public class DeleteInvoiceFault extends Exception {
    
    private org.example.messages.DeleteInvoiceFaultType deleteInvoiceFault;

    public DeleteInvoiceFault() {
        super();
    }
    
    public DeleteInvoiceFault(String message) {
        super(message);
    }
    
    public DeleteInvoiceFault(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteInvoiceFault(String message, org.example.messages.DeleteInvoiceFaultType deleteInvoiceFault) {
        super(message);
        this.deleteInvoiceFault = deleteInvoiceFault;
    }

    public DeleteInvoiceFault(String message, org.example.messages.DeleteInvoiceFaultType deleteInvoiceFault, Throwable cause) {
        super(message, cause);
        this.deleteInvoiceFault = deleteInvoiceFault;
    }

    public org.example.messages.DeleteInvoiceFaultType getFaultInfo() {
        return this.deleteInvoiceFault;
    }
}
