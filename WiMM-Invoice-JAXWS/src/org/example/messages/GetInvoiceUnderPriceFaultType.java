
package org.example.messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.example.businessschemas.InvoiceFaultType;


/**
 * <p>Java class for GetInvoiceUnderPriceFaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInvoiceUnderPriceFaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fault" type="{http://www.example.org/businessSchemas}InvoiceFaultType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInvoiceUnderPriceFaultType", propOrder = {
    "fault"
})
public class GetInvoiceUnderPriceFaultType {

    @XmlElement(required = true)
    protected InvoiceFaultType fault;

    /**
     * Gets the value of the fault property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceFaultType }
     *     
     */
    public InvoiceFaultType getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceFaultType }
     *     
     */
    public void setFault(InvoiceFaultType value) {
        this.fault = value;
    }

}
