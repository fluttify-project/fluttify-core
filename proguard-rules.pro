-dontshrink
-dontoptimize
# -dontobfuscate
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-printmapping priguardMapping.txt
-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}

# antlr类不混淆
-keep class org.antlr.v4.** { *; }
-dontwarn org.antlr.v4.**

-keep class parser.** { *; }
-dontwarn parser.**

-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**

-keep class org.apache.commons.** { *; }
-dontwarn org.apache.commons.**

-keep class okhttp3.** { *; }
-dontwarn okhttp3.**

# gradle api不混淆
-keep class org.gradle.api.** { *; }
-dontwarn org.gradle.api.**

-keep public class * extends me.yohom.fluttify.task.FluttifyTask { *; }
-keep public class * extends java.** { *; }
-keep public class me.yohom.fluttify.FluttifyExtension { *; }
-keep public class me.yohom.fluttify.PlatformSpec { *; }
-keep public class me.yohom.fluttify.Exclude { *; }
-keep public class me.yohom.fluttify.Remote { *; }
-keep public class me.yohom.fluttify.Local { *; }
-keep public class me.yohom.fluttify.FluttifyCorePlugin { *; }
-keep public class * extends org.gradle.api.Task { *; }
-keepclassmembers public class * extends me.yohom.fluttify.task.FluttifyTask { *; }
-keepclassmembers public class me.yohom.fluttify.FluttifyExtension { *; }
-keepclassmembers public class me.yohom.fluttify.PlatformSpec { public <init>(...); }
-keepclassmembers public class me.yohom.fluttify.Exclude { *; }
-keepclassmembers public class me.yohom.fluttify.Remote { *; }
-keepclassmembers public class me.yohom.fluttify.Local { *; }
-keepclassmembers public class me.yohom.fluttify.FluttifyCorePlugin { *; }
-keepclassmembers public class * extends org.gradle.api.Task { *; }
-dontwarn me.yohom.fluttify.task.**

-keepattributes *Annotation*
-keepattributes InnerClasses
-keep @org.jetbrains.annotations.* class * { *; }
-dontwarn org.jetbrains.annotations.*

-keep @javax.inject.Inject class * { *; }
-dontwarn javax.inject.Inject