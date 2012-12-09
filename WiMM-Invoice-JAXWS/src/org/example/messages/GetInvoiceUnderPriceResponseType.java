
package org.example.messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.example.businessschemas.MultiFullInvoiceEntityType;


/**
 * <p>Java class for GetInvoiceUnderPriceResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInvoiceUnderPriceResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invoices" type="{http://www.example.org/businessSchemas}MultiFullInvoiceEntityType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInvoiceUnderPriceResponseType", propOrder = {
    "invoices"
})
public class GetInvoiceUnderPriceResponseType {

    @XmlElement(required = true)
    protected MultiFullInvoiceEntityType invoices;

    /**
     * Gets the value of the invoices property.
     * 
     * @return
     *     possible object is
     *     {@link MultiFullInvoiceEntityType }
     *     
     */
    public MultiFullInvoiceEntityType getInvoices() {
        return invoices;
    }

    /**
     * Sets the value of the invoices property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiFullInvoiceEntityType }
     *     
     */
    public void setInvoices(MultiFullInvoiceEntityType value) {
        this.invoices = value;
    }

}
