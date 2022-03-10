
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxImageKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxImageKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="html"/>
 *     &lt;enumeration value="latex"/>
 *     &lt;enumeration value="docbook"/>
 *     &lt;enumeration value="rtf"/>
 *     &lt;enumeration value="xml"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxImageKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxImageKind {

    @XmlEnumValue("html")
    HTML("html"),
    @XmlEnumValue("latex")
    LATEX("latex"),
    @XmlEnumValue("docbook")
    DOCBOOK("docbook"),
    @XmlEnumValue("rtf")
    RTF("rtf"),
    @XmlEnumValue("xml")
    XML("xml");
    private final String value;

    DoxImageKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxImageKind fromValue(String v) {
        for (DoxImageKind c: DoxImageKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
