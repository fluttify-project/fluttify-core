
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxParamListKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxParamListKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="param"/>
 *     &lt;enumeration value="retval"/>
 *     &lt;enumeration value="exception"/>
 *     &lt;enumeration value="templateparam"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxParamListKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxParamListKind {

    @XmlEnumValue("param")
    PARAM("param"),
    @XmlEnumValue("retval")
    RETVAL("retval"),
    @XmlEnumValue("exception")
    EXCEPTION("exception"),
    @XmlEnumValue("templateparam")
    TEMPLATEPARAM("templateparam");
    private final String value;

    DoxParamListKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxParamListKind fromValue(String v) {
        for (DoxParamListKind c: DoxParamListKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
