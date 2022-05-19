
package me.yohom.fluttify.model;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the me.yohom.fluttify.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Doxygen_QNAME = new QName("", "doxygen");
    private final static QName _DocRefTextTypeUlink_QNAME = new QName("", "ulink");
    private final static QName _DescriptionTypeInternal_QNAME = new QName("", "internal");
    private final static QName _DescriptionTypePara_QNAME = new QName("", "para");
    private final static QName _DescriptionTypeTitle_QNAME = new QName("", "title");
    private final static QName _DescriptionTypeSect1_QNAME = new QName("", "sect1");
    private final static QName _DocParamNameRef_QNAME = new QName("", "ref");
    private final static QName _DocInternalS1TypeSect2_QNAME = new QName("", "sect2");
    private final static QName _DocMarkupTypeToclist_QNAME = new QName("", "toclist");
    private final static QName _DocMarkupTypeProgramlisting_QNAME = new QName("", "programlisting");
    private final static QName _DocMarkupTypeOrderedlist_QNAME = new QName("", "orderedlist");
    private final static QName _DocMarkupTypeLanguage_QNAME = new QName("", "language");
    private final static QName _DocMarkupTypeVariablelist_QNAME = new QName("", "variablelist");
    private final static QName _DocMarkupTypeJavadocliteral_QNAME = new QName("", "javadocliteral");
    private final static QName _DocMarkupTypeSimplesect_QNAME = new QName("", "simplesect");
    private final static QName _DocMarkupTypeVerbatim_QNAME = new QName("", "verbatim");
    private final static QName _DocMarkupTypeDiafile_QNAME = new QName("", "diafile");
    private final static QName _DocMarkupTypeJavadoccode_QNAME = new QName("", "javadoccode");
    private final static QName _DocMarkupTypeTable_QNAME = new QName("", "table");
    private final static QName _DocMarkupTypeMscfile_QNAME = new QName("", "mscfile");
    private final static QName _DocMarkupTypeXrefsect_QNAME = new QName("", "xrefsect");
    private final static QName _DocMarkupTypeBlockquote_QNAME = new QName("", "blockquote");
    private final static QName _DocMarkupTypeHeading_QNAME = new QName("", "heading");
    private final static QName _DocMarkupTypeParameterlist_QNAME = new QName("", "parameterlist");
    private final static QName _DocMarkupTypeParblock_QNAME = new QName("", "parblock");
    private final static QName _DocMarkupTypeDotfile_QNAME = new QName("", "dotfile");
    private final static QName _DocMarkupTypeCopydoc_QNAME = new QName("", "copydoc");
    private final static QName _DocMarkupTypeIndexentry_QNAME = new QName("", "indexentry");
    private final static QName _DocMarkupTypeItemizedlist_QNAME = new QName("", "itemizedlist");
    private final static QName _DocMarkupTypeHruler_QNAME = new QName("", "hruler");
    private final static QName _DocMarkupTypePreformatted_QNAME = new QName("", "preformatted");
    private final static QName _EnumvalueTypeBriefdescription_QNAME = new QName("", "briefdescription");
    private final static QName _EnumvalueTypeName_QNAME = new QName("", "name");
    private final static QName _EnumvalueTypeDetaileddescription_QNAME = new QName("", "detaileddescription");
    private final static QName _EnumvalueTypeInitializer_QNAME = new QName("", "initializer");
    private final static QName _DocInternalS2TypeSect3_QNAME = new QName("", "sect3");
    private final static QName _DocSect3TypeSect4_QNAME = new QName("", "sect4");
    private final static QName _HighlightTypeSp_QNAME = new QName("", "sp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: me.yohom.fluttify.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoxygenType }
     * 
     */
    public DoxygenType createDoxygenType() {
        return new DoxygenType();
    }

    /**
     * Create an instance of {@link DocSect1Type }
     * 
     */
    public DocSect1Type createDocSect1Type() {
        return new DocSect1Type();
    }

    /**
     * Create an instance of {@link DocBlockQuoteType }
     * 
     */
    public DocBlockQuoteType createDocBlockQuoteType() {
        return new DocBlockQuoteType();
    }

    /**
     * Create an instance of {@link TableofcontentsType }
     * 
     */
    public TableofcontentsType createTableofcontentsType() {
        return new TableofcontentsType();
    }

    /**
     * Create an instance of {@link IncType }
     * 
     */
    public IncType createIncType() {
        return new IncType();
    }

    /**
     * Create an instance of {@link DocTocListType }
     * 
     */
    public DocTocListType createDocTocListType() {
        return new DocTocListType();
    }

    /**
     * Create an instance of {@link ListingType }
     * 
     */
    public ListingType createListingType() {
        return new ListingType();
    }

    /**
     * Create an instance of {@link LocationType }
     * 
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link DocFormulaType }
     * 
     */
    public DocFormulaType createDocFormulaType() {
        return new DocFormulaType();
    }

    /**
     * Create an instance of {@link DocEmptyType }
     * 
     */
    public DocEmptyType createDocEmptyType() {
        return new DocEmptyType();
    }

    /**
     * Create an instance of {@link DocSect2Type }
     * 
     */
    public DocSect2Type createDocSect2Type() {
        return new DocSect2Type();
    }

    /**
     * Create an instance of {@link DocInternalS3Type }
     * 
     */
    public DocInternalS3Type createDocInternalS3Type() {
        return new DocInternalS3Type();
    }

    /**
     * Create an instance of {@link ParamType }
     * 
     */
    public ParamType createParamType() {
        return new ParamType();
    }

    /**
     * Create an instance of {@link DocRowType }
     * 
     */
    public DocRowType createDocRowType() {
        return new DocRowType();
    }

    /**
     * Create an instance of {@link DocURLLink }
     * 
     */
    public DocURLLink createDocURLLink() {
        return new DocURLLink();
    }

    /**
     * Create an instance of {@link DescriptionType }
     * 
     */
    public DescriptionType createDescriptionType() {
        return new DescriptionType();
    }

    /**
     * Create an instance of {@link DocIndexEntryType }
     * 
     */
    public DocIndexEntryType createDocIndexEntryType() {
        return new DocIndexEntryType();
    }

    /**
     * Create an instance of {@link DocPlantumlType }
     * 
     */
    public DocPlantumlType createDocPlantumlType() {
        return new DocPlantumlType();
    }

    /**
     * Create an instance of {@link SectiondefType }
     * 
     */
    public SectiondefType createSectiondefType() {
        return new SectiondefType();
    }

    /**
     * Create an instance of {@link DocInternalS4Type }
     * 
     */
    public DocInternalS4Type createDocInternalS4Type() {
        return new DocInternalS4Type();
    }

    /**
     * Create an instance of {@link DocEntryType }
     * 
     */
    public DocEntryType createDocEntryType() {
        return new DocEntryType();
    }

    /**
     * Create an instance of {@link GraphType }
     * 
     */
    public GraphType createGraphType() {
        return new GraphType();
    }

    /**
     * Create an instance of {@link DocListItemType }
     * 
     */
    public DocListItemType createDocListItemType() {
        return new DocListItemType();
    }

    /**
     * Create an instance of {@link DocEmojiType }
     * 
     */
    public DocEmojiType createDocEmojiType() {
        return new DocEmojiType();
    }

    /**
     * Create an instance of {@link RefTextType }
     * 
     */
    public RefTextType createRefTextType() {
        return new RefTextType();
    }

    /**
     * Create an instance of {@link DocSect4Type }
     * 
     */
    public DocSect4Type createDocSect4Type() {
        return new DocSect4Type();
    }

    /**
     * Create an instance of {@link DocInternalS1Type }
     * 
     */
    public DocInternalS1Type createDocInternalS1Type() {
        return new DocInternalS1Type();
    }

    /**
     * Create an instance of {@link NodeType }
     * 
     */
    public NodeType createNodeType() {
        return new NodeType();
    }

    /**
     * Create an instance of {@link DocLanguageType }
     * 
     */
    public DocLanguageType createDocLanguageType() {
        return new DocLanguageType();
    }

    /**
     * Create an instance of {@link DocTableType }
     * 
     */
    public DocTableType createDocTableType() {
        return new DocTableType();
    }

    /**
     * Create an instance of {@link TableofcontentsKindType }
     * 
     */
    public TableofcontentsKindType createTableofcontentsKindType() {
        return new TableofcontentsKindType();
    }

    /**
     * Create an instance of {@link DocVarListEntryType }
     * 
     */
    public DocVarListEntryType createDocVarListEntryType() {
        return new DocVarListEntryType();
    }

    /**
     * Create an instance of {@link ChildnodeType }
     * 
     */
    public ChildnodeType createChildnodeType() {
        return new ChildnodeType();
    }

    /**
     * Create an instance of {@link DocCaptionType }
     * 
     */
    public DocCaptionType createDocCaptionType() {
        return new DocCaptionType();
    }

    /**
     * Create an instance of {@link MemberdefType }
     * 
     */
    public MemberdefType createMemberdefType() {
        return new MemberdefType();
    }

    /**
     * Create an instance of {@link LinkedTextType }
     * 
     */
    public LinkedTextType createLinkedTextType() {
        return new LinkedTextType();
    }

    /**
     * Create an instance of {@link SpType }
     * 
     */
    public SpType createSpType() {
        return new SpType();
    }

    /**
     * Create an instance of {@link CompoundRefType }
     * 
     */
    public CompoundRefType createCompoundRefType() {
        return new CompoundRefType();
    }

    /**
     * Create an instance of {@link DocParamName }
     * 
     */
    public DocParamName createDocParamName() {
        return new DocParamName();
    }

    /**
     * Create an instance of {@link DocInternalS2Type }
     * 
     */
    public DocInternalS2Type createDocInternalS2Type() {
        return new DocInternalS2Type();
    }

    /**
     * Create an instance of {@link ReimplementType }
     * 
     */
    public ReimplementType createReimplementType() {
        return new ReimplementType();
    }

    /**
     * Create an instance of {@link DocSect3Type }
     * 
     */
    public DocSect3Type createDocSect3Type() {
        return new DocSect3Type();
    }

    /**
     * Create an instance of {@link DocTitleType }
     * 
     */
    public DocTitleType createDocTitleType() {
        return new DocTitleType();
    }

    /**
     * Create an instance of {@link DocParBlockType }
     * 
     */
    public DocParBlockType createDocParBlockType() {
        return new DocParBlockType();
    }

    /**
     * Create an instance of {@link TemplateparamlistType }
     * 
     */
    public TemplateparamlistType createTemplateparamlistType() {
        return new TemplateparamlistType();
    }

    /**
     * Create an instance of {@link ListofallmembersType }
     * 
     */
    public ListofallmembersType createListofallmembersType() {
        return new ListofallmembersType();
    }

    /**
     * Create an instance of {@link EnumvalueType }
     * 
     */
    public EnumvalueType createEnumvalueType() {
        return new EnumvalueType();
    }

    /**
     * Create an instance of {@link RefType }
     * 
     */
    public RefType createRefType() {
        return new RefType();
    }

    /**
     * Create an instance of {@link ReferenceType }
     * 
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link DocRefTextType }
     * 
     */
    public DocRefTextType createDocRefTextType() {
        return new DocRefTextType();
    }

    /**
     * Create an instance of {@link DocAnchorType }
     * 
     */
    public DocAnchorType createDocAnchorType() {
        return new DocAnchorType();
    }

    /**
     * Create an instance of {@link DocHeadingType }
     * 
     */
    public DocHeadingType createDocHeadingType() {
        return new DocHeadingType();
    }

    /**
     * Create an instance of {@link DocParamListType }
     * 
     */
    public DocParamListType createDocParamListType() {
        return new DocParamListType();
    }

    /**
     * Create an instance of {@link DocParamType }
     * 
     */
    public DocParamType createDocParamType() {
        return new DocParamType();
    }

    /**
     * Create an instance of {@link DocImageType }
     * 
     */
    public DocImageType createDocImageType() {
        return new DocImageType();
    }

    /**
     * Create an instance of {@link DocDotMscType }
     * 
     */
    public DocDotMscType createDocDotMscType() {
        return new DocDotMscType();
    }

    /**
     * Create an instance of {@link DocParaType }
     * 
     */
    public DocParaType createDocParaType() {
        return new DocParaType();
    }

    /**
     * Create an instance of {@link DocParamListItem }
     * 
     */
    public DocParamListItem createDocParamListItem() {
        return new DocParamListItem();
    }

    /**
     * Create an instance of {@link CodelineType }
     * 
     */
    public CodelineType createCodelineType() {
        return new CodelineType();
    }

    /**
     * Create an instance of {@link HighlightType }
     * 
     */
    public HighlightType createHighlightType() {
        return new HighlightType();
    }

    /**
     * Create an instance of {@link DocSimpleSectType }
     * 
     */
    public DocSimpleSectType createDocSimpleSectType() {
        return new DocSimpleSectType();
    }

    /**
     * Create an instance of {@link DocVariableListType }
     * 
     */
    public DocVariableListType createDocVariableListType() {
        return new DocVariableListType();
    }

    /**
     * Create an instance of {@link DocParamNameList }
     * 
     */
    public DocParamNameList createDocParamNameList() {
        return new DocParamNameList();
    }

    /**
     * Create an instance of {@link DocImageFileType }
     * 
     */
    public DocImageFileType createDocImageFileType() {
        return new DocImageFileType();
    }

    /**
     * Create an instance of {@link DocHtmlOnlyType }
     * 
     */
    public DocHtmlOnlyType createDocHtmlOnlyType() {
        return new DocHtmlOnlyType();
    }

    /**
     * Create an instance of {@link DocListType }
     * 
     */
    public DocListType createDocListType() {
        return new DocListType();
    }

    /**
     * Create an instance of {@link DocCopyType }
     * 
     */
    public DocCopyType createDocCopyType() {
        return new DocCopyType();
    }

    /**
     * Create an instance of {@link MemberRefType }
     * 
     */
    public MemberRefType createMemberRefType() {
        return new MemberRefType();
    }

    /**
     * Create an instance of {@link DocTocItemType }
     * 
     */
    public DocTocItemType createDocTocItemType() {
        return new DocTocItemType();
    }

    /**
     * Create an instance of {@link CompounddefType }
     * 
     */
    public CompounddefType createCompounddefType() {
        return new CompounddefType();
    }

    /**
     * Create an instance of {@link LinkType }
     * 
     */
    public LinkType createLinkType() {
        return new LinkType();
    }

    /**
     * Create an instance of {@link DocXRefSectType }
     * 
     */
    public DocXRefSectType createDocXRefSectType() {
        return new DocXRefSectType();
    }

    /**
     * Create an instance of {@link DocInternalType }
     * 
     */
    public DocInternalType createDocInternalType() {
        return new DocInternalType();
    }

    /**
     * Create an instance of {@link DocMarkupType }
     * 
     */
    public DocMarkupType createDocMarkupType() {
        return new DocMarkupType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoxygenType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "doxygen")
    public JAXBElement<DoxygenType> createDoxygen(DoxygenType value) {
        return new JAXBElement<DoxygenType>(_Doxygen_QNAME, DoxygenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocRefTextType.class)
    public JAXBElement<DocURLLink> createDocRefTextTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocRefTextType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocInternalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "internal", scope = DescriptionType.class)
    public JAXBElement<DocInternalType> createDescriptionTypeInternal(DocInternalType value) {
        return new JAXBElement<DocInternalType>(_DescriptionTypeInternal_QNAME, DocInternalType.class, DescriptionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DescriptionType.class)
    public JAXBElement<DocParaType> createDescriptionTypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DescriptionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = DescriptionType.class)
    public JAXBElement<String> createDescriptionTypeTitle(String value) {
        return new JAXBElement<String>(_DescriptionTypeTitle_QNAME, String.class, DescriptionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSect1Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sect1", scope = DescriptionType.class)
    public JAXBElement<DocSect1Type> createDescriptionTypeSect1(DocSect1Type value) {
        return new JAXBElement<DocSect1Type>(_DescriptionTypeSect1_QNAME, DocSect1Type.class, DescriptionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocHeadingType.class)
    public JAXBElement<DocURLLink> createDocHeadingTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocHeadingType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocPlantumlType.class)
    public JAXBElement<DocURLLink> createDocPlantumlTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocPlantumlType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ref", scope = DocParamName.class)
    public JAXBElement<RefTextType> createDocParamNameRef(RefTextType value) {
        return new JAXBElement<RefTextType>(_DocParamNameRef_QNAME, RefTextType.class, DocParamName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocTitleType.class)
    public JAXBElement<DocURLLink> createDocTitleTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocTitleType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocInternalS1Type.class)
    public JAXBElement<DocParaType> createDocInternalS1TypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocInternalS1Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSect2Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sect2", scope = DocInternalS1Type.class)
    public JAXBElement<DocSect2Type> createDocInternalS1TypeSect2(DocSect2Type value) {
        return new JAXBElement<DocSect2Type>(_DocInternalS1TypeSect2_QNAME, DocSect2Type.class, DocInternalS1Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocURLLink.class)
    public JAXBElement<DocURLLink> createDocURLLinkUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocURLLink.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocTocListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "toclist", scope = DocMarkupType.class)
    public JAXBElement<DocTocListType> createDocMarkupTypeToclist(DocTocListType value) {
        return new JAXBElement<DocTocListType>(_DocMarkupTypeToclist_QNAME, DocTocListType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "programlisting", scope = DocMarkupType.class)
    public JAXBElement<ListingType> createDocMarkupTypeProgramlisting(ListingType value) {
        return new JAXBElement<ListingType>(_DocMarkupTypeProgramlisting_QNAME, ListingType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "orderedlist", scope = DocMarkupType.class)
    public JAXBElement<DocListType> createDocMarkupTypeOrderedlist(DocListType value) {
        return new JAXBElement<DocListType>(_DocMarkupTypeOrderedlist_QNAME, DocListType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocLanguageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "language", scope = DocMarkupType.class)
    public JAXBElement<DocLanguageType> createDocMarkupTypeLanguage(DocLanguageType value) {
        return new JAXBElement<DocLanguageType>(_DocMarkupTypeLanguage_QNAME, DocLanguageType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocVariableListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "variablelist", scope = DocMarkupType.class)
    public JAXBElement<DocVariableListType> createDocMarkupTypeVariablelist(DocVariableListType value) {
        return new JAXBElement<DocVariableListType>(_DocMarkupTypeVariablelist_QNAME, DocVariableListType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocMarkupType.class)
    public JAXBElement<DocURLLink> createDocMarkupTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "javadocliteral", scope = DocMarkupType.class)
    public JAXBElement<String> createDocMarkupTypeJavadocliteral(String value) {
        return new JAXBElement<String>(_DocMarkupTypeJavadocliteral_QNAME, String.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSimpleSectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "simplesect", scope = DocMarkupType.class)
    public JAXBElement<DocSimpleSectType> createDocMarkupTypeSimplesect(DocSimpleSectType value) {
        return new JAXBElement<DocSimpleSectType>(_DocMarkupTypeSimplesect_QNAME, DocSimpleSectType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocTitleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = DocMarkupType.class)
    public JAXBElement<DocTitleType> createDocMarkupTypeTitle(DocTitleType value) {
        return new JAXBElement<DocTitleType>(_DescriptionTypeTitle_QNAME, DocTitleType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "verbatim", scope = DocMarkupType.class)
    public JAXBElement<String> createDocMarkupTypeVerbatim(String value) {
        return new JAXBElement<String>(_DocMarkupTypeVerbatim_QNAME, String.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "diafile", scope = DocMarkupType.class)
    public JAXBElement<DocImageFileType> createDocMarkupTypeDiafile(DocImageFileType value) {
        return new JAXBElement<DocImageFileType>(_DocMarkupTypeDiafile_QNAME, DocImageFileType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "javadoccode", scope = DocMarkupType.class)
    public JAXBElement<String> createDocMarkupTypeJavadoccode(String value) {
        return new JAXBElement<String>(_DocMarkupTypeJavadoccode_QNAME, String.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocTableType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "table", scope = DocMarkupType.class)
    public JAXBElement<DocTableType> createDocMarkupTypeTable(DocTableType value) {
        return new JAXBElement<DocTableType>(_DocMarkupTypeTable_QNAME, DocTableType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mscfile", scope = DocMarkupType.class)
    public JAXBElement<DocImageFileType> createDocMarkupTypeMscfile(DocImageFileType value) {
        return new JAXBElement<DocImageFileType>(_DocMarkupTypeMscfile_QNAME, DocImageFileType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocXRefSectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "xrefsect", scope = DocMarkupType.class)
    public JAXBElement<DocXRefSectType> createDocMarkupTypeXrefsect(DocXRefSectType value) {
        return new JAXBElement<DocXRefSectType>(_DocMarkupTypeXrefsect_QNAME, DocXRefSectType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocBlockQuoteType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "blockquote", scope = DocMarkupType.class)
    public JAXBElement<DocBlockQuoteType> createDocMarkupTypeBlockquote(DocBlockQuoteType value) {
        return new JAXBElement<DocBlockQuoteType>(_DocMarkupTypeBlockquote_QNAME, DocBlockQuoteType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocHeadingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "heading", scope = DocMarkupType.class)
    public JAXBElement<DocHeadingType> createDocMarkupTypeHeading(DocHeadingType value) {
        return new JAXBElement<DocHeadingType>(_DocMarkupTypeHeading_QNAME, DocHeadingType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParamListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parameterlist", scope = DocMarkupType.class)
    public JAXBElement<DocParamListType> createDocMarkupTypeParameterlist(DocParamListType value) {
        return new JAXBElement<DocParamListType>(_DocMarkupTypeParameterlist_QNAME, DocParamListType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParBlockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parblock", scope = DocMarkupType.class)
    public JAXBElement<DocParBlockType> createDocMarkupTypeParblock(DocParBlockType value) {
        return new JAXBElement<DocParBlockType>(_DocMarkupTypeParblock_QNAME, DocParBlockType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "dotfile", scope = DocMarkupType.class)
    public JAXBElement<DocImageFileType> createDocMarkupTypeDotfile(DocImageFileType value) {
        return new JAXBElement<DocImageFileType>(_DocMarkupTypeDotfile_QNAME, DocImageFileType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocCopyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "copydoc", scope = DocMarkupType.class)
    public JAXBElement<DocCopyType> createDocMarkupTypeCopydoc(DocCopyType value) {
        return new JAXBElement<DocCopyType>(_DocMarkupTypeCopydoc_QNAME, DocCopyType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocIndexEntryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "indexentry", scope = DocMarkupType.class)
    public JAXBElement<DocIndexEntryType> createDocMarkupTypeIndexentry(DocIndexEntryType value) {
        return new JAXBElement<DocIndexEntryType>(_DocMarkupTypeIndexentry_QNAME, DocIndexEntryType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "itemizedlist", scope = DocMarkupType.class)
    public JAXBElement<DocListType> createDocMarkupTypeItemizedlist(DocListType value) {
        return new JAXBElement<DocListType>(_DocMarkupTypeItemizedlist_QNAME, DocListType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "hruler", scope = DocMarkupType.class)
    public JAXBElement<DocEmptyType> createDocMarkupTypeHruler(DocEmptyType value) {
        return new JAXBElement<DocEmptyType>(_DocMarkupTypeHruler_QNAME, DocEmptyType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "preformatted", scope = DocMarkupType.class)
    public JAXBElement<DocMarkupType> createDocMarkupTypePreformatted(DocMarkupType value) {
        return new JAXBElement<DocMarkupType>(_DocMarkupTypePreformatted_QNAME, DocMarkupType.class, DocMarkupType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocImageFileType.class)
    public JAXBElement<DocURLLink> createDocImageFileTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocImageFileType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DescriptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "briefdescription", scope = EnumvalueType.class)
    public JAXBElement<DescriptionType> createEnumvalueTypeBriefdescription(DescriptionType value) {
        return new JAXBElement<DescriptionType>(_EnumvalueTypeBriefdescription_QNAME, DescriptionType.class, EnumvalueType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name", scope = EnumvalueType.class)
    public JAXBElement<Object> createEnumvalueTypeName(Object value) {
        return new JAXBElement<Object>(_EnumvalueTypeName_QNAME, Object.class, EnumvalueType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DescriptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "detaileddescription", scope = EnumvalueType.class)
    public JAXBElement<DescriptionType> createEnumvalueTypeDetaileddescription(DescriptionType value) {
        return new JAXBElement<DescriptionType>(_EnumvalueTypeDetaileddescription_QNAME, DescriptionType.class, EnumvalueType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkedTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "initializer", scope = EnumvalueType.class)
    public JAXBElement<LinkedTextType> createEnumvalueTypeInitializer(LinkedTextType value) {
        return new JAXBElement<LinkedTextType>(_EnumvalueTypeInitializer_QNAME, LinkedTextType.class, EnumvalueType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSect3Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sect3", scope = DocInternalS2Type.class)
    public JAXBElement<DocSect3Type> createDocInternalS2TypeSect3(DocSect3Type value) {
        return new JAXBElement<DocSect3Type>(_DocInternalS2TypeSect3_QNAME, DocSect3Type.class, DocInternalS2Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocInternalS2Type.class)
    public JAXBElement<DocParaType> createDocInternalS2TypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocInternalS2Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocCaptionType.class)
    public JAXBElement<DocURLLink> createDocCaptionTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocCaptionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocInternalS4Type.class)
    public JAXBElement<DocParaType> createDocInternalS4TypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocInternalS4Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocTocItemType.class)
    public JAXBElement<DocURLLink> createDocTocItemTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocTocItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ref", scope = DocParamType.class)
    public JAXBElement<RefTextType> createDocParamTypeRef(RefTextType value) {
        return new JAXBElement<RefTextType>(_DocParamNameRef_QNAME, RefTextType.class, DocParamType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ref", scope = LinkedTextType.class)
    public JAXBElement<RefTextType> createLinkedTextTypeRef(RefTextType value) {
        return new JAXBElement<RefTextType>(_DocParamNameRef_QNAME, RefTextType.class, LinkedTextType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocImageType.class)
    public JAXBElement<DocURLLink> createDocImageTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocImageType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSect4Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sect3", scope = DocInternalS3Type.class)
    public JAXBElement<DocSect4Type> createDocInternalS3TypeSect3(DocSect4Type value) {
        return new JAXBElement<DocSect4Type>(_DocInternalS2TypeSect3_QNAME, DocSect4Type.class, DocInternalS3Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocInternalS3Type.class)
    public JAXBElement<DocParaType> createDocInternalS3TypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocInternalS3Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSect4Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sect4", scope = DocSect3Type.class)
    public JAXBElement<DocSect4Type> createDocSect3TypeSect4(DocSect4Type value) {
        return new JAXBElement<DocSect4Type>(_DocSect3TypeSect4_QNAME, DocSect4Type.class, DocSect3Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocInternalS3Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "internal", scope = DocSect3Type.class)
    public JAXBElement<DocInternalS3Type> createDocSect3TypeInternal(DocInternalS3Type value) {
        return new JAXBElement<DocInternalS3Type>(_DescriptionTypeInternal_QNAME, DocInternalS3Type.class, DocSect3Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocSect3Type.class)
    public JAXBElement<DocParaType> createDocSect3TypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocSect3Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = DocSect3Type.class)
    public JAXBElement<String> createDocSect3TypeTitle(String value) {
        return new JAXBElement<String>(_DescriptionTypeTitle_QNAME, String.class, DocSect3Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocInternalS1Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "internal", scope = DocSect1Type.class)
    public JAXBElement<DocInternalS1Type> createDocSect1TypeInternal(DocInternalS1Type value) {
        return new JAXBElement<DocInternalS1Type>(_DescriptionTypeInternal_QNAME, DocInternalS1Type.class, DocSect1Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocSect1Type.class)
    public JAXBElement<DocParaType> createDocSect1TypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocSect1Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = DocSect1Type.class)
    public JAXBElement<String> createDocSect1TypeTitle(String value) {
        return new JAXBElement<String>(_DescriptionTypeTitle_QNAME, String.class, DocSect1Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSect2Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sect2", scope = DocSect1Type.class)
    public JAXBElement<DocSect2Type> createDocSect1TypeSect2(DocSect2Type value) {
        return new JAXBElement<DocSect2Type>(_DocInternalS1TypeSect2_QNAME, DocSect2Type.class, DocSect1Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocInternalS4Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "internal", scope = DocSect4Type.class)
    public JAXBElement<DocInternalS4Type> createDocSect4TypeInternal(DocInternalS4Type value) {
        return new JAXBElement<DocInternalS4Type>(_DescriptionTypeInternal_QNAME, DocInternalS4Type.class, DocSect4Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocSect4Type.class)
    public JAXBElement<DocParaType> createDocSect4TypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocSect4Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = DocSect4Type.class)
    public JAXBElement<String> createDocSect4TypeTitle(String value) {
        return new JAXBElement<String>(_DescriptionTypeTitle_QNAME, String.class, DocSect4Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocInternalType.class)
    public JAXBElement<DocParaType> createDocInternalTypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocInternalType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSect1Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sect1", scope = DocInternalType.class)
    public JAXBElement<DocSect1Type> createDocInternalTypeSect1(DocSect1Type value) {
        return new JAXBElement<DocSect1Type>(_DescriptionTypeSect1_QNAME, DocSect1Type.class, DocInternalType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocTocListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "toclist", scope = DocParaType.class)
    public JAXBElement<DocTocListType> createDocParaTypeToclist(DocTocListType value) {
        return new JAXBElement<DocTocListType>(_DocMarkupTypeToclist_QNAME, DocTocListType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "programlisting", scope = DocParaType.class)
    public JAXBElement<ListingType> createDocParaTypeProgramlisting(ListingType value) {
        return new JAXBElement<ListingType>(_DocMarkupTypeProgramlisting_QNAME, ListingType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "orderedlist", scope = DocParaType.class)
    public JAXBElement<DocListType> createDocParaTypeOrderedlist(DocListType value) {
        return new JAXBElement<DocListType>(_DocMarkupTypeOrderedlist_QNAME, DocListType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocLanguageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "language", scope = DocParaType.class)
    public JAXBElement<DocLanguageType> createDocParaTypeLanguage(DocLanguageType value) {
        return new JAXBElement<DocLanguageType>(_DocMarkupTypeLanguage_QNAME, DocLanguageType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocVariableListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "variablelist", scope = DocParaType.class)
    public JAXBElement<DocVariableListType> createDocParaTypeVariablelist(DocVariableListType value) {
        return new JAXBElement<DocVariableListType>(_DocMarkupTypeVariablelist_QNAME, DocVariableListType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocParaType.class)
    public JAXBElement<DocURLLink> createDocParaTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "javadocliteral", scope = DocParaType.class)
    public JAXBElement<String> createDocParaTypeJavadocliteral(String value) {
        return new JAXBElement<String>(_DocMarkupTypeJavadocliteral_QNAME, String.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSimpleSectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "simplesect", scope = DocParaType.class)
    public JAXBElement<DocSimpleSectType> createDocParaTypeSimplesect(DocSimpleSectType value) {
        return new JAXBElement<DocSimpleSectType>(_DocMarkupTypeSimplesect_QNAME, DocSimpleSectType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocTitleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = DocParaType.class)
    public JAXBElement<DocTitleType> createDocParaTypeTitle(DocTitleType value) {
        return new JAXBElement<DocTitleType>(_DescriptionTypeTitle_QNAME, DocTitleType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "verbatim", scope = DocParaType.class)
    public JAXBElement<String> createDocParaTypeVerbatim(String value) {
        return new JAXBElement<String>(_DocMarkupTypeVerbatim_QNAME, String.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "diafile", scope = DocParaType.class)
    public JAXBElement<DocImageFileType> createDocParaTypeDiafile(DocImageFileType value) {
        return new JAXBElement<DocImageFileType>(_DocMarkupTypeDiafile_QNAME, DocImageFileType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "javadoccode", scope = DocParaType.class)
    public JAXBElement<String> createDocParaTypeJavadoccode(String value) {
        return new JAXBElement<String>(_DocMarkupTypeJavadoccode_QNAME, String.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocTableType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "table", scope = DocParaType.class)
    public JAXBElement<DocTableType> createDocParaTypeTable(DocTableType value) {
        return new JAXBElement<DocTableType>(_DocMarkupTypeTable_QNAME, DocTableType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mscfile", scope = DocParaType.class)
    public JAXBElement<DocImageFileType> createDocParaTypeMscfile(DocImageFileType value) {
        return new JAXBElement<DocImageFileType>(_DocMarkupTypeMscfile_QNAME, DocImageFileType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocXRefSectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "xrefsect", scope = DocParaType.class)
    public JAXBElement<DocXRefSectType> createDocParaTypeXrefsect(DocXRefSectType value) {
        return new JAXBElement<DocXRefSectType>(_DocMarkupTypeXrefsect_QNAME, DocXRefSectType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocBlockQuoteType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "blockquote", scope = DocParaType.class)
    public JAXBElement<DocBlockQuoteType> createDocParaTypeBlockquote(DocBlockQuoteType value) {
        return new JAXBElement<DocBlockQuoteType>(_DocMarkupTypeBlockquote_QNAME, DocBlockQuoteType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocHeadingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "heading", scope = DocParaType.class)
    public JAXBElement<DocHeadingType> createDocParaTypeHeading(DocHeadingType value) {
        return new JAXBElement<DocHeadingType>(_DocMarkupTypeHeading_QNAME, DocHeadingType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParamListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parameterlist", scope = DocParaType.class)
    public JAXBElement<DocParamListType> createDocParaTypeParameterlist(DocParamListType value) {
        return new JAXBElement<DocParamListType>(_DocMarkupTypeParameterlist_QNAME, DocParamListType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParBlockType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parblock", scope = DocParaType.class)
    public JAXBElement<DocParBlockType> createDocParaTypeParblock(DocParBlockType value) {
        return new JAXBElement<DocParBlockType>(_DocMarkupTypeParblock_QNAME, DocParBlockType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocImageFileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "dotfile", scope = DocParaType.class)
    public JAXBElement<DocImageFileType> createDocParaTypeDotfile(DocImageFileType value) {
        return new JAXBElement<DocImageFileType>(_DocMarkupTypeDotfile_QNAME, DocImageFileType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocCopyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "copydoc", scope = DocParaType.class)
    public JAXBElement<DocCopyType> createDocParaTypeCopydoc(DocCopyType value) {
        return new JAXBElement<DocCopyType>(_DocMarkupTypeCopydoc_QNAME, DocCopyType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocIndexEntryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "indexentry", scope = DocParaType.class)
    public JAXBElement<DocIndexEntryType> createDocParaTypeIndexentry(DocIndexEntryType value) {
        return new JAXBElement<DocIndexEntryType>(_DocMarkupTypeIndexentry_QNAME, DocIndexEntryType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "itemizedlist", scope = DocParaType.class)
    public JAXBElement<DocListType> createDocParaTypeItemizedlist(DocListType value) {
        return new JAXBElement<DocListType>(_DocMarkupTypeItemizedlist_QNAME, DocListType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "hruler", scope = DocParaType.class)
    public JAXBElement<DocEmptyType> createDocParaTypeHruler(DocEmptyType value) {
        return new JAXBElement<DocEmptyType>(_DocMarkupTypeHruler_QNAME, DocEmptyType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "preformatted", scope = DocParaType.class)
    public JAXBElement<DocMarkupType> createDocParaTypePreformatted(DocMarkupType value) {
        return new JAXBElement<DocMarkupType>(_DocMarkupTypePreformatted_QNAME, DocMarkupType.class, DocParaType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocInternalS2Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "internal", scope = DocSect2Type.class)
    public JAXBElement<DocInternalS2Type> createDocSect2TypeInternal(DocInternalS2Type value) {
        return new JAXBElement<DocInternalS2Type>(_DescriptionTypeInternal_QNAME, DocInternalS2Type.class, DocSect2Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocSect3Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sect3", scope = DocSect2Type.class)
    public JAXBElement<DocSect3Type> createDocSect2TypeSect3(DocSect3Type value) {
        return new JAXBElement<DocSect3Type>(_DocInternalS2TypeSect3_QNAME, DocSect3Type.class, DocSect2Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocParaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "para", scope = DocSect2Type.class)
    public JAXBElement<DocParaType> createDocSect2TypePara(DocParaType value) {
        return new JAXBElement<DocParaType>(_DescriptionTypePara_QNAME, DocParaType.class, DocSect2Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = DocSect2Type.class)
    public JAXBElement<String> createDocSect2TypeTitle(String value) {
        return new JAXBElement<String>(_DescriptionTypeTitle_QNAME, String.class, DocSect2Type.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ref", scope = HighlightType.class)
    public JAXBElement<RefTextType> createHighlightTypeRef(RefTextType value) {
        return new JAXBElement<RefTextType>(_DocParamNameRef_QNAME, RefTextType.class, HighlightType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sp", scope = HighlightType.class)
    public JAXBElement<SpType> createHighlightTypeSp(SpType value) {
        return new JAXBElement<SpType>(_HighlightTypeSp_QNAME, SpType.class, HighlightType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ulink", scope = DocDotMscType.class)
    public JAXBElement<DocURLLink> createDocDotMscTypeUlink(DocURLLink value) {
        return new JAXBElement<DocURLLink>(_DocRefTextTypeUlink_QNAME, DocURLLink.class, DocDotMscType.class, value);
    }

}
