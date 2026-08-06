@echo off
REM Build APK debug cho Avatar258
cd /d "%~dp0"
call gradlew.bat buildApkDebug
if %ERRORLEVEL% NEQ 0 exit /b %ERRORLEVEL%
echo.
echo APK debug: android\build\outputs\apk\debug\android-debug.apk
pause
