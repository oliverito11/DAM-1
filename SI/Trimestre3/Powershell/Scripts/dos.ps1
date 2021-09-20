#Comprobar si existe el fichero uno.ps1
Clear-Host
<#
$fichero=Read-Host "Fichero:"
Para leerlo de teclado

Si queremos que se pase como parámetro, tenemos que
usar -[nombre] de la variable a la que queramos darle valor
#>
if(Test-Path -Path $fichero -PathType Leaf){
    Write-Host "Sí existe el fichero"
}else{
    Write-Host "No existe el fichero"
}