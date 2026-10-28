#!/usr/bin/env bash
# Сборка APK прямо в песочнице агента: JDK 17 + Android SDK 34 + Gradle 8.7.
set -euo pipefail
SDK=/workspace/android-sdk
export JAVA_HOME=/workspace/jdk
export ANDROID_HOME="$SDK"; export ANDROID_SDK_ROOT="$SDK"
export PATH="$JAVA_HOME/bin:$SDK/cmdline-tools/latest/bin:$PATH"
cd /workspace/mavis-android-demo
echo "sdk.dir=$SDK" > local.properties
/workspace/gradle-8.7/bin/gradle assembleDebug --no-daemon --console=plain
ls -la app/build/outputs/apk/debug/
