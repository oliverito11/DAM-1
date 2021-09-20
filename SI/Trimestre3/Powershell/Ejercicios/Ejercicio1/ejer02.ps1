param($fichero)
if(Test-Path -Path $fichero -PathType Leaf){
    Write-Host "El archivo existe"
}else{
    Write-Host "El archivo NO existe"
}