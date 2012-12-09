
package org.example.businessschemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InvoiceEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceEntityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shopname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shopvat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="itembarcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="itemprice" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="itemquantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceEntityType", propOrder = {
    "shopname",
    "shopvat",
    "itembarcode",
    "itemprice",
    "itemquantity",
    "date"
})
@XmlSeeAlso({
    FullInvoiceEntityType.class
})
public class InvoiceEntityType {

    @XmlElement(required = true)
    protected String shopname;
    @XmlElement(required = true)
    protected String shopvat;
    @XmlElement(required = true)
    protected String itembarcode;
    protected float itemprice;
    protected int itemquantity;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;

    /**
     * Gets the value of the shopname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopname() {
        return shopname;
    }

    /**
     * Sets the value of the shopname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopname(String value) {
        this.shopname = value;
    }

    /**
     * Gets the value of the shopvat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopvat() {
        return shopvat;
    }

    /**
     * Sets the value of the shopvat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopvat(String value) {
        this.shopvat = value;
    }

    /**
     * Gets the value of the itembarcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItembarcode() {
        return itembarcode;
    }

    /**
     * Sets the value of the itembarcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItembarcode(String value) {
        this.itembarcode = value;
    }

    /**
     * Gets the value of the itemprice property.
     * 
     */
    public float getItemprice() {
        return itemprice;
    }

    /**
     * Sets the value of the itemprice property.
     * 
     */
    public void setItemprice(float value) {
        this.itemprice = value;
    }

    /**
     * Gets the value of the itemquantity property.
     * 
     */
    public int getItemquantity() {
        return itemquantity;
    }

    /**
     * Sets the value of the itemquantity property.
     * 
     */
    public void setItemquantity(int value) {
        this.itemquantity = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}
