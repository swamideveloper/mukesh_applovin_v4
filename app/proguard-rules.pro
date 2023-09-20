-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

-dontoptimize
-dontpreverify

-keepattributes *Annotation*
-keepclassmembers class * {
    native <methods>;
}

-repackageclasses

    -keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

-keeppackagenames org.jsoup.nodes


-keepclassmembers class io.reactivex.** { *; }
-keepclassmembers class rx.** { *; }


# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator CREATOR;
}

-keep class com.fastcash.speedloancoach.quickloan.mukesh_pkg_ten.** { *; }
-keep class com.fastcash.speedloancoach.quickloan.mukesh_pkg_twelve.** { *; }
-keep class com.fastcash.speedloancoach.quickloan.mukesh_pkg_six.** { *; }
-keep class com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.** { *; }
-keep class com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.** { *; }