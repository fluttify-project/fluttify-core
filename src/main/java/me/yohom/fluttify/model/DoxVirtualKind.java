
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxVirtualKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxVirtualKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="non-virtual"/>
 *     &lt;enumeration value="virtual"/>
 *     &lt;enumeration value="pure-virtual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxVirtualKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxVirtualKind {

    @XmlEnumValue("non-virtual")
    NON_VIRTUAL("non-virtual"),
    @XmlEnumValue("virtual")
    VIRTUAL("virtual"),
    @XmlEnumValue("pure-virtual")
    PURE_VIRTUAL("pure-virtual");
    private final String value;

    DoxVirtualKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxVirtualKind fromValue(String v) {
        for (DoxVirtualKind c: DoxVirtualKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
