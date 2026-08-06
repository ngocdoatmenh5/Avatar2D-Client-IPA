@echo off
REM Build APK release cho Avatar258
cd /d "%~dp0"
call gradlew.bat buildApk
if %ERRORLEVEL% NEQ 0 exit /b %ERRORLEVEL%
echo.
echo APK release: android\build\outputs\apk\release\android-release-unsigned.apk
pause
