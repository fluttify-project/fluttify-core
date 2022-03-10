
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxProtectionKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxProtectionKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="public"/>
 *     &lt;enumeration value="protected"/>
 *     &lt;enumeration value="private"/>
 *     &lt;enumeration value="package"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxProtectionKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxProtectionKind {

    @XmlEnumValue("public")
    PUBLIC("public"),
    @XmlEnumValue("protected")
    PROTECTED("protected"),
    @XmlEnumValue("private")
    PRIVATE("private"),
    @XmlEnumValue("package")
    PACKAGE("package");
    private final String value;

    DoxProtectionKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxProtectionKind fromValue(String v) {
        for (DoxProtectionKind c: DoxProtectionKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
