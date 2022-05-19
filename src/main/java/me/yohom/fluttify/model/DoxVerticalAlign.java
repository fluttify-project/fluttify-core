
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxVerticalAlign.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxVerticalAlign">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bottom"/>
 *     &lt;enumeration value="top"/>
 *     &lt;enumeration value="middle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxVerticalAlign")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxVerticalAlign {

    @XmlEnumValue("bottom")
    BOTTOM("bottom"),
    @XmlEnumValue("top")
    TOP("top"),
    @XmlEnumValue("middle")
    MIDDLE("middle");
    private final String value;

    DoxVerticalAlign(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxVerticalAlign fromValue(String v) {
        for (DoxVerticalAlign c: DoxVerticalAlign.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
