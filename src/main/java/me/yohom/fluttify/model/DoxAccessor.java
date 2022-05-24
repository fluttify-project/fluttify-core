
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxAccessor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxAccessor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="retain"/>
 *     &lt;enumeration value="copy"/>
 *     &lt;enumeration value="assign"/>
 *     &lt;enumeration value="weak"/>
 *     &lt;enumeration value="strong"/>
 *     &lt;enumeration value="unretained"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxAccessor")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxAccessor {

    @XmlEnumValue("retain")
    RETAIN("retain"),
    @XmlEnumValue("copy")
    COPY("copy"),
    @XmlEnumValue("assign")
    ASSIGN("assign"),
    @XmlEnumValue("weak")
    WEAK("weak"),
    @XmlEnumValue("strong")
    STRONG("strong"),
    @XmlEnumValue("unretained")
    UNRETAINED("unretained");
    private final String value;

    DoxAccessor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxAccessor fromValue(String v) {
        for (DoxAccessor c: DoxAccessor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
