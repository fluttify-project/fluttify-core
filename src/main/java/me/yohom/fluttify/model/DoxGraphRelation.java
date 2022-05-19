
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxGraphRelation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxGraphRelation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="include"/>
 *     &lt;enumeration value="usage"/>
 *     &lt;enumeration value="template-instance"/>
 *     &lt;enumeration value="public-inheritance"/>
 *     &lt;enumeration value="protected-inheritance"/>
 *     &lt;enumeration value="private-inheritance"/>
 *     &lt;enumeration value="type-constraint"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxGraphRelation")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxGraphRelation {

    @XmlEnumValue("include")
    INCLUDE("include"),
    @XmlEnumValue("usage")
    USAGE("usage"),
    @XmlEnumValue("template-instance")
    TEMPLATE_INSTANCE("template-instance"),
    @XmlEnumValue("public-inheritance")
    PUBLIC_INHERITANCE("public-inheritance"),
    @XmlEnumValue("protected-inheritance")
    PROTECTED_INHERITANCE("protected-inheritance"),
    @XmlEnumValue("private-inheritance")
    PRIVATE_INHERITANCE("private-inheritance"),
    @XmlEnumValue("type-constraint")
    TYPE_CONSTRAINT("type-constraint");
    private final String value;

    DoxGraphRelation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxGraphRelation fromValue(String v) {
        for (DoxGraphRelation c: DoxGraphRelation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
