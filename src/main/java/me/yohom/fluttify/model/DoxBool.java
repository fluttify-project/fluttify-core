
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxBool.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxBool">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="yes"/>
 *     &lt;enumeration value="no"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxBool")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxBool {

    @XmlEnumValue("yes")
    YES("yes"),
    @XmlEnumValue("no")
    NO("no");
    private final String value;

    DoxBool(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxBool fromValue(String v) {
        for (DoxBool c: DoxBool.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
