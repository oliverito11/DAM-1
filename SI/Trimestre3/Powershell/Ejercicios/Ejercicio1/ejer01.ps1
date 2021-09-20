param($fichero)
if(Test-Path -Path $fichero -PathType Container){
    Write-Host "El directorio existe"
}else{
    Write-Host "El directorio NO existe"
}