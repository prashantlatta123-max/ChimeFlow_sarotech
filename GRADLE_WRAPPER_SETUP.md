# Gradle Wrapper

This source archive does not contain a Gradle Wrapper JAR. A binary wrapper JAR is
not fabricated. The GitHub Actions workflow currently installs Gradle 8.13 directly,
so CI does not depend on a missing wrapper.

For a reproducible local build, open the project in Android Studio, use its Gradle
tooling to generate the wrapper for Gradle 8.13, then commit:
- gradlew
- gradlew.bat
- gradle/wrapper/gradle-wrapper.jar
- gradle/wrapper/gradle-wrapper.properties

After that, use `./gradlew testDebugUnitTest lintDebug assembleDebug`.
