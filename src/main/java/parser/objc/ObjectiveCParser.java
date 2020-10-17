package parser.objc;
// Generated from ObjectiveCParser.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ObjectiveCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AUTO=1, BREAK=2, CASE=3, CHAR=4, CONST=5, CONTINUE=6, DEFAULT=7, DO=8, 
		DOUBLE=9, ELSE=10, ENUM=11, EXTERN=12, FLOAT=13, FOR=14, GOTO=15, IF=16, 
		INLINE=17, INT=18, LONG=19, REGISTER=20, RESTRICT=21, RETURN=22, SHORT=23, 
		SIGNED=24, SIZEOF=25, STATIC=26, STRUCT=27, SWITCH=28, TYPEDEF=29, UNION=30, 
		UNSIGNED=31, VOID=32, VOLATILE=33, WHILE=34, BOOL_=35, COMPLEX=36, IMAGINERY=37, 
		TRUE=38, FALSE=39, BOOL=40, Class=41, BYCOPY=42, BYREF=43, ID=44, IMP=45, 
		IN=46, INOUT=47, NIL=48, NO=49, NULL=50, ONEWAY=51, OUT=52, PROTOCOL_=53, 
		SEL=54, SELF=55, SUPER=56, YES=57, AUTORELEASEPOOL=58, CATCH=59, CLASS=60, 
		DYNAMIC=61, ENCODE=62, END=63, FINALLY=64, IMPLEMENTATION=65, INTERFACE=66, 
		IMPORT=67, PACKAGE=68, PROTOCOL=69, OPTIONAL=70, PRIVATE=71, PROPERTY=72, 
		PROTECTED=73, PUBLIC=74, REQUIRED=75, SELECTOR=76, SYNCHRONIZED=77, SYNTHESIZE=78, 
		THROW=79, TRY=80, ATOMIC=81, NONATOMIC=82, RETAIN=83, ATTRIBUTE=84, AUTORELEASING_QUALIFIER=85, 
		BLOCK=86, BRIDGE=87, BRIDGE_RETAINED=88, BRIDGE_TRANSFER=89, COVARIANT=90, 
		CONTRAVARIANT=91, DEPRECATED=92, KINDOF=93, STRONG_QUALIFIER=94, TYPEOF=95, 
		UNSAFE_UNRETAINED_QUALIFIER=96, UNUSED=97, WEAK_QUALIFIER=98, NULL_UNSPECIFIED=99, 
		NULLABLE=100, NONNULL=101, NULL_RESETTABLE=102, NS_INLINE=103, NS_ENUM=104, 
		NS_OPTIONS=105, NS_CLOSED_ENUM=106, NS_TYPED_EXTENSIBLE_ENUM=107, NS_ERROR_ENUM=108, 
		ASSIGN=109, COPY=110, GETTER=111, SETTER=112, STRONG=113, READONLY=114, 
		READWRITE=115, WEAK=116, UNSAFE_UNRETAINED=117, IB_OUTLET=118, IB_OUTLET_COLLECTION=119, 
		IB_INSPECTABLE=120, IB_DESIGNABLE=121, NS_ASSUME_NONNULL_BEGIN=122, NS_ASSUME_NONNULL_END=123, 
		EXTERN_SUFFIX=124, IOS_SUFFIX=125, MAC_SUFFIX=126, TVOS_PROHIBITED=127, 
		NS_NOESCAPE=128, EXPORT_SUFFIX=129, NS_RETURNS_RETAINED=130, NS_RETURNS_NOT_RETAINED=131, 
		NS_RETURNS_INNER_POINTER=132, CF_RETURNS_RETAINED=133, CF_RETURNS_NOT_RETAINED=134, 
		CF_CONSUMED=135, IDENTIFIER=136, LP=137, RP=138, LBRACE=139, RBRACE=140, 
		LBRACK=141, RBRACK=142, SEMI=143, COMMA=144, DOT=145, STRUCTACCESS=146, 
		AT=147, ASSIGNMENT=148, GT=149, LT=150, BANG=151, TILDE=152, QUESTION=153, 
		COLON=154, EQUAL=155, LE=156, GE=157, NOTEQUAL=158, AND=159, OR=160, INC=161, 
		DEC=162, ADD=163, SUB=164, MUL=165, DIV=166, BITAND=167, BITOR=168, BITXOR=169, 
		MOD=170, ADD_ASSIGN=171, SUB_ASSIGN=172, MUL_ASSIGN=173, DIV_ASSIGN=174, 
		AND_ASSIGN=175, OR_ASSIGN=176, XOR_ASSIGN=177, MOD_ASSIGN=178, LSHIFT_ASSIGN=179, 
		RSHIFT_ASSIGN=180, ELIPSIS=181, CHARACTER_LITERAL=182, STRING_START=183, 
		HEX_LITERAL=184, OCTAL_LITERAL=185, BINARY_LITERAL=186, DECIMAL_LITERAL=187, 
		FLOATING_POINT_LITERAL=188, VERSION_SEMATIC=189, WS=190, MULTI_COMMENT=191, 
		SINGLE_COMMENT=192, BACKSLASH=193, SHARP=194, STRING_NEWLINE=195, STRING_END=196, 
		STRING_VALUE=197, DIRECTIVE_IMPORT=198, DIRECTIVE_INCLUDE=199, DIRECTIVE_PRAGMA=200, 
		DIRECTIVE_DEFINE=201, DIRECTIVE_DEFINED=202, DIRECTIVE_IF=203, DIRECTIVE_ELIF=204, 
		DIRECTIVE_ELSE=205, DIRECTIVE_UNDEF=206, DIRECTIVE_IFDEF=207, DIRECTIVE_IFNDEF=208, 
		DIRECTIVE_ENDIF=209, DIRECTIVE_TRUE=210, DIRECTIVE_FALSE=211, DIRECTIVE_ERROR=212, 
		DIRECTIVE_WARNING=213, DIRECTIVE_BANG=214, DIRECTIVE_LP=215, DIRECTIVE_RP=216, 
		DIRECTIVE_EQUAL=217, DIRECTIVE_NOTEQUAL=218, DIRECTIVE_AND=219, DIRECTIVE_OR=220, 
		DIRECTIVE_LT=221, DIRECTIVE_GT=222, DIRECTIVE_LE=223, DIRECTIVE_GE=224, 
		DIRECTIVE_ADD=225, DIRECTIVE_SUB=226, DIRECTIVE_MUL=227, DIRECTIVE_DIV=228, 
		DIRECTIVE_BITAND=229, DIRECTIVE_BITOR=230, DIRECTIVE_BITXOR=231, DIRECTIVE_MOD=232, 
		DIRECTIVE_DOT=233, DIRECTIVE_STRING=234, DIRECTIVE_ID=235, DIRECTIVE_DECIMAL_LITERAL=236, 
		DIRECTIVE_FLOAT=237, DIRECTIVE_NEWLINE=238, DIRECTIVE_MULTI_COMMENT=239, 
		DIRECTIVE_SINGLE_COMMENT=240, DIRECTIVE_BACKSLASH_NEWLINE=241, DIRECTIVE_TEXT_NEWLINE=242, 
		DIRECTIVE_TEXT=243;
	public static final int
		RULE_translationUnit = 0, RULE_topLevelDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_classInterface = 3, RULE_categoryInterface = 4, RULE_classImplementation = 5, 
		RULE_categoryImplementation = 6, RULE_genericTypeSpecifier = 7, RULE_protocolDeclaration = 8, 
		RULE_protocolDeclarationSection = 9, RULE_protocolDeclarationList = 10, 
		RULE_classDeclaration = 11, RULE_classDeclarationList = 12, RULE_protocolList = 13, 
		RULE_propertyDeclaration = 14, RULE_propertyAttributesList = 15, RULE_propertyAttribute = 16, 
		RULE_protocolName = 17, RULE_instanceVariables = 18, RULE_visibilitySection = 19, 
		RULE_accessModifier = 20, RULE_interfaceDeclarationList = 21, RULE_classMethodDeclaration = 22, 
		RULE_instanceMethodDeclaration = 23, RULE_methodDeclaration = 24, RULE_implementationDefinitionList = 25, 
		RULE_classMethodDefinition = 26, RULE_instanceMethodDefinition = 27, RULE_methodDefinition = 28, 
		RULE_methodSelector = 29, RULE_keywordDeclarator = 30, RULE_selector = 31, 
		RULE_methodType = 32, RULE_propertyImplementation = 33, RULE_propertySynthesizeList = 34, 
		RULE_propertySynthesizeItem = 35, RULE_blockType = 36, RULE_genericsSpecifier = 37, 
		RULE_typeSpecifierWithPrefixes = 38, RULE_dictionaryExpression = 39, RULE_dictionaryPair = 40, 
		RULE_arrayExpression = 41, RULE_boxExpression = 42, RULE_blockParameters = 43, 
		RULE_typeVariableDeclaratorOrName = 44, RULE_blockExpression = 45, RULE_messageExpression = 46, 
		RULE_receiver = 47, RULE_messageSelector = 48, RULE_keywordArgument = 49, 
		RULE_keywordArgumentType = 50, RULE_selectorExpression = 51, RULE_selectorName = 52, 
		RULE_protocolExpression = 53, RULE_encodeExpression = 54, RULE_typeVariableDeclarator = 55, 
		RULE_throwStatement = 56, RULE_tryBlock = 57, RULE_catchStatement = 58, 
		RULE_synchronizedStatement = 59, RULE_autoreleaseStatement = 60, RULE_functionDeclaration = 61, 
		RULE_functionDefinition = 62, RULE_functionSignature = 63, RULE_functionPointer = 64, 
		RULE_attribute = 65, RULE_attributeName = 66, RULE_attributeParameters = 67, 
		RULE_attributeParameterList = 68, RULE_attributeParameter = 69, RULE_attributeParameterAssignment = 70, 
		RULE_declaration = 71, RULE_functionCallExpression = 72, RULE_enumDeclaration = 73, 
		RULE_varDeclaration = 74, RULE_typedefDeclaration = 75, RULE_typeDeclaratorList = 76, 
		RULE_typeDeclarator = 77, RULE_commonSpecifiers = 78, RULE_declarationSpecifiers = 79, 
		RULE_pointerQualifier = 80, RULE_attributeSpecifier = 81, RULE_initDeclaratorList = 82, 
		RULE_initDeclarator = 83, RULE_structOrUnionSpecifier = 84, RULE_fieldDeclaration = 85, 
		RULE_specifierQualifierList = 86, RULE_ibOutletQualifier = 87, RULE_arcBehaviourSpecifier = 88, 
		RULE_nullabilitySpecifier = 89, RULE_storageClassSpecifier = 90, RULE_typePrefix = 91, 
		RULE_typeQualifier = 92, RULE_protocolQualifier = 93, RULE_typeSpecifier = 94, 
		RULE_typeofExpression = 95, RULE_fieldDeclaratorList = 96, RULE_fieldDeclarator = 97, 
		RULE_enumSpecifier = 98, RULE_enumeratorList = 99, RULE_enumerator = 100, 
		RULE_enumeratorIdentifier = 101, RULE_directDeclarator = 102, RULE_declaratorSuffix = 103, 
		RULE_parameterList = 104, RULE_pointer = 105, RULE_macro = 106, RULE_arrayInitializer = 107, 
		RULE_structInitializer = 108, RULE_initializerList = 109, RULE_typeName = 110, 
		RULE_abstractDeclarator = 111, RULE_abstractDeclaratorSuffix = 112, RULE_parameterDeclarationList = 113, 
		RULE_parameterDeclaration = 114, RULE_declarator = 115, RULE_statement = 116, 
		RULE_labeledStatement = 117, RULE_rangeExpression = 118, RULE_compoundStatement = 119, 
		RULE_selectionStatement = 120, RULE_switchStatement = 121, RULE_switchBlock = 122, 
		RULE_switchSection = 123, RULE_switchLabel = 124, RULE_iterationStatement = 125, 
		RULE_whileStatement = 126, RULE_doStatement = 127, RULE_forStatement = 128, 
		RULE_forLoopInitializer = 129, RULE_forInStatement = 130, RULE_jumpStatement = 131, 
		RULE_expressions = 132, RULE_expression = 133, RULE_assignmentOperator = 134, 
		RULE_castExpression = 135, RULE_initializer = 136, RULE_constantExpression = 137, 
		RULE_unaryExpression = 138, RULE_unaryOperator = 139, RULE_postfixExpression = 140, 
		RULE_postfix = 141, RULE_argumentExpressionList = 142, RULE_argumentExpression = 143, 
		RULE_osVersion = 144, RULE_primaryExpression = 145, RULE_constant = 146, 
		RULE_stringLiteral = 147, RULE_identifier = 148;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "topLevelDeclaration", "importDeclaration", "classInterface", 
			"categoryInterface", "classImplementation", "categoryImplementation", 
			"genericTypeSpecifier", "protocolDeclaration", "protocolDeclarationSection", 
			"protocolDeclarationList", "classDeclaration", "classDeclarationList", 
			"protocolList", "propertyDeclaration", "propertyAttributesList", "propertyAttribute", 
			"protocolName", "instanceVariables", "visibilitySection", "accessModifier", 
			"interfaceDeclarationList", "classMethodDeclaration", "instanceMethodDeclaration", 
			"methodDeclaration", "implementationDefinitionList", "classMethodDefinition", 
			"instanceMethodDefinition", "methodDefinition", "methodSelector", "keywordDeclarator", 
			"selector", "methodType", "propertyImplementation", "propertySynthesizeList", 
			"propertySynthesizeItem", "blockType", "genericsSpecifier", "typeSpecifierWithPrefixes", 
			"dictionaryExpression", "dictionaryPair", "arrayExpression", "boxExpression", 
			"blockParameters", "typeVariableDeclaratorOrName", "blockExpression", 
			"messageExpression", "receiver", "messageSelector", "keywordArgument", 
			"keywordArgumentType", "selectorExpression", "selectorName", "protocolExpression", 
			"encodeExpression", "typeVariableDeclarator", "throwStatement", "tryBlock", 
			"catchStatement", "synchronizedStatement", "autoreleaseStatement", "functionDeclaration", 
			"functionDefinition", "functionSignature", "functionPointer", "attribute", 
			"attributeName", "attributeParameters", "attributeParameterList", "attributeParameter", 
			"attributeParameterAssignment", "declaration", "functionCallExpression", 
			"enumDeclaration", "varDeclaration", "typedefDeclaration", "typeDeclaratorList", 
			"typeDeclarator", "commonSpecifiers", "declarationSpecifiers", "pointerQualifier", 
			"attributeSpecifier", "initDeclaratorList", "initDeclarator", "structOrUnionSpecifier", 
			"fieldDeclaration", "specifierQualifierList", "ibOutletQualifier", "arcBehaviourSpecifier", 
			"nullabilitySpecifier", "storageClassSpecifier", "typePrefix", "typeQualifier", 
			"protocolQualifier", "typeSpecifier", "typeofExpression", "fieldDeclaratorList", 
			"fieldDeclarator", "enumSpecifier", "enumeratorList", "enumerator", "enumeratorIdentifier", 
			"directDeclarator", "declaratorSuffix", "parameterList", "pointer", "macro", 
			"arrayInitializer", "structInitializer", "initializerList", "typeName", 
			"abstractDeclarator", "abstractDeclaratorSuffix", "parameterDeclarationList", 
			"parameterDeclaration", "declarator", "statement", "labeledStatement", 
			"rangeExpression", "compoundStatement", "selectionStatement", "switchStatement", 
			"switchBlock", "switchSection", "switchLabel", "iterationStatement", 
			"whileStatement", "doStatement", "forStatement", "forLoopInitializer", 
			"forInStatement", "jumpStatement", "expressions", "expression", "assignmentOperator", 
			"castExpression", "initializer", "constantExpression", "unaryExpression", 
			"unaryOperator", "postfixExpression", "postfix", "argumentExpressionList", 
			"argumentExpression", "osVersion", "primaryExpression", "constant", "stringLiteral", 
			"identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'auto'", "'break'", "'case'", "'char'", "'const'", "'continue'", 
			"'default'", "'do'", "'double'", null, "'enum'", "'extern'", "'float'", 
			"'for'", "'goto'", null, "'inline'", "'int'", "'long'", "'register'", 
			"'restrict'", "'return'", "'short'", "'signed'", "'sizeof'", "'static'", 
			"'struct'", "'switch'", "'typedef'", "'union'", "'unsigned'", "'void'", 
			"'volatile'", "'while'", "'_Bool'", "'_Complex'", "'_Imaginery'", "'true'", 
			"'false'", "'BOOL'", "'Class'", "'bycopy'", "'byref'", "'id'", "'IMP'", 
			"'in'", "'inout'", "'nil'", "'NO'", "'NULL'", "'oneway'", "'out'", "'Protocol'", 
			"'SEL'", "'self'", "'super'", "'YES'", "'@autoreleasepool'", "'@catch'", 
			"'@class'", "'@dynamic'", "'@encode'", "'@end'", "'@finally'", "'@implementation'", 
			"'@interface'", null, "'@package'", "'@protocol'", "'@optional'", "'@private'", 
			"'@property'", "'@protected'", "'@public'", "'@required'", "'@selector'", 
			"'@synchronized'", "'@synthesize'", "'@throw'", "'@try'", "'atomic'", 
			"'nonatomic'", "'retain'", "'__attribute__'", "'__autoreleasing'", "'__block'", 
			"'__bridge'", "'__bridge_retained'", "'__bridge_transfer'", "'__covariant'", 
			"'__contravariant'", "'__deprecated'", "'__kindof'", "'__strong'", null, 
			"'__unsafe_unretained'", "'__unused'", "'__weak'", null, null, null, 
			"'null_resettable'", "'NS_INLINE'", "'NS_ENUM'", "'NS_OPTIONS'", "'NS_CLOSED_ENUM'", 
			"'NS_TYPED_EXTENSIBLE_ENUM'", "'NS_ERROR_ENUM'", "'assign'", "'copy'", 
			"'getter'", "'setter'", "'strong'", "'readonly'", "'readwrite'", "'weak'", 
			"'unsafe_unretained'", "'IBOutlet'", "'IBOutletCollection'", "'IBInspectable'", 
			"'IB_DESIGNABLE'", null, null, null, null, null, "'__TVOS_PROHIBITED'", 
			"'NS_NOESCAPE'", null, "'NS_RETURNS_RETAINED'", "'NS_RETURNS_NOT_RETAINED'", 
			"'NS_RETURNS_INNER_POINTER'", "'CF_RETURNS_RETAINED'", "'CF_RETURNS_NOT_RETAINED'", 
			"'CF_CONSUMED'", null, null, null, "'{'", "'}'", "'['", "']'", "';'", 
			"','", null, "'->'", "'@'", "'='", null, null, null, "'~'", "'?'", "':'", 
			null, null, null, null, null, null, "'++'", "'--'", null, null, null, 
			null, null, null, null, null, "'+='", "'-='", "'*='", "'/='", "'&='", 
			"'|='", "'^='", "'%='", "'<<='", "'>>='", "'...'", null, null, null, 
			null, null, null, null, null, null, null, null, "'\\'", null, null, null, 
			null, null, null, null, null, "'defined'", null, "'elif'", null, "'undef'", 
			"'ifdef'", "'ifndef'", "'endif'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AUTO", "BREAK", "CASE", "CHAR", "CONST", "CONTINUE", "DEFAULT", 
			"DO", "DOUBLE", "ELSE", "ENUM", "EXTERN", "FLOAT", "FOR", "GOTO", "IF", 
			"INLINE", "INT", "LONG", "REGISTER", "RESTRICT", "RETURN", "SHORT", "SIGNED", 
			"SIZEOF", "STATIC", "STRUCT", "SWITCH", "TYPEDEF", "UNION", "UNSIGNED", 
			"VOID", "VOLATILE", "WHILE", "BOOL_", "COMPLEX", "IMAGINERY", "TRUE", 
			"FALSE", "BOOL", "Class", "BYCOPY", "BYREF", "ID", "IMP", "IN", "INOUT", 
			"NIL", "NO", "NULL", "ONEWAY", "OUT", "PROTOCOL_", "SEL", "SELF", "SUPER", 
			"YES", "AUTORELEASEPOOL", "CATCH", "CLASS", "DYNAMIC", "ENCODE", "END", 
			"FINALLY", "IMPLEMENTATION", "INTERFACE", "IMPORT", "PACKAGE", "PROTOCOL", 
			"OPTIONAL", "PRIVATE", "PROPERTY", "PROTECTED", "PUBLIC", "REQUIRED", 
			"SELECTOR", "SYNCHRONIZED", "SYNTHESIZE", "THROW", "TRY", "ATOMIC", "NONATOMIC", 
			"RETAIN", "ATTRIBUTE", "AUTORELEASING_QUALIFIER", "BLOCK", "BRIDGE", 
			"BRIDGE_RETAINED", "BRIDGE_TRANSFER", "COVARIANT", "CONTRAVARIANT", "DEPRECATED", 
			"KINDOF", "STRONG_QUALIFIER", "TYPEOF", "UNSAFE_UNRETAINED_QUALIFIER", 
			"UNUSED", "WEAK_QUALIFIER", "NULL_UNSPECIFIED", "NULLABLE", "NONNULL", 
			"NULL_RESETTABLE", "NS_INLINE", "NS_ENUM", "NS_OPTIONS", "NS_CLOSED_ENUM", 
			"NS_TYPED_EXTENSIBLE_ENUM", "NS_ERROR_ENUM", "ASSIGN", "COPY", "GETTER", 
			"SETTER", "STRONG", "READONLY", "READWRITE", "WEAK", "UNSAFE_UNRETAINED", 
			"IB_OUTLET", "IB_OUTLET_COLLECTION", "IB_INSPECTABLE", "IB_DESIGNABLE", 
			"NS_ASSUME_NONNULL_BEGIN", "NS_ASSUME_NONNULL_END", "EXTERN_SUFFIX", 
			"IOS_SUFFIX", "MAC_SUFFIX", "TVOS_PROHIBITED", "NS_NOESCAPE", "EXPORT_SUFFIX", 
			"NS_RETURNS_RETAINED", "NS_RETURNS_NOT_RETAINED", "NS_RETURNS_INNER_POINTER", 
			"CF_RETURNS_RETAINED", "CF_RETURNS_NOT_RETAINED", "CF_CONSUMED", "IDENTIFIER", 
			"LP", "RP", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
			"DOT", "STRUCTACCESS", "AT", "ASSIGNMENT", "GT", "LT", "BANG", "TILDE", 
			"QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
			"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "BITXOR", "MOD", 
			"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", 
			"OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", 
			"ELIPSIS", "CHARACTER_LITERAL", "STRING_START", "HEX_LITERAL", "OCTAL_LITERAL", 
			"BINARY_LITERAL", "DECIMAL_LITERAL", "FLOATING_POINT_LITERAL", "VERSION_SEMATIC", 
			"WS", "MULTI_COMMENT", "SINGLE_COMMENT", "BACKSLASH", "SHARP", "STRING_NEWLINE", 
			"STRING_END", "STRING_VALUE", "DIRECTIVE_IMPORT", "DIRECTIVE_INCLUDE", 
			"DIRECTIVE_PRAGMA", "DIRECTIVE_DEFINE", "DIRECTIVE_DEFINED", "DIRECTIVE_IF", 
			"DIRECTIVE_ELIF", "DIRECTIVE_ELSE", "DIRECTIVE_UNDEF", "DIRECTIVE_IFDEF", 
			"DIRECTIVE_IFNDEF", "DIRECTIVE_ENDIF", "DIRECTIVE_TRUE", "DIRECTIVE_FALSE", 
			"DIRECTIVE_ERROR", "DIRECTIVE_WARNING", "DIRECTIVE_BANG", "DIRECTIVE_LP", 
			"DIRECTIVE_RP", "DIRECTIVE_EQUAL", "DIRECTIVE_NOTEQUAL", "DIRECTIVE_AND", 
			"DIRECTIVE_OR", "DIRECTIVE_LT", "DIRECTIVE_GT", "DIRECTIVE_LE", "DIRECTIVE_GE", 
			"DIRECTIVE_ADD", "DIRECTIVE_SUB", "DIRECTIVE_MUL", "DIRECTIVE_DIV", "DIRECTIVE_BITAND", 
			"DIRECTIVE_BITOR", "DIRECTIVE_BITXOR", "DIRECTIVE_MOD", "DIRECTIVE_DOT", 
			"DIRECTIVE_STRING", "DIRECTIVE_ID", "DIRECTIVE_DECIMAL_LITERAL", "DIRECTIVE_FLOAT", 
			"DIRECTIVE_NEWLINE", "DIRECTIVE_MULTI_COMMENT", "DIRECTIVE_SINGLE_COMMENT", 
			"DIRECTIVE_BACKSLASH_NEWLINE", "DIRECTIVE_TEXT_NEWLINE", "DIRECTIVE_TEXT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ObjectiveCParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ObjectiveCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TranslationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ObjectiveCParser.EOF, 0); }
		public List<TopLevelDeclarationContext> topLevelDeclaration() {
			return getRuleContexts(TopLevelDeclarationContext.class);
		}
		public TopLevelDeclarationContext topLevelDeclaration(int i) {
			return getRuleContext(TopLevelDeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTranslationUnit(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << CLASS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (IMPLEMENTATION - 65)) | (1L << (INTERFACE - 65)) | (1L << (IMPORT - 65)) | (1L << (PROTOCOL - 65)) | (1L << (ATOMIC - 65)) | (1L << (NONATOMIC - 65)) | (1L << (RETAIN - 65)) | (1L << (ATTRIBUTE - 65)) | (1L << (AUTORELEASING_QUALIFIER - 65)) | (1L << (BLOCK - 65)) | (1L << (BRIDGE - 65)) | (1L << (BRIDGE_RETAINED - 65)) | (1L << (BRIDGE_TRANSFER - 65)) | (1L << (COVARIANT - 65)) | (1L << (CONTRAVARIANT - 65)) | (1L << (DEPRECATED - 65)) | (1L << (KINDOF - 65)) | (1L << (STRONG_QUALIFIER - 65)) | (1L << (TYPEOF - 65)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 65)) | (1L << (UNUSED - 65)) | (1L << (WEAK_QUALIFIER - 65)) | (1L << (NULL_UNSPECIFIED - 65)) | (1L << (NULLABLE - 65)) | (1L << (NONNULL - 65)) | (1L << (NULL_RESETTABLE - 65)) | (1L << (NS_INLINE - 65)) | (1L << (NS_ENUM - 65)) | (1L << (NS_OPTIONS - 65)) | (1L << (NS_CLOSED_ENUM - 65)) | (1L << (NS_ERROR_ENUM - 65)) | (1L << (ASSIGN - 65)) | (1L << (COPY - 65)) | (1L << (GETTER - 65)) | (1L << (SETTER - 65)) | (1L << (STRONG - 65)) | (1L << (READONLY - 65)) | (1L << (READWRITE - 65)) | (1L << (WEAK - 65)) | (1L << (UNSAFE_UNRETAINED - 65)) | (1L << (IB_OUTLET - 65)) | (1L << (IB_OUTLET_COLLECTION - 65)) | (1L << (IB_INSPECTABLE - 65)) | (1L << (IB_DESIGNABLE - 65)))) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(298);
				topLevelDeclaration();
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(304);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopLevelDeclarationContext extends ParserRuleContext {
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ClassInterfaceContext classInterface() {
			return getRuleContext(ClassInterfaceContext.class,0);
		}
		public ClassImplementationContext classImplementation() {
			return getRuleContext(ClassImplementationContext.class,0);
		}
		public CategoryInterfaceContext categoryInterface() {
			return getRuleContext(CategoryInterfaceContext.class,0);
		}
		public CategoryImplementationContext categoryImplementation() {
			return getRuleContext(CategoryImplementationContext.class,0);
		}
		public ProtocolDeclarationContext protocolDeclaration() {
			return getRuleContext(ProtocolDeclarationContext.class,0);
		}
		public ProtocolDeclarationListContext protocolDeclarationList() {
			return getRuleContext(ProtocolDeclarationListContext.class,0);
		}
		public ClassDeclarationListContext classDeclarationList() {
			return getRuleContext(ClassDeclarationListContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public TopLevelDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTopLevelDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTopLevelDeclaration(this);
		}
	}

	public final TopLevelDeclarationContext topLevelDeclaration() throws RecognitionException {
		TopLevelDeclarationContext _localctx = new TopLevelDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDeclaration);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				importDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(308);
				declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(309);
				classInterface();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(310);
				classImplementation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(311);
				categoryInterface();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(312);
				categoryImplementation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(313);
				protocolDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(314);
				protocolDeclarationList();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(315);
				classDeclarationList();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(316);
				functionDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public IdentifierContext frameworkName;
		public IdentifierContext headerName;
		public TerminalNode IMPORT() { return getToken(ObjectiveCParser.IMPORT, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public TerminalNode DOT() { return getToken(ObjectiveCParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ObjectiveCParser.IDENTIFIER, 0); }
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode DIV() { return getToken(ObjectiveCParser.DIV, 0); }
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitImportDeclaration(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(IMPORT);
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				{
				{
				setState(320);
				((ImportDeclarationContext)_localctx).frameworkName = identifier();
				setState(321);
				match(SEMI);
				}
				}
				break;
			case LT:
				{
				{
				setState(323);
				match(LT);
				setState(325);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(324);
					((ImportDeclarationContext)_localctx).frameworkName = identifier();
					}
					break;
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DIV) {
					{
					setState(327);
					match(DIV);
					}
				}

				setState(330);
				((ImportDeclarationContext)_localctx).headerName = identifier();
				setState(331);
				match(DOT);
				setState(332);
				match(IDENTIFIER);
				setState(333);
				match(GT);
				}
				}
				break;
			case STRING_START:
				{
				setState(335);
				stringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInterfaceContext extends ParserRuleContext {
		public GenericTypeSpecifierContext className;
		public IdentifierContext superclassName;
		public ProtocolListContext protocols;
		public TerminalNode INTERFACE() { return getToken(ObjectiveCParser.INTERFACE, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public TerminalNode IB_DESIGNABLE() { return getToken(ObjectiveCParser.IB_DESIGNABLE, 0); }
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public InstanceVariablesContext instanceVariables() {
			return getRuleContext(InstanceVariablesContext.class,0);
		}
		public InterfaceDeclarationListContext interfaceDeclarationList() {
			return getRuleContext(InterfaceDeclarationListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public ClassInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassInterface(this);
		}
	}

	public final ClassInterfaceContext classInterface() throws RecognitionException {
		ClassInterfaceContext _localctx = new ClassInterfaceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(338);
				match(IB_DESIGNABLE);
				}
				break;
			}
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(343);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(341);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(342);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(348);
			match(INTERFACE);
			setState(349);
			((ClassInterfaceContext)_localctx).className = genericTypeSpecifier();
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(350);
				match(COLON);
				setState(351);
				((ClassInterfaceContext)_localctx).superclassName = identifier();
				}
			}

			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(354);
				match(LT);
				setState(355);
				((ClassInterfaceContext)_localctx).protocols = protocolList();
				setState(356);
				match(GT);
				}
			}

			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(360);
				instanceVariables();
				}
			}

			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (PROPERTY - 72)) | (1L << (ATOMIC - 72)) | (1L << (NONATOMIC - 72)) | (1L << (RETAIN - 72)) | (1L << (ATTRIBUTE - 72)) | (1L << (AUTORELEASING_QUALIFIER - 72)) | (1L << (BLOCK - 72)) | (1L << (BRIDGE - 72)) | (1L << (BRIDGE_RETAINED - 72)) | (1L << (BRIDGE_TRANSFER - 72)) | (1L << (COVARIANT - 72)) | (1L << (CONTRAVARIANT - 72)) | (1L << (DEPRECATED - 72)) | (1L << (KINDOF - 72)) | (1L << (STRONG_QUALIFIER - 72)) | (1L << (TYPEOF - 72)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 72)) | (1L << (UNUSED - 72)) | (1L << (WEAK_QUALIFIER - 72)) | (1L << (NULL_UNSPECIFIED - 72)) | (1L << (NULLABLE - 72)) | (1L << (NONNULL - 72)) | (1L << (NULL_RESETTABLE - 72)) | (1L << (NS_INLINE - 72)) | (1L << (NS_ENUM - 72)) | (1L << (NS_OPTIONS - 72)) | (1L << (NS_CLOSED_ENUM - 72)) | (1L << (NS_ERROR_ENUM - 72)) | (1L << (ASSIGN - 72)) | (1L << (COPY - 72)) | (1L << (GETTER - 72)) | (1L << (SETTER - 72)) | (1L << (STRONG - 72)) | (1L << (READONLY - 72)) | (1L << (READWRITE - 72)) | (1L << (WEAK - 72)) | (1L << (UNSAFE_UNRETAINED - 72)) | (1L << (IB_OUTLET - 72)) | (1L << (IB_OUTLET_COLLECTION - 72)) | (1L << (IB_INSPECTABLE - 72)) | (1L << (IB_DESIGNABLE - 72)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)))) != 0)) {
				{
				setState(363);
				interfaceDeclarationList();
				}
			}

			setState(366);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CategoryInterfaceContext extends ParserRuleContext {
		public GenericTypeSpecifierContext className;
		public IdentifierContext categoryName;
		public ProtocolListContext protocols;
		public TerminalNode INTERFACE() { return getToken(ObjectiveCParser.INTERFACE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public InstanceVariablesContext instanceVariables() {
			return getRuleContext(InstanceVariablesContext.class,0);
		}
		public InterfaceDeclarationListContext interfaceDeclarationList() {
			return getRuleContext(InterfaceDeclarationListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public CategoryInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_categoryInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCategoryInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCategoryInterface(this);
		}
	}

	public final CategoryInterfaceContext categoryInterface() throws RecognitionException {
		CategoryInterfaceContext _localctx = new CategoryInterfaceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_categoryInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(370);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(368);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(369);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(375);
			match(INTERFACE);
			setState(376);
			((CategoryInterfaceContext)_localctx).className = genericTypeSpecifier();
			setState(377);
			match(LP);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(378);
				((CategoryInterfaceContext)_localctx).categoryName = identifier();
				}
			}

			setState(381);
			match(RP);
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(382);
				match(LT);
				setState(383);
				((CategoryInterfaceContext)_localctx).protocols = protocolList();
				setState(384);
				match(GT);
				}
			}

			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(388);
				instanceVariables();
				}
			}

			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (PROPERTY - 72)) | (1L << (ATOMIC - 72)) | (1L << (NONATOMIC - 72)) | (1L << (RETAIN - 72)) | (1L << (ATTRIBUTE - 72)) | (1L << (AUTORELEASING_QUALIFIER - 72)) | (1L << (BLOCK - 72)) | (1L << (BRIDGE - 72)) | (1L << (BRIDGE_RETAINED - 72)) | (1L << (BRIDGE_TRANSFER - 72)) | (1L << (COVARIANT - 72)) | (1L << (CONTRAVARIANT - 72)) | (1L << (DEPRECATED - 72)) | (1L << (KINDOF - 72)) | (1L << (STRONG_QUALIFIER - 72)) | (1L << (TYPEOF - 72)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 72)) | (1L << (UNUSED - 72)) | (1L << (WEAK_QUALIFIER - 72)) | (1L << (NULL_UNSPECIFIED - 72)) | (1L << (NULLABLE - 72)) | (1L << (NONNULL - 72)) | (1L << (NULL_RESETTABLE - 72)) | (1L << (NS_INLINE - 72)) | (1L << (NS_ENUM - 72)) | (1L << (NS_OPTIONS - 72)) | (1L << (NS_CLOSED_ENUM - 72)) | (1L << (NS_ERROR_ENUM - 72)) | (1L << (ASSIGN - 72)) | (1L << (COPY - 72)) | (1L << (GETTER - 72)) | (1L << (SETTER - 72)) | (1L << (STRONG - 72)) | (1L << (READONLY - 72)) | (1L << (READWRITE - 72)) | (1L << (WEAK - 72)) | (1L << (UNSAFE_UNRETAINED - 72)) | (1L << (IB_OUTLET - 72)) | (1L << (IB_OUTLET_COLLECTION - 72)) | (1L << (IB_INSPECTABLE - 72)) | (1L << (IB_DESIGNABLE - 72)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)))) != 0)) {
				{
				setState(391);
				interfaceDeclarationList();
				}
			}

			setState(394);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassImplementationContext extends ParserRuleContext {
		public GenericTypeSpecifierContext className;
		public IdentifierContext superclassName;
		public TerminalNode IMPLEMENTATION() { return getToken(ObjectiveCParser.IMPLEMENTATION, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public InstanceVariablesContext instanceVariables() {
			return getRuleContext(InstanceVariablesContext.class,0);
		}
		public ImplementationDefinitionListContext implementationDefinitionList() {
			return getRuleContext(ImplementationDefinitionListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classImplementation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassImplementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassImplementation(this);
		}
	}

	public final ClassImplementationContext classImplementation() throws RecognitionException {
		ClassImplementationContext _localctx = new ClassImplementationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classImplementation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(IMPLEMENTATION);
			setState(397);
			((ClassImplementationContext)_localctx).className = genericTypeSpecifier();
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(398);
				match(COLON);
				setState(399);
				((ClassImplementationContext)_localctx).superclassName = identifier();
				}
			}

			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(402);
				instanceVariables();
				}
			}

			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (NS_CLOSED_ENUM - 78)) | (1L << (NS_ERROR_ENUM - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(405);
				implementationDefinitionList();
				}
			}

			setState(408);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CategoryImplementationContext extends ParserRuleContext {
		public GenericTypeSpecifierContext className;
		public IdentifierContext categoryName;
		public TerminalNode IMPLEMENTATION() { return getToken(ObjectiveCParser.IMPLEMENTATION, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImplementationDefinitionListContext implementationDefinitionList() {
			return getRuleContext(ImplementationDefinitionListContext.class,0);
		}
		public CategoryImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_categoryImplementation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCategoryImplementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCategoryImplementation(this);
		}
	}

	public final CategoryImplementationContext categoryImplementation() throws RecognitionException {
		CategoryImplementationContext _localctx = new CategoryImplementationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_categoryImplementation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(IMPLEMENTATION);
			setState(411);
			((CategoryImplementationContext)_localctx).className = genericTypeSpecifier();
			setState(412);
			match(LP);
			setState(413);
			((CategoryImplementationContext)_localctx).categoryName = identifier();
			setState(414);
			match(RP);
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (NS_CLOSED_ENUM - 78)) | (1L << (NS_ERROR_ENUM - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(415);
				implementationDefinitionList();
				}
			}

			setState(418);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericTypeSpecifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GenericsSpecifierContext genericsSpecifier() {
			return getRuleContext(GenericsSpecifierContext.class,0);
		}
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public GenericTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterGenericTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitGenericTypeSpecifier(this);
		}
	}

	public final GenericTypeSpecifierContext genericTypeSpecifier() throws RecognitionException {
		GenericTypeSpecifierContext _localctx = new GenericTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_genericTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			identifier();
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				{
				setState(421);
				match(LT);
				setState(422);
				protocolList();
				setState(423);
				match(GT);
				}
				}
				break;
			case 2:
				{
				setState(425);
				genericsSpecifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolDeclarationContext extends ParserRuleContext {
		public ProtocolNameContext name;
		public ProtocolListContext protocols;
		public TerminalNode PROTOCOL() { return getToken(ObjectiveCParser.PROTOCOL, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public ProtocolNameContext protocolName() {
			return getRuleContext(ProtocolNameContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public List<ProtocolDeclarationSectionContext> protocolDeclarationSection() {
			return getRuleContexts(ProtocolDeclarationSectionContext.class);
		}
		public ProtocolDeclarationSectionContext protocolDeclarationSection(int i) {
			return getRuleContext(ProtocolDeclarationSectionContext.class,i);
		}
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public ProtocolDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolDeclaration(this);
		}
	}

	public final ProtocolDeclarationContext protocolDeclaration() throws RecognitionException {
		ProtocolDeclarationContext _localctx = new ProtocolDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_protocolDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(430);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(428);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(429);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(435);
			match(PROTOCOL);
			setState(436);
			((ProtocolDeclarationContext)_localctx).name = protocolName();
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(437);
				match(LT);
				setState(438);
				((ProtocolDeclarationContext)_localctx).protocols = protocolList();
				setState(439);
				match(GT);
				}
			}

			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (OPTIONAL - 70)) | (1L << (PROPERTY - 70)) | (1L << (REQUIRED - 70)) | (1L << (ATOMIC - 70)) | (1L << (NONATOMIC - 70)) | (1L << (RETAIN - 70)) | (1L << (ATTRIBUTE - 70)) | (1L << (AUTORELEASING_QUALIFIER - 70)) | (1L << (BLOCK - 70)) | (1L << (BRIDGE - 70)) | (1L << (BRIDGE_RETAINED - 70)) | (1L << (BRIDGE_TRANSFER - 70)) | (1L << (COVARIANT - 70)) | (1L << (CONTRAVARIANT - 70)) | (1L << (DEPRECATED - 70)) | (1L << (KINDOF - 70)) | (1L << (STRONG_QUALIFIER - 70)) | (1L << (TYPEOF - 70)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 70)) | (1L << (UNUSED - 70)) | (1L << (WEAK_QUALIFIER - 70)) | (1L << (NULL_UNSPECIFIED - 70)) | (1L << (NULLABLE - 70)) | (1L << (NONNULL - 70)) | (1L << (NULL_RESETTABLE - 70)) | (1L << (NS_INLINE - 70)) | (1L << (NS_ENUM - 70)) | (1L << (NS_OPTIONS - 70)) | (1L << (NS_CLOSED_ENUM - 70)) | (1L << (NS_ERROR_ENUM - 70)) | (1L << (ASSIGN - 70)) | (1L << (COPY - 70)) | (1L << (GETTER - 70)) | (1L << (SETTER - 70)) | (1L << (STRONG - 70)) | (1L << (READONLY - 70)) | (1L << (READWRITE - 70)) | (1L << (WEAK - 70)) | (1L << (UNSAFE_UNRETAINED - 70)) | (1L << (IB_OUTLET - 70)) | (1L << (IB_OUTLET_COLLECTION - 70)) | (1L << (IB_INSPECTABLE - 70)) | (1L << (IB_DESIGNABLE - 70)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)))) != 0)) {
				{
				{
				setState(443);
				protocolDeclarationSection();
				}
				}
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(449);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolDeclarationSectionContext extends ParserRuleContext {
		public Token modifier;
		public TerminalNode REQUIRED() { return getToken(ObjectiveCParser.REQUIRED, 0); }
		public TerminalNode OPTIONAL() { return getToken(ObjectiveCParser.OPTIONAL, 0); }
		public List<InterfaceDeclarationListContext> interfaceDeclarationList() {
			return getRuleContexts(InterfaceDeclarationListContext.class);
		}
		public InterfaceDeclarationListContext interfaceDeclarationList(int i) {
			return getRuleContext(InterfaceDeclarationListContext.class,i);
		}
		public ProtocolDeclarationSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolDeclarationSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolDeclarationSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolDeclarationSection(this);
		}
	}

	public final ProtocolDeclarationSectionContext protocolDeclarationSection() throws RecognitionException {
		ProtocolDeclarationSectionContext _localctx = new ProtocolDeclarationSectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_protocolDeclarationSection);
		int _la;
		try {
			int _alt;
			setState(463);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONAL:
			case REQUIRED:
				enterOuterAlt(_localctx, 1);
				{
				setState(451);
				((ProtocolDeclarationSectionContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OPTIONAL || _la==REQUIRED) ) {
					((ProtocolDeclarationSectionContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(455);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(452);
						interfaceDeclarationList();
						}
						} 
					}
					setState(457);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			case AUTO:
			case CHAR:
			case CONST:
			case DOUBLE:
			case ENUM:
			case EXTERN:
			case FLOAT:
			case INLINE:
			case INT:
			case LONG:
			case REGISTER:
			case RESTRICT:
			case SHORT:
			case SIGNED:
			case STATIC:
			case STRUCT:
			case TYPEDEF:
			case UNION:
			case UNSIGNED:
			case VOID:
			case VOLATILE:
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case PROPERTY:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case ATTRIBUTE:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case STRONG_QUALIFIER:
			case TYPEOF:
			case UNSAFE_UNRETAINED_QUALIFIER:
			case UNUSED:
			case WEAK_QUALIFIER:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case NS_CLOSED_ENUM:
			case NS_ERROR_ENUM:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(459); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(458);
						interfaceDeclarationList();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(461); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolDeclarationListContext extends ParserRuleContext {
		public TerminalNode PROTOCOL() { return getToken(ObjectiveCParser.PROTOCOL, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public ProtocolDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolDeclarationList(this);
		}
	}

	public final ProtocolDeclarationListContext protocolDeclarationList() throws RecognitionException {
		ProtocolDeclarationListContext _localctx = new ProtocolDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_protocolDeclarationList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(PROTOCOL);
			setState(466);
			protocolList();
			setState(467);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			identifier();
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(470);
				match(LT);
				setState(471);
				protocolList();
				setState(472);
				match(GT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationListContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(ObjectiveCParser.CLASS, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ClassDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassDeclarationList(this);
		}
	}

	public final ClassDeclarationListContext classDeclarationList() throws RecognitionException {
		ClassDeclarationListContext _localctx = new ClassDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(CLASS);
			setState(477);
			classDeclaration();
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(478);
				match(COMMA);
				setState(479);
				classDeclaration();
				}
				}
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(485);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolListContext extends ParserRuleContext {
		public ProtocolNameContext protocolName;
		public List<ProtocolNameContext> list = new ArrayList<ProtocolNameContext>();
		public List<ProtocolNameContext> protocolName() {
			return getRuleContexts(ProtocolNameContext.class);
		}
		public ProtocolNameContext protocolName(int i) {
			return getRuleContext(ProtocolNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ProtocolListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolList(this);
		}
	}

	public final ProtocolListContext protocolList() throws RecognitionException {
		ProtocolListContext _localctx = new ProtocolListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_protocolList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			((ProtocolListContext)_localctx).protocolName = protocolName();
			((ProtocolListContext)_localctx).list.add(((ProtocolListContext)_localctx).protocolName);
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(488);
				match(COMMA);
				setState(489);
				((ProtocolListContext)_localctx).protocolName = protocolName();
				((ProtocolListContext)_localctx).list.add(((ProtocolListContext)_localctx).protocolName);
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyDeclarationContext extends ParserRuleContext {
		public TerminalNode PROPERTY() { return getToken(ObjectiveCParser.PROPERTY, 0); }
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public PropertyAttributesListContext propertyAttributesList() {
			return getRuleContext(PropertyAttributesListContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public IbOutletQualifierContext ibOutletQualifier() {
			return getRuleContext(IbOutletQualifierContext.class,0);
		}
		public TerminalNode IB_INSPECTABLE() { return getToken(ObjectiveCParser.IB_INSPECTABLE, 0); }
		public PropertyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertyDeclaration(this);
		}
	}

	public final PropertyDeclarationContext propertyDeclaration() throws RecognitionException {
		PropertyDeclarationContext _localctx = new PropertyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propertyDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(PROPERTY);
			setState(500);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(496);
				match(LP);
				setState(497);
				propertyAttributesList();
				setState(498);
				match(RP);
				}
				break;
			}
			setState(503);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(502);
				ibOutletQualifier();
				}
				break;
			}
			setState(506);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(505);
				match(IB_INSPECTABLE);
				}
				break;
			}
			setState(508);
			fieldDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyAttributesListContext extends ParserRuleContext {
		public List<PropertyAttributeContext> propertyAttribute() {
			return getRuleContexts(PropertyAttributeContext.class);
		}
		public PropertyAttributeContext propertyAttribute(int i) {
			return getRuleContext(PropertyAttributeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public PropertyAttributesListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyAttributesList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertyAttributesList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertyAttributesList(this);
		}
	}

	public final PropertyAttributesListContext propertyAttributesList() throws RecognitionException {
		PropertyAttributesListContext _localctx = new PropertyAttributesListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propertyAttributesList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			propertyAttribute();
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(511);
				match(COMMA);
				setState(512);
				propertyAttribute();
				}
				}
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyAttributeContext extends ParserRuleContext {
		public TerminalNode ATOMIC() { return getToken(ObjectiveCParser.ATOMIC, 0); }
		public TerminalNode NONATOMIC() { return getToken(ObjectiveCParser.NONATOMIC, 0); }
		public TerminalNode STRONG() { return getToken(ObjectiveCParser.STRONG, 0); }
		public TerminalNode WEAK() { return getToken(ObjectiveCParser.WEAK, 0); }
		public TerminalNode RETAIN() { return getToken(ObjectiveCParser.RETAIN, 0); }
		public TerminalNode ASSIGN() { return getToken(ObjectiveCParser.ASSIGN, 0); }
		public TerminalNode UNSAFE_UNRETAINED() { return getToken(ObjectiveCParser.UNSAFE_UNRETAINED, 0); }
		public TerminalNode COPY() { return getToken(ObjectiveCParser.COPY, 0); }
		public TerminalNode READONLY() { return getToken(ObjectiveCParser.READONLY, 0); }
		public TerminalNode READWRITE() { return getToken(ObjectiveCParser.READWRITE, 0); }
		public TerminalNode GETTER() { return getToken(ObjectiveCParser.GETTER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SETTER() { return getToken(ObjectiveCParser.SETTER, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public PropertyAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertyAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertyAttribute(this);
		}
	}

	public final PropertyAttributeContext propertyAttribute() throws RecognitionException {
		PropertyAttributeContext _localctx = new PropertyAttributeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_propertyAttribute);
		try {
			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(518);
				match(ATOMIC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(519);
				match(NONATOMIC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(520);
				match(STRONG);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(521);
				match(WEAK);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(522);
				match(RETAIN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(523);
				match(ASSIGN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(524);
				match(UNSAFE_UNRETAINED);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(525);
				match(COPY);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(526);
				match(READONLY);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(527);
				match(READWRITE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(528);
				match(GETTER);
				setState(529);
				match(ASSIGNMENT);
				setState(530);
				identifier();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(531);
				match(SETTER);
				setState(532);
				match(ASSIGNMENT);
				setState(533);
				identifier();
				setState(534);
				match(COLON);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(536);
				nullabilitySpecifier();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(537);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolNameContext extends ParserRuleContext {
		public TypeNameContext name;
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode COVARIANT() { return getToken(ObjectiveCParser.COVARIANT, 0); }
		public TerminalNode CONTRAVARIANT() { return getToken(ObjectiveCParser.CONTRAVARIANT, 0); }
		public ProtocolNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolName(this);
		}
	}

	public final ProtocolNameContext protocolName() throws RecognitionException {
		ProtocolNameContext _localctx = new ProtocolNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_protocolName);
		int _la;
		try {
			setState(552);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(540);
				match(LT);
				setState(541);
				protocolList();
				setState(542);
				match(GT);
				}
				break;
			case AUTO:
			case CHAR:
			case CONST:
			case DOUBLE:
			case ENUM:
			case EXTERN:
			case FLOAT:
			case INLINE:
			case INT:
			case LONG:
			case REGISTER:
			case RESTRICT:
			case SHORT:
			case SIGNED:
			case STATIC:
			case STRUCT:
			case UNION:
			case UNSIGNED:
			case VOID:
			case VOLATILE:
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case ATTRIBUTE:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case STRONG_QUALIFIER:
			case TYPEOF:
			case UNSAFE_UNRETAINED_QUALIFIER:
			case UNUSED:
			case WEAK_QUALIFIER:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case NS_CLOSED_ENUM:
			case NS_ERROR_ENUM:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(544);
					_la = _input.LA(1);
					if ( !(_la==COVARIANT || _la==CONTRAVARIANT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(547);
				((ProtocolNameContext)_localctx).name = typeName();
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(548);
					match(COLON);
					setState(549);
					typeSpecifier();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceVariablesContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<VisibilitySectionContext> visibilitySection() {
			return getRuleContexts(VisibilitySectionContext.class);
		}
		public VisibilitySectionContext visibilitySection(int i) {
			return getRuleContext(VisibilitySectionContext.class,i);
		}
		public InstanceVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInstanceVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInstanceVariables(this);
		}
	}

	public final InstanceVariablesContext instanceVariables() throws RecognitionException {
		InstanceVariablesContext _localctx = new InstanceVariablesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_instanceVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(LBRACE);
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (PACKAGE - 68)) | (1L << (PRIVATE - 68)) | (1L << (PROTECTED - 68)) | (1L << (PUBLIC - 68)) | (1L << (ATOMIC - 68)) | (1L << (NONATOMIC - 68)) | (1L << (RETAIN - 68)) | (1L << (ATTRIBUTE - 68)) | (1L << (AUTORELEASING_QUALIFIER - 68)) | (1L << (BLOCK - 68)) | (1L << (BRIDGE - 68)) | (1L << (BRIDGE_RETAINED - 68)) | (1L << (BRIDGE_TRANSFER - 68)) | (1L << (COVARIANT - 68)) | (1L << (CONTRAVARIANT - 68)) | (1L << (DEPRECATED - 68)) | (1L << (KINDOF - 68)) | (1L << (STRONG_QUALIFIER - 68)) | (1L << (TYPEOF - 68)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 68)) | (1L << (UNUSED - 68)) | (1L << (WEAK_QUALIFIER - 68)) | (1L << (NULL_UNSPECIFIED - 68)) | (1L << (NULLABLE - 68)) | (1L << (NONNULL - 68)) | (1L << (NULL_RESETTABLE - 68)) | (1L << (NS_INLINE - 68)) | (1L << (NS_ENUM - 68)) | (1L << (NS_OPTIONS - 68)) | (1L << (NS_CLOSED_ENUM - 68)) | (1L << (NS_ERROR_ENUM - 68)) | (1L << (ASSIGN - 68)) | (1L << (COPY - 68)) | (1L << (GETTER - 68)) | (1L << (SETTER - 68)) | (1L << (STRONG - 68)) | (1L << (READONLY - 68)) | (1L << (READWRITE - 68)) | (1L << (WEAK - 68)) | (1L << (UNSAFE_UNRETAINED - 68)) | (1L << (IB_OUTLET - 68)) | (1L << (IB_OUTLET_COLLECTION - 68)) | (1L << (IB_INSPECTABLE - 68)) | (1L << (IB_DESIGNABLE - 68)))) != 0) || _la==IDENTIFIER || _la==LP) {
				{
				{
				setState(555);
				visibilitySection();
				}
				}
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(561);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VisibilitySectionContext extends ParserRuleContext {
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public VisibilitySectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibilitySection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterVisibilitySection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitVisibilitySection(this);
		}
	}

	public final VisibilitySectionContext visibilitySection() throws RecognitionException {
		VisibilitySectionContext _localctx = new VisibilitySectionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_visibilitySection);
		try {
			int _alt;
			setState(575);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PACKAGE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(563);
				accessModifier();
				setState(567);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(564);
						fieldDeclaration();
						}
						} 
					}
					setState(569);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				}
				}
				break;
			case AUTO:
			case CHAR:
			case CONST:
			case DOUBLE:
			case ENUM:
			case EXTERN:
			case FLOAT:
			case INLINE:
			case INT:
			case LONG:
			case REGISTER:
			case RESTRICT:
			case SHORT:
			case SIGNED:
			case STATIC:
			case STRUCT:
			case UNION:
			case UNSIGNED:
			case VOID:
			case VOLATILE:
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case ATTRIBUTE:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case STRONG_QUALIFIER:
			case TYPEOF:
			case UNSAFE_UNRETAINED_QUALIFIER:
			case UNUSED:
			case WEAK_QUALIFIER:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case NS_CLOSED_ENUM:
			case NS_ERROR_ENUM:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(571); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(570);
						fieldDeclaration();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(573); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessModifierContext extends ParserRuleContext {
		public TerminalNode PRIVATE() { return getToken(ObjectiveCParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(ObjectiveCParser.PROTECTED, 0); }
		public TerminalNode PACKAGE() { return getToken(ObjectiveCParser.PACKAGE, 0); }
		public TerminalNode PUBLIC() { return getToken(ObjectiveCParser.PUBLIC, 0); }
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAccessModifier(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			_la = _input.LA(1);
			if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (PACKAGE - 68)) | (1L << (PRIVATE - 68)) | (1L << (PROTECTED - 68)) | (1L << (PUBLIC - 68)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationListContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<ClassMethodDeclarationContext> classMethodDeclaration() {
			return getRuleContexts(ClassMethodDeclarationContext.class);
		}
		public ClassMethodDeclarationContext classMethodDeclaration(int i) {
			return getRuleContext(ClassMethodDeclarationContext.class,i);
		}
		public List<InstanceMethodDeclarationContext> instanceMethodDeclaration() {
			return getRuleContexts(InstanceMethodDeclarationContext.class);
		}
		public InstanceMethodDeclarationContext instanceMethodDeclaration(int i) {
			return getRuleContext(InstanceMethodDeclarationContext.class,i);
		}
		public List<PropertyDeclarationContext> propertyDeclaration() {
			return getRuleContexts(PropertyDeclarationContext.class);
		}
		public PropertyDeclarationContext propertyDeclaration(int i) {
			return getRuleContext(PropertyDeclarationContext.class,i);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public InterfaceDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInterfaceDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInterfaceDeclarationList(this);
		}
	}

	public final InterfaceDeclarationListContext interfaceDeclarationList() throws RecognitionException {
		InterfaceDeclarationListContext _localctx = new InterfaceDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_interfaceDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(584); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(584);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						setState(579);
						declaration();
						}
						break;
					case 2:
						{
						setState(580);
						classMethodDeclaration();
						}
						break;
					case 3:
						{
						setState(581);
						instanceMethodDeclaration();
						}
						break;
					case 4:
						{
						setState(582);
						propertyDeclaration();
						}
						break;
					case 5:
						{
						setState(583);
						functionDeclaration();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(586); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMethodDeclarationContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassMethodDeclaration(this);
		}
	}

	public final ClassMethodDeclarationContext classMethodDeclaration() throws RecognitionException {
		ClassMethodDeclarationContext _localctx = new ClassMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_classMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			match(ADD);
			setState(589);
			methodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceMethodDeclarationContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public InstanceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInstanceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInstanceMethodDeclaration(this);
		}
	}

	public final InstanceMethodDeclarationContext instanceMethodDeclaration() throws RecognitionException {
		InstanceMethodDeclarationContext _localctx = new InstanceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_instanceMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			match(SUB);
			setState(592);
			methodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodSelectorContext methodSelector() {
			return getRuleContext(MethodSelectorContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(594);
				methodType();
				}
			}

			setState(597);
			methodSelector();
			setState(602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(600);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(598);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(599);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(604);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(605);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImplementationDefinitionListContext extends ParserRuleContext {
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<ClassMethodDefinitionContext> classMethodDefinition() {
			return getRuleContexts(ClassMethodDefinitionContext.class);
		}
		public ClassMethodDefinitionContext classMethodDefinition(int i) {
			return getRuleContext(ClassMethodDefinitionContext.class,i);
		}
		public List<InstanceMethodDefinitionContext> instanceMethodDefinition() {
			return getRuleContexts(InstanceMethodDefinitionContext.class);
		}
		public InstanceMethodDefinitionContext instanceMethodDefinition(int i) {
			return getRuleContext(InstanceMethodDefinitionContext.class,i);
		}
		public List<PropertyImplementationContext> propertyImplementation() {
			return getRuleContexts(PropertyImplementationContext.class);
		}
		public PropertyImplementationContext propertyImplementation(int i) {
			return getRuleContext(PropertyImplementationContext.class,i);
		}
		public ImplementationDefinitionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implementationDefinitionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterImplementationDefinitionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitImplementationDefinitionList(this);
		}
	}

	public final ImplementationDefinitionListContext implementationDefinitionList() throws RecognitionException {
		ImplementationDefinitionListContext _localctx = new ImplementationDefinitionListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_implementationDefinitionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(612);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(607);
					functionDefinition();
					}
					break;
				case 2:
					{
					setState(608);
					declaration();
					}
					break;
				case 3:
					{
					setState(609);
					classMethodDefinition();
					}
					break;
				case 4:
					{
					setState(610);
					instanceMethodDefinition();
					}
					break;
				case 5:
					{
					setState(611);
					propertyImplementation();
					}
					break;
				}
				}
				setState(614); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (NS_CLOSED_ENUM - 78)) | (1L << (NS_ERROR_ENUM - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMethodDefinitionContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public MethodDefinitionContext methodDefinition() {
			return getRuleContext(MethodDefinitionContext.class,0);
		}
		public ClassMethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterClassMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitClassMethodDefinition(this);
		}
	}

	public final ClassMethodDefinitionContext classMethodDefinition() throws RecognitionException {
		ClassMethodDefinitionContext _localctx = new ClassMethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_classMethodDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			match(ADD);
			setState(617);
			methodDefinition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceMethodDefinitionContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public MethodDefinitionContext methodDefinition() {
			return getRuleContext(MethodDefinitionContext.class,0);
		}
		public InstanceMethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceMethodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInstanceMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInstanceMethodDefinition(this);
		}
	}

	public final InstanceMethodDefinitionContext instanceMethodDefinition() throws RecognitionException {
		InstanceMethodDefinitionContext _localctx = new InstanceMethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_instanceMethodDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(SUB);
			setState(620);
			methodDefinition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDefinitionContext extends ParserRuleContext {
		public MethodSelectorContext methodSelector() {
			return getRuleContext(MethodSelectorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public MethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMethodDefinition(this);
		}
	}

	public final MethodDefinitionContext methodDefinition() throws RecognitionException {
		MethodDefinitionContext _localctx = new MethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_methodDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(622);
				methodType();
				}
			}

			setState(625);
			methodSelector();
			setState(627);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (BOOL - 40)) | (1L << (Class - 40)) | (1L << (BYCOPY - 40)) | (1L << (BYREF - 40)) | (1L << (ID - 40)) | (1L << (IMP - 40)) | (1L << (IN - 40)) | (1L << (INOUT - 40)) | (1L << (ONEWAY - 40)) | (1L << (OUT - 40)) | (1L << (PROTOCOL_ - 40)) | (1L << (SEL - 40)) | (1L << (SELF - 40)) | (1L << (SUPER - 40)) | (1L << (ATOMIC - 40)) | (1L << (NONATOMIC - 40)) | (1L << (RETAIN - 40)) | (1L << (AUTORELEASING_QUALIFIER - 40)) | (1L << (BLOCK - 40)) | (1L << (BRIDGE_RETAINED - 40)) | (1L << (BRIDGE_TRANSFER - 40)) | (1L << (COVARIANT - 40)) | (1L << (CONTRAVARIANT - 40)) | (1L << (DEPRECATED - 40)) | (1L << (KINDOF - 40)) | (1L << (UNUSED - 40)) | (1L << (NULL_UNSPECIFIED - 40)) | (1L << (NULLABLE - 40)) | (1L << (NONNULL - 40)) | (1L << (NULL_RESETTABLE - 40)) | (1L << (NS_INLINE - 40)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (NS_ENUM - 104)) | (1L << (NS_OPTIONS - 104)) | (1L << (ASSIGN - 104)) | (1L << (COPY - 104)) | (1L << (GETTER - 104)) | (1L << (SETTER - 104)) | (1L << (STRONG - 104)) | (1L << (READONLY - 104)) | (1L << (READWRITE - 104)) | (1L << (WEAK - 104)) | (1L << (UNSAFE_UNRETAINED - 104)) | (1L << (IB_OUTLET - 104)) | (1L << (IB_OUTLET_COLLECTION - 104)) | (1L << (IB_INSPECTABLE - 104)) | (1L << (IB_DESIGNABLE - 104)) | (1L << (IDENTIFIER - 104)) | (1L << (LP - 104)) | (1L << (MUL - 104)))) != 0)) {
				{
				setState(626);
				initDeclaratorList();
				}
			}

			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(629);
				match(SEMI);
				}
			}

			setState(632);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodSelectorContext extends ParserRuleContext {
		public SelectorContext sel;
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public List<KeywordDeclaratorContext> keywordDeclarator() {
			return getRuleContexts(KeywordDeclaratorContext.class);
		}
		public KeywordDeclaratorContext keywordDeclarator(int i) {
			return getRuleContext(KeywordDeclaratorContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public TerminalNode ELIPSIS() { return getToken(ObjectiveCParser.ELIPSIS, 0); }
		public MethodSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMethodSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMethodSelector(this);
		}
	}

	public final MethodSelectorContext methodSelector() throws RecognitionException {
		MethodSelectorContext _localctx = new MethodSelectorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_methodSelector);
		int _la;
		try {
			int _alt;
			setState(644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(634);
				((MethodSelectorContext)_localctx).sel = selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(636); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(635);
						keywordDeclarator();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(638); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(640);
					match(COMMA);
					setState(641);
					match(ELIPSIS);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordDeclaratorContext extends ParserRuleContext {
		public SelectorContext sel;
		public MethodTypeContext methodType;
		public List<MethodTypeContext> types = new ArrayList<MethodTypeContext>();
		public IdentifierContext name;
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArcBehaviourSpecifierContext arcBehaviourSpecifier() {
			return getRuleContext(ArcBehaviourSpecifierContext.class,0);
		}
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public List<MethodTypeContext> methodType() {
			return getRuleContexts(MethodTypeContext.class);
		}
		public MethodTypeContext methodType(int i) {
			return getRuleContext(MethodTypeContext.class,i);
		}
		public KeywordDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterKeywordDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitKeywordDeclarator(this);
		}
	}

	public final KeywordDeclaratorContext keywordDeclarator() throws RecognitionException {
		KeywordDeclaratorContext _localctx = new KeywordDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_keywordDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(646);
				((KeywordDeclaratorContext)_localctx).sel = selector();
				}
			}

			setState(649);
			match(COLON);
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(650);
				((KeywordDeclaratorContext)_localctx).methodType = methodType();
				((KeywordDeclaratorContext)_localctx).types.add(((KeywordDeclaratorContext)_localctx).methodType);
				}
				}
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(656);
				arcBehaviourSpecifier();
				}
				break;
			}
			setState(659);
			((KeywordDeclaratorContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(ObjectiveCParser.RETURN, 0); }
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSelector(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_selector);
		try {
			setState(663);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(661);
				identifier();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(662);
				match(RETURN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodTypeContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public MethodTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMethodType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMethodType(this);
		}
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_methodType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			match(LP);
			setState(666);
			typeName();
			setState(667);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyImplementationContext extends ParserRuleContext {
		public TerminalNode SYNTHESIZE() { return getToken(ObjectiveCParser.SYNTHESIZE, 0); }
		public PropertySynthesizeListContext propertySynthesizeList() {
			return getRuleContext(PropertySynthesizeListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public TerminalNode DYNAMIC() { return getToken(ObjectiveCParser.DYNAMIC, 0); }
		public PropertyImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyImplementation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertyImplementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertyImplementation(this);
		}
	}

	public final PropertyImplementationContext propertyImplementation() throws RecognitionException {
		PropertyImplementationContext _localctx = new PropertyImplementationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_propertyImplementation);
		try {
			setState(677);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SYNTHESIZE:
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				match(SYNTHESIZE);
				setState(670);
				propertySynthesizeList();
				setState(671);
				match(SEMI);
				}
				break;
			case DYNAMIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(673);
				match(DYNAMIC);
				setState(674);
				propertySynthesizeList();
				setState(675);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertySynthesizeListContext extends ParserRuleContext {
		public List<PropertySynthesizeItemContext> propertySynthesizeItem() {
			return getRuleContexts(PropertySynthesizeItemContext.class);
		}
		public PropertySynthesizeItemContext propertySynthesizeItem(int i) {
			return getRuleContext(PropertySynthesizeItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public PropertySynthesizeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertySynthesizeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertySynthesizeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertySynthesizeList(this);
		}
	}

	public final PropertySynthesizeListContext propertySynthesizeList() throws RecognitionException {
		PropertySynthesizeListContext _localctx = new PropertySynthesizeListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_propertySynthesizeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			propertySynthesizeItem();
			setState(684);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(680);
				match(COMMA);
				setState(681);
				propertySynthesizeItem();
				}
				}
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertySynthesizeItemContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public PropertySynthesizeItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertySynthesizeItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPropertySynthesizeItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPropertySynthesizeItem(this);
		}
	}

	public final PropertySynthesizeItemContext propertySynthesizeItem() throws RecognitionException {
		PropertySynthesizeItemContext _localctx = new PropertySynthesizeItemContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_propertySynthesizeItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
			identifier();
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(688);
				match(ASSIGNMENT);
				setState(689);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockTypeContext extends ParserRuleContext {
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode BITXOR() { return getToken(ObjectiveCParser.BITXOR, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<NullabilitySpecifierContext> nullabilitySpecifier() {
			return getRuleContexts(NullabilitySpecifierContext.class);
		}
		public NullabilitySpecifierContext nullabilitySpecifier(int i) {
			return getRuleContext(NullabilitySpecifierContext.class,i);
		}
		public BlockParametersContext blockParameters() {
			return getRuleContext(BlockParametersContext.class,0);
		}
		public BlockTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterBlockType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitBlockType(this);
		}
	}

	public final BlockTypeContext blockType() throws RecognitionException {
		BlockTypeContext _localctx = new BlockTypeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_blockType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(692);
				nullabilitySpecifier();
				}
				break;
			}
			setState(695);
			typeSpecifier();
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (NULL_UNSPECIFIED - 99)) | (1L << (NULLABLE - 99)) | (1L << (NONNULL - 99)) | (1L << (NULL_RESETTABLE - 99)))) != 0)) {
				{
				setState(696);
				nullabilitySpecifier();
				}
			}

			setState(699);
			match(LP);
			setState(700);
			match(BITXOR);
			setState(703);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(701);
				nullabilitySpecifier();
				}
				break;
			case 2:
				{
				setState(702);
				typeSpecifier();
				}
				break;
			}
			setState(705);
			match(RP);
			setState(707);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(706);
				blockParameters();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericsSpecifierContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public List<TypeSpecifierWithPrefixesContext> typeSpecifierWithPrefixes() {
			return getRuleContexts(TypeSpecifierWithPrefixesContext.class);
		}
		public TypeSpecifierWithPrefixesContext typeSpecifierWithPrefixes(int i) {
			return getRuleContext(TypeSpecifierWithPrefixesContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public GenericsSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericsSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterGenericsSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitGenericsSpecifier(this);
		}
	}

	public final GenericsSpecifierContext genericsSpecifier() throws RecognitionException {
		GenericsSpecifierContext _localctx = new GenericsSpecifierContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_genericsSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
			match(LT);
			setState(718);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (NS_CLOSED_ENUM - 81)) | (1L << (NS_ERROR_ENUM - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(710);
				typeSpecifierWithPrefixes();
				setState(715);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(711);
					match(COMMA);
					setState(712);
					typeSpecifierWithPrefixes();
					}
					}
					setState(717);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(720);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierWithPrefixesContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public List<TypePrefixContext> typePrefix() {
			return getRuleContexts(TypePrefixContext.class);
		}
		public TypePrefixContext typePrefix(int i) {
			return getRuleContext(TypePrefixContext.class,i);
		}
		public TypeSpecifierWithPrefixesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifierWithPrefixes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeSpecifierWithPrefixes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeSpecifierWithPrefixes(this);
		}
	}

	public final TypeSpecifierWithPrefixesContext typeSpecifierWithPrefixes() throws RecognitionException {
		TypeSpecifierWithPrefixesContext _localctx = new TypeSpecifierWithPrefixesContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_typeSpecifierWithPrefixes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(722);
					typePrefix();
					}
					} 
				}
				setState(727);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			}
			setState(728);
			typeSpecifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DictionaryExpressionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ObjectiveCParser.AT, 0); }
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<DictionaryPairContext> dictionaryPair() {
			return getRuleContexts(DictionaryPairContext.class);
		}
		public DictionaryPairContext dictionaryPair(int i) {
			return getRuleContext(DictionaryPairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public DictionaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDictionaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDictionaryExpression(this);
		}
	}

	public final DictionaryExpressionContext dictionaryExpression() throws RecognitionException {
		DictionaryExpressionContext _localctx = new DictionaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_dictionaryExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			match(AT);
			setState(731);
			match(LBRACE);
			setState(743);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(732);
				dictionaryPair();
				setState(737);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(733);
						match(COMMA);
						setState(734);
						dictionaryPair();
						}
						} 
					}
					setState(739);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
				}
				setState(741);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(740);
					match(COMMA);
					}
				}

				}
			}

			setState(745);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DictionaryPairContext extends ParserRuleContext {
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DictionaryPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionaryPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDictionaryPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDictionaryPair(this);
		}
	}

	public final DictionaryPairContext dictionaryPair() throws RecognitionException {
		DictionaryPairContext _localctx = new DictionaryPairContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_dictionaryPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			castExpression();
			setState(748);
			match(COLON);
			setState(749);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayExpressionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ObjectiveCParser.AT, 0); }
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArrayExpression(this);
		}
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			match(AT);
			setState(752);
			match(LBRACK);
			setState(757);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(753);
				expressions();
				setState(755);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(754);
					match(COMMA);
					}
				}

				}
			}

			setState(759);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoxExpressionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ObjectiveCParser.AT, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BoxExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boxExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterBoxExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitBoxExpression(this);
		}
	}

	public final BoxExpressionContext boxExpression() throws RecognitionException {
		BoxExpressionContext _localctx = new BoxExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_boxExpression);
		try {
			setState(771);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(761);
				match(AT);
				setState(762);
				match(LP);
				setState(763);
				expression(0);
				setState(764);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(766);
				match(AT);
				setState(769);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case NIL:
				case NO:
				case NULL:
				case YES:
				case ADD:
				case SUB:
				case CHARACTER_LITERAL:
				case HEX_LITERAL:
				case OCTAL_LITERAL:
				case BINARY_LITERAL:
				case DECIMAL_LITERAL:
				case FLOATING_POINT_LITERAL:
					{
					setState(767);
					constant();
					}
					break;
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(768);
					identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockParametersContext extends ParserRuleContext {
		public TypeVariableDeclaratorOrNameContext typeVariableDeclaratorOrName;
		public List<TypeVariableDeclaratorOrNameContext> types = new ArrayList<TypeVariableDeclaratorOrNameContext>();
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode VOID() { return getToken(ObjectiveCParser.VOID, 0); }
		public List<TypeVariableDeclaratorOrNameContext> typeVariableDeclaratorOrName() {
			return getRuleContexts(TypeVariableDeclaratorOrNameContext.class);
		}
		public TypeVariableDeclaratorOrNameContext typeVariableDeclaratorOrName(int i) {
			return getRuleContext(TypeVariableDeclaratorOrNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public BlockParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterBlockParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitBlockParameters(this);
		}
	}

	public final BlockParametersContext blockParameters() throws RecognitionException {
		BlockParametersContext _localctx = new BlockParametersContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_blockParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			match(LP);
			setState(785);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (NS_CLOSED_ENUM - 81)) | (1L << (NS_ERROR_ENUM - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (LP - 81)))) != 0)) {
				{
				setState(776);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(774);
					((BlockParametersContext)_localctx).typeVariableDeclaratorOrName = typeVariableDeclaratorOrName();
					((BlockParametersContext)_localctx).types.add(((BlockParametersContext)_localctx).typeVariableDeclaratorOrName);
					}
					break;
				case 2:
					{
					setState(775);
					match(VOID);
					}
					break;
				}
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(778);
					match(COMMA);
					setState(779);
					((BlockParametersContext)_localctx).typeVariableDeclaratorOrName = typeVariableDeclaratorOrName();
					((BlockParametersContext)_localctx).types.add(((BlockParametersContext)_localctx).typeVariableDeclaratorOrName);
					}
					}
					setState(784);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(787);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeVariableDeclaratorOrNameContext extends ParserRuleContext {
		public TypeVariableDeclaratorContext typeVariableDeclarator() {
			return getRuleContext(TypeVariableDeclaratorContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TypeVariableDeclaratorOrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariableDeclaratorOrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeVariableDeclaratorOrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeVariableDeclaratorOrName(this);
		}
	}

	public final TypeVariableDeclaratorOrNameContext typeVariableDeclaratorOrName() throws RecognitionException {
		TypeVariableDeclaratorOrNameContext _localctx = new TypeVariableDeclaratorOrNameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_typeVariableDeclaratorOrName);
		try {
			setState(791);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(789);
				typeVariableDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(790);
				typeName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockExpressionContext extends ParserRuleContext {
		public TerminalNode BITXOR() { return getToken(ObjectiveCParser.BITXOR, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public BlockParametersContext blockParameters() {
			return getRuleContext(BlockParametersContext.class,0);
		}
		public BlockExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterBlockExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitBlockExpression(this);
		}
	}

	public final BlockExpressionContext blockExpression() throws RecognitionException {
		BlockExpressionContext _localctx = new BlockExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_blockExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793);
			match(BITXOR);
			setState(795);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				{
				setState(794);
				typeSpecifier();
				}
				break;
			}
			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (NULL_UNSPECIFIED - 99)) | (1L << (NULLABLE - 99)) | (1L << (NONNULL - 99)) | (1L << (NULL_RESETTABLE - 99)))) != 0)) {
				{
				setState(797);
				nullabilitySpecifier();
				}
			}

			setState(801);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(800);
				blockParameters();
				}
			}

			setState(803);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageExpressionContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public ReceiverContext receiver() {
			return getRuleContext(ReceiverContext.class,0);
		}
		public MessageSelectorContext messageSelector() {
			return getRuleContext(MessageSelectorContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public MessageExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMessageExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMessageExpression(this);
		}
	}

	public final MessageExpressionContext messageExpression() throws RecognitionException {
		MessageExpressionContext _localctx = new MessageExpressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_messageExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			match(LBRACK);
			setState(806);
			receiver();
			setState(807);
			messageSelector();
			setState(808);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReceiverContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public ReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitReceiver(this);
		}
	}

	public final ReceiverContext receiver() throws RecognitionException {
		ReceiverContext _localctx = new ReceiverContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_receiver);
		try {
			setState(812);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(810);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(811);
				typeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageSelectorContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public List<KeywordArgumentContext> keywordArgument() {
			return getRuleContexts(KeywordArgumentContext.class);
		}
		public KeywordArgumentContext keywordArgument(int i) {
			return getRuleContext(KeywordArgumentContext.class,i);
		}
		public MessageSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMessageSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMessageSelector(this);
		}
	}

	public final MessageSelectorContext messageSelector() throws RecognitionException {
		MessageSelectorContext _localctx = new MessageSelectorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_messageSelector);
		int _la;
		try {
			setState(820);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(814);
				selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(816); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(815);
					keywordArgument();
					}
					}
					setState(818); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || _la==COLON );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordArgumentContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public List<KeywordArgumentTypeContext> keywordArgumentType() {
			return getRuleContexts(KeywordArgumentTypeContext.class);
		}
		public KeywordArgumentTypeContext keywordArgumentType(int i) {
			return getRuleContext(KeywordArgumentTypeContext.class,i);
		}
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public KeywordArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterKeywordArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitKeywordArgument(this);
		}
	}

	public final KeywordArgumentContext keywordArgument() throws RecognitionException {
		KeywordArgumentContext _localctx = new KeywordArgumentContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_keywordArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(822);
				selector();
				}
			}

			setState(825);
			match(COLON);
			setState(826);
			keywordArgumentType();
			setState(831);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(827);
				match(COMMA);
				setState(828);
				keywordArgumentType();
				}
				}
				setState(833);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordArgumentTypeContext extends ParserRuleContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public KeywordArgumentTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordArgumentType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterKeywordArgumentType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitKeywordArgumentType(this);
		}
	}

	public final KeywordArgumentTypeContext keywordArgumentType() throws RecognitionException {
		KeywordArgumentTypeContext _localctx = new KeywordArgumentTypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_keywordArgumentType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834);
			expressions();
			setState(836);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				{
				setState(835);
				nullabilitySpecifier();
				}
				break;
			}
			setState(842);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(838);
				match(LBRACE);
				setState(839);
				initializerList();
				setState(840);
				match(RBRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorExpressionContext extends ParserRuleContext {
		public TerminalNode SELECTOR() { return getToken(ObjectiveCParser.SELECTOR, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public SelectorNameContext selectorName() {
			return getRuleContext(SelectorNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public SelectorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSelectorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSelectorExpression(this);
		}
	}

	public final SelectorExpressionContext selectorExpression() throws RecognitionException {
		SelectorExpressionContext _localctx = new SelectorExpressionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_selectorExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
			match(SELECTOR);
			setState(845);
			match(LP);
			setState(846);
			selectorName();
			setState(847);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorNameContext extends ParserRuleContext {
		public List<SelectorContext> selector() {
			return getRuleContexts(SelectorContext.class);
		}
		public SelectorContext selector(int i) {
			return getRuleContext(SelectorContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ObjectiveCParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ObjectiveCParser.COLON, i);
		}
		public SelectorNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSelectorName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSelectorName(this);
		}
	}

	public final SelectorNameContext selectorName() throws RecognitionException {
		SelectorNameContext _localctx = new SelectorNameContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_selectorName);
		int _la;
		try {
			setState(858);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(849);
				selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(854); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(851);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
						{
						setState(850);
						selector();
						}
					}

					setState(853);
					match(COLON);
					}
					}
					setState(856); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || _la==COLON );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolExpressionContext extends ParserRuleContext {
		public TerminalNode PROTOCOL() { return getToken(ObjectiveCParser.PROTOCOL, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ProtocolNameContext protocolName() {
			return getRuleContext(ProtocolNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public ProtocolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolExpression(this);
		}
	}

	public final ProtocolExpressionContext protocolExpression() throws RecognitionException {
		ProtocolExpressionContext _localctx = new ProtocolExpressionContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_protocolExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			match(PROTOCOL);
			setState(861);
			match(LP);
			setState(862);
			protocolName();
			setState(863);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EncodeExpressionContext extends ParserRuleContext {
		public TerminalNode ENCODE() { return getToken(ObjectiveCParser.ENCODE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public EncodeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_encodeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEncodeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEncodeExpression(this);
		}
	}

	public final EncodeExpressionContext encodeExpression() throws RecognitionException {
		EncodeExpressionContext _localctx = new EncodeExpressionContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_encodeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(865);
			match(ENCODE);
			setState(866);
			match(LP);
			setState(867);
			typeName();
			setState(868);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeVariableDeclaratorContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TypeVariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeVariableDeclarator(this);
		}
	}

	public final TypeVariableDeclaratorContext typeVariableDeclarator() throws RecognitionException {
		TypeVariableDeclaratorContext _localctx = new TypeVariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_typeVariableDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			declarationSpecifiers();
			setState(871);
			declarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode THROW() { return getToken(ObjectiveCParser.THROW, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitThrowStatement(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_throwStatement);
		try {
			setState(880);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(873);
				match(THROW);
				setState(874);
				match(LP);
				setState(875);
				identifier();
				setState(876);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(878);
				match(THROW);
				setState(879);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryBlockContext extends ParserRuleContext {
		public CompoundStatementContext tryStatement;
		public CompoundStatementContext finallyStatement;
		public TerminalNode TRY() { return getToken(ObjectiveCParser.TRY, 0); }
		public List<CompoundStatementContext> compoundStatement() {
			return getRuleContexts(CompoundStatementContext.class);
		}
		public CompoundStatementContext compoundStatement(int i) {
			return getRuleContext(CompoundStatementContext.class,i);
		}
		public List<CatchStatementContext> catchStatement() {
			return getRuleContexts(CatchStatementContext.class);
		}
		public CatchStatementContext catchStatement(int i) {
			return getRuleContext(CatchStatementContext.class,i);
		}
		public TerminalNode FINALLY() { return getToken(ObjectiveCParser.FINALLY, 0); }
		public TryBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTryBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTryBlock(this);
		}
	}

	public final TryBlockContext tryBlock() throws RecognitionException {
		TryBlockContext _localctx = new TryBlockContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_tryBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(882);
			match(TRY);
			setState(883);
			((TryBlockContext)_localctx).tryStatement = compoundStatement();
			setState(887);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(884);
				catchStatement();
				}
				}
				setState(889);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(892);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(890);
				match(FINALLY);
				setState(891);
				((TryBlockContext)_localctx).finallyStatement = compoundStatement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchStatementContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(ObjectiveCParser.CATCH, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeVariableDeclaratorContext typeVariableDeclarator() {
			return getRuleContext(TypeVariableDeclaratorContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public CatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCatchStatement(this);
		}
	}

	public final CatchStatementContext catchStatement() throws RecognitionException {
		CatchStatementContext _localctx = new CatchStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_catchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			match(CATCH);
			setState(895);
			match(LP);
			setState(896);
			typeVariableDeclarator();
			setState(897);
			match(RP);
			setState(898);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynchronizedStatementContext extends ParserRuleContext {
		public TerminalNode SYNCHRONIZED() { return getToken(ObjectiveCParser.SYNCHRONIZED, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public SynchronizedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronizedStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSynchronizedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSynchronizedStatement(this);
		}
	}

	public final SynchronizedStatementContext synchronizedStatement() throws RecognitionException {
		SynchronizedStatementContext _localctx = new SynchronizedStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_synchronizedStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(900);
			match(SYNCHRONIZED);
			setState(901);
			match(LP);
			setState(902);
			expression(0);
			setState(903);
			match(RP);
			setState(904);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AutoreleaseStatementContext extends ParserRuleContext {
		public TerminalNode AUTORELEASEPOOL() { return getToken(ObjectiveCParser.AUTORELEASEPOOL, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public AutoreleaseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoreleaseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAutoreleaseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAutoreleaseStatement(this);
		}
	}

	public final AutoreleaseStatementContext autoreleaseStatement() throws RecognitionException {
		AutoreleaseStatementContext _localctx = new AutoreleaseStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_autoreleaseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906);
			match(AUTORELEASEPOOL);
			setState(907);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(909);
			functionSignature();
			setState(914);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(912);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(910);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(911);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(917);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919);
			functionSignature();
			setState(924);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(922);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(920);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(921);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(926);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(927);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionSignatureContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public AttributeSpecifierContext attributeSpecifier() {
			return getRuleContext(AttributeSpecifierContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionSignature(this);
		}
	}

	public final FunctionSignatureContext functionSignature() throws RecognitionException {
		FunctionSignatureContext _localctx = new FunctionSignatureContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_functionSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(930);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(929);
				declarationSpecifiers();
				}
				break;
			}
			setState(932);
			identifier();
			{
			setState(933);
			match(LP);
			setState(935);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (NS_CLOSED_ENUM - 81)) | (1L << (NS_ERROR_ENUM - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (LP - 81)))) != 0)) {
				{
				setState(934);
				parameterList();
				}
			}

			setState(937);
			match(RP);
			}
			setState(940);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				setState(939);
				attributeSpecifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionPointerContext extends ParserRuleContext {
		public IdentifierContext name;
		public List<TerminalNode> LP() { return getTokens(ObjectiveCParser.LP); }
		public TerminalNode LP(int i) {
			return getToken(ObjectiveCParser.LP, i);
		}
		public TerminalNode MUL() { return getToken(ObjectiveCParser.MUL, 0); }
		public List<TerminalNode> RP() { return getTokens(ObjectiveCParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(ObjectiveCParser.RP, i);
		}
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public AttributeSpecifierContext attributeSpecifier() {
			return getRuleContext(AttributeSpecifierContext.class,0);
		}
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionPointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionPointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionPointer(this);
		}
	}

	public final FunctionPointerContext functionPointer() throws RecognitionException {
		FunctionPointerContext _localctx = new FunctionPointerContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_functionPointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (NS_CLOSED_ENUM - 81)) | (1L << (NS_ERROR_ENUM - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(942);
				declarationSpecifiers();
				}
			}

			{
			setState(945);
			match(LP);
			setState(946);
			match(MUL);
			setState(948);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				{
				setState(947);
				nullabilitySpecifier();
				}
				break;
			}
			setState(951);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(950);
				((FunctionPointerContext)_localctx).name = identifier();
				}
			}

			setState(953);
			match(RP);
			}
			{
			setState(955);
			match(LP);
			setState(957);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (NS_CLOSED_ENUM - 81)) | (1L << (NS_ERROR_ENUM - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (LP - 81)))) != 0)) {
				{
				setState(956);
				parameterList();
				}
			}

			setState(959);
			match(RP);
			}
			setState(962);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(961);
				attributeSpecifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public AttributeParametersContext attributeParameters() {
			return getRuleContext(AttributeParametersContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(964);
			attributeName();
			setState(966);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(965);
				attributeParameters();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeNameContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(ObjectiveCParser.CONST, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeName(this);
		}
	}

	public final AttributeNameContext attributeName() throws RecognitionException {
		AttributeNameContext _localctx = new AttributeNameContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_attributeName);
		try {
			setState(970);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(968);
				match(CONST);
				}
				break;
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(969);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeParametersContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public AttributeParameterListContext attributeParameterList() {
			return getRuleContext(AttributeParameterListContext.class,0);
		}
		public AttributeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeParameters(this);
		}
	}

	public final AttributeParametersContext attributeParameters() throws RecognitionException {
		AttributeParametersContext _localctx = new AttributeParametersContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_attributeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(972);
			match(LP);
			setState(974);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (ADD - 163)) | (1L << (SUB - 163)) | (1L << (CHARACTER_LITERAL - 163)) | (1L << (STRING_START - 163)) | (1L << (HEX_LITERAL - 163)) | (1L << (OCTAL_LITERAL - 163)) | (1L << (BINARY_LITERAL - 163)) | (1L << (DECIMAL_LITERAL - 163)) | (1L << (FLOATING_POINT_LITERAL - 163)))) != 0)) {
				{
				setState(973);
				attributeParameterList();
				}
			}

			setState(976);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeParameterListContext extends ParserRuleContext {
		public List<AttributeParameterContext> attributeParameter() {
			return getRuleContexts(AttributeParameterContext.class);
		}
		public AttributeParameterContext attributeParameter(int i) {
			return getRuleContext(AttributeParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public AttributeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeParameterList(this);
		}
	}

	public final AttributeParameterListContext attributeParameterList() throws RecognitionException {
		AttributeParameterListContext _localctx = new AttributeParameterListContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_attributeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			attributeParameter();
			setState(983);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(979);
				match(COMMA);
				setState(980);
				attributeParameter();
				}
				}
				setState(985);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeParameterContext extends ParserRuleContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public AttributeParameterAssignmentContext attributeParameterAssignment() {
			return getRuleContext(AttributeParameterAssignmentContext.class,0);
		}
		public AttributeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeParameter(this);
		}
	}

	public final AttributeParameterContext attributeParameter() throws RecognitionException {
		AttributeParameterContext _localctx = new AttributeParameterContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_attributeParameter);
		try {
			setState(990);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(986);
				attribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(987);
				constant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(988);
				stringLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(989);
				attributeParameterAssignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeParameterAssignmentContext extends ParserRuleContext {
		public List<AttributeNameContext> attributeName() {
			return getRuleContexts(AttributeNameContext.class);
		}
		public AttributeNameContext attributeName(int i) {
			return getRuleContext(AttributeNameContext.class,i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public AttributeParameterAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeParameterAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeParameterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeParameterAssignment(this);
		}
	}

	public final AttributeParameterAssignmentContext attributeParameterAssignment() throws RecognitionException {
		AttributeParameterAssignmentContext _localctx = new AttributeParameterAssignmentContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_attributeParameterAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(992);
			attributeName();
			setState(993);
			match(ASSIGNMENT);
			setState(997);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NIL:
			case NO:
			case NULL:
			case YES:
			case ADD:
			case SUB:
			case CHARACTER_LITERAL:
			case HEX_LITERAL:
			case OCTAL_LITERAL:
			case BINARY_LITERAL:
			case DECIMAL_LITERAL:
			case FLOATING_POINT_LITERAL:
				{
				setState(994);
				constant();
				}
				break;
			case CONST:
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				{
				setState(995);
				attributeName();
				}
				break;
			case STRING_START:
				{
				setState(996);
				stringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public FunctionCallExpressionContext functionCallExpression() {
			return getRuleContext(FunctionCallExpressionContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public TypedefDeclarationContext typedefDeclaration() {
			return getRuleContext(TypedefDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_declaration);
		try {
			setState(1003);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(999);
				functionCallExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1000);
				enumDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1001);
				varDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1002);
				typedefDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public FunctionCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFunctionCallExpression(this);
		}
	}

	public final FunctionCallExpressionContext functionCallExpression() throws RecognitionException {
		FunctionCallExpressionContext _localctx = new FunctionCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_functionCallExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(1005);
				attributeSpecifier();
				}
			}

			setState(1008);
			identifier();
			setState(1010);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(1009);
				attributeSpecifier();
				}
			}

			setState(1012);
			match(LP);
			setState(1013);
			directDeclarator();
			setState(1014);
			match(RP);
			setState(1015);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclarationContext extends ParserRuleContext {
		public IdentifierContext name;
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public TerminalNode TYPEDEF() { return getToken(ObjectiveCParser.TYPEDEF, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumDeclaration(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_enumDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1021);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1019);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BOOL:
					case Class:
					case BYCOPY:
					case BYREF:
					case ID:
					case IMP:
					case IN:
					case INOUT:
					case ONEWAY:
					case OUT:
					case PROTOCOL_:
					case SEL:
					case SELF:
					case SUPER:
					case ATOMIC:
					case NONATOMIC:
					case RETAIN:
					case AUTORELEASING_QUALIFIER:
					case BLOCK:
					case BRIDGE_RETAINED:
					case BRIDGE_TRANSFER:
					case COVARIANT:
					case CONTRAVARIANT:
					case DEPRECATED:
					case KINDOF:
					case UNUSED:
					case NULL_UNSPECIFIED:
					case NULLABLE:
					case NONNULL:
					case NULL_RESETTABLE:
					case NS_INLINE:
					case NS_ENUM:
					case NS_OPTIONS:
					case ASSIGN:
					case COPY:
					case GETTER:
					case SETTER:
					case STRONG:
					case READONLY:
					case READWRITE:
					case WEAK:
					case UNSAFE_UNRETAINED:
					case IB_OUTLET:
					case IB_OUTLET_COLLECTION:
					case IB_INSPECTABLE:
					case IB_DESIGNABLE:
					case IDENTIFIER:
						{
						setState(1017);
						macro();
						}
						break;
					case ATTRIBUTE:
						{
						setState(1018);
						attributeSpecifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(1023);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
			}
			setState(1025);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(1024);
				match(TYPEDEF);
				}
			}

			setState(1027);
			enumSpecifier();
			setState(1029);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				{
				setState(1028);
				((EnumDeclarationContext)_localctx).name = identifier();
				}
				break;
			}
			setState(1035);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(1033);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1031);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(1032);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1037);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1038);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1041);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				{
				setState(1040);
				macro();
				}
				break;
			}
			setState(1047);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				{
				setState(1043);
				declarationSpecifiers();
				setState(1044);
				initDeclaratorList();
				}
				break;
			case 2:
				{
				setState(1046);
				declarationSpecifiers();
				}
				break;
			}
			setState(1053);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(1051);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1049);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(1050);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1055);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1056);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedefDeclarationContext extends ParserRuleContext {
		public TerminalNode TYPEDEF() { return getToken(ObjectiveCParser.TYPEDEF, 0); }
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public TypeDeclaratorListContext typeDeclaratorList() {
			return getRuleContext(TypeDeclaratorListContext.class,0);
		}
		public FunctionPointerContext functionPointer() {
			return getRuleContext(FunctionPointerContext.class,0);
		}
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public StructOrUnionSpecifierContext structOrUnionSpecifier() {
			return getRuleContext(StructOrUnionSpecifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public TypedefDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedefDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypedefDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypedefDeclaration(this);
		}
	}

	public final TypedefDeclarationContext typedefDeclaration() throws RecognitionException {
		TypedefDeclarationContext _localctx = new TypedefDeclarationContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_typedefDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(1058);
				attributeSpecifier();
				}
			}

			setState(1061);
			match(TYPEDEF);
			setState(1071);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				{
				setState(1062);
				declarationSpecifiers();
				setState(1063);
				typeDeclaratorList();
				}
				break;
			case 2:
				{
				setState(1065);
				declarationSpecifiers();
				}
				break;
			case 3:
				{
				setState(1066);
				functionPointer();
				}
				break;
			case 4:
				{
				setState(1067);
				functionSignature();
				}
				break;
			case 5:
				{
				setState(1068);
				structOrUnionSpecifier();
				setState(1069);
				identifier();
				}
				break;
			}
			setState(1077);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(1075);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1073);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(1074);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1079);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1080);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclaratorListContext extends ParserRuleContext {
		public List<TypeDeclaratorContext> typeDeclarator() {
			return getRuleContexts(TypeDeclaratorContext.class);
		}
		public TypeDeclaratorContext typeDeclarator(int i) {
			return getRuleContext(TypeDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public TypeDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeDeclaratorList(this);
		}
	}

	public final TypeDeclaratorListContext typeDeclaratorList() throws RecognitionException {
		TypeDeclaratorListContext _localctx = new TypeDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_typeDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1082);
			typeDeclarator();
			setState(1087);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1083);
				match(COMMA);
				setState(1084);
				typeDeclarator();
				}
				}
				setState(1089);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclaratorContext extends ParserRuleContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public TypeDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeDeclarator(this);
		}
	}

	public final TypeDeclaratorContext typeDeclarator() throws RecognitionException {
		TypeDeclaratorContext _localctx = new TypeDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_typeDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1091);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUL) {
				{
				setState(1090);
				pointer();
				}
			}

			setState(1093);
			directDeclarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommonSpecifiersContext extends ParserRuleContext {
		public List<ArcBehaviourSpecifierContext> arcBehaviourSpecifier() {
			return getRuleContexts(ArcBehaviourSpecifierContext.class);
		}
		public ArcBehaviourSpecifierContext arcBehaviourSpecifier(int i) {
			return getRuleContext(ArcBehaviourSpecifierContext.class,i);
		}
		public List<NullabilitySpecifierContext> nullabilitySpecifier() {
			return getRuleContexts(NullabilitySpecifierContext.class);
		}
		public NullabilitySpecifierContext nullabilitySpecifier(int i) {
			return getRuleContext(NullabilitySpecifierContext.class,i);
		}
		public List<IbOutletQualifierContext> ibOutletQualifier() {
			return getRuleContexts(IbOutletQualifierContext.class);
		}
		public IbOutletQualifierContext ibOutletQualifier(int i) {
			return getRuleContext(IbOutletQualifierContext.class,i);
		}
		public List<TypePrefixContext> typePrefix() {
			return getRuleContexts(TypePrefixContext.class);
		}
		public TypePrefixContext typePrefix(int i) {
			return getRuleContext(TypePrefixContext.class,i);
		}
		public List<TypeQualifierContext> typeQualifier() {
			return getRuleContexts(TypeQualifierContext.class);
		}
		public TypeQualifierContext typeQualifier(int i) {
			return getRuleContext(TypeQualifierContext.class,i);
		}
		public CommonSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commonSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCommonSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCommonSpecifiers(this);
		}
	}

	public final CommonSpecifiersContext commonSpecifiers() throws RecognitionException {
		CommonSpecifiersContext _localctx = new CommonSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_commonSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1100); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1100);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case AUTORELEASING_QUALIFIER:
					case STRONG_QUALIFIER:
					case UNSAFE_UNRETAINED_QUALIFIER:
					case WEAK_QUALIFIER:
						{
						setState(1095);
						arcBehaviourSpecifier();
						}
						break;
					case NULL_UNSPECIFIED:
					case NULLABLE:
					case NONNULL:
					case NULL_RESETTABLE:
						{
						setState(1096);
						nullabilitySpecifier();
						}
						break;
					case IB_OUTLET:
					case IB_OUTLET_COLLECTION:
						{
						setState(1097);
						ibOutletQualifier();
						}
						break;
					case INLINE:
					case BLOCK:
					case BRIDGE:
					case BRIDGE_RETAINED:
					case BRIDGE_TRANSFER:
					case KINDOF:
					case NS_INLINE:
						{
						setState(1098);
						typePrefix();
						}
						break;
					case CONST:
					case RESTRICT:
					case VOLATILE:
					case BYCOPY:
					case BYREF:
					case IN:
					case INOUT:
					case ONEWAY:
					case OUT:
						{
						setState(1099);
						typeQualifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1102); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public List<StorageClassSpecifierContext> storageClassSpecifier() {
			return getRuleContexts(StorageClassSpecifierContext.class);
		}
		public StorageClassSpecifierContext storageClassSpecifier(int i) {
			return getRuleContext(StorageClassSpecifierContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public List<CommonSpecifiersContext> commonSpecifiers() {
			return getRuleContexts(CommonSpecifiersContext.class);
		}
		public CommonSpecifiersContext commonSpecifiers(int i) {
			return getRuleContext(CommonSpecifiersContext.class,i);
		}
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDeclarationSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDeclarationSpecifiers(this);
		}
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1108); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1108);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
					case 1:
						{
						setState(1104);
						storageClassSpecifier();
						}
						break;
					case 2:
						{
						setState(1105);
						attributeSpecifier();
						}
						break;
					case 3:
						{
						setState(1106);
						commonSpecifiers();
						}
						break;
					case 4:
						{
						setState(1107);
						typeSpecifier();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1110); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerQualifierContext extends ParserRuleContext {
		public List<StorageClassSpecifierContext> storageClassSpecifier() {
			return getRuleContexts(StorageClassSpecifierContext.class);
		}
		public StorageClassSpecifierContext storageClassSpecifier(int i) {
			return getRuleContext(StorageClassSpecifierContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public List<CommonSpecifiersContext> commonSpecifiers() {
			return getRuleContexts(CommonSpecifiersContext.class);
		}
		public CommonSpecifiersContext commonSpecifiers(int i) {
			return getRuleContext(CommonSpecifiersContext.class,i);
		}
		public PointerQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPointerQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPointerQualifier(this);
		}
	}

	public final PointerQualifierContext pointerQualifier() throws RecognitionException {
		PointerQualifierContext _localctx = new PointerQualifierContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_pointerQualifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1115); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1115);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case AUTO:
					case EXTERN:
					case REGISTER:
					case STATIC:
						{
						setState(1112);
						storageClassSpecifier();
						}
						break;
					case ATTRIBUTE:
						{
						setState(1113);
						attributeSpecifier();
						}
						break;
					case CONST:
					case INLINE:
					case RESTRICT:
					case VOLATILE:
					case BYCOPY:
					case BYREF:
					case IN:
					case INOUT:
					case ONEWAY:
					case OUT:
					case AUTORELEASING_QUALIFIER:
					case BLOCK:
					case BRIDGE:
					case BRIDGE_RETAINED:
					case BRIDGE_TRANSFER:
					case KINDOF:
					case STRONG_QUALIFIER:
					case UNSAFE_UNRETAINED_QUALIFIER:
					case WEAK_QUALIFIER:
					case NULL_UNSPECIFIED:
					case NULLABLE:
					case NONNULL:
					case NULL_RESETTABLE:
					case NS_INLINE:
					case IB_OUTLET:
					case IB_OUTLET_COLLECTION:
						{
						setState(1114);
						commonSpecifiers();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1117); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeSpecifierContext extends ParserRuleContext {
		public TerminalNode ATTRIBUTE() { return getToken(ObjectiveCParser.ATTRIBUTE, 0); }
		public List<TerminalNode> LP() { return getTokens(ObjectiveCParser.LP); }
		public TerminalNode LP(int i) {
			return getToken(ObjectiveCParser.LP, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(ObjectiveCParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(ObjectiveCParser.RP, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public AttributeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAttributeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAttributeSpecifier(this);
		}
	}

	public final AttributeSpecifierContext attributeSpecifier() throws RecognitionException {
		AttributeSpecifierContext _localctx = new AttributeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_attributeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119);
			match(ATTRIBUTE);
			setState(1120);
			match(LP);
			setState(1121);
			match(LP);
			setState(1122);
			attribute();
			setState(1127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1123);
				match(COMMA);
				setState(1124);
				attribute();
				}
				}
				setState(1129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1130);
			match(RP);
			setState(1131);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorListContext extends ParserRuleContext {
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInitDeclaratorList(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1133);
			initDeclarator();
			setState(1138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1134);
				match(COMMA);
				setState(1135);
				initDeclarator();
				}
				}
				setState(1140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInitDeclarator(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_initDeclarator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1141);
			declarator();
			setState(1146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1144);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BOOL:
					case Class:
					case BYCOPY:
					case BYREF:
					case ID:
					case IMP:
					case IN:
					case INOUT:
					case ONEWAY:
					case OUT:
					case PROTOCOL_:
					case SEL:
					case SELF:
					case SUPER:
					case ATOMIC:
					case NONATOMIC:
					case RETAIN:
					case AUTORELEASING_QUALIFIER:
					case BLOCK:
					case BRIDGE_RETAINED:
					case BRIDGE_TRANSFER:
					case COVARIANT:
					case CONTRAVARIANT:
					case DEPRECATED:
					case KINDOF:
					case UNUSED:
					case NULL_UNSPECIFIED:
					case NULLABLE:
					case NONNULL:
					case NULL_RESETTABLE:
					case NS_INLINE:
					case NS_ENUM:
					case NS_OPTIONS:
					case ASSIGN:
					case COPY:
					case GETTER:
					case SETTER:
					case STRONG:
					case READONLY:
					case READWRITE:
					case WEAK:
					case UNSAFE_UNRETAINED:
					case IB_OUTLET:
					case IB_OUTLET_COLLECTION:
					case IB_INSPECTABLE:
					case IB_DESIGNABLE:
					case IDENTIFIER:
						{
						setState(1142);
						macro();
						}
						break;
					case ATTRIBUTE:
						{
						setState(1143);
						attributeSpecifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(1148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			}
			setState(1151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(1149);
				match(ASSIGNMENT);
				setState(1150);
				initializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructOrUnionSpecifierContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(ObjectiveCParser.STRUCT, 0); }
		public TerminalNode UNION() { return getToken(ObjectiveCParser.UNION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public StructOrUnionSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structOrUnionSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStructOrUnionSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStructOrUnionSpecifier(this);
		}
	}

	public final StructOrUnionSpecifierContext structOrUnionSpecifier() throws RecognitionException {
		StructOrUnionSpecifierContext _localctx = new StructOrUnionSpecifierContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_structOrUnionSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153);
			_la = _input.LA(1);
			if ( !(_la==STRUCT || _la==UNION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
			case 1:
				{
				setState(1154);
				identifier();
				}
				break;
			case 2:
				{
				setState(1156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(1155);
					identifier();
					}
				}

				setState(1158);
				match(LBRACE);
				setState(1160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1159);
					fieldDeclaration();
					}
					}
					setState(1162); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (NS_CLOSED_ENUM - 81)) | (1L << (NS_ERROR_ENUM - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (LP - 81)))) != 0) );
				setState(1164);
				match(RBRACE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public FieldDeclaratorListContext fieldDeclaratorList() {
			return getRuleContext(FieldDeclaratorListContext.class,0);
		}
		public FunctionPointerContext functionPointer() {
			return getRuleContext(FunctionPointerContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				{
				setState(1168);
				specifierQualifierList();
				setState(1169);
				fieldDeclaratorList();
				}
				break;
			case 2:
				{
				setState(1171);
				functionPointer();
				}
				break;
			}
			setState(1178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(1176);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1174);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(1175);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1181);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public List<CommonSpecifiersContext> commonSpecifiers() {
			return getRuleContexts(CommonSpecifiersContext.class);
		}
		public CommonSpecifiersContext commonSpecifiers(int i) {
			return getRuleContext(CommonSpecifiersContext.class,i);
		}
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSpecifierQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSpecifierQualifierList(this);
		}
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_specifierQualifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1185); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1185);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
					case 1:
						{
						setState(1183);
						commonSpecifiers();
						}
						break;
					case 2:
						{
						setState(1184);
						typeSpecifier();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1187); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IbOutletQualifierContext extends ParserRuleContext {
		public TerminalNode IB_OUTLET_COLLECTION() { return getToken(ObjectiveCParser.IB_OUTLET_COLLECTION, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode IB_OUTLET() { return getToken(ObjectiveCParser.IB_OUTLET, 0); }
		public IbOutletQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ibOutletQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterIbOutletQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitIbOutletQualifier(this);
		}
	}

	public final IbOutletQualifierContext ibOutletQualifier() throws RecognitionException {
		IbOutletQualifierContext _localctx = new IbOutletQualifierContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_ibOutletQualifier);
		try {
			setState(1195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IB_OUTLET_COLLECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(1189);
				match(IB_OUTLET_COLLECTION);
				setState(1190);
				match(LP);
				setState(1191);
				identifier();
				setState(1192);
				match(RP);
				}
				break;
			case IB_OUTLET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1194);
				match(IB_OUTLET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArcBehaviourSpecifierContext extends ParserRuleContext {
		public TerminalNode WEAK_QUALIFIER() { return getToken(ObjectiveCParser.WEAK_QUALIFIER, 0); }
		public TerminalNode STRONG_QUALIFIER() { return getToken(ObjectiveCParser.STRONG_QUALIFIER, 0); }
		public TerminalNode AUTORELEASING_QUALIFIER() { return getToken(ObjectiveCParser.AUTORELEASING_QUALIFIER, 0); }
		public TerminalNode UNSAFE_UNRETAINED_QUALIFIER() { return getToken(ObjectiveCParser.UNSAFE_UNRETAINED_QUALIFIER, 0); }
		public ArcBehaviourSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arcBehaviourSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArcBehaviourSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArcBehaviourSpecifier(this);
		}
	}

	public final ArcBehaviourSpecifierContext arcBehaviourSpecifier() throws RecognitionException {
		ArcBehaviourSpecifierContext _localctx = new ArcBehaviourSpecifierContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_arcBehaviourSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1197);
			_la = _input.LA(1);
			if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (AUTORELEASING_QUALIFIER - 85)) | (1L << (STRONG_QUALIFIER - 85)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 85)) | (1L << (WEAK_QUALIFIER - 85)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullabilitySpecifierContext extends ParserRuleContext {
		public TerminalNode NULL_UNSPECIFIED() { return getToken(ObjectiveCParser.NULL_UNSPECIFIED, 0); }
		public TerminalNode NULLABLE() { return getToken(ObjectiveCParser.NULLABLE, 0); }
		public TerminalNode NONNULL() { return getToken(ObjectiveCParser.NONNULL, 0); }
		public TerminalNode NULL_RESETTABLE() { return getToken(ObjectiveCParser.NULL_RESETTABLE, 0); }
		public NullabilitySpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullabilitySpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterNullabilitySpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitNullabilitySpecifier(this);
		}
	}

	public final NullabilitySpecifierContext nullabilitySpecifier() throws RecognitionException {
		NullabilitySpecifierContext _localctx = new NullabilitySpecifierContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_nullabilitySpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1199);
			_la = _input.LA(1);
			if ( !(((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (NULL_UNSPECIFIED - 99)) | (1L << (NULLABLE - 99)) | (1L << (NONNULL - 99)) | (1L << (NULL_RESETTABLE - 99)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageClassSpecifierContext extends ParserRuleContext {
		public TerminalNode AUTO() { return getToken(ObjectiveCParser.AUTO, 0); }
		public TerminalNode REGISTER() { return getToken(ObjectiveCParser.REGISTER, 0); }
		public TerminalNode STATIC() { return getToken(ObjectiveCParser.STATIC, 0); }
		public TerminalNode EXTERN() { return getToken(ObjectiveCParser.EXTERN, 0); }
		public StorageClassSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageClassSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStorageClassSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStorageClassSpecifier(this);
		}
	}

	public final StorageClassSpecifierContext storageClassSpecifier() throws RecognitionException {
		StorageClassSpecifierContext _localctx = new StorageClassSpecifierContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_storageClassSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1201);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << EXTERN) | (1L << REGISTER) | (1L << STATIC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypePrefixContext extends ParserRuleContext {
		public TerminalNode BRIDGE() { return getToken(ObjectiveCParser.BRIDGE, 0); }
		public TerminalNode BRIDGE_TRANSFER() { return getToken(ObjectiveCParser.BRIDGE_TRANSFER, 0); }
		public TerminalNode BRIDGE_RETAINED() { return getToken(ObjectiveCParser.BRIDGE_RETAINED, 0); }
		public TerminalNode BLOCK() { return getToken(ObjectiveCParser.BLOCK, 0); }
		public TerminalNode INLINE() { return getToken(ObjectiveCParser.INLINE, 0); }
		public TerminalNode NS_INLINE() { return getToken(ObjectiveCParser.NS_INLINE, 0); }
		public TerminalNode KINDOF() { return getToken(ObjectiveCParser.KINDOF, 0); }
		public TypePrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typePrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypePrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypePrefix(this);
		}
	}

	public final TypePrefixContext typePrefix() throws RecognitionException {
		TypePrefixContext _localctx = new TypePrefixContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_typePrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1203);
			_la = _input.LA(1);
			if ( !(_la==INLINE || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (BLOCK - 86)) | (1L << (BRIDGE - 86)) | (1L << (BRIDGE_RETAINED - 86)) | (1L << (BRIDGE_TRANSFER - 86)) | (1L << (KINDOF - 86)) | (1L << (NS_INLINE - 86)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeQualifierContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(ObjectiveCParser.CONST, 0); }
		public TerminalNode VOLATILE() { return getToken(ObjectiveCParser.VOLATILE, 0); }
		public TerminalNode RESTRICT() { return getToken(ObjectiveCParser.RESTRICT, 0); }
		public ProtocolQualifierContext protocolQualifier() {
			return getRuleContext(ProtocolQualifierContext.class,0);
		}
		public TypeQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeQualifier(this);
		}
	}

	public final TypeQualifierContext typeQualifier() throws RecognitionException {
		TypeQualifierContext _localctx = new TypeQualifierContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_typeQualifier);
		try {
			setState(1209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(1205);
				match(CONST);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1206);
				match(VOLATILE);
				}
				break;
			case RESTRICT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1207);
				match(RESTRICT);
				}
				break;
			case BYCOPY:
			case BYREF:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1208);
				protocolQualifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProtocolQualifierContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(ObjectiveCParser.IN, 0); }
		public TerminalNode OUT() { return getToken(ObjectiveCParser.OUT, 0); }
		public TerminalNode INOUT() { return getToken(ObjectiveCParser.INOUT, 0); }
		public TerminalNode BYCOPY() { return getToken(ObjectiveCParser.BYCOPY, 0); }
		public TerminalNode BYREF() { return getToken(ObjectiveCParser.BYREF, 0); }
		public TerminalNode ONEWAY() { return getToken(ObjectiveCParser.ONEWAY, 0); }
		public ProtocolQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protocolQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterProtocolQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitProtocolQualifier(this);
		}
	}

	public final ProtocolQualifierContext protocolQualifier() throws RecognitionException {
		ProtocolQualifierContext _localctx = new ProtocolQualifierContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_protocolQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1211);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYCOPY) | (1L << BYREF) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends ParserRuleContext {
		public TypeofExpressionContext typeofExpression() {
			return getRuleContext(TypeofExpressionContext.class,0);
		}
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public StructOrUnionSpecifierContext structOrUnionSpecifier() {
			return getRuleContext(StructOrUnionSpecifierContext.class,0);
		}
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public List<TerminalNode> VOID() { return getTokens(ObjectiveCParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(ObjectiveCParser.VOID, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(ObjectiveCParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(ObjectiveCParser.CHAR, i);
		}
		public List<TerminalNode> SHORT() { return getTokens(ObjectiveCParser.SHORT); }
		public TerminalNode SHORT(int i) {
			return getToken(ObjectiveCParser.SHORT, i);
		}
		public List<TerminalNode> INT() { return getTokens(ObjectiveCParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ObjectiveCParser.INT, i);
		}
		public List<TerminalNode> LONG() { return getTokens(ObjectiveCParser.LONG); }
		public TerminalNode LONG(int i) {
			return getToken(ObjectiveCParser.LONG, i);
		}
		public List<TerminalNode> FLOAT() { return getTokens(ObjectiveCParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(ObjectiveCParser.FLOAT, i);
		}
		public List<TerminalNode> DOUBLE() { return getTokens(ObjectiveCParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(ObjectiveCParser.DOUBLE, i);
		}
		public List<TerminalNode> SIGNED() { return getTokens(ObjectiveCParser.SIGNED); }
		public TerminalNode SIGNED(int i) {
			return getToken(ObjectiveCParser.SIGNED, i);
		}
		public List<TerminalNode> UNSIGNED() { return getTokens(ObjectiveCParser.UNSIGNED); }
		public TerminalNode UNSIGNED(int i) {
			return getToken(ObjectiveCParser.UNSIGNED, i);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeSpecifier(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_typeSpecifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				{
				setState(1214); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1213);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << SIGNED) | (1L << UNSIGNED) | (1L << VOID))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1216); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				{
				setState(1218);
				typeofExpression();
				}
				break;
			case 3:
				{
				setState(1219);
				genericTypeSpecifier();
				}
				break;
			case 4:
				{
				setState(1220);
				structOrUnionSpecifier();
				}
				break;
			case 5:
				{
				setState(1221);
				enumSpecifier();
				}
				break;
			case 6:
				{
				setState(1222);
				identifier();
				}
				break;
			}
			setState(1226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				{
				setState(1225);
				pointer();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeofExpressionContext extends ParserRuleContext {
		public TerminalNode TYPEOF() { return getToken(ObjectiveCParser.TYPEOF, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TypeofExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeofExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeofExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeofExpression(this);
		}
	}

	public final TypeofExpressionContext typeofExpression() throws RecognitionException {
		TypeofExpressionContext _localctx = new TypeofExpressionContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_typeofExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1228);
			match(TYPEOF);
			{
			setState(1229);
			match(LP);
			setState(1230);
			expression(0);
			setState(1231);
			match(RP);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclaratorListContext extends ParserRuleContext {
		public List<FieldDeclaratorContext> fieldDeclarator() {
			return getRuleContexts(FieldDeclaratorContext.class);
		}
		public FieldDeclaratorContext fieldDeclarator(int i) {
			return getRuleContext(FieldDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public FieldDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFieldDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFieldDeclaratorList(this);
		}
	}

	public final FieldDeclaratorListContext fieldDeclaratorList() throws RecognitionException {
		FieldDeclaratorListContext _localctx = new FieldDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_fieldDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1233);
			fieldDeclarator();
			setState(1238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1234);
				match(COMMA);
				setState(1235);
				fieldDeclarator();
				}
				}
				setState(1240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FieldDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterFieldDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitFieldDeclarator(this);
		}
	}

	public final FieldDeclaratorContext fieldDeclarator() throws RecognitionException {
		FieldDeclaratorContext _localctx = new FieldDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_fieldDeclarator);
		int _la;
		try {
			setState(1247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1241);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (BOOL - 40)) | (1L << (Class - 40)) | (1L << (BYCOPY - 40)) | (1L << (BYREF - 40)) | (1L << (ID - 40)) | (1L << (IMP - 40)) | (1L << (IN - 40)) | (1L << (INOUT - 40)) | (1L << (ONEWAY - 40)) | (1L << (OUT - 40)) | (1L << (PROTOCOL_ - 40)) | (1L << (SEL - 40)) | (1L << (SELF - 40)) | (1L << (SUPER - 40)) | (1L << (ATOMIC - 40)) | (1L << (NONATOMIC - 40)) | (1L << (RETAIN - 40)) | (1L << (AUTORELEASING_QUALIFIER - 40)) | (1L << (BLOCK - 40)) | (1L << (BRIDGE_RETAINED - 40)) | (1L << (BRIDGE_TRANSFER - 40)) | (1L << (COVARIANT - 40)) | (1L << (CONTRAVARIANT - 40)) | (1L << (DEPRECATED - 40)) | (1L << (KINDOF - 40)) | (1L << (UNUSED - 40)) | (1L << (NULL_UNSPECIFIED - 40)) | (1L << (NULLABLE - 40)) | (1L << (NONNULL - 40)) | (1L << (NULL_RESETTABLE - 40)) | (1L << (NS_INLINE - 40)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (NS_ENUM - 104)) | (1L << (NS_OPTIONS - 104)) | (1L << (ASSIGN - 104)) | (1L << (COPY - 104)) | (1L << (GETTER - 104)) | (1L << (SETTER - 104)) | (1L << (STRONG - 104)) | (1L << (READONLY - 104)) | (1L << (READWRITE - 104)) | (1L << (WEAK - 104)) | (1L << (UNSAFE_UNRETAINED - 104)) | (1L << (IB_OUTLET - 104)) | (1L << (IB_OUTLET_COLLECTION - 104)) | (1L << (IB_INSPECTABLE - 104)) | (1L << (IB_DESIGNABLE - 104)) | (1L << (IDENTIFIER - 104)) | (1L << (LP - 104)) | (1L << (MUL - 104)))) != 0)) {
					{
					setState(1242);
					declarator();
					}
				}

				setState(1245);
				match(COLON);
				setState(1246);
				constant();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumSpecifierContext extends ParserRuleContext {
		public IdentifierContext name;
		public Token type;
		public TerminalNode ENUM() { return getToken(ObjectiveCParser.ENUM, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public EnumeratorListContext enumeratorList() {
			return getRuleContext(EnumeratorListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode NS_OPTIONS() { return getToken(ObjectiveCParser.NS_OPTIONS, 0); }
		public TerminalNode NS_ENUM() { return getToken(ObjectiveCParser.NS_ENUM, 0); }
		public TerminalNode NS_ERROR_ENUM() { return getToken(ObjectiveCParser.NS_ERROR_ENUM, 0); }
		public TerminalNode NS_CLOSED_ENUM() { return getToken(ObjectiveCParser.NS_CLOSED_ENUM, 0); }
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public EnumSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumSpecifier(this);
		}
	}

	public final EnumSpecifierContext enumSpecifier() throws RecognitionException {
		EnumSpecifierContext _localctx = new EnumSpecifierContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_enumSpecifier);
		int _la;
		try {
			setState(1282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(1249);
				match(ENUM);
				setState(1255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
				case 1:
					{
					setState(1251);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
						{
						setState(1250);
						((EnumSpecifierContext)_localctx).name = identifier();
						}
					}

					setState(1253);
					match(COLON);
					setState(1254);
					typeName();
					}
					break;
				}
				setState(1268);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1257);
					identifier();
					setState(1262);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
					case 1:
						{
						setState(1258);
						match(LBRACE);
						setState(1259);
						enumeratorList();
						setState(1260);
						match(RBRACE);
						}
						break;
					}
					}
					break;
				case LBRACE:
					{
					setState(1264);
					match(LBRACE);
					setState(1265);
					enumeratorList();
					setState(1266);
					match(RBRACE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case NS_ENUM:
			case NS_OPTIONS:
			case NS_CLOSED_ENUM:
			case NS_ERROR_ENUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(1270);
				((EnumSpecifierContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (NS_ENUM - 104)) | (1L << (NS_OPTIONS - 104)) | (1L << (NS_CLOSED_ENUM - 104)) | (1L << (NS_ERROR_ENUM - 104)))) != 0)) ) {
					((EnumSpecifierContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1271);
				match(LP);
				setState(1272);
				typeName();
				setState(1275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1273);
					match(COMMA);
					setState(1274);
					((EnumSpecifierContext)_localctx).name = identifier();
					}
				}

				setState(1277);
				match(RP);
				setState(1278);
				match(LBRACE);
				setState(1279);
				enumeratorList();
				setState(1280);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorListContext extends ParserRuleContext {
		public EnumeratorContext enumerator;
		public List<EnumeratorContext> list = new ArrayList<EnumeratorContext>();
		public List<EnumeratorContext> enumerator() {
			return getRuleContexts(EnumeratorContext.class);
		}
		public EnumeratorContext enumerator(int i) {
			return getRuleContext(EnumeratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public EnumeratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumeratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumeratorList(this);
		}
	}

	public final EnumeratorListContext enumeratorList() throws RecognitionException {
		EnumeratorListContext _localctx = new EnumeratorListContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_enumeratorList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1284);
			((EnumeratorListContext)_localctx).enumerator = enumerator();
			((EnumeratorListContext)_localctx).list.add(((EnumeratorListContext)_localctx).enumerator);
			setState(1289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,169,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1285);
					match(COMMA);
					setState(1286);
					((EnumeratorListContext)_localctx).enumerator = enumerator();
					((EnumeratorListContext)_localctx).list.add(((EnumeratorListContext)_localctx).enumerator);
					}
					} 
				}
				setState(1291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,169,_ctx);
			}
			setState(1293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1292);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorContext extends ParserRuleContext {
		public EnumeratorIdentifierContext name;
		public ExpressionContext value;
		public EnumeratorIdentifierContext enumeratorIdentifier() {
			return getRuleContext(EnumeratorIdentifierContext.class,0);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumerator(this);
		}
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1295);
			((EnumeratorContext)_localctx).name = enumeratorIdentifier();
			setState(1300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(1298);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1296);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(1297);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(1303);
				match(ASSIGNMENT);
				setState(1304);
				((EnumeratorContext)_localctx).value = expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(ObjectiveCParser.DEFAULT, 0); }
		public EnumeratorIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterEnumeratorIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitEnumeratorIdentifier(this);
		}
	}

	public final EnumeratorIdentifierContext enumeratorIdentifier() throws RecognitionException {
		EnumeratorIdentifierContext _localctx = new EnumeratorIdentifierContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_enumeratorIdentifier);
		try {
			setState(1309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1307);
				identifier();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1308);
				match(DEFAULT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectDeclaratorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<DeclaratorSuffixContext> declaratorSuffix() {
			return getRuleContexts(DeclaratorSuffixContext.class);
		}
		public DeclaratorSuffixContext declaratorSuffix(int i) {
			return getRuleContext(DeclaratorSuffixContext.class,i);
		}
		public TerminalNode BITXOR() { return getToken(ObjectiveCParser.BITXOR, 0); }
		public BlockParametersContext blockParameters() {
			return getRuleContext(BlockParametersContext.class,0);
		}
		public NullabilitySpecifierContext nullabilitySpecifier() {
			return getRuleContext(NullabilitySpecifierContext.class,0);
		}
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDirectDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDirectDeclarator(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_directDeclarator);
		int _la;
		try {
			setState(1334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1316);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
					{
					setState(1311);
					identifier();
					}
					break;
				case LP:
					{
					setState(1312);
					match(LP);
					setState(1313);
					declarator();
					setState(1314);
					match(RP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1318);
					declaratorSuffix();
					}
					}
					setState(1323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1324);
				match(LP);
				setState(1325);
				match(BITXOR);
				setState(1327);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
				case 1:
					{
					setState(1326);
					nullabilitySpecifier();
					}
					break;
				}
				setState(1330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(1329);
					identifier();
					}
				}

				setState(1332);
				match(RP);
				setState(1333);
				blockParameters();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorSuffixContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public DeclaratorSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDeclaratorSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDeclaratorSuffix(this);
		}
	}

	public final DeclaratorSuffixContext declaratorSuffix() throws RecognitionException {
		DeclaratorSuffixContext _localctx = new DeclaratorSuffixContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_declaratorSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1336);
			match(LBRACK);
			setState(1338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (ADD - 163)) | (1L << (SUB - 163)) | (1L << (CHARACTER_LITERAL - 163)) | (1L << (HEX_LITERAL - 163)) | (1L << (OCTAL_LITERAL - 163)) | (1L << (BINARY_LITERAL - 163)) | (1L << (DECIMAL_LITERAL - 163)) | (1L << (FLOATING_POINT_LITERAL - 163)))) != 0)) {
				{
				setState(1337);
				constantExpression();
				}
			}

			setState(1340);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public ParameterDeclarationListContext parameterDeclarationList() {
			return getRuleContext(ParameterDeclarationListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public TerminalNode ELIPSIS() { return getToken(ObjectiveCParser.ELIPSIS, 0); }
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1342);
			parameterDeclarationList();
			setState(1345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1343);
				match(COMMA);
				setState(1344);
				match(ELIPSIS);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerContext extends ParserRuleContext {
		public PointerContext nextPointer;
		public TerminalNode MUL() { return getToken(ObjectiveCParser.MUL, 0); }
		public PointerQualifierContext pointerQualifier() {
			return getRuleContext(PointerQualifierContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPointer(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_pointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1347);
			match(MUL);
			setState(1349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				{
				setState(1348);
				pointerQualifier();
				}
				break;
			}
			setState(1352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				{
				setState(1351);
				((PointerContext)_localctx).nextPointer = pointer();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression;
		public List<PrimaryExpressionContext> messages = new ArrayList<PrimaryExpressionContext>();
		public OsVersionContext osVersion;
		public List<OsVersionContext> osVersions = new ArrayList<OsVersionContext>();
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> LP() { return getTokens(ObjectiveCParser.LP); }
		public TerminalNode LP(int i) {
			return getToken(ObjectiveCParser.LP, i);
		}
		public List<TerminalNode> RP() { return getTokens(ObjectiveCParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(ObjectiveCParser.RP, i);
		}
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public List<OsVersionContext> osVersion() {
			return getRuleContexts(OsVersionContext.class);
		}
		public OsVersionContext osVersion(int i) {
			return getRuleContext(OsVersionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ObjectiveCParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ObjectiveCParser.DOT, i);
		}
		public List<TerminalNode> COLON() { return getTokens(ObjectiveCParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ObjectiveCParser.COLON, i);
		}
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitMacro(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_macro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1354);
			identifier();
			setState(1392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(1355);
				match(LP);
				setState(1378);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
				case 1:
					{
					setState(1356);
					((MacroContext)_localctx).primaryExpression = primaryExpression();
					((MacroContext)_localctx).messages.add(((MacroContext)_localctx).primaryExpression);
					}
					break;
				case 2:
					{
					setState(1357);
					((MacroContext)_localctx).osVersion = osVersion();
					((MacroContext)_localctx).osVersions.add(((MacroContext)_localctx).osVersion);
					}
					break;
				case 3:
					{
					setState(1358);
					identifier();
					setState(1363);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==DOT) {
						{
						{
						setState(1359);
						match(DOT);
						setState(1360);
						identifier();
						}
						}
						setState(1365);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1376);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LP) {
						{
						setState(1366);
						match(LP);
						setState(1372);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
							{
							{
							setState(1367);
							identifier();
							setState(1368);
							match(COLON);
							}
							}
							setState(1374);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1375);
						match(RP);
						}
					}

					}
					break;
				}
				setState(1387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1380);
					match(COMMA);
					setState(1383);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
					case 1:
						{
						setState(1381);
						((MacroContext)_localctx).primaryExpression = primaryExpression();
						((MacroContext)_localctx).messages.add(((MacroContext)_localctx).primaryExpression);
						}
						break;
					case 2:
						{
						setState(1382);
						((MacroContext)_localctx).osVersion = osVersion();
						((MacroContext)_localctx).osVersions.add(((MacroContext)_localctx).osVersion);
						}
						break;
					}
					}
					}
					setState(1389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1390);
				match(RP);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArrayInitializer(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1394);
			match(LBRACE);
			setState(1399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1395);
				expressions();
				setState(1397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1396);
					match(COMMA);
					}
				}

				}
			}

			setState(1401);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<TerminalNode> DOT() { return getTokens(ObjectiveCParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ObjectiveCParser.DOT, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public StructInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStructInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStructInitializer(this);
		}
	}

	public final StructInitializerContext structInitializer() throws RecognitionException {
		StructInitializerContext _localctx = new StructInitializerContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_structInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1403);
			match(LBRACE);
			setState(1417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(1404);
				match(DOT);
				setState(1405);
				expression(0);
				setState(1411);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1406);
						match(COMMA);
						setState(1407);
						match(DOT);
						setState(1408);
						expression(0);
						}
						} 
					}
					setState(1413);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
				}
				setState(1415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1414);
					match(COMMA);
					}
				}

				}
			}

			setState(1419);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerListContext extends ParserRuleContext {
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInitializerList(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1421);
			initializer();
			setState(1426);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,196,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1422);
					match(COMMA);
					setState(1423);
					initializer();
					}
					} 
				}
				setState(1428);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,196,_ctx);
			}
			setState(1430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1429);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public BlockTypeContext blockType() {
			return getRuleContext(BlockTypeContext.class,0);
		}
		public FunctionPointerContext functionPointer() {
			return getRuleContext(FunctionPointerContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_typeName);
		int _la;
		try {
			setState(1438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1432);
				specifierQualifierList();
				setState(1434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (LP - 137)) | (1L << (LBRACK - 137)) | (1L << (MUL - 137)))) != 0)) {
					{
					setState(1433);
					abstractDeclarator();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1436);
				blockType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1437);
				functionPointer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<AbstractDeclaratorSuffixContext> abstractDeclaratorSuffix() {
			return getRuleContexts(AbstractDeclaratorSuffixContext.class);
		}
		public AbstractDeclaratorSuffixContext abstractDeclaratorSuffix(int i) {
			return getRuleContext(AbstractDeclaratorSuffixContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ObjectiveCParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ObjectiveCParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ObjectiveCParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ObjectiveCParser.RBRACK, i);
		}
		public List<ConstantExpressionContext> constantExpression() {
			return getRuleContexts(ConstantExpressionContext.class);
		}
		public ConstantExpressionContext constantExpression(int i) {
			return getRuleContext(ConstantExpressionContext.class,i);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAbstractDeclarator(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_abstractDeclarator);
		int _la;
		try {
			setState(1463);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1440);
				pointer();
				setState(1442);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (LP - 137)) | (1L << (LBRACK - 137)) | (1L << (MUL - 137)))) != 0)) {
					{
					setState(1441);
					abstractDeclarator();
					}
				}

				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1444);
				match(LP);
				setState(1446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (LP - 137)) | (1L << (LBRACK - 137)) | (1L << (MUL - 137)))) != 0)) {
					{
					setState(1445);
					abstractDeclarator();
					}
				}

				setState(1448);
				match(RP);
				setState(1450); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1449);
					abstractDeclaratorSuffix();
					}
					}
					setState(1452); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LP || _la==LBRACK );
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(1459); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1454);
					match(LBRACK);
					setState(1456);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (ADD - 163)) | (1L << (SUB - 163)) | (1L << (CHARACTER_LITERAL - 163)) | (1L << (HEX_LITERAL - 163)) | (1L << (OCTAL_LITERAL - 163)) | (1L << (BINARY_LITERAL - 163)) | (1L << (DECIMAL_LITERAL - 163)) | (1L << (FLOATING_POINT_LITERAL - 163)))) != 0)) {
						{
						setState(1455);
						constantExpression();
						}
					}

					setState(1458);
					match(RBRACK);
					}
					}
					setState(1461); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACK );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractDeclaratorSuffixContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public ParameterDeclarationListContext parameterDeclarationList() {
			return getRuleContext(ParameterDeclarationListContext.class,0);
		}
		public AbstractDeclaratorSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclaratorSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAbstractDeclaratorSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAbstractDeclaratorSuffix(this);
		}
	}

	public final AbstractDeclaratorSuffixContext abstractDeclaratorSuffix() throws RecognitionException {
		AbstractDeclaratorSuffixContext _localctx = new AbstractDeclaratorSuffixContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_abstractDeclaratorSuffix);
		int _la;
		try {
			setState(1475);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(1465);
				match(LBRACK);
				setState(1467);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (ADD - 163)) | (1L << (SUB - 163)) | (1L << (CHARACTER_LITERAL - 163)) | (1L << (HEX_LITERAL - 163)) | (1L << (OCTAL_LITERAL - 163)) | (1L << (BINARY_LITERAL - 163)) | (1L << (DECIMAL_LITERAL - 163)) | (1L << (FLOATING_POINT_LITERAL - 163)))) != 0)) {
					{
					setState(1466);
					constantExpression();
					}
				}

				setState(1469);
				match(RBRACK);
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1470);
				match(LP);
				setState(1472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (NS_CLOSED_ENUM - 81)) | (1L << (NS_ERROR_ENUM - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (LP - 81)))) != 0)) {
					{
					setState(1471);
					parameterDeclarationList();
					}
				}

				setState(1474);
				match(RP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclarationListContext extends ParserRuleContext {
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ParameterDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterParameterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitParameterDeclarationList(this);
		}
	}

	public final ParameterDeclarationListContext parameterDeclarationList() throws RecognitionException {
		ParameterDeclarationListContext _localctx = new ParameterDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_parameterDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1477);
			parameterDeclaration();
			setState(1482);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,209,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1478);
					match(COMMA);
					setState(1479);
					parameterDeclaration();
					}
					} 
				}
				setState(1484);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,209,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode VOID() { return getToken(ObjectiveCParser.VOID, 0); }
		public FunctionPointerContext functionPointer() {
			return getRuleContext(FunctionPointerContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitParameterDeclaration(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_parameterDeclaration);
		int _la;
		try {
			setState(1491);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1485);
				declarationSpecifiers();
				setState(1487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (BOOL - 40)) | (1L << (Class - 40)) | (1L << (BYCOPY - 40)) | (1L << (BYREF - 40)) | (1L << (ID - 40)) | (1L << (IMP - 40)) | (1L << (IN - 40)) | (1L << (INOUT - 40)) | (1L << (ONEWAY - 40)) | (1L << (OUT - 40)) | (1L << (PROTOCOL_ - 40)) | (1L << (SEL - 40)) | (1L << (SELF - 40)) | (1L << (SUPER - 40)) | (1L << (ATOMIC - 40)) | (1L << (NONATOMIC - 40)) | (1L << (RETAIN - 40)) | (1L << (AUTORELEASING_QUALIFIER - 40)) | (1L << (BLOCK - 40)) | (1L << (BRIDGE_RETAINED - 40)) | (1L << (BRIDGE_TRANSFER - 40)) | (1L << (COVARIANT - 40)) | (1L << (CONTRAVARIANT - 40)) | (1L << (DEPRECATED - 40)) | (1L << (KINDOF - 40)) | (1L << (UNUSED - 40)) | (1L << (NULL_UNSPECIFIED - 40)) | (1L << (NULLABLE - 40)) | (1L << (NONNULL - 40)) | (1L << (NULL_RESETTABLE - 40)) | (1L << (NS_INLINE - 40)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (NS_ENUM - 104)) | (1L << (NS_OPTIONS - 104)) | (1L << (ASSIGN - 104)) | (1L << (COPY - 104)) | (1L << (GETTER - 104)) | (1L << (SETTER - 104)) | (1L << (STRONG - 104)) | (1L << (READONLY - 104)) | (1L << (READWRITE - 104)) | (1L << (WEAK - 104)) | (1L << (UNSAFE_UNRETAINED - 104)) | (1L << (IB_OUTLET - 104)) | (1L << (IB_OUTLET_COLLECTION - 104)) | (1L << (IB_INSPECTABLE - 104)) | (1L << (IB_DESIGNABLE - 104)) | (1L << (IDENTIFIER - 104)) | (1L << (LP - 104)) | (1L << (MUL - 104)))) != 0)) {
					{
					setState(1486);
					declarator();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1489);
				match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1490);
				functionPointer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDeclarator(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUL) {
				{
				setState(1493);
				pointer();
				}
			}

			setState(1496);
			directDeclarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public SynchronizedStatementContext synchronizedStatement() {
			return getRuleContext(SynchronizedStatementContext.class,0);
		}
		public AutoreleaseStatementContext autoreleaseStatement() {
			return getRuleContext(AutoreleaseStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryBlockContext tryBlock() {
			return getRuleContext(TryBlockContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_statement);
		try {
			setState(1539);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1498);
				labeledStatement();
				setState(1500);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
				case 1:
					{
					setState(1499);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1502);
				compoundStatement();
				setState(1504);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
				case 1:
					{
					setState(1503);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1506);
				selectionStatement();
				setState(1508);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
				case 1:
					{
					setState(1507);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1510);
				iterationStatement();
				setState(1512);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
				case 1:
					{
					setState(1511);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1514);
				jumpStatement();
				setState(1516);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
				case 1:
					{
					setState(1515);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1518);
				synchronizedStatement();
				setState(1520);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
				case 1:
					{
					setState(1519);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1522);
				autoreleaseStatement();
				setState(1524);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
				case 1:
					{
					setState(1523);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1526);
				throwStatement();
				setState(1528);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
				case 1:
					{
					setState(1527);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1530);
				tryBlock();
				setState(1532);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
				case 1:
					{
					setState(1531);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1534);
				expressions();
				setState(1536);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
				case 1:
					{
					setState(1535);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1538);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitLabeledStatement(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_labeledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1541);
			identifier();
			setState(1542);
			match(COLON);
			setState(1543);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeExpressionContext extends ParserRuleContext {
		public List<ConstantExpressionContext> constantExpression() {
			return getRuleContexts(ConstantExpressionContext.class);
		}
		public ConstantExpressionContext constantExpression(int i) {
			return getRuleContext(ConstantExpressionContext.class,i);
		}
		public TerminalNode ELIPSIS() { return getToken(ObjectiveCParser.ELIPSIS, 0); }
		public RangeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterRangeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitRangeExpression(this);
		}
	}

	public final RangeExpressionContext rangeExpression() throws RecognitionException {
		RangeExpressionContext _localctx = new RangeExpressionContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_rangeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1545);
			constantExpression();
			setState(1548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELIPSIS) {
				{
				setState(1546);
				match(ELIPSIS);
				setState(1547);
				constantExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCompoundStatement(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1550);
			match(LBRACE);
			setState(1555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BREAK) | (1L << CHAR) | (1L << CONST) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << RETURN) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << SWITCH) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (SYNCHRONIZED - 69)) | (1L << (THROW - 69)) | (1L << (TRY - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (ATTRIBUTE - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (STRONG_QUALIFIER - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 69)) | (1L << (UNUSED - 69)) | (1L << (WEAK_QUALIFIER - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (NS_CLOSED_ENUM - 69)) | (1L << (NS_ERROR_ENUM - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACE - 136)) | (1L << (LBRACK - 136)) | (1L << (SEMI - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1553);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
				case 1:
					{
					setState(1551);
					declaration();
					}
					break;
				case 2:
					{
					setState(1552);
					statement();
					}
					break;
				}
				}
				setState(1557);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1558);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionStatementContext extends ParserRuleContext {
		public StatementContext ifBody;
		public StatementContext elseBody;
		public TerminalNode IF() { return getToken(ObjectiveCParser.IF, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ObjectiveCParser.ELSE, 0); }
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSelectionStatement(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_selectionStatement);
		try {
			setState(1570);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1560);
				match(IF);
				setState(1561);
				match(LP);
				setState(1562);
				expression(0);
				setState(1563);
				match(RP);
				setState(1564);
				((SelectionStatementContext)_localctx).ifBody = statement();
				setState(1567);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,227,_ctx) ) {
				case 1:
					{
					setState(1565);
					match(ELSE);
					setState(1566);
					((SelectionStatementContext)_localctx).elseBody = statement();
					}
					break;
				}
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 2);
				{
				setState(1569);
				switchStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(ObjectiveCParser.SWITCH, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public SwitchBlockContext switchBlock() {
			return getRuleContext(SwitchBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1572);
			match(SWITCH);
			setState(1573);
			match(LP);
			setState(1574);
			expression(0);
			setState(1575);
			match(RP);
			setState(1576);
			switchBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ObjectiveCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ObjectiveCParser.RBRACE, 0); }
		public List<SwitchSectionContext> switchSection() {
			return getRuleContexts(SwitchSectionContext.class);
		}
		public SwitchSectionContext switchSection(int i) {
			return getRuleContext(SwitchSectionContext.class,i);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSwitchBlock(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_switchBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1578);
			match(LBRACE);
			setState(1582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1579);
				switchSection();
				}
				}
				setState(1584);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1585);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchSectionContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSwitchSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSwitchSection(this);
		}
	}

	public final SwitchSectionContext switchSection() throws RecognitionException {
		SwitchSectionContext _localctx = new SwitchSectionContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_switchSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1588); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1587);
				switchLabel();
				}
				}
				setState(1590); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(1593); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1592);
				statement();
				}
				}
				setState(1595); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << RETURN) | (1L << SIZEOF) | (1L << SWITCH) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (SYNCHRONIZED - 69)) | (1L << (THROW - 69)) | (1L << (TRY - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACE - 136)) | (1L << (LBRACK - 136)) | (1L << (SEMI - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(ObjectiveCParser.CASE, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public RangeExpressionContext rangeExpression() {
			return getRuleContext(RangeExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode DEFAULT() { return getToken(ObjectiveCParser.DEFAULT, 0); }
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitSwitchLabel(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_switchLabel);
		try {
			setState(1609);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1597);
				match(CASE);
				setState(1603);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case BOOL:
				case Class:
				case BYCOPY:
				case BYREF:
				case ID:
				case IMP:
				case IN:
				case INOUT:
				case NIL:
				case NO:
				case NULL:
				case ONEWAY:
				case OUT:
				case PROTOCOL_:
				case SEL:
				case SELF:
				case SUPER:
				case YES:
				case ATOMIC:
				case NONATOMIC:
				case RETAIN:
				case AUTORELEASING_QUALIFIER:
				case BLOCK:
				case BRIDGE_RETAINED:
				case BRIDGE_TRANSFER:
				case COVARIANT:
				case CONTRAVARIANT:
				case DEPRECATED:
				case KINDOF:
				case UNUSED:
				case NULL_UNSPECIFIED:
				case NULLABLE:
				case NONNULL:
				case NULL_RESETTABLE:
				case NS_INLINE:
				case NS_ENUM:
				case NS_OPTIONS:
				case ASSIGN:
				case COPY:
				case GETTER:
				case SETTER:
				case STRONG:
				case READONLY:
				case READWRITE:
				case WEAK:
				case UNSAFE_UNRETAINED:
				case IB_OUTLET:
				case IB_OUTLET_COLLECTION:
				case IB_INSPECTABLE:
				case IB_DESIGNABLE:
				case IDENTIFIER:
				case ADD:
				case SUB:
				case CHARACTER_LITERAL:
				case HEX_LITERAL:
				case OCTAL_LITERAL:
				case BINARY_LITERAL:
				case DECIMAL_LITERAL:
				case FLOATING_POINT_LITERAL:
					{
					setState(1598);
					rangeExpression();
					}
					break;
				case LP:
					{
					setState(1599);
					match(LP);
					setState(1600);
					rangeExpression();
					setState(1601);
					match(RP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1605);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1607);
				match(DEFAULT);
				setState(1608);
				match(COLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationStatementContext extends ParserRuleContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoStatementContext doStatement() {
			return getRuleContext(DoStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForInStatementContext forInStatement() {
			return getRuleContext(ForInStatementContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitIterationStatement(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_iterationStatement);
		try {
			setState(1615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1611);
				whileStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1612);
				doStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1613);
				forStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1614);
				forInStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ObjectiveCParser.WHILE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1617);
			match(WHILE);
			setState(1618);
			match(LP);
			setState(1619);
			expression(0);
			setState(1620);
			match(RP);
			setState(1621);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(ObjectiveCParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(ObjectiveCParser.WHILE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public DoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterDoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitDoStatement(this);
		}
	}

	public final DoStatementContext doStatement() throws RecognitionException {
		DoStatementContext _localctx = new DoStatementContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_doStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1623);
			match(DO);
			setState(1624);
			statement();
			setState(1625);
			match(WHILE);
			setState(1626);
			match(LP);
			setState(1627);
			expression(0);
			setState(1628);
			match(RP);
			setState(1629);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ObjectiveCParser.FOR, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public List<TerminalNode> SEMI() { return getTokens(ObjectiveCParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ObjectiveCParser.SEMI, i);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForLoopInitializerContext forLoopInitializer() {
			return getRuleContext(ForLoopInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1631);
			match(FOR);
			setState(1632);
			match(LP);
			setState(1634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (ATTRIBUTE - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (STRONG_QUALIFIER - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 69)) | (1L << (UNUSED - 69)) | (1L << (WEAK_QUALIFIER - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (NS_CLOSED_ENUM - 69)) | (1L << (NS_ERROR_ENUM - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1633);
				forLoopInitializer();
				}
			}

			setState(1636);
			match(SEMI);
			setState(1638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1637);
				expression(0);
				}
			}

			setState(1640);
			match(SEMI);
			setState(1642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1641);
				expressions();
				}
			}

			setState(1644);
			match(RP);
			setState(1645);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForLoopInitializerContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ForLoopInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoopInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterForLoopInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitForLoopInitializer(this);
		}
	}

	public final ForLoopInitializerContext forLoopInitializer() throws RecognitionException {
		ForLoopInitializerContext _localctx = new ForLoopInitializerContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_forLoopInitializer);
		try {
			setState(1651);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1647);
				declarationSpecifiers();
				setState(1648);
				initDeclaratorList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1650);
				expressions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ObjectiveCParser.FOR, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeVariableDeclaratorContext typeVariableDeclarator() {
			return getRuleContext(TypeVariableDeclaratorContext.class,0);
		}
		public TerminalNode IN() { return getToken(ObjectiveCParser.IN, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterForInStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitForInStatement(this);
		}
	}

	public final ForInStatementContext forInStatement() throws RecognitionException {
		ForInStatementContext _localctx = new ForInStatementContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_forInStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1653);
			match(FOR);
			setState(1654);
			match(LP);
			setState(1655);
			typeVariableDeclarator();
			setState(1656);
			match(IN);
			setState(1658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1657);
				expression(0);
				}
			}

			setState(1660);
			match(RP);
			setState(1661);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode GOTO() { return getToken(ObjectiveCParser.GOTO, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CONTINUE() { return getToken(ObjectiveCParser.CONTINUE, 0); }
		public TerminalNode BREAK() { return getToken(ObjectiveCParser.BREAK, 0); }
		public TerminalNode RETURN() { return getToken(ObjectiveCParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitJumpStatement(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_jumpStatement);
		try {
			setState(1671);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GOTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(1663);
				match(GOTO);
				setState(1664);
				identifier();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1665);
				match(CONTINUE);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 3);
				{
				setState(1666);
				match(BREAK);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(1667);
				match(RETURN);
				setState(1669);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
				case 1:
					{
					setState(1668);
					expression(0);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_expressions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1673);
			expression(0);
			setState(1678);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,242,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1674);
					match(COMMA);
					setState(1675);
					expression(0);
					}
					} 
				}
				setState(1680);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,242,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext assignmentExpression;
		public Token op;
		public ExpressionContext trueExpression;
		public ExpressionContext falseExpression;
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ObjectiveCParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ObjectiveCParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ObjectiveCParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public List<TerminalNode> LT() { return getTokens(ObjectiveCParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(ObjectiveCParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(ObjectiveCParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(ObjectiveCParser.GT, i);
		}
		public TerminalNode LE() { return getToken(ObjectiveCParser.LE, 0); }
		public TerminalNode GE() { return getToken(ObjectiveCParser.GE, 0); }
		public TerminalNode NOTEQUAL() { return getToken(ObjectiveCParser.NOTEQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(ObjectiveCParser.EQUAL, 0); }
		public TerminalNode BITAND() { return getToken(ObjectiveCParser.BITAND, 0); }
		public TerminalNode BITXOR() { return getToken(ObjectiveCParser.BITXOR, 0); }
		public TerminalNode BITOR() { return getToken(ObjectiveCParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(ObjectiveCParser.AND, 0); }
		public TerminalNode OR() { return getToken(ObjectiveCParser.OR, 0); }
		public TerminalNode QUESTION() { return getToken(ObjectiveCParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 266;
		enterRecursionRule(_localctx, 266, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1691);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
			case 1:
				{
				setState(1682);
				castExpression();
				}
				break;
			case 2:
				{
				setState(1683);
				match(LP);
				setState(1684);
				compoundStatement();
				setState(1685);
				match(RP);
				}
				break;
			case 3:
				{
				setState(1687);
				unaryExpression();
				setState(1688);
				assignmentOperator();
				setState(1689);
				((ExpressionContext)_localctx).assignmentExpression = expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1737);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1735);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,246,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1693);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1694);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (MUL - 165)) | (1L << (DIV - 165)) | (1L << (MOD - 165)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1695);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1696);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1697);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1698);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1699);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1704);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LT:
							{
							setState(1700);
							match(LT);
							setState(1701);
							match(LT);
							}
							break;
						case GT:
							{
							setState(1702);
							match(GT);
							setState(1703);
							match(GT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1706);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1707);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1708);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (GT - 149)) | (1L << (LT - 149)) | (1L << (LE - 149)) | (1L << (GE - 149)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1709);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1710);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1711);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1712);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1713);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1714);
						((ExpressionContext)_localctx).op = match(BITAND);
						setState(1715);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1716);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1717);
						((ExpressionContext)_localctx).op = match(BITXOR);
						setState(1718);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1719);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1720);
						((ExpressionContext)_localctx).op = match(BITOR);
						setState(1721);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1722);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1723);
						((ExpressionContext)_localctx).op = match(AND);
						setState(1724);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1725);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1726);
						((ExpressionContext)_localctx).op = match(OR);
						setState(1727);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1728);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1729);
						match(QUESTION);
						setState(1731);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
							{
							setState(1730);
							((ExpressionContext)_localctx).trueExpression = expression(0);
							}
						}

						setState(1733);
						match(COLON);
						setState(1734);
						((ExpressionContext)_localctx).falseExpression = expression(4);
						}
						break;
					}
					} 
				}
				setState(1739);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode ASSIGNMENT() { return getToken(ObjectiveCParser.ASSIGNMENT, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(ObjectiveCParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(ObjectiveCParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(ObjectiveCParser.MOD_ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(ObjectiveCParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(ObjectiveCParser.SUB_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(ObjectiveCParser.LSHIFT_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(ObjectiveCParser.RSHIFT_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(ObjectiveCParser.AND_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(ObjectiveCParser.XOR_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(ObjectiveCParser.OR_ASSIGN, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1740);
			_la = _input.LA(1);
			if ( !(((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (ASSIGNMENT - 148)) | (1L << (ADD_ASSIGN - 148)) | (1L << (SUB_ASSIGN - 148)) | (1L << (MUL_ASSIGN - 148)) | (1L << (DIV_ASSIGN - 148)) | (1L << (AND_ASSIGN - 148)) | (1L << (OR_ASSIGN - 148)) | (1L << (XOR_ASSIGN - 148)) | (1L << (MOD_ASSIGN - 148)) | (1L << (LSHIFT_ASSIGN - 148)) | (1L << (RSHIFT_ASSIGN - 148)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitCastExpression(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_castExpression);
		try {
			setState(1751);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1742);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1743);
				match(LP);
				setState(1744);
				typeName();
				setState(1745);
				match(RP);
				}
				setState(1749);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
				case 1:
					{
					setState(1747);
					castExpression();
					}
					break;
				case 2:
					{
					setState(1748);
					initializer();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public StructInitializerContext structInitializer() {
			return getRuleContext(StructInitializerContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_initializer);
		try {
			setState(1756);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1753);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1754);
				arrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1755);
				structInitializer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitConstantExpression(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_constantExpression);
		try {
			setState(1760);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case Class:
			case BYCOPY:
			case BYREF:
			case ID:
			case IMP:
			case IN:
			case INOUT:
			case ONEWAY:
			case OUT:
			case PROTOCOL_:
			case SEL:
			case SELF:
			case SUPER:
			case ATOMIC:
			case NONATOMIC:
			case RETAIN:
			case AUTORELEASING_QUALIFIER:
			case BLOCK:
			case BRIDGE_RETAINED:
			case BRIDGE_TRANSFER:
			case COVARIANT:
			case CONTRAVARIANT:
			case DEPRECATED:
			case KINDOF:
			case UNUSED:
			case NULL_UNSPECIFIED:
			case NULLABLE:
			case NONNULL:
			case NULL_RESETTABLE:
			case NS_INLINE:
			case NS_ENUM:
			case NS_OPTIONS:
			case ASSIGN:
			case COPY:
			case GETTER:
			case SETTER:
			case STRONG:
			case READONLY:
			case READWRITE:
			case WEAK:
			case UNSAFE_UNRETAINED:
			case IB_OUTLET:
			case IB_OUTLET_COLLECTION:
			case IB_INSPECTABLE:
			case IB_DESIGNABLE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1758);
				identifier();
				}
				break;
			case TRUE:
			case FALSE:
			case NIL:
			case NO:
			case NULL:
			case YES:
			case ADD:
			case SUB:
			case CHARACTER_LITERAL:
			case HEX_LITERAL:
			case OCTAL_LITERAL:
			case BINARY_LITERAL:
			case DECIMAL_LITERAL:
			case FLOATING_POINT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1759);
				constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public Token op;
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode SIZEOF() { return getToken(ObjectiveCParser.SIZEOF, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode INC() { return getToken(ObjectiveCParser.INC, 0); }
		public TerminalNode DEC() { return getToken(ObjectiveCParser.DEC, 0); }
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_unaryExpression);
		int _la;
		try {
			setState(1776);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1762);
				postfixExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1763);
				match(SIZEOF);
				setState(1769);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(1764);
					unaryExpression();
					}
					break;
				case 2:
					{
					setState(1765);
					match(LP);
					setState(1766);
					typeSpecifier();
					setState(1767);
					match(RP);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1771);
				((UnaryExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((UnaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1772);
				unaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1773);
				unaryOperator();
				setState(1774);
				castExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode BITAND() { return getToken(ObjectiveCParser.BITAND, 0); }
		public TerminalNode MUL() { return getToken(ObjectiveCParser.MUL, 0); }
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public TerminalNode TILDE() { return getToken(ObjectiveCParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(ObjectiveCParser.BANG, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitUnaryOperator(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1778);
			_la = _input.LA(1);
			if ( !(((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (BANG - 151)) | (1L << (TILDE - 151)) | (1L << (ADD - 151)) | (1L << (SUB - 151)) | (1L << (MUL - 151)) | (1L << (BITAND - 151)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ObjectiveCParser.DOT, 0); }
		public TerminalNode STRUCTACCESS() { return getToken(ObjectiveCParser.STRUCTACCESS, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPostfixExpression(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 280;
		enterRecursionRule(_localctx, 280, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1781);
			primaryExpression();
			setState(1785);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1782);
					postfix();
					}
					} 
				}
				setState(1787);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1799);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,256,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PostfixExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
					setState(1788);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1789);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==STRUCTACCESS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1790);
					identifier();
					setState(1794);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1791);
							postfix();
							}
							} 
						}
						setState(1796);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					}
					}
					} 
				}
				setState(1801);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,256,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public Token RP;
		public List<Token> macroArguments = new ArrayList<Token>();
		public Token _tset3557;
		public Token op;
		public TerminalNode LBRACK() { return getToken(ObjectiveCParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ObjectiveCParser.RBRACK, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public List<TerminalNode> RP() { return getTokens(ObjectiveCParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(ObjectiveCParser.RP, i);
		}
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public TerminalNode INC() { return getToken(ObjectiveCParser.INC, 0); }
		public TerminalNode DEC() { return getToken(ObjectiveCParser.DEC, 0); }
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_postfix);
		int _la;
		try {
			setState(1820);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1802);
				match(LBRACK);
				setState(1803);
				expression(0);
				setState(1804);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1806);
				match(LP);
				setState(1808);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (NS_CLOSED_ENUM - 69)) | (1L << (NS_ERROR_ENUM - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (LP - 136)) | (1L << (LBRACK - 136)) | (1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
					{
					setState(1807);
					argumentExpressionList();
					}
				}

				setState(1810);
				match(RP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1811);
				match(LP);
				setState(1814); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(1814);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
					case 1:
						{
						setState(1812);
						match(COMMA);
						}
						break;
					case 2:
						{
						setState(1813);
						((PostfixContext)_localctx)._tset3557 = _input.LT(1);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==RP) ) {
							((PostfixContext)_localctx)._tset3557 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						((PostfixContext)_localctx).macroArguments.add(((PostfixContext)_localctx)._tset3557);
						}
						break;
					}
					}
					setState(1816); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BREAK) | (1L << CASE) | (1L << CHAR) | (1L << CONST) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << ELSE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << RETURN) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << SWITCH) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << WHILE) | (1L << BOOL_) | (1L << COMPLEX) | (1L << IMAGINERY) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << CATCH) | (1L << CLASS) | (1L << DYNAMIC) | (1L << ENCODE) | (1L << END))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FINALLY - 64)) | (1L << (IMPLEMENTATION - 64)) | (1L << (INTERFACE - 64)) | (1L << (IMPORT - 64)) | (1L << (PACKAGE - 64)) | (1L << (PROTOCOL - 64)) | (1L << (OPTIONAL - 64)) | (1L << (PRIVATE - 64)) | (1L << (PROPERTY - 64)) | (1L << (PROTECTED - 64)) | (1L << (PUBLIC - 64)) | (1L << (REQUIRED - 64)) | (1L << (SELECTOR - 64)) | (1L << (SYNCHRONIZED - 64)) | (1L << (SYNTHESIZE - 64)) | (1L << (THROW - 64)) | (1L << (TRY - 64)) | (1L << (ATOMIC - 64)) | (1L << (NONATOMIC - 64)) | (1L << (RETAIN - 64)) | (1L << (ATTRIBUTE - 64)) | (1L << (AUTORELEASING_QUALIFIER - 64)) | (1L << (BLOCK - 64)) | (1L << (BRIDGE - 64)) | (1L << (BRIDGE_RETAINED - 64)) | (1L << (BRIDGE_TRANSFER - 64)) | (1L << (COVARIANT - 64)) | (1L << (CONTRAVARIANT - 64)) | (1L << (DEPRECATED - 64)) | (1L << (KINDOF - 64)) | (1L << (STRONG_QUALIFIER - 64)) | (1L << (TYPEOF - 64)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 64)) | (1L << (UNUSED - 64)) | (1L << (WEAK_QUALIFIER - 64)) | (1L << (NULL_UNSPECIFIED - 64)) | (1L << (NULLABLE - 64)) | (1L << (NONNULL - 64)) | (1L << (NULL_RESETTABLE - 64)) | (1L << (NS_INLINE - 64)) | (1L << (NS_ENUM - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_CLOSED_ENUM - 64)) | (1L << (NS_TYPED_EXTENSIBLE_ENUM - 64)) | (1L << (NS_ERROR_ENUM - 64)) | (1L << (ASSIGN - 64)) | (1L << (COPY - 64)) | (1L << (GETTER - 64)) | (1L << (SETTER - 64)) | (1L << (STRONG - 64)) | (1L << (READONLY - 64)) | (1L << (READWRITE - 64)) | (1L << (WEAK - 64)) | (1L << (UNSAFE_UNRETAINED - 64)) | (1L << (IB_OUTLET - 64)) | (1L << (IB_OUTLET_COLLECTION - 64)) | (1L << (IB_INSPECTABLE - 64)) | (1L << (IB_DESIGNABLE - 64)) | (1L << (NS_ASSUME_NONNULL_BEGIN - 64)) | (1L << (NS_ASSUME_NONNULL_END - 64)) | (1L << (EXTERN_SUFFIX - 64)) | (1L << (IOS_SUFFIX - 64)) | (1L << (MAC_SUFFIX - 64)) | (1L << (TVOS_PROHIBITED - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (NS_NOESCAPE - 128)) | (1L << (EXPORT_SUFFIX - 128)) | (1L << (NS_RETURNS_RETAINED - 128)) | (1L << (NS_RETURNS_NOT_RETAINED - 128)) | (1L << (NS_RETURNS_INNER_POINTER - 128)) | (1L << (CF_RETURNS_RETAINED - 128)) | (1L << (CF_RETURNS_NOT_RETAINED - 128)) | (1L << (CF_CONSUMED - 128)) | (1L << (IDENTIFIER - 128)) | (1L << (LP - 128)) | (1L << (LBRACE - 128)) | (1L << (RBRACE - 128)) | (1L << (LBRACK - 128)) | (1L << (RBRACK - 128)) | (1L << (SEMI - 128)) | (1L << (COMMA - 128)) | (1L << (DOT - 128)) | (1L << (STRUCTACCESS - 128)) | (1L << (AT - 128)) | (1L << (ASSIGNMENT - 128)) | (1L << (GT - 128)) | (1L << (LT - 128)) | (1L << (BANG - 128)) | (1L << (TILDE - 128)) | (1L << (QUESTION - 128)) | (1L << (COLON - 128)) | (1L << (EQUAL - 128)) | (1L << (LE - 128)) | (1L << (GE - 128)) | (1L << (NOTEQUAL - 128)) | (1L << (AND - 128)) | (1L << (OR - 128)) | (1L << (INC - 128)) | (1L << (DEC - 128)) | (1L << (ADD - 128)) | (1L << (SUB - 128)) | (1L << (MUL - 128)) | (1L << (DIV - 128)) | (1L << (BITAND - 128)) | (1L << (BITOR - 128)) | (1L << (BITXOR - 128)) | (1L << (MOD - 128)) | (1L << (ADD_ASSIGN - 128)) | (1L << (SUB_ASSIGN - 128)) | (1L << (MUL_ASSIGN - 128)) | (1L << (DIV_ASSIGN - 128)) | (1L << (AND_ASSIGN - 128)) | (1L << (OR_ASSIGN - 128)) | (1L << (XOR_ASSIGN - 128)) | (1L << (MOD_ASSIGN - 128)) | (1L << (LSHIFT_ASSIGN - 128)) | (1L << (RSHIFT_ASSIGN - 128)) | (1L << (ELIPSIS - 128)) | (1L << (CHARACTER_LITERAL - 128)) | (1L << (STRING_START - 128)) | (1L << (HEX_LITERAL - 128)) | (1L << (OCTAL_LITERAL - 128)) | (1L << (BINARY_LITERAL - 128)) | (1L << (DECIMAL_LITERAL - 128)) | (1L << (FLOATING_POINT_LITERAL - 128)) | (1L << (VERSION_SEMATIC - 128)) | (1L << (WS - 128)) | (1L << (MULTI_COMMENT - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (SINGLE_COMMENT - 192)) | (1L << (BACKSLASH - 192)) | (1L << (SHARP - 192)) | (1L << (STRING_NEWLINE - 192)) | (1L << (STRING_END - 192)) | (1L << (STRING_VALUE - 192)) | (1L << (DIRECTIVE_IMPORT - 192)) | (1L << (DIRECTIVE_INCLUDE - 192)) | (1L << (DIRECTIVE_PRAGMA - 192)) | (1L << (DIRECTIVE_DEFINE - 192)) | (1L << (DIRECTIVE_DEFINED - 192)) | (1L << (DIRECTIVE_IF - 192)) | (1L << (DIRECTIVE_ELIF - 192)) | (1L << (DIRECTIVE_ELSE - 192)) | (1L << (DIRECTIVE_UNDEF - 192)) | (1L << (DIRECTIVE_IFDEF - 192)) | (1L << (DIRECTIVE_IFNDEF - 192)) | (1L << (DIRECTIVE_ENDIF - 192)) | (1L << (DIRECTIVE_TRUE - 192)) | (1L << (DIRECTIVE_FALSE - 192)) | (1L << (DIRECTIVE_ERROR - 192)) | (1L << (DIRECTIVE_WARNING - 192)) | (1L << (DIRECTIVE_BANG - 192)) | (1L << (DIRECTIVE_LP - 192)) | (1L << (DIRECTIVE_RP - 192)) | (1L << (DIRECTIVE_EQUAL - 192)) | (1L << (DIRECTIVE_NOTEQUAL - 192)) | (1L << (DIRECTIVE_AND - 192)) | (1L << (DIRECTIVE_OR - 192)) | (1L << (DIRECTIVE_LT - 192)) | (1L << (DIRECTIVE_GT - 192)) | (1L << (DIRECTIVE_LE - 192)) | (1L << (DIRECTIVE_GE - 192)) | (1L << (DIRECTIVE_ADD - 192)) | (1L << (DIRECTIVE_SUB - 192)) | (1L << (DIRECTIVE_MUL - 192)) | (1L << (DIRECTIVE_DIV - 192)) | (1L << (DIRECTIVE_BITAND - 192)) | (1L << (DIRECTIVE_BITOR - 192)) | (1L << (DIRECTIVE_BITXOR - 192)) | (1L << (DIRECTIVE_MOD - 192)) | (1L << (DIRECTIVE_DOT - 192)) | (1L << (DIRECTIVE_STRING - 192)) | (1L << (DIRECTIVE_ID - 192)) | (1L << (DIRECTIVE_DECIMAL_LITERAL - 192)) | (1L << (DIRECTIVE_FLOAT - 192)) | (1L << (DIRECTIVE_NEWLINE - 192)) | (1L << (DIRECTIVE_MULTI_COMMENT - 192)) | (1L << (DIRECTIVE_SINGLE_COMMENT - 192)) | (1L << (DIRECTIVE_BACKSLASH_NEWLINE - 192)) | (1L << (DIRECTIVE_TEXT_NEWLINE - 192)) | (1L << (DIRECTIVE_TEXT - 192)))) != 0) );
				setState(1818);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1819);
				((PostfixContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((PostfixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public List<ArgumentExpressionContext> argumentExpression() {
			return getRuleContexts(ArgumentExpressionContext.class);
		}
		public ArgumentExpressionContext argumentExpression(int i) {
			return getRuleContext(ArgumentExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArgumentExpressionList(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1822);
			argumentExpression();
			setState(1827);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1823);
				match(COMMA);
				setState(1824);
				argumentExpression();
				}
				}
				setState(1829);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public ArgumentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterArgumentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitArgumentExpression(this);
		}
	}

	public final ArgumentExpressionContext argumentExpression() throws RecognitionException {
		ArgumentExpressionContext _localctx = new ArgumentExpressionContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_argumentExpression);
		try {
			setState(1832);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1830);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1831);
				typeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OsVersionContext extends ParserRuleContext {
		public IdentifierContext os;
		public Token min;
		public Token max;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<TerminalNode> FLOATING_POINT_LITERAL() { return getTokens(ObjectiveCParser.FLOATING_POINT_LITERAL); }
		public TerminalNode FLOATING_POINT_LITERAL(int i) {
			return getToken(ObjectiveCParser.FLOATING_POINT_LITERAL, i);
		}
		public List<TerminalNode> VERSION_SEMATIC() { return getTokens(ObjectiveCParser.VERSION_SEMATIC); }
		public TerminalNode VERSION_SEMATIC(int i) {
			return getToken(ObjectiveCParser.VERSION_SEMATIC, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ObjectiveCParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ObjectiveCParser.IDENTIFIER, i);
		}
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public OsVersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_osVersion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterOsVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitOsVersion(this);
		}
	}

	public final OsVersionContext osVersion() throws RecognitionException {
		OsVersionContext _localctx = new OsVersionContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_osVersion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1834);
			((OsVersionContext)_localctx).os = identifier();
			}
			setState(1842);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(1835);
				match(LP);
				setState(1836);
				((OsVersionContext)_localctx).min = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)) | (1L << (VERSION_SEMATIC - 136)))) != 0)) ) {
					((OsVersionContext)_localctx).min = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1839);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1837);
					match(COMMA);
					setState(1838);
					((OsVersionContext)_localctx).max = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (IDENTIFIER - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)) | (1L << (VERSION_SEMATIC - 136)))) != 0)) ) {
						((OsVersionContext)_localctx).max = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1841);
				match(RP);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public MessageExpressionContext messageExpression() {
			return getRuleContext(MessageExpressionContext.class,0);
		}
		public SelectorExpressionContext selectorExpression() {
			return getRuleContext(SelectorExpressionContext.class,0);
		}
		public ProtocolExpressionContext protocolExpression() {
			return getRuleContext(ProtocolExpressionContext.class,0);
		}
		public EncodeExpressionContext encodeExpression() {
			return getRuleContext(EncodeExpressionContext.class,0);
		}
		public DictionaryExpressionContext dictionaryExpression() {
			return getRuleContext(DictionaryExpressionContext.class,0);
		}
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public BoxExpressionContext boxExpression() {
			return getRuleContext(BoxExpressionContext.class,0);
		}
		public BlockExpressionContext blockExpression() {
			return getRuleContext(BlockExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_primaryExpression);
		try {
			setState(1859);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,265,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1844);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1845);
				constant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1846);
				stringLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1847);
				match(LP);
				setState(1848);
				expression(0);
				setState(1849);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1851);
				messageExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1852);
				selectorExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1853);
				protocolExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1854);
				encodeExpression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1855);
				dictionaryExpression();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1856);
				arrayExpression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1857);
				boxExpression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1858);
				blockExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode HEX_LITERAL() { return getToken(ObjectiveCParser.HEX_LITERAL, 0); }
		public TerminalNode OCTAL_LITERAL() { return getToken(ObjectiveCParser.OCTAL_LITERAL, 0); }
		public TerminalNode BINARY_LITERAL() { return getToken(ObjectiveCParser.BINARY_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(ObjectiveCParser.DECIMAL_LITERAL, 0); }
		public TerminalNode ADD() { return getToken(ObjectiveCParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ObjectiveCParser.SUB, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(ObjectiveCParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode CHARACTER_LITERAL() { return getToken(ObjectiveCParser.CHARACTER_LITERAL, 0); }
		public TerminalNode NIL() { return getToken(ObjectiveCParser.NIL, 0); }
		public TerminalNode NULL() { return getToken(ObjectiveCParser.NULL, 0); }
		public TerminalNode YES() { return getToken(ObjectiveCParser.YES, 0); }
		public TerminalNode NO() { return getToken(ObjectiveCParser.NO, 0); }
		public TerminalNode TRUE() { return getToken(ObjectiveCParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ObjectiveCParser.FALSE, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_constant);
		int _la;
		try {
			setState(1879);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1861);
				match(HEX_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1862);
				match(OCTAL_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1863);
				match(BINARY_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1865);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(1864);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1867);
				match(DECIMAL_LITERAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1869);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(1868);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1871);
				match(FLOATING_POINT_LITERAL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1872);
				match(CHARACTER_LITERAL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1873);
				match(NIL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1874);
				match(NULL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1875);
				match(YES);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1876);
				match(NO);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1877);
				match(TRUE);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1878);
				match(FALSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> STRING_START() { return getTokens(ObjectiveCParser.STRING_START); }
		public TerminalNode STRING_START(int i) {
			return getToken(ObjectiveCParser.STRING_START, i);
		}
		public List<TerminalNode> STRING_END() { return getTokens(ObjectiveCParser.STRING_END); }
		public TerminalNode STRING_END(int i) {
			return getToken(ObjectiveCParser.STRING_END, i);
		}
		public List<TerminalNode> STRING_VALUE() { return getTokens(ObjectiveCParser.STRING_VALUE); }
		public TerminalNode STRING_VALUE(int i) {
			return getToken(ObjectiveCParser.STRING_VALUE, i);
		}
		public List<TerminalNode> STRING_NEWLINE() { return getTokens(ObjectiveCParser.STRING_NEWLINE); }
		public TerminalNode STRING_NEWLINE(int i) {
			return getToken(ObjectiveCParser.STRING_NEWLINE, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_stringLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1889); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1881);
					match(STRING_START);
					setState(1885);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==STRING_NEWLINE || _la==STRING_VALUE) {
						{
						{
						setState(1882);
						_la = _input.LA(1);
						if ( !(_la==STRING_NEWLINE || _la==STRING_VALUE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(1887);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1888);
					match(STRING_END);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1891); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,270,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ObjectiveCParser.IDENTIFIER, 0); }
		public TerminalNode BOOL() { return getToken(ObjectiveCParser.BOOL, 0); }
		public TerminalNode Class() { return getToken(ObjectiveCParser.Class, 0); }
		public TerminalNode BYCOPY() { return getToken(ObjectiveCParser.BYCOPY, 0); }
		public TerminalNode BYREF() { return getToken(ObjectiveCParser.BYREF, 0); }
		public TerminalNode ID() { return getToken(ObjectiveCParser.ID, 0); }
		public TerminalNode IMP() { return getToken(ObjectiveCParser.IMP, 0); }
		public TerminalNode IN() { return getToken(ObjectiveCParser.IN, 0); }
		public TerminalNode INOUT() { return getToken(ObjectiveCParser.INOUT, 0); }
		public TerminalNode ONEWAY() { return getToken(ObjectiveCParser.ONEWAY, 0); }
		public TerminalNode OUT() { return getToken(ObjectiveCParser.OUT, 0); }
		public TerminalNode PROTOCOL_() { return getToken(ObjectiveCParser.PROTOCOL_, 0); }
		public TerminalNode SEL() { return getToken(ObjectiveCParser.SEL, 0); }
		public TerminalNode SELF() { return getToken(ObjectiveCParser.SELF, 0); }
		public TerminalNode SUPER() { return getToken(ObjectiveCParser.SUPER, 0); }
		public TerminalNode ATOMIC() { return getToken(ObjectiveCParser.ATOMIC, 0); }
		public TerminalNode NONATOMIC() { return getToken(ObjectiveCParser.NONATOMIC, 0); }
		public TerminalNode RETAIN() { return getToken(ObjectiveCParser.RETAIN, 0); }
		public TerminalNode AUTORELEASING_QUALIFIER() { return getToken(ObjectiveCParser.AUTORELEASING_QUALIFIER, 0); }
		public TerminalNode BLOCK() { return getToken(ObjectiveCParser.BLOCK, 0); }
		public TerminalNode BRIDGE_RETAINED() { return getToken(ObjectiveCParser.BRIDGE_RETAINED, 0); }
		public TerminalNode BRIDGE_TRANSFER() { return getToken(ObjectiveCParser.BRIDGE_TRANSFER, 0); }
		public TerminalNode COVARIANT() { return getToken(ObjectiveCParser.COVARIANT, 0); }
		public TerminalNode CONTRAVARIANT() { return getToken(ObjectiveCParser.CONTRAVARIANT, 0); }
		public TerminalNode DEPRECATED() { return getToken(ObjectiveCParser.DEPRECATED, 0); }
		public TerminalNode KINDOF() { return getToken(ObjectiveCParser.KINDOF, 0); }
		public TerminalNode UNUSED() { return getToken(ObjectiveCParser.UNUSED, 0); }
		public TerminalNode NS_INLINE() { return getToken(ObjectiveCParser.NS_INLINE, 0); }
		public TerminalNode NS_ENUM() { return getToken(ObjectiveCParser.NS_ENUM, 0); }
		public TerminalNode NS_OPTIONS() { return getToken(ObjectiveCParser.NS_OPTIONS, 0); }
		public TerminalNode NULL_UNSPECIFIED() { return getToken(ObjectiveCParser.NULL_UNSPECIFIED, 0); }
		public TerminalNode NULLABLE() { return getToken(ObjectiveCParser.NULLABLE, 0); }
		public TerminalNode NONNULL() { return getToken(ObjectiveCParser.NONNULL, 0); }
		public TerminalNode NULL_RESETTABLE() { return getToken(ObjectiveCParser.NULL_RESETTABLE, 0); }
		public TerminalNode ASSIGN() { return getToken(ObjectiveCParser.ASSIGN, 0); }
		public TerminalNode COPY() { return getToken(ObjectiveCParser.COPY, 0); }
		public TerminalNode GETTER() { return getToken(ObjectiveCParser.GETTER, 0); }
		public TerminalNode SETTER() { return getToken(ObjectiveCParser.SETTER, 0); }
		public TerminalNode STRONG() { return getToken(ObjectiveCParser.STRONG, 0); }
		public TerminalNode READONLY() { return getToken(ObjectiveCParser.READONLY, 0); }
		public TerminalNode READWRITE() { return getToken(ObjectiveCParser.READWRITE, 0); }
		public TerminalNode WEAK() { return getToken(ObjectiveCParser.WEAK, 0); }
		public TerminalNode UNSAFE_UNRETAINED() { return getToken(ObjectiveCParser.UNSAFE_UNRETAINED, 0); }
		public TerminalNode IB_OUTLET() { return getToken(ObjectiveCParser.IB_OUTLET, 0); }
		public TerminalNode IB_OUTLET_COLLECTION() { return getToken(ObjectiveCParser.IB_OUTLET_COLLECTION, 0); }
		public TerminalNode IB_INSPECTABLE() { return getToken(ObjectiveCParser.IB_INSPECTABLE, 0); }
		public TerminalNode IB_DESIGNABLE() { return getToken(ObjectiveCParser.IB_DESIGNABLE, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObjectiveCParserListener ) ((ObjectiveCParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1893);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 133:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 140:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00f5\u076a\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\3\2\7"+
		"\2\u012e\n\2\f\2\16\2\u0131\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3\u0140\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0148\n\4\3\4"+
		"\5\4\u014b\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0153\n\4\3\5\5\5\u0156\n\5"+
		"\3\5\3\5\7\5\u015a\n\5\f\5\16\5\u015d\13\5\3\5\3\5\3\5\3\5\5\5\u0163\n"+
		"\5\3\5\3\5\3\5\3\5\5\5\u0169\n\5\3\5\5\5\u016c\n\5\3\5\5\5\u016f\n\5\3"+
		"\5\3\5\3\6\3\6\7\6\u0175\n\6\f\6\16\6\u0178\13\6\3\6\3\6\3\6\3\6\5\6\u017e"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\5\6\u0185\n\6\3\6\5\6\u0188\n\6\3\6\5\6\u018b"+
		"\n\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0193\n\7\3\7\5\7\u0196\n\7\3\7\5\7\u0199"+
		"\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u01a3\n\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u01ad\n\t\3\n\3\n\7\n\u01b1\n\n\f\n\16\n\u01b4\13\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u01bc\n\n\3\n\7\n\u01bf\n\n\f\n\16\n\u01c2"+
		"\13\n\3\n\3\n\3\13\3\13\7\13\u01c8\n\13\f\13\16\13\u01cb\13\13\3\13\6"+
		"\13\u01ce\n\13\r\13\16\13\u01cf\5\13\u01d2\n\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u01dd\n\r\3\16\3\16\3\16\3\16\7\16\u01e3\n\16\f\16"+
		"\16\16\u01e6\13\16\3\16\3\16\3\17\3\17\3\17\7\17\u01ed\n\17\f\17\16\17"+
		"\u01f0\13\17\3\20\3\20\3\20\3\20\3\20\5\20\u01f7\n\20\3\20\5\20\u01fa"+
		"\n\20\3\20\5\20\u01fd\n\20\3\20\3\20\3\21\3\21\3\21\7\21\u0204\n\21\f"+
		"\21\16\21\u0207\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u021d\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0224\n\23\3\23\3\23\3\23\5\23\u0229\n\23\5"+
		"\23\u022b\n\23\3\24\3\24\7\24\u022f\n\24\f\24\16\24\u0232\13\24\3\24\3"+
		"\24\3\25\3\25\7\25\u0238\n\25\f\25\16\25\u023b\13\25\3\25\6\25\u023e\n"+
		"\25\r\25\16\25\u023f\5\25\u0242\n\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\6\27\u024b\n\27\r\27\16\27\u024c\3\30\3\30\3\30\3\31\3\31\3\31\3\32\5"+
		"\32\u0256\n\32\3\32\3\32\3\32\7\32\u025b\n\32\f\32\16\32\u025e\13\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\6\33\u0267\n\33\r\33\16\33\u0268\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\36\5\36\u0272\n\36\3\36\3\36\5\36\u0276\n"+
		"\36\3\36\5\36\u0279\n\36\3\36\3\36\3\37\3\37\6\37\u027f\n\37\r\37\16\37"+
		"\u0280\3\37\3\37\5\37\u0285\n\37\5\37\u0287\n\37\3 \5 \u028a\n \3 \3 "+
		"\7 \u028e\n \f \16 \u0291\13 \3 \5 \u0294\n \3 \3 \3!\3!\5!\u029a\n!\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u02a8\n#\3$\3$\3$\7$\u02ad\n"+
		"$\f$\16$\u02b0\13$\3%\3%\3%\5%\u02b5\n%\3&\5&\u02b8\n&\3&\3&\5&\u02bc"+
		"\n&\3&\3&\3&\3&\5&\u02c2\n&\3&\3&\5&\u02c6\n&\3\'\3\'\3\'\3\'\7\'\u02cc"+
		"\n\'\f\'\16\'\u02cf\13\'\5\'\u02d1\n\'\3\'\3\'\3(\7(\u02d6\n(\f(\16(\u02d9"+
		"\13(\3(\3(\3)\3)\3)\3)\3)\7)\u02e2\n)\f)\16)\u02e5\13)\3)\5)\u02e8\n)"+
		"\5)\u02ea\n)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\5+\u02f6\n+\5+\u02f8\n+\3+"+
		"\3+\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0304\n,\5,\u0306\n,\3-\3-\3-\5-\u030b"+
		"\n-\3-\3-\7-\u030f\n-\f-\16-\u0312\13-\5-\u0314\n-\3-\3-\3.\3.\5.\u031a"+
		"\n.\3/\3/\5/\u031e\n/\3/\5/\u0321\n/\3/\5/\u0324\n/\3/\3/\3\60\3\60\3"+
		"\60\3\60\3\60\3\61\3\61\5\61\u032f\n\61\3\62\3\62\6\62\u0333\n\62\r\62"+
		"\16\62\u0334\5\62\u0337\n\62\3\63\5\63\u033a\n\63\3\63\3\63\3\63\3\63"+
		"\7\63\u0340\n\63\f\63\16\63\u0343\13\63\3\64\3\64\5\64\u0347\n\64\3\64"+
		"\3\64\3\64\3\64\5\64\u034d\n\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\5\66"+
		"\u0356\n\66\3\66\6\66\u0359\n\66\r\66\16\66\u035a\5\66\u035d\n\66\3\67"+
		"\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\3:\3:\3:\3:\3:\3:\3:\5:\u0373"+
		"\n:\3;\3;\3;\7;\u0378\n;\f;\16;\u037b\13;\3;\3;\5;\u037f\n;\3<\3<\3<\3"+
		"<\3<\3<\3=\3=\3=\3=\3=\3=\3>\3>\3>\3?\3?\3?\7?\u0393\n?\f?\16?\u0396\13"+
		"?\3?\3?\3@\3@\3@\7@\u039d\n@\f@\16@\u03a0\13@\3@\3@\3A\5A\u03a5\nA\3A"+
		"\3A\3A\5A\u03aa\nA\3A\3A\3A\5A\u03af\nA\3B\5B\u03b2\nB\3B\3B\3B\5B\u03b7"+
		"\nB\3B\5B\u03ba\nB\3B\3B\3B\3B\5B\u03c0\nB\3B\3B\3B\5B\u03c5\nB\3C\3C"+
		"\5C\u03c9\nC\3D\3D\5D\u03cd\nD\3E\3E\5E\u03d1\nE\3E\3E\3F\3F\3F\7F\u03d8"+
		"\nF\fF\16F\u03db\13F\3G\3G\3G\3G\5G\u03e1\nG\3H\3H\3H\3H\3H\5H\u03e8\n"+
		"H\3I\3I\3I\3I\5I\u03ee\nI\3J\5J\u03f1\nJ\3J\3J\5J\u03f5\nJ\3J\3J\3J\3"+
		"J\3J\3K\3K\7K\u03fe\nK\fK\16K\u0401\13K\3K\5K\u0404\nK\3K\3K\5K\u0408"+
		"\nK\3K\3K\7K\u040c\nK\fK\16K\u040f\13K\3K\3K\3L\5L\u0414\nL\3L\3L\3L\3"+
		"L\5L\u041a\nL\3L\3L\7L\u041e\nL\fL\16L\u0421\13L\3L\3L\3M\5M\u0426\nM"+
		"\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\5M\u0432\nM\3M\3M\7M\u0436\nM\fM\16M\u0439"+
		"\13M\3M\3M\3N\3N\3N\7N\u0440\nN\fN\16N\u0443\13N\3O\5O\u0446\nO\3O\3O"+
		"\3P\3P\3P\3P\3P\6P\u044f\nP\rP\16P\u0450\3Q\3Q\3Q\3Q\6Q\u0457\nQ\rQ\16"+
		"Q\u0458\3R\3R\3R\6R\u045e\nR\rR\16R\u045f\3S\3S\3S\3S\3S\3S\7S\u0468\n"+
		"S\fS\16S\u046b\13S\3S\3S\3S\3T\3T\3T\7T\u0473\nT\fT\16T\u0476\13T\3U\3"+
		"U\3U\7U\u047b\nU\fU\16U\u047e\13U\3U\3U\5U\u0482\nU\3V\3V\3V\5V\u0487"+
		"\nV\3V\3V\6V\u048b\nV\rV\16V\u048c\3V\3V\5V\u0491\nV\3W\3W\3W\3W\5W\u0497"+
		"\nW\3W\3W\7W\u049b\nW\fW\16W\u049e\13W\3W\3W\3X\3X\6X\u04a4\nX\rX\16X"+
		"\u04a5\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u04ae\nY\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3"+
		"^\3^\5^\u04bc\n^\3_\3_\3`\6`\u04c1\n`\r`\16`\u04c2\3`\3`\3`\3`\3`\5`\u04ca"+
		"\n`\3`\5`\u04cd\n`\3a\3a\3a\3a\3a\3b\3b\3b\7b\u04d7\nb\fb\16b\u04da\13"+
		"b\3c\3c\5c\u04de\nc\3c\3c\5c\u04e2\nc\3d\3d\5d\u04e6\nd\3d\3d\5d\u04ea"+
		"\nd\3d\3d\3d\3d\3d\5d\u04f1\nd\3d\3d\3d\3d\5d\u04f7\nd\3d\3d\3d\3d\3d"+
		"\5d\u04fe\nd\3d\3d\3d\3d\3d\5d\u0505\nd\3e\3e\3e\7e\u050a\ne\fe\16e\u050d"+
		"\13e\3e\5e\u0510\ne\3f\3f\3f\7f\u0515\nf\ff\16f\u0518\13f\3f\3f\5f\u051c"+
		"\nf\3g\3g\5g\u0520\ng\3h\3h\3h\3h\3h\5h\u0527\nh\3h\7h\u052a\nh\fh\16"+
		"h\u052d\13h\3h\3h\3h\5h\u0532\nh\3h\5h\u0535\nh\3h\3h\5h\u0539\nh\3i\3"+
		"i\5i\u053d\ni\3i\3i\3j\3j\3j\5j\u0544\nj\3k\3k\5k\u0548\nk\3k\5k\u054b"+
		"\nk\3l\3l\3l\3l\3l\3l\3l\7l\u0554\nl\fl\16l\u0557\13l\3l\3l\3l\3l\7l\u055d"+
		"\nl\fl\16l\u0560\13l\3l\5l\u0563\nl\5l\u0565\nl\3l\3l\3l\5l\u056a\nl\7"+
		"l\u056c\nl\fl\16l\u056f\13l\3l\3l\5l\u0573\nl\3m\3m\3m\5m\u0578\nm\5m"+
		"\u057a\nm\3m\3m\3n\3n\3n\3n\3n\3n\7n\u0584\nn\fn\16n\u0587\13n\3n\5n\u058a"+
		"\nn\5n\u058c\nn\3n\3n\3o\3o\3o\7o\u0593\no\fo\16o\u0596\13o\3o\5o\u0599"+
		"\no\3p\3p\5p\u059d\np\3p\3p\5p\u05a1\np\3q\3q\5q\u05a5\nq\3q\3q\5q\u05a9"+
		"\nq\3q\3q\6q\u05ad\nq\rq\16q\u05ae\3q\3q\5q\u05b3\nq\3q\6q\u05b6\nq\r"+
		"q\16q\u05b7\5q\u05ba\nq\3r\3r\5r\u05be\nr\3r\3r\3r\5r\u05c3\nr\3r\5r\u05c6"+
		"\nr\3s\3s\3s\7s\u05cb\ns\fs\16s\u05ce\13s\3t\3t\5t\u05d2\nt\3t\3t\5t\u05d6"+
		"\nt\3u\5u\u05d9\nu\3u\3u\3v\3v\5v\u05df\nv\3v\3v\5v\u05e3\nv\3v\3v\5v"+
		"\u05e7\nv\3v\3v\5v\u05eb\nv\3v\3v\5v\u05ef\nv\3v\3v\5v\u05f3\nv\3v\3v"+
		"\5v\u05f7\nv\3v\3v\5v\u05fb\nv\3v\3v\5v\u05ff\nv\3v\3v\5v\u0603\nv\3v"+
		"\5v\u0606\nv\3w\3w\3w\3w\3x\3x\3x\5x\u060f\nx\3y\3y\3y\7y\u0614\ny\fy"+
		"\16y\u0617\13y\3y\3y\3z\3z\3z\3z\3z\3z\3z\5z\u0622\nz\3z\5z\u0625\nz\3"+
		"{\3{\3{\3{\3{\3{\3|\3|\7|\u062f\n|\f|\16|\u0632\13|\3|\3|\3}\6}\u0637"+
		"\n}\r}\16}\u0638\3}\6}\u063c\n}\r}\16}\u063d\3~\3~\3~\3~\3~\3~\5~\u0646"+
		"\n~\3~\3~\3~\3~\5~\u064c\n~\3\177\3\177\3\177\3\177\5\177\u0652\n\177"+
		"\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081"+
		"\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0082\3\u0082\3\u0082\5\u0082"+
		"\u0665\n\u0082\3\u0082\3\u0082\5\u0082\u0669\n\u0082\3\u0082\3\u0082\5"+
		"\u0082\u066d\n\u0082\3\u0082\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083\3"+
		"\u0083\5\u0083\u0676\n\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\5"+
		"\u0084\u067d\n\u0084\3\u0084\3\u0084\3\u0084\3\u0085\3\u0085\3\u0085\3"+
		"\u0085\3\u0085\3\u0085\5\u0085\u0688\n\u0085\5\u0085\u068a\n\u0085\3\u0086"+
		"\3\u0086\3\u0086\7\u0086\u068f\n\u0086\f\u0086\16\u0086\u0692\13\u0086"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\5\u0087\u069e\n\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\5\u0087\u06ab\n\u0087"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\5\u0087\u06c6"+
		"\n\u0087\3\u0087\3\u0087\7\u0087\u06ca\n\u0087\f\u0087\16\u0087\u06cd"+
		"\13\u0087\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\5\u0089\u06d8\n\u0089\5\u0089\u06da\n\u0089\3\u008a\3\u008a\3"+
		"\u008a\5\u008a\u06df\n\u008a\3\u008b\3\u008b\5\u008b\u06e3\n\u008b\3\u008c"+
		"\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c\5\u008c\u06ec\n\u008c"+
		"\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c\5\u008c\u06f3\n\u008c\3\u008d"+
		"\3\u008d\3\u008e\3\u008e\3\u008e\7\u008e\u06fa\n\u008e\f\u008e\16\u008e"+
		"\u06fd\13\u008e\3\u008e\3\u008e\3\u008e\3\u008e\7\u008e\u0703\n\u008e"+
		"\f\u008e\16\u008e\u0706\13\u008e\7\u008e\u0708\n\u008e\f\u008e\16\u008e"+
		"\u070b\13\u008e\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f"+
		"\u0713\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f\6\u008f\u0719\n\u008f\r"+
		"\u008f\16\u008f\u071a\3\u008f\3\u008f\5\u008f\u071f\n\u008f\3\u0090\3"+
		"\u0090\3\u0090\7\u0090\u0724\n\u0090\f\u0090\16\u0090\u0727\13\u0090\3"+
		"\u0091\3\u0091\5\u0091\u072b\n\u0091\3\u0092\3\u0092\3\u0092\3\u0092\3"+
		"\u0092\5\u0092\u0732\n\u0092\3\u0092\5\u0092\u0735\n\u0092\3\u0093\3\u0093"+
		"\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093"+
		"\3\u0093\3\u0093\3\u0093\3\u0093\5\u0093\u0746\n\u0093\3\u0094\3\u0094"+
		"\3\u0094\3\u0094\5\u0094\u074c\n\u0094\3\u0094\3\u0094\5\u0094\u0750\n"+
		"\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094"+
		"\5\u0094\u075a\n\u0094\3\u0095\3\u0095\7\u0095\u075e\n\u0095\f\u0095\16"+
		"\u0095\u0761\13\u0095\3\u0095\6\u0095\u0764\n\u0095\r\u0095\16\u0095\u0765"+
		"\3\u0096\3\u0096\3\u0096\2\4\u010c\u011a\u0097\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv"+
		"xz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4"+
		"\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c"+
		"\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124"+
		"\u0126\u0128\u012a\2\31\4\2HHMM\3\2\\]\5\2FFIIKL\4\2\35\35  \6\2WW``b"+
		"bdd\3\2eh\6\2\3\3\16\16\26\26\34\34\6\2\23\23X[__ii\5\2,-\60\61\65\66"+
		"\b\2\6\6\13\13\17\17\24\25\31\32!\"\4\2jlnn\4\2\u00a7\u00a8\u00ac\u00ac"+
		"\3\2\u00a5\u00a6\4\2\u0097\u0098\u009e\u009f\4\2\u009d\u009d\u00a0\u00a0"+
		"\4\2\u0096\u0096\u00ad\u00b6\3\2\u00a3\u00a4\5\2\u0099\u009a\u00a5\u00a7"+
		"\u00a9\u00a9\3\2\u0093\u0094\3\2\u008c\u008c\4\2\u008a\u008a\u00be\u00bf"+
		"\4\2\u00c5\u00c5\u00c7\u00c7\13\2*\61\65:SUWXZ_cceko{\u008a\u008a\2\u0849"+
		"\2\u012f\3\2\2\2\4\u013f\3\2\2\2\6\u0141\3\2\2\2\b\u0155\3\2\2\2\n\u0176"+
		"\3\2\2\2\f\u018e\3\2\2\2\16\u019c\3\2\2\2\20\u01a6\3\2\2\2\22\u01b2\3"+
		"\2\2\2\24\u01d1\3\2\2\2\26\u01d3\3\2\2\2\30\u01d7\3\2\2\2\32\u01de\3\2"+
		"\2\2\34\u01e9\3\2\2\2\36\u01f1\3\2\2\2 \u0200\3\2\2\2\"\u021c\3\2\2\2"+
		"$\u022a\3\2\2\2&\u022c\3\2\2\2(\u0241\3\2\2\2*\u0243\3\2\2\2,\u024a\3"+
		"\2\2\2.\u024e\3\2\2\2\60\u0251\3\2\2\2\62\u0255\3\2\2\2\64\u0266\3\2\2"+
		"\2\66\u026a\3\2\2\28\u026d\3\2\2\2:\u0271\3\2\2\2<\u0286\3\2\2\2>\u0289"+
		"\3\2\2\2@\u0299\3\2\2\2B\u029b\3\2\2\2D\u02a7\3\2\2\2F\u02a9\3\2\2\2H"+
		"\u02b1\3\2\2\2J\u02b7\3\2\2\2L\u02c7\3\2\2\2N\u02d7\3\2\2\2P\u02dc\3\2"+
		"\2\2R\u02ed\3\2\2\2T\u02f1\3\2\2\2V\u0305\3\2\2\2X\u0307\3\2\2\2Z\u0319"+
		"\3\2\2\2\\\u031b\3\2\2\2^\u0327\3\2\2\2`\u032e\3\2\2\2b\u0336\3\2\2\2"+
		"d\u0339\3\2\2\2f\u0344\3\2\2\2h\u034e\3\2\2\2j\u035c\3\2\2\2l\u035e\3"+
		"\2\2\2n\u0363\3\2\2\2p\u0368\3\2\2\2r\u0372\3\2\2\2t\u0374\3\2\2\2v\u0380"+
		"\3\2\2\2x\u0386\3\2\2\2z\u038c\3\2\2\2|\u038f\3\2\2\2~\u0399\3\2\2\2\u0080"+
		"\u03a4\3\2\2\2\u0082\u03b1\3\2\2\2\u0084\u03c6\3\2\2\2\u0086\u03cc\3\2"+
		"\2\2\u0088\u03ce\3\2\2\2\u008a\u03d4\3\2\2\2\u008c\u03e0\3\2\2\2\u008e"+
		"\u03e2\3\2\2\2\u0090\u03ed\3\2\2\2\u0092\u03f0\3\2\2\2\u0094\u03ff\3\2"+
		"\2\2\u0096\u0413\3\2\2\2\u0098\u0425\3\2\2\2\u009a\u043c\3\2\2\2\u009c"+
		"\u0445\3\2\2\2\u009e\u044e\3\2\2\2\u00a0\u0456\3\2\2\2\u00a2\u045d\3\2"+
		"\2\2\u00a4\u0461\3\2\2\2\u00a6\u046f\3\2\2\2\u00a8\u0477\3\2\2\2\u00aa"+
		"\u0483\3\2\2\2\u00ac\u0496\3\2\2\2\u00ae\u04a3\3\2\2\2\u00b0\u04ad\3\2"+
		"\2\2\u00b2\u04af\3\2\2\2\u00b4\u04b1\3\2\2\2\u00b6\u04b3\3\2\2\2\u00b8"+
		"\u04b5\3\2\2\2\u00ba\u04bb\3\2\2\2\u00bc\u04bd\3\2\2\2\u00be\u04c9\3\2"+
		"\2\2\u00c0\u04ce\3\2\2\2\u00c2\u04d3\3\2\2\2\u00c4\u04e1\3\2\2\2\u00c6"+
		"\u0504\3\2\2\2\u00c8\u0506\3\2\2\2\u00ca\u0511\3\2\2\2\u00cc\u051f\3\2"+
		"\2\2\u00ce\u0538\3\2\2\2\u00d0\u053a\3\2\2\2\u00d2\u0540\3\2\2\2\u00d4"+
		"\u0545\3\2\2\2\u00d6\u054c\3\2\2\2\u00d8\u0574\3\2\2\2\u00da\u057d\3\2"+
		"\2\2\u00dc\u058f\3\2\2\2\u00de\u05a0\3\2\2\2\u00e0\u05b9\3\2\2\2\u00e2"+
		"\u05c5\3\2\2\2\u00e4\u05c7\3\2\2\2\u00e6\u05d5\3\2\2\2\u00e8\u05d8\3\2"+
		"\2\2\u00ea\u0605\3\2\2\2\u00ec\u0607\3\2\2\2\u00ee\u060b\3\2\2\2\u00f0"+
		"\u0610\3\2\2\2\u00f2\u0624\3\2\2\2\u00f4\u0626\3\2\2\2\u00f6\u062c\3\2"+
		"\2\2\u00f8\u0636\3\2\2\2\u00fa\u064b\3\2\2\2\u00fc\u0651\3\2\2\2\u00fe"+
		"\u0653\3\2\2\2\u0100\u0659\3\2\2\2\u0102\u0661\3\2\2\2\u0104\u0675\3\2"+
		"\2\2\u0106\u0677\3\2\2\2\u0108\u0689\3\2\2\2\u010a\u068b\3\2\2\2\u010c"+
		"\u069d\3\2\2\2\u010e\u06ce\3\2\2\2\u0110\u06d9\3\2\2\2\u0112\u06de\3\2"+
		"\2\2\u0114\u06e2\3\2\2\2\u0116\u06f2\3\2\2\2\u0118\u06f4\3\2\2\2\u011a"+
		"\u06f6\3\2\2\2\u011c\u071e\3\2\2\2\u011e\u0720\3\2\2\2\u0120\u072a\3\2"+
		"\2\2\u0122\u072c\3\2\2\2\u0124\u0745\3\2\2\2\u0126\u0759\3\2\2\2\u0128"+
		"\u0763\3\2\2\2\u012a\u0767\3\2\2\2\u012c\u012e\5\4\3\2\u012d\u012c\3\2"+
		"\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\7\2\2\3\u0133\3\3\2\2\2"+
		"\u0134\u0140\5\6\4\2\u0135\u0140\5|?\2\u0136\u0140\5\u0090I\2\u0137\u0140"+
		"\5\b\5\2\u0138\u0140\5\f\7\2\u0139\u0140\5\n\6\2\u013a\u0140\5\16\b\2"+
		"\u013b\u0140\5\22\n\2\u013c\u0140\5\26\f\2\u013d\u0140\5\32\16\2\u013e"+
		"\u0140\5~@\2\u013f\u0134\3\2\2\2\u013f\u0135\3\2\2\2\u013f\u0136\3\2\2"+
		"\2\u013f\u0137\3\2\2\2\u013f\u0138\3\2\2\2\u013f\u0139\3\2\2\2\u013f\u013a"+
		"\3\2\2\2\u013f\u013b\3\2\2\2\u013f\u013c\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u013e\3\2\2\2\u0140\5\3\2\2\2\u0141\u0152\7E\2\2\u0142\u0143\5\u012a"+
		"\u0096\2\u0143\u0144\7\u0091\2\2\u0144\u0153\3\2\2\2\u0145\u0147\7\u0098"+
		"\2\2\u0146\u0148\5\u012a\u0096\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2"+
		"\2\u0148\u014a\3\2\2\2\u0149\u014b\7\u00a8\2\2\u014a\u0149\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\5\u012a\u0096\2\u014d\u014e"+
		"\7\u0093\2\2\u014e\u014f\7\u008a\2\2\u014f\u0150\7\u0097\2\2\u0150\u0153"+
		"\3\2\2\2\u0151\u0153\5\u0128\u0095\2\u0152\u0142\3\2\2\2\u0152\u0145\3"+
		"\2\2\2\u0152\u0151\3\2\2\2\u0153\7\3\2\2\2\u0154\u0156\7{\2\2\u0155\u0154"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u015b\3\2\2\2\u0157\u015a\5\u00d6l"+
		"\2\u0158\u015a\5\u00a4S\2\u0159\u0157\3\2\2\2\u0159\u0158\3\2\2\2\u015a"+
		"\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7D\2\2\u015f\u0162\5\20\t\2\u0160"+
		"\u0161\7\u009c\2\2\u0161\u0163\5\u012a\u0096\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0168\3\2\2\2\u0164\u0165\7\u0098\2\2\u0165\u0166"+
		"\5\34\17\2\u0166\u0167\7\u0097\2\2\u0167\u0169\3\2\2\2\u0168\u0164\3\2"+
		"\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u016c\5&\24\2\u016b"+
		"\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016f\5,"+
		"\27\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0171\7A\2\2\u0171\t\3\2\2\2\u0172\u0175\5\u00d6l\2\u0173\u0175\5\u00a4"+
		"S\2\u0174\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176"+
		"\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2"+
		"\2\2\u0179\u017a\7D\2\2\u017a\u017b\5\20\t\2\u017b\u017d\7\u008b\2\2\u017c"+
		"\u017e\5\u012a\u0096\2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f"+
		"\3\2\2\2\u017f\u0184\7\u008c\2\2\u0180\u0181\7\u0098\2\2\u0181\u0182\5"+
		"\34\17\2\u0182\u0183\7\u0097\2\2\u0183\u0185\3\2\2\2\u0184\u0180\3\2\2"+
		"\2\u0184\u0185\3\2\2\2\u0185\u0187\3\2\2\2\u0186\u0188\5&\24\2\u0187\u0186"+
		"\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u018b\5,\27\2\u018a"+
		"\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\7A"+
		"\2\2\u018d\13\3\2\2\2\u018e\u018f\7C\2\2\u018f\u0192\5\20\t\2\u0190\u0191"+
		"\7\u009c\2\2\u0191\u0193\5\u012a\u0096\2\u0192\u0190\3\2\2\2\u0192\u0193"+
		"\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0196\5&\24\2\u0195\u0194\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0199\5\64\33\2\u0198\u0197\3"+
		"\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\7A\2\2\u019b"+
		"\r\3\2\2\2\u019c\u019d\7C\2\2\u019d\u019e\5\20\t\2\u019e\u019f\7\u008b"+
		"\2\2\u019f\u01a0\5\u012a\u0096\2\u01a0\u01a2\7\u008c\2\2\u01a1\u01a3\5"+
		"\64\33\2\u01a2\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a5\7A\2\2\u01a5\17\3\2\2\2\u01a6\u01ac\5\u012a\u0096\2\u01a7\u01a8"+
		"\7\u0098\2\2\u01a8\u01a9\5\34\17\2\u01a9\u01aa\7\u0097\2\2\u01aa\u01ad"+
		"\3\2\2\2\u01ab\u01ad\5L\'\2\u01ac\u01a7\3\2\2\2\u01ac\u01ab\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\21\3\2\2\2\u01ae\u01b1\5\u00d6l\2\u01af\u01b1\5\u00a4"+
		"S\2\u01b0\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b2\3\2"+
		"\2\2\u01b5\u01b6\7G\2\2\u01b6\u01bb\5$\23\2\u01b7\u01b8\7\u0098\2\2\u01b8"+
		"\u01b9\5\34\17\2\u01b9\u01ba\7\u0097\2\2\u01ba\u01bc\3\2\2\2\u01bb\u01b7"+
		"\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01c0\3\2\2\2\u01bd\u01bf\5\24\13\2"+
		"\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1"+
		"\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c4\7A\2\2\u01c4"+
		"\23\3\2\2\2\u01c5\u01c9\t\2\2\2\u01c6\u01c8\5,\27\2\u01c7\u01c6\3\2\2"+
		"\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01d2"+
		"\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01ce\5,\27\2\u01cd\u01cc\3\2\2\2\u01ce"+
		"\u01cf\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d2\3\2"+
		"\2\2\u01d1\u01c5\3\2\2\2\u01d1\u01cd\3\2\2\2\u01d2\25\3\2\2\2\u01d3\u01d4"+
		"\7G\2\2\u01d4\u01d5\5\34\17\2\u01d5\u01d6\7\u0091\2\2\u01d6\27\3\2\2\2"+
		"\u01d7\u01dc\5\u012a\u0096\2\u01d8\u01d9\7\u0098\2\2\u01d9\u01da\5\34"+
		"\17\2\u01da\u01db\7\u0097\2\2\u01db\u01dd\3\2\2\2\u01dc\u01d8\3\2\2\2"+
		"\u01dc\u01dd\3\2\2\2\u01dd\31\3\2\2\2\u01de\u01df\7>\2\2\u01df\u01e4\5"+
		"\30\r\2\u01e0\u01e1\7\u0092\2\2\u01e1\u01e3\5\30\r\2\u01e2\u01e0\3\2\2"+
		"\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e7"+
		"\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e8\7\u0091\2\2\u01e8\33\3\2\2\2"+
		"\u01e9\u01ee\5$\23\2\u01ea\u01eb\7\u0092\2\2\u01eb\u01ed\5$\23\2\u01ec"+
		"\u01ea\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2"+
		"\2\2\u01ef\35\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f6\7J\2\2\u01f2\u01f3"+
		"\7\u008b\2\2\u01f3\u01f4\5 \21\2\u01f4\u01f5\7\u008c\2\2\u01f5\u01f7\3"+
		"\2\2\2\u01f6\u01f2\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f9\3\2\2\2\u01f8"+
		"\u01fa\5\u00b0Y\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc"+
		"\3\2\2\2\u01fb\u01fd\7z\2\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u01fe\3\2\2\2\u01fe\u01ff\5\u00acW\2\u01ff\37\3\2\2\2\u0200\u0205\5\""+
		"\22\2\u0201\u0202\7\u0092\2\2\u0202\u0204\5\"\22\2\u0203\u0201\3\2\2\2"+
		"\u0204\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206!\3"+
		"\2\2\2\u0207\u0205\3\2\2\2\u0208\u021d\7S\2\2\u0209\u021d\7T\2\2\u020a"+
		"\u021d\7s\2\2\u020b\u021d\7v\2\2\u020c\u021d\7U\2\2\u020d\u021d\7o\2\2"+
		"\u020e\u021d\7w\2\2\u020f\u021d\7p\2\2\u0210\u021d\7t\2\2\u0211\u021d"+
		"\7u\2\2\u0212\u0213\7q\2\2\u0213\u0214\7\u0096\2\2\u0214\u021d\5\u012a"+
		"\u0096\2\u0215\u0216\7r\2\2\u0216\u0217\7\u0096\2\2\u0217\u0218\5\u012a"+
		"\u0096\2\u0218\u0219\7\u009c\2\2\u0219\u021d\3\2\2\2\u021a\u021d\5\u00b4"+
		"[\2\u021b\u021d\5\u012a\u0096\2\u021c\u0208\3\2\2\2\u021c\u0209\3\2\2"+
		"\2\u021c\u020a\3\2\2\2\u021c\u020b\3\2\2\2\u021c\u020c\3\2\2\2\u021c\u020d"+
		"\3\2\2\2\u021c\u020e\3\2\2\2\u021c\u020f\3\2\2\2\u021c\u0210\3\2\2\2\u021c"+
		"\u0211\3\2\2\2\u021c\u0212\3\2\2\2\u021c\u0215\3\2\2\2\u021c\u021a\3\2"+
		"\2\2\u021c\u021b\3\2\2\2\u021d#\3\2\2\2\u021e\u021f\7\u0098\2\2\u021f"+
		"\u0220\5\34\17\2\u0220\u0221\7\u0097\2\2\u0221\u022b\3\2\2\2\u0222\u0224"+
		"\t\3\2\2\u0223\u0222\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0228\5\u00dep\2\u0226\u0227\7\u009c\2\2\u0227\u0229\5\u00be`\2\u0228"+
		"\u0226\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022b\3\2\2\2\u022a\u021e\3\2"+
		"\2\2\u022a\u0223\3\2\2\2\u022b%\3\2\2\2\u022c\u0230\7\u008d\2\2\u022d"+
		"\u022f\5(\25\2\u022e\u022d\3\2\2\2\u022f\u0232\3\2\2\2\u0230\u022e\3\2"+
		"\2\2\u0230\u0231\3\2\2\2\u0231\u0233\3\2\2\2\u0232\u0230\3\2\2\2\u0233"+
		"\u0234\7\u008e\2\2\u0234\'\3\2\2\2\u0235\u0239\5*\26\2\u0236\u0238\5\u00ac"+
		"W\2\u0237\u0236\3\2\2\2\u0238\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u0239"+
		"\u023a\3\2\2\2\u023a\u0242\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u023e\5\u00ac"+
		"W\2\u023d\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u023d\3\2\2\2\u023f"+
		"\u0240\3\2\2\2\u0240\u0242\3\2\2\2\u0241\u0235\3\2\2\2\u0241\u023d\3\2"+
		"\2\2\u0242)\3\2\2\2\u0243\u0244\t\4\2\2\u0244+\3\2\2\2\u0245\u024b\5\u0090"+
		"I\2\u0246\u024b\5.\30\2\u0247\u024b\5\60\31\2\u0248\u024b\5\36\20\2\u0249"+
		"\u024b\5|?\2\u024a\u0245\3\2\2\2\u024a\u0246\3\2\2\2\u024a\u0247\3\2\2"+
		"\2\u024a\u0248\3\2\2\2\u024a\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024a"+
		"\3\2\2\2\u024c\u024d\3\2\2\2\u024d-\3\2\2\2\u024e\u024f\7\u00a5\2\2\u024f"+
		"\u0250\5\62\32\2\u0250/\3\2\2\2\u0251\u0252\7\u00a6\2\2\u0252\u0253\5"+
		"\62\32\2\u0253\61\3\2\2\2\u0254\u0256\5B\"\2\u0255\u0254\3\2\2\2\u0255"+
		"\u0256\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u025c\5<\37\2\u0258\u025b\5\u00d6"+
		"l\2\u0259\u025b\5\u00a4S\2\u025a\u0258\3\2\2\2\u025a\u0259\3\2\2\2\u025b"+
		"\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025f\3\2"+
		"\2\2\u025e\u025c\3\2\2\2\u025f\u0260\7\u0091\2\2\u0260\63\3\2\2\2\u0261"+
		"\u0267\5~@\2\u0262\u0267\5\u0090I\2\u0263\u0267\5\66\34\2\u0264\u0267"+
		"\58\35\2\u0265\u0267\5D#\2\u0266\u0261\3\2\2\2\u0266\u0262\3\2\2\2\u0266"+
		"\u0263\3\2\2\2\u0266\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267\u0268\3\2"+
		"\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\65\3\2\2\2\u026a\u026b"+
		"\7\u00a5\2\2\u026b\u026c\5:\36\2\u026c\67\3\2\2\2\u026d\u026e\7\u00a6"+
		"\2\2\u026e\u026f\5:\36\2\u026f9\3\2\2\2\u0270\u0272\5B\"\2\u0271\u0270"+
		"\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0275\5<\37\2\u0274"+
		"\u0276\5\u00a6T\2\u0275\u0274\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0278"+
		"\3\2\2\2\u0277\u0279\7\u0091\2\2\u0278\u0277\3\2\2\2\u0278\u0279\3\2\2"+
		"\2\u0279\u027a\3\2\2\2\u027a\u027b\5\u00f0y\2\u027b;\3\2\2\2\u027c\u0287"+
		"\5@!\2\u027d\u027f\5> \2\u027e\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280"+
		"\u027e\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0284\3\2\2\2\u0282\u0283\7\u0092"+
		"\2\2\u0283\u0285\7\u00b7\2\2\u0284\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285"+
		"\u0287\3\2\2\2\u0286\u027c\3\2\2\2\u0286\u027e\3\2\2\2\u0287=\3\2\2\2"+
		"\u0288\u028a\5@!\2\u0289\u0288\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b"+
		"\3\2\2\2\u028b\u028f\7\u009c\2\2\u028c\u028e\5B\"\2\u028d\u028c\3\2\2"+
		"\2\u028e\u0291\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0293"+
		"\3\2\2\2\u0291\u028f\3\2\2\2\u0292\u0294\5\u00b2Z\2\u0293\u0292\3\2\2"+
		"\2\u0293\u0294\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0296\5\u012a\u0096\2"+
		"\u0296?\3\2\2\2\u0297\u029a\5\u012a\u0096\2\u0298\u029a\7\30\2\2\u0299"+
		"\u0297\3\2\2\2\u0299\u0298\3\2\2\2\u029aA\3\2\2\2\u029b\u029c\7\u008b"+
		"\2\2\u029c\u029d\5\u00dep\2\u029d\u029e\7\u008c\2\2\u029eC\3\2\2\2\u029f"+
		"\u02a0\7P\2\2\u02a0\u02a1\5F$\2\u02a1\u02a2\7\u0091\2\2\u02a2\u02a8\3"+
		"\2\2\2\u02a3\u02a4\7?\2\2\u02a4\u02a5\5F$\2\u02a5\u02a6\7\u0091\2\2\u02a6"+
		"\u02a8\3\2\2\2\u02a7\u029f\3\2\2\2\u02a7\u02a3\3\2\2\2\u02a8E\3\2\2\2"+
		"\u02a9\u02ae\5H%\2\u02aa\u02ab\7\u0092\2\2\u02ab\u02ad\5H%\2\u02ac\u02aa"+
		"\3\2\2\2\u02ad\u02b0\3\2\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af"+
		"G\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b1\u02b4\5\u012a\u0096\2\u02b2\u02b3"+
		"\7\u0096\2\2\u02b3\u02b5\5\u012a\u0096\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5"+
		"\3\2\2\2\u02b5I\3\2\2\2\u02b6\u02b8\5\u00b4[\2\u02b7\u02b6\3\2\2\2\u02b7"+
		"\u02b8\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02bb\5\u00be`\2\u02ba\u02bc"+
		"\5\u00b4[\2\u02bb\u02ba\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\3\2\2"+
		"\2\u02bd\u02be\7\u008b\2\2\u02be\u02c1\7\u00ab\2\2\u02bf\u02c2\5\u00b4"+
		"[\2\u02c0\u02c2\5\u00be`\2\u02c1\u02bf\3\2\2\2\u02c1\u02c0\3\2\2\2\u02c1"+
		"\u02c2\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c5\7\u008c\2\2\u02c4\u02c6"+
		"\5X-\2\u02c5\u02c4\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6K\3\2\2\2\u02c7\u02d0"+
		"\7\u0098\2\2\u02c8\u02cd\5N(\2\u02c9\u02ca\7\u0092\2\2\u02ca\u02cc\5N"+
		"(\2\u02cb\u02c9\3\2\2\2\u02cc\u02cf\3\2\2\2\u02cd\u02cb\3\2\2\2\u02cd"+
		"\u02ce\3\2\2\2\u02ce\u02d1\3\2\2\2\u02cf\u02cd\3\2\2\2\u02d0\u02c8\3\2"+
		"\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d3\7\u0097\2\2\u02d3"+
		"M\3\2\2\2\u02d4\u02d6\5\u00b8]\2\u02d5\u02d4\3\2\2\2\u02d6\u02d9\3\2\2"+
		"\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02da\3\2\2\2\u02d9\u02d7"+
		"\3\2\2\2\u02da\u02db\5\u00be`\2\u02dbO\3\2\2\2\u02dc\u02dd\7\u0095\2\2"+
		"\u02dd\u02e9\7\u008d\2\2\u02de\u02e3\5R*\2\u02df\u02e0\7\u0092\2\2\u02e0"+
		"\u02e2\5R*\2\u02e1\u02df\3\2\2\2\u02e2\u02e5\3\2\2\2\u02e3\u02e1\3\2\2"+
		"\2\u02e3\u02e4\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e6\u02e8"+
		"\7\u0092\2\2\u02e7\u02e6\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02ea\3\2\2"+
		"\2\u02e9\u02de\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec"+
		"\7\u008e\2\2\u02ecQ\3\2\2\2\u02ed\u02ee\5\u0110\u0089\2\u02ee\u02ef\7"+
		"\u009c\2\2\u02ef\u02f0\5\u010c\u0087\2\u02f0S\3\2\2\2\u02f1\u02f2\7\u0095"+
		"\2\2\u02f2\u02f7\7\u008f\2\2\u02f3\u02f5\5\u010a\u0086\2\u02f4\u02f6\7"+
		"\u0092\2\2\u02f5\u02f4\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f8\3\2\2\2"+
		"\u02f7\u02f3\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fa"+
		"\7\u0090\2\2\u02faU\3\2\2\2\u02fb\u02fc\7\u0095\2\2\u02fc\u02fd\7\u008b"+
		"\2\2\u02fd\u02fe\5\u010c\u0087\2\u02fe\u02ff\7\u008c\2\2\u02ff\u0306\3"+
		"\2\2\2\u0300\u0303\7\u0095\2\2\u0301\u0304\5\u0126\u0094\2\u0302\u0304"+
		"\5\u012a\u0096\2\u0303\u0301\3\2\2\2\u0303\u0302\3\2\2\2\u0304\u0306\3"+
		"\2\2\2\u0305\u02fb\3\2\2\2\u0305\u0300\3\2\2\2\u0306W\3\2\2\2\u0307\u0313"+
		"\7\u008b\2\2\u0308\u030b\5Z.\2\u0309\u030b\7\"\2\2\u030a\u0308\3\2\2\2"+
		"\u030a\u0309\3\2\2\2\u030b\u0310\3\2\2\2\u030c\u030d\7\u0092\2\2\u030d"+
		"\u030f\5Z.\2\u030e\u030c\3\2\2\2\u030f\u0312\3\2\2\2\u0310\u030e\3\2\2"+
		"\2\u0310\u0311\3\2\2\2\u0311\u0314\3\2\2\2\u0312\u0310\3\2\2\2\u0313\u030a"+
		"\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316\7\u008c\2"+
		"\2\u0316Y\3\2\2\2\u0317\u031a\5p9\2\u0318\u031a\5\u00dep\2\u0319\u0317"+
		"\3\2\2\2\u0319\u0318\3\2\2\2\u031a[\3\2\2\2\u031b\u031d\7\u00ab\2\2\u031c"+
		"\u031e\5\u00be`\2\u031d\u031c\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u0320"+
		"\3\2\2\2\u031f\u0321\5\u00b4[\2\u0320\u031f\3\2\2\2\u0320\u0321\3\2\2"+
		"\2\u0321\u0323\3\2\2\2\u0322\u0324\5X-\2\u0323\u0322\3\2\2\2\u0323\u0324"+
		"\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326\5\u00f0y\2\u0326]\3\2\2\2\u0327"+
		"\u0328\7\u008f\2\2\u0328\u0329\5`\61\2\u0329\u032a\5b\62\2\u032a\u032b"+
		"\7\u0090\2\2\u032b_\3\2\2\2\u032c\u032f\5\u010c\u0087\2\u032d\u032f\5"+
		"\u00be`\2\u032e\u032c\3\2\2\2\u032e\u032d\3\2\2\2\u032fa\3\2\2\2\u0330"+
		"\u0337\5@!\2\u0331\u0333\5d\63\2\u0332\u0331\3\2\2\2\u0333\u0334\3\2\2"+
		"\2\u0334\u0332\3\2\2\2\u0334\u0335\3\2\2\2\u0335\u0337\3\2\2\2\u0336\u0330"+
		"\3\2\2\2\u0336\u0332\3\2\2\2\u0337c\3\2\2\2\u0338\u033a\5@!\2\u0339\u0338"+
		"\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u033c\7\u009c\2"+
		"\2\u033c\u0341\5f\64\2\u033d\u033e\7\u0092\2\2\u033e\u0340\5f\64\2\u033f"+
		"\u033d\3\2\2\2\u0340\u0343\3\2\2\2\u0341\u033f\3\2\2\2\u0341\u0342\3\2"+
		"\2\2\u0342e\3\2\2\2\u0343\u0341\3\2\2\2\u0344\u0346\5\u010a\u0086\2\u0345"+
		"\u0347\5\u00b4[\2\u0346\u0345\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u034c"+
		"\3\2\2\2\u0348\u0349\7\u008d\2\2\u0349\u034a\5\u00dco\2\u034a\u034b\7"+
		"\u008e\2\2\u034b\u034d\3\2\2\2\u034c\u0348\3\2\2\2\u034c\u034d\3\2\2\2"+
		"\u034dg\3\2\2\2\u034e\u034f\7N\2\2\u034f\u0350\7\u008b\2\2\u0350\u0351"+
		"\5j\66\2\u0351\u0352\7\u008c\2\2\u0352i\3\2\2\2\u0353\u035d\5@!\2\u0354"+
		"\u0356\5@!\2\u0355\u0354\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u0357\3\2\2"+
		"\2\u0357\u0359\7\u009c\2\2\u0358\u0355\3\2\2\2\u0359\u035a\3\2\2\2\u035a"+
		"\u0358\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035d\3\2\2\2\u035c\u0353\3\2"+
		"\2\2\u035c\u0358\3\2\2\2\u035dk\3\2\2\2\u035e\u035f\7G\2\2\u035f\u0360"+
		"\7\u008b\2\2\u0360\u0361\5$\23\2\u0361\u0362\7\u008c\2\2\u0362m\3\2\2"+
		"\2\u0363\u0364\7@\2\2\u0364\u0365\7\u008b\2\2\u0365\u0366\5\u00dep\2\u0366"+
		"\u0367\7\u008c\2\2\u0367o\3\2\2\2\u0368\u0369\5\u00a0Q\2\u0369\u036a\5"+
		"\u00e8u\2\u036aq\3\2\2\2\u036b\u036c\7Q\2\2\u036c\u036d\7\u008b\2\2\u036d"+
		"\u036e\5\u012a\u0096\2\u036e\u036f\7\u008c\2\2\u036f\u0373\3\2\2\2\u0370"+
		"\u0371\7Q\2\2\u0371\u0373\5\u010c\u0087\2\u0372\u036b\3\2\2\2\u0372\u0370"+
		"\3\2\2\2\u0373s\3\2\2\2\u0374\u0375\7R\2\2\u0375\u0379\5\u00f0y\2\u0376"+
		"\u0378\5v<\2\u0377\u0376\3\2\2\2\u0378\u037b\3\2\2\2\u0379\u0377\3\2\2"+
		"\2\u0379\u037a\3\2\2\2\u037a\u037e\3\2\2\2\u037b\u0379\3\2\2\2\u037c\u037d"+
		"\7B\2\2\u037d\u037f\5\u00f0y\2\u037e\u037c\3\2\2\2\u037e\u037f\3\2\2\2"+
		"\u037fu\3\2\2\2\u0380\u0381\7=\2\2\u0381\u0382\7\u008b\2\2\u0382\u0383"+
		"\5p9\2\u0383\u0384\7\u008c\2\2\u0384\u0385\5\u00f0y\2\u0385w\3\2\2\2\u0386"+
		"\u0387\7O\2\2\u0387\u0388\7\u008b\2\2\u0388\u0389\5\u010c\u0087\2\u0389"+
		"\u038a\7\u008c\2\2\u038a\u038b\5\u00f0y\2\u038by\3\2\2\2\u038c\u038d\7"+
		"<\2\2\u038d\u038e\5\u00f0y\2\u038e{\3\2\2\2\u038f\u0394\5\u0080A\2\u0390"+
		"\u0393\5\u00d6l\2\u0391\u0393\5\u00a4S\2\u0392\u0390\3\2\2\2\u0392\u0391"+
		"\3\2\2\2\u0393\u0396\3\2\2\2\u0394\u0392\3\2\2\2\u0394\u0395\3\2\2\2\u0395"+
		"\u0397\3\2\2\2\u0396\u0394\3\2\2\2\u0397\u0398\7\u0091\2\2\u0398}\3\2"+
		"\2\2\u0399\u039e\5\u0080A\2\u039a\u039d\5\u00d6l\2\u039b\u039d\5\u00a4"+
		"S\2\u039c\u039a\3\2\2\2\u039c\u039b\3\2\2\2\u039d\u03a0\3\2\2\2\u039e"+
		"\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u03a1\3\2\2\2\u03a0\u039e\3\2"+
		"\2\2\u03a1\u03a2\5\u00f0y\2\u03a2\177\3\2\2\2\u03a3\u03a5\5\u00a0Q\2\u03a4"+
		"\u03a3\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a7\5\u012a"+
		"\u0096\2\u03a7\u03a9\7\u008b\2\2\u03a8\u03aa\5\u00d2j\2\u03a9\u03a8\3"+
		"\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03ac\7\u008c\2\2"+
		"\u03ac\u03ae\3\2\2\2\u03ad\u03af\5\u00a4S\2\u03ae\u03ad\3\2\2\2\u03ae"+
		"\u03af\3\2\2\2\u03af\u0081\3\2\2\2\u03b0\u03b2\5\u00a0Q\2\u03b1\u03b0"+
		"\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b3\3\2\2\2\u03b3\u03b4\7\u008b\2"+
		"\2\u03b4\u03b6\7\u00a7\2\2\u03b5\u03b7\5\u00b4[\2\u03b6\u03b5\3\2\2\2"+
		"\u03b6\u03b7\3\2\2\2\u03b7\u03b9\3\2\2\2\u03b8\u03ba\5\u012a\u0096\2\u03b9"+
		"\u03b8\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03bc\7\u008c"+
		"\2\2\u03bc\u03bd\3\2\2\2\u03bd\u03bf\7\u008b\2\2\u03be\u03c0\5\u00d2j"+
		"\2\u03bf\u03be\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03c2"+
		"\7\u008c\2\2\u03c2\u03c4\3\2\2\2\u03c3\u03c5\5\u00a4S\2\u03c4\u03c3\3"+
		"\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u0083\3\2\2\2\u03c6\u03c8\5\u0086D\2"+
		"\u03c7\u03c9\5\u0088E\2\u03c8\u03c7\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9"+
		"\u0085\3\2\2\2\u03ca\u03cd\7\7\2\2\u03cb\u03cd\5\u012a\u0096\2\u03cc\u03ca"+
		"\3\2\2\2\u03cc\u03cb\3\2\2\2\u03cd\u0087\3\2\2\2\u03ce\u03d0\7\u008b\2"+
		"\2\u03cf\u03d1\5\u008aF\2\u03d0\u03cf\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1"+
		"\u03d2\3\2\2\2\u03d2\u03d3\7\u008c\2\2\u03d3\u0089\3\2\2\2\u03d4\u03d9"+
		"\5\u008cG\2\u03d5\u03d6\7\u0092\2\2\u03d6\u03d8\5\u008cG\2\u03d7\u03d5"+
		"\3\2\2\2\u03d8\u03db\3\2\2\2\u03d9\u03d7\3\2\2\2\u03d9\u03da\3\2\2\2\u03da"+
		"\u008b\3\2\2\2\u03db\u03d9\3\2\2\2\u03dc\u03e1\5\u0084C\2\u03dd\u03e1"+
		"\5\u0126\u0094\2\u03de\u03e1\5\u0128\u0095\2\u03df\u03e1\5\u008eH\2\u03e0"+
		"\u03dc\3\2\2\2\u03e0\u03dd\3\2\2\2\u03e0\u03de\3\2\2\2\u03e0\u03df\3\2"+
		"\2\2\u03e1\u008d\3\2\2\2\u03e2\u03e3\5\u0086D\2\u03e3\u03e7\7\u0096\2"+
		"\2\u03e4\u03e8\5\u0126\u0094\2\u03e5\u03e8\5\u0086D\2\u03e6\u03e8\5\u0128"+
		"\u0095\2\u03e7\u03e4\3\2\2\2\u03e7\u03e5\3\2\2\2\u03e7\u03e6\3\2\2\2\u03e8"+
		"\u008f\3\2\2\2\u03e9\u03ee\5\u0092J\2\u03ea\u03ee\5\u0094K\2\u03eb\u03ee"+
		"\5\u0096L\2\u03ec\u03ee\5\u0098M\2\u03ed\u03e9\3\2\2\2\u03ed\u03ea\3\2"+
		"\2\2\u03ed\u03eb\3\2\2\2\u03ed\u03ec\3\2\2\2\u03ee\u0091\3\2\2\2\u03ef"+
		"\u03f1\5\u00a4S\2\u03f0\u03ef\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03f2"+
		"\3\2\2\2\u03f2\u03f4\5\u012a\u0096\2\u03f3\u03f5\5\u00a4S\2\u03f4\u03f3"+
		"\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6\u03f7\7\u008b\2"+
		"\2\u03f7\u03f8\5\u00ceh\2\u03f8\u03f9\7\u008c\2\2\u03f9\u03fa\7\u0091"+
		"\2\2\u03fa\u0093\3\2\2\2\u03fb\u03fe\5\u00d6l\2\u03fc\u03fe\5\u00a4S\2"+
		"\u03fd\u03fb\3\2\2\2\u03fd\u03fc\3\2\2\2\u03fe\u0401\3\2\2\2\u03ff\u03fd"+
		"\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0403\3\2\2\2\u0401\u03ff\3\2\2\2\u0402"+
		"\u0404\7\37\2\2\u0403\u0402\3\2\2\2\u0403\u0404\3\2\2\2\u0404\u0405\3"+
		"\2\2\2\u0405\u0407\5\u00c6d\2\u0406\u0408\5\u012a\u0096\2\u0407\u0406"+
		"\3\2\2\2\u0407\u0408\3\2\2\2\u0408\u040d\3\2\2\2\u0409\u040c\5\u00d6l"+
		"\2\u040a\u040c\5\u00a4S\2\u040b\u0409\3\2\2\2\u040b\u040a\3\2\2\2\u040c"+
		"\u040f\3\2\2\2\u040d\u040b\3\2\2\2\u040d\u040e\3\2\2\2\u040e\u0410\3\2"+
		"\2\2\u040f\u040d\3\2\2\2\u0410\u0411\7\u0091\2\2\u0411\u0095\3\2\2\2\u0412"+
		"\u0414\5\u00d6l\2\u0413\u0412\3\2\2\2\u0413\u0414\3\2\2\2\u0414\u0419"+
		"\3\2\2\2\u0415\u0416\5\u00a0Q\2\u0416\u0417\5\u00a6T\2\u0417\u041a\3\2"+
		"\2\2\u0418\u041a\5\u00a0Q\2\u0419\u0415\3\2\2\2\u0419\u0418\3\2\2\2\u041a"+
		"\u041f\3\2\2\2\u041b\u041e\5\u00d6l\2\u041c\u041e\5\u00a4S\2\u041d\u041b"+
		"\3\2\2\2\u041d\u041c\3\2\2\2\u041e\u0421\3\2\2\2\u041f\u041d\3\2\2\2\u041f"+
		"\u0420\3\2\2\2\u0420\u0422\3\2\2\2\u0421\u041f\3\2\2\2\u0422\u0423\7\u0091"+
		"\2\2\u0423\u0097\3\2\2\2\u0424\u0426\5\u00a4S\2\u0425\u0424\3\2\2\2\u0425"+
		"\u0426\3\2\2\2\u0426\u0427\3\2\2\2\u0427\u0431\7\37\2\2\u0428\u0429\5"+
		"\u00a0Q\2\u0429\u042a\5\u009aN\2\u042a\u0432\3\2\2\2\u042b\u0432\5\u00a0"+
		"Q\2\u042c\u0432\5\u0082B\2\u042d\u0432\5\u0080A\2\u042e\u042f\5\u00aa"+
		"V\2\u042f\u0430\5\u012a\u0096\2\u0430\u0432\3\2\2\2\u0431\u0428\3\2\2"+
		"\2\u0431\u042b\3\2\2\2\u0431\u042c\3\2\2\2\u0431\u042d\3\2\2\2\u0431\u042e"+
		"\3\2\2\2\u0432\u0437\3\2\2\2\u0433\u0436\5\u00d6l\2\u0434\u0436\5\u00a4"+
		"S\2\u0435\u0433\3\2\2\2\u0435\u0434\3\2\2\2\u0436\u0439\3\2\2\2\u0437"+
		"\u0435\3\2\2\2\u0437\u0438\3\2\2\2\u0438\u043a\3\2\2\2\u0439\u0437\3\2"+
		"\2\2\u043a\u043b\7\u0091\2\2\u043b\u0099\3\2\2\2\u043c\u0441\5\u009cO"+
		"\2\u043d\u043e\7\u0092\2\2\u043e\u0440\5\u009cO\2\u043f\u043d\3\2\2\2"+
		"\u0440\u0443\3\2\2\2\u0441\u043f\3\2\2\2\u0441\u0442\3\2\2\2\u0442\u009b"+
		"\3\2\2\2\u0443\u0441\3\2\2\2\u0444\u0446\5\u00d4k\2\u0445\u0444\3\2\2"+
		"\2\u0445\u0446\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u0448\5\u00ceh\2\u0448"+
		"\u009d\3\2\2\2\u0449\u044f\5\u00b2Z\2\u044a\u044f\5\u00b4[\2\u044b\u044f"+
		"\5\u00b0Y\2\u044c\u044f\5\u00b8]\2\u044d\u044f\5\u00ba^\2\u044e\u0449"+
		"\3\2\2\2\u044e\u044a\3\2\2\2\u044e\u044b\3\2\2\2\u044e\u044c\3\2\2\2\u044e"+
		"\u044d\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u044e\3\2\2\2\u0450\u0451\3\2"+
		"\2\2\u0451\u009f\3\2\2\2\u0452\u0457\5\u00b6\\\2\u0453\u0457\5\u00a4S"+
		"\2\u0454\u0457\5\u009eP\2\u0455\u0457\5\u00be`\2\u0456\u0452\3\2\2\2\u0456"+
		"\u0453\3\2\2\2\u0456\u0454\3\2\2\2\u0456\u0455\3\2\2\2\u0457\u0458\3\2"+
		"\2\2\u0458\u0456\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u00a1\3\2\2\2\u045a"+
		"\u045e\5\u00b6\\\2\u045b\u045e\5\u00a4S\2\u045c\u045e\5\u009eP\2\u045d"+
		"\u045a\3\2\2\2\u045d\u045b\3\2\2\2\u045d\u045c\3\2\2\2\u045e\u045f\3\2"+
		"\2\2\u045f\u045d\3\2\2\2\u045f\u0460\3\2\2\2\u0460\u00a3\3\2\2\2\u0461"+
		"\u0462\7V\2\2\u0462\u0463\7\u008b\2\2\u0463\u0464\7\u008b\2\2\u0464\u0469"+
		"\5\u0084C\2\u0465\u0466\7\u0092\2\2\u0466\u0468\5\u0084C\2\u0467\u0465"+
		"\3\2\2\2\u0468\u046b\3\2\2\2\u0469\u0467\3\2\2\2\u0469\u046a\3\2\2\2\u046a"+
		"\u046c\3\2\2\2\u046b\u0469\3\2\2\2\u046c\u046d\7\u008c\2\2\u046d\u046e"+
		"\7\u008c\2\2\u046e\u00a5\3\2\2\2\u046f\u0474\5\u00a8U\2\u0470\u0471\7"+
		"\u0092\2\2\u0471\u0473\5\u00a8U\2\u0472\u0470\3\2\2\2\u0473\u0476\3\2"+
		"\2\2\u0474\u0472\3\2\2\2\u0474\u0475\3\2\2\2\u0475\u00a7\3\2\2\2\u0476"+
		"\u0474\3\2\2\2\u0477\u047c\5\u00e8u\2\u0478\u047b\5\u00d6l\2\u0479\u047b"+
		"\5\u00a4S\2\u047a\u0478\3\2\2\2\u047a\u0479\3\2\2\2\u047b\u047e\3\2\2"+
		"\2\u047c\u047a\3\2\2\2\u047c\u047d\3\2\2\2\u047d\u0481\3\2\2\2\u047e\u047c"+
		"\3\2\2\2\u047f\u0480\7\u0096\2\2\u0480\u0482\5\u0112\u008a\2\u0481\u047f"+
		"\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u00a9\3\2\2\2\u0483\u0490\t\5\2\2\u0484"+
		"\u0491\5\u012a\u0096\2\u0485\u0487\5\u012a\u0096\2\u0486\u0485\3\2\2\2"+
		"\u0486\u0487\3\2\2\2\u0487\u0488\3\2\2\2\u0488\u048a\7\u008d\2\2\u0489"+
		"\u048b\5\u00acW\2\u048a\u0489\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048a"+
		"\3\2\2\2\u048c\u048d\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u048f\7\u008e\2"+
		"\2\u048f\u0491\3\2\2\2\u0490\u0484\3\2\2\2\u0490\u0486\3\2\2\2\u0491\u00ab"+
		"\3\2\2\2\u0492\u0493\5\u00aeX\2\u0493\u0494\5\u00c2b\2\u0494\u0497\3\2"+
		"\2\2\u0495\u0497\5\u0082B\2\u0496\u0492\3\2\2\2\u0496\u0495\3\2\2\2\u0497"+
		"\u049c\3\2\2\2\u0498\u049b\5\u00d6l\2\u0499\u049b\5\u00a4S\2\u049a\u0498"+
		"\3\2\2\2\u049a\u0499\3\2\2\2\u049b\u049e\3\2\2\2\u049c\u049a\3\2\2\2\u049c"+
		"\u049d\3\2\2\2\u049d\u049f\3\2\2\2\u049e\u049c\3\2\2\2\u049f\u04a0\7\u0091"+
		"\2\2\u04a0\u00ad\3\2\2\2\u04a1\u04a4\5\u009eP\2\u04a2\u04a4\5\u00be`\2"+
		"\u04a3\u04a1\3\2\2\2\u04a3\u04a2\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a3"+
		"\3\2\2\2\u04a5\u04a6\3\2\2\2\u04a6\u00af\3\2\2\2\u04a7\u04a8\7y\2\2\u04a8"+
		"\u04a9\7\u008b\2\2\u04a9\u04aa\5\u012a\u0096\2\u04aa\u04ab\7\u008c\2\2"+
		"\u04ab\u04ae\3\2\2\2\u04ac\u04ae\7x\2\2\u04ad\u04a7\3\2\2\2\u04ad\u04ac"+
		"\3\2\2\2\u04ae\u00b1\3\2\2\2\u04af\u04b0\t\6\2\2\u04b0\u00b3\3\2\2\2\u04b1"+
		"\u04b2\t\7\2\2\u04b2\u00b5\3\2\2\2\u04b3\u04b4\t\b\2\2\u04b4\u00b7\3\2"+
		"\2\2\u04b5\u04b6\t\t\2\2\u04b6\u00b9\3\2\2\2\u04b7\u04bc\7\7\2\2\u04b8"+
		"\u04bc\7#\2\2\u04b9\u04bc\7\27\2\2\u04ba\u04bc\5\u00bc_\2\u04bb\u04b7"+
		"\3\2\2\2\u04bb\u04b8\3\2\2\2\u04bb\u04b9\3\2\2\2\u04bb\u04ba\3\2\2\2\u04bc"+
		"\u00bb\3\2\2\2\u04bd\u04be\t\n\2\2\u04be\u00bd\3\2\2\2\u04bf\u04c1\t\13"+
		"\2\2\u04c0\u04bf\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c0\3\2\2\2\u04c2"+
		"\u04c3\3\2\2\2\u04c3\u04ca\3\2\2\2\u04c4\u04ca\5\u00c0a\2\u04c5\u04ca"+
		"\5\20\t\2\u04c6\u04ca\5\u00aaV\2\u04c7\u04ca\5\u00c6d\2\u04c8\u04ca\5"+
		"\u012a\u0096\2\u04c9\u04c0\3\2\2\2\u04c9\u04c4\3\2\2\2\u04c9\u04c5\3\2"+
		"\2\2\u04c9\u04c6\3\2\2\2\u04c9\u04c7\3\2\2\2\u04c9\u04c8\3\2\2\2\u04ca"+
		"\u04cc\3\2\2\2\u04cb\u04cd\5\u00d4k\2\u04cc\u04cb\3\2\2\2\u04cc\u04cd"+
		"\3\2\2\2\u04cd\u00bf\3\2\2\2\u04ce\u04cf\7a\2\2\u04cf\u04d0\7\u008b\2"+
		"\2\u04d0\u04d1\5\u010c\u0087\2\u04d1\u04d2\7\u008c\2\2\u04d2\u00c1\3\2"+
		"\2\2\u04d3\u04d8\5\u00c4c\2\u04d4\u04d5\7\u0092\2\2\u04d5\u04d7\5\u00c4"+
		"c\2\u04d6\u04d4\3\2\2\2\u04d7\u04da\3\2\2\2\u04d8\u04d6\3\2\2\2\u04d8"+
		"\u04d9\3\2\2\2\u04d9\u00c3\3\2\2\2\u04da\u04d8\3\2\2\2\u04db\u04e2\5\u00e8"+
		"u\2\u04dc\u04de\5\u00e8u\2\u04dd\u04dc\3\2\2\2\u04dd\u04de\3\2\2\2\u04de"+
		"\u04df\3\2\2\2\u04df\u04e0\7\u009c\2\2\u04e0\u04e2\5\u0126\u0094\2\u04e1"+
		"\u04db\3\2\2\2\u04e1\u04dd\3\2\2\2\u04e2\u00c5\3\2\2\2\u04e3\u04e9\7\r"+
		"\2\2\u04e4\u04e6\5\u012a\u0096\2\u04e5\u04e4\3\2\2\2\u04e5\u04e6\3\2\2"+
		"\2\u04e6\u04e7\3\2\2\2\u04e7\u04e8\7\u009c\2\2\u04e8\u04ea\5\u00dep\2"+
		"\u04e9\u04e5\3\2\2\2\u04e9\u04ea\3\2\2\2\u04ea\u04f6\3\2\2\2\u04eb\u04f0"+
		"\5\u012a\u0096\2\u04ec\u04ed\7\u008d\2\2\u04ed\u04ee\5\u00c8e\2\u04ee"+
		"\u04ef\7\u008e\2\2\u04ef\u04f1\3\2\2\2\u04f0\u04ec\3\2\2\2\u04f0\u04f1"+
		"\3\2\2\2\u04f1\u04f7\3\2\2\2\u04f2\u04f3\7\u008d\2\2\u04f3\u04f4\5\u00c8"+
		"e\2\u04f4\u04f5\7\u008e\2\2\u04f5\u04f7\3\2\2\2\u04f6\u04eb\3\2\2\2\u04f6"+
		"\u04f2\3\2\2\2\u04f7\u0505\3\2\2\2\u04f8\u04f9\t\f\2\2\u04f9\u04fa\7\u008b"+
		"\2\2\u04fa\u04fd\5\u00dep\2\u04fb\u04fc\7\u0092\2\2\u04fc\u04fe\5\u012a"+
		"\u0096\2\u04fd\u04fb\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff"+
		"\u0500\7\u008c\2\2\u0500\u0501\7\u008d\2\2\u0501\u0502\5\u00c8e\2\u0502"+
		"\u0503\7\u008e\2\2\u0503\u0505\3\2\2\2\u0504\u04e3\3\2\2\2\u0504\u04f8"+
		"\3\2\2\2\u0505\u00c7\3\2\2\2\u0506\u050b\5\u00caf\2\u0507\u0508\7\u0092"+
		"\2\2\u0508\u050a\5\u00caf\2\u0509\u0507\3\2\2\2\u050a\u050d\3\2\2\2\u050b"+
		"\u0509\3\2\2\2\u050b\u050c\3\2\2\2\u050c\u050f\3\2\2\2\u050d\u050b\3\2"+
		"\2\2\u050e\u0510\7\u0092\2\2\u050f\u050e\3\2\2\2\u050f\u0510\3\2\2\2\u0510"+
		"\u00c9\3\2\2\2\u0511\u0516\5\u00ccg\2\u0512\u0515\5\u00d6l\2\u0513\u0515"+
		"\5\u00a4S\2\u0514\u0512\3\2\2\2\u0514\u0513\3\2\2\2\u0515\u0518\3\2\2"+
		"\2\u0516\u0514\3\2\2\2\u0516\u0517\3\2\2\2\u0517\u051b\3\2\2\2\u0518\u0516"+
		"\3\2\2\2\u0519\u051a\7\u0096\2\2\u051a\u051c\5\u010c\u0087\2\u051b\u0519"+
		"\3\2\2\2\u051b\u051c\3\2\2\2\u051c\u00cb\3\2\2\2\u051d\u0520\5\u012a\u0096"+
		"\2\u051e\u0520\7\t\2\2\u051f\u051d\3\2\2\2\u051f\u051e\3\2\2\2\u0520\u00cd"+
		"\3\2\2\2\u0521\u0527\5\u012a\u0096\2\u0522\u0523\7\u008b\2\2\u0523\u0524"+
		"\5\u00e8u\2\u0524\u0525\7\u008c\2\2\u0525\u0527\3\2\2\2\u0526\u0521\3"+
		"\2\2\2\u0526\u0522\3\2\2\2\u0527\u052b\3\2\2\2\u0528\u052a\5\u00d0i\2"+
		"\u0529\u0528\3\2\2\2\u052a\u052d\3\2\2\2\u052b\u0529\3\2\2\2\u052b\u052c"+
		"\3\2\2\2\u052c\u0539\3\2\2\2\u052d\u052b\3\2\2\2\u052e\u052f\7\u008b\2"+
		"\2\u052f\u0531\7\u00ab\2\2\u0530\u0532\5\u00b4[\2\u0531\u0530\3\2\2\2"+
		"\u0531\u0532\3\2\2\2\u0532\u0534\3\2\2\2\u0533\u0535\5\u012a\u0096\2\u0534"+
		"\u0533\3\2\2\2\u0534\u0535\3\2\2\2\u0535\u0536\3\2\2\2\u0536\u0537\7\u008c"+
		"\2\2\u0537\u0539\5X-\2\u0538\u0526\3\2\2\2\u0538\u052e\3\2\2\2\u0539\u00cf"+
		"\3\2\2\2\u053a\u053c\7\u008f\2\2\u053b\u053d\5\u0114\u008b\2\u053c\u053b"+
		"\3\2\2\2\u053c\u053d\3\2\2\2\u053d\u053e\3\2\2\2\u053e\u053f\7\u0090\2"+
		"\2\u053f\u00d1\3\2\2\2\u0540\u0543\5\u00e4s\2\u0541\u0542\7\u0092\2\2"+
		"\u0542\u0544\7\u00b7\2\2\u0543\u0541\3\2\2\2\u0543\u0544\3\2\2\2\u0544"+
		"\u00d3\3\2\2\2\u0545\u0547\7\u00a7\2\2\u0546\u0548\5\u00a2R\2\u0547\u0546"+
		"\3\2\2\2\u0547\u0548\3\2\2\2\u0548\u054a\3\2\2\2\u0549\u054b\5\u00d4k"+
		"\2\u054a\u0549\3\2\2\2\u054a\u054b\3\2\2\2\u054b\u00d5\3\2\2\2\u054c\u0572"+
		"\5\u012a\u0096\2\u054d\u0564\7\u008b\2\2\u054e\u0565\5\u0124\u0093\2\u054f"+
		"\u0565\5\u0122\u0092\2\u0550\u0555\5\u012a\u0096\2\u0551\u0552\7\u0093"+
		"\2\2\u0552\u0554\5\u012a\u0096\2\u0553\u0551\3\2\2\2\u0554\u0557\3\2\2"+
		"\2\u0555\u0553\3\2\2\2\u0555\u0556\3\2\2\2\u0556\u0562\3\2\2\2\u0557\u0555"+
		"\3\2\2\2\u0558\u055e\7\u008b\2\2\u0559\u055a\5\u012a\u0096\2\u055a\u055b"+
		"\7\u009c\2\2\u055b\u055d\3\2\2\2\u055c\u0559\3\2\2\2\u055d\u0560\3\2\2"+
		"\2\u055e\u055c\3\2\2\2\u055e\u055f\3\2\2\2\u055f\u0561\3\2\2\2\u0560\u055e"+
		"\3\2\2\2\u0561\u0563\7\u008c\2\2\u0562\u0558\3\2\2\2\u0562\u0563\3\2\2"+
		"\2\u0563\u0565\3\2\2\2\u0564\u054e\3\2\2\2\u0564\u054f\3\2\2\2\u0564\u0550"+
		"\3\2\2\2\u0565\u056d\3\2\2\2\u0566\u0569\7\u0092\2\2\u0567\u056a\5\u0124"+
		"\u0093\2\u0568\u056a\5\u0122\u0092\2\u0569\u0567\3\2\2\2\u0569\u0568\3"+
		"\2\2\2\u056a\u056c\3\2\2\2\u056b\u0566\3\2\2\2\u056c\u056f\3\2\2\2\u056d"+
		"\u056b\3\2\2\2\u056d\u056e\3\2\2\2\u056e\u0570\3\2\2\2\u056f\u056d\3\2"+
		"\2\2\u0570\u0571\7\u008c\2\2\u0571\u0573\3\2\2\2\u0572\u054d\3\2\2\2\u0572"+
		"\u0573\3\2\2\2\u0573\u00d7\3\2\2\2\u0574\u0579\7\u008d\2\2\u0575\u0577"+
		"\5\u010a\u0086\2\u0576\u0578\7\u0092\2\2\u0577\u0576\3\2\2\2\u0577\u0578"+
		"\3\2\2\2\u0578\u057a\3\2\2\2\u0579\u0575\3\2\2\2\u0579\u057a\3\2\2\2\u057a"+
		"\u057b\3\2\2\2\u057b\u057c\7\u008e\2\2\u057c\u00d9\3\2\2\2\u057d\u058b"+
		"\7\u008d\2\2\u057e\u057f\7\u0093\2\2\u057f\u0585\5\u010c\u0087\2\u0580"+
		"\u0581\7\u0092\2\2\u0581\u0582\7\u0093\2\2\u0582\u0584\5\u010c\u0087\2"+
		"\u0583\u0580\3\2\2\2\u0584\u0587\3\2\2\2\u0585\u0583\3\2\2\2\u0585\u0586"+
		"\3\2\2\2\u0586\u0589\3\2\2\2\u0587\u0585\3\2\2\2\u0588\u058a\7\u0092\2"+
		"\2\u0589\u0588\3\2\2\2\u0589\u058a\3\2\2\2\u058a\u058c\3\2\2\2\u058b\u057e"+
		"\3\2\2\2\u058b\u058c\3\2\2\2\u058c\u058d\3\2\2\2\u058d\u058e\7\u008e\2"+
		"\2\u058e\u00db\3\2\2\2\u058f\u0594\5\u0112\u008a\2\u0590\u0591\7\u0092"+
		"\2\2\u0591\u0593\5\u0112\u008a\2\u0592\u0590\3\2\2\2\u0593\u0596\3\2\2"+
		"\2\u0594\u0592\3\2\2\2\u0594\u0595\3\2\2\2\u0595\u0598\3\2\2\2\u0596\u0594"+
		"\3\2\2\2\u0597\u0599\7\u0092\2\2\u0598\u0597\3\2\2\2\u0598\u0599\3\2\2"+
		"\2\u0599\u00dd\3\2\2\2\u059a\u059c\5\u00aeX\2\u059b\u059d\5\u00e0q\2\u059c"+
		"\u059b\3\2\2\2\u059c\u059d\3\2\2\2\u059d\u05a1\3\2\2\2\u059e\u05a1\5J"+
		"&\2\u059f\u05a1\5\u0082B\2\u05a0\u059a\3\2\2\2\u05a0\u059e\3\2\2\2\u05a0"+
		"\u059f\3\2\2\2\u05a1\u00df\3\2\2\2\u05a2\u05a4\5\u00d4k\2\u05a3\u05a5"+
		"\5\u00e0q\2\u05a4\u05a3\3\2\2\2\u05a4\u05a5\3\2\2\2\u05a5\u05ba\3\2\2"+
		"\2\u05a6\u05a8\7\u008b\2\2\u05a7\u05a9\5\u00e0q\2\u05a8\u05a7\3\2\2\2"+
		"\u05a8\u05a9\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa\u05ac\7\u008c\2\2\u05ab"+
		"\u05ad\5\u00e2r\2\u05ac\u05ab\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u05ac"+
		"\3\2\2\2\u05ae\u05af\3\2\2\2\u05af\u05ba\3\2\2\2\u05b0\u05b2\7\u008f\2"+
		"\2\u05b1\u05b3\5\u0114\u008b\2\u05b2\u05b1\3\2\2\2\u05b2\u05b3\3\2\2\2"+
		"\u05b3\u05b4\3\2\2\2\u05b4\u05b6\7\u0090\2\2\u05b5\u05b0\3\2\2\2\u05b6"+
		"\u05b7\3\2\2\2\u05b7\u05b5\3\2\2\2\u05b7\u05b8\3\2\2\2\u05b8\u05ba\3\2"+
		"\2\2\u05b9\u05a2\3\2\2\2\u05b9\u05a6\3\2\2\2\u05b9\u05b5\3\2\2\2\u05ba"+
		"\u00e1\3\2\2\2\u05bb\u05bd\7\u008f\2\2\u05bc\u05be\5\u0114\u008b\2\u05bd"+
		"\u05bc\3\2\2\2\u05bd\u05be\3\2\2\2\u05be\u05bf\3\2\2\2\u05bf\u05c6\7\u0090"+
		"\2\2\u05c0\u05c2\7\u008b\2\2\u05c1\u05c3\5\u00e4s\2\u05c2\u05c1\3\2\2"+
		"\2\u05c2\u05c3\3\2\2\2\u05c3\u05c4\3\2\2\2\u05c4\u05c6\7\u008c\2\2\u05c5"+
		"\u05bb\3\2\2\2\u05c5\u05c0\3\2\2\2\u05c6\u00e3\3\2\2\2\u05c7\u05cc\5\u00e6"+
		"t\2\u05c8\u05c9\7\u0092\2\2\u05c9\u05cb\5\u00e6t\2\u05ca\u05c8\3\2\2\2"+
		"\u05cb\u05ce\3\2\2\2\u05cc\u05ca\3\2\2\2\u05cc\u05cd\3\2\2\2\u05cd\u00e5"+
		"\3\2\2\2\u05ce\u05cc\3\2\2\2\u05cf\u05d1\5\u00a0Q\2\u05d0\u05d2\5\u00e8"+
		"u\2\u05d1\u05d0\3\2\2\2\u05d1\u05d2\3\2\2\2\u05d2\u05d6\3\2\2\2\u05d3"+
		"\u05d6\7\"\2\2\u05d4\u05d6\5\u0082B\2\u05d5\u05cf\3\2\2\2\u05d5\u05d3"+
		"\3\2\2\2\u05d5\u05d4\3\2\2\2\u05d6\u00e7\3\2\2\2\u05d7\u05d9\5\u00d4k"+
		"\2\u05d8\u05d7\3\2\2\2\u05d8\u05d9\3\2\2\2\u05d9\u05da\3\2\2\2\u05da\u05db"+
		"\5\u00ceh\2\u05db\u00e9\3\2\2\2\u05dc\u05de\5\u00ecw\2\u05dd\u05df\7\u0091"+
		"\2\2\u05de\u05dd\3\2\2\2\u05de\u05df\3\2\2\2\u05df\u0606\3\2\2\2\u05e0"+
		"\u05e2\5\u00f0y\2\u05e1\u05e3\7\u0091\2\2\u05e2\u05e1\3\2\2\2\u05e2\u05e3"+
		"\3\2\2\2\u05e3\u0606\3\2\2\2\u05e4\u05e6\5\u00f2z\2\u05e5\u05e7\7\u0091"+
		"\2\2\u05e6\u05e5\3\2\2\2\u05e6\u05e7\3\2\2\2\u05e7\u0606\3\2\2\2\u05e8"+
		"\u05ea\5\u00fc\177\2\u05e9\u05eb\7\u0091\2\2\u05ea\u05e9\3\2\2\2\u05ea"+
		"\u05eb\3\2\2\2\u05eb\u0606\3\2\2\2\u05ec\u05ee\5\u0108\u0085\2\u05ed\u05ef"+
		"\7\u0091\2\2\u05ee\u05ed\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef\u0606\3\2\2"+
		"\2\u05f0\u05f2\5x=\2\u05f1\u05f3\7\u0091\2\2\u05f2\u05f1\3\2\2\2\u05f2"+
		"\u05f3\3\2\2\2\u05f3\u0606\3\2\2\2\u05f4\u05f6\5z>\2\u05f5\u05f7\7\u0091"+
		"\2\2\u05f6\u05f5\3\2\2\2\u05f6\u05f7\3\2\2\2\u05f7\u0606\3\2\2\2\u05f8"+
		"\u05fa\5r:\2\u05f9\u05fb\7\u0091\2\2\u05fa\u05f9\3\2\2\2\u05fa\u05fb\3"+
		"\2\2\2\u05fb\u0606\3\2\2\2\u05fc\u05fe\5t;\2\u05fd\u05ff\7\u0091\2\2\u05fe"+
		"\u05fd\3\2\2\2\u05fe\u05ff\3\2\2\2\u05ff\u0606\3\2\2\2\u0600\u0602\5\u010a"+
		"\u0086\2\u0601\u0603\7\u0091\2\2\u0602\u0601\3\2\2\2\u0602\u0603\3\2\2"+
		"\2\u0603\u0606\3\2\2\2\u0604\u0606\7\u0091\2\2\u0605\u05dc\3\2\2\2\u0605"+
		"\u05e0\3\2\2\2\u0605\u05e4\3\2\2\2\u0605\u05e8\3\2\2\2\u0605\u05ec\3\2"+
		"\2\2\u0605\u05f0\3\2\2\2\u0605\u05f4\3\2\2\2\u0605\u05f8\3\2\2\2\u0605"+
		"\u05fc\3\2\2\2\u0605\u0600\3\2\2\2\u0605\u0604\3\2\2\2\u0606\u00eb\3\2"+
		"\2\2\u0607\u0608\5\u012a\u0096\2\u0608\u0609\7\u009c\2\2\u0609\u060a\5"+
		"\u00eav\2\u060a\u00ed\3\2\2\2\u060b\u060e\5\u0114\u008b\2\u060c\u060d"+
		"\7\u00b7\2\2\u060d\u060f\5\u0114\u008b\2\u060e\u060c\3\2\2\2\u060e\u060f"+
		"\3\2\2\2\u060f\u00ef\3\2\2\2\u0610\u0615\7\u008d\2\2\u0611\u0614\5\u0090"+
		"I\2\u0612\u0614\5\u00eav\2\u0613\u0611\3\2\2\2\u0613\u0612\3\2\2\2\u0614"+
		"\u0617\3\2\2\2\u0615\u0613\3\2\2\2\u0615\u0616\3\2\2\2\u0616\u0618\3\2"+
		"\2\2\u0617\u0615\3\2\2\2\u0618\u0619\7\u008e\2\2\u0619\u00f1\3\2\2\2\u061a"+
		"\u061b\7\22\2\2\u061b\u061c\7\u008b\2\2\u061c\u061d\5\u010c\u0087\2\u061d"+
		"\u061e\7\u008c\2\2\u061e\u0621\5\u00eav\2\u061f\u0620\7\f\2\2\u0620\u0622"+
		"\5\u00eav\2\u0621\u061f\3\2\2\2\u0621\u0622\3\2\2\2\u0622\u0625\3\2\2"+
		"\2\u0623\u0625\5\u00f4{\2\u0624\u061a\3\2\2\2\u0624\u0623\3\2\2\2\u0625"+
		"\u00f3\3\2\2\2\u0626\u0627\7\36\2\2\u0627\u0628\7\u008b\2\2\u0628\u0629"+
		"\5\u010c\u0087\2\u0629\u062a\7\u008c\2\2\u062a\u062b\5\u00f6|\2\u062b"+
		"\u00f5\3\2\2\2\u062c\u0630\7\u008d\2\2\u062d\u062f\5\u00f8}\2\u062e\u062d"+
		"\3\2\2\2\u062f\u0632\3\2\2\2\u0630\u062e\3\2\2\2\u0630\u0631\3\2\2\2\u0631"+
		"\u0633\3\2\2\2\u0632\u0630\3\2\2\2\u0633\u0634\7\u008e\2\2\u0634\u00f7"+
		"\3\2\2\2\u0635\u0637\5\u00fa~\2\u0636\u0635\3\2\2\2\u0637\u0638\3\2\2"+
		"\2\u0638\u0636\3\2\2\2\u0638\u0639\3\2\2\2\u0639\u063b\3\2\2\2\u063a\u063c"+
		"\5\u00eav\2\u063b\u063a\3\2\2\2\u063c\u063d\3\2\2\2\u063d\u063b\3\2\2"+
		"\2\u063d\u063e\3\2\2\2\u063e\u00f9\3\2\2\2\u063f\u0645\7\5\2\2\u0640\u0646"+
		"\5\u00eex\2\u0641\u0642\7\u008b\2\2\u0642\u0643\5\u00eex\2\u0643\u0644"+
		"\7\u008c\2\2\u0644\u0646\3\2\2\2\u0645\u0640\3\2\2\2\u0645\u0641\3\2\2"+
		"\2\u0646\u0647\3\2\2\2\u0647\u0648\7\u009c\2\2\u0648\u064c\3\2\2\2\u0649"+
		"\u064a\7\t\2\2\u064a\u064c\7\u009c\2\2\u064b\u063f\3\2\2\2\u064b\u0649"+
		"\3\2\2\2\u064c\u00fb\3\2\2\2\u064d\u0652\5\u00fe\u0080\2\u064e\u0652\5"+
		"\u0100\u0081\2\u064f\u0652\5\u0102\u0082\2\u0650\u0652\5\u0106\u0084\2"+
		"\u0651\u064d\3\2\2\2\u0651\u064e\3\2\2\2\u0651\u064f\3\2\2\2\u0651\u0650"+
		"\3\2\2\2\u0652\u00fd\3\2\2\2\u0653\u0654\7$\2\2\u0654\u0655\7\u008b\2"+
		"\2\u0655\u0656\5\u010c\u0087\2\u0656\u0657\7\u008c\2\2\u0657\u0658\5\u00ea"+
		"v\2\u0658\u00ff\3\2\2\2\u0659\u065a\7\n\2\2\u065a\u065b\5\u00eav\2\u065b"+
		"\u065c\7$\2\2\u065c\u065d\7\u008b\2\2\u065d\u065e\5\u010c\u0087\2\u065e"+
		"\u065f\7\u008c\2\2\u065f\u0660\7\u0091\2\2\u0660\u0101\3\2\2\2\u0661\u0662"+
		"\7\20\2\2\u0662\u0664\7\u008b\2\2\u0663\u0665\5\u0104\u0083\2\u0664\u0663"+
		"\3\2\2\2\u0664\u0665\3\2\2\2\u0665\u0666\3\2\2\2\u0666\u0668\7\u0091\2"+
		"\2\u0667\u0669\5\u010c\u0087\2\u0668\u0667\3\2\2\2\u0668\u0669\3\2\2\2"+
		"\u0669\u066a\3\2\2\2\u066a\u066c\7\u0091\2\2\u066b\u066d\5\u010a\u0086"+
		"\2\u066c\u066b\3\2\2\2\u066c\u066d\3\2\2\2\u066d\u066e\3\2\2\2\u066e\u066f"+
		"\7\u008c\2\2\u066f\u0670\5\u00eav\2\u0670\u0103\3\2\2\2\u0671\u0672\5"+
		"\u00a0Q\2\u0672\u0673\5\u00a6T\2\u0673\u0676\3\2\2\2\u0674\u0676\5\u010a"+
		"\u0086\2\u0675\u0671\3\2\2\2\u0675\u0674\3\2\2\2\u0676\u0105\3\2\2\2\u0677"+
		"\u0678\7\20\2\2\u0678\u0679\7\u008b\2\2\u0679\u067a\5p9\2\u067a\u067c"+
		"\7\60\2\2\u067b\u067d\5\u010c\u0087\2\u067c\u067b\3\2\2\2\u067c\u067d"+
		"\3\2\2\2\u067d\u067e\3\2\2\2\u067e\u067f\7\u008c\2\2\u067f\u0680\5\u00ea"+
		"v\2\u0680\u0107\3\2\2\2\u0681\u0682\7\21\2\2\u0682\u068a\5\u012a\u0096"+
		"\2\u0683\u068a\7\b\2\2\u0684\u068a\7\4\2\2\u0685\u0687\7\30\2\2\u0686"+
		"\u0688\5\u010c\u0087\2\u0687\u0686\3\2\2\2\u0687\u0688\3\2\2\2\u0688\u068a"+
		"\3\2\2\2\u0689\u0681\3\2\2\2\u0689\u0683\3\2\2\2\u0689\u0684\3\2\2\2\u0689"+
		"\u0685\3\2\2\2\u068a\u0109\3\2\2\2\u068b\u0690\5\u010c\u0087\2\u068c\u068d"+
		"\7\u0092\2\2\u068d\u068f\5\u010c\u0087\2\u068e\u068c\3\2\2\2\u068f\u0692"+
		"\3\2\2\2\u0690\u068e\3\2\2\2\u0690\u0691\3\2\2\2\u0691\u010b\3\2\2\2\u0692"+
		"\u0690\3\2\2\2\u0693\u0694\b\u0087\1\2\u0694\u069e\5\u0110\u0089\2\u0695"+
		"\u0696\7\u008b\2\2\u0696\u0697\5\u00f0y\2\u0697\u0698\7\u008c\2\2\u0698"+
		"\u069e\3\2\2\2\u0699\u069a\5\u0116\u008c\2\u069a\u069b\5\u010e\u0088\2"+
		"\u069b\u069c\5\u010c\u0087\3\u069c\u069e\3\2\2\2\u069d\u0693\3\2\2\2\u069d"+
		"\u0695\3\2\2\2\u069d\u0699\3\2\2\2\u069e\u06cb\3\2\2\2\u069f\u06a0\f\17"+
		"\2\2\u06a0\u06a1\t\r\2\2\u06a1\u06ca\5\u010c\u0087\20\u06a2\u06a3\f\16"+
		"\2\2\u06a3\u06a4\t\16\2\2\u06a4\u06ca\5\u010c\u0087\17\u06a5\u06aa\f\r"+
		"\2\2\u06a6\u06a7\7\u0098\2\2\u06a7\u06ab\7\u0098\2\2\u06a8\u06a9\7\u0097"+
		"\2\2\u06a9\u06ab\7\u0097\2\2\u06aa\u06a6\3\2\2\2\u06aa\u06a8\3\2\2\2\u06ab"+
		"\u06ac\3\2\2\2\u06ac\u06ca\5\u010c\u0087\16\u06ad\u06ae\f\f\2\2\u06ae"+
		"\u06af\t\17\2\2\u06af\u06ca\5\u010c\u0087\r\u06b0\u06b1\f\13\2\2\u06b1"+
		"\u06b2\t\20\2\2\u06b2\u06ca\5\u010c\u0087\f\u06b3\u06b4\f\n\2\2\u06b4"+
		"\u06b5\7\u00a9\2\2\u06b5\u06ca\5\u010c\u0087\13\u06b6\u06b7\f\t\2\2\u06b7"+
		"\u06b8\7\u00ab\2\2\u06b8\u06ca\5\u010c\u0087\n\u06b9\u06ba\f\b\2\2\u06ba"+
		"\u06bb\7\u00aa\2\2\u06bb\u06ca\5\u010c\u0087\t\u06bc\u06bd\f\7\2\2\u06bd"+
		"\u06be\7\u00a1\2\2\u06be\u06ca\5\u010c\u0087\b\u06bf\u06c0\f\6\2\2\u06c0"+
		"\u06c1\7\u00a2\2\2\u06c1\u06ca\5\u010c\u0087\7\u06c2\u06c3\f\5\2\2\u06c3"+
		"\u06c5\7\u009b\2\2\u06c4\u06c6\5\u010c\u0087\2\u06c5\u06c4\3\2\2\2\u06c5"+
		"\u06c6\3\2\2\2\u06c6\u06c7\3\2\2\2\u06c7\u06c8\7\u009c\2\2\u06c8\u06ca"+
		"\5\u010c\u0087\6\u06c9\u069f\3\2\2\2\u06c9\u06a2\3\2\2\2\u06c9\u06a5\3"+
		"\2\2\2\u06c9\u06ad\3\2\2\2\u06c9\u06b0\3\2\2\2\u06c9\u06b3\3\2\2\2\u06c9"+
		"\u06b6\3\2\2\2\u06c9\u06b9\3\2\2\2\u06c9\u06bc\3\2\2\2\u06c9\u06bf\3\2"+
		"\2\2\u06c9\u06c2\3\2\2\2\u06ca\u06cd\3\2\2\2\u06cb\u06c9\3\2\2\2\u06cb"+
		"\u06cc\3\2\2\2\u06cc\u010d\3\2\2\2\u06cd\u06cb\3\2\2\2\u06ce\u06cf\t\21"+
		"\2\2\u06cf\u010f\3\2\2\2\u06d0\u06da\5\u0116\u008c\2\u06d1\u06d2\7\u008b"+
		"\2\2\u06d2\u06d3\5\u00dep\2\u06d3\u06d4\7\u008c\2\2\u06d4\u06d7\3\2\2"+
		"\2\u06d5\u06d8\5\u0110\u0089\2\u06d6\u06d8\5\u0112\u008a\2\u06d7\u06d5"+
		"\3\2\2\2\u06d7\u06d6\3\2\2\2\u06d8\u06da\3\2\2\2\u06d9\u06d0\3\2\2\2\u06d9"+
		"\u06d1\3\2\2\2\u06da\u0111\3\2\2\2\u06db\u06df\5\u010c\u0087\2\u06dc\u06df"+
		"\5\u00d8m\2\u06dd\u06df\5\u00dan\2\u06de\u06db\3\2\2\2\u06de\u06dc\3\2"+
		"\2\2\u06de\u06dd\3\2\2\2\u06df\u0113\3\2\2\2\u06e0\u06e3\5\u012a\u0096"+
		"\2\u06e1\u06e3\5\u0126\u0094\2\u06e2\u06e0\3\2\2\2\u06e2\u06e1\3\2\2\2"+
		"\u06e3\u0115\3\2\2\2\u06e4\u06f3\5\u011a\u008e\2\u06e5\u06eb\7\33\2\2"+
		"\u06e6\u06ec\5\u0116\u008c\2\u06e7\u06e8\7\u008b\2\2\u06e8\u06e9\5\u00be"+
		"`\2\u06e9\u06ea\7\u008c\2\2\u06ea\u06ec\3\2\2\2\u06eb\u06e6\3\2\2\2\u06eb"+
		"\u06e7\3\2\2\2\u06ec\u06f3\3\2\2\2\u06ed\u06ee\t\22\2\2\u06ee\u06f3\5"+
		"\u0116\u008c\2\u06ef\u06f0\5\u0118\u008d\2\u06f0\u06f1\5\u0110\u0089\2"+
		"\u06f1\u06f3\3\2\2\2\u06f2\u06e4\3\2\2\2\u06f2\u06e5\3\2\2\2\u06f2\u06ed"+
		"\3\2\2\2\u06f2\u06ef\3\2\2\2\u06f3\u0117\3\2\2\2\u06f4\u06f5\t\23\2\2"+
		"\u06f5\u0119\3\2\2\2\u06f6\u06f7\b\u008e\1\2\u06f7\u06fb\5\u0124\u0093"+
		"\2\u06f8\u06fa\5\u011c\u008f\2\u06f9\u06f8\3\2\2\2\u06fa\u06fd\3\2\2\2"+
		"\u06fb\u06f9\3\2\2\2\u06fb\u06fc\3\2\2\2\u06fc\u0709\3\2\2\2\u06fd\u06fb"+
		"\3\2\2\2\u06fe\u06ff\f\3\2\2\u06ff\u0700\t\24\2\2\u0700\u0704\5\u012a"+
		"\u0096\2\u0701\u0703\5\u011c\u008f\2\u0702\u0701\3\2\2\2\u0703\u0706\3"+
		"\2\2\2\u0704\u0702\3\2\2\2\u0704\u0705\3\2\2\2\u0705\u0708\3\2\2\2\u0706"+
		"\u0704\3\2\2\2\u0707\u06fe\3\2\2\2\u0708\u070b\3\2\2\2\u0709\u0707\3\2"+
		"\2\2\u0709\u070a\3\2\2\2\u070a\u011b\3\2\2\2\u070b\u0709\3\2\2\2\u070c"+
		"\u070d\7\u008f\2\2\u070d\u070e\5\u010c\u0087\2\u070e\u070f\7\u0090\2\2"+
		"\u070f\u071f\3\2\2\2\u0710\u0712\7\u008b\2\2\u0711\u0713\5\u011e\u0090"+
		"\2\u0712\u0711\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0714\3\2\2\2\u0714\u071f"+
		"\7\u008c\2\2\u0715\u0718\7\u008b\2\2\u0716\u0719\7\u0092\2\2\u0717\u0719"+
		"\n\25\2\2\u0718\u0716\3\2\2\2\u0718\u0717\3\2\2\2\u0719\u071a\3\2\2\2"+
		"\u071a\u0718\3\2\2\2\u071a\u071b\3\2\2\2\u071b\u071c\3\2\2\2\u071c\u071f"+
		"\7\u008c\2\2\u071d\u071f\t\22\2\2\u071e\u070c\3\2\2\2\u071e\u0710\3\2"+
		"\2\2\u071e\u0715\3\2\2\2\u071e\u071d\3\2\2\2\u071f\u011d\3\2\2\2\u0720"+
		"\u0725\5\u0120\u0091\2\u0721\u0722\7\u0092\2\2\u0722\u0724\5\u0120\u0091"+
		"\2\u0723\u0721\3\2\2\2\u0724\u0727\3\2\2\2\u0725\u0723\3\2\2\2\u0725\u0726"+
		"\3\2\2\2\u0726\u011f\3\2\2\2\u0727\u0725\3\2\2\2\u0728\u072b\5\u010c\u0087"+
		"\2\u0729\u072b\5\u00be`\2\u072a\u0728\3\2\2\2\u072a\u0729\3\2\2\2\u072b"+
		"\u0121\3\2\2\2\u072c\u0734\5\u012a\u0096\2\u072d\u072e\7\u008b\2\2\u072e"+
		"\u0731\t\26\2\2\u072f\u0730\7\u0092\2\2\u0730\u0732\t\26\2\2\u0731\u072f"+
		"\3\2\2\2\u0731\u0732\3\2\2\2\u0732\u0733\3\2\2\2\u0733\u0735\7\u008c\2"+
		"\2\u0734\u072d\3\2\2\2\u0734\u0735\3\2\2\2\u0735\u0123\3\2\2\2\u0736\u0746"+
		"\5\u012a\u0096\2\u0737\u0746\5\u0126\u0094\2\u0738\u0746\5\u0128\u0095"+
		"\2\u0739\u073a\7\u008b\2\2\u073a\u073b\5\u010c\u0087\2\u073b\u073c\7\u008c"+
		"\2\2\u073c\u0746\3\2\2\2\u073d\u0746\5^\60\2\u073e\u0746\5h\65\2\u073f"+
		"\u0746\5l\67\2\u0740\u0746\5n8\2\u0741\u0746\5P)\2\u0742\u0746\5T+\2\u0743"+
		"\u0746\5V,\2\u0744\u0746\5\\/\2\u0745\u0736\3\2\2\2\u0745\u0737\3\2\2"+
		"\2\u0745\u0738\3\2\2\2\u0745\u0739\3\2\2\2\u0745\u073d\3\2\2\2\u0745\u073e"+
		"\3\2\2\2\u0745\u073f\3\2\2\2\u0745\u0740\3\2\2\2\u0745\u0741\3\2\2\2\u0745"+
		"\u0742\3\2\2\2\u0745\u0743\3\2\2\2\u0745\u0744\3\2\2\2\u0746\u0125\3\2"+
		"\2\2\u0747\u075a\7\u00ba\2\2\u0748\u075a\7\u00bb\2\2\u0749\u075a\7\u00bc"+
		"\2\2\u074a\u074c\t\16\2\2\u074b\u074a\3\2\2\2\u074b\u074c\3\2\2\2\u074c"+
		"\u074d\3\2\2\2\u074d\u075a\7\u00bd\2\2\u074e\u0750\t\16\2\2\u074f\u074e"+
		"\3\2\2\2\u074f\u0750\3\2\2\2\u0750\u0751\3\2\2\2\u0751\u075a\7\u00be\2"+
		"\2\u0752\u075a\7\u00b8\2\2\u0753\u075a\7\62\2\2\u0754\u075a\7\64\2\2\u0755"+
		"\u075a\7;\2\2\u0756\u075a\7\63\2\2\u0757\u075a\7(\2\2\u0758\u075a\7)\2"+
		"\2\u0759\u0747\3\2\2\2\u0759\u0748\3\2\2\2\u0759\u0749\3\2\2\2\u0759\u074b"+
		"\3\2\2\2\u0759\u074f\3\2\2\2\u0759\u0752\3\2\2\2\u0759\u0753\3\2\2\2\u0759"+
		"\u0754\3\2\2\2\u0759\u0755\3\2\2\2\u0759\u0756\3\2\2\2\u0759\u0757\3\2"+
		"\2\2\u0759\u0758\3\2\2\2\u075a\u0127\3\2\2\2\u075b\u075f\7\u00b9\2\2\u075c"+
		"\u075e\t\27\2\2\u075d\u075c\3\2\2\2\u075e\u0761\3\2\2\2\u075f\u075d\3"+
		"\2\2\2\u075f\u0760\3\2\2\2\u0760\u0762\3\2\2\2\u0761\u075f\3\2\2\2\u0762"+
		"\u0764\7\u00c6\2\2\u0763\u075b\3\2\2\2\u0764\u0765\3\2\2\2\u0765\u0763"+
		"\3\2\2\2\u0765\u0766\3\2\2\2\u0766\u0129\3\2\2\2\u0767\u0768\t\30\2\2"+
		"\u0768\u012b\3\2\2\2\u0111\u012f\u013f\u0147\u014a\u0152\u0155\u0159\u015b"+
		"\u0162\u0168\u016b\u016e\u0174\u0176\u017d\u0184\u0187\u018a\u0192\u0195"+
		"\u0198\u01a2\u01ac\u01b0\u01b2\u01bb\u01c0\u01c9\u01cf\u01d1\u01dc\u01e4"+
		"\u01ee\u01f6\u01f9\u01fc\u0205\u021c\u0223\u0228\u022a\u0230\u0239\u023f"+
		"\u0241\u024a\u024c\u0255\u025a\u025c\u0266\u0268\u0271\u0275\u0278\u0280"+
		"\u0284\u0286\u0289\u028f\u0293\u0299\u02a7\u02ae\u02b4\u02b7\u02bb\u02c1"+
		"\u02c5\u02cd\u02d0\u02d7\u02e3\u02e7\u02e9\u02f5\u02f7\u0303\u0305\u030a"+
		"\u0310\u0313\u0319\u031d\u0320\u0323\u032e\u0334\u0336\u0339\u0341\u0346"+
		"\u034c\u0355\u035a\u035c\u0372\u0379\u037e\u0392\u0394\u039c\u039e\u03a4"+
		"\u03a9\u03ae\u03b1\u03b6\u03b9\u03bf\u03c4\u03c8\u03cc\u03d0\u03d9\u03e0"+
		"\u03e7\u03ed\u03f0\u03f4\u03fd\u03ff\u0403\u0407\u040b\u040d\u0413\u0419"+
		"\u041d\u041f\u0425\u0431\u0435\u0437\u0441\u0445\u044e\u0450\u0456\u0458"+
		"\u045d\u045f\u0469\u0474\u047a\u047c\u0481\u0486\u048c\u0490\u0496\u049a"+
		"\u049c\u04a3\u04a5\u04ad\u04bb\u04c2\u04c9\u04cc\u04d8\u04dd\u04e1\u04e5"+
		"\u04e9\u04f0\u04f6\u04fd\u0504\u050b\u050f\u0514\u0516\u051b\u051f\u0526"+
		"\u052b\u0531\u0534\u0538\u053c\u0543\u0547\u054a\u0555\u055e\u0562\u0564"+
		"\u0569\u056d\u0572\u0577\u0579\u0585\u0589\u058b\u0594\u0598\u059c\u05a0"+
		"\u05a4\u05a8\u05ae\u05b2\u05b7\u05b9\u05bd\u05c2\u05c5\u05cc\u05d1\u05d5"+
		"\u05d8\u05de\u05e2\u05e6\u05ea\u05ee\u05f2\u05f6\u05fa\u05fe\u0602\u0605"+
		"\u060e\u0613\u0615\u0621\u0624\u0630\u0638\u063d\u0645\u064b\u0651\u0664"+
		"\u0668\u066c\u0675\u067c\u0687\u0689\u0690\u069d\u06aa\u06c5\u06c9\u06cb"+
		"\u06d7\u06d9\u06de\u06e2\u06eb\u06f2\u06fb\u0704\u0709\u0712\u0718\u071a"+
		"\u071e\u0725\u072a\u0731\u0734\u0745\u074b\u074f\u0759\u075f\u0765";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}