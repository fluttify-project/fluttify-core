
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxSimpleSectKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxSimpleSectKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="see"/>
 *     &lt;enumeration value="return"/>
 *     &lt;enumeration value="author"/>
 *     &lt;enumeration value="authors"/>
 *     &lt;enumeration value="version"/>
 *     &lt;enumeration value="since"/>
 *     &lt;enumeration value="date"/>
 *     &lt;enumeration value="note"/>
 *     &lt;enumeration value="warning"/>
 *     &lt;enumeration value="pre"/>
 *     &lt;enumeration value="post"/>
 *     &lt;enumeration value="copyright"/>
 *     &lt;enumeration value="invariant"/>
 *     &lt;enumeration value="remark"/>
 *     &lt;enumeration value="attention"/>
 *     &lt;enumeration value="par"/>
 *     &lt;enumeration value="rcs"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxSimpleSectKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxSimpleSectKind {

    @XmlEnumValue("see")
    SEE("see"),
    @XmlEnumValue("return")
    RETURN("return"),
    @XmlEnumValue("author")
    AUTHOR("author"),
    @XmlEnumValue("authors")
    AUTHORS("authors"),
    @XmlEnumValue("version")
    VERSION("version"),
    @XmlEnumValue("since")
    SINCE("since"),
    @XmlEnumValue("date")
    DATE("date"),
    @XmlEnumValue("note")
    NOTE("note"),
    @XmlEnumValue("warning")
    WARNING("warning"),
    @XmlEnumValue("pre")
    PRE("pre"),
    @XmlEnumValue("post")
    POST("post"),
    @XmlEnumValue("copyright")
    COPYRIGHT("copyright"),
    @XmlEnumValue("invariant")
    INVARIANT("invariant"),
    @XmlEnumValue("remark")
    REMARK("remark"),
    @XmlEnumValue("attention")
    ATTENTION("attention"),
    @XmlEnumValue("par")
    PAR("par"),
    @XmlEnumValue("rcs")
    RCS("rcs");
    private final String value;

    DoxSimpleSectKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxSimpleSectKind fromValue(String v) {
        for (DoxSimpleSectKind c: DoxSimpleSectKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
