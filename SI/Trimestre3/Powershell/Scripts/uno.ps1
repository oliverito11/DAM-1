Clear-Host
Write-Host "Hola mundo"
#Get-ChildItem
#Comentario unilinea
<#
Comentario multilínea
#>

#Variables
[int]$edad = 23
$nombre = "Pedro"
Write-Host "Edad de $nombre : $edad"

#Pedir valores
Write-Host "Dame tu nombre:"
$nombre = Read-Host
Write-Host "Dame tu edad:"
$edad = Read-Host
Write-Host "Edad de $nombre : $edad"
$edad++
Write-Host $edad
