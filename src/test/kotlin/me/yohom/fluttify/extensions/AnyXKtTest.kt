package me.yohom.fluttify.extensions

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Test for AnyX")
class AnyXKtTest {
    val testVar = Variable(typeName = "TestType", name = "testVar", platform = Platform.Android)
    val testField = Field(
        isPublic = true,
        isFinal = false,
        isStatic = false,
        variable = testVar,
        className = "TestClass",
        platform = Platform.Android
    )
    val testType = Type().apply { name = "TestType" }
    val testMethod = Method(
        returnType = "TestType",
        name = "testMethod",
        formalParams = listOf(),
        isStatic = false,
        isPublic = true,
        className = "TestType",
        platform = Platform.Android,
        isDeprecated = false,
        isFunction = false,
        isAbstract = false
    )
    val testConstructor =
        Constructor(name = "TestConstructor", formalParams = listOf(), isPublic = true, platform = Platform.Android)
    val unsupportedType = "unsupportedType"

    @Nested
    @DisplayName("Test for `must`")
    inner class MustTest : FluttifyTest() {
//        @Test
//        fun must_true_variable_actually_false_output_message() {
//            testVar.must("测试必须真") { false }
//            assertEquals("Variable::TestType::testVar由于不是`测试必须真`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_true_variable_actually_true_output_nothing() {
//            testVar.must("测试必须真") { true }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_true_field_actually_false_output_message() {
//            testField.must("测试必须真") { false }
//            assertEquals("TestClass::Field::TestType::testVar由于不是`测试必须真`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_true_field_actually_true_output_nothing() {
//            testField.must("测试必须真") { true }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_true_type_actually_false_output_message() {
//            testType.must("测试必须真") { false }
//            assertEquals("Type::TestType由于不是`测试必须真`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_true_type_actually_true_output_nothing() {
//            testType.must("测试必须真") { true }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_true_method_actually_false_output_message() {
//            testMethod.must("测试必须真") { false }
//            assertEquals("TestType::Method::TestType::testMethod()由于不是`测试必须真`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_true_method_actually_true_output_nothing() {
//            testMethod.must("测试必须真") { true }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_true_constructor_actually_false_output_message() {
//            testConstructor.must("测试必须真") { false }
//            assertEquals("Constructor::TestConstructor()由于不是`测试必须真`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_true_constructor_actually_true_output_nothing() {
//            testConstructor.must("测试必须真") { true }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_true_unsupported_type_output_nothing() {
//            unsupportedType.must("测试必须真") { false }
//            assertEquals("不支持的过滤类型\n", outContent.toString());
//        }
    }

    @Nested
    @DisplayName("Test for `mustNot`")
    inner class MustNotTest : FluttifyTest() {
//        @Test
//        fun must_false_variable_actually_false_output_nothing() {
//            testVar.mustNot("测试必须假") { false }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_false_variable_actually_true_output_message() {
//            testVar.mustNot("测试必须假") { true }
//            assertEquals("Variable::TestType::testVar由于是`测试必须假`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_false_field_actually_false_output_nothing() {
//            testField.mustNot("测试必须假") { false }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_false_field_actually_true_output_message() {
//            testField.mustNot("测试必须假") { true }
//            assertEquals("TestClass::Field::TestType::testVar由于是`测试必须假`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_false_type_actually_true_output_message() {
//            testType.mustNot("测试必须假") { true }
//            assertEquals("Type::TestType由于是`测试必须假`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_false_type_actually_false_output_nothing() {
//            testType.mustNot("测试必须假") { false }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_false_method_actually_true_output_message() {
//            testMethod.mustNot("测试必须假") { true }
//            assertEquals("TestType::Method::TestType::testMethod()由于是`测试必须假`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_false_method_actually_false_output_nothing() {
//            testMethod.mustNot("测试必须假") { false }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_false_constructor_actually_true_output_message() {
//            testConstructor.mustNot("测试必须假") { true }
//            assertEquals("Constructor::TestConstructor()由于是`测试必须假`, 被过滤\n", outContent.toString());
//        }
//
//        @Test
//        fun must_false_constructor_actually_false_output_nothing() {
//            testConstructor.mustNot("测试必须假") { false }
//            assertEquals("", outContent.toString());
//        }
//
//        @Test
//        fun must_false_unsupported_type_output_nothing() {
//            unsupportedType.mustNot("测试必须假") { true }
//            assertEquals("不支持的过滤类型\n", outContent.toString());
//        }
    }

    @Test
    fun getResource() {
    }
}