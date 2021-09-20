$dir="."
Write-Host "Nombre del directorio actual $(Get-Location)"
[int]$i=0

#Se limpia el fichero primero
if(Test-Path $HOME\lista.txt){
    Remove-Item $HOME\lista.txt
}
foreach($fichero in Get-ChildItem){
    Write-Host "$i $fichero"
    Write-Output "$i $fichero" | Out-File -FilePath $HOME\lista.txt -Append
    $i++
}