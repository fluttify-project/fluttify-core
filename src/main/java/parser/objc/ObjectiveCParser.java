// Generated from ObjectiveCParser.g4 by ANTLR 4.10.1
package parser.objc;
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
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

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
		IN=46, INOUT=47, NIL=48, NO=49, NULL_=50, ONEWAY=51, OUT=52, PROTOCOL_=53, 
		SEL=54, SELF=55, SUPER=56, YES=57, AUTORELEASEPOOL=58, CATCH=59, CLASS=60, 
		DYNAMIC=61, ENCODE=62, END=63, FINALLY=64, IMPLEMENTATION=65, INTERFACE=66, 
		IMPORT=67, PACKAGE=68, PROTOCOL=69, OPTIONAL=70, PRIVATE=71, PROPERTY=72, 
		PROTECTED=73, PUBLIC=74, REQUIRED=75, SELECTOR=76, SYNCHRONIZED=77, SYNTHESIZE=78, 
		THROW=79, TRY=80, ATOMIC=81, NONATOMIC=82, RETAIN=83, ATTRIBUTE=84, AUTORELEASING_QUALIFIER=85, 
		BLOCK=86, BRIDGE=87, BRIDGE_RETAINED=88, BRIDGE_TRANSFER=89, COVARIANT=90, 
		CONTRAVARIANT=91, DEPRECATED=92, KINDOF=93, STRONG_QUALIFIER=94, TYPEOF=95, 
		UNSAFE_UNRETAINED_QUALIFIER=96, UNUSED=97, WEAK_QUALIFIER=98, NULL_UNSPECIFIED=99, 
		NULLABLE=100, NONNULL=101, NULL_RESETTABLE=102, NS_INLINE=103, NS_ENUM=104, 
		NS_OPTIONS=105, ASSIGN=106, COPY=107, GETTER=108, SETTER=109, STRONG=110, 
		READONLY=111, READWRITE=112, WEAK=113, UNSAFE_UNRETAINED=114, IB_OUTLET=115, 
		IB_OUTLET_COLLECTION=116, IB_INSPECTABLE=117, IB_DESIGNABLE=118, NS_ASSUME_NONNULL_BEGIN=119, 
		NS_ASSUME_NONNULL_END=120, EXTERN_SUFFIX=121, IOS_SUFFIX=122, MAC_SUFFIX=123, 
		TVOS_PROHIBITED=124, IDENTIFIER=125, LP=126, RP=127, LBRACE=128, RBRACE=129, 
		LBRACK=130, RBRACK=131, SEMI=132, COMMA=133, DOT=134, STRUCTACCESS=135, 
		AT=136, ASSIGNMENT=137, GT=138, LT=139, BANG=140, TILDE=141, QUESTION=142, 
		COLON=143, EQUAL=144, LE=145, GE=146, NOTEQUAL=147, AND=148, OR=149, INC=150, 
		DEC=151, ADD=152, SUB=153, MUL=154, DIV=155, BITAND=156, BITOR=157, BITXOR=158, 
		MOD=159, ADD_ASSIGN=160, SUB_ASSIGN=161, MUL_ASSIGN=162, DIV_ASSIGN=163, 
		AND_ASSIGN=164, OR_ASSIGN=165, XOR_ASSIGN=166, MOD_ASSIGN=167, LSHIFT_ASSIGN=168, 
		RSHIFT_ASSIGN=169, ELIPSIS=170, CHARACTER_LITERAL=171, STRING_START=172, 
		HEX_LITERAL=173, OCTAL_LITERAL=174, BINARY_LITERAL=175, DECIMAL_LITERAL=176, 
		FLOATING_POINT_LITERAL=177, WS=178, MULTI_COMMENT=179, SINGLE_COMMENT=180, 
		BACKSLASH=181, SHARP=182, STRING_NEWLINE=183, STRING_END=184, STRING_VALUE=185, 
		DIRECTIVE_IMPORT=186, DIRECTIVE_INCLUDE=187, DIRECTIVE_PRAGMA=188, DIRECTIVE_DEFINE=189, 
		DIRECTIVE_DEFINED=190, DIRECTIVE_IF=191, DIRECTIVE_ELIF=192, DIRECTIVE_ELSE=193, 
		DIRECTIVE_UNDEF=194, DIRECTIVE_IFDEF=195, DIRECTIVE_IFNDEF=196, DIRECTIVE_ENDIF=197, 
		DIRECTIVE_TRUE=198, DIRECTIVE_FALSE=199, DIRECTIVE_ERROR=200, DIRECTIVE_WARNING=201, 
		DIRECTIVE_BANG=202, DIRECTIVE_LP=203, DIRECTIVE_RP=204, DIRECTIVE_EQUAL=205, 
		DIRECTIVE_NOTEQUAL=206, DIRECTIVE_AND=207, DIRECTIVE_OR=208, DIRECTIVE_LT=209, 
		DIRECTIVE_GT=210, DIRECTIVE_LE=211, DIRECTIVE_GE=212, DIRECTIVE_STRING=213, 
		DIRECTIVE_ID=214, DIRECTIVE_DECIMAL_LITERAL=215, DIRECTIVE_FLOAT=216, 
		DIRECTIVE_NEWLINE=217, DIRECTIVE_MULTI_COMMENT=218, DIRECTIVE_SINGLE_COMMENT=219, 
		DIRECTIVE_BACKSLASH_NEWLINE=220, DIRECTIVE_TEXT_NEWLINE=221, DIRECTIVE_TEXT=222;
	public static final int
		RULE_translationUnit = 0, RULE_topLevelDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_classInterface = 3, RULE_categoryInterface = 4, RULE_classImplementation = 5, 
		RULE_categoryImplementation = 6, RULE_genericTypeSpecifier = 7, RULE_protocolDeclaration = 8, 
		RULE_protocolDeclarationSection = 9, RULE_protocolDeclarationList = 10, 
		RULE_classDeclarationList = 11, RULE_protocolList = 12, RULE_propertyDeclaration = 13, 
		RULE_propertyAttributesList = 14, RULE_propertyAttribute = 15, RULE_protocolName = 16, 
		RULE_instanceVariables = 17, RULE_visibilitySection = 18, RULE_accessModifier = 19, 
		RULE_interfaceDeclarationList = 20, RULE_classMethodDeclaration = 21, 
		RULE_instanceMethodDeclaration = 22, RULE_methodDeclaration = 23, RULE_implementationDefinitionList = 24, 
		RULE_classMethodDefinition = 25, RULE_instanceMethodDefinition = 26, RULE_methodDefinition = 27, 
		RULE_methodSelector = 28, RULE_keywordDeclarator = 29, RULE_selector = 30, 
		RULE_methodType = 31, RULE_propertyImplementation = 32, RULE_propertySynthesizeList = 33, 
		RULE_propertySynthesizeItem = 34, RULE_blockType = 35, RULE_genericsSpecifier = 36, 
		RULE_typeSpecifierWithPrefixes = 37, RULE_dictionaryExpression = 38, RULE_dictionaryPair = 39, 
		RULE_arrayExpression = 40, RULE_boxExpression = 41, RULE_blockParameters = 42, 
		RULE_typeVariableDeclaratorOrName = 43, RULE_blockExpression = 44, RULE_messageExpression = 45, 
		RULE_receiver = 46, RULE_messageSelector = 47, RULE_keywordArgument = 48, 
		RULE_keywordArgumentType = 49, RULE_selectorExpression = 50, RULE_selectorName = 51, 
		RULE_protocolExpression = 52, RULE_encodeExpression = 53, RULE_typeVariableDeclarator = 54, 
		RULE_throwStatement = 55, RULE_tryBlock = 56, RULE_catchStatement = 57, 
		RULE_synchronizedStatement = 58, RULE_autoreleaseStatement = 59, RULE_functionDeclaration = 60, 
		RULE_functionDefinition = 61, RULE_functionSignature = 62, RULE_attribute = 63, 
		RULE_attributeName = 64, RULE_attributeParameters = 65, RULE_attributeParameterList = 66, 
		RULE_attributeParameter = 67, RULE_attributeParameterAssignment = 68, 
		RULE_declaration = 69, RULE_functionCallExpression = 70, RULE_enumDeclaration = 71, 
		RULE_varDeclaration = 72, RULE_typedefDeclaration = 73, RULE_typeDeclaratorList = 74, 
		RULE_typeDeclarator = 75, RULE_declarationSpecifiers = 76, RULE_attributeSpecifier = 77, 
		RULE_initDeclaratorList = 78, RULE_initDeclarator = 79, RULE_structOrUnionSpecifier = 80, 
		RULE_fieldDeclaration = 81, RULE_specifierQualifierList = 82, RULE_ibOutletQualifier = 83, 
		RULE_arcBehaviourSpecifier = 84, RULE_nullabilitySpecifier = 85, RULE_storageClassSpecifier = 86, 
		RULE_typePrefix = 87, RULE_typeQualifier = 88, RULE_protocolQualifier = 89, 
		RULE_typeSpecifier = 90, RULE_typeofExpression = 91, RULE_fieldDeclaratorList = 92, 
		RULE_fieldDeclarator = 93, RULE_enumSpecifier = 94, RULE_enumeratorList = 95, 
		RULE_enumerator = 96, RULE_enumeratorIdentifier = 97, RULE_directDeclarator = 98, 
		RULE_declaratorSuffix = 99, RULE_parameterList = 100, RULE_pointer = 101, 
		RULE_macro = 102, RULE_arrayInitializer = 103, RULE_structInitializer = 104, 
		RULE_initializerList = 105, RULE_typeName = 106, RULE_abstractDeclarator = 107, 
		RULE_abstractDeclaratorSuffix = 108, RULE_parameterDeclarationList = 109, 
		RULE_parameterDeclaration = 110, RULE_declarator = 111, RULE_statement = 112, 
		RULE_labeledStatement = 113, RULE_rangeExpression = 114, RULE_compoundStatement = 115, 
		RULE_selectionStatement = 116, RULE_switchStatement = 117, RULE_switchBlock = 118, 
		RULE_switchSection = 119, RULE_switchLabel = 120, RULE_iterationStatement = 121, 
		RULE_whileStatement = 122, RULE_doStatement = 123, RULE_forStatement = 124, 
		RULE_forLoopInitializer = 125, RULE_forInStatement = 126, RULE_jumpStatement = 127, 
		RULE_expressions = 128, RULE_expression = 129, RULE_assignmentOperator = 130, 
		RULE_castExpression = 131, RULE_initializer = 132, RULE_constantExpression = 133, 
		RULE_unaryExpression = 134, RULE_unaryOperator = 135, RULE_postfixExpression = 136, 
		RULE_postfix = 137, RULE_argumentExpressionList = 138, RULE_argumentExpression = 139, 
		RULE_primaryExpression = 140, RULE_constant = 141, RULE_stringLiteral = 142, 
		RULE_identifier = 143;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "topLevelDeclaration", "importDeclaration", "classInterface", 
			"categoryInterface", "classImplementation", "categoryImplementation", 
			"genericTypeSpecifier", "protocolDeclaration", "protocolDeclarationSection", 
			"protocolDeclarationList", "classDeclarationList", "protocolList", "propertyDeclaration", 
			"propertyAttributesList", "propertyAttribute", "protocolName", "instanceVariables", 
			"visibilitySection", "accessModifier", "interfaceDeclarationList", "classMethodDeclaration", 
			"instanceMethodDeclaration", "methodDeclaration", "implementationDefinitionList", 
			"classMethodDefinition", "instanceMethodDefinition", "methodDefinition", 
			"methodSelector", "keywordDeclarator", "selector", "methodType", "propertyImplementation", 
			"propertySynthesizeList", "propertySynthesizeItem", "blockType", "genericsSpecifier", 
			"typeSpecifierWithPrefixes", "dictionaryExpression", "dictionaryPair", 
			"arrayExpression", "boxExpression", "blockParameters", "typeVariableDeclaratorOrName", 
			"blockExpression", "messageExpression", "receiver", "messageSelector", 
			"keywordArgument", "keywordArgumentType", "selectorExpression", "selectorName", 
			"protocolExpression", "encodeExpression", "typeVariableDeclarator", "throwStatement", 
			"tryBlock", "catchStatement", "synchronizedStatement", "autoreleaseStatement", 
			"functionDeclaration", "functionDefinition", "functionSignature", "attribute", 
			"attributeName", "attributeParameters", "attributeParameterList", "attributeParameter", 
			"attributeParameterAssignment", "declaration", "functionCallExpression", 
			"enumDeclaration", "varDeclaration", "typedefDeclaration", "typeDeclaratorList", 
			"typeDeclarator", "declarationSpecifiers", "attributeSpecifier", "initDeclaratorList", 
			"initDeclarator", "structOrUnionSpecifier", "fieldDeclaration", "specifierQualifierList", 
			"ibOutletQualifier", "arcBehaviourSpecifier", "nullabilitySpecifier", 
			"storageClassSpecifier", "typePrefix", "typeQualifier", "protocolQualifier", 
			"typeSpecifier", "typeofExpression", "fieldDeclaratorList", "fieldDeclarator", 
			"enumSpecifier", "enumeratorList", "enumerator", "enumeratorIdentifier", 
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
			"argumentExpression", "primaryExpression", "constant", "stringLiteral", 
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
			"'@interface'", "'@import'", "'@package'", "'@protocol'", "'@optional'", 
			"'@private'", "'@property'", "'@protected'", "'@public'", "'@required'", 
			"'@selector'", "'@synchronized'", "'@synthesize'", "'@throw'", "'@try'", 
			"'atomic'", "'nonatomic'", "'retain'", "'__attribute__'", "'__autoreleasing'", 
			"'__block'", "'__bridge'", "'__bridge_retained'", "'__bridge_transfer'", 
			"'__covariant'", "'__contravariant'", "'__deprecated'", "'__kindof'", 
			"'__strong'", null, "'__unsafe_unretained'", "'__unused'", "'__weak'", 
			null, null, null, "'null_resettable'", "'NS_INLINE'", "'NS_ENUM'", "'NS_OPTIONS'", 
			"'assign'", "'copy'", "'getter'", "'setter'", "'strong'", "'readonly'", 
			"'readwrite'", "'weak'", "'unsafe_unretained'", "'IBOutlet'", "'IBOutletCollection'", 
			"'IBInspectable'", "'IB_DESIGNABLE'", null, null, null, null, null, "'__TVOS_PROHIBITED'", 
			null, null, null, "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'->'", 
			"'@'", "'='", null, null, null, "'~'", "'?'", "':'", null, null, null, 
			null, null, null, "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", 
			"'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", 
			"'^='", "'%='", "'<<='", "'>>='", "'...'", null, null, null, null, null, 
			null, null, null, null, null, "'\\'", null, null, null, null, null, null, 
			null, null, "'defined'", null, "'elif'", null, "'undef'", "'ifdef'", 
			"'ifndef'", "'endif'"
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
			"NIL", "NO", "NULL_", "ONEWAY", "OUT", "PROTOCOL_", "SEL", "SELF", "SUPER", 
			"YES", "AUTORELEASEPOOL", "CATCH", "CLASS", "DYNAMIC", "ENCODE", "END", 
			"FINALLY", "IMPLEMENTATION", "INTERFACE", "IMPORT", "PACKAGE", "PROTOCOL", 
			"OPTIONAL", "PRIVATE", "PROPERTY", "PROTECTED", "PUBLIC", "REQUIRED", 
			"SELECTOR", "SYNCHRONIZED", "SYNTHESIZE", "THROW", "TRY", "ATOMIC", "NONATOMIC", 
			"RETAIN", "ATTRIBUTE", "AUTORELEASING_QUALIFIER", "BLOCK", "BRIDGE", 
			"BRIDGE_RETAINED", "BRIDGE_TRANSFER", "COVARIANT", "CONTRAVARIANT", "DEPRECATED", 
			"KINDOF", "STRONG_QUALIFIER", "TYPEOF", "UNSAFE_UNRETAINED_QUALIFIER", 
			"UNUSED", "WEAK_QUALIFIER", "NULL_UNSPECIFIED", "NULLABLE", "NONNULL", 
			"NULL_RESETTABLE", "NS_INLINE", "NS_ENUM", "NS_OPTIONS", "ASSIGN", "COPY", 
			"GETTER", "SETTER", "STRONG", "READONLY", "READWRITE", "WEAK", "UNSAFE_UNRETAINED", 
			"IB_OUTLET", "IB_OUTLET_COLLECTION", "IB_INSPECTABLE", "IB_DESIGNABLE", 
			"NS_ASSUME_NONNULL_BEGIN", "NS_ASSUME_NONNULL_END", "EXTERN_SUFFIX", 
			"IOS_SUFFIX", "MAC_SUFFIX", "TVOS_PROHIBITED", "IDENTIFIER", "LP", "RP", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "STRUCTACCESS", 
			"AT", "ASSIGNMENT", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", 
			"EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
			"MUL", "DIV", "BITAND", "BITOR", "BITXOR", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", 
			"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
			"MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "ELIPSIS", "CHARACTER_LITERAL", 
			"STRING_START", "HEX_LITERAL", "OCTAL_LITERAL", "BINARY_LITERAL", "DECIMAL_LITERAL", 
			"FLOATING_POINT_LITERAL", "WS", "MULTI_COMMENT", "SINGLE_COMMENT", "BACKSLASH", 
			"SHARP", "STRING_NEWLINE", "STRING_END", "STRING_VALUE", "DIRECTIVE_IMPORT", 
			"DIRECTIVE_INCLUDE", "DIRECTIVE_PRAGMA", "DIRECTIVE_DEFINE", "DIRECTIVE_DEFINED", 
			"DIRECTIVE_IF", "DIRECTIVE_ELIF", "DIRECTIVE_ELSE", "DIRECTIVE_UNDEF", 
			"DIRECTIVE_IFDEF", "DIRECTIVE_IFNDEF", "DIRECTIVE_ENDIF", "DIRECTIVE_TRUE", 
			"DIRECTIVE_FALSE", "DIRECTIVE_ERROR", "DIRECTIVE_WARNING", "DIRECTIVE_BANG", 
			"DIRECTIVE_LP", "DIRECTIVE_RP", "DIRECTIVE_EQUAL", "DIRECTIVE_NOTEQUAL", 
			"DIRECTIVE_AND", "DIRECTIVE_OR", "DIRECTIVE_LT", "DIRECTIVE_GT", "DIRECTIVE_LE", 
			"DIRECTIVE_GE", "DIRECTIVE_STRING", "DIRECTIVE_ID", "DIRECTIVE_DECIMAL_LITERAL", 
			"DIRECTIVE_FLOAT", "DIRECTIVE_NEWLINE", "DIRECTIVE_MULTI_COMMENT", "DIRECTIVE_SINGLE_COMMENT", 
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
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << CLASS))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (IMPLEMENTATION - 65)) | (1L << (INTERFACE - 65)) | (1L << (IMPORT - 65)) | (1L << (PROTOCOL - 65)) | (1L << (ATOMIC - 65)) | (1L << (NONATOMIC - 65)) | (1L << (RETAIN - 65)) | (1L << (ATTRIBUTE - 65)) | (1L << (AUTORELEASING_QUALIFIER - 65)) | (1L << (BLOCK - 65)) | (1L << (BRIDGE - 65)) | (1L << (BRIDGE_RETAINED - 65)) | (1L << (BRIDGE_TRANSFER - 65)) | (1L << (COVARIANT - 65)) | (1L << (CONTRAVARIANT - 65)) | (1L << (DEPRECATED - 65)) | (1L << (KINDOF - 65)) | (1L << (STRONG_QUALIFIER - 65)) | (1L << (TYPEOF - 65)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 65)) | (1L << (UNUSED - 65)) | (1L << (WEAK_QUALIFIER - 65)) | (1L << (NULL_UNSPECIFIED - 65)) | (1L << (NULLABLE - 65)) | (1L << (NONNULL - 65)) | (1L << (NULL_RESETTABLE - 65)) | (1L << (NS_INLINE - 65)) | (1L << (NS_ENUM - 65)) | (1L << (NS_OPTIONS - 65)) | (1L << (ASSIGN - 65)) | (1L << (COPY - 65)) | (1L << (GETTER - 65)) | (1L << (SETTER - 65)) | (1L << (STRONG - 65)) | (1L << (READONLY - 65)) | (1L << (READWRITE - 65)) | (1L << (WEAK - 65)) | (1L << (UNSAFE_UNRETAINED - 65)) | (1L << (IB_OUTLET - 65)) | (1L << (IB_OUTLET_COLLECTION - 65)) | (1L << (IB_INSPECTABLE - 65)) | (1L << (IB_DESIGNABLE - 65)) | (1L << (IDENTIFIER - 65)))) != 0)) {
				{
				{
				setState(288);
				topLevelDeclaration();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
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
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				importDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(299);
				classInterface();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(300);
				classImplementation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				categoryInterface();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(302);
				categoryImplementation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(303);
				protocolDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(304);
				protocolDeclarationList();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(305);
				classDeclarationList();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(306);
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
		public TerminalNode IMPORT() { return getToken(ObjectiveCParser.IMPORT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(IMPORT);
			setState(310);
			identifier();
			setState(311);
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

	public static class ClassInterfaceContext extends ParserRuleContext {
		public GenericTypeSpecifierContext className;
		public IdentifierContext superclassName;
		public TerminalNode INTERFACE() { return getToken(ObjectiveCParser.INTERFACE, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public TerminalNode IB_DESIGNABLE() { return getToken(ObjectiveCParser.IB_DESIGNABLE, 0); }
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
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
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IB_DESIGNABLE) {
				{
				setState(313);
				match(IB_DESIGNABLE);
				}
			}

			setState(316);
			match(INTERFACE);
			setState(317);
			((ClassInterfaceContext)_localctx).className = genericTypeSpecifier();
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(318);
				match(COLON);
				setState(319);
				((ClassInterfaceContext)_localctx).superclassName = identifier();
				}
			}

			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(322);
				match(LT);
				setState(323);
				protocolList();
				setState(324);
				match(GT);
				}
			}

			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(328);
				instanceVariables();
				}
			}

			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (PROPERTY - 72)) | (1L << (ATOMIC - 72)) | (1L << (NONATOMIC - 72)) | (1L << (RETAIN - 72)) | (1L << (ATTRIBUTE - 72)) | (1L << (AUTORELEASING_QUALIFIER - 72)) | (1L << (BLOCK - 72)) | (1L << (BRIDGE - 72)) | (1L << (BRIDGE_RETAINED - 72)) | (1L << (BRIDGE_TRANSFER - 72)) | (1L << (COVARIANT - 72)) | (1L << (CONTRAVARIANT - 72)) | (1L << (DEPRECATED - 72)) | (1L << (KINDOF - 72)) | (1L << (STRONG_QUALIFIER - 72)) | (1L << (TYPEOF - 72)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 72)) | (1L << (UNUSED - 72)) | (1L << (WEAK_QUALIFIER - 72)) | (1L << (NULL_UNSPECIFIED - 72)) | (1L << (NULLABLE - 72)) | (1L << (NONNULL - 72)) | (1L << (NULL_RESETTABLE - 72)) | (1L << (NS_INLINE - 72)) | (1L << (NS_ENUM - 72)) | (1L << (NS_OPTIONS - 72)) | (1L << (ASSIGN - 72)) | (1L << (COPY - 72)) | (1L << (GETTER - 72)) | (1L << (SETTER - 72)) | (1L << (STRONG - 72)) | (1L << (READONLY - 72)) | (1L << (READWRITE - 72)) | (1L << (WEAK - 72)) | (1L << (UNSAFE_UNRETAINED - 72)) | (1L << (IB_OUTLET - 72)) | (1L << (IB_OUTLET_COLLECTION - 72)) | (1L << (IB_INSPECTABLE - 72)) | (1L << (IB_DESIGNABLE - 72)) | (1L << (IDENTIFIER - 72)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(331);
				interfaceDeclarationList();
				}
			}

			setState(334);
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
		public GenericTypeSpecifierContext categoryName;
		public IdentifierContext className;
		public TerminalNode INTERFACE() { return getToken(ObjectiveCParser.INTERFACE, 0); }
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public GenericTypeSpecifierContext genericTypeSpecifier() {
			return getRuleContext(GenericTypeSpecifierContext.class,0);
		}
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
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
			setState(336);
			match(INTERFACE);
			setState(337);
			((CategoryInterfaceContext)_localctx).categoryName = genericTypeSpecifier();
			setState(338);
			match(LP);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(339);
				((CategoryInterfaceContext)_localctx).className = identifier();
				}
			}

			setState(342);
			match(RP);
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(343);
				match(LT);
				setState(344);
				protocolList();
				setState(345);
				match(GT);
				}
			}

			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(349);
				instanceVariables();
				}
			}

			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (PROPERTY - 72)) | (1L << (ATOMIC - 72)) | (1L << (NONATOMIC - 72)) | (1L << (RETAIN - 72)) | (1L << (ATTRIBUTE - 72)) | (1L << (AUTORELEASING_QUALIFIER - 72)) | (1L << (BLOCK - 72)) | (1L << (BRIDGE - 72)) | (1L << (BRIDGE_RETAINED - 72)) | (1L << (BRIDGE_TRANSFER - 72)) | (1L << (COVARIANT - 72)) | (1L << (CONTRAVARIANT - 72)) | (1L << (DEPRECATED - 72)) | (1L << (KINDOF - 72)) | (1L << (STRONG_QUALIFIER - 72)) | (1L << (TYPEOF - 72)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 72)) | (1L << (UNUSED - 72)) | (1L << (WEAK_QUALIFIER - 72)) | (1L << (NULL_UNSPECIFIED - 72)) | (1L << (NULLABLE - 72)) | (1L << (NONNULL - 72)) | (1L << (NULL_RESETTABLE - 72)) | (1L << (NS_INLINE - 72)) | (1L << (NS_ENUM - 72)) | (1L << (NS_OPTIONS - 72)) | (1L << (ASSIGN - 72)) | (1L << (COPY - 72)) | (1L << (GETTER - 72)) | (1L << (SETTER - 72)) | (1L << (STRONG - 72)) | (1L << (READONLY - 72)) | (1L << (READWRITE - 72)) | (1L << (WEAK - 72)) | (1L << (UNSAFE_UNRETAINED - 72)) | (1L << (IB_OUTLET - 72)) | (1L << (IB_OUTLET_COLLECTION - 72)) | (1L << (IB_INSPECTABLE - 72)) | (1L << (IB_DESIGNABLE - 72)) | (1L << (IDENTIFIER - 72)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(352);
				interfaceDeclarationList();
				}
			}

			setState(355);
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
			setState(357);
			match(IMPLEMENTATION);
			setState(358);
			((ClassImplementationContext)_localctx).className = genericTypeSpecifier();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(359);
				match(COLON);
				setState(360);
				((ClassImplementationContext)_localctx).superclassName = identifier();
				}
			}

			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(363);
				instanceVariables();
				}
			}

			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(366);
				implementationDefinitionList();
				}
			}

			setState(369);
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
		public GenericTypeSpecifierContext categoryName;
		public IdentifierContext className;
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
			setState(371);
			match(IMPLEMENTATION);
			setState(372);
			((CategoryImplementationContext)_localctx).categoryName = genericTypeSpecifier();
			setState(373);
			match(LP);
			setState(374);
			((CategoryImplementationContext)_localctx).className = identifier();
			setState(375);
			match(RP);
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB) {
				{
				setState(376);
				implementationDefinitionList();
				}
			}

			setState(379);
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
			setState(381);
			identifier();
			setState(387);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(382);
				match(LT);
				setState(383);
				protocolList();
				setState(384);
				match(GT);
				}
				}
				break;
			case 2:
				{
				setState(386);
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
		public TerminalNode PROTOCOL() { return getToken(ObjectiveCParser.PROTOCOL, 0); }
		public ProtocolNameContext protocolName() {
			return getRuleContext(ProtocolNameContext.class,0);
		}
		public TerminalNode END() { return getToken(ObjectiveCParser.END, 0); }
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public List<ProtocolDeclarationSectionContext> protocolDeclarationSection() {
			return getRuleContexts(ProtocolDeclarationSectionContext.class);
		}
		public ProtocolDeclarationSectionContext protocolDeclarationSection(int i) {
			return getRuleContext(ProtocolDeclarationSectionContext.class,i);
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
			setState(389);
			match(PROTOCOL);
			setState(390);
			protocolName();
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(391);
				match(LT);
				setState(392);
				protocolList();
				setState(393);
				match(GT);
				}
			}

			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (OPTIONAL - 70)) | (1L << (PROPERTY - 70)) | (1L << (REQUIRED - 70)) | (1L << (ATOMIC - 70)) | (1L << (NONATOMIC - 70)) | (1L << (RETAIN - 70)) | (1L << (ATTRIBUTE - 70)) | (1L << (AUTORELEASING_QUALIFIER - 70)) | (1L << (BLOCK - 70)) | (1L << (BRIDGE - 70)) | (1L << (BRIDGE_RETAINED - 70)) | (1L << (BRIDGE_TRANSFER - 70)) | (1L << (COVARIANT - 70)) | (1L << (CONTRAVARIANT - 70)) | (1L << (DEPRECATED - 70)) | (1L << (KINDOF - 70)) | (1L << (STRONG_QUALIFIER - 70)) | (1L << (TYPEOF - 70)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 70)) | (1L << (UNUSED - 70)) | (1L << (WEAK_QUALIFIER - 70)) | (1L << (NULL_UNSPECIFIED - 70)) | (1L << (NULLABLE - 70)) | (1L << (NONNULL - 70)) | (1L << (NULL_RESETTABLE - 70)) | (1L << (NS_INLINE - 70)) | (1L << (NS_ENUM - 70)) | (1L << (NS_OPTIONS - 70)) | (1L << (ASSIGN - 70)) | (1L << (COPY - 70)) | (1L << (GETTER - 70)) | (1L << (SETTER - 70)) | (1L << (STRONG - 70)) | (1L << (READONLY - 70)) | (1L << (READWRITE - 70)) | (1L << (WEAK - 70)) | (1L << (UNSAFE_UNRETAINED - 70)) | (1L << (IB_OUTLET - 70)) | (1L << (IB_OUTLET_COLLECTION - 70)) | (1L << (IB_INSPECTABLE - 70)) | (1L << (IB_DESIGNABLE - 70)) | (1L << (IDENTIFIER - 70)))) != 0) || _la==ADD || _la==SUB) {
				{
				{
				setState(397);
				protocolDeclarationSection();
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(403);
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
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONAL:
			case REQUIRED:
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
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
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(406);
						interfaceDeclarationList();
						}
						} 
					}
					setState(411);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
				setState(413); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(412);
						interfaceDeclarationList();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(415); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
			setState(419);
			match(PROTOCOL);
			setState(420);
			protocolList();
			setState(421);
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

	public static class ClassDeclarationListContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(ObjectiveCParser.CLASS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
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
		enterRule(_localctx, 22, RULE_classDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(CLASS);
			setState(424);
			identifier();
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(425);
				match(COMMA);
				setState(426);
				identifier();
				}
				}
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(432);
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
		enterRule(_localctx, 24, RULE_protocolList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			protocolName();
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(435);
				match(COMMA);
				setState(436);
				protocolName();
				}
				}
				setState(441);
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
		enterRule(_localctx, 26, RULE_propertyDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(PROPERTY);
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(443);
				match(LP);
				setState(444);
				propertyAttributesList();
				setState(445);
				match(RP);
				}
			}

			setState(450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(449);
				ibOutletQualifier();
				}
				break;
			}
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(452);
				match(IB_INSPECTABLE);
				}
				break;
			}
			setState(455);
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
		enterRule(_localctx, 28, RULE_propertyAttributesList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			propertyAttribute();
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(458);
				match(COMMA);
				setState(459);
				propertyAttribute();
				}
				}
				setState(464);
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
		enterRule(_localctx, 30, RULE_propertyAttribute);
		try {
			setState(485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				match(ATOMIC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				match(NONATOMIC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(467);
				match(STRONG);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(468);
				match(WEAK);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(469);
				match(RETAIN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(470);
				match(ASSIGN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(471);
				match(UNSAFE_UNRETAINED);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(472);
				match(COPY);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(473);
				match(READONLY);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(474);
				match(READWRITE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(475);
				match(GETTER);
				setState(476);
				match(ASSIGNMENT);
				setState(477);
				identifier();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(478);
				match(SETTER);
				setState(479);
				match(ASSIGNMENT);
				setState(480);
				identifier();
				setState(481);
				match(COLON);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(483);
				nullabilitySpecifier();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(484);
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
		public TerminalNode LT() { return getToken(ObjectiveCParser.LT, 0); }
		public ProtocolListContext protocolList() {
			return getRuleContext(ProtocolListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ObjectiveCParser.GT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 32, RULE_protocolName);
		int _la;
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				match(LT);
				setState(488);
				protocolList();
				setState(489);
				match(GT);
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
				setState(492);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(491);
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
				setState(494);
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
		enterRule(_localctx, 34, RULE_instanceVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(LBRACE);
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (PACKAGE - 68)) | (1L << (PRIVATE - 68)) | (1L << (PROTECTED - 68)) | (1L << (PUBLIC - 68)) | (1L << (ATOMIC - 68)) | (1L << (NONATOMIC - 68)) | (1L << (RETAIN - 68)) | (1L << (AUTORELEASING_QUALIFIER - 68)) | (1L << (BLOCK - 68)) | (1L << (BRIDGE - 68)) | (1L << (BRIDGE_RETAINED - 68)) | (1L << (BRIDGE_TRANSFER - 68)) | (1L << (COVARIANT - 68)) | (1L << (CONTRAVARIANT - 68)) | (1L << (DEPRECATED - 68)) | (1L << (KINDOF - 68)) | (1L << (STRONG_QUALIFIER - 68)) | (1L << (TYPEOF - 68)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 68)) | (1L << (UNUSED - 68)) | (1L << (WEAK_QUALIFIER - 68)) | (1L << (NULL_UNSPECIFIED - 68)) | (1L << (NULLABLE - 68)) | (1L << (NONNULL - 68)) | (1L << (NULL_RESETTABLE - 68)) | (1L << (NS_INLINE - 68)) | (1L << (NS_ENUM - 68)) | (1L << (NS_OPTIONS - 68)) | (1L << (ASSIGN - 68)) | (1L << (COPY - 68)) | (1L << (GETTER - 68)) | (1L << (SETTER - 68)) | (1L << (STRONG - 68)) | (1L << (READONLY - 68)) | (1L << (READWRITE - 68)) | (1L << (WEAK - 68)) | (1L << (UNSAFE_UNRETAINED - 68)) | (1L << (IB_OUTLET - 68)) | (1L << (IB_OUTLET_COLLECTION - 68)) | (1L << (IB_INSPECTABLE - 68)) | (1L << (IB_DESIGNABLE - 68)) | (1L << (IDENTIFIER - 68)))) != 0)) {
				{
				{
				setState(498);
				visibilitySection();
				}
				}
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(504);
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
		enterRule(_localctx, 36, RULE_visibilitySection);
		try {
			int _alt;
			setState(518);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PACKAGE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(506);
				accessModifier();
				setState(510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(507);
						fieldDeclaration();
						}
						} 
					}
					setState(512);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				}
				break;
			case CHAR:
			case CONST:
			case DOUBLE:
			case ENUM:
			case FLOAT:
			case INLINE:
			case INT:
			case LONG:
			case RESTRICT:
			case SHORT:
			case SIGNED:
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
				setState(514); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(513);
						fieldDeclaration();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(516); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		enterRule(_localctx, 38, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
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
		enterRule(_localctx, 40, RULE_interfaceDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(527); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(527);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(522);
						declaration();
						}
						break;
					case 2:
						{
						setState(523);
						classMethodDeclaration();
						}
						break;
					case 3:
						{
						setState(524);
						instanceMethodDeclaration();
						}
						break;
					case 4:
						{
						setState(525);
						propertyDeclaration();
						}
						break;
					case 5:
						{
						setState(526);
						functionDeclaration();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(529); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		enterRule(_localctx, 42, RULE_classMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(ADD);
			setState(532);
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
		enterRule(_localctx, 44, RULE_instanceMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			match(SUB);
			setState(535);
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
		enterRule(_localctx, 46, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(537);
				methodType();
				}
			}

			setState(540);
			methodSelector();
			setState(545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(543);
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
					setState(541);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(542);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(548);
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
		enterRule(_localctx, 48, RULE_implementationDefinitionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(555);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(550);
					functionDefinition();
					}
					break;
				case 2:
					{
					setState(551);
					declaration();
					}
					break;
				case 3:
					{
					setState(552);
					classMethodDefinition();
					}
					break;
				case 4:
					{
					setState(553);
					instanceMethodDefinition();
					}
					break;
				case 5:
					{
					setState(554);
					propertyImplementation();
					}
					break;
				}
				}
				setState(557); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << DYNAMIC))) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (SYNTHESIZE - 78)) | (1L << (ATOMIC - 78)) | (1L << (NONATOMIC - 78)) | (1L << (RETAIN - 78)) | (1L << (ATTRIBUTE - 78)) | (1L << (AUTORELEASING_QUALIFIER - 78)) | (1L << (BLOCK - 78)) | (1L << (BRIDGE - 78)) | (1L << (BRIDGE_RETAINED - 78)) | (1L << (BRIDGE_TRANSFER - 78)) | (1L << (COVARIANT - 78)) | (1L << (CONTRAVARIANT - 78)) | (1L << (DEPRECATED - 78)) | (1L << (KINDOF - 78)) | (1L << (STRONG_QUALIFIER - 78)) | (1L << (TYPEOF - 78)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 78)) | (1L << (UNUSED - 78)) | (1L << (WEAK_QUALIFIER - 78)) | (1L << (NULL_UNSPECIFIED - 78)) | (1L << (NULLABLE - 78)) | (1L << (NONNULL - 78)) | (1L << (NULL_RESETTABLE - 78)) | (1L << (NS_INLINE - 78)) | (1L << (NS_ENUM - 78)) | (1L << (NS_OPTIONS - 78)) | (1L << (ASSIGN - 78)) | (1L << (COPY - 78)) | (1L << (GETTER - 78)) | (1L << (SETTER - 78)) | (1L << (STRONG - 78)) | (1L << (READONLY - 78)) | (1L << (READWRITE - 78)) | (1L << (WEAK - 78)) | (1L << (UNSAFE_UNRETAINED - 78)) | (1L << (IB_OUTLET - 78)) | (1L << (IB_OUTLET_COLLECTION - 78)) | (1L << (IB_INSPECTABLE - 78)) | (1L << (IB_DESIGNABLE - 78)) | (1L << (IDENTIFIER - 78)))) != 0) || _la==ADD || _la==SUB );
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
		enterRule(_localctx, 50, RULE_classMethodDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(ADD);
			setState(560);
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
		enterRule(_localctx, 52, RULE_instanceMethodDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(SUB);
			setState(563);
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
		enterRule(_localctx, 54, RULE_methodDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(565);
				methodType();
				}
			}

			setState(568);
			methodSelector();
			setState(570);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (BOOL - 40)) | (1L << (Class - 40)) | (1L << (BYCOPY - 40)) | (1L << (BYREF - 40)) | (1L << (ID - 40)) | (1L << (IMP - 40)) | (1L << (IN - 40)) | (1L << (INOUT - 40)) | (1L << (ONEWAY - 40)) | (1L << (OUT - 40)) | (1L << (PROTOCOL_ - 40)) | (1L << (SEL - 40)) | (1L << (SELF - 40)) | (1L << (SUPER - 40)) | (1L << (ATOMIC - 40)) | (1L << (NONATOMIC - 40)) | (1L << (RETAIN - 40)) | (1L << (AUTORELEASING_QUALIFIER - 40)) | (1L << (BLOCK - 40)) | (1L << (BRIDGE_RETAINED - 40)) | (1L << (BRIDGE_TRANSFER - 40)) | (1L << (COVARIANT - 40)) | (1L << (CONTRAVARIANT - 40)) | (1L << (DEPRECATED - 40)) | (1L << (KINDOF - 40)) | (1L << (UNUSED - 40)) | (1L << (NULL_UNSPECIFIED - 40)) | (1L << (NULLABLE - 40)) | (1L << (NONNULL - 40)) | (1L << (NULL_RESETTABLE - 40)) | (1L << (NS_INLINE - 40)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (NS_ENUM - 104)) | (1L << (NS_OPTIONS - 104)) | (1L << (ASSIGN - 104)) | (1L << (COPY - 104)) | (1L << (GETTER - 104)) | (1L << (SETTER - 104)) | (1L << (STRONG - 104)) | (1L << (READONLY - 104)) | (1L << (READWRITE - 104)) | (1L << (WEAK - 104)) | (1L << (UNSAFE_UNRETAINED - 104)) | (1L << (IB_OUTLET - 104)) | (1L << (IB_OUTLET_COLLECTION - 104)) | (1L << (IB_INSPECTABLE - 104)) | (1L << (IB_DESIGNABLE - 104)) | (1L << (IDENTIFIER - 104)) | (1L << (LP - 104)) | (1L << (MUL - 104)))) != 0)) {
				{
				setState(569);
				initDeclaratorList();
				}
			}

			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(572);
				match(SEMI);
				}
			}

			setState(575);
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
		enterRule(_localctx, 56, RULE_methodSelector);
		int _la;
		try {
			int _alt;
			setState(587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(577);
				selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(578);
						keywordDeclarator();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(581); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(583);
					match(COMMA);
					setState(584);
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
		public TerminalNode COLON() { return getToken(ObjectiveCParser.COLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		public ArcBehaviourSpecifierContext arcBehaviourSpecifier() {
			return getRuleContext(ArcBehaviourSpecifierContext.class,0);
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
		enterRule(_localctx, 58, RULE_keywordDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(589);
				selector();
				}
			}

			setState(592);
			match(COLON);
			setState(596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LP) {
				{
				{
				setState(593);
				methodType();
				}
				}
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(599);
				arcBehaviourSpecifier();
				}
				break;
			}
			setState(602);
			identifier();
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
		enterRule(_localctx, 60, RULE_selector);
		try {
			setState(606);
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
				setState(604);
				identifier();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(605);
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
		enterRule(_localctx, 62, RULE_methodType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			match(LP);
			setState(609);
			typeName();
			setState(610);
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
		enterRule(_localctx, 64, RULE_propertyImplementation);
		try {
			setState(620);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SYNTHESIZE:
				enterOuterAlt(_localctx, 1);
				{
				setState(612);
				match(SYNTHESIZE);
				setState(613);
				propertySynthesizeList();
				setState(614);
				match(SEMI);
				}
				break;
			case DYNAMIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(616);
				match(DYNAMIC);
				setState(617);
				propertySynthesizeList();
				setState(618);
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
		enterRule(_localctx, 66, RULE_propertySynthesizeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			propertySynthesizeItem();
			setState(627);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(623);
				match(COMMA);
				setState(624);
				propertySynthesizeItem();
				}
				}
				setState(629);
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
		enterRule(_localctx, 68, RULE_propertySynthesizeItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			identifier();
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(631);
				match(ASSIGNMENT);
				setState(632);
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
		enterRule(_localctx, 70, RULE_blockType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(635);
				nullabilitySpecifier();
				}
				break;
			}
			setState(638);
			typeSpecifier();
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (NULL_UNSPECIFIED - 99)) | (1L << (NULLABLE - 99)) | (1L << (NONNULL - 99)) | (1L << (NULL_RESETTABLE - 99)))) != 0)) {
				{
				setState(639);
				nullabilitySpecifier();
				}
			}

			setState(642);
			match(LP);
			setState(643);
			match(BITXOR);
			setState(646);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(644);
				nullabilitySpecifier();
				}
				break;
			case 2:
				{
				setState(645);
				typeSpecifier();
				}
				break;
			}
			setState(648);
			match(RP);
			setState(650);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(649);
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
		enterRule(_localctx, 72, RULE_genericsSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			match(LT);
			setState(661);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(653);
				typeSpecifierWithPrefixes();
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(654);
					match(COMMA);
					setState(655);
					typeSpecifierWithPrefixes();
					}
					}
					setState(660);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(663);
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
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
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
		enterRule(_localctx, 74, RULE_typeSpecifierWithPrefixes);
		try {
			int _alt;
			setState(673);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(668);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(665);
						typePrefix();
						}
						} 
					}
					setState(670);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				}
				setState(671);
				typeSpecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
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
		enterRule(_localctx, 76, RULE_dictionaryExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(AT);
			setState(676);
			match(LBRACE);
			setState(688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(677);
				dictionaryPair();
				setState(682);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(678);
						match(COMMA);
						setState(679);
						dictionaryPair();
						}
						} 
					}
					setState(684);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				}
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(685);
					match(COMMA);
					}
				}

				}
			}

			setState(690);
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
		enterRule(_localctx, 78, RULE_dictionaryPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692);
			castExpression();
			setState(693);
			match(COLON);
			setState(694);
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
		enterRule(_localctx, 80, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			match(AT);
			setState(697);
			match(LBRACK);
			setState(702);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(698);
				expressions();
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(699);
					match(COMMA);
					}
				}

				}
			}

			setState(704);
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
		enterRule(_localctx, 82, RULE_boxExpression);
		try {
			setState(716);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(706);
				match(AT);
				setState(707);
				match(LP);
				setState(708);
				expression(0);
				setState(709);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(711);
				match(AT);
				setState(714);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
				case NIL:
				case NO:
				case NULL_:
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
					setState(712);
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
					setState(713);
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
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<TypeVariableDeclaratorOrNameContext> typeVariableDeclaratorOrName() {
			return getRuleContexts(TypeVariableDeclaratorOrNameContext.class);
		}
		public TypeVariableDeclaratorOrNameContext typeVariableDeclaratorOrName(int i) {
			return getRuleContext(TypeVariableDeclaratorOrNameContext.class,i);
		}
		public TerminalNode VOID() { return getToken(ObjectiveCParser.VOID, 0); }
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
		enterRule(_localctx, 84, RULE_blockParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			match(LP);
			setState(730);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(721);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(719);
					typeVariableDeclaratorOrName();
					}
					break;
				case 2:
					{
					setState(720);
					match(VOID);
					}
					break;
				}
				setState(727);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(723);
					match(COMMA);
					setState(724);
					typeVariableDeclaratorOrName();
					}
					}
					setState(729);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(732);
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
		enterRule(_localctx, 86, RULE_typeVariableDeclaratorOrName);
		try {
			setState(736);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(734);
				typeVariableDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(735);
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
		enterRule(_localctx, 88, RULE_blockExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			match(BITXOR);
			setState(740);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(739);
				typeSpecifier();
				}
				break;
			}
			setState(743);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (NULL_UNSPECIFIED - 99)) | (1L << (NULLABLE - 99)) | (1L << (NONNULL - 99)) | (1L << (NULL_RESETTABLE - 99)))) != 0)) {
				{
				setState(742);
				nullabilitySpecifier();
				}
			}

			setState(746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(745);
				blockParameters();
				}
			}

			setState(748);
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
		enterRule(_localctx, 90, RULE_messageExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			match(LBRACK);
			setState(751);
			receiver();
			setState(752);
			messageSelector();
			setState(753);
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
		enterRule(_localctx, 92, RULE_receiver);
		try {
			setState(757);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(755);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(756);
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
		enterRule(_localctx, 94, RULE_messageSelector);
		int _la;
		try {
			setState(765);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(759);
				selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(761); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(760);
					keywordArgument();
					}
					}
					setState(763); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (COLON - 81)))) != 0) );
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
		enterRule(_localctx, 96, RULE_keywordArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(767);
				selector();
				}
			}

			setState(770);
			match(COLON);
			setState(771);
			keywordArgumentType();
			setState(776);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(772);
				match(COMMA);
				setState(773);
				keywordArgumentType();
				}
				}
				setState(778);
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
		enterRule(_localctx, 98, RULE_keywordArgumentType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			expressions();
			setState(781);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				{
				setState(780);
				nullabilitySpecifier();
				}
				break;
			}
			setState(787);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(783);
				match(LBRACE);
				setState(784);
				initializerList();
				setState(785);
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
		enterRule(_localctx, 100, RULE_selectorExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(789);
			match(SELECTOR);
			setState(790);
			match(LP);
			setState(791);
			selectorName();
			setState(792);
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
		enterRule(_localctx, 102, RULE_selectorName);
		int _la;
		try {
			setState(803);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(794);
				selector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(799); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(796);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
						{
						setState(795);
						selector();
						}
					}

					setState(798);
					match(COLON);
					}
					}
					setState(801); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)) | (1L << (COLON - 81)))) != 0) );
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
		enterRule(_localctx, 104, RULE_protocolExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			match(PROTOCOL);
			setState(806);
			match(LP);
			setState(807);
			protocolName();
			setState(808);
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
		enterRule(_localctx, 106, RULE_encodeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810);
			match(ENCODE);
			setState(811);
			match(LP);
			setState(812);
			typeName();
			setState(813);
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
		enterRule(_localctx, 108, RULE_typeVariableDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			declarationSpecifiers();
			setState(816);
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
		enterRule(_localctx, 110, RULE_throwStatement);
		try {
			setState(825);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(818);
				match(THROW);
				setState(819);
				match(LP);
				setState(820);
				identifier();
				setState(821);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(823);
				match(THROW);
				setState(824);
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
		enterRule(_localctx, 112, RULE_tryBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			match(TRY);
			setState(828);
			((TryBlockContext)_localctx).tryStatement = compoundStatement();
			setState(832);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(829);
				catchStatement();
				}
				}
				setState(834);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(835);
				match(FINALLY);
				setState(836);
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
		enterRule(_localctx, 114, RULE_catchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(839);
			match(CATCH);
			setState(840);
			match(LP);
			setState(841);
			typeVariableDeclarator();
			setState(842);
			match(RP);
			setState(843);
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
		enterRule(_localctx, 116, RULE_synchronizedStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			match(SYNCHRONIZED);
			setState(846);
			match(LP);
			setState(847);
			expression(0);
			setState(848);
			match(RP);
			setState(849);
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
		enterRule(_localctx, 118, RULE_autoreleaseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851);
			match(AUTORELEASEPOOL);
			setState(852);
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
		enterRule(_localctx, 120, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			functionSignature();
			setState(855);
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
		enterRule(_localctx, 122, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(857);
			functionSignature();
			setState(858);
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
		enterRule(_localctx, 124, RULE_functionSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(860);
				declarationSpecifiers();
				}
				break;
			}
			setState(863);
			identifier();
			{
			setState(864);
			match(LP);
			setState(866);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(865);
				parameterList();
				}
			}

			setState(868);
			match(RP);
			}
			setState(871);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(870);
				attributeSpecifier();
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
		enterRule(_localctx, 126, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			attributeName();
			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(874);
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
		enterRule(_localctx, 128, RULE_attributeName);
		try {
			setState(879);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(877);
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
				setState(878);
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
		enterRule(_localctx, 130, RULE_attributeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			match(LP);
			setState(883);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (ADD - 152)) | (1L << (SUB - 152)) | (1L << (CHARACTER_LITERAL - 152)) | (1L << (STRING_START - 152)) | (1L << (HEX_LITERAL - 152)) | (1L << (OCTAL_LITERAL - 152)) | (1L << (BINARY_LITERAL - 152)) | (1L << (DECIMAL_LITERAL - 152)) | (1L << (FLOATING_POINT_LITERAL - 152)))) != 0)) {
				{
				setState(882);
				attributeParameterList();
				}
			}

			setState(885);
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
		enterRule(_localctx, 132, RULE_attributeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			attributeParameter();
			setState(892);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(888);
				match(COMMA);
				setState(889);
				attributeParameter();
				}
				}
				setState(894);
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
		enterRule(_localctx, 134, RULE_attributeParameter);
		try {
			setState(899);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(895);
				attribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(896);
				constant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(897);
				stringLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(898);
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
		enterRule(_localctx, 136, RULE_attributeParameterAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			attributeName();
			setState(902);
			match(ASSIGNMENT);
			setState(906);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NIL:
			case NO:
			case NULL_:
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
				setState(903);
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
				setState(904);
				attributeName();
				}
				break;
			case STRING_START:
				{
				setState(905);
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
		enterRule(_localctx, 138, RULE_declaration);
		try {
			setState(912);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(908);
				functionCallExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(909);
				enumDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(910);
				varDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(911);
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
		enterRule(_localctx, 140, RULE_functionCallExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(914);
				attributeSpecifier();
				}
			}

			setState(917);
			identifier();
			setState(919);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(918);
				attributeSpecifier();
				}
			}

			setState(921);
			match(LP);
			setState(922);
			directDeclarator();
			setState(923);
			match(RP);
			setState(924);
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
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ObjectiveCParser.SEMI, 0); }
		public AttributeSpecifierContext attributeSpecifier() {
			return getRuleContext(AttributeSpecifierContext.class,0);
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
		enterRule(_localctx, 142, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(927);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(926);
				attributeSpecifier();
				}
			}

			setState(930);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(929);
				match(TYPEDEF);
				}
			}

			setState(932);
			enumSpecifier();
			setState(934);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(933);
				identifier();
				}
			}

			setState(936);
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
		enterRule(_localctx, 144, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(942);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(938);
				declarationSpecifiers();
				setState(939);
				initDeclaratorList();
				}
				break;
			case 2:
				{
				setState(941);
				declarationSpecifiers();
				}
				break;
			}
			setState(944);
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
		public AttributeSpecifierContext attributeSpecifier() {
			return getRuleContext(AttributeSpecifierContext.class,0);
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
		enterRule(_localctx, 146, RULE_typedefDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTRIBUTE) {
				{
				setState(946);
				attributeSpecifier();
				}
			}

			setState(949);
			match(TYPEDEF);
			setState(954);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				{
				setState(950);
				declarationSpecifiers();
				setState(951);
				typeDeclaratorList();
				}
				break;
			case 2:
				{
				setState(953);
				declarationSpecifiers();
				}
				break;
			}
			setState(956);
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
		enterRule(_localctx, 148, RULE_typeDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(958);
			typeDeclarator();
			setState(963);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(959);
				match(COMMA);
				setState(960);
				typeDeclarator();
				}
				}
				setState(965);
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
		enterRule(_localctx, 150, RULE_typeDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(967);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUL) {
				{
				setState(966);
				pointer();
				}
			}

			setState(969);
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
		enterRule(_localctx, 152, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(979); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(979);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
					case 1:
						{
						setState(971);
						storageClassSpecifier();
						}
						break;
					case 2:
						{
						setState(972);
						attributeSpecifier();
						}
						break;
					case 3:
						{
						setState(973);
						arcBehaviourSpecifier();
						}
						break;
					case 4:
						{
						setState(974);
						nullabilitySpecifier();
						}
						break;
					case 5:
						{
						setState(975);
						ibOutletQualifier();
						}
						break;
					case 6:
						{
						setState(976);
						typePrefix();
						}
						break;
					case 7:
						{
						setState(977);
						typeQualifier();
						}
						break;
					case 8:
						{
						setState(978);
						typeSpecifier();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(981); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
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
		enterRule(_localctx, 154, RULE_attributeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			match(ATTRIBUTE);
			setState(984);
			match(LP);
			setState(985);
			match(LP);
			setState(986);
			attribute();
			setState(991);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(987);
				match(COMMA);
				setState(988);
				attribute();
				}
				}
				setState(993);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(994);
			match(RP);
			setState(995);
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
		enterRule(_localctx, 156, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			initDeclarator();
			setState(1002);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(998);
				match(COMMA);
				setState(999);
				initDeclarator();
				}
				}
				setState(1004);
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
		enterRule(_localctx, 158, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1005);
			declarator();
			setState(1008);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(1006);
				match(ASSIGNMENT);
				setState(1007);
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
		enterRule(_localctx, 160, RULE_structOrUnionSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1010);
			_la = _input.LA(1);
			if ( !(_la==STRUCT || _la==UNION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1023);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				{
				setState(1011);
				identifier();
				}
				break;
			case 2:
				{
				setState(1013);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(1012);
					identifier();
					}
				}

				setState(1015);
				match(LBRACE);
				setState(1017); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1016);
					fieldDeclaration();
					}
					}
					setState(1019); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) );
				setState(1021);
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
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public FieldDeclaratorListContext fieldDeclaratorList() {
			return getRuleContext(FieldDeclaratorListContext.class,0);
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
		enterRule(_localctx, 162, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1025);
			specifierQualifierList();
			setState(1026);
			fieldDeclaratorList();
			setState(1031);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(1029);
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
					setState(1027);
					macro();
					}
					break;
				case ATTRIBUTE:
					{
					setState(1028);
					attributeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1034);
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
		enterRule(_localctx, 164, RULE_specifierQualifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1042); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1042);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
					case 1:
						{
						setState(1036);
						arcBehaviourSpecifier();
						}
						break;
					case 2:
						{
						setState(1037);
						nullabilitySpecifier();
						}
						break;
					case 3:
						{
						setState(1038);
						ibOutletQualifier();
						}
						break;
					case 4:
						{
						setState(1039);
						typePrefix();
						}
						break;
					case 5:
						{
						setState(1040);
						typeQualifier();
						}
						break;
					case 6:
						{
						setState(1041);
						typeSpecifier();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1044); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
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
		enterRule(_localctx, 166, RULE_ibOutletQualifier);
		try {
			setState(1052);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IB_OUTLET_COLLECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(1046);
				match(IB_OUTLET_COLLECTION);
				setState(1047);
				match(LP);
				setState(1048);
				identifier();
				setState(1049);
				match(RP);
				}
				break;
			case IB_OUTLET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1051);
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
		enterRule(_localctx, 168, RULE_arcBehaviourSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054);
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
		enterRule(_localctx, 170, RULE_nullabilitySpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056);
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
		enterRule(_localctx, 172, RULE_storageClassSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1058);
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
		enterRule(_localctx, 174, RULE_typePrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060);
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
		enterRule(_localctx, 176, RULE_typeQualifier);
		try {
			setState(1066);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(1062);
				match(CONST);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1063);
				match(VOLATILE);
				}
				break;
			case RESTRICT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1064);
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
				setState(1065);
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
		enterRule(_localctx, 178, RULE_protocolQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1068);
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
		public TerminalNode VOID() { return getToken(ObjectiveCParser.VOID, 0); }
		public TerminalNode CHAR() { return getToken(ObjectiveCParser.CHAR, 0); }
		public TerminalNode SHORT() { return getToken(ObjectiveCParser.SHORT, 0); }
		public TerminalNode INT() { return getToken(ObjectiveCParser.INT, 0); }
		public TerminalNode LONG() { return getToken(ObjectiveCParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(ObjectiveCParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(ObjectiveCParser.DOUBLE, 0); }
		public TerminalNode SIGNED() { return getToken(ObjectiveCParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(ObjectiveCParser.UNSIGNED, 0); }
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
		enterRule(_localctx, 180, RULE_typeSpecifier);
		try {
			setState(1087);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1070);
				match(VOID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1071);
				match(CHAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1072);
				match(SHORT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1073);
				match(INT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1074);
				match(LONG);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1075);
				match(FLOAT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1076);
				match(DOUBLE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1077);
				match(SIGNED);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1078);
				match(UNSIGNED);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1079);
				typeofExpression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1080);
				genericTypeSpecifier();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1081);
				structOrUnionSpecifier();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1082);
				enumSpecifier();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1083);
				identifier();
				setState(1085);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
				case 1:
					{
					setState(1084);
					pointer();
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
		enterRule(_localctx, 182, RULE_typeofExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			match(TYPEOF);
			{
			setState(1090);
			match(LP);
			setState(1091);
			expression(0);
			setState(1092);
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
		enterRule(_localctx, 184, RULE_fieldDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1094);
			fieldDeclarator();
			setState(1099);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1095);
				match(COMMA);
				setState(1096);
				fieldDeclarator();
				}
				}
				setState(1101);
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
		enterRule(_localctx, 186, RULE_fieldDeclarator);
		int _la;
		try {
			setState(1108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1102);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (BOOL - 40)) | (1L << (Class - 40)) | (1L << (BYCOPY - 40)) | (1L << (BYREF - 40)) | (1L << (ID - 40)) | (1L << (IMP - 40)) | (1L << (IN - 40)) | (1L << (INOUT - 40)) | (1L << (ONEWAY - 40)) | (1L << (OUT - 40)) | (1L << (PROTOCOL_ - 40)) | (1L << (SEL - 40)) | (1L << (SELF - 40)) | (1L << (SUPER - 40)) | (1L << (ATOMIC - 40)) | (1L << (NONATOMIC - 40)) | (1L << (RETAIN - 40)) | (1L << (AUTORELEASING_QUALIFIER - 40)) | (1L << (BLOCK - 40)) | (1L << (BRIDGE_RETAINED - 40)) | (1L << (BRIDGE_TRANSFER - 40)) | (1L << (COVARIANT - 40)) | (1L << (CONTRAVARIANT - 40)) | (1L << (DEPRECATED - 40)) | (1L << (KINDOF - 40)) | (1L << (UNUSED - 40)) | (1L << (NULL_UNSPECIFIED - 40)) | (1L << (NULLABLE - 40)) | (1L << (NONNULL - 40)) | (1L << (NULL_RESETTABLE - 40)) | (1L << (NS_INLINE - 40)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (NS_ENUM - 104)) | (1L << (NS_OPTIONS - 104)) | (1L << (ASSIGN - 104)) | (1L << (COPY - 104)) | (1L << (GETTER - 104)) | (1L << (SETTER - 104)) | (1L << (STRONG - 104)) | (1L << (READONLY - 104)) | (1L << (READWRITE - 104)) | (1L << (WEAK - 104)) | (1L << (UNSAFE_UNRETAINED - 104)) | (1L << (IB_OUTLET - 104)) | (1L << (IB_OUTLET_COLLECTION - 104)) | (1L << (IB_INSPECTABLE - 104)) | (1L << (IB_DESIGNABLE - 104)) | (1L << (IDENTIFIER - 104)) | (1L << (LP - 104)) | (1L << (MUL - 104)))) != 0)) {
					{
					setState(1103);
					declarator();
					}
				}

				setState(1106);
				match(COLON);
				setState(1107);
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
		public TerminalNode COMMA() { return getToken(ObjectiveCParser.COMMA, 0); }
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public TerminalNode NS_OPTIONS() { return getToken(ObjectiveCParser.NS_OPTIONS, 0); }
		public TerminalNode NS_ENUM() { return getToken(ObjectiveCParser.NS_ENUM, 0); }
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
		enterRule(_localctx, 188, RULE_enumSpecifier);
		int _la;
		try {
			setState(1141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(1110);
				match(ENUM);
				setState(1116);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
				case 1:
					{
					setState(1112);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
						{
						setState(1111);
						identifier();
						}
					}

					setState(1114);
					match(COLON);
					setState(1115);
					typeName();
					}
					break;
				}
				setState(1129);
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
					setState(1118);
					identifier();
					setState(1123);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
					case 1:
						{
						setState(1119);
						match(LBRACE);
						setState(1120);
						enumeratorList();
						setState(1121);
						match(RBRACE);
						}
						break;
					}
					}
					break;
				case LBRACE:
					{
					setState(1125);
					match(LBRACE);
					setState(1126);
					enumeratorList();
					setState(1127);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(1131);
				_la = _input.LA(1);
				if ( !(_la==NS_ENUM || _la==NS_OPTIONS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1132);
				match(LP);
				setState(1133);
				typeName();
				setState(1134);
				match(COMMA);
				setState(1135);
				identifier();
				setState(1136);
				match(RP);
				setState(1137);
				match(LBRACE);
				setState(1138);
				enumeratorList();
				setState(1139);
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
		enterRule(_localctx, 190, RULE_enumeratorList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1143);
			enumerator();
			setState(1148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1144);
					match(COMMA);
					setState(1145);
					enumerator();
					}
					} 
				}
				setState(1150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			}
			setState(1152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1151);
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
		public EnumeratorIdentifierContext enumeratorIdentifier() {
			return getRuleContext(EnumeratorIdentifierContext.class,0);
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
		enterRule(_localctx, 192, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1154);
			enumeratorIdentifier();
			setState(1157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(1155);
				match(ASSIGNMENT);
				setState(1156);
				expression(0);
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
		enterRule(_localctx, 194, RULE_enumeratorIdentifier);
		try {
			setState(1161);
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
				setState(1159);
				identifier();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1160);
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
		enterRule(_localctx, 196, RULE_directDeclarator);
		int _la;
		try {
			setState(1186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1168);
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
					setState(1163);
					identifier();
					}
					break;
				case LP:
					{
					setState(1164);
					match(LP);
					setState(1165);
					declarator();
					setState(1166);
					match(RP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1170);
					declaratorSuffix();
					}
					}
					setState(1175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1176);
				match(LP);
				setState(1177);
				match(BITXOR);
				setState(1179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
				case 1:
					{
					setState(1178);
					nullabilitySpecifier();
					}
					break;
				}
				setState(1182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(1181);
					identifier();
					}
				}

				setState(1184);
				match(RP);
				setState(1185);
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
		enterRule(_localctx, 198, RULE_declaratorSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1188);
			match(LBRACK);
			setState(1190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (ADD - 152)) | (1L << (SUB - 152)) | (1L << (CHARACTER_LITERAL - 152)) | (1L << (HEX_LITERAL - 152)) | (1L << (OCTAL_LITERAL - 152)) | (1L << (BINARY_LITERAL - 152)) | (1L << (DECIMAL_LITERAL - 152)) | (1L << (FLOATING_POINT_LITERAL - 152)))) != 0)) {
				{
				setState(1189);
				constantExpression();
				}
			}

			setState(1192);
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
		enterRule(_localctx, 200, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1194);
			parameterDeclarationList();
			setState(1197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1195);
				match(COMMA);
				setState(1196);
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
		public TerminalNode MUL() { return getToken(ObjectiveCParser.MUL, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
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
		enterRule(_localctx, 202, RULE_pointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1199);
			match(MUL);
			setState(1201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				{
				setState(1200);
				declarationSpecifiers();
				}
				break;
			}
			setState(1204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
			case 1:
				{
				setState(1203);
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

	public static class MacroContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LP() { return getToken(ObjectiveCParser.LP, 0); }
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public TerminalNode RP() { return getToken(ObjectiveCParser.RP, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ObjectiveCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ObjectiveCParser.COMMA, i);
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
		enterRule(_localctx, 204, RULE_macro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1206);
			identifier();
			setState(1218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(1207);
				match(LP);
				setState(1208);
				primaryExpression();
				setState(1213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1209);
					match(COMMA);
					setState(1210);
					primaryExpression();
					}
					}
					setState(1215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1216);
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
		enterRule(_localctx, 206, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1220);
			match(LBRACE);
			setState(1225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1221);
				expressions();
				setState(1223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1222);
					match(COMMA);
					}
				}

				}
			}

			setState(1227);
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
		enterRule(_localctx, 208, RULE_structInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1229);
			match(LBRACE);
			setState(1243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(1230);
				match(DOT);
				setState(1231);
				expression(0);
				setState(1237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1232);
						match(COMMA);
						setState(1233);
						match(DOT);
						setState(1234);
						expression(0);
						}
						} 
					}
					setState(1239);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
				}
				setState(1241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1240);
					match(COMMA);
					}
				}

				}
			}

			setState(1245);
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
		enterRule(_localctx, 210, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1247);
			initializer();
			setState(1252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1248);
					match(COMMA);
					setState(1249);
					initializer();
					}
					} 
				}
				setState(1254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
			}
			setState(1256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1255);
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
		enterRule(_localctx, 212, RULE_typeName);
		int _la;
		try {
			setState(1263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1258);
				specifierQualifierList();
				setState(1260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 126)) & ~0x3f) == 0 && ((1L << (_la - 126)) & ((1L << (LP - 126)) | (1L << (LBRACK - 126)) | (1L << (MUL - 126)))) != 0)) {
					{
					setState(1259);
					abstractDeclarator();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1262);
				blockType();
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
		enterRule(_localctx, 214, RULE_abstractDeclarator);
		int _la;
		try {
			setState(1288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1265);
				pointer();
				setState(1267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 126)) & ~0x3f) == 0 && ((1L << (_la - 126)) & ((1L << (LP - 126)) | (1L << (LBRACK - 126)) | (1L << (MUL - 126)))) != 0)) {
					{
					setState(1266);
					abstractDeclarator();
					}
				}

				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1269);
				match(LP);
				setState(1271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 126)) & ~0x3f) == 0 && ((1L << (_la - 126)) & ((1L << (LP - 126)) | (1L << (LBRACK - 126)) | (1L << (MUL - 126)))) != 0)) {
					{
					setState(1270);
					abstractDeclarator();
					}
				}

				setState(1273);
				match(RP);
				setState(1275); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1274);
					abstractDeclaratorSuffix();
					}
					}
					setState(1277); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LP || _la==LBRACK );
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(1284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1279);
					match(LBRACK);
					setState(1281);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (ADD - 152)) | (1L << (SUB - 152)) | (1L << (CHARACTER_LITERAL - 152)) | (1L << (HEX_LITERAL - 152)) | (1L << (OCTAL_LITERAL - 152)) | (1L << (BINARY_LITERAL - 152)) | (1L << (DECIMAL_LITERAL - 152)) | (1L << (FLOATING_POINT_LITERAL - 152)))) != 0)) {
						{
						setState(1280);
						constantExpression();
						}
					}

					setState(1283);
					match(RBRACK);
					}
					}
					setState(1286); 
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
		enterRule(_localctx, 216, RULE_abstractDeclaratorSuffix);
		int _la;
		try {
			setState(1300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(1290);
				match(LBRACK);
				setState(1292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (UNUSED - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0) || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (ADD - 152)) | (1L << (SUB - 152)) | (1L << (CHARACTER_LITERAL - 152)) | (1L << (HEX_LITERAL - 152)) | (1L << (OCTAL_LITERAL - 152)) | (1L << (BINARY_LITERAL - 152)) | (1L << (DECIMAL_LITERAL - 152)) | (1L << (FLOATING_POINT_LITERAL - 152)))) != 0)) {
					{
					setState(1291);
					constantExpression();
					}
				}

				setState(1294);
				match(RBRACK);
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1295);
				match(LP);
				setState(1297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ATOMIC - 81)) | (1L << (NONATOMIC - 81)) | (1L << (RETAIN - 81)) | (1L << (ATTRIBUTE - 81)) | (1L << (AUTORELEASING_QUALIFIER - 81)) | (1L << (BLOCK - 81)) | (1L << (BRIDGE - 81)) | (1L << (BRIDGE_RETAINED - 81)) | (1L << (BRIDGE_TRANSFER - 81)) | (1L << (COVARIANT - 81)) | (1L << (CONTRAVARIANT - 81)) | (1L << (DEPRECATED - 81)) | (1L << (KINDOF - 81)) | (1L << (STRONG_QUALIFIER - 81)) | (1L << (TYPEOF - 81)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 81)) | (1L << (UNUSED - 81)) | (1L << (WEAK_QUALIFIER - 81)) | (1L << (NULL_UNSPECIFIED - 81)) | (1L << (NULLABLE - 81)) | (1L << (NONNULL - 81)) | (1L << (NULL_RESETTABLE - 81)) | (1L << (NS_INLINE - 81)) | (1L << (NS_ENUM - 81)) | (1L << (NS_OPTIONS - 81)) | (1L << (ASSIGN - 81)) | (1L << (COPY - 81)) | (1L << (GETTER - 81)) | (1L << (SETTER - 81)) | (1L << (STRONG - 81)) | (1L << (READONLY - 81)) | (1L << (READWRITE - 81)) | (1L << (WEAK - 81)) | (1L << (UNSAFE_UNRETAINED - 81)) | (1L << (IB_OUTLET - 81)) | (1L << (IB_OUTLET_COLLECTION - 81)) | (1L << (IB_INSPECTABLE - 81)) | (1L << (IB_DESIGNABLE - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(1296);
					parameterDeclarationList();
					}
				}

				setState(1299);
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
		enterRule(_localctx, 218, RULE_parameterDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1302);
			parameterDeclaration();
			setState(1307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1303);
					match(COMMA);
					setState(1304);
					parameterDeclaration();
					}
					} 
				}
				setState(1309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
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
		enterRule(_localctx, 220, RULE_parameterDeclaration);
		try {
			setState(1314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1310);
				declarationSpecifiers();
				setState(1311);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1313);
				match(VOID);
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
		enterRule(_localctx, 222, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUL) {
				{
				setState(1316);
				pointer();
				}
			}

			setState(1319);
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
		enterRule(_localctx, 224, RULE_statement);
		try {
			setState(1362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1321);
				labeledStatement();
				setState(1323);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
				case 1:
					{
					setState(1322);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1325);
				compoundStatement();
				setState(1327);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1326);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1329);
				selectionStatement();
				setState(1331);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
				case 1:
					{
					setState(1330);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1333);
				iterationStatement();
				setState(1335);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
				case 1:
					{
					setState(1334);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1337);
				jumpStatement();
				setState(1339);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
				case 1:
					{
					setState(1338);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1341);
				synchronizedStatement();
				setState(1343);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
				case 1:
					{
					setState(1342);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1345);
				autoreleaseStatement();
				setState(1347);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
				case 1:
					{
					setState(1346);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1349);
				throwStatement();
				setState(1351);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
				case 1:
					{
					setState(1350);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1353);
				tryBlock();
				setState(1355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
				case 1:
					{
					setState(1354);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1357);
				expressions();
				setState(1359);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
				case 1:
					{
					setState(1358);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1361);
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
		enterRule(_localctx, 226, RULE_labeledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1364);
			identifier();
			setState(1365);
			match(COLON);
			setState(1366);
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
		enterRule(_localctx, 228, RULE_rangeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1368);
			constantExpression();
			setState(1371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELIPSIS) {
				{
				setState(1369);
				match(ELIPSIS);
				setState(1370);
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
		enterRule(_localctx, 230, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1373);
			match(LBRACE);
			setState(1378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BREAK) | (1L << CHAR) | (1L << CONST) | (1L << CONTINUE) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << RETURN) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << SWITCH) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (SYNCHRONIZED - 69)) | (1L << (THROW - 69)) | (1L << (TRY - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (ATTRIBUTE - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (STRONG_QUALIFIER - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 69)) | (1L << (UNUSED - 69)) | (1L << (WEAK_QUALIFIER - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACE - 69)) | (1L << (LBRACK - 69)) | (1L << (SEMI - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1376);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
				case 1:
					{
					setState(1374);
					declaration();
					}
					break;
				case 2:
					{
					setState(1375);
					statement();
					}
					break;
				}
				}
				setState(1380);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1381);
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
		enterRule(_localctx, 232, RULE_selectionStatement);
		try {
			setState(1393);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1383);
				match(IF);
				setState(1384);
				match(LP);
				setState(1385);
				expression(0);
				setState(1386);
				match(RP);
				setState(1387);
				((SelectionStatementContext)_localctx).ifBody = statement();
				setState(1390);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
				case 1:
					{
					setState(1388);
					match(ELSE);
					setState(1389);
					((SelectionStatementContext)_localctx).elseBody = statement();
					}
					break;
				}
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 2);
				{
				setState(1392);
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
		enterRule(_localctx, 234, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1395);
			match(SWITCH);
			setState(1396);
			match(LP);
			setState(1397);
			expression(0);
			setState(1398);
			match(RP);
			setState(1399);
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
		enterRule(_localctx, 236, RULE_switchBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1401);
			match(LBRACE);
			setState(1405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1402);
				switchSection();
				}
				}
				setState(1407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1408);
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
		enterRule(_localctx, 238, RULE_switchSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1411); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1410);
				switchLabel();
				}
				}
				setState(1413); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(1416); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1415);
				statement();
				}
				}
				setState(1418); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << RETURN) | (1L << SIZEOF) | (1L << SWITCH) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (SYNCHRONIZED - 69)) | (1L << (THROW - 69)) | (1L << (TRY - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACE - 69)) | (1L << (LBRACK - 69)) | (1L << (SEMI - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0) );
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
		enterRule(_localctx, 240, RULE_switchLabel);
		try {
			setState(1432);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1420);
				match(CASE);
				setState(1426);
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
				case NULL_:
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
					setState(1421);
					rangeExpression();
					}
					break;
				case LP:
					{
					setState(1422);
					match(LP);
					setState(1423);
					rangeExpression();
					setState(1424);
					match(RP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1428);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1430);
				match(DEFAULT);
				setState(1431);
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
		enterRule(_localctx, 242, RULE_iterationStatement);
		try {
			setState(1438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1434);
				whileStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1435);
				doStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1436);
				forStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1437);
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
		enterRule(_localctx, 244, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1440);
			match(WHILE);
			setState(1441);
			match(LP);
			setState(1442);
			expression(0);
			setState(1443);
			match(RP);
			setState(1444);
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
		enterRule(_localctx, 246, RULE_doStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1446);
			match(DO);
			setState(1447);
			statement();
			setState(1448);
			match(WHILE);
			setState(1449);
			match(LP);
			setState(1450);
			expression(0);
			setState(1451);
			match(RP);
			setState(1452);
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
		enterRule(_localctx, 248, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1454);
			match(FOR);
			setState(1455);
			match(LP);
			setState(1457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (ATTRIBUTE - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (STRONG_QUALIFIER - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 69)) | (1L << (UNUSED - 69)) | (1L << (WEAK_QUALIFIER - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1456);
				forLoopInitializer();
				}
			}

			setState(1459);
			match(SEMI);
			setState(1461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1460);
				expression(0);
				}
			}

			setState(1463);
			match(SEMI);
			setState(1465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1464);
				expressions();
				}
			}

			setState(1467);
			match(RP);
			setState(1468);
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
		enterRule(_localctx, 250, RULE_forLoopInitializer);
		try {
			setState(1474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1470);
				declarationSpecifiers();
				setState(1471);
				initDeclaratorList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1473);
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
		enterRule(_localctx, 252, RULE_forInStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1476);
			match(FOR);
			setState(1477);
			match(LP);
			setState(1478);
			typeVariableDeclarator();
			setState(1479);
			match(IN);
			setState(1481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
				{
				setState(1480);
				expression(0);
				}
			}

			setState(1483);
			match(RP);
			setState(1484);
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
		enterRule(_localctx, 254, RULE_jumpStatement);
		try {
			setState(1494);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GOTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(1486);
				match(GOTO);
				setState(1487);
				identifier();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1488);
				match(CONTINUE);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 3);
				{
				setState(1489);
				match(BREAK);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(1490);
				match(RETURN);
				setState(1492);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1491);
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
		enterRule(_localctx, 256, RULE_expressions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1496);
			expression(0);
			setState(1501);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1497);
					match(COMMA);
					setState(1498);
					expression(0);
					}
					} 
				}
				setState(1503);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
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
		int _startState = 258;
		enterRecursionRule(_localctx, 258, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				{
				setState(1505);
				castExpression();
				}
				break;
			case 2:
				{
				setState(1506);
				match(LP);
				setState(1507);
				compoundStatement();
				setState(1508);
				match(RP);
				}
				break;
			case 3:
				{
				setState(1510);
				unaryExpression();
				setState(1511);
				assignmentOperator();
				setState(1512);
				((ExpressionContext)_localctx).assignmentExpression = expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1560);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1558);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1516);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1517);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 154)) & ~0x3f) == 0 && ((1L << (_la - 154)) & ((1L << (MUL - 154)) | (1L << (DIV - 154)) | (1L << (MOD - 154)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1518);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1519);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1520);
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
						setState(1521);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1522);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1527);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LT:
							{
							setState(1523);
							match(LT);
							setState(1524);
							match(LT);
							}
							break;
						case GT:
							{
							setState(1525);
							match(GT);
							setState(1526);
							match(GT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1529);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1530);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1531);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (GT - 138)) | (1L << (LT - 138)) | (1L << (LE - 138)) | (1L << (GE - 138)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1532);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1533);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1534);
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
						setState(1535);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1536);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1537);
						((ExpressionContext)_localctx).op = match(BITAND);
						setState(1538);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1539);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1540);
						((ExpressionContext)_localctx).op = match(BITXOR);
						setState(1541);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1542);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1543);
						((ExpressionContext)_localctx).op = match(BITOR);
						setState(1544);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1545);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1546);
						((ExpressionContext)_localctx).op = match(AND);
						setState(1547);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1548);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1549);
						((ExpressionContext)_localctx).op = match(OR);
						setState(1550);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1551);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1552);
						match(QUESTION);
						setState(1554);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZEOF) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
							{
							setState(1553);
							((ExpressionContext)_localctx).trueExpression = expression(0);
							}
						}

						setState(1556);
						match(COLON);
						setState(1557);
						((ExpressionContext)_localctx).falseExpression = expression(4);
						}
						break;
					}
					} 
				}
				setState(1562);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
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
		enterRule(_localctx, 260, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1563);
			_la = _input.LA(1);
			if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (ASSIGNMENT - 137)) | (1L << (ADD_ASSIGN - 137)) | (1L << (SUB_ASSIGN - 137)) | (1L << (MUL_ASSIGN - 137)) | (1L << (DIV_ASSIGN - 137)) | (1L << (AND_ASSIGN - 137)) | (1L << (OR_ASSIGN - 137)) | (1L << (XOR_ASSIGN - 137)) | (1L << (MOD_ASSIGN - 137)) | (1L << (LSHIFT_ASSIGN - 137)) | (1L << (RSHIFT_ASSIGN - 137)))) != 0)) ) {
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
		enterRule(_localctx, 262, RULE_castExpression);
		try {
			setState(1574);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1565);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1566);
				match(LP);
				setState(1567);
				typeName();
				setState(1568);
				match(RP);
				}
				setState(1572);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
				case 1:
					{
					setState(1570);
					castExpression();
					}
					break;
				case 2:
					{
					setState(1571);
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
		enterRule(_localctx, 264, RULE_initializer);
		try {
			setState(1579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1576);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1577);
				arrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1578);
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
		enterRule(_localctx, 266, RULE_constantExpression);
		try {
			setState(1583);
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
				setState(1581);
				identifier();
				}
				break;
			case TRUE:
			case FALSE:
			case NIL:
			case NO:
			case NULL_:
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
				setState(1582);
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
		enterRule(_localctx, 268, RULE_unaryExpression);
		int _la;
		try {
			setState(1599);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1585);
				postfixExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1586);
				match(SIZEOF);
				setState(1592);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
				case 1:
					{
					setState(1587);
					unaryExpression();
					}
					break;
				case 2:
					{
					setState(1588);
					match(LP);
					setState(1589);
					typeSpecifier();
					setState(1590);
					match(RP);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1594);
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
				setState(1595);
				unaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1596);
				unaryOperator();
				setState(1597);
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
		enterRule(_localctx, 270, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1601);
			_la = _input.LA(1);
			if ( !(((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (BANG - 140)) | (1L << (TILDE - 140)) | (1L << (ADD - 140)) | (1L << (SUB - 140)) | (1L << (MUL - 140)) | (1L << (BITAND - 140)))) != 0)) ) {
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
		int _startState = 272;
		enterRecursionRule(_localctx, 272, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1604);
			primaryExpression();
			setState(1608);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1605);
					postfix();
					}
					} 
				}
				setState(1610);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1622);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,212,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PostfixExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
					setState(1611);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1612);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==STRUCTACCESS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1613);
					identifier();
					setState(1617);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1614);
							postfix();
							}
							} 
						}
						setState(1619);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
					}
					}
					} 
				}
				setState(1624);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,212,_ctx);
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
		public Token _tset3122;
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
		enterRule(_localctx, 274, RULE_postfix);
		int _la;
		try {
			setState(1643);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1625);
				match(LBRACK);
				setState(1626);
				expression(0);
				setState(1627);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1629);
				match(LP);
				setState(1631);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << ENCODE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PROTOCOL - 69)) | (1L << (SELECTOR - 69)) | (1L << (ATOMIC - 69)) | (1L << (NONATOMIC - 69)) | (1L << (RETAIN - 69)) | (1L << (AUTORELEASING_QUALIFIER - 69)) | (1L << (BLOCK - 69)) | (1L << (BRIDGE_RETAINED - 69)) | (1L << (BRIDGE_TRANSFER - 69)) | (1L << (COVARIANT - 69)) | (1L << (CONTRAVARIANT - 69)) | (1L << (DEPRECATED - 69)) | (1L << (KINDOF - 69)) | (1L << (TYPEOF - 69)) | (1L << (UNUSED - 69)) | (1L << (NULL_UNSPECIFIED - 69)) | (1L << (NULLABLE - 69)) | (1L << (NONNULL - 69)) | (1L << (NULL_RESETTABLE - 69)) | (1L << (NS_INLINE - 69)) | (1L << (NS_ENUM - 69)) | (1L << (NS_OPTIONS - 69)) | (1L << (ASSIGN - 69)) | (1L << (COPY - 69)) | (1L << (GETTER - 69)) | (1L << (SETTER - 69)) | (1L << (STRONG - 69)) | (1L << (READONLY - 69)) | (1L << (READWRITE - 69)) | (1L << (WEAK - 69)) | (1L << (UNSAFE_UNRETAINED - 69)) | (1L << (IB_OUTLET - 69)) | (1L << (IB_OUTLET_COLLECTION - 69)) | (1L << (IB_INSPECTABLE - 69)) | (1L << (IB_DESIGNABLE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (LP - 69)) | (1L << (LBRACK - 69)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (AT - 136)) | (1L << (BANG - 136)) | (1L << (TILDE - 136)) | (1L << (INC - 136)) | (1L << (DEC - 136)) | (1L << (ADD - 136)) | (1L << (SUB - 136)) | (1L << (MUL - 136)) | (1L << (BITAND - 136)) | (1L << (BITXOR - 136)) | (1L << (CHARACTER_LITERAL - 136)) | (1L << (STRING_START - 136)) | (1L << (HEX_LITERAL - 136)) | (1L << (OCTAL_LITERAL - 136)) | (1L << (BINARY_LITERAL - 136)) | (1L << (DECIMAL_LITERAL - 136)) | (1L << (FLOATING_POINT_LITERAL - 136)))) != 0)) {
					{
					setState(1630);
					argumentExpressionList();
					}
				}

				setState(1633);
				match(RP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1634);
				match(LP);
				setState(1637); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(1637);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
					case 1:
						{
						setState(1635);
						match(COMMA);
						}
						break;
					case 2:
						{
						setState(1636);
						((PostfixContext)_localctx)._tset3122 = _input.LT(1);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==RP) ) {
							((PostfixContext)_localctx)._tset3122 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						((PostfixContext)_localctx).macroArguments.add(((PostfixContext)_localctx)._tset3122);
						}
						break;
					}
					}
					setState(1639); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BREAK) | (1L << CASE) | (1L << CHAR) | (1L << CONST) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << ELSE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << FOR) | (1L << GOTO) | (1L << IF) | (1L << INLINE) | (1L << INT) | (1L << LONG) | (1L << REGISTER) | (1L << RESTRICT) | (1L << RETURN) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << SWITCH) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID) | (1L << VOLATILE) | (1L << WHILE) | (1L << BOOL_) | (1L << COMPLEX) | (1L << IMAGINERY) | (1L << TRUE) | (1L << FALSE) | (1L << BOOL) | (1L << Class) | (1L << BYCOPY) | (1L << BYREF) | (1L << ID) | (1L << IMP) | (1L << IN) | (1L << INOUT) | (1L << NIL) | (1L << NO) | (1L << NULL_) | (1L << ONEWAY) | (1L << OUT) | (1L << PROTOCOL_) | (1L << SEL) | (1L << SELF) | (1L << SUPER) | (1L << YES) | (1L << AUTORELEASEPOOL) | (1L << CATCH) | (1L << CLASS) | (1L << DYNAMIC) | (1L << ENCODE) | (1L << END))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FINALLY - 64)) | (1L << (IMPLEMENTATION - 64)) | (1L << (INTERFACE - 64)) | (1L << (IMPORT - 64)) | (1L << (PACKAGE - 64)) | (1L << (PROTOCOL - 64)) | (1L << (OPTIONAL - 64)) | (1L << (PRIVATE - 64)) | (1L << (PROPERTY - 64)) | (1L << (PROTECTED - 64)) | (1L << (PUBLIC - 64)) | (1L << (REQUIRED - 64)) | (1L << (SELECTOR - 64)) | (1L << (SYNCHRONIZED - 64)) | (1L << (SYNTHESIZE - 64)) | (1L << (THROW - 64)) | (1L << (TRY - 64)) | (1L << (ATOMIC - 64)) | (1L << (NONATOMIC - 64)) | (1L << (RETAIN - 64)) | (1L << (ATTRIBUTE - 64)) | (1L << (AUTORELEASING_QUALIFIER - 64)) | (1L << (BLOCK - 64)) | (1L << (BRIDGE - 64)) | (1L << (BRIDGE_RETAINED - 64)) | (1L << (BRIDGE_TRANSFER - 64)) | (1L << (COVARIANT - 64)) | (1L << (CONTRAVARIANT - 64)) | (1L << (DEPRECATED - 64)) | (1L << (KINDOF - 64)) | (1L << (STRONG_QUALIFIER - 64)) | (1L << (TYPEOF - 64)) | (1L << (UNSAFE_UNRETAINED_QUALIFIER - 64)) | (1L << (UNUSED - 64)) | (1L << (WEAK_QUALIFIER - 64)) | (1L << (NULL_UNSPECIFIED - 64)) | (1L << (NULLABLE - 64)) | (1L << (NONNULL - 64)) | (1L << (NULL_RESETTABLE - 64)) | (1L << (NS_INLINE - 64)) | (1L << (NS_ENUM - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (ASSIGN - 64)) | (1L << (COPY - 64)) | (1L << (GETTER - 64)) | (1L << (SETTER - 64)) | (1L << (STRONG - 64)) | (1L << (READONLY - 64)) | (1L << (READWRITE - 64)) | (1L << (WEAK - 64)) | (1L << (UNSAFE_UNRETAINED - 64)) | (1L << (IB_OUTLET - 64)) | (1L << (IB_OUTLET_COLLECTION - 64)) | (1L << (IB_INSPECTABLE - 64)) | (1L << (IB_DESIGNABLE - 64)) | (1L << (NS_ASSUME_NONNULL_BEGIN - 64)) | (1L << (NS_ASSUME_NONNULL_END - 64)) | (1L << (EXTERN_SUFFIX - 64)) | (1L << (IOS_SUFFIX - 64)) | (1L << (MAC_SUFFIX - 64)) | (1L << (TVOS_PROHIBITED - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (LP - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (LBRACE - 128)) | (1L << (RBRACE - 128)) | (1L << (LBRACK - 128)) | (1L << (RBRACK - 128)) | (1L << (SEMI - 128)) | (1L << (COMMA - 128)) | (1L << (DOT - 128)) | (1L << (STRUCTACCESS - 128)) | (1L << (AT - 128)) | (1L << (ASSIGNMENT - 128)) | (1L << (GT - 128)) | (1L << (LT - 128)) | (1L << (BANG - 128)) | (1L << (TILDE - 128)) | (1L << (QUESTION - 128)) | (1L << (COLON - 128)) | (1L << (EQUAL - 128)) | (1L << (LE - 128)) | (1L << (GE - 128)) | (1L << (NOTEQUAL - 128)) | (1L << (AND - 128)) | (1L << (OR - 128)) | (1L << (INC - 128)) | (1L << (DEC - 128)) | (1L << (ADD - 128)) | (1L << (SUB - 128)) | (1L << (MUL - 128)) | (1L << (DIV - 128)) | (1L << (BITAND - 128)) | (1L << (BITOR - 128)) | (1L << (BITXOR - 128)) | (1L << (MOD - 128)) | (1L << (ADD_ASSIGN - 128)) | (1L << (SUB_ASSIGN - 128)) | (1L << (MUL_ASSIGN - 128)) | (1L << (DIV_ASSIGN - 128)) | (1L << (AND_ASSIGN - 128)) | (1L << (OR_ASSIGN - 128)) | (1L << (XOR_ASSIGN - 128)) | (1L << (MOD_ASSIGN - 128)) | (1L << (LSHIFT_ASSIGN - 128)) | (1L << (RSHIFT_ASSIGN - 128)) | (1L << (ELIPSIS - 128)) | (1L << (CHARACTER_LITERAL - 128)) | (1L << (STRING_START - 128)) | (1L << (HEX_LITERAL - 128)) | (1L << (OCTAL_LITERAL - 128)) | (1L << (BINARY_LITERAL - 128)) | (1L << (DECIMAL_LITERAL - 128)) | (1L << (FLOATING_POINT_LITERAL - 128)) | (1L << (WS - 128)) | (1L << (MULTI_COMMENT - 128)) | (1L << (SINGLE_COMMENT - 128)) | (1L << (BACKSLASH - 128)) | (1L << (SHARP - 128)) | (1L << (STRING_NEWLINE - 128)) | (1L << (STRING_END - 128)) | (1L << (STRING_VALUE - 128)) | (1L << (DIRECTIVE_IMPORT - 128)) | (1L << (DIRECTIVE_INCLUDE - 128)) | (1L << (DIRECTIVE_PRAGMA - 128)) | (1L << (DIRECTIVE_DEFINE - 128)) | (1L << (DIRECTIVE_DEFINED - 128)) | (1L << (DIRECTIVE_IF - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (DIRECTIVE_ELIF - 192)) | (1L << (DIRECTIVE_ELSE - 192)) | (1L << (DIRECTIVE_UNDEF - 192)) | (1L << (DIRECTIVE_IFDEF - 192)) | (1L << (DIRECTIVE_IFNDEF - 192)) | (1L << (DIRECTIVE_ENDIF - 192)) | (1L << (DIRECTIVE_TRUE - 192)) | (1L << (DIRECTIVE_FALSE - 192)) | (1L << (DIRECTIVE_ERROR - 192)) | (1L << (DIRECTIVE_WARNING - 192)) | (1L << (DIRECTIVE_BANG - 192)) | (1L << (DIRECTIVE_LP - 192)) | (1L << (DIRECTIVE_RP - 192)) | (1L << (DIRECTIVE_EQUAL - 192)) | (1L << (DIRECTIVE_NOTEQUAL - 192)) | (1L << (DIRECTIVE_AND - 192)) | (1L << (DIRECTIVE_OR - 192)) | (1L << (DIRECTIVE_LT - 192)) | (1L << (DIRECTIVE_GT - 192)) | (1L << (DIRECTIVE_LE - 192)) | (1L << (DIRECTIVE_GE - 192)) | (1L << (DIRECTIVE_STRING - 192)) | (1L << (DIRECTIVE_ID - 192)) | (1L << (DIRECTIVE_DECIMAL_LITERAL - 192)) | (1L << (DIRECTIVE_FLOAT - 192)) | (1L << (DIRECTIVE_NEWLINE - 192)) | (1L << (DIRECTIVE_MULTI_COMMENT - 192)) | (1L << (DIRECTIVE_SINGLE_COMMENT - 192)) | (1L << (DIRECTIVE_BACKSLASH_NEWLINE - 192)) | (1L << (DIRECTIVE_TEXT_NEWLINE - 192)) | (1L << (DIRECTIVE_TEXT - 192)))) != 0) );
				setState(1641);
				match(RP);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1642);
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
		enterRule(_localctx, 276, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1645);
			argumentExpression();
			setState(1650);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1646);
				match(COMMA);
				setState(1647);
				argumentExpression();
				}
				}
				setState(1652);
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
		enterRule(_localctx, 278, RULE_argumentExpression);
		try {
			setState(1655);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1653);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1654);
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
		enterRule(_localctx, 280, RULE_primaryExpression);
		try {
			setState(1672);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1657);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1658);
				constant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1659);
				stringLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1660);
				match(LP);
				setState(1661);
				expression(0);
				setState(1662);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1664);
				messageExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1665);
				selectorExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1666);
				protocolExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1667);
				encodeExpression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1668);
				dictionaryExpression();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1669);
				arrayExpression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1670);
				boxExpression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1671);
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
		public TerminalNode NULL_() { return getToken(ObjectiveCParser.NULL_, 0); }
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
		enterRule(_localctx, 282, RULE_constant);
		int _la;
		try {
			setState(1692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1674);
				match(HEX_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1675);
				match(OCTAL_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1676);
				match(BINARY_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(1677);
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

				setState(1680);
				match(DECIMAL_LITERAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1682);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(1681);
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

				setState(1684);
				match(FLOATING_POINT_LITERAL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1685);
				match(CHARACTER_LITERAL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1686);
				match(NIL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1687);
				match(NULL_);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1688);
				match(YES);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1689);
				match(NO);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1690);
				match(TRUE);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1691);
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
		enterRule(_localctx, 284, RULE_stringLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1702); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1694);
					match(STRING_START);
					setState(1698);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==STRING_NEWLINE || _la==STRING_VALUE) {
						{
						{
						setState(1695);
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
						setState(1700);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1701);
					match(STRING_END);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1704); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,224,_ctx);
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
		enterRule(_localctx, 286, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1706);
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
		case 129:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 136:
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
		"\u0004\u0001\u00de\u06ad\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"+
		"|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"+
		"\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007"+
		"\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007"+
		"\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007"+
		"\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007"+
		"\u008c\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e\u0002\u008f\u0007"+
		"\u008f\u0001\u0000\u0005\u0000\u0122\b\u0000\n\u0000\f\u0000\u0125\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0134\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0003\u0003\u013b\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u0141\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u0147\b\u0003\u0001\u0003\u0003\u0003"+
		"\u014a\b\u0003\u0001\u0003\u0003\u0003\u014d\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0155"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u015c\b\u0004\u0001\u0004\u0003\u0004\u015f\b\u0004\u0001\u0004"+
		"\u0003\u0004\u0162\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u016a\b\u0005\u0001\u0005\u0003\u0005"+
		"\u016d\b\u0005\u0001\u0005\u0003\u0005\u0170\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u017a\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0184"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u018c"+
		"\b\b\u0001\b\u0005\b\u018f\b\b\n\b\f\b\u0192\t\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0005\t\u0198\b\t\n\t\f\t\u019b\t\t\u0001\t\u0004\t\u019e\b"+
		"\t\u000b\t\f\t\u019f\u0003\t\u01a2\b\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u01ac\b\u000b"+
		"\n\u000b\f\u000b\u01af\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0005\f\u01b6\b\f\n\f\f\f\u01b9\t\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u01c0\b\r\u0001\r\u0003\r\u01c3\b\r\u0001\r\u0003\r"+
		"\u01c6\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u01cd\b\u000e\n\u000e\f\u000e\u01d0\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u01e6\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u01ed\b\u0010\u0001\u0010\u0003\u0010\u01f0\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u01f4\b\u0011\n\u0011\f\u0011\u01f7"+
		"\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005\u0012\u01fd"+
		"\b\u0012\n\u0012\f\u0012\u0200\t\u0012\u0001\u0012\u0004\u0012\u0203\b"+
		"\u0012\u000b\u0012\f\u0012\u0204\u0003\u0012\u0207\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0004\u0014\u0210\b\u0014\u000b\u0014\f\u0014\u0211\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0003"+
		"\u0017\u021b\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0220"+
		"\b\u0017\n\u0017\f\u0017\u0223\t\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0004\u0018\u022c\b\u0018"+
		"\u000b\u0018\f\u0018\u022d\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0003\u001b\u0237\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u023b\b\u001b\u0001\u001b\u0003\u001b\u023e\b"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0004\u001c\u0244"+
		"\b\u001c\u000b\u001c\f\u001c\u0245\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u024a\b\u001c\u0003\u001c\u024c\b\u001c\u0001\u001d\u0003\u001d\u024f"+
		"\b\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0253\b\u001d\n\u001d\f\u001d"+
		"\u0256\t\u001d\u0001\u001d\u0003\u001d\u0259\b\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u025f\b\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0003 \u026d\b \u0001!\u0001!\u0001!\u0005!\u0272\b!\n"+
		"!\f!\u0275\t!\u0001\"\u0001\"\u0001\"\u0003\"\u027a\b\"\u0001#\u0003#"+
		"\u027d\b#\u0001#\u0001#\u0003#\u0281\b#\u0001#\u0001#\u0001#\u0001#\u0003"+
		"#\u0287\b#\u0001#\u0001#\u0003#\u028b\b#\u0001$\u0001$\u0001$\u0001$\u0005"+
		"$\u0291\b$\n$\f$\u0294\t$\u0003$\u0296\b$\u0001$\u0001$\u0001%\u0005%"+
		"\u029b\b%\n%\f%\u029e\t%\u0001%\u0001%\u0003%\u02a2\b%\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0005&\u02a9\b&\n&\f&\u02ac\t&\u0001&\u0003&\u02af\b&"+
		"\u0003&\u02b1\b&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001("+
		"\u0001(\u0001(\u0001(\u0003(\u02bd\b(\u0003(\u02bf\b(\u0001(\u0001(\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u02cb\b)\u0003"+
		")\u02cd\b)\u0001*\u0001*\u0001*\u0003*\u02d2\b*\u0001*\u0001*\u0005*\u02d6"+
		"\b*\n*\f*\u02d9\t*\u0003*\u02db\b*\u0001*\u0001*\u0001+\u0001+\u0003+"+
		"\u02e1\b+\u0001,\u0001,\u0003,\u02e5\b,\u0001,\u0003,\u02e8\b,\u0001,"+
		"\u0003,\u02eb\b,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		".\u0001.\u0003.\u02f6\b.\u0001/\u0001/\u0004/\u02fa\b/\u000b/\f/\u02fb"+
		"\u0003/\u02fe\b/\u00010\u00030\u0301\b0\u00010\u00010\u00010\u00010\u0005"+
		"0\u0307\b0\n0\f0\u030a\t0\u00011\u00011\u00031\u030e\b1\u00011\u00011"+
		"\u00011\u00011\u00031\u0314\b1\u00012\u00012\u00012\u00012\u00012\u0001"+
		"3\u00013\u00033\u031d\b3\u00013\u00043\u0320\b3\u000b3\f3\u0321\u0003"+
		"3\u0324\b3\u00014\u00014\u00014\u00014\u00014\u00015\u00015\u00015\u0001"+
		"5\u00015\u00016\u00016\u00016\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00037\u033a\b7\u00018\u00018\u00018\u00058\u033f\b8\n8\f8\u0342"+
		"\t8\u00018\u00018\u00038\u0346\b8\u00019\u00019\u00019\u00019\u00019\u0001"+
		"9\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001"+
		"<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001>\u0003>\u035e\b>\u0001>\u0001"+
		">\u0001>\u0003>\u0363\b>\u0001>\u0001>\u0001>\u0003>\u0368\b>\u0001?\u0001"+
		"?\u0003?\u036c\b?\u0001@\u0001@\u0003@\u0370\b@\u0001A\u0001A\u0003A\u0374"+
		"\bA\u0001A\u0001A\u0001B\u0001B\u0001B\u0005B\u037b\bB\nB\fB\u037e\tB"+
		"\u0001C\u0001C\u0001C\u0001C\u0003C\u0384\bC\u0001D\u0001D\u0001D\u0001"+
		"D\u0001D\u0003D\u038b\bD\u0001E\u0001E\u0001E\u0001E\u0003E\u0391\bE\u0001"+
		"F\u0003F\u0394\bF\u0001F\u0001F\u0003F\u0398\bF\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001G\u0003G\u03a0\bG\u0001G\u0003G\u03a3\bG\u0001G\u0001G\u0003"+
		"G\u03a7\bG\u0001G\u0001G\u0001H\u0001H\u0001H\u0001H\u0003H\u03af\bH\u0001"+
		"H\u0001H\u0001I\u0003I\u03b4\bI\u0001I\u0001I\u0001I\u0001I\u0001I\u0003"+
		"I\u03bb\bI\u0001I\u0001I\u0001J\u0001J\u0001J\u0005J\u03c2\bJ\nJ\fJ\u03c5"+
		"\tJ\u0001K\u0003K\u03c8\bK\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0004L\u03d4\bL\u000bL\fL\u03d5\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0005M\u03de\bM\nM\fM\u03e1\tM\u0001M\u0001M\u0001"+
		"M\u0001N\u0001N\u0001N\u0005N\u03e9\bN\nN\fN\u03ec\tN\u0001O\u0001O\u0001"+
		"O\u0003O\u03f1\bO\u0001P\u0001P\u0001P\u0003P\u03f6\bP\u0001P\u0001P\u0004"+
		"P\u03fa\bP\u000bP\fP\u03fb\u0001P\u0001P\u0003P\u0400\bP\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0005Q\u0406\bQ\nQ\fQ\u0409\tQ\u0001Q\u0001Q\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0004R\u0413\bR\u000bR\fR\u0414\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0003S\u041d\bS\u0001T\u0001T\u0001U\u0001"+
		"U\u0001V\u0001V\u0001W\u0001W\u0001X\u0001X\u0001X\u0001X\u0003X\u042b"+
		"\bX\u0001Y\u0001Y\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0003Z\u043e\bZ\u0003"+
		"Z\u0440\bZ\u0001[\u0001[\u0001[\u0001[\u0001[\u0001\\\u0001\\\u0001\\"+
		"\u0005\\\u044a\b\\\n\\\f\\\u044d\t\\\u0001]\u0001]\u0003]\u0451\b]\u0001"+
		"]\u0001]\u0003]\u0455\b]\u0001^\u0001^\u0003^\u0459\b^\u0001^\u0001^\u0003"+
		"^\u045d\b^\u0001^\u0001^\u0001^\u0001^\u0001^\u0003^\u0464\b^\u0001^\u0001"+
		"^\u0001^\u0001^\u0003^\u046a\b^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0003^\u0476\b^\u0001_\u0001_\u0001_\u0005"+
		"_\u047b\b_\n_\f_\u047e\t_\u0001_\u0003_\u0481\b_\u0001`\u0001`\u0001`"+
		"\u0003`\u0486\b`\u0001a\u0001a\u0003a\u048a\ba\u0001b\u0001b\u0001b\u0001"+
		"b\u0001b\u0003b\u0491\bb\u0001b\u0005b\u0494\bb\nb\fb\u0497\tb\u0001b"+
		"\u0001b\u0001b\u0003b\u049c\bb\u0001b\u0003b\u049f\bb\u0001b\u0001b\u0003"+
		"b\u04a3\bb\u0001c\u0001c\u0003c\u04a7\bc\u0001c\u0001c\u0001d\u0001d\u0001"+
		"d\u0003d\u04ae\bd\u0001e\u0001e\u0003e\u04b2\be\u0001e\u0003e\u04b5\b"+
		"e\u0001f\u0001f\u0001f\u0001f\u0001f\u0005f\u04bc\bf\nf\ff\u04bf\tf\u0001"+
		"f\u0001f\u0003f\u04c3\bf\u0001g\u0001g\u0001g\u0003g\u04c8\bg\u0003g\u04ca"+
		"\bg\u0001g\u0001g\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0005h\u04d4"+
		"\bh\nh\fh\u04d7\th\u0001h\u0003h\u04da\bh\u0003h\u04dc\bh\u0001h\u0001"+
		"h\u0001i\u0001i\u0001i\u0005i\u04e3\bi\ni\fi\u04e6\ti\u0001i\u0003i\u04e9"+
		"\bi\u0001j\u0001j\u0003j\u04ed\bj\u0001j\u0003j\u04f0\bj\u0001k\u0001"+
		"k\u0003k\u04f4\bk\u0001k\u0001k\u0003k\u04f8\bk\u0001k\u0001k\u0004k\u04fc"+
		"\bk\u000bk\fk\u04fd\u0001k\u0001k\u0003k\u0502\bk\u0001k\u0004k\u0505"+
		"\bk\u000bk\fk\u0506\u0003k\u0509\bk\u0001l\u0001l\u0003l\u050d\bl\u0001"+
		"l\u0001l\u0001l\u0003l\u0512\bl\u0001l\u0003l\u0515\bl\u0001m\u0001m\u0001"+
		"m\u0005m\u051a\bm\nm\fm\u051d\tm\u0001n\u0001n\u0001n\u0001n\u0003n\u0523"+
		"\bn\u0001o\u0003o\u0526\bo\u0001o\u0001o\u0001p\u0001p\u0003p\u052c\b"+
		"p\u0001p\u0001p\u0003p\u0530\bp\u0001p\u0001p\u0003p\u0534\bp\u0001p\u0001"+
		"p\u0003p\u0538\bp\u0001p\u0001p\u0003p\u053c\bp\u0001p\u0001p\u0003p\u0540"+
		"\bp\u0001p\u0001p\u0003p\u0544\bp\u0001p\u0001p\u0003p\u0548\bp\u0001"+
		"p\u0001p\u0003p\u054c\bp\u0001p\u0001p\u0003p\u0550\bp\u0001p\u0003p\u0553"+
		"\bp\u0001q\u0001q\u0001q\u0001q\u0001r\u0001r\u0001r\u0003r\u055c\br\u0001"+
		"s\u0001s\u0001s\u0005s\u0561\bs\ns\fs\u0564\ts\u0001s\u0001s\u0001t\u0001"+
		"t\u0001t\u0001t\u0001t\u0001t\u0001t\u0003t\u056f\bt\u0001t\u0003t\u0572"+
		"\bt\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001v\u0001v\u0005v\u057c"+
		"\bv\nv\fv\u057f\tv\u0001v\u0001v\u0001w\u0004w\u0584\bw\u000bw\fw\u0585"+
		"\u0001w\u0004w\u0589\bw\u000bw\fw\u058a\u0001x\u0001x\u0001x\u0001x\u0001"+
		"x\u0001x\u0003x\u0593\bx\u0001x\u0001x\u0001x\u0001x\u0003x\u0599\bx\u0001"+
		"y\u0001y\u0001y\u0001y\u0003y\u059f\by\u0001z\u0001z\u0001z\u0001z\u0001"+
		"z\u0001z\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001"+
		"|\u0001|\u0001|\u0003|\u05b2\b|\u0001|\u0001|\u0003|\u05b6\b|\u0001|\u0001"+
		"|\u0003|\u05ba\b|\u0001|\u0001|\u0001|\u0001}\u0001}\u0001}\u0001}\u0003"+
		"}\u05c3\b}\u0001~\u0001~\u0001~\u0001~\u0001~\u0003~\u05ca\b~\u0001~\u0001"+
		"~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001"+
		"\u007f\u0003\u007f\u05d5\b\u007f\u0003\u007f\u05d7\b\u007f\u0001\u0080"+
		"\u0001\u0080\u0001\u0080\u0005\u0080\u05dc\b\u0080\n\u0080\f\u0080\u05df"+
		"\t\u0080\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0003\u0081\u05eb"+
		"\b\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0003"+
		"\u0081\u05f8\b\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0003\u0081\u0613\b\u0081\u0001\u0081\u0001"+
		"\u0081\u0005\u0081\u0617\b\u0081\n\u0081\f\u0081\u061a\t\u0081\u0001\u0082"+
		"\u0001\u0082\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083"+
		"\u0001\u0083\u0001\u0083\u0003\u0083\u0625\b\u0083\u0003\u0083\u0627\b"+
		"\u0083\u0001\u0084\u0001\u0084\u0001\u0084\u0003\u0084\u062c\b\u0084\u0001"+
		"\u0085\u0001\u0085\u0003\u0085\u0630\b\u0085\u0001\u0086\u0001\u0086\u0001"+
		"\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0003\u0086\u0639"+
		"\b\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0003"+
		"\u0086\u0640\b\u0086\u0001\u0087\u0001\u0087\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0005\u0088\u0647\b\u0088\n\u0088\f\u0088\u064a\t\u0088\u0001\u0088"+
		"\u0001\u0088\u0001\u0088\u0001\u0088\u0005\u0088\u0650\b\u0088\n\u0088"+
		"\f\u0088\u0653\t\u0088\u0005\u0088\u0655\b\u0088\n\u0088\f\u0088\u0658"+
		"\t\u0088\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0003\u0089\u0660\b\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0004\u0089\u0666\b\u0089\u000b\u0089\f\u0089\u0667\u0001\u0089"+
		"\u0001\u0089\u0003\u0089\u066c\b\u0089\u0001\u008a\u0001\u008a\u0001\u008a"+
		"\u0005\u008a\u0671\b\u008a\n\u008a\f\u008a\u0674\t\u008a\u0001\u008b\u0001"+
		"\u008b\u0003\u008b\u0678\b\u008b\u0001\u008c\u0001\u008c\u0001\u008c\u0001"+
		"\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001"+
		"\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0003"+
		"\u008c\u0689\b\u008c\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0003"+
		"\u008d\u068f\b\u008d\u0001\u008d\u0001\u008d\u0003\u008d\u0693\b\u008d"+
		"\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d"+
		"\u0001\u008d\u0001\u008d\u0003\u008d\u069d\b\u008d\u0001\u008e\u0001\u008e"+
		"\u0005\u008e\u06a1\b\u008e\n\u008e\f\u008e\u06a4\t\u008e\u0001\u008e\u0004"+
		"\u008e\u06a7\b\u008e\u000b\u008e\f\u008e\u06a8\u0001\u008f\u0001\u008f"+
		"\u0001\u008f\u0000\u0002\u0102\u0110\u0090\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2"+
		"\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba"+
		"\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2"+
		"\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea"+
		"\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102"+
		"\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a"+
		"\u011c\u011e\u0000\u0015\u0002\u0000FFKK\u0001\u0000Z[\u0003\u0000DDG"+
		"GIJ\u0002\u0000\u001b\u001b\u001e\u001e\u0004\u0000UU^^``bb\u0001\u0000"+
		"cf\u0004\u0000\u0001\u0001\f\f\u0014\u0014\u001a\u001a\u0004\u0000\u0011"+
		"\u0011VY]]gg\u0003\u0000*+./34\u0001\u0000hi\u0002\u0000\u009a\u009b\u009f"+
		"\u009f\u0001\u0000\u0098\u0099\u0002\u0000\u008a\u008b\u0091\u0092\u0002"+
		"\u0000\u0090\u0090\u0093\u0093\u0002\u0000\u0089\u0089\u00a0\u00a9\u0001"+
		"\u0000\u0096\u0097\u0003\u0000\u008c\u008d\u0098\u009a\u009c\u009c\u0001"+
		"\u0000\u0086\u0087\u0001\u0000\u007f\u007f\u0002\u0000\u00b7\u00b7\u00b9"+
		"\u00b9\b\u0000(/38QSUVX]aacv}}\u0768\u0000\u0123\u0001\u0000\u0000\u0000"+
		"\u0002\u0133\u0001\u0000\u0000\u0000\u0004\u0135\u0001\u0000\u0000\u0000"+
		"\u0006\u013a\u0001\u0000\u0000\u0000\b\u0150\u0001\u0000\u0000\u0000\n"+
		"\u0165\u0001\u0000\u0000\u0000\f\u0173\u0001\u0000\u0000\u0000\u000e\u017d"+
		"\u0001\u0000\u0000\u0000\u0010\u0185\u0001\u0000\u0000\u0000\u0012\u01a1"+
		"\u0001\u0000\u0000\u0000\u0014\u01a3\u0001\u0000\u0000\u0000\u0016\u01a7"+
		"\u0001\u0000\u0000\u0000\u0018\u01b2\u0001\u0000\u0000\u0000\u001a\u01ba"+
		"\u0001\u0000\u0000\u0000\u001c\u01c9\u0001\u0000\u0000\u0000\u001e\u01e5"+
		"\u0001\u0000\u0000\u0000 \u01ef\u0001\u0000\u0000\u0000\"\u01f1\u0001"+
		"\u0000\u0000\u0000$\u0206\u0001\u0000\u0000\u0000&\u0208\u0001\u0000\u0000"+
		"\u0000(\u020f\u0001\u0000\u0000\u0000*\u0213\u0001\u0000\u0000\u0000,"+
		"\u0216\u0001\u0000\u0000\u0000.\u021a\u0001\u0000\u0000\u00000\u022b\u0001"+
		"\u0000\u0000\u00002\u022f\u0001\u0000\u0000\u00004\u0232\u0001\u0000\u0000"+
		"\u00006\u0236\u0001\u0000\u0000\u00008\u024b\u0001\u0000\u0000\u0000:"+
		"\u024e\u0001\u0000\u0000\u0000<\u025e\u0001\u0000\u0000\u0000>\u0260\u0001"+
		"\u0000\u0000\u0000@\u026c\u0001\u0000\u0000\u0000B\u026e\u0001\u0000\u0000"+
		"\u0000D\u0276\u0001\u0000\u0000\u0000F\u027c\u0001\u0000\u0000\u0000H"+
		"\u028c\u0001\u0000\u0000\u0000J\u02a1\u0001\u0000\u0000\u0000L\u02a3\u0001"+
		"\u0000\u0000\u0000N\u02b4\u0001\u0000\u0000\u0000P\u02b8\u0001\u0000\u0000"+
		"\u0000R\u02cc\u0001\u0000\u0000\u0000T\u02ce\u0001\u0000\u0000\u0000V"+
		"\u02e0\u0001\u0000\u0000\u0000X\u02e2\u0001\u0000\u0000\u0000Z\u02ee\u0001"+
		"\u0000\u0000\u0000\\\u02f5\u0001\u0000\u0000\u0000^\u02fd\u0001\u0000"+
		"\u0000\u0000`\u0300\u0001\u0000\u0000\u0000b\u030b\u0001\u0000\u0000\u0000"+
		"d\u0315\u0001\u0000\u0000\u0000f\u0323\u0001\u0000\u0000\u0000h\u0325"+
		"\u0001\u0000\u0000\u0000j\u032a\u0001\u0000\u0000\u0000l\u032f\u0001\u0000"+
		"\u0000\u0000n\u0339\u0001\u0000\u0000\u0000p\u033b\u0001\u0000\u0000\u0000"+
		"r\u0347\u0001\u0000\u0000\u0000t\u034d\u0001\u0000\u0000\u0000v\u0353"+
		"\u0001\u0000\u0000\u0000x\u0356\u0001\u0000\u0000\u0000z\u0359\u0001\u0000"+
		"\u0000\u0000|\u035d\u0001\u0000\u0000\u0000~\u0369\u0001\u0000\u0000\u0000"+
		"\u0080\u036f\u0001\u0000\u0000\u0000\u0082\u0371\u0001\u0000\u0000\u0000"+
		"\u0084\u0377\u0001\u0000\u0000\u0000\u0086\u0383\u0001\u0000\u0000\u0000"+
		"\u0088\u0385\u0001\u0000\u0000\u0000\u008a\u0390\u0001\u0000\u0000\u0000"+
		"\u008c\u0393\u0001\u0000\u0000\u0000\u008e\u039f\u0001\u0000\u0000\u0000"+
		"\u0090\u03ae\u0001\u0000\u0000\u0000\u0092\u03b3\u0001\u0000\u0000\u0000"+
		"\u0094\u03be\u0001\u0000\u0000\u0000\u0096\u03c7\u0001\u0000\u0000\u0000"+
		"\u0098\u03d3\u0001\u0000\u0000\u0000\u009a\u03d7\u0001\u0000\u0000\u0000"+
		"\u009c\u03e5\u0001\u0000\u0000\u0000\u009e\u03ed\u0001\u0000\u0000\u0000"+
		"\u00a0\u03f2\u0001\u0000\u0000\u0000\u00a2\u0401\u0001\u0000\u0000\u0000"+
		"\u00a4\u0412\u0001\u0000\u0000\u0000\u00a6\u041c\u0001\u0000\u0000\u0000"+
		"\u00a8\u041e\u0001\u0000\u0000\u0000\u00aa\u0420\u0001\u0000\u0000\u0000"+
		"\u00ac\u0422\u0001\u0000\u0000\u0000\u00ae\u0424\u0001\u0000\u0000\u0000"+
		"\u00b0\u042a\u0001\u0000\u0000\u0000\u00b2\u042c\u0001\u0000\u0000\u0000"+
		"\u00b4\u043f\u0001\u0000\u0000\u0000\u00b6\u0441\u0001\u0000\u0000\u0000"+
		"\u00b8\u0446\u0001\u0000\u0000\u0000\u00ba\u0454\u0001\u0000\u0000\u0000"+
		"\u00bc\u0475\u0001\u0000\u0000\u0000\u00be\u0477\u0001\u0000\u0000\u0000"+
		"\u00c0\u0482\u0001\u0000\u0000\u0000\u00c2\u0489\u0001\u0000\u0000\u0000"+
		"\u00c4\u04a2\u0001\u0000\u0000\u0000\u00c6\u04a4\u0001\u0000\u0000\u0000"+
		"\u00c8\u04aa\u0001\u0000\u0000\u0000\u00ca\u04af\u0001\u0000\u0000\u0000"+
		"\u00cc\u04b6\u0001\u0000\u0000\u0000\u00ce\u04c4\u0001\u0000\u0000\u0000"+
		"\u00d0\u04cd\u0001\u0000\u0000\u0000\u00d2\u04df\u0001\u0000\u0000\u0000"+
		"\u00d4\u04ef\u0001\u0000\u0000\u0000\u00d6\u0508\u0001\u0000\u0000\u0000"+
		"\u00d8\u0514\u0001\u0000\u0000\u0000\u00da\u0516\u0001\u0000\u0000\u0000"+
		"\u00dc\u0522\u0001\u0000\u0000\u0000\u00de\u0525\u0001\u0000\u0000\u0000"+
		"\u00e0\u0552\u0001\u0000\u0000\u0000\u00e2\u0554\u0001\u0000\u0000\u0000"+
		"\u00e4\u0558\u0001\u0000\u0000\u0000\u00e6\u055d\u0001\u0000\u0000\u0000"+
		"\u00e8\u0571\u0001\u0000\u0000\u0000\u00ea\u0573\u0001\u0000\u0000\u0000"+
		"\u00ec\u0579\u0001\u0000\u0000\u0000\u00ee\u0583\u0001\u0000\u0000\u0000"+
		"\u00f0\u0598\u0001\u0000\u0000\u0000\u00f2\u059e\u0001\u0000\u0000\u0000"+
		"\u00f4\u05a0\u0001\u0000\u0000\u0000\u00f6\u05a6\u0001\u0000\u0000\u0000"+
		"\u00f8\u05ae\u0001\u0000\u0000\u0000\u00fa\u05c2\u0001\u0000\u0000\u0000"+
		"\u00fc\u05c4\u0001\u0000\u0000\u0000\u00fe\u05d6\u0001\u0000\u0000\u0000"+
		"\u0100\u05d8\u0001\u0000\u0000\u0000\u0102\u05ea\u0001\u0000\u0000\u0000"+
		"\u0104\u061b\u0001\u0000\u0000\u0000\u0106\u0626\u0001\u0000\u0000\u0000"+
		"\u0108\u062b\u0001\u0000\u0000\u0000\u010a\u062f\u0001\u0000\u0000\u0000"+
		"\u010c\u063f\u0001\u0000\u0000\u0000\u010e\u0641\u0001\u0000\u0000\u0000"+
		"\u0110\u0643\u0001\u0000\u0000\u0000\u0112\u066b\u0001\u0000\u0000\u0000"+
		"\u0114\u066d\u0001\u0000\u0000\u0000\u0116\u0677\u0001\u0000\u0000\u0000"+
		"\u0118\u0688\u0001\u0000\u0000\u0000\u011a\u069c\u0001\u0000\u0000\u0000"+
		"\u011c\u06a6\u0001\u0000\u0000\u0000\u011e\u06aa\u0001\u0000\u0000\u0000"+
		"\u0120\u0122\u0003\u0002\u0001\u0000\u0121\u0120\u0001\u0000\u0000\u0000"+
		"\u0122\u0125\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000"+
		"\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0126\u0001\u0000\u0000\u0000"+
		"\u0125\u0123\u0001\u0000\u0000\u0000\u0126\u0127\u0005\u0000\u0000\u0001"+
		"\u0127\u0001\u0001\u0000\u0000\u0000\u0128\u0134\u0003\u0004\u0002\u0000"+
		"\u0129\u0134\u0003x<\u0000\u012a\u0134\u0003\u008aE\u0000\u012b\u0134"+
		"\u0003\u0006\u0003\u0000\u012c\u0134\u0003\n\u0005\u0000\u012d\u0134\u0003"+
		"\b\u0004\u0000\u012e\u0134\u0003\f\u0006\u0000\u012f\u0134\u0003\u0010"+
		"\b\u0000\u0130\u0134\u0003\u0014\n\u0000\u0131\u0134\u0003\u0016\u000b"+
		"\u0000\u0132\u0134\u0003z=\u0000\u0133\u0128\u0001\u0000\u0000\u0000\u0133"+
		"\u0129\u0001\u0000\u0000\u0000\u0133\u012a\u0001\u0000\u0000\u0000\u0133"+
		"\u012b\u0001\u0000\u0000\u0000\u0133\u012c\u0001\u0000\u0000\u0000\u0133"+
		"\u012d\u0001\u0000\u0000\u0000\u0133\u012e\u0001\u0000\u0000\u0000\u0133"+
		"\u012f\u0001\u0000\u0000\u0000\u0133\u0130\u0001\u0000\u0000\u0000\u0133"+
		"\u0131\u0001\u0000\u0000\u0000\u0133\u0132\u0001\u0000\u0000\u0000\u0134"+
		"\u0003\u0001\u0000\u0000\u0000\u0135\u0136\u0005C\u0000\u0000\u0136\u0137"+
		"\u0003\u011e\u008f\u0000\u0137\u0138\u0005\u0084\u0000\u0000\u0138\u0005"+
		"\u0001\u0000\u0000\u0000\u0139\u013b\u0005v\u0000\u0000\u013a\u0139\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0005B\u0000\u0000\u013d\u0140\u0003\u000e"+
		"\u0007\u0000\u013e\u013f\u0005\u008f\u0000\u0000\u013f\u0141\u0003\u011e"+
		"\u008f\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000"+
		"\u0000\u0000\u0141\u0146\u0001\u0000\u0000\u0000\u0142\u0143\u0005\u008b"+
		"\u0000\u0000\u0143\u0144\u0003\u0018\f\u0000\u0144\u0145\u0005\u008a\u0000"+
		"\u0000\u0145\u0147\u0001\u0000\u0000\u0000\u0146\u0142\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u0149\u0001\u0000\u0000"+
		"\u0000\u0148\u014a\u0003\"\u0011\u0000\u0149\u0148\u0001\u0000\u0000\u0000"+
		"\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014c\u0001\u0000\u0000\u0000"+
		"\u014b\u014d\u0003(\u0014\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014c"+
		"\u014d\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0005?\u0000\u0000\u014f\u0007\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\u0005B\u0000\u0000\u0151\u0152\u0003\u000e\u0007\u0000\u0152\u0154\u0005"+
		"~\u0000\u0000\u0153\u0155\u0003\u011e\u008f\u0000\u0154\u0153\u0001\u0000"+
		"\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000"+
		"\u0000\u0000\u0156\u015b\u0005\u007f\u0000\u0000\u0157\u0158\u0005\u008b"+
		"\u0000\u0000\u0158\u0159\u0003\u0018\f\u0000\u0159\u015a\u0005\u008a\u0000"+
		"\u0000\u015a\u015c\u0001\u0000\u0000\u0000\u015b\u0157\u0001\u0000\u0000"+
		"\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u015e\u0001\u0000\u0000"+
		"\u0000\u015d\u015f\u0003\"\u0011\u0000\u015e\u015d\u0001\u0000\u0000\u0000"+
		"\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u0161\u0001\u0000\u0000\u0000"+
		"\u0160\u0162\u0003(\u0014\u0000\u0161\u0160\u0001\u0000\u0000\u0000\u0161"+
		"\u0162\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0005?\u0000\u0000\u0164\t\u0001\u0000\u0000\u0000\u0165\u0166"+
		"\u0005A\u0000\u0000\u0166\u0169\u0003\u000e\u0007\u0000\u0167\u0168\u0005"+
		"\u008f\u0000\u0000\u0168\u016a\u0003\u011e\u008f\u0000\u0169\u0167\u0001"+
		"\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u016c\u0001"+
		"\u0000\u0000\u0000\u016b\u016d\u0003\"\u0011\u0000\u016c\u016b\u0001\u0000"+
		"\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016f\u0001\u0000"+
		"\u0000\u0000\u016e\u0170\u00030\u0018\u0000\u016f\u016e\u0001\u0000\u0000"+
		"\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000"+
		"\u0000\u0171\u0172\u0005?\u0000\u0000\u0172\u000b\u0001\u0000\u0000\u0000"+
		"\u0173\u0174\u0005A\u0000\u0000\u0174\u0175\u0003\u000e\u0007\u0000\u0175"+
		"\u0176\u0005~\u0000\u0000\u0176\u0177\u0003\u011e\u008f\u0000\u0177\u0179"+
		"\u0005\u007f\u0000\u0000\u0178\u017a\u00030\u0018\u0000\u0179\u0178\u0001"+
		"\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017b\u0001"+
		"\u0000\u0000\u0000\u017b\u017c\u0005?\u0000\u0000\u017c\r\u0001\u0000"+
		"\u0000\u0000\u017d\u0183\u0003\u011e\u008f\u0000\u017e\u017f\u0005\u008b"+
		"\u0000\u0000\u017f\u0180\u0003\u0018\f\u0000\u0180\u0181\u0005\u008a\u0000"+
		"\u0000\u0181\u0184\u0001\u0000\u0000\u0000\u0182\u0184\u0003H$\u0000\u0183"+
		"\u017e\u0001\u0000\u0000\u0000\u0183\u0182\u0001\u0000\u0000\u0000\u0183"+
		"\u0184\u0001\u0000\u0000\u0000\u0184\u000f\u0001\u0000\u0000\u0000\u0185"+
		"\u0186\u0005E\u0000\u0000\u0186\u018b\u0003 \u0010\u0000\u0187\u0188\u0005"+
		"\u008b\u0000\u0000\u0188\u0189\u0003\u0018\f\u0000\u0189\u018a\u0005\u008a"+
		"\u0000\u0000\u018a\u018c\u0001\u0000\u0000\u0000\u018b\u0187\u0001\u0000"+
		"\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u0190\u0001\u0000"+
		"\u0000\u0000\u018d\u018f\u0003\u0012\t\u0000\u018e\u018d\u0001\u0000\u0000"+
		"\u0000\u018f\u0192\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000"+
		"\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0193\u0001\u0000\u0000"+
		"\u0000\u0192\u0190\u0001\u0000\u0000\u0000\u0193\u0194\u0005?\u0000\u0000"+
		"\u0194\u0011\u0001\u0000\u0000\u0000\u0195\u0199\u0007\u0000\u0000\u0000"+
		"\u0196\u0198\u0003(\u0014\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0198"+
		"\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u0199"+
		"\u019a\u0001\u0000\u0000\u0000\u019a\u01a2\u0001\u0000\u0000\u0000\u019b"+
		"\u0199\u0001\u0000\u0000\u0000\u019c\u019e\u0003(\u0014\u0000\u019d\u019c"+
		"\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u019d"+
		"\u0001\u0000\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a1\u0195\u0001\u0000\u0000\u0000\u01a1\u019d"+
		"\u0001\u0000\u0000\u0000\u01a2\u0013\u0001\u0000\u0000\u0000\u01a3\u01a4"+
		"\u0005E\u0000\u0000\u01a4\u01a5\u0003\u0018\f\u0000\u01a5\u01a6\u0005"+
		"\u0084\u0000\u0000\u01a6\u0015\u0001\u0000\u0000\u0000\u01a7\u01a8\u0005"+
		"<\u0000\u0000\u01a8\u01ad\u0003\u011e\u008f\u0000\u01a9\u01aa\u0005\u0085"+
		"\u0000\u0000\u01aa\u01ac\u0003\u011e\u008f\u0000\u01ab\u01a9\u0001\u0000"+
		"\u0000\u0000\u01ac\u01af\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000"+
		"\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01b0\u0001\u0000"+
		"\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01b0\u01b1\u0005\u0084"+
		"\u0000\u0000\u01b1\u0017\u0001\u0000\u0000\u0000\u01b2\u01b7\u0003 \u0010"+
		"\u0000\u01b3\u01b4\u0005\u0085\u0000\u0000\u01b4\u01b6\u0003 \u0010\u0000"+
		"\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b6\u01b9\u0001\u0000\u0000\u0000"+
		"\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000"+
		"\u01b8\u0019\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000"+
		"\u01ba\u01bf\u0005H\u0000\u0000\u01bb\u01bc\u0005~\u0000\u0000\u01bc\u01bd"+
		"\u0003\u001c\u000e\u0000\u01bd\u01be\u0005\u007f\u0000\u0000\u01be\u01c0"+
		"\u0001\u0000\u0000\u0000\u01bf\u01bb\u0001\u0000\u0000\u0000\u01bf\u01c0"+
		"\u0001\u0000\u0000\u0000\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1\u01c3"+
		"\u0003\u00a6S\u0000\u01c2\u01c1\u0001\u0000\u0000\u0000\u01c2\u01c3\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c5\u0001\u0000\u0000\u0000\u01c4\u01c6\u0005"+
		"u\u0000\u0000\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000"+
		"\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c8\u0003\u00a2"+
		"Q\u0000\u01c8\u001b\u0001\u0000\u0000\u0000\u01c9\u01ce\u0003\u001e\u000f"+
		"\u0000\u01ca\u01cb\u0005\u0085\u0000\u0000\u01cb\u01cd\u0003\u001e\u000f"+
		"\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000\u01cd\u01d0\u0001\u0000\u0000"+
		"\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000"+
		"\u0000\u01cf\u001d\u0001\u0000\u0000\u0000\u01d0\u01ce\u0001\u0000\u0000"+
		"\u0000\u01d1\u01e6\u0005Q\u0000\u0000\u01d2\u01e6\u0005R\u0000\u0000\u01d3"+
		"\u01e6\u0005n\u0000\u0000\u01d4\u01e6\u0005q\u0000\u0000\u01d5\u01e6\u0005"+
		"S\u0000\u0000\u01d6\u01e6\u0005j\u0000\u0000\u01d7\u01e6\u0005r\u0000"+
		"\u0000\u01d8\u01e6\u0005k\u0000\u0000\u01d9\u01e6\u0005o\u0000\u0000\u01da"+
		"\u01e6\u0005p\u0000\u0000\u01db\u01dc\u0005l\u0000\u0000\u01dc\u01dd\u0005"+
		"\u0089\u0000\u0000\u01dd\u01e6\u0003\u011e\u008f\u0000\u01de\u01df\u0005"+
		"m\u0000\u0000\u01df\u01e0\u0005\u0089\u0000\u0000\u01e0\u01e1\u0003\u011e"+
		"\u008f\u0000\u01e1\u01e2\u0005\u008f\u0000\u0000\u01e2\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e3\u01e6\u0003\u00aaU\u0000\u01e4\u01e6\u0003\u011e\u008f"+
		"\u0000\u01e5\u01d1\u0001\u0000\u0000\u0000\u01e5\u01d2\u0001\u0000\u0000"+
		"\u0000\u01e5\u01d3\u0001\u0000\u0000\u0000\u01e5\u01d4\u0001\u0000\u0000"+
		"\u0000\u01e5\u01d5\u0001\u0000\u0000\u0000\u01e5\u01d6\u0001\u0000\u0000"+
		"\u0000\u01e5\u01d7\u0001\u0000\u0000\u0000\u01e5\u01d8\u0001\u0000\u0000"+
		"\u0000\u01e5\u01d9\u0001\u0000\u0000\u0000\u01e5\u01da\u0001\u0000\u0000"+
		"\u0000\u01e5\u01db\u0001\u0000\u0000\u0000\u01e5\u01de\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e4\u0001\u0000\u0000"+
		"\u0000\u01e6\u001f\u0001\u0000\u0000\u0000\u01e7\u01e8\u0005\u008b\u0000"+
		"\u0000\u01e8\u01e9\u0003\u0018\f\u0000\u01e9\u01ea\u0005\u008a\u0000\u0000"+
		"\u01ea\u01f0\u0001\u0000\u0000\u0000\u01eb\u01ed\u0007\u0001\u0000\u0000"+
		"\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000"+
		"\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee\u01f0\u0003\u011e\u008f\u0000"+
		"\u01ef\u01e7\u0001\u0000\u0000\u0000\u01ef\u01ec\u0001\u0000\u0000\u0000"+
		"\u01f0!\u0001\u0000\u0000\u0000\u01f1\u01f5\u0005\u0080\u0000\u0000\u01f2"+
		"\u01f4\u0003$\u0012\u0000\u01f3\u01f2\u0001\u0000\u0000\u0000\u01f4\u01f7"+
		"\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6"+
		"\u0001\u0000\u0000\u0000\u01f6\u01f8\u0001\u0000\u0000\u0000\u01f7\u01f5"+
		"\u0001\u0000\u0000\u0000\u01f8\u01f9\u0005\u0081\u0000\u0000\u01f9#\u0001"+
		"\u0000\u0000\u0000\u01fa\u01fe\u0003&\u0013\u0000\u01fb\u01fd\u0003\u00a2"+
		"Q\u0000\u01fc\u01fb\u0001\u0000\u0000\u0000\u01fd\u0200\u0001\u0000\u0000"+
		"\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000"+
		"\u0000\u01ff\u0207\u0001\u0000\u0000\u0000\u0200\u01fe\u0001\u0000\u0000"+
		"\u0000\u0201\u0203\u0003\u00a2Q\u0000\u0202\u0201\u0001\u0000\u0000\u0000"+
		"\u0203\u0204\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000\u0000\u0000"+
		"\u0204\u0205\u0001\u0000\u0000\u0000\u0205\u0207\u0001\u0000\u0000\u0000"+
		"\u0206\u01fa\u0001\u0000\u0000\u0000\u0206\u0202\u0001\u0000\u0000\u0000"+
		"\u0207%\u0001\u0000\u0000\u0000\u0208\u0209\u0007\u0002\u0000\u0000\u0209"+
		"\'\u0001\u0000\u0000\u0000\u020a\u0210\u0003\u008aE\u0000\u020b\u0210"+
		"\u0003*\u0015\u0000\u020c\u0210\u0003,\u0016\u0000\u020d\u0210\u0003\u001a"+
		"\r\u0000\u020e\u0210\u0003x<\u0000\u020f\u020a\u0001\u0000\u0000\u0000"+
		"\u020f\u020b\u0001\u0000\u0000\u0000\u020f\u020c\u0001\u0000\u0000\u0000"+
		"\u020f\u020d\u0001\u0000\u0000\u0000\u020f\u020e\u0001\u0000\u0000\u0000"+
		"\u0210\u0211\u0001\u0000\u0000\u0000\u0211\u020f\u0001\u0000\u0000\u0000"+
		"\u0211\u0212\u0001\u0000\u0000\u0000\u0212)\u0001\u0000\u0000\u0000\u0213"+
		"\u0214\u0005\u0098\u0000\u0000\u0214\u0215\u0003.\u0017\u0000\u0215+\u0001"+
		"\u0000\u0000\u0000\u0216\u0217\u0005\u0099\u0000\u0000\u0217\u0218\u0003"+
		".\u0017\u0000\u0218-\u0001\u0000\u0000\u0000\u0219\u021b\u0003>\u001f"+
		"\u0000\u021a\u0219\u0001\u0000\u0000\u0000\u021a\u021b\u0001\u0000\u0000"+
		"\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c\u0221\u00038\u001c\u0000"+
		"\u021d\u0220\u0003\u00ccf\u0000\u021e\u0220\u0003\u009aM\u0000\u021f\u021d"+
		"\u0001\u0000\u0000\u0000\u021f\u021e\u0001\u0000\u0000\u0000\u0220\u0223"+
		"\u0001\u0000\u0000\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0221\u0222"+
		"\u0001\u0000\u0000\u0000\u0222\u0224\u0001\u0000\u0000\u0000\u0223\u0221"+
		"\u0001\u0000\u0000\u0000\u0224\u0225\u0005\u0084\u0000\u0000\u0225/\u0001"+
		"\u0000\u0000\u0000\u0226\u022c\u0003z=\u0000\u0227\u022c\u0003\u008aE"+
		"\u0000\u0228\u022c\u00032\u0019\u0000\u0229\u022c\u00034\u001a\u0000\u022a"+
		"\u022c\u0003@ \u0000\u022b\u0226\u0001\u0000\u0000\u0000\u022b\u0227\u0001"+
		"\u0000\u0000\u0000\u022b\u0228\u0001\u0000\u0000\u0000\u022b\u0229\u0001"+
		"\u0000\u0000\u0000\u022b\u022a\u0001\u0000\u0000\u0000\u022c\u022d\u0001"+
		"\u0000\u0000\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022d\u022e\u0001"+
		"\u0000\u0000\u0000\u022e1\u0001\u0000\u0000\u0000\u022f\u0230\u0005\u0098"+
		"\u0000\u0000\u0230\u0231\u00036\u001b\u0000\u02313\u0001\u0000\u0000\u0000"+
		"\u0232\u0233\u0005\u0099\u0000\u0000\u0233\u0234\u00036\u001b\u0000\u0234"+
		"5\u0001\u0000\u0000\u0000\u0235\u0237\u0003>\u001f\u0000\u0236\u0235\u0001"+
		"\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000\u0000\u0237\u0238\u0001"+
		"\u0000\u0000\u0000\u0238\u023a\u00038\u001c\u0000\u0239\u023b\u0003\u009c"+
		"N\u0000\u023a\u0239\u0001\u0000\u0000\u0000\u023a\u023b\u0001\u0000\u0000"+
		"\u0000\u023b\u023d\u0001\u0000\u0000\u0000\u023c\u023e\u0005\u0084\u0000"+
		"\u0000\u023d\u023c\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000\u0000"+
		"\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0240\u0003\u00e6s\u0000"+
		"\u02407\u0001\u0000\u0000\u0000\u0241\u024c\u0003<\u001e\u0000\u0242\u0244"+
		"\u0003:\u001d\u0000\u0243\u0242\u0001\u0000\u0000\u0000\u0244\u0245\u0001"+
		"\u0000\u0000\u0000\u0245\u0243\u0001\u0000\u0000\u0000\u0245\u0246\u0001"+
		"\u0000\u0000\u0000\u0246\u0249\u0001\u0000\u0000\u0000\u0247\u0248\u0005"+
		"\u0085\u0000\u0000\u0248\u024a\u0005\u00aa\u0000\u0000\u0249\u0247\u0001"+
		"\u0000\u0000\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024c\u0001"+
		"\u0000\u0000\u0000\u024b\u0241\u0001\u0000\u0000\u0000\u024b\u0243\u0001"+
		"\u0000\u0000\u0000\u024c9\u0001\u0000\u0000\u0000\u024d\u024f\u0003<\u001e"+
		"\u0000\u024e\u024d\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000"+
		"\u0000\u024f\u0250\u0001\u0000\u0000\u0000\u0250\u0254\u0005\u008f\u0000"+
		"\u0000\u0251\u0253\u0003>\u001f\u0000\u0252\u0251\u0001\u0000\u0000\u0000"+
		"\u0253\u0256\u0001\u0000\u0000\u0000\u0254\u0252\u0001\u0000\u0000\u0000"+
		"\u0254\u0255\u0001\u0000\u0000\u0000\u0255\u0258\u0001\u0000\u0000\u0000"+
		"\u0256\u0254\u0001\u0000\u0000\u0000\u0257\u0259\u0003\u00a8T\u0000\u0258"+
		"\u0257\u0001\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259"+
		"\u025a\u0001\u0000\u0000\u0000\u025a\u025b\u0003\u011e\u008f\u0000\u025b"+
		";\u0001\u0000\u0000\u0000\u025c\u025f\u0003\u011e\u008f\u0000\u025d\u025f"+
		"\u0005\u0016\u0000\u0000\u025e\u025c\u0001\u0000\u0000\u0000\u025e\u025d"+
		"\u0001\u0000\u0000\u0000\u025f=\u0001\u0000\u0000\u0000\u0260\u0261\u0005"+
		"~\u0000\u0000\u0261\u0262\u0003\u00d4j\u0000\u0262\u0263\u0005\u007f\u0000"+
		"\u0000\u0263?\u0001\u0000\u0000\u0000\u0264\u0265\u0005N\u0000\u0000\u0265"+
		"\u0266\u0003B!\u0000\u0266\u0267\u0005\u0084\u0000\u0000\u0267\u026d\u0001"+
		"\u0000\u0000\u0000\u0268\u0269\u0005=\u0000\u0000\u0269\u026a\u0003B!"+
		"\u0000\u026a\u026b\u0005\u0084\u0000\u0000\u026b\u026d\u0001\u0000\u0000"+
		"\u0000\u026c\u0264\u0001\u0000\u0000\u0000\u026c\u0268\u0001\u0000\u0000"+
		"\u0000\u026dA\u0001\u0000\u0000\u0000\u026e\u0273\u0003D\"\u0000\u026f"+
		"\u0270\u0005\u0085\u0000\u0000\u0270\u0272\u0003D\"\u0000\u0271\u026f"+
		"\u0001\u0000\u0000\u0000\u0272\u0275\u0001\u0000\u0000\u0000\u0273\u0271"+
		"\u0001\u0000\u0000\u0000\u0273\u0274\u0001\u0000\u0000\u0000\u0274C\u0001"+
		"\u0000\u0000\u0000\u0275\u0273\u0001\u0000\u0000\u0000\u0276\u0279\u0003"+
		"\u011e\u008f\u0000\u0277\u0278\u0005\u0089\u0000\u0000\u0278\u027a\u0003"+
		"\u011e\u008f\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u0279\u027a\u0001"+
		"\u0000\u0000\u0000\u027aE\u0001\u0000\u0000\u0000\u027b\u027d\u0003\u00aa"+
		"U\u0000\u027c\u027b\u0001\u0000\u0000\u0000\u027c\u027d\u0001\u0000\u0000"+
		"\u0000\u027d\u027e\u0001\u0000\u0000\u0000\u027e\u0280\u0003\u00b4Z\u0000"+
		"\u027f\u0281\u0003\u00aaU\u0000\u0280\u027f\u0001\u0000\u0000\u0000\u0280"+
		"\u0281\u0001\u0000\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000\u0282"+
		"\u0283\u0005~\u0000\u0000\u0283\u0286\u0005\u009e\u0000\u0000\u0284\u0287"+
		"\u0003\u00aaU\u0000\u0285\u0287\u0003\u00b4Z\u0000\u0286\u0284\u0001\u0000"+
		"\u0000\u0000\u0286\u0285\u0001\u0000\u0000\u0000\u0286\u0287\u0001\u0000"+
		"\u0000\u0000\u0287\u0288\u0001\u0000\u0000\u0000\u0288\u028a\u0005\u007f"+
		"\u0000\u0000\u0289\u028b\u0003T*\u0000\u028a\u0289\u0001\u0000\u0000\u0000"+
		"\u028a\u028b\u0001\u0000\u0000\u0000\u028bG\u0001\u0000\u0000\u0000\u028c"+
		"\u0295\u0005\u008b\u0000\u0000\u028d\u0292\u0003J%\u0000\u028e\u028f\u0005"+
		"\u0085\u0000\u0000\u028f\u0291\u0003J%\u0000\u0290\u028e\u0001\u0000\u0000"+
		"\u0000\u0291\u0294\u0001\u0000\u0000\u0000\u0292\u0290\u0001\u0000\u0000"+
		"\u0000\u0292\u0293\u0001\u0000\u0000\u0000\u0293\u0296\u0001\u0000\u0000"+
		"\u0000\u0294\u0292\u0001\u0000\u0000\u0000\u0295\u028d\u0001\u0000\u0000"+
		"\u0000\u0295\u0296\u0001\u0000\u0000\u0000\u0296\u0297\u0001\u0000\u0000"+
		"\u0000\u0297\u0298\u0005\u008a\u0000\u0000\u0298I\u0001\u0000\u0000\u0000"+
		"\u0299\u029b\u0003\u00aeW\u0000\u029a\u0299\u0001\u0000\u0000\u0000\u029b"+
		"\u029e\u0001\u0000\u0000\u0000\u029c\u029a\u0001\u0000\u0000\u0000\u029c"+
		"\u029d\u0001\u0000\u0000\u0000\u029d\u029f\u0001\u0000\u0000\u0000\u029e"+
		"\u029c\u0001\u0000\u0000\u0000\u029f\u02a2\u0003\u00b4Z\u0000\u02a0\u02a2"+
		"\u0003\u00d4j\u0000\u02a1\u029c\u0001\u0000\u0000\u0000\u02a1\u02a0\u0001"+
		"\u0000\u0000\u0000\u02a2K\u0001\u0000\u0000\u0000\u02a3\u02a4\u0005\u0088"+
		"\u0000\u0000\u02a4\u02b0\u0005\u0080\u0000\u0000\u02a5\u02aa\u0003N\'"+
		"\u0000\u02a6\u02a7\u0005\u0085\u0000\u0000\u02a7\u02a9\u0003N\'\u0000"+
		"\u02a8\u02a6\u0001\u0000\u0000\u0000\u02a9\u02ac\u0001\u0000\u0000\u0000"+
		"\u02aa\u02a8\u0001\u0000\u0000\u0000\u02aa\u02ab\u0001\u0000\u0000\u0000"+
		"\u02ab\u02ae\u0001\u0000\u0000\u0000\u02ac\u02aa\u0001\u0000\u0000\u0000"+
		"\u02ad\u02af\u0005\u0085\u0000\u0000\u02ae\u02ad\u0001\u0000\u0000\u0000"+
		"\u02ae\u02af\u0001\u0000\u0000\u0000\u02af\u02b1\u0001\u0000\u0000\u0000"+
		"\u02b0\u02a5\u0001\u0000\u0000\u0000\u02b0\u02b1\u0001\u0000\u0000\u0000"+
		"\u02b1\u02b2\u0001\u0000\u0000\u0000\u02b2\u02b3\u0005\u0081\u0000\u0000"+
		"\u02b3M\u0001\u0000\u0000\u0000\u02b4\u02b5\u0003\u0106\u0083\u0000\u02b5"+
		"\u02b6\u0005\u008f\u0000\u0000\u02b6\u02b7\u0003\u0102\u0081\u0000\u02b7"+
		"O\u0001\u0000\u0000\u0000\u02b8\u02b9\u0005\u0088\u0000\u0000\u02b9\u02be"+
		"\u0005\u0082\u0000\u0000\u02ba\u02bc\u0003\u0100\u0080\u0000\u02bb\u02bd"+
		"\u0005\u0085\u0000\u0000\u02bc\u02bb\u0001\u0000\u0000\u0000\u02bc\u02bd"+
		"\u0001\u0000\u0000\u0000\u02bd\u02bf\u0001\u0000\u0000\u0000\u02be\u02ba"+
		"\u0001\u0000\u0000\u0000\u02be\u02bf\u0001\u0000\u0000\u0000\u02bf\u02c0"+
		"\u0001\u0000\u0000\u0000\u02c0\u02c1\u0005\u0083\u0000\u0000\u02c1Q\u0001"+
		"\u0000\u0000\u0000\u02c2\u02c3\u0005\u0088\u0000\u0000\u02c3\u02c4\u0005"+
		"~\u0000\u0000\u02c4\u02c5\u0003\u0102\u0081\u0000\u02c5\u02c6\u0005\u007f"+
		"\u0000\u0000\u02c6\u02cd\u0001\u0000\u0000\u0000\u02c7\u02ca\u0005\u0088"+
		"\u0000\u0000\u02c8\u02cb\u0003\u011a\u008d\u0000\u02c9\u02cb\u0003\u011e"+
		"\u008f\u0000\u02ca\u02c8\u0001\u0000\u0000\u0000\u02ca\u02c9\u0001\u0000"+
		"\u0000\u0000\u02cb\u02cd\u0001\u0000\u0000\u0000\u02cc\u02c2\u0001\u0000"+
		"\u0000\u0000\u02cc\u02c7\u0001\u0000\u0000\u0000\u02cdS\u0001\u0000\u0000"+
		"\u0000\u02ce\u02da\u0005~\u0000\u0000\u02cf\u02d2\u0003V+\u0000\u02d0"+
		"\u02d2\u0005 \u0000\u0000\u02d1\u02cf\u0001\u0000\u0000\u0000\u02d1\u02d0"+
		"\u0001\u0000\u0000\u0000\u02d2\u02d7\u0001\u0000\u0000\u0000\u02d3\u02d4"+
		"\u0005\u0085\u0000\u0000\u02d4\u02d6\u0003V+\u0000\u02d5\u02d3\u0001\u0000"+
		"\u0000\u0000\u02d6\u02d9\u0001\u0000\u0000\u0000\u02d7\u02d5\u0001\u0000"+
		"\u0000\u0000\u02d7\u02d8\u0001\u0000\u0000\u0000\u02d8\u02db\u0001\u0000"+
		"\u0000\u0000\u02d9\u02d7\u0001\u0000\u0000\u0000\u02da\u02d1\u0001\u0000"+
		"\u0000\u0000\u02da\u02db\u0001\u0000\u0000\u0000\u02db\u02dc\u0001\u0000"+
		"\u0000\u0000\u02dc\u02dd\u0005\u007f\u0000\u0000\u02ddU\u0001\u0000\u0000"+
		"\u0000\u02de\u02e1\u0003l6\u0000\u02df\u02e1\u0003\u00d4j\u0000\u02e0"+
		"\u02de\u0001\u0000\u0000\u0000\u02e0\u02df\u0001\u0000\u0000\u0000\u02e1"+
		"W\u0001\u0000\u0000\u0000\u02e2\u02e4\u0005\u009e\u0000\u0000\u02e3\u02e5"+
		"\u0003\u00b4Z\u0000\u02e4\u02e3\u0001\u0000\u0000\u0000\u02e4\u02e5\u0001"+
		"\u0000\u0000\u0000\u02e5\u02e7\u0001\u0000\u0000\u0000\u02e6\u02e8\u0003"+
		"\u00aaU\u0000\u02e7\u02e6\u0001\u0000\u0000\u0000\u02e7\u02e8\u0001\u0000"+
		"\u0000\u0000\u02e8\u02ea\u0001\u0000\u0000\u0000\u02e9\u02eb\u0003T*\u0000"+
		"\u02ea\u02e9\u0001\u0000\u0000\u0000\u02ea\u02eb\u0001\u0000\u0000\u0000"+
		"\u02eb\u02ec\u0001\u0000\u0000\u0000\u02ec\u02ed\u0003\u00e6s\u0000\u02ed"+
		"Y\u0001\u0000\u0000\u0000\u02ee\u02ef\u0005\u0082\u0000\u0000\u02ef\u02f0"+
		"\u0003\\.\u0000\u02f0\u02f1\u0003^/\u0000\u02f1\u02f2\u0005\u0083\u0000"+
		"\u0000\u02f2[\u0001\u0000\u0000\u0000\u02f3\u02f6\u0003\u0102\u0081\u0000"+
		"\u02f4\u02f6\u0003\u00b4Z\u0000\u02f5\u02f3\u0001\u0000\u0000\u0000\u02f5"+
		"\u02f4\u0001\u0000\u0000\u0000\u02f6]\u0001\u0000\u0000\u0000\u02f7\u02fe"+
		"\u0003<\u001e\u0000\u02f8\u02fa\u0003`0\u0000\u02f9\u02f8\u0001\u0000"+
		"\u0000\u0000\u02fa\u02fb\u0001\u0000\u0000\u0000\u02fb\u02f9\u0001\u0000"+
		"\u0000\u0000\u02fb\u02fc\u0001\u0000\u0000\u0000\u02fc\u02fe\u0001\u0000"+
		"\u0000\u0000\u02fd\u02f7\u0001\u0000\u0000\u0000\u02fd\u02f9\u0001\u0000"+
		"\u0000\u0000\u02fe_\u0001\u0000\u0000\u0000\u02ff\u0301\u0003<\u001e\u0000"+
		"\u0300\u02ff\u0001\u0000\u0000\u0000\u0300\u0301\u0001\u0000\u0000\u0000"+
		"\u0301\u0302\u0001\u0000\u0000\u0000\u0302\u0303\u0005\u008f\u0000\u0000"+
		"\u0303\u0308\u0003b1\u0000\u0304\u0305\u0005\u0085\u0000\u0000\u0305\u0307"+
		"\u0003b1\u0000\u0306\u0304\u0001\u0000\u0000\u0000\u0307\u030a\u0001\u0000"+
		"\u0000\u0000\u0308\u0306\u0001\u0000\u0000\u0000\u0308\u0309\u0001\u0000"+
		"\u0000\u0000\u0309a\u0001\u0000\u0000\u0000\u030a\u0308\u0001\u0000\u0000"+
		"\u0000\u030b\u030d\u0003\u0100\u0080\u0000\u030c\u030e\u0003\u00aaU\u0000"+
		"\u030d\u030c\u0001\u0000\u0000\u0000\u030d\u030e\u0001\u0000\u0000\u0000"+
		"\u030e\u0313\u0001\u0000\u0000\u0000\u030f\u0310\u0005\u0080\u0000\u0000"+
		"\u0310\u0311\u0003\u00d2i\u0000\u0311\u0312\u0005\u0081\u0000\u0000\u0312"+
		"\u0314\u0001\u0000\u0000\u0000\u0313\u030f\u0001\u0000\u0000\u0000\u0313"+
		"\u0314\u0001\u0000\u0000\u0000\u0314c\u0001\u0000\u0000\u0000\u0315\u0316"+
		"\u0005L\u0000\u0000\u0316\u0317\u0005~\u0000\u0000\u0317\u0318\u0003f"+
		"3\u0000\u0318\u0319\u0005\u007f\u0000\u0000\u0319e\u0001\u0000\u0000\u0000"+
		"\u031a\u0324\u0003<\u001e\u0000\u031b\u031d\u0003<\u001e\u0000\u031c\u031b"+
		"\u0001\u0000\u0000\u0000\u031c\u031d\u0001\u0000\u0000\u0000\u031d\u031e"+
		"\u0001\u0000\u0000\u0000\u031e\u0320\u0005\u008f\u0000\u0000\u031f\u031c"+
		"\u0001\u0000\u0000\u0000\u0320\u0321\u0001\u0000\u0000\u0000\u0321\u031f"+
		"\u0001\u0000\u0000\u0000\u0321\u0322\u0001\u0000\u0000\u0000\u0322\u0324"+
		"\u0001\u0000\u0000\u0000\u0323\u031a\u0001\u0000\u0000\u0000\u0323\u031f"+
		"\u0001\u0000\u0000\u0000\u0324g\u0001\u0000\u0000\u0000\u0325\u0326\u0005"+
		"E\u0000\u0000\u0326\u0327\u0005~\u0000\u0000\u0327\u0328\u0003 \u0010"+
		"\u0000\u0328\u0329\u0005\u007f\u0000\u0000\u0329i\u0001\u0000\u0000\u0000"+
		"\u032a\u032b\u0005>\u0000\u0000\u032b\u032c\u0005~\u0000\u0000\u032c\u032d"+
		"\u0003\u00d4j\u0000\u032d\u032e\u0005\u007f\u0000\u0000\u032ek\u0001\u0000"+
		"\u0000\u0000\u032f\u0330\u0003\u0098L\u0000\u0330\u0331\u0003\u00deo\u0000"+
		"\u0331m\u0001\u0000\u0000\u0000\u0332\u0333\u0005O\u0000\u0000\u0333\u0334"+
		"\u0005~\u0000\u0000\u0334\u0335\u0003\u011e\u008f\u0000\u0335\u0336\u0005"+
		"\u007f\u0000\u0000\u0336\u033a\u0001\u0000\u0000\u0000\u0337\u0338\u0005"+
		"O\u0000\u0000\u0338\u033a\u0003\u0102\u0081\u0000\u0339\u0332\u0001\u0000"+
		"\u0000\u0000\u0339\u0337\u0001\u0000\u0000\u0000\u033ao\u0001\u0000\u0000"+
		"\u0000\u033b\u033c\u0005P\u0000\u0000\u033c\u0340\u0003\u00e6s\u0000\u033d"+
		"\u033f\u0003r9\u0000\u033e\u033d\u0001\u0000\u0000\u0000\u033f\u0342\u0001"+
		"\u0000\u0000\u0000\u0340\u033e\u0001\u0000\u0000\u0000\u0340\u0341\u0001"+
		"\u0000\u0000\u0000\u0341\u0345\u0001\u0000\u0000\u0000\u0342\u0340\u0001"+
		"\u0000\u0000\u0000\u0343\u0344\u0005@\u0000\u0000\u0344\u0346\u0003\u00e6"+
		"s\u0000\u0345\u0343\u0001\u0000\u0000\u0000\u0345\u0346\u0001\u0000\u0000"+
		"\u0000\u0346q\u0001\u0000\u0000\u0000\u0347\u0348\u0005;\u0000\u0000\u0348"+
		"\u0349\u0005~\u0000\u0000\u0349\u034a\u0003l6\u0000\u034a\u034b\u0005"+
		"\u007f\u0000\u0000\u034b\u034c\u0003\u00e6s\u0000\u034cs\u0001\u0000\u0000"+
		"\u0000\u034d\u034e\u0005M\u0000\u0000\u034e\u034f\u0005~\u0000\u0000\u034f"+
		"\u0350\u0003\u0102\u0081\u0000\u0350\u0351\u0005\u007f\u0000\u0000\u0351"+
		"\u0352\u0003\u00e6s\u0000\u0352u\u0001\u0000\u0000\u0000\u0353\u0354\u0005"+
		":\u0000\u0000\u0354\u0355\u0003\u00e6s\u0000\u0355w\u0001\u0000\u0000"+
		"\u0000\u0356\u0357\u0003|>\u0000\u0357\u0358\u0005\u0084\u0000\u0000\u0358"+
		"y\u0001\u0000\u0000\u0000\u0359\u035a\u0003|>\u0000\u035a\u035b\u0003"+
		"\u00e6s\u0000\u035b{\u0001\u0000\u0000\u0000\u035c\u035e\u0003\u0098L"+
		"\u0000\u035d\u035c\u0001\u0000\u0000\u0000\u035d\u035e\u0001\u0000\u0000"+
		"\u0000\u035e\u035f\u0001\u0000\u0000\u0000\u035f\u0360\u0003\u011e\u008f"+
		"\u0000\u0360\u0362\u0005~\u0000\u0000\u0361\u0363\u0003\u00c8d\u0000\u0362"+
		"\u0361\u0001\u0000\u0000\u0000\u0362\u0363\u0001\u0000\u0000\u0000\u0363"+
		"\u0364\u0001\u0000\u0000\u0000\u0364\u0365\u0005\u007f\u0000\u0000\u0365"+
		"\u0367\u0001\u0000\u0000\u0000\u0366\u0368\u0003\u009aM\u0000\u0367\u0366"+
		"\u0001\u0000\u0000\u0000\u0367\u0368\u0001\u0000\u0000\u0000\u0368}\u0001"+
		"\u0000\u0000\u0000\u0369\u036b\u0003\u0080@\u0000\u036a\u036c\u0003\u0082"+
		"A\u0000\u036b\u036a\u0001\u0000\u0000\u0000\u036b\u036c\u0001\u0000\u0000"+
		"\u0000\u036c\u007f\u0001\u0000\u0000\u0000\u036d\u0370\u0005\u0005\u0000"+
		"\u0000\u036e\u0370\u0003\u011e\u008f\u0000\u036f\u036d\u0001\u0000\u0000"+
		"\u0000\u036f\u036e\u0001\u0000\u0000\u0000\u0370\u0081\u0001\u0000\u0000"+
		"\u0000\u0371\u0373\u0005~\u0000\u0000\u0372\u0374\u0003\u0084B\u0000\u0373"+
		"\u0372\u0001\u0000\u0000\u0000\u0373\u0374\u0001\u0000\u0000\u0000\u0374"+
		"\u0375\u0001\u0000\u0000\u0000\u0375\u0376\u0005\u007f\u0000\u0000\u0376"+
		"\u0083\u0001\u0000\u0000\u0000\u0377\u037c\u0003\u0086C\u0000\u0378\u0379"+
		"\u0005\u0085\u0000\u0000\u0379\u037b\u0003\u0086C\u0000\u037a\u0378\u0001"+
		"\u0000\u0000\u0000\u037b\u037e\u0001\u0000\u0000\u0000\u037c\u037a\u0001"+
		"\u0000\u0000\u0000\u037c\u037d\u0001\u0000\u0000\u0000\u037d\u0085\u0001"+
		"\u0000\u0000\u0000\u037e\u037c\u0001\u0000\u0000\u0000\u037f\u0384\u0003"+
		"~?\u0000\u0380\u0384\u0003\u011a\u008d\u0000\u0381\u0384\u0003\u011c\u008e"+
		"\u0000\u0382\u0384\u0003\u0088D\u0000\u0383\u037f\u0001\u0000\u0000\u0000"+
		"\u0383\u0380\u0001\u0000\u0000\u0000\u0383\u0381\u0001\u0000\u0000\u0000"+
		"\u0383\u0382\u0001\u0000\u0000\u0000\u0384\u0087\u0001\u0000\u0000\u0000"+
		"\u0385\u0386\u0003\u0080@\u0000\u0386\u038a\u0005\u0089\u0000\u0000\u0387"+
		"\u038b\u0003\u011a\u008d\u0000\u0388\u038b\u0003\u0080@\u0000\u0389\u038b"+
		"\u0003\u011c\u008e\u0000\u038a\u0387\u0001\u0000\u0000\u0000\u038a\u0388"+
		"\u0001\u0000\u0000\u0000\u038a\u0389\u0001\u0000\u0000\u0000\u038b\u0089"+
		"\u0001\u0000\u0000\u0000\u038c\u0391\u0003\u008cF\u0000\u038d\u0391\u0003"+
		"\u008eG\u0000\u038e\u0391\u0003\u0090H\u0000\u038f\u0391\u0003\u0092I"+
		"\u0000\u0390\u038c\u0001\u0000\u0000\u0000\u0390\u038d\u0001\u0000\u0000"+
		"\u0000\u0390\u038e\u0001\u0000\u0000\u0000\u0390\u038f\u0001\u0000\u0000"+
		"\u0000\u0391\u008b\u0001\u0000\u0000\u0000\u0392\u0394\u0003\u009aM\u0000"+
		"\u0393\u0392\u0001\u0000\u0000\u0000\u0393\u0394\u0001\u0000\u0000\u0000"+
		"\u0394\u0395\u0001\u0000\u0000\u0000\u0395\u0397\u0003\u011e\u008f\u0000"+
		"\u0396\u0398\u0003\u009aM\u0000\u0397\u0396\u0001\u0000\u0000\u0000\u0397"+
		"\u0398\u0001\u0000\u0000\u0000\u0398\u0399\u0001\u0000\u0000\u0000\u0399"+
		"\u039a\u0005~\u0000\u0000\u039a\u039b\u0003\u00c4b\u0000\u039b\u039c\u0005"+
		"\u007f\u0000\u0000\u039c\u039d\u0005\u0084\u0000\u0000\u039d\u008d\u0001"+
		"\u0000\u0000\u0000\u039e\u03a0\u0003\u009aM\u0000\u039f\u039e\u0001\u0000"+
		"\u0000\u0000\u039f\u03a0\u0001\u0000\u0000\u0000\u03a0\u03a2\u0001\u0000"+
		"\u0000\u0000\u03a1\u03a3\u0005\u001d\u0000\u0000\u03a2\u03a1\u0001\u0000"+
		"\u0000\u0000\u03a2\u03a3\u0001\u0000\u0000\u0000\u03a3\u03a4\u0001\u0000"+
		"\u0000\u0000\u03a4\u03a6\u0003\u00bc^\u0000\u03a5\u03a7\u0003\u011e\u008f"+
		"\u0000\u03a6\u03a5\u0001\u0000\u0000\u0000\u03a6\u03a7\u0001\u0000\u0000"+
		"\u0000\u03a7\u03a8\u0001\u0000\u0000\u0000\u03a8\u03a9\u0005\u0084\u0000"+
		"\u0000\u03a9\u008f\u0001\u0000\u0000\u0000\u03aa\u03ab\u0003\u0098L\u0000"+
		"\u03ab\u03ac\u0003\u009cN\u0000\u03ac\u03af\u0001\u0000\u0000\u0000\u03ad"+
		"\u03af\u0003\u0098L\u0000\u03ae\u03aa\u0001\u0000\u0000\u0000\u03ae\u03ad"+
		"\u0001\u0000\u0000\u0000\u03af\u03b0\u0001\u0000\u0000\u0000\u03b0\u03b1"+
		"\u0005\u0084\u0000\u0000\u03b1\u0091\u0001\u0000\u0000\u0000\u03b2\u03b4"+
		"\u0003\u009aM\u0000\u03b3\u03b2\u0001\u0000\u0000\u0000\u03b3\u03b4\u0001"+
		"\u0000\u0000\u0000\u03b4\u03b5\u0001\u0000\u0000\u0000\u03b5\u03ba\u0005"+
		"\u001d\u0000\u0000\u03b6\u03b7\u0003\u0098L\u0000\u03b7\u03b8\u0003\u0094"+
		"J\u0000\u03b8\u03bb\u0001\u0000\u0000\u0000\u03b9\u03bb\u0003\u0098L\u0000"+
		"\u03ba\u03b6\u0001\u0000\u0000\u0000\u03ba\u03b9\u0001\u0000\u0000\u0000"+
		"\u03bb\u03bc\u0001\u0000\u0000\u0000\u03bc\u03bd\u0005\u0084\u0000\u0000"+
		"\u03bd\u0093\u0001\u0000\u0000\u0000\u03be\u03c3\u0003\u0096K\u0000\u03bf"+
		"\u03c0\u0005\u0085\u0000\u0000\u03c0\u03c2\u0003\u0096K\u0000\u03c1\u03bf"+
		"\u0001\u0000\u0000\u0000\u03c2\u03c5\u0001\u0000\u0000\u0000\u03c3\u03c1"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c4\u0001\u0000\u0000\u0000\u03c4\u0095"+
		"\u0001\u0000\u0000\u0000\u03c5\u03c3\u0001\u0000\u0000\u0000\u03c6\u03c8"+
		"\u0003\u00cae\u0000\u03c7\u03c6\u0001\u0000\u0000\u0000\u03c7\u03c8\u0001"+
		"\u0000\u0000\u0000\u03c8\u03c9\u0001\u0000\u0000\u0000\u03c9\u03ca\u0003"+
		"\u00c4b\u0000\u03ca\u0097\u0001\u0000\u0000\u0000\u03cb\u03d4\u0003\u00ac"+
		"V\u0000\u03cc\u03d4\u0003\u009aM\u0000\u03cd\u03d4\u0003\u00a8T\u0000"+
		"\u03ce\u03d4\u0003\u00aaU\u0000\u03cf\u03d4\u0003\u00a6S\u0000\u03d0\u03d4"+
		"\u0003\u00aeW\u0000\u03d1\u03d4\u0003\u00b0X\u0000\u03d2\u03d4\u0003\u00b4"+
		"Z\u0000\u03d3\u03cb\u0001\u0000\u0000\u0000\u03d3\u03cc\u0001\u0000\u0000"+
		"\u0000\u03d3\u03cd\u0001\u0000\u0000\u0000\u03d3\u03ce\u0001\u0000\u0000"+
		"\u0000\u03d3\u03cf\u0001\u0000\u0000\u0000\u03d3\u03d0\u0001\u0000\u0000"+
		"\u0000\u03d3\u03d1\u0001\u0000\u0000\u0000\u03d3\u03d2\u0001\u0000\u0000"+
		"\u0000\u03d4\u03d5\u0001\u0000\u0000\u0000\u03d5\u03d3\u0001\u0000\u0000"+
		"\u0000\u03d5\u03d6\u0001\u0000\u0000\u0000\u03d6\u0099\u0001\u0000\u0000"+
		"\u0000\u03d7\u03d8\u0005T\u0000\u0000\u03d8\u03d9\u0005~\u0000\u0000\u03d9"+
		"\u03da\u0005~\u0000\u0000\u03da\u03df\u0003~?\u0000\u03db\u03dc\u0005"+
		"\u0085\u0000\u0000\u03dc\u03de\u0003~?\u0000\u03dd\u03db\u0001\u0000\u0000"+
		"\u0000\u03de\u03e1\u0001\u0000\u0000\u0000\u03df\u03dd\u0001\u0000\u0000"+
		"\u0000\u03df\u03e0\u0001\u0000\u0000\u0000\u03e0\u03e2\u0001\u0000\u0000"+
		"\u0000\u03e1\u03df\u0001\u0000\u0000\u0000\u03e2\u03e3\u0005\u007f\u0000"+
		"\u0000\u03e3\u03e4\u0005\u007f\u0000\u0000\u03e4\u009b\u0001\u0000\u0000"+
		"\u0000\u03e5\u03ea\u0003\u009eO\u0000\u03e6\u03e7\u0005\u0085\u0000\u0000"+
		"\u03e7\u03e9\u0003\u009eO\u0000\u03e8\u03e6\u0001\u0000\u0000\u0000\u03e9"+
		"\u03ec\u0001\u0000\u0000\u0000\u03ea\u03e8\u0001\u0000\u0000\u0000\u03ea"+
		"\u03eb\u0001\u0000\u0000\u0000\u03eb\u009d\u0001\u0000\u0000\u0000\u03ec"+
		"\u03ea\u0001\u0000\u0000\u0000\u03ed\u03f0\u0003\u00deo\u0000\u03ee\u03ef"+
		"\u0005\u0089\u0000\u0000\u03ef\u03f1\u0003\u0108\u0084\u0000\u03f0\u03ee"+
		"\u0001\u0000\u0000\u0000\u03f0\u03f1\u0001\u0000\u0000\u0000\u03f1\u009f"+
		"\u0001\u0000\u0000\u0000\u03f2\u03ff\u0007\u0003\u0000\u0000\u03f3\u0400"+
		"\u0003\u011e\u008f\u0000\u03f4\u03f6\u0003\u011e\u008f\u0000\u03f5\u03f4"+
		"\u0001\u0000\u0000\u0000\u03f5\u03f6\u0001\u0000\u0000\u0000\u03f6\u03f7"+
		"\u0001\u0000\u0000\u0000\u03f7\u03f9\u0005\u0080\u0000\u0000\u03f8\u03fa"+
		"\u0003\u00a2Q\u0000\u03f9\u03f8\u0001\u0000\u0000\u0000\u03fa\u03fb\u0001"+
		"\u0000\u0000\u0000\u03fb\u03f9\u0001\u0000\u0000\u0000\u03fb\u03fc\u0001"+
		"\u0000\u0000\u0000\u03fc\u03fd\u0001\u0000\u0000\u0000\u03fd\u03fe\u0005"+
		"\u0081\u0000\u0000\u03fe\u0400\u0001\u0000\u0000\u0000\u03ff\u03f3\u0001"+
		"\u0000\u0000\u0000\u03ff\u03f5\u0001\u0000\u0000\u0000\u0400\u00a1\u0001"+
		"\u0000\u0000\u0000\u0401\u0402\u0003\u00a4R\u0000\u0402\u0407\u0003\u00b8"+
		"\\\u0000\u0403\u0406\u0003\u00ccf\u0000\u0404\u0406\u0003\u009aM\u0000"+
		"\u0405\u0403\u0001\u0000\u0000\u0000\u0405\u0404\u0001\u0000\u0000\u0000"+
		"\u0406\u0409\u0001\u0000\u0000\u0000\u0407\u0405\u0001\u0000\u0000\u0000"+
		"\u0407\u0408\u0001\u0000\u0000\u0000\u0408\u040a\u0001\u0000\u0000\u0000"+
		"\u0409\u0407\u0001\u0000\u0000\u0000\u040a\u040b\u0005\u0084\u0000\u0000"+
		"\u040b\u00a3\u0001\u0000\u0000\u0000\u040c\u0413\u0003\u00a8T\u0000\u040d"+
		"\u0413\u0003\u00aaU\u0000\u040e\u0413\u0003\u00a6S\u0000\u040f\u0413\u0003"+
		"\u00aeW\u0000\u0410\u0413\u0003\u00b0X\u0000\u0411\u0413\u0003\u00b4Z"+
		"\u0000\u0412\u040c\u0001\u0000\u0000\u0000\u0412\u040d\u0001\u0000\u0000"+
		"\u0000\u0412\u040e\u0001\u0000\u0000\u0000\u0412\u040f\u0001\u0000\u0000"+
		"\u0000\u0412\u0410\u0001\u0000\u0000\u0000\u0412\u0411\u0001\u0000\u0000"+
		"\u0000\u0413\u0414\u0001\u0000\u0000\u0000\u0414\u0412\u0001\u0000\u0000"+
		"\u0000\u0414\u0415\u0001\u0000\u0000\u0000\u0415\u00a5\u0001\u0000\u0000"+
		"\u0000\u0416\u0417\u0005t\u0000\u0000\u0417\u0418\u0005~\u0000\u0000\u0418"+
		"\u0419\u0003\u011e\u008f\u0000\u0419\u041a\u0005\u007f\u0000\u0000\u041a"+
		"\u041d\u0001\u0000\u0000\u0000\u041b\u041d\u0005s\u0000\u0000\u041c\u0416"+
		"\u0001\u0000\u0000\u0000\u041c\u041b\u0001\u0000\u0000\u0000\u041d\u00a7"+
		"\u0001\u0000\u0000\u0000\u041e\u041f\u0007\u0004\u0000\u0000\u041f\u00a9"+
		"\u0001\u0000\u0000\u0000\u0420\u0421\u0007\u0005\u0000\u0000\u0421\u00ab"+
		"\u0001\u0000\u0000\u0000\u0422\u0423\u0007\u0006\u0000\u0000\u0423\u00ad"+
		"\u0001\u0000\u0000\u0000\u0424\u0425\u0007\u0007\u0000\u0000\u0425\u00af"+
		"\u0001\u0000\u0000\u0000\u0426\u042b\u0005\u0005\u0000\u0000\u0427\u042b"+
		"\u0005!\u0000\u0000\u0428\u042b\u0005\u0015\u0000\u0000\u0429\u042b\u0003"+
		"\u00b2Y\u0000\u042a\u0426\u0001\u0000\u0000\u0000\u042a\u0427\u0001\u0000"+
		"\u0000\u0000\u042a\u0428\u0001\u0000\u0000\u0000\u042a\u0429\u0001\u0000"+
		"\u0000\u0000\u042b\u00b1\u0001\u0000\u0000\u0000\u042c\u042d\u0007\b\u0000"+
		"\u0000\u042d\u00b3\u0001\u0000\u0000\u0000\u042e\u0440\u0005 \u0000\u0000"+
		"\u042f\u0440\u0005\u0004\u0000\u0000\u0430\u0440\u0005\u0017\u0000\u0000"+
		"\u0431\u0440\u0005\u0012\u0000\u0000\u0432\u0440\u0005\u0013\u0000\u0000"+
		"\u0433\u0440\u0005\r\u0000\u0000\u0434\u0440\u0005\t\u0000\u0000\u0435"+
		"\u0440\u0005\u0018\u0000\u0000\u0436\u0440\u0005\u001f\u0000\u0000\u0437"+
		"\u0440\u0003\u00b6[\u0000\u0438\u0440\u0003\u000e\u0007\u0000\u0439\u0440"+
		"\u0003\u00a0P\u0000\u043a\u0440\u0003\u00bc^\u0000\u043b\u043d\u0003\u011e"+
		"\u008f\u0000\u043c\u043e\u0003\u00cae\u0000\u043d\u043c\u0001\u0000\u0000"+
		"\u0000\u043d\u043e\u0001\u0000\u0000\u0000\u043e\u0440\u0001\u0000\u0000"+
		"\u0000\u043f\u042e\u0001\u0000\u0000\u0000\u043f\u042f\u0001\u0000\u0000"+
		"\u0000\u043f\u0430\u0001\u0000\u0000\u0000\u043f\u0431\u0001\u0000\u0000"+
		"\u0000\u043f\u0432\u0001\u0000\u0000\u0000\u043f\u0433\u0001\u0000\u0000"+
		"\u0000\u043f\u0434\u0001\u0000\u0000\u0000\u043f\u0435\u0001\u0000\u0000"+
		"\u0000\u043f\u0436\u0001\u0000\u0000\u0000\u043f\u0437\u0001\u0000\u0000"+
		"\u0000\u043f\u0438\u0001\u0000\u0000\u0000\u043f\u0439\u0001\u0000\u0000"+
		"\u0000\u043f\u043a\u0001\u0000\u0000\u0000\u043f\u043b\u0001\u0000\u0000"+
		"\u0000\u0440\u00b5\u0001\u0000\u0000\u0000\u0441\u0442\u0005_\u0000\u0000"+
		"\u0442\u0443\u0005~\u0000\u0000\u0443\u0444\u0003\u0102\u0081\u0000\u0444"+
		"\u0445\u0005\u007f\u0000\u0000\u0445\u00b7\u0001\u0000\u0000\u0000\u0446"+
		"\u044b\u0003\u00ba]\u0000\u0447\u0448\u0005\u0085\u0000\u0000\u0448\u044a"+
		"\u0003\u00ba]\u0000\u0449\u0447\u0001\u0000\u0000\u0000\u044a\u044d\u0001"+
		"\u0000\u0000\u0000\u044b\u0449\u0001\u0000\u0000\u0000\u044b\u044c\u0001"+
		"\u0000\u0000\u0000\u044c\u00b9\u0001\u0000\u0000\u0000\u044d\u044b\u0001"+
		"\u0000\u0000\u0000\u044e\u0455\u0003\u00deo\u0000\u044f\u0451\u0003\u00de"+
		"o\u0000\u0450\u044f\u0001\u0000\u0000\u0000\u0450\u0451\u0001\u0000\u0000"+
		"\u0000\u0451\u0452\u0001\u0000\u0000\u0000\u0452\u0453\u0005\u008f\u0000"+
		"\u0000\u0453\u0455\u0003\u011a\u008d\u0000\u0454\u044e\u0001\u0000\u0000"+
		"\u0000\u0454\u0450\u0001\u0000\u0000\u0000\u0455\u00bb\u0001\u0000\u0000"+
		"\u0000\u0456\u045c\u0005\u000b\u0000\u0000\u0457\u0459\u0003\u011e\u008f"+
		"\u0000\u0458\u0457\u0001\u0000\u0000\u0000\u0458\u0459\u0001\u0000\u0000"+
		"\u0000\u0459\u045a\u0001\u0000\u0000\u0000\u045a\u045b\u0005\u008f\u0000"+
		"\u0000\u045b\u045d\u0003\u00d4j\u0000\u045c\u0458\u0001\u0000\u0000\u0000"+
		"\u045c\u045d\u0001\u0000\u0000\u0000\u045d\u0469\u0001\u0000\u0000\u0000"+
		"\u045e\u0463\u0003\u011e\u008f\u0000\u045f\u0460\u0005\u0080\u0000\u0000"+
		"\u0460\u0461\u0003\u00be_\u0000\u0461\u0462\u0005\u0081\u0000\u0000\u0462"+
		"\u0464\u0001\u0000\u0000\u0000\u0463\u045f\u0001\u0000\u0000\u0000\u0463"+
		"\u0464\u0001\u0000\u0000\u0000\u0464\u046a\u0001\u0000\u0000\u0000\u0465"+
		"\u0466\u0005\u0080\u0000\u0000\u0466\u0467\u0003\u00be_\u0000\u0467\u0468"+
		"\u0005\u0081\u0000\u0000\u0468\u046a\u0001\u0000\u0000\u0000\u0469\u045e"+
		"\u0001\u0000\u0000\u0000\u0469\u0465\u0001\u0000\u0000\u0000\u046a\u0476"+
		"\u0001\u0000\u0000\u0000\u046b\u046c\u0007\t\u0000\u0000\u046c\u046d\u0005"+
		"~\u0000\u0000\u046d\u046e\u0003\u00d4j\u0000\u046e\u046f\u0005\u0085\u0000"+
		"\u0000\u046f\u0470\u0003\u011e\u008f\u0000\u0470\u0471\u0005\u007f\u0000"+
		"\u0000\u0471\u0472\u0005\u0080\u0000\u0000\u0472\u0473\u0003\u00be_\u0000"+
		"\u0473\u0474\u0005\u0081\u0000\u0000\u0474\u0476\u0001\u0000\u0000\u0000"+
		"\u0475\u0456\u0001\u0000\u0000\u0000\u0475\u046b\u0001\u0000\u0000\u0000"+
		"\u0476\u00bd\u0001\u0000\u0000\u0000\u0477\u047c\u0003\u00c0`\u0000\u0478"+
		"\u0479\u0005\u0085\u0000\u0000\u0479\u047b\u0003\u00c0`\u0000\u047a\u0478"+
		"\u0001\u0000\u0000\u0000\u047b\u047e\u0001\u0000\u0000\u0000\u047c\u047a"+
		"\u0001\u0000\u0000\u0000\u047c\u047d\u0001\u0000\u0000\u0000\u047d\u0480"+
		"\u0001\u0000\u0000\u0000\u047e\u047c\u0001\u0000\u0000\u0000\u047f\u0481"+
		"\u0005\u0085\u0000\u0000\u0480\u047f\u0001\u0000\u0000\u0000\u0480\u0481"+
		"\u0001\u0000\u0000\u0000\u0481\u00bf\u0001\u0000\u0000\u0000\u0482\u0485"+
		"\u0003\u00c2a\u0000\u0483\u0484\u0005\u0089\u0000\u0000\u0484\u0486\u0003"+
		"\u0102\u0081\u0000\u0485\u0483\u0001\u0000\u0000\u0000\u0485\u0486\u0001"+
		"\u0000\u0000\u0000\u0486\u00c1\u0001\u0000\u0000\u0000\u0487\u048a\u0003"+
		"\u011e\u008f\u0000\u0488\u048a\u0005\u0007\u0000\u0000\u0489\u0487\u0001"+
		"\u0000\u0000\u0000\u0489\u0488\u0001\u0000\u0000\u0000\u048a\u00c3\u0001"+
		"\u0000\u0000\u0000\u048b\u0491\u0003\u011e\u008f\u0000\u048c\u048d\u0005"+
		"~\u0000\u0000\u048d\u048e\u0003\u00deo\u0000\u048e\u048f\u0005\u007f\u0000"+
		"\u0000\u048f\u0491\u0001\u0000\u0000\u0000\u0490\u048b\u0001\u0000\u0000"+
		"\u0000\u0490\u048c\u0001\u0000\u0000\u0000\u0491\u0495\u0001\u0000\u0000"+
		"\u0000\u0492\u0494\u0003\u00c6c\u0000\u0493\u0492\u0001\u0000\u0000\u0000"+
		"\u0494\u0497\u0001\u0000\u0000\u0000\u0495\u0493\u0001\u0000\u0000\u0000"+
		"\u0495\u0496\u0001\u0000\u0000\u0000\u0496\u04a3\u0001\u0000\u0000\u0000"+
		"\u0497\u0495\u0001\u0000\u0000\u0000\u0498\u0499\u0005~\u0000\u0000\u0499"+
		"\u049b\u0005\u009e\u0000\u0000\u049a\u049c\u0003\u00aaU\u0000\u049b\u049a"+
		"\u0001\u0000\u0000\u0000\u049b\u049c\u0001\u0000\u0000\u0000\u049c\u049e"+
		"\u0001\u0000\u0000\u0000\u049d\u049f\u0003\u011e\u008f\u0000\u049e\u049d"+
		"\u0001\u0000\u0000\u0000\u049e\u049f\u0001\u0000\u0000\u0000\u049f\u04a0"+
		"\u0001\u0000\u0000\u0000\u04a0\u04a1\u0005\u007f\u0000\u0000\u04a1\u04a3"+
		"\u0003T*\u0000\u04a2\u0490\u0001\u0000\u0000\u0000\u04a2\u0498\u0001\u0000"+
		"\u0000\u0000\u04a3\u00c5\u0001\u0000\u0000\u0000\u04a4\u04a6\u0005\u0082"+
		"\u0000\u0000\u04a5\u04a7\u0003\u010a\u0085\u0000\u04a6\u04a5\u0001\u0000"+
		"\u0000\u0000\u04a6\u04a7\u0001\u0000\u0000\u0000\u04a7\u04a8\u0001\u0000"+
		"\u0000\u0000\u04a8\u04a9\u0005\u0083\u0000\u0000\u04a9\u00c7\u0001\u0000"+
		"\u0000\u0000\u04aa\u04ad\u0003\u00dam\u0000\u04ab\u04ac\u0005\u0085\u0000"+
		"\u0000\u04ac\u04ae\u0005\u00aa\u0000\u0000\u04ad\u04ab\u0001\u0000\u0000"+
		"\u0000\u04ad\u04ae\u0001\u0000\u0000\u0000\u04ae\u00c9\u0001\u0000\u0000"+
		"\u0000\u04af\u04b1\u0005\u009a\u0000\u0000\u04b0\u04b2\u0003\u0098L\u0000"+
		"\u04b1\u04b0\u0001\u0000\u0000\u0000\u04b1\u04b2\u0001\u0000\u0000\u0000"+
		"\u04b2\u04b4\u0001\u0000\u0000\u0000\u04b3\u04b5\u0003\u00cae\u0000\u04b4"+
		"\u04b3\u0001\u0000\u0000\u0000\u04b4\u04b5\u0001\u0000\u0000\u0000\u04b5"+
		"\u00cb\u0001\u0000\u0000\u0000\u04b6\u04c2\u0003\u011e\u008f\u0000\u04b7"+
		"\u04b8\u0005~\u0000\u0000\u04b8\u04bd\u0003\u0118\u008c\u0000\u04b9\u04ba"+
		"\u0005\u0085\u0000\u0000\u04ba\u04bc\u0003\u0118\u008c\u0000\u04bb\u04b9"+
		"\u0001\u0000\u0000\u0000\u04bc\u04bf\u0001\u0000\u0000\u0000\u04bd\u04bb"+
		"\u0001\u0000\u0000\u0000\u04bd\u04be\u0001\u0000\u0000\u0000\u04be\u04c0"+
		"\u0001\u0000\u0000\u0000\u04bf\u04bd\u0001\u0000\u0000\u0000\u04c0\u04c1"+
		"\u0005\u007f\u0000\u0000\u04c1\u04c3\u0001\u0000\u0000\u0000\u04c2\u04b7"+
		"\u0001\u0000\u0000\u0000\u04c2\u04c3\u0001\u0000\u0000\u0000\u04c3\u00cd"+
		"\u0001\u0000\u0000\u0000\u04c4\u04c9\u0005\u0080\u0000\u0000\u04c5\u04c7"+
		"\u0003\u0100\u0080\u0000\u04c6\u04c8\u0005\u0085\u0000\u0000\u04c7\u04c6"+
		"\u0001\u0000\u0000\u0000\u04c7\u04c8\u0001\u0000\u0000\u0000\u04c8\u04ca"+
		"\u0001\u0000\u0000\u0000\u04c9\u04c5\u0001\u0000\u0000\u0000\u04c9\u04ca"+
		"\u0001\u0000\u0000\u0000\u04ca\u04cb\u0001\u0000\u0000\u0000\u04cb\u04cc"+
		"\u0005\u0081\u0000\u0000\u04cc\u00cf\u0001\u0000\u0000\u0000\u04cd\u04db"+
		"\u0005\u0080\u0000\u0000\u04ce\u04cf\u0005\u0086\u0000\u0000\u04cf\u04d5"+
		"\u0003\u0102\u0081\u0000\u04d0\u04d1\u0005\u0085\u0000\u0000\u04d1\u04d2"+
		"\u0005\u0086\u0000\u0000\u04d2\u04d4\u0003\u0102\u0081\u0000\u04d3\u04d0"+
		"\u0001\u0000\u0000\u0000\u04d4\u04d7\u0001\u0000\u0000\u0000\u04d5\u04d3"+
		"\u0001\u0000\u0000\u0000\u04d5\u04d6\u0001\u0000\u0000\u0000\u04d6\u04d9"+
		"\u0001\u0000\u0000\u0000\u04d7\u04d5\u0001\u0000\u0000\u0000\u04d8\u04da"+
		"\u0005\u0085\u0000\u0000\u04d9\u04d8\u0001\u0000\u0000\u0000\u04d9\u04da"+
		"\u0001\u0000\u0000\u0000\u04da\u04dc\u0001\u0000\u0000\u0000\u04db\u04ce"+
		"\u0001\u0000\u0000\u0000\u04db\u04dc\u0001\u0000\u0000\u0000\u04dc\u04dd"+
		"\u0001\u0000\u0000\u0000\u04dd\u04de\u0005\u0081\u0000\u0000\u04de\u00d1"+
		"\u0001\u0000\u0000\u0000\u04df\u04e4\u0003\u0108\u0084\u0000\u04e0\u04e1"+
		"\u0005\u0085\u0000\u0000\u04e1\u04e3\u0003\u0108\u0084\u0000\u04e2\u04e0"+
		"\u0001\u0000\u0000\u0000\u04e3\u04e6\u0001\u0000\u0000\u0000\u04e4\u04e2"+
		"\u0001\u0000\u0000\u0000\u04e4\u04e5\u0001\u0000\u0000\u0000\u04e5\u04e8"+
		"\u0001\u0000\u0000\u0000\u04e6\u04e4\u0001\u0000\u0000\u0000\u04e7\u04e9"+
		"\u0005\u0085\u0000\u0000\u04e8\u04e7\u0001\u0000\u0000\u0000\u04e8\u04e9"+
		"\u0001\u0000\u0000\u0000\u04e9\u00d3\u0001\u0000\u0000\u0000\u04ea\u04ec"+
		"\u0003\u00a4R\u0000\u04eb\u04ed\u0003\u00d6k\u0000\u04ec\u04eb\u0001\u0000"+
		"\u0000\u0000\u04ec\u04ed\u0001\u0000\u0000\u0000\u04ed\u04f0\u0001\u0000"+
		"\u0000\u0000\u04ee\u04f0\u0003F#\u0000\u04ef\u04ea\u0001\u0000\u0000\u0000"+
		"\u04ef\u04ee\u0001\u0000\u0000\u0000\u04f0\u00d5\u0001\u0000\u0000\u0000"+
		"\u04f1\u04f3\u0003\u00cae\u0000\u04f2\u04f4\u0003\u00d6k\u0000\u04f3\u04f2"+
		"\u0001\u0000\u0000\u0000\u04f3\u04f4\u0001\u0000\u0000\u0000\u04f4\u0509"+
		"\u0001\u0000\u0000\u0000\u04f5\u04f7\u0005~\u0000\u0000\u04f6\u04f8\u0003"+
		"\u00d6k\u0000\u04f7\u04f6\u0001\u0000\u0000\u0000\u04f7\u04f8\u0001\u0000"+
		"\u0000\u0000\u04f8\u04f9\u0001\u0000\u0000\u0000\u04f9\u04fb\u0005\u007f"+
		"\u0000\u0000\u04fa\u04fc\u0003\u00d8l\u0000\u04fb\u04fa\u0001\u0000\u0000"+
		"\u0000\u04fc\u04fd\u0001\u0000\u0000\u0000\u04fd\u04fb\u0001\u0000\u0000"+
		"\u0000\u04fd\u04fe\u0001\u0000\u0000\u0000\u04fe\u0509\u0001\u0000\u0000"+
		"\u0000\u04ff\u0501\u0005\u0082\u0000\u0000\u0500\u0502\u0003\u010a\u0085"+
		"\u0000\u0501\u0500\u0001\u0000\u0000\u0000\u0501\u0502\u0001\u0000\u0000"+
		"\u0000\u0502\u0503\u0001\u0000\u0000\u0000\u0503\u0505\u0005\u0083\u0000"+
		"\u0000\u0504\u04ff\u0001\u0000\u0000\u0000\u0505\u0506\u0001\u0000\u0000"+
		"\u0000\u0506\u0504\u0001\u0000\u0000\u0000\u0506\u0507\u0001\u0000\u0000"+
		"\u0000\u0507\u0509\u0001\u0000\u0000\u0000\u0508\u04f1\u0001\u0000\u0000"+
		"\u0000\u0508\u04f5\u0001\u0000\u0000\u0000\u0508\u0504\u0001\u0000\u0000"+
		"\u0000\u0509\u00d7\u0001\u0000\u0000\u0000\u050a\u050c\u0005\u0082\u0000"+
		"\u0000\u050b\u050d\u0003\u010a\u0085\u0000\u050c\u050b\u0001\u0000\u0000"+
		"\u0000\u050c\u050d\u0001\u0000\u0000\u0000\u050d\u050e\u0001\u0000\u0000"+
		"\u0000\u050e\u0515\u0005\u0083\u0000\u0000\u050f\u0511\u0005~\u0000\u0000"+
		"\u0510\u0512\u0003\u00dam\u0000\u0511\u0510\u0001\u0000\u0000\u0000\u0511"+
		"\u0512\u0001\u0000\u0000\u0000\u0512\u0513\u0001\u0000\u0000\u0000\u0513"+
		"\u0515\u0005\u007f\u0000\u0000\u0514\u050a\u0001\u0000\u0000\u0000\u0514"+
		"\u050f\u0001\u0000\u0000\u0000\u0515\u00d9\u0001\u0000\u0000\u0000\u0516"+
		"\u051b\u0003\u00dcn\u0000\u0517\u0518\u0005\u0085\u0000\u0000\u0518\u051a"+
		"\u0003\u00dcn\u0000\u0519\u0517\u0001\u0000\u0000\u0000\u051a\u051d\u0001"+
		"\u0000\u0000\u0000\u051b\u0519\u0001\u0000\u0000\u0000\u051b\u051c\u0001"+
		"\u0000\u0000\u0000\u051c\u00db\u0001\u0000\u0000\u0000\u051d\u051b\u0001"+
		"\u0000\u0000\u0000\u051e\u051f\u0003\u0098L\u0000\u051f\u0520\u0003\u00de"+
		"o\u0000\u0520\u0523\u0001\u0000\u0000\u0000\u0521\u0523\u0005 \u0000\u0000"+
		"\u0522\u051e\u0001\u0000\u0000\u0000\u0522\u0521\u0001\u0000\u0000\u0000"+
		"\u0523\u00dd\u0001\u0000\u0000\u0000\u0524\u0526\u0003\u00cae\u0000\u0525"+
		"\u0524\u0001\u0000\u0000\u0000\u0525\u0526\u0001\u0000\u0000\u0000\u0526"+
		"\u0527\u0001\u0000\u0000\u0000\u0527\u0528\u0003\u00c4b\u0000\u0528\u00df"+
		"\u0001\u0000\u0000\u0000\u0529\u052b\u0003\u00e2q\u0000\u052a\u052c\u0005"+
		"\u0084\u0000\u0000\u052b\u052a\u0001\u0000\u0000\u0000\u052b\u052c\u0001"+
		"\u0000\u0000\u0000\u052c\u0553\u0001\u0000\u0000\u0000\u052d\u052f\u0003"+
		"\u00e6s\u0000\u052e\u0530\u0005\u0084\u0000\u0000\u052f\u052e\u0001\u0000"+
		"\u0000\u0000\u052f\u0530\u0001\u0000\u0000\u0000\u0530\u0553\u0001\u0000"+
		"\u0000\u0000\u0531\u0533\u0003\u00e8t\u0000\u0532\u0534\u0005\u0084\u0000"+
		"\u0000\u0533\u0532\u0001\u0000\u0000\u0000\u0533\u0534\u0001\u0000\u0000"+
		"\u0000\u0534\u0553\u0001\u0000\u0000\u0000\u0535\u0537\u0003\u00f2y\u0000"+
		"\u0536\u0538\u0005\u0084\u0000\u0000\u0537\u0536\u0001\u0000\u0000\u0000"+
		"\u0537\u0538\u0001\u0000\u0000\u0000\u0538\u0553\u0001\u0000\u0000\u0000"+
		"\u0539\u053b\u0003\u00fe\u007f\u0000\u053a\u053c\u0005\u0084\u0000\u0000"+
		"\u053b\u053a\u0001\u0000\u0000\u0000\u053b\u053c\u0001\u0000\u0000\u0000"+
		"\u053c\u0553\u0001\u0000\u0000\u0000\u053d\u053f\u0003t:\u0000\u053e\u0540"+
		"\u0005\u0084\u0000\u0000\u053f\u053e\u0001\u0000\u0000\u0000\u053f\u0540"+
		"\u0001\u0000\u0000\u0000\u0540\u0553\u0001\u0000\u0000\u0000\u0541\u0543"+
		"\u0003v;\u0000\u0542\u0544\u0005\u0084\u0000\u0000\u0543\u0542\u0001\u0000"+
		"\u0000\u0000\u0543\u0544\u0001\u0000\u0000\u0000\u0544\u0553\u0001\u0000"+
		"\u0000\u0000\u0545\u0547\u0003n7\u0000\u0546\u0548\u0005\u0084\u0000\u0000"+
		"\u0547\u0546\u0001\u0000\u0000\u0000\u0547\u0548\u0001\u0000\u0000\u0000"+
		"\u0548\u0553\u0001\u0000\u0000\u0000\u0549\u054b\u0003p8\u0000\u054a\u054c"+
		"\u0005\u0084\u0000\u0000\u054b\u054a\u0001\u0000\u0000\u0000\u054b\u054c"+
		"\u0001\u0000\u0000\u0000\u054c\u0553\u0001\u0000\u0000\u0000\u054d\u054f"+
		"\u0003\u0100\u0080\u0000\u054e\u0550\u0005\u0084\u0000\u0000\u054f\u054e"+
		"\u0001\u0000\u0000\u0000\u054f\u0550\u0001\u0000\u0000\u0000\u0550\u0553"+
		"\u0001\u0000\u0000\u0000\u0551\u0553\u0005\u0084\u0000\u0000\u0552\u0529"+
		"\u0001\u0000\u0000\u0000\u0552\u052d\u0001\u0000\u0000\u0000\u0552\u0531"+
		"\u0001\u0000\u0000\u0000\u0552\u0535\u0001\u0000\u0000\u0000\u0552\u0539"+
		"\u0001\u0000\u0000\u0000\u0552\u053d\u0001\u0000\u0000\u0000\u0552\u0541"+
		"\u0001\u0000\u0000\u0000\u0552\u0545\u0001\u0000\u0000\u0000\u0552\u0549"+
		"\u0001\u0000\u0000\u0000\u0552\u054d\u0001\u0000\u0000\u0000\u0552\u0551"+
		"\u0001\u0000\u0000\u0000\u0553\u00e1\u0001\u0000\u0000\u0000\u0554\u0555"+
		"\u0003\u011e\u008f\u0000\u0555\u0556\u0005\u008f\u0000\u0000\u0556\u0557"+
		"\u0003\u00e0p\u0000\u0557\u00e3\u0001\u0000\u0000\u0000\u0558\u055b\u0003"+
		"\u010a\u0085\u0000\u0559\u055a\u0005\u00aa\u0000\u0000\u055a\u055c\u0003"+
		"\u010a\u0085\u0000\u055b\u0559\u0001\u0000\u0000\u0000\u055b\u055c\u0001"+
		"\u0000\u0000\u0000\u055c\u00e5\u0001\u0000\u0000\u0000\u055d\u0562\u0005"+
		"\u0080\u0000\u0000\u055e\u0561\u0003\u008aE\u0000\u055f\u0561\u0003\u00e0"+
		"p\u0000\u0560\u055e\u0001\u0000\u0000\u0000\u0560\u055f\u0001\u0000\u0000"+
		"\u0000\u0561\u0564\u0001\u0000\u0000\u0000\u0562\u0560\u0001\u0000\u0000"+
		"\u0000\u0562\u0563\u0001\u0000\u0000\u0000\u0563\u0565\u0001\u0000\u0000"+
		"\u0000\u0564\u0562\u0001\u0000\u0000\u0000\u0565\u0566\u0005\u0081\u0000"+
		"\u0000\u0566\u00e7\u0001\u0000\u0000\u0000\u0567\u0568\u0005\u0010\u0000"+
		"\u0000\u0568\u0569\u0005~\u0000\u0000\u0569\u056a\u0003\u0102\u0081\u0000"+
		"\u056a\u056b\u0005\u007f\u0000\u0000\u056b\u056e\u0003\u00e0p\u0000\u056c"+
		"\u056d\u0005\n\u0000\u0000\u056d\u056f\u0003\u00e0p\u0000\u056e\u056c"+
		"\u0001\u0000\u0000\u0000\u056e\u056f\u0001\u0000\u0000\u0000\u056f\u0572"+
		"\u0001\u0000\u0000\u0000\u0570\u0572\u0003\u00eau\u0000\u0571\u0567\u0001"+
		"\u0000\u0000\u0000\u0571\u0570\u0001\u0000\u0000\u0000\u0572\u00e9\u0001"+
		"\u0000\u0000\u0000\u0573\u0574\u0005\u001c\u0000\u0000\u0574\u0575\u0005"+
		"~\u0000\u0000\u0575\u0576\u0003\u0102\u0081\u0000\u0576\u0577\u0005\u007f"+
		"\u0000\u0000\u0577\u0578\u0003\u00ecv\u0000\u0578\u00eb\u0001\u0000\u0000"+
		"\u0000\u0579\u057d\u0005\u0080\u0000\u0000\u057a\u057c\u0003\u00eew\u0000"+
		"\u057b\u057a\u0001\u0000\u0000\u0000\u057c\u057f\u0001\u0000\u0000\u0000"+
		"\u057d\u057b\u0001\u0000\u0000\u0000\u057d\u057e\u0001\u0000\u0000\u0000"+
		"\u057e\u0580\u0001\u0000\u0000\u0000\u057f\u057d\u0001\u0000\u0000\u0000"+
		"\u0580\u0581\u0005\u0081\u0000\u0000\u0581\u00ed\u0001\u0000\u0000\u0000"+
		"\u0582\u0584\u0003\u00f0x\u0000\u0583\u0582\u0001\u0000\u0000\u0000\u0584"+
		"\u0585\u0001\u0000\u0000\u0000\u0585\u0583\u0001\u0000\u0000\u0000\u0585"+
		"\u0586\u0001\u0000\u0000\u0000\u0586\u0588\u0001\u0000\u0000\u0000\u0587"+
		"\u0589\u0003\u00e0p\u0000\u0588\u0587\u0001\u0000\u0000\u0000\u0589\u058a"+
		"\u0001\u0000\u0000\u0000\u058a\u0588\u0001\u0000\u0000\u0000\u058a\u058b"+
		"\u0001\u0000\u0000\u0000\u058b\u00ef\u0001\u0000\u0000\u0000\u058c\u0592"+
		"\u0005\u0003\u0000\u0000\u058d\u0593\u0003\u00e4r\u0000\u058e\u058f\u0005"+
		"~\u0000\u0000\u058f\u0590\u0003\u00e4r\u0000\u0590\u0591\u0005\u007f\u0000"+
		"\u0000\u0591\u0593\u0001\u0000\u0000\u0000\u0592\u058d\u0001\u0000\u0000"+
		"\u0000\u0592\u058e\u0001\u0000\u0000\u0000\u0593\u0594\u0001\u0000\u0000"+
		"\u0000\u0594\u0595\u0005\u008f\u0000\u0000\u0595\u0599\u0001\u0000\u0000"+
		"\u0000\u0596\u0597\u0005\u0007\u0000\u0000\u0597\u0599\u0005\u008f\u0000"+
		"\u0000\u0598\u058c\u0001\u0000\u0000\u0000\u0598\u0596\u0001\u0000\u0000"+
		"\u0000\u0599\u00f1\u0001\u0000\u0000\u0000\u059a\u059f\u0003\u00f4z\u0000"+
		"\u059b\u059f\u0003\u00f6{\u0000\u059c\u059f\u0003\u00f8|\u0000\u059d\u059f"+
		"\u0003\u00fc~\u0000\u059e\u059a\u0001\u0000\u0000\u0000\u059e\u059b\u0001"+
		"\u0000\u0000\u0000\u059e\u059c\u0001\u0000\u0000\u0000\u059e\u059d\u0001"+
		"\u0000\u0000\u0000\u059f\u00f3\u0001\u0000\u0000\u0000\u05a0\u05a1\u0005"+
		"\"\u0000\u0000\u05a1\u05a2\u0005~\u0000\u0000\u05a2\u05a3\u0003\u0102"+
		"\u0081\u0000\u05a3\u05a4\u0005\u007f\u0000\u0000\u05a4\u05a5\u0003\u00e0"+
		"p\u0000\u05a5\u00f5\u0001\u0000\u0000\u0000\u05a6\u05a7\u0005\b\u0000"+
		"\u0000\u05a7\u05a8\u0003\u00e0p\u0000\u05a8\u05a9\u0005\"\u0000\u0000"+
		"\u05a9\u05aa\u0005~\u0000\u0000\u05aa\u05ab\u0003\u0102\u0081\u0000\u05ab"+
		"\u05ac\u0005\u007f\u0000\u0000\u05ac\u05ad\u0005\u0084\u0000\u0000\u05ad"+
		"\u00f7\u0001\u0000\u0000\u0000\u05ae\u05af\u0005\u000e\u0000\u0000\u05af"+
		"\u05b1\u0005~\u0000\u0000\u05b0\u05b2\u0003\u00fa}\u0000\u05b1\u05b0\u0001"+
		"\u0000\u0000\u0000\u05b1\u05b2\u0001\u0000\u0000\u0000\u05b2\u05b3\u0001"+
		"\u0000\u0000\u0000\u05b3\u05b5\u0005\u0084\u0000\u0000\u05b4\u05b6\u0003"+
		"\u0102\u0081\u0000\u05b5\u05b4\u0001\u0000\u0000\u0000\u05b5\u05b6\u0001"+
		"\u0000\u0000\u0000\u05b6\u05b7\u0001\u0000\u0000\u0000\u05b7\u05b9\u0005"+
		"\u0084\u0000\u0000\u05b8\u05ba\u0003\u0100\u0080\u0000\u05b9\u05b8\u0001"+
		"\u0000\u0000\u0000\u05b9\u05ba\u0001\u0000\u0000\u0000\u05ba\u05bb\u0001"+
		"\u0000\u0000\u0000\u05bb\u05bc\u0005\u007f\u0000\u0000\u05bc\u05bd\u0003"+
		"\u00e0p\u0000\u05bd\u00f9\u0001\u0000\u0000\u0000\u05be\u05bf\u0003\u0098"+
		"L\u0000\u05bf\u05c0\u0003\u009cN\u0000\u05c0\u05c3\u0001\u0000\u0000\u0000"+
		"\u05c1\u05c3\u0003\u0100\u0080\u0000\u05c2\u05be\u0001\u0000\u0000\u0000"+
		"\u05c2\u05c1\u0001\u0000\u0000\u0000\u05c3\u00fb\u0001\u0000\u0000\u0000"+
		"\u05c4\u05c5\u0005\u000e\u0000\u0000\u05c5\u05c6\u0005~\u0000\u0000\u05c6"+
		"\u05c7\u0003l6\u0000\u05c7\u05c9\u0005.\u0000\u0000\u05c8\u05ca\u0003"+
		"\u0102\u0081\u0000\u05c9\u05c8\u0001\u0000\u0000\u0000\u05c9\u05ca\u0001"+
		"\u0000\u0000\u0000\u05ca\u05cb\u0001\u0000\u0000\u0000\u05cb\u05cc\u0005"+
		"\u007f\u0000\u0000\u05cc\u05cd\u0003\u00e0p\u0000\u05cd\u00fd\u0001\u0000"+
		"\u0000\u0000\u05ce\u05cf\u0005\u000f\u0000\u0000\u05cf\u05d7\u0003\u011e"+
		"\u008f\u0000\u05d0\u05d7\u0005\u0006\u0000\u0000\u05d1\u05d7\u0005\u0002"+
		"\u0000\u0000\u05d2\u05d4\u0005\u0016\u0000\u0000\u05d3\u05d5\u0003\u0102"+
		"\u0081\u0000\u05d4\u05d3\u0001\u0000\u0000\u0000\u05d4\u05d5\u0001\u0000"+
		"\u0000\u0000\u05d5\u05d7\u0001\u0000\u0000\u0000\u05d6\u05ce\u0001\u0000"+
		"\u0000\u0000\u05d6\u05d0\u0001\u0000\u0000\u0000\u05d6\u05d1\u0001\u0000"+
		"\u0000\u0000\u05d6\u05d2\u0001\u0000\u0000\u0000\u05d7\u00ff\u0001\u0000"+
		"\u0000\u0000\u05d8\u05dd\u0003\u0102\u0081\u0000\u05d9\u05da\u0005\u0085"+
		"\u0000\u0000\u05da\u05dc\u0003\u0102\u0081\u0000\u05db\u05d9\u0001\u0000"+
		"\u0000\u0000\u05dc\u05df\u0001\u0000\u0000\u0000\u05dd\u05db\u0001\u0000"+
		"\u0000\u0000\u05dd\u05de\u0001\u0000\u0000\u0000\u05de\u0101\u0001\u0000"+
		"\u0000\u0000\u05df\u05dd\u0001\u0000\u0000\u0000\u05e0\u05e1\u0006\u0081"+
		"\uffff\uffff\u0000\u05e1\u05eb\u0003\u0106\u0083\u0000\u05e2\u05e3\u0005"+
		"~\u0000\u0000\u05e3\u05e4\u0003\u00e6s\u0000\u05e4\u05e5\u0005\u007f\u0000"+
		"\u0000\u05e5\u05eb\u0001\u0000\u0000\u0000\u05e6\u05e7\u0003\u010c\u0086"+
		"\u0000\u05e7\u05e8\u0003\u0104\u0082\u0000\u05e8\u05e9\u0003\u0102\u0081"+
		"\u0001\u05e9\u05eb\u0001\u0000\u0000\u0000\u05ea\u05e0\u0001\u0000\u0000"+
		"\u0000\u05ea\u05e2\u0001\u0000\u0000\u0000\u05ea\u05e6\u0001\u0000\u0000"+
		"\u0000\u05eb\u0618\u0001\u0000\u0000\u0000\u05ec\u05ed\n\r\u0000\u0000"+
		"\u05ed\u05ee\u0007\n\u0000\u0000\u05ee\u0617\u0003\u0102\u0081\u000e\u05ef"+
		"\u05f0\n\f\u0000\u0000\u05f0\u05f1\u0007\u000b\u0000\u0000\u05f1\u0617"+
		"\u0003\u0102\u0081\r\u05f2\u05f7\n\u000b\u0000\u0000\u05f3\u05f4\u0005"+
		"\u008b\u0000\u0000\u05f4\u05f8\u0005\u008b\u0000\u0000\u05f5\u05f6\u0005"+
		"\u008a\u0000\u0000\u05f6\u05f8\u0005\u008a\u0000\u0000\u05f7\u05f3\u0001"+
		"\u0000\u0000\u0000\u05f7\u05f5\u0001\u0000\u0000\u0000\u05f8\u05f9\u0001"+
		"\u0000\u0000\u0000\u05f9\u0617\u0003\u0102\u0081\f\u05fa\u05fb\n\n\u0000"+
		"\u0000\u05fb\u05fc\u0007\f\u0000\u0000\u05fc\u0617\u0003\u0102\u0081\u000b"+
		"\u05fd\u05fe\n\t\u0000\u0000\u05fe\u05ff\u0007\r\u0000\u0000\u05ff\u0617"+
		"\u0003\u0102\u0081\n\u0600\u0601\n\b\u0000\u0000\u0601\u0602\u0005\u009c"+
		"\u0000\u0000\u0602\u0617\u0003\u0102\u0081\t\u0603\u0604\n\u0007\u0000"+
		"\u0000\u0604\u0605\u0005\u009e\u0000\u0000\u0605\u0617\u0003\u0102\u0081"+
		"\b\u0606\u0607\n\u0006\u0000\u0000\u0607\u0608\u0005\u009d\u0000\u0000"+
		"\u0608\u0617\u0003\u0102\u0081\u0007\u0609\u060a\n\u0005\u0000\u0000\u060a"+
		"\u060b\u0005\u0094\u0000\u0000\u060b\u0617\u0003\u0102\u0081\u0006\u060c"+
		"\u060d\n\u0004\u0000\u0000\u060d\u060e\u0005\u0095\u0000\u0000\u060e\u0617"+
		"\u0003\u0102\u0081\u0005\u060f\u0610\n\u0003\u0000\u0000\u0610\u0612\u0005"+
		"\u008e\u0000\u0000\u0611\u0613\u0003\u0102\u0081\u0000\u0612\u0611\u0001"+
		"\u0000\u0000\u0000\u0612\u0613\u0001\u0000\u0000\u0000\u0613\u0614\u0001"+
		"\u0000\u0000\u0000\u0614\u0615\u0005\u008f\u0000\u0000\u0615\u0617\u0003"+
		"\u0102\u0081\u0004\u0616\u05ec\u0001\u0000\u0000\u0000\u0616\u05ef\u0001"+
		"\u0000\u0000\u0000\u0616\u05f2\u0001\u0000\u0000\u0000\u0616\u05fa\u0001"+
		"\u0000\u0000\u0000\u0616\u05fd\u0001\u0000\u0000\u0000\u0616\u0600\u0001"+
		"\u0000\u0000\u0000\u0616\u0603\u0001\u0000\u0000\u0000\u0616\u0606\u0001"+
		"\u0000\u0000\u0000\u0616\u0609\u0001\u0000\u0000\u0000\u0616\u060c\u0001"+
		"\u0000\u0000\u0000\u0616\u060f\u0001\u0000\u0000\u0000\u0617\u061a\u0001"+
		"\u0000\u0000\u0000\u0618\u0616\u0001\u0000\u0000\u0000\u0618\u0619\u0001"+
		"\u0000\u0000\u0000\u0619\u0103\u0001\u0000\u0000\u0000\u061a\u0618\u0001"+
		"\u0000\u0000\u0000\u061b\u061c\u0007\u000e\u0000\u0000\u061c\u0105\u0001"+
		"\u0000\u0000\u0000\u061d\u0627\u0003\u010c\u0086\u0000\u061e\u061f\u0005"+
		"~\u0000\u0000\u061f\u0620\u0003\u00d4j\u0000\u0620\u0621\u0005\u007f\u0000"+
		"\u0000\u0621\u0624\u0001\u0000\u0000\u0000\u0622\u0625\u0003\u0106\u0083"+
		"\u0000\u0623\u0625\u0003\u0108\u0084\u0000\u0624\u0622\u0001\u0000\u0000"+
		"\u0000\u0624\u0623\u0001\u0000\u0000\u0000\u0625\u0627\u0001\u0000\u0000"+
		"\u0000\u0626\u061d\u0001\u0000\u0000\u0000\u0626\u061e\u0001\u0000\u0000"+
		"\u0000\u0627\u0107\u0001\u0000\u0000\u0000\u0628\u062c\u0003\u0102\u0081"+
		"\u0000\u0629\u062c\u0003\u00ceg\u0000\u062a\u062c\u0003\u00d0h\u0000\u062b"+
		"\u0628\u0001\u0000\u0000\u0000\u062b\u0629\u0001\u0000\u0000\u0000\u062b"+
		"\u062a\u0001\u0000\u0000\u0000\u062c\u0109\u0001\u0000\u0000\u0000\u062d"+
		"\u0630\u0003\u011e\u008f\u0000\u062e\u0630\u0003\u011a\u008d\u0000\u062f"+
		"\u062d\u0001\u0000\u0000\u0000\u062f\u062e\u0001\u0000\u0000\u0000\u0630"+
		"\u010b\u0001\u0000\u0000\u0000\u0631\u0640\u0003\u0110\u0088\u0000\u0632"+
		"\u0638\u0005\u0019\u0000\u0000\u0633\u0639\u0003\u010c\u0086\u0000\u0634"+
		"\u0635\u0005~\u0000\u0000\u0635\u0636\u0003\u00b4Z\u0000\u0636\u0637\u0005"+
		"\u007f\u0000\u0000\u0637\u0639\u0001\u0000\u0000\u0000\u0638\u0633\u0001"+
		"\u0000\u0000\u0000\u0638\u0634\u0001\u0000\u0000\u0000\u0639\u0640\u0001"+
		"\u0000\u0000\u0000\u063a\u063b\u0007\u000f\u0000\u0000\u063b\u0640\u0003"+
		"\u010c\u0086\u0000\u063c\u063d\u0003\u010e\u0087\u0000\u063d\u063e\u0003"+
		"\u0106\u0083\u0000\u063e\u0640\u0001\u0000\u0000\u0000\u063f\u0631\u0001"+
		"\u0000\u0000\u0000\u063f\u0632\u0001\u0000\u0000\u0000\u063f\u063a\u0001"+
		"\u0000\u0000\u0000\u063f\u063c\u0001\u0000\u0000\u0000\u0640\u010d\u0001"+
		"\u0000\u0000\u0000\u0641\u0642\u0007\u0010\u0000\u0000\u0642\u010f\u0001"+
		"\u0000\u0000\u0000\u0643\u0644\u0006\u0088\uffff\uffff\u0000\u0644\u0648"+
		"\u0003\u0118\u008c\u0000\u0645\u0647\u0003\u0112\u0089\u0000\u0646\u0645"+
		"\u0001\u0000\u0000\u0000\u0647\u064a\u0001\u0000\u0000\u0000\u0648\u0646"+
		"\u0001\u0000\u0000\u0000\u0648\u0649\u0001\u0000\u0000\u0000\u0649\u0656"+
		"\u0001\u0000\u0000\u0000\u064a\u0648\u0001\u0000\u0000\u0000\u064b\u064c"+
		"\n\u0001\u0000\u0000\u064c\u064d\u0007\u0011\u0000\u0000\u064d\u0651\u0003"+
		"\u011e\u008f\u0000\u064e\u0650\u0003\u0112\u0089\u0000\u064f\u064e\u0001"+
		"\u0000\u0000\u0000\u0650\u0653\u0001\u0000\u0000\u0000\u0651\u064f\u0001"+
		"\u0000\u0000\u0000\u0651\u0652\u0001\u0000\u0000\u0000\u0652\u0655\u0001"+
		"\u0000\u0000\u0000\u0653\u0651\u0001\u0000\u0000\u0000\u0654\u064b\u0001"+
		"\u0000\u0000\u0000\u0655\u0658\u0001\u0000\u0000\u0000\u0656\u0654\u0001"+
		"\u0000\u0000\u0000\u0656\u0657\u0001\u0000\u0000\u0000\u0657\u0111\u0001"+
		"\u0000\u0000\u0000\u0658\u0656\u0001\u0000\u0000\u0000\u0659\u065a\u0005"+
		"\u0082\u0000\u0000\u065a\u065b\u0003\u0102\u0081\u0000\u065b\u065c\u0005"+
		"\u0083\u0000\u0000\u065c\u066c\u0001\u0000\u0000\u0000\u065d\u065f\u0005"+
		"~\u0000\u0000\u065e\u0660\u0003\u0114\u008a\u0000\u065f\u065e\u0001\u0000"+
		"\u0000\u0000\u065f\u0660\u0001\u0000\u0000\u0000\u0660\u0661\u0001\u0000"+
		"\u0000\u0000\u0661\u066c\u0005\u007f\u0000\u0000\u0662\u0665\u0005~\u0000"+
		"\u0000\u0663\u0666\u0005\u0085\u0000\u0000\u0664\u0666\b\u0012\u0000\u0000"+
		"\u0665\u0663\u0001\u0000\u0000\u0000\u0665\u0664\u0001\u0000\u0000\u0000"+
		"\u0666\u0667\u0001\u0000\u0000\u0000\u0667\u0665\u0001\u0000\u0000\u0000"+
		"\u0667\u0668\u0001\u0000\u0000\u0000\u0668\u0669\u0001\u0000\u0000\u0000"+
		"\u0669\u066c\u0005\u007f\u0000\u0000\u066a\u066c\u0007\u000f\u0000\u0000"+
		"\u066b\u0659\u0001\u0000\u0000\u0000\u066b\u065d\u0001\u0000\u0000\u0000"+
		"\u066b\u0662\u0001\u0000\u0000\u0000\u066b\u066a\u0001\u0000\u0000\u0000"+
		"\u066c\u0113\u0001\u0000\u0000\u0000\u066d\u0672\u0003\u0116\u008b\u0000"+
		"\u066e\u066f\u0005\u0085\u0000\u0000\u066f\u0671\u0003\u0116\u008b\u0000"+
		"\u0670\u066e\u0001\u0000\u0000\u0000\u0671\u0674\u0001\u0000\u0000\u0000"+
		"\u0672\u0670\u0001\u0000\u0000\u0000\u0672\u0673\u0001\u0000\u0000\u0000"+
		"\u0673\u0115\u0001\u0000\u0000\u0000\u0674\u0672\u0001\u0000\u0000\u0000"+
		"\u0675\u0678\u0003\u0102\u0081\u0000\u0676\u0678\u0003\u00b4Z\u0000\u0677"+
		"\u0675\u0001\u0000\u0000\u0000\u0677\u0676\u0001\u0000\u0000\u0000\u0678"+
		"\u0117\u0001\u0000\u0000\u0000\u0679\u0689\u0003\u011e\u008f\u0000\u067a"+
		"\u0689\u0003\u011a\u008d\u0000\u067b\u0689\u0003\u011c\u008e\u0000\u067c"+
		"\u067d\u0005~\u0000\u0000\u067d\u067e\u0003\u0102\u0081\u0000\u067e\u067f"+
		"\u0005\u007f\u0000\u0000\u067f\u0689\u0001\u0000\u0000\u0000\u0680\u0689"+
		"\u0003Z-\u0000\u0681\u0689\u0003d2\u0000\u0682\u0689\u0003h4\u0000\u0683"+
		"\u0689\u0003j5\u0000\u0684\u0689\u0003L&\u0000\u0685\u0689\u0003P(\u0000"+
		"\u0686\u0689\u0003R)\u0000\u0687\u0689\u0003X,\u0000\u0688\u0679\u0001"+
		"\u0000\u0000\u0000\u0688\u067a\u0001\u0000\u0000\u0000\u0688\u067b\u0001"+
		"\u0000\u0000\u0000\u0688\u067c\u0001\u0000\u0000\u0000\u0688\u0680\u0001"+
		"\u0000\u0000\u0000\u0688\u0681\u0001\u0000\u0000\u0000\u0688\u0682\u0001"+
		"\u0000\u0000\u0000\u0688\u0683\u0001\u0000\u0000\u0000\u0688\u0684\u0001"+
		"\u0000\u0000\u0000\u0688\u0685\u0001\u0000\u0000\u0000\u0688\u0686\u0001"+
		"\u0000\u0000\u0000\u0688\u0687\u0001\u0000\u0000\u0000\u0689\u0119\u0001"+
		"\u0000\u0000\u0000\u068a\u069d\u0005\u00ad\u0000\u0000\u068b\u069d\u0005"+
		"\u00ae\u0000\u0000\u068c\u069d\u0005\u00af\u0000\u0000\u068d\u068f\u0007"+
		"\u000b\u0000\u0000\u068e\u068d\u0001\u0000\u0000\u0000\u068e\u068f\u0001"+
		"\u0000\u0000\u0000\u068f\u0690\u0001\u0000\u0000\u0000\u0690\u069d\u0005"+
		"\u00b0\u0000\u0000\u0691\u0693\u0007\u000b\u0000\u0000\u0692\u0691\u0001"+
		"\u0000\u0000\u0000\u0692\u0693\u0001\u0000\u0000\u0000\u0693\u0694\u0001"+
		"\u0000\u0000\u0000\u0694\u069d\u0005\u00b1\u0000\u0000\u0695\u069d\u0005"+
		"\u00ab\u0000\u0000\u0696\u069d\u00050\u0000\u0000\u0697\u069d\u00052\u0000"+
		"\u0000\u0698\u069d\u00059\u0000\u0000\u0699\u069d\u00051\u0000\u0000\u069a"+
		"\u069d\u0005&\u0000\u0000\u069b\u069d\u0005\'\u0000\u0000\u069c\u068a"+
		"\u0001\u0000\u0000\u0000\u069c\u068b\u0001\u0000\u0000\u0000\u069c\u068c"+
		"\u0001\u0000\u0000\u0000\u069c\u068e\u0001\u0000\u0000\u0000\u069c\u0692"+
		"\u0001\u0000\u0000\u0000\u069c\u0695\u0001\u0000\u0000\u0000\u069c\u0696"+
		"\u0001\u0000\u0000\u0000\u069c\u0697\u0001\u0000\u0000\u0000\u069c\u0698"+
		"\u0001\u0000\u0000\u0000\u069c\u0699\u0001\u0000\u0000\u0000\u069c\u069a"+
		"\u0001\u0000\u0000\u0000\u069c\u069b\u0001\u0000\u0000\u0000\u069d\u011b"+
		"\u0001\u0000\u0000\u0000\u069e\u06a2\u0005\u00ac\u0000\u0000\u069f\u06a1"+
		"\u0007\u0013\u0000\u0000\u06a0\u069f\u0001\u0000\u0000\u0000\u06a1\u06a4"+
		"\u0001\u0000\u0000\u0000\u06a2\u06a0\u0001\u0000\u0000\u0000\u06a2\u06a3"+
		"\u0001\u0000\u0000\u0000\u06a3\u06a5\u0001\u0000\u0000\u0000\u06a4\u06a2"+
		"\u0001\u0000\u0000\u0000\u06a5\u06a7\u0005\u00b8\u0000\u0000\u06a6\u069e"+
		"\u0001\u0000\u0000\u0000\u06a7\u06a8\u0001\u0000\u0000\u0000\u06a8\u06a6"+
		"\u0001\u0000\u0000\u0000\u06a8\u06a9\u0001\u0000\u0000\u0000\u06a9\u011d"+
		"\u0001\u0000\u0000\u0000\u06aa\u06ab\u0007\u0014\u0000\u0000\u06ab\u011f"+
		"\u0001\u0000\u0000\u0000\u00e1\u0123\u0133\u013a\u0140\u0146\u0149\u014c"+
		"\u0154\u015b\u015e\u0161\u0169\u016c\u016f\u0179\u0183\u018b\u0190\u0199"+
		"\u019f\u01a1\u01ad\u01b7\u01bf\u01c2\u01c5\u01ce\u01e5\u01ec\u01ef\u01f5"+
		"\u01fe\u0204\u0206\u020f\u0211\u021a\u021f\u0221\u022b\u022d\u0236\u023a"+
		"\u023d\u0245\u0249\u024b\u024e\u0254\u0258\u025e\u026c\u0273\u0279\u027c"+
		"\u0280\u0286\u028a\u0292\u0295\u029c\u02a1\u02aa\u02ae\u02b0\u02bc\u02be"+
		"\u02ca\u02cc\u02d1\u02d7\u02da\u02e0\u02e4\u02e7\u02ea\u02f5\u02fb\u02fd"+
		"\u0300\u0308\u030d\u0313\u031c\u0321\u0323\u0339\u0340\u0345\u035d\u0362"+
		"\u0367\u036b\u036f\u0373\u037c\u0383\u038a\u0390\u0393\u0397\u039f\u03a2"+
		"\u03a6\u03ae\u03b3\u03ba\u03c3\u03c7\u03d3\u03d5\u03df\u03ea\u03f0\u03f5"+
		"\u03fb\u03ff\u0405\u0407\u0412\u0414\u041c\u042a\u043d\u043f\u044b\u0450"+
		"\u0454\u0458\u045c\u0463\u0469\u0475\u047c\u0480\u0485\u0489\u0490\u0495"+
		"\u049b\u049e\u04a2\u04a6\u04ad\u04b1\u04b4\u04bd\u04c2\u04c7\u04c9\u04d5"+
		"\u04d9\u04db\u04e4\u04e8\u04ec\u04ef\u04f3\u04f7\u04fd\u0501\u0506\u0508"+
		"\u050c\u0511\u0514\u051b\u0522\u0525\u052b\u052f\u0533\u0537\u053b\u053f"+
		"\u0543\u0547\u054b\u054f\u0552\u055b\u0560\u0562\u056e\u0571\u057d\u0585"+
		"\u058a\u0592\u0598\u059e\u05b1\u05b5\u05b9\u05c2\u05c9\u05d4\u05d6\u05dd"+
		"\u05ea\u05f7\u0612\u0616\u0618\u0624\u0626\u062b\u062f\u0638\u063f\u0648"+
		"\u0651\u0656\u065f\u0665\u0667\u066b\u0672\u0677\u0688\u068e\u0692\u069c"+
		"\u06a2\u06a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}