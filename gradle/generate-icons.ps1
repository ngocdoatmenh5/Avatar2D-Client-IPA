Add-Type -AssemblyName System.Drawing
$src = Join-Path $PSScriptRoot "..\lwjgl3\icons\logo.png"
$img = [System.Drawing.Image]::FromFile($src)
$sizes = @{
  'mipmap-mdpi'    = 48
  'mipmap-hdpi'    = 72
  'mipmap-xhdpi'   = 96
  'mipmap-xxhdpi'  = 144
  'mipmap-xxxhdpi' = 192
}
$androidRes = Join-Path $PSScriptRoot "..\android\res"
foreach ($folder in $sizes.Keys) {
  $dir = Join-Path $androidRes $folder
  New-Item -ItemType Directory -Force -Path $dir | Out-Null
  $size = $sizes[$folder]
  $bmp = New-Object System.Drawing.Bitmap $size, $size
  $g = [System.Drawing.Graphics]::FromImage($bmp)
  $g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
  $g.DrawImage($img, 0, 0, $size, $size)
  $g.Dispose()
  $bmp.Save((Join-Path $dir 'ic_launcher.png'), [System.Drawing.Imaging.ImageFormat]::Png)
  $bmp.Dispose()
}
$lwjglRes = Join-Path $PSScriptRoot "..\lwjgl3\src\main\resources"
foreach ($s in @(16, 32, 64, 128)) {
  $bmp = New-Object System.Drawing.Bitmap $s, $s
  $g = [System.Drawing.Graphics]::FromImage($bmp)
  $g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
  $g.DrawImage($img, 0, 0, $s, $s)
  $g.Dispose()
  $bmp.Save((Join-Path $lwjglRes "app_icon$s.png"), [System.Drawing.Imaging.ImageFormat]::Png)
  $bmp.Dispose()
}
$img.Dispose()
Write-Host "Icons generated."
