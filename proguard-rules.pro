-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-printmapping priguardMapping.txt
-optimizations !code/simplification/artithmetic,!field/*,!class/merging/*

# antlr类不混淆
# -keep class parser.** { *; }
# -dontwarn parser.**

# gradle api不混淆
# -keep class org.gradle.api.** { *; }
# -dontwarn org.gradle.api.**

-keep class * extends org.gradle.api.Plugin { *; }
