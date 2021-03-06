
package org.example.businessschemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultiFullInvoiceEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultiFullInvoiceEntityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invoices" type="{http://www.example.org/businessSchemas}FullInvoiceEntityType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiFullInvoiceEntityType", propOrder = {
    "invoices"
})
public class MultiFullInvoiceEntityType {

    @XmlElement(required = true)
    protected List<FullInvoiceEntityType> invoices;

    /**
     * Gets the value of the invoices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FullInvoiceEntityType }
     * 
     * 
     */
    public List<FullInvoiceEntityType> getInvoices() {
        if (invoices == null) {
            invoices = new ArrayList<FullInvoiceEntityType>();
        }
        return this.invoices;
    }

}
