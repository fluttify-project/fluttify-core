
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxParamDir.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxParamDir">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="in"/>
 *     &lt;enumeration value="out"/>
 *     &lt;enumeration value="inout"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxParamDir")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxParamDir {

    @XmlEnumValue("in")
    IN("in"),
    @XmlEnumValue("out")
    OUT("out"),
    @XmlEnumValue("inout")
    INOUT("inout");
    private final String value;

    DoxParamDir(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxParamDir fromValue(String v) {
        for (DoxParamDir c: DoxParamDir.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
