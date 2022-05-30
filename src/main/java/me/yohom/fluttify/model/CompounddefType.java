
package me.yohom.fluttify.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for compounddefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="compounddefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="compoundname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basecompoundref" type="{}compoundRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="derivedcompoundref" type="{}compoundRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="includes" type="{}incType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="includedby" type="{}incType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="incdepgraph" type="{}graphType" minOccurs="0"/>
 *         &lt;element name="invincdepgraph" type="{}graphType" minOccurs="0"/>
 *         &lt;element name="innerdir" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innerfile" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innerclass" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innernamespace" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innerpage" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innergroup" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="templateparamlist" type="{}templateparamlistType" minOccurs="0"/>
 *         &lt;element name="sectiondef" type="{}sectiondefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tableofcontents" type="{}tableofcontentsType" minOccurs="0"/>
 *         &lt;element name="requiresclause" type="{}linkedTextType" minOccurs="0"/>
 *         &lt;element name="initializer" type="{}linkedTextType" minOccurs="0"/>
 *         &lt;element name="briefdescription" type="{}descriptionType" minOccurs="0"/>
 *         &lt;element name="detaileddescription" type="{}descriptionType" minOccurs="0"/>
 *         &lt;element name="inheritancegraph" type="{}graphType" minOccurs="0"/>
 *         &lt;element name="collaborationgraph" type="{}graphType" minOccurs="0"/>
 *         &lt;element name="programlisting" type="{}listingType" minOccurs="0"/>
 *         &lt;element name="location" type="{}locationType" minOccurs="0"/>
 *         &lt;element name="listofallmembers" type="{}listofallmembersType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="kind" type="{}DoxCompoundKind" />
 *       &lt;attribute name="language" type="{}DoxLanguage" />
 *       &lt;attribute name="prot" type="{}DoxProtectionKind" />
 *       &lt;attribute name="final" type="{}DoxBool" />
 *       &lt;attribute name="inline" type="{}DoxBool" />
 *       &lt;attribute name="sealed" type="{}DoxBool" />
 *       &lt;attribute name="abstract" type="{}DoxBool" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compounddefType", propOrder = {
    "compoundname",
    "title",
    "basecompoundref",
    "derivedcompoundref",
    "includes",
    "includedby",
    "incdepgraph",
    "invincdepgraph",
    "innerdir",
    "innerfile",
    "innerclass",
    "innernamespace",
    "innerpage",
    "innergroup",
    "templateparamlist",
    "sectiondef",
    "tableofcontents",
    "requiresclause",
    "initializer",
    "briefdescription",
    "detaileddescription",
    "inheritancegraph",
    "collaborationgraph",
    "programlisting",
    "location",
    "listofallmembers"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class CompounddefType {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String compoundname;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String title;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<CompoundRefType> basecompoundref;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<CompoundRefType> derivedcompoundref;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<IncType> includes;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<IncType> includedby;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected GraphType incdepgraph;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected GraphType invincdepgraph;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<RefType> innerdir;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<RefType> innerfile;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<RefType> innerclass;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<RefType> innernamespace;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<RefType> innerpage;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<RefType> innergroup;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected TemplateparamlistType templateparamlist;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<SectiondefType> sectiondef;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected TableofcontentsType tableofcontents;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected LinkedTextType requiresclause;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected LinkedTextType initializer;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DescriptionType briefdescription;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DescriptionType detaileddescription;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected GraphType inheritancegraph;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected GraphType collaborationgraph;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected ListingType programlisting;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected LocationType location;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected ListofallmembersType listofallmembers;
    @XmlAttribute(name = "id")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String id;
    @XmlAttribute(name = "kind")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxCompoundKind kind;
    @XmlAttribute(name = "language")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String language;
    @XmlAttribute(name = "prot")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxProtectionKind prot;
    @XmlAttribute(name = "final")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool _final;
    @XmlAttribute(name = "inline")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool inline;
    @XmlAttribute(name = "sealed")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool sealed;
    @XmlAttribute(name = "abstract")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool _abstract;

    /**
     * Gets the value of the compoundname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getCompoundname() {
        return compoundname;
    }

    /**
     * Sets the value of the compoundname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setCompoundname(String value) {
        this.compoundname = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the basecompoundref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the basecompoundref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBasecompoundref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompoundRefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<CompoundRefType> getBasecompoundref() {
        if (basecompoundref == null) {
            basecompoundref = new ArrayList<CompoundRefType>();
        }
        return this.basecompoundref;
    }

    /**
     * Gets the value of the derivedcompoundref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derivedcompoundref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerivedcompoundref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompoundRefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<CompoundRefType> getDerivedcompoundref() {
        if (derivedcompoundref == null) {
            derivedcompoundref = new ArrayList<CompoundRefType>();
        }
        return this.derivedcompoundref;
    }

    /**
     * Gets the value of the includes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<IncType> getIncludes() {
        if (includes == null) {
            includes = new ArrayList<IncType>();
        }
        return this.includes;
    }

    /**
     * Gets the value of the includedby property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedby property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedby().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<IncType> getIncludedby() {
        if (includedby == null) {
            includedby = new ArrayList<IncType>();
        }
        return this.includedby;
    }

    /**
     * Gets the value of the incdepgraph property.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public GraphType getIncdepgraph() {
        return incdepgraph;
    }

    /**
     * Sets the value of the incdepgraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setIncdepgraph(GraphType value) {
        this.incdepgraph = value;
    }

    /**
     * Gets the value of the invincdepgraph property.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public GraphType getInvincdepgraph() {
        return invincdepgraph;
    }

    /**
     * Sets the value of the invincdepgraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInvincdepgraph(GraphType value) {
        this.invincdepgraph = value;
    }

    /**
     * Gets the value of the innerdir property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerdir property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerdir().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<RefType> getInnerdir() {
        if (innerdir == null) {
            innerdir = new ArrayList<RefType>();
        }
        return this.innerdir;
    }

    /**
     * Gets the value of the innerfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<RefType> getInnerfile() {
        if (innerfile == null) {
            innerfile = new ArrayList<RefType>();
        }
        return this.innerfile;
    }

    /**
     * Gets the value of the innerclass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerclass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerclass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<RefType> getInnerclass() {
        if (innerclass == null) {
            innerclass = new ArrayList<RefType>();
        }
        return this.innerclass;
    }

    /**
     * Gets the value of the innernamespace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innernamespace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnernamespace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<RefType> getInnernamespace() {
        if (innernamespace == null) {
            innernamespace = new ArrayList<RefType>();
        }
        return this.innernamespace;
    }

    /**
     * Gets the value of the innerpage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerpage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerpage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<RefType> getInnerpage() {
        if (innerpage == null) {
            innerpage = new ArrayList<RefType>();
        }
        return this.innerpage;
    }

    /**
     * Gets the value of the innergroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innergroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnergroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<RefType> getInnergroup() {
        if (innergroup == null) {
            innergroup = new ArrayList<RefType>();
        }
        return this.innergroup;
    }

    /**
     * Gets the value of the templateparamlist property.
     * 
     * @return
     *     possible object is
     *     {@link TemplateparamlistType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public TemplateparamlistType getTemplateparamlist() {
        return templateparamlist;
    }

    /**
     * Sets the value of the templateparamlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateparamlistType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTemplateparamlist(TemplateparamlistType value) {
        this.templateparamlist = value;
    }

    /**
     * Gets the value of the sectiondef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sectiondef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSectiondef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SectiondefType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<SectiondefType> getSectiondef() {
        if (sectiondef == null) {
            sectiondef = new ArrayList<SectiondefType>();
        }
        return this.sectiondef;
    }

    /**
     * Gets the value of the tableofcontents property.
     * 
     * @return
     *     possible object is
     *     {@link TableofcontentsType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public TableofcontentsType getTableofcontents() {
        return tableofcontents;
    }

    /**
     * Sets the value of the tableofcontents property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableofcontentsType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTableofcontents(TableofcontentsType value) {
        this.tableofcontents = value;
    }

    /**
     * Gets the value of the requiresclause property.
     * 
     * @return
     *     possible object is
     *     {@link LinkedTextType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public LinkedTextType getRequiresclause() {
        return requiresclause;
    }

    /**
     * Sets the value of the requiresclause property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkedTextType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setRequiresclause(LinkedTextType value) {
        this.requiresclause = value;
    }

    /**
     * Gets the value of the initializer property.
     * 
     * @return
     *     possible object is
     *     {@link LinkedTextType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public LinkedTextType getInitializer() {
        return initializer;
    }

    /**
     * Sets the value of the initializer property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkedTextType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInitializer(LinkedTextType value) {
        this.initializer = value;
    }

    /**
     * Gets the value of the briefdescription property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DescriptionType getBriefdescription() {
        return briefdescription;
    }

    /**
     * Sets the value of the briefdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setBriefdescription(DescriptionType value) {
        this.briefdescription = value;
    }

    /**
     * Gets the value of the detaileddescription property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DescriptionType getDetaileddescription() {
        return detaileddescription;
    }

    /**
     * Sets the value of the detaileddescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDetaileddescription(DescriptionType value) {
        this.detaileddescription = value;
    }

    /**
     * Gets the value of the inheritancegraph property.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public GraphType getInheritancegraph() {
        return inheritancegraph;
    }

    /**
     * Sets the value of the inheritancegraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInheritancegraph(GraphType value) {
        this.inheritancegraph = value;
    }

    /**
     * Gets the value of the collaborationgraph property.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public GraphType getCollaborationgraph() {
        return collaborationgraph;
    }

    /**
     * Sets the value of the collaborationgraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setCollaborationgraph(GraphType value) {
        this.collaborationgraph = value;
    }

    /**
     * Gets the value of the programlisting property.
     * 
     * @return
     *     possible object is
     *     {@link ListingType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public ListingType getProgramlisting() {
        return programlisting;
    }

    /**
     * Sets the value of the programlisting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListingType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setProgramlisting(ListingType value) {
        this.programlisting = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public LocationType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLocation(LocationType value) {
        this.location = value;
    }

    /**
     * Gets the value of the listofallmembers property.
     * 
     * @return
     *     possible object is
     *     {@link ListofallmembersType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public ListofallmembersType getListofallmembers() {
        return listofallmembers;
    }

    /**
     * Sets the value of the listofallmembers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListofallmembersType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setListofallmembers(ListofallmembersType value) {
        this.listofallmembers = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link DoxCompoundKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxCompoundKind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxCompoundKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setKind(DoxCompoundKind value) {
        this.kind = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the prot property.
     * 
     * @return
     *     possible object is
     *     {@link DoxProtectionKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxProtectionKind getProt() {
        return prot;
    }

    /**
     * Sets the value of the prot property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxProtectionKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setProt(DoxProtectionKind value) {
        this.prot = value;
    }

    /**
     * Gets the value of the final property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getFinal() {
        return _final;
    }

    /**
     * Sets the value of the final property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setFinal(DoxBool value) {
        this._final = value;
    }

    /**
     * Gets the value of the inline property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getInline() {
        return inline;
    }

    /**
     * Sets the value of the inline property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInline(DoxBool value) {
        this.inline = value;
    }

    /**
     * Gets the value of the sealed property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getSealed() {
        return sealed;
    }

    /**
     * Sets the value of the sealed property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSealed(DoxBool value) {
        this.sealed = value;
    }

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAbstract(DoxBool value) {
        this._abstract = value;
    }

}
