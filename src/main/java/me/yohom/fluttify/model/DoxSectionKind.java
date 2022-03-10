
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxSectionKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxSectionKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="user-defined"/>
 *     &lt;enumeration value="public-type"/>
 *     &lt;enumeration value="public-func"/>
 *     &lt;enumeration value="public-attrib"/>
 *     &lt;enumeration value="public-slot"/>
 *     &lt;enumeration value="signal"/>
 *     &lt;enumeration value="dcop-func"/>
 *     &lt;enumeration value="property"/>
 *     &lt;enumeration value="event"/>
 *     &lt;enumeration value="public-static-func"/>
 *     &lt;enumeration value="public-static-attrib"/>
 *     &lt;enumeration value="protected-type"/>
 *     &lt;enumeration value="protected-func"/>
 *     &lt;enumeration value="protected-attrib"/>
 *     &lt;enumeration value="protected-slot"/>
 *     &lt;enumeration value="protected-static-func"/>
 *     &lt;enumeration value="protected-static-attrib"/>
 *     &lt;enumeration value="package-type"/>
 *     &lt;enumeration value="package-func"/>
 *     &lt;enumeration value="package-attrib"/>
 *     &lt;enumeration value="package-static-func"/>
 *     &lt;enumeration value="package-static-attrib"/>
 *     &lt;enumeration value="private-type"/>
 *     &lt;enumeration value="private-func"/>
 *     &lt;enumeration value="private-attrib"/>
 *     &lt;enumeration value="private-slot"/>
 *     &lt;enumeration value="private-static-func"/>
 *     &lt;enumeration value="private-static-attrib"/>
 *     &lt;enumeration value="friend"/>
 *     &lt;enumeration value="related"/>
 *     &lt;enumeration value="define"/>
 *     &lt;enumeration value="prototype"/>
 *     &lt;enumeration value="typedef"/>
 *     &lt;enumeration value="enum"/>
 *     &lt;enumeration value="func"/>
 *     &lt;enumeration value="var"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxSectionKind")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxSectionKind {

    @XmlEnumValue("user-defined")
    USER_DEFINED("user-defined"),
    @XmlEnumValue("public-type")
    PUBLIC_TYPE("public-type"),
    @XmlEnumValue("public-func")
    PUBLIC_FUNC("public-func"),
    @XmlEnumValue("public-attrib")
    PUBLIC_ATTRIB("public-attrib"),
    @XmlEnumValue("public-slot")
    PUBLIC_SLOT("public-slot"),
    @XmlEnumValue("signal")
    SIGNAL("signal"),
    @XmlEnumValue("dcop-func")
    DCOP_FUNC("dcop-func"),
    @XmlEnumValue("property")
    PROPERTY("property"),
    @XmlEnumValue("event")
    EVENT("event"),
    @XmlEnumValue("public-static-func")
    PUBLIC_STATIC_FUNC("public-static-func"),
    @XmlEnumValue("public-static-attrib")
    PUBLIC_STATIC_ATTRIB("public-static-attrib"),
    @XmlEnumValue("protected-type")
    PROTECTED_TYPE("protected-type"),
    @XmlEnumValue("protected-func")
    PROTECTED_FUNC("protected-func"),
    @XmlEnumValue("protected-attrib")
    PROTECTED_ATTRIB("protected-attrib"),
    @XmlEnumValue("protected-slot")
    PROTECTED_SLOT("protected-slot"),
    @XmlEnumValue("protected-static-func")
    PROTECTED_STATIC_FUNC("protected-static-func"),
    @XmlEnumValue("protected-static-attrib")
    PROTECTED_STATIC_ATTRIB("protected-static-attrib"),
    @XmlEnumValue("package-type")
    PACKAGE_TYPE("package-type"),
    @XmlEnumValue("package-func")
    PACKAGE_FUNC("package-func"),
    @XmlEnumValue("package-attrib")
    PACKAGE_ATTRIB("package-attrib"),
    @XmlEnumValue("package-static-func")
    PACKAGE_STATIC_FUNC("package-static-func"),
    @XmlEnumValue("package-static-attrib")
    PACKAGE_STATIC_ATTRIB("package-static-attrib"),
    @XmlEnumValue("private-type")
    PRIVATE_TYPE("private-type"),
    @XmlEnumValue("private-func")
    PRIVATE_FUNC("private-func"),
    @XmlEnumValue("private-attrib")
    PRIVATE_ATTRIB("private-attrib"),
    @XmlEnumValue("private-slot")
    PRIVATE_SLOT("private-slot"),
    @XmlEnumValue("private-static-func")
    PRIVATE_STATIC_FUNC("private-static-func"),
    @XmlEnumValue("private-static-attrib")
    PRIVATE_STATIC_ATTRIB("private-static-attrib"),
    @XmlEnumValue("friend")
    FRIEND("friend"),
    @XmlEnumValue("related")
    RELATED("related"),
    @XmlEnumValue("define")
    DEFINE("define"),
    @XmlEnumValue("prototype")
    PROTOTYPE("prototype"),
    @XmlEnumValue("typedef")
    TYPEDEF("typedef"),
    @XmlEnumValue("enum")
    ENUM("enum"),
    @XmlEnumValue("func")
    FUNC("func"),
    @XmlEnumValue("var")
    VAR("var");
    private final String value;

    DoxSectionKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxSectionKind fromValue(String v) {
        for (DoxSectionKind c: DoxSectionKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
