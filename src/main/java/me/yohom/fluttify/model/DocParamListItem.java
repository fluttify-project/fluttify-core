
package me.yohom.fluttify.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for docParamListItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docParamListItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parameternamelist" type="{}docParamNameList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="parameterdescription" type="{}descriptionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docParamListItem", propOrder = {
    "parameternamelist",
    "parameterdescription"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class DocParamListItem {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<DocParamNameList> parameternamelist;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DescriptionType parameterdescription;

    /**
     * Gets the value of the parameternamelist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameternamelist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameternamelist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocParamNameList }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<DocParamNameList> getParameternamelist() {
        if (parameternamelist == null) {
            parameternamelist = new ArrayList<DocParamNameList>();
        }
        return this.parameternamelist;
    }

    /**
     * Gets the value of the parameterdescription property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DescriptionType getParameterdescription() {
        return parameterdescription;
    }

    /**
     * Sets the value of the parameterdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setParameterdescription(DescriptionType value) {
        this.parameterdescription = value;
    }

}
