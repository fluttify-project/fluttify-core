
package me.yohom.fluttify.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for memberdefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="memberdefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="templateparamlist" type="{}templateparamlistType" minOccurs="0"/>
 *         &lt;element name="type" type="{}linkedTextType" minOccurs="0"/>
 *         &lt;element name="definition" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="argsstring" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="qualifiedname" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="read" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="write" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="bitfield" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="reimplements" type="{}reimplementType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reimplementedby" type="{}reimplementType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="param" type="{}paramType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="enumvalue" type="{}enumvalueType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requiresclause" type="{}linkedTextType" minOccurs="0"/>
 *         &lt;element name="initializer" type="{}linkedTextType" minOccurs="0"/>
 *         &lt;element name="exceptions" type="{}linkedTextType" minOccurs="0"/>
 *         &lt;element name="briefdescription" type="{}descriptionType" minOccurs="0"/>
 *         &lt;element name="detaileddescription" type="{}descriptionType" minOccurs="0"/>
 *         &lt;element name="inbodydescription" type="{}descriptionType" minOccurs="0"/>
 *         &lt;element name="location" type="{}locationType"/>
 *         &lt;element name="references" type="{}referenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="referencedby" type="{}referenceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="kind" type="{}DoxMemberKind" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prot" type="{}DoxProtectionKind" />
 *       &lt;attribute name="static" type="{}DoxBool" />
 *       &lt;attribute name="strong" type="{}DoxBool" />
 *       &lt;attribute name="const" type="{}DoxBool" />
 *       &lt;attribute name="explicit" type="{}DoxBool" />
 *       &lt;attribute name="inline" type="{}DoxBool" />
 *       &lt;attribute name="refqual" type="{}DoxRefQualifierKind" />
 *       &lt;attribute name="virt" type="{}DoxVirtualKind" />
 *       &lt;attribute name="volatile" type="{}DoxBool" />
 *       &lt;attribute name="mutable" type="{}DoxBool" />
 *       &lt;attribute name="noexcept" type="{}DoxBool" />
 *       &lt;attribute name="constexpr" type="{}DoxBool" />
 *       &lt;attribute name="readable" type="{}DoxBool" />
 *       &lt;attribute name="writable" type="{}DoxBool" />
 *       &lt;attribute name="initonly" type="{}DoxBool" />
 *       &lt;attribute name="settable" type="{}DoxBool" />
 *       &lt;attribute name="privatesettable" type="{}DoxBool" />
 *       &lt;attribute name="protectedsettable" type="{}DoxBool" />
 *       &lt;attribute name="gettable" type="{}DoxBool" />
 *       &lt;attribute name="privategettable" type="{}DoxBool" />
 *       &lt;attribute name="protectedgettable" type="{}DoxBool" />
 *       &lt;attribute name="final" type="{}DoxBool" />
 *       &lt;attribute name="sealed" type="{}DoxBool" />
 *       &lt;attribute name="new" type="{}DoxBool" />
 *       &lt;attribute name="add" type="{}DoxBool" />
 *       &lt;attribute name="remove" type="{}DoxBool" />
 *       &lt;attribute name="raise" type="{}DoxBool" />
 *       &lt;attribute name="optional" type="{}DoxBool" />
 *       &lt;attribute name="required" type="{}DoxBool" />
 *       &lt;attribute name="accessor" type="{}DoxAccessor" />
 *       &lt;attribute name="attribute" type="{}DoxBool" />
 *       &lt;attribute name="property" type="{}DoxBool" />
 *       &lt;attribute name="readonly" type="{}DoxBool" />
 *       &lt;attribute name="bound" type="{}DoxBool" />
 *       &lt;attribute name="removable" type="{}DoxBool" />
 *       &lt;attribute name="constrained" type="{}DoxBool" />
 *       &lt;attribute name="transient" type="{}DoxBool" />
 *       &lt;attribute name="maybevoid" type="{}DoxBool" />
 *       &lt;attribute name="maybedefault" type="{}DoxBool" />
 *       &lt;attribute name="maybeambiguous" type="{}DoxBool" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "memberdefType", propOrder = {
    "templateparamlist",
    "type",
    "definition",
    "argsstring",
    "name",
    "qualifiedname",
    "read",
    "write",
    "bitfield",
    "reimplements",
    "reimplementedby",
    "param",
    "enumvalue",
    "requiresclause",
    "initializer",
    "exceptions",
    "briefdescription",
    "detaileddescription",
    "inbodydescription",
    "location",
    "references",
    "referencedby"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class MemberdefType {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected TemplateparamlistType templateparamlist;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected LinkedTextType type;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Object definition;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Object argsstring;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Object name;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Object qualifiedname;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Object read;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Object write;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Object bitfield;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<ReimplementType> reimplements;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<ReimplementType> reimplementedby;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<ParamType> param;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<EnumvalueType> enumvalue;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected LinkedTextType requiresclause;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected LinkedTextType initializer;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected LinkedTextType exceptions;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DescriptionType briefdescription;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DescriptionType detaileddescription;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DescriptionType inbodydescription;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected LocationType location;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<ReferenceType> references;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<ReferenceType> referencedby;
    @XmlAttribute(name = "kind")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxMemberKind kind;
    @XmlAttribute(name = "id")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String id;
    @XmlAttribute(name = "prot")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxProtectionKind prot;
    @XmlAttribute(name = "static")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool _static;
    @XmlAttribute(name = "strong")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool strong;
    @XmlAttribute(name = "const")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool _const;
    @XmlAttribute(name = "explicit")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool explicit;
    @XmlAttribute(name = "inline")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool inline;
    @XmlAttribute(name = "refqual")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxRefQualifierKind refqual;
    @XmlAttribute(name = "virt")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxVirtualKind virt;
    @XmlAttribute(name = "volatile")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool _volatile;
    @XmlAttribute(name = "mutable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool mutable;
    @XmlAttribute(name = "noexcept")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool noexcept;
    @XmlAttribute(name = "constexpr")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool constexpr;
    @XmlAttribute(name = "readable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool readable;
    @XmlAttribute(name = "writable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool writable;
    @XmlAttribute(name = "initonly")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool initonly;
    @XmlAttribute(name = "settable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool settable;
    @XmlAttribute(name = "privatesettable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool privatesettable;
    @XmlAttribute(name = "protectedsettable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool protectedsettable;
    @XmlAttribute(name = "gettable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool gettable;
    @XmlAttribute(name = "privategettable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool privategettable;
    @XmlAttribute(name = "protectedgettable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool protectedgettable;
    @XmlAttribute(name = "final")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool _final;
    @XmlAttribute(name = "sealed")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool sealed;
    @XmlAttribute(name = "new")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool _new;
    @XmlAttribute(name = "add")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool add;
    @XmlAttribute(name = "remove")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool remove;
    @XmlAttribute(name = "raise")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool raise;
    @XmlAttribute(name = "optional")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool optional;
    @XmlAttribute(name = "required")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool required;
    @XmlAttribute(name = "accessor")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxAccessor accessor;
    @XmlAttribute(name = "attribute")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool attribute;
    @XmlAttribute(name = "property")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool property;
    @XmlAttribute(name = "readonly")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool readonly;
    @XmlAttribute(name = "bound")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool bound;
    @XmlAttribute(name = "removable")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool removable;
    @XmlAttribute(name = "constrained")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool constrained;
    @XmlAttribute(name = "transient")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool _transient;
    @XmlAttribute(name = "maybevoid")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool maybevoid;
    @XmlAttribute(name = "maybedefault")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool maybedefault;
    @XmlAttribute(name = "maybeambiguous")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected DoxBool maybeambiguous;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link LinkedTextType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public LinkedTextType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkedTextType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setType(LinkedTextType value) {
        this.type = value;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Object getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDefinition(Object value) {
        this.definition = value;
    }

    /**
     * Gets the value of the argsstring property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Object getArgsstring() {
        return argsstring;
    }

    /**
     * Sets the value of the argsstring property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setArgsstring(Object value) {
        this.argsstring = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Object getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Gets the value of the qualifiedname property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Object getQualifiedname() {
        return qualifiedname;
    }

    /**
     * Sets the value of the qualifiedname property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setQualifiedname(Object value) {
        this.qualifiedname = value;
    }

    /**
     * Gets the value of the read property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Object getRead() {
        return read;
    }

    /**
     * Sets the value of the read property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setRead(Object value) {
        this.read = value;
    }

    /**
     * Gets the value of the write property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Object getWrite() {
        return write;
    }

    /**
     * Sets the value of the write property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setWrite(Object value) {
        this.write = value;
    }

    /**
     * Gets the value of the bitfield property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Object getBitfield() {
        return bitfield;
    }

    /**
     * Sets the value of the bitfield property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setBitfield(Object value) {
        this.bitfield = value;
    }

    /**
     * Gets the value of the reimplements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reimplements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReimplements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReimplementType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<ReimplementType> getReimplements() {
        if (reimplements == null) {
            reimplements = new ArrayList<ReimplementType>();
        }
        return this.reimplements;
    }

    /**
     * Gets the value of the reimplementedby property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reimplementedby property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReimplementedby().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReimplementType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<ReimplementType> getReimplementedby() {
        if (reimplementedby == null) {
            reimplementedby = new ArrayList<ReimplementType>();
        }
        return this.reimplementedby;
    }

    /**
     * Gets the value of the param property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the param property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParamType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<ParamType> getParam() {
        if (param == null) {
            param = new ArrayList<ParamType>();
        }
        return this.param;
    }

    /**
     * Gets the value of the enumvalue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enumvalue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnumvalue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnumvalueType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<EnumvalueType> getEnumvalue() {
        if (enumvalue == null) {
            enumvalue = new ArrayList<EnumvalueType>();
        }
        return this.enumvalue;
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
     * Gets the value of the exceptions property.
     * 
     * @return
     *     possible object is
     *     {@link LinkedTextType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public LinkedTextType getExceptions() {
        return exceptions;
    }

    /**
     * Sets the value of the exceptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkedTextType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setExceptions(LinkedTextType value) {
        this.exceptions = value;
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
     * Gets the value of the inbodydescription property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DescriptionType getInbodydescription() {
        return inbodydescription;
    }

    /**
     * Sets the value of the inbodydescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInbodydescription(DescriptionType value) {
        this.inbodydescription = value;
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
     * Gets the value of the references property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the references property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<ReferenceType> getReferences() {
        if (references == null) {
            references = new ArrayList<ReferenceType>();
        }
        return this.references;
    }

    /**
     * Gets the value of the referencedby property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referencedby property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferencedby().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<ReferenceType> getReferencedby() {
        if (referencedby == null) {
            referencedby = new ArrayList<ReferenceType>();
        }
        return this.referencedby;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link DoxMemberKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxMemberKind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxMemberKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setKind(DoxMemberKind value) {
        this.kind = value;
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
     * Gets the value of the static property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getStatic() {
        return _static;
    }

    /**
     * Sets the value of the static property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setStatic(DoxBool value) {
        this._static = value;
    }

    /**
     * Gets the value of the strong property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getStrong() {
        return strong;
    }

    /**
     * Sets the value of the strong property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setStrong(DoxBool value) {
        this.strong = value;
    }

    /**
     * Gets the value of the const property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getConst() {
        return _const;
    }

    /**
     * Sets the value of the const property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setConst(DoxBool value) {
        this._const = value;
    }

    /**
     * Gets the value of the explicit property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getExplicit() {
        return explicit;
    }

    /**
     * Sets the value of the explicit property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setExplicit(DoxBool value) {
        this.explicit = value;
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
     * Gets the value of the refqual property.
     * 
     * @return
     *     possible object is
     *     {@link DoxRefQualifierKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxRefQualifierKind getRefqual() {
        return refqual;
    }

    /**
     * Sets the value of the refqual property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxRefQualifierKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setRefqual(DoxRefQualifierKind value) {
        this.refqual = value;
    }

    /**
     * Gets the value of the virt property.
     * 
     * @return
     *     possible object is
     *     {@link DoxVirtualKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxVirtualKind getVirt() {
        return virt;
    }

    /**
     * Sets the value of the virt property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxVirtualKind }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setVirt(DoxVirtualKind value) {
        this.virt = value;
    }

    /**
     * Gets the value of the volatile property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getVolatile() {
        return _volatile;
    }

    /**
     * Sets the value of the volatile property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setVolatile(DoxBool value) {
        this._volatile = value;
    }

    /**
     * Gets the value of the mutable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getMutable() {
        return mutable;
    }

    /**
     * Sets the value of the mutable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setMutable(DoxBool value) {
        this.mutable = value;
    }

    /**
     * Gets the value of the noexcept property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getNoexcept() {
        return noexcept;
    }

    /**
     * Sets the value of the noexcept property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setNoexcept(DoxBool value) {
        this.noexcept = value;
    }

    /**
     * Gets the value of the constexpr property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getConstexpr() {
        return constexpr;
    }

    /**
     * Sets the value of the constexpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setConstexpr(DoxBool value) {
        this.constexpr = value;
    }

    /**
     * Gets the value of the readable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getReadable() {
        return readable;
    }

    /**
     * Sets the value of the readable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setReadable(DoxBool value) {
        this.readable = value;
    }

    /**
     * Gets the value of the writable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getWritable() {
        return writable;
    }

    /**
     * Sets the value of the writable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setWritable(DoxBool value) {
        this.writable = value;
    }

    /**
     * Gets the value of the initonly property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getInitonly() {
        return initonly;
    }

    /**
     * Sets the value of the initonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setInitonly(DoxBool value) {
        this.initonly = value;
    }

    /**
     * Gets the value of the settable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getSettable() {
        return settable;
    }

    /**
     * Sets the value of the settable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSettable(DoxBool value) {
        this.settable = value;
    }

    /**
     * Gets the value of the privatesettable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getPrivatesettable() {
        return privatesettable;
    }

    /**
     * Sets the value of the privatesettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPrivatesettable(DoxBool value) {
        this.privatesettable = value;
    }

    /**
     * Gets the value of the protectedsettable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getProtectedsettable() {
        return protectedsettable;
    }

    /**
     * Sets the value of the protectedsettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setProtectedsettable(DoxBool value) {
        this.protectedsettable = value;
    }

    /**
     * Gets the value of the gettable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getGettable() {
        return gettable;
    }

    /**
     * Sets the value of the gettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setGettable(DoxBool value) {
        this.gettable = value;
    }

    /**
     * Gets the value of the privategettable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getPrivategettable() {
        return privategettable;
    }

    /**
     * Sets the value of the privategettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPrivategettable(DoxBool value) {
        this.privategettable = value;
    }

    /**
     * Gets the value of the protectedgettable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getProtectedgettable() {
        return protectedgettable;
    }

    /**
     * Sets the value of the protectedgettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setProtectedgettable(DoxBool value) {
        this.protectedgettable = value;
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
     * Gets the value of the new property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getNew() {
        return _new;
    }

    /**
     * Sets the value of the new property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setNew(DoxBool value) {
        this._new = value;
    }

    /**
     * Gets the value of the add property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getAdd() {
        return add;
    }

    /**
     * Sets the value of the add property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAdd(DoxBool value) {
        this.add = value;
    }

    /**
     * Gets the value of the remove property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getRemove() {
        return remove;
    }

    /**
     * Sets the value of the remove property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setRemove(DoxBool value) {
        this.remove = value;
    }

    /**
     * Gets the value of the raise property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getRaise() {
        return raise;
    }

    /**
     * Sets the value of the raise property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setRaise(DoxBool value) {
        this.raise = value;
    }

    /**
     * Gets the value of the optional property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getOptional() {
        return optional;
    }

    /**
     * Sets the value of the optional property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOptional(DoxBool value) {
        this.optional = value;
    }

    /**
     * Gets the value of the required property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setRequired(DoxBool value) {
        this.required = value;
    }

    /**
     * Gets the value of the accessor property.
     * 
     * @return
     *     possible object is
     *     {@link DoxAccessor }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxAccessor getAccessor() {
        return accessor;
    }

    /**
     * Sets the value of the accessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxAccessor }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAccessor(DoxAccessor value) {
        this.accessor = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getAttribute() {
        return attribute;
    }

    /**
     * Sets the value of the attribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setAttribute(DoxBool value) {
        this.attribute = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setProperty(DoxBool value) {
        this.property = value;
    }

    /**
     * Gets the value of the readonly property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getReadonly() {
        return readonly;
    }

    /**
     * Sets the value of the readonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setReadonly(DoxBool value) {
        this.readonly = value;
    }

    /**
     * Gets the value of the bound property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getBound() {
        return bound;
    }

    /**
     * Sets the value of the bound property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setBound(DoxBool value) {
        this.bound = value;
    }

    /**
     * Gets the value of the removable property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getRemovable() {
        return removable;
    }

    /**
     * Sets the value of the removable property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setRemovable(DoxBool value) {
        this.removable = value;
    }

    /**
     * Gets the value of the constrained property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getConstrained() {
        return constrained;
    }

    /**
     * Sets the value of the constrained property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setConstrained(DoxBool value) {
        this.constrained = value;
    }

    /**
     * Gets the value of the transient property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getTransient() {
        return _transient;
    }

    /**
     * Sets the value of the transient property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTransient(DoxBool value) {
        this._transient = value;
    }

    /**
     * Gets the value of the maybevoid property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getMaybevoid() {
        return maybevoid;
    }

    /**
     * Sets the value of the maybevoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setMaybevoid(DoxBool value) {
        this.maybevoid = value;
    }

    /**
     * Gets the value of the maybedefault property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getMaybedefault() {
        return maybedefault;
    }

    /**
     * Sets the value of the maybedefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setMaybedefault(DoxBool value) {
        this.maybedefault = value;
    }

    /**
     * Gets the value of the maybeambiguous property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public DoxBool getMaybeambiguous() {
        return maybeambiguous;
    }

    /**
     * Sets the value of the maybeambiguous property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setMaybeambiguous(DoxBool value) {
        this.maybeambiguous = value;
    }

}
