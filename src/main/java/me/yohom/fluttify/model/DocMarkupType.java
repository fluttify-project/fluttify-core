
package me.yohom.fluttify.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for docMarkupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docMarkupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{}docCmdGroup" maxOccurs="unbounded" minOccurs="0"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docMarkupType", propOrder = {
    "content"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class DocMarkupType {

    @XmlElementRefs({
        @XmlElementRef(name = "language", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "preformatted", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "javadoccode", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "copydoc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "parblock", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "dotfile", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "programlisting", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "variablelist", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "parameterlist", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "title", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "orderedlist", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "table", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "blockquote", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "simplesect", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "indexentry", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "toclist", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "xrefsect", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "javadocliteral", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ulink", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "itemizedlist", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "heading", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "mscfile", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "diafile", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "verbatim", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "hruler", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Serializable> content;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link DocLanguageType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCopyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocParBlockType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}
     * {@link JAXBElement }{@code <}{@link ListingType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocVariableListType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocParamListType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocTitleType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocListType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocTableType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocBlockQuoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocSimpleSectType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocIndexEntryType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocTocListType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocXRefSectType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}
     * {@link JAXBElement }{@code <}{@link DocListType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocHeadingType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

}
