@echo off
chcp 65001 >nul
cd /d "%~dp0"
set "SDK="

REM 
if defined ANDROID_SDK_ROOT if exist "%ANDROID_SDK_ROOT%\platform-tools\adb.exe" set "SDK=%ANDROID_SDK_ROOT%"
if not defined SDK if defined ANDROID_HOME if exist "%ANDROID_HOME%\platform-tools\adb.exe" set "SDK=%ANDROID_HOME%"

REM 
if not defined SDK if exist "%LOCALAPPDATA%\Android\Sdk\platform-tools\adb.exe" set "SDK=%LOCALAPPDATA%\Android\Sdk"
if not defined SDK if exist "%USERPROFILE%\Android\Sdk\platform-tools\adb.exe" set "SDK=%USERPROFILE%\Android\Sdk"

REM 
set "AVATAR_LP=%~dp0..\..\Avatar 2D Client LibGDX\Avatar 2D Client LibGDX\local.properties"
if not defined SDK if exist "%AVATAR_LP%" (
  for /f "usebackq tokens=1,* delims==" %%a in ("%AVATAR_LP%") do (
    if /i "%%a"=="sdk.dir" set "SDK=%%b"
  )
)

REM 
if not defined SDK (
  for /f "usebackq tokens=1,* delims==" %%a in ("gradle.properties") do (
    if /i "%%a"=="androidSdkDir" set "SDK=%%b"
  )
)

if not defined SDK (
  echo ========================================
  echo  KHONG TIM THAY ANDROID SDK
  echo ========================================
  echo.
  echo Project Avatar 2D Client LibGDX cung can file local.properties
  echo voi dong: sdk.dir=...  ^(khong commit len git^)
  echo.
  echo Hay lam 1 trong cac buoc:
  echo   1. Cai Android Studio + SDK Manager
  echo   2. Nhap duong dan thu muc SDK ben duoi
  echo      ^(phai co platform-tools\adb.exe^)
  echo.
  set /p SDK="Nhap duong dan SDK: "
)

REM 
for /f "tokens=* delims= " %%a in ("%SDK%") do set "SDK=%%a"

if not exist "%SDK%\platform-tools\adb.exe" (
  echo.
  echo LOI: Khong thay adb tai:
  echo   "%SDK%\platform-tools\adb.exe"
  echo.
  echo Sua gradle.properties: androidSdkDir=DUONG_DAN_SDK
  echo Hoac tao local.properties: sdk.dir=DUONG_DAN_SDK
  pause
  exit /b 1
)

set "SDK_FWD=%SDK:\=/%"
>local.properties echo sdk.dir=%SDK_FWD%

echo.
echo Da tao local.properties:
type local.properties
echo.
echo Tiep theo: gradlew.bat buildApkDebug
pause
