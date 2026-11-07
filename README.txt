NERVE.NET LEGACY ANDROID PROJECT

Target device:
- Acer Iconia Tab A200
- Android 4.0.3 (API 15)

Project choices:
- Java Activity with programmatic native Android UI
- minSdk 15
- no AndroidX dependencies
- no MultiDex dependency
- no network permission
- no browser launch

BUILD REQUIREMENTS:
- Android Studio
- JDK 17
- Android SDK Platform 35
- Android Gradle Plugin 8.7.3 / Gradle 8.9

BUILD:
1. Extract this ZIP.
2. In Android Studio choose Open and select the extracted NerveNet folder.
3. Allow Gradle Sync and install any requested SDK components.
4. Select Build > Build Bundle(s) / APK(s) > Build APK(s).
5. APK output:
   app/build/outputs/apk/debug/app-debug.apk

IMPORTANT COMPATIBILITY NOTE:
The source uses APIs available on old Android versions and sets minSdk 15.
The modern build toolchain still needs a modern JDK and SDK on the computer.
A successful build does not prove device compatibility. Install and test on the
actual Acer A200. If it crashes, collect ADB logcat for diagnosis.

The current UI is a starter shell. MEMBERS, MESSAGES and SETTINGS are placeholders.
