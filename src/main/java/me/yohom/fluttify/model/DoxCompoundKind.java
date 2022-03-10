
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxCompoundKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxCompoundKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="class"/>
 *     &lt;enumeration value="struct"/>
 *     &lt;enumeration value="union"/>
 *     &lt;enumeration value="interface"/>
 *     &lt;enumeration value="protocol"/>
 *     &lt;enumeration value="category"/>
 *     &lt;enumeration value="exception"/>
 *     &lt;enumeration value="service"/>
 *     &lt;enumeration value="singleton"/>
 *     &lt;enumeration value="module"/>
 *     &lt;enumeration value="type"/>
 *     &lt;enumeration value="file"/>
 *     &lt;enumeration value="namespace"/>
 *     &lt;enumeration value="group"/>
 *     &lt;enumeration value="page"/>
 *     &lt;enumeration value="example"/>
 *     &lt;enumeration value="dir"/>
 *     &lt;enumeration value="concept"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxCompoundKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxCompoundKind {

    @XmlEnumValue("class")
    CLASS("class"),
    @XmlEnumValue("struct")
    STRUCT("struct"),
    @XmlEnumValue("union")
    UNION("union"),
    @XmlEnumValue("interface")
    INTERFACE("interface"),
    @XmlEnumValue("protocol")
    PROTOCOL("protocol"),
    @XmlEnumValue("category")
    CATEGORY("category"),
    @XmlEnumValue("exception")
    EXCEPTION("exception"),
    @XmlEnumValue("service")
    SERVICE("service"),
    @XmlEnumValue("singleton")
    SINGLETON("singleton"),
    @XmlEnumValue("module")
    MODULE("module"),
    @XmlEnumValue("type")
    TYPE("type"),
    @XmlEnumValue("file")
    FILE("file"),
    @XmlEnumValue("namespace")
    NAMESPACE("namespace"),
    @XmlEnumValue("group")
    GROUP("group"),
    @XmlEnumValue("page")
    PAGE("page"),
    @XmlEnumValue("example")
    EXAMPLE("example"),
    @XmlEnumValue("dir")
    DIR("dir"),
    @XmlEnumValue("concept")
    CONCEPT("concept");
    private final String value;

    DoxCompoundKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxCompoundKind fromValue(String v) {
        for (DoxCompoundKind c: DoxCompoundKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
