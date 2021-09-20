foreach($fich in Get-ChildItem "$HOME\Scripts"){
    Write-Host $fich
    Copy-Item $HOME\scripts\$fich Z:\
}