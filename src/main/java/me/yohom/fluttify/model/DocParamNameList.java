
package me.yohom.fluttify.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for docParamNameList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docParamNameList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parametertype" type="{}docParamType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="parametername" type="{}docParamName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docParamNameList", propOrder = {
    "parametertype",
    "parametername"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class DocParamNameList {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<DocParamType> parametertype;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<DocParamName> parametername;

    /**
     * Gets the value of the parametertype property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametertype property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametertype().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocParamType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<DocParamType> getParametertype() {
        if (parametertype == null) {
            parametertype = new ArrayList<DocParamType>();
        }
        return this.parametertype;
    }

    /**
     * Gets the value of the parametername property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametername property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametername().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocParamName }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<DocParamName> getParametername() {
        if (parametername == null) {
            parametername = new ArrayList<DocParamName>();
        }
        return this.parametername;
    }

}
