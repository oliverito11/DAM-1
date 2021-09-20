param($archivo, $directorio)

if(Test-Path -Path $directorio -PathType Container){
    Copy-Item $archivo $directorio
}else{
    Write-Host "El directorio o archivo NO existe"
}