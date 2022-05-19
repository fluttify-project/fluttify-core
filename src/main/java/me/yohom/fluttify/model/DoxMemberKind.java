
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxMemberKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxMemberKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="define"/>
 *     &lt;enumeration value="property"/>
 *     &lt;enumeration value="event"/>
 *     &lt;enumeration value="variable"/>
 *     &lt;enumeration value="typedef"/>
 *     &lt;enumeration value="enum"/>
 *     &lt;enumeration value="function"/>
 *     &lt;enumeration value="signal"/>
 *     &lt;enumeration value="prototype"/>
 *     &lt;enumeration value="friend"/>
 *     &lt;enumeration value="dcop"/>
 *     &lt;enumeration value="slot"/>
 *     &lt;enumeration value="interface"/>
 *     &lt;enumeration value="service"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxMemberKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxMemberKind {

    @XmlEnumValue("define")
    DEFINE("define"),
    @XmlEnumValue("property")
    PROPERTY("property"),
    @XmlEnumValue("event")
    EVENT("event"),
    @XmlEnumValue("variable")
    VARIABLE("variable"),
    @XmlEnumValue("typedef")
    TYPEDEF("typedef"),
    @XmlEnumValue("enum")
    ENUM("enum"),
    @XmlEnumValue("function")
    FUNCTION("function"),
    @XmlEnumValue("signal")
    SIGNAL("signal"),
    @XmlEnumValue("prototype")
    PROTOTYPE("prototype"),
    @XmlEnumValue("friend")
    FRIEND("friend"),
    @XmlEnumValue("dcop")
    DCOP("dcop"),
    @XmlEnumValue("slot")
    SLOT("slot"),
    @XmlEnumValue("interface")
    INTERFACE("interface"),
    @XmlEnumValue("service")
    SERVICE("service");
    private final String value;

    DoxMemberKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxMemberKind fromValue(String v) {
        for (DoxMemberKind c: DoxMemberKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
