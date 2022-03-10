
package me.yohom.fluttify.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxPlantumlEngine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxPlantumlEngine">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="uml"/>
 *     &lt;enumeration value="bpm"/>
 *     &lt;enumeration value="wire"/>
 *     &lt;enumeration value="dot"/>
 *     &lt;enumeration value="ditaa"/>
 *     &lt;enumeration value="salt"/>
 *     &lt;enumeration value="math"/>
 *     &lt;enumeration value="latex"/>
 *     &lt;enumeration value="gantt"/>
 *     &lt;enumeration value="mindmap"/>
 *     &lt;enumeration value="wbs"/>
 *     &lt;enumeration value="yaml"/>
 *     &lt;enumeration value="creole"/>
 *     &lt;enumeration value="json"/>
 *     &lt;enumeration value="flow"/>
 *     &lt;enumeration value="board"/>
 *     &lt;enumeration value="git"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxPlantumlEngine")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2022-03-10T02:28:02+08:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum DoxPlantumlEngine {

    @XmlEnumValue("uml")
    UML("uml"),
    @XmlEnumValue("bpm")
    BPM("bpm"),
    @XmlEnumValue("wire")
    WIRE("wire"),
    @XmlEnumValue("dot")
    DOT("dot"),
    @XmlEnumValue("ditaa")
    DITAA("ditaa"),
    @XmlEnumValue("salt")
    SALT("salt"),
    @XmlEnumValue("math")
    MATH("math"),
    @XmlEnumValue("latex")
    LATEX("latex"),
    @XmlEnumValue("gantt")
    GANTT("gantt"),
    @XmlEnumValue("mindmap")
    MINDMAP("mindmap"),
    @XmlEnumValue("wbs")
    WBS("wbs"),
    @XmlEnumValue("yaml")
    YAML("yaml"),
    @XmlEnumValue("creole")
    CREOLE("creole"),
    @XmlEnumValue("json")
    JSON("json"),
    @XmlEnumValue("flow")
    FLOW("flow"),
    @XmlEnumValue("board")
    BOARD("board"),
    @XmlEnumValue("git")
    GIT("git");
    private final String value;

    DoxPlantumlEngine(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxPlantumlEngine fromValue(String v) {
        for (DoxPlantumlEngine c: DoxPlantumlEngine.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
