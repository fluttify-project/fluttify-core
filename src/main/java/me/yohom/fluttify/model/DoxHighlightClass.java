
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxHighlightClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxHighlightClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="comment"/>
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="preprocessor"/>
 *     &lt;enumeration value="keyword"/>
 *     &lt;enumeration value="keywordtype"/>
 *     &lt;enumeration value="keywordflow"/>
 *     &lt;enumeration value="stringliteral"/>
 *     &lt;enumeration value="charliteral"/>
 *     &lt;enumeration value="vhdlkeyword"/>
 *     &lt;enumeration value="vhdllogic"/>
 *     &lt;enumeration value="vhdlchar"/>
 *     &lt;enumeration value="vhdldigit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxHighlightClass")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxHighlightClass {

    @XmlEnumValue("comment")
    COMMENT("comment"),
    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("preprocessor")
    PREPROCESSOR("preprocessor"),
    @XmlEnumValue("keyword")
    KEYWORD("keyword"),
    @XmlEnumValue("keywordtype")
    KEYWORDTYPE("keywordtype"),
    @XmlEnumValue("keywordflow")
    KEYWORDFLOW("keywordflow"),
    @XmlEnumValue("stringliteral")
    STRINGLITERAL("stringliteral"),
    @XmlEnumValue("charliteral")
    CHARLITERAL("charliteral"),
    @XmlEnumValue("vhdlkeyword")
    VHDLKEYWORD("vhdlkeyword"),
    @XmlEnumValue("vhdllogic")
    VHDLLOGIC("vhdllogic"),
    @XmlEnumValue("vhdlchar")
    VHDLCHAR("vhdlchar"),
    @XmlEnumValue("vhdldigit")
    VHDLDIGIT("vhdldigit");
    private final String value;

    DoxHighlightClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxHighlightClass fromValue(String v) {
        for (DoxHighlightClass c: DoxHighlightClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
