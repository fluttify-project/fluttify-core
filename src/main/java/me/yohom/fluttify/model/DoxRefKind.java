
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxRefKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxRefKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="compound"/>
 *     &lt;enumeration value="member"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxRefKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxRefKind {

    @XmlEnumValue("compound")
    COMPOUND("compound"),
    @XmlEnumValue("member")
    MEMBER("member");
    private final String value;

    DoxRefKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxRefKind fromValue(String v) {
        for (DoxRefKind c: DoxRefKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
