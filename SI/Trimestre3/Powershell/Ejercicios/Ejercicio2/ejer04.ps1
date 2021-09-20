param($dir)
$dir_copia="$HOME\Copia"

if(Test-Path -Path $dir){
    #Comprobar si existe o no el fichero de copia
    if(-Not (Test-Path -Path $dir_copia)){
        New-Item -Path $dir_copia -Type Directory
    }

    #Copiar los archivos .xls?
    foreach($fich in (Get-ChildItem -Path $dir -Name *.xls? -Recurse)){
        Write-Host $fich
        Copy-Item $dir\$fich $dir_copia
    }

    #Copiar los ficheros .doc?
    foreach($fich in (Get-ChildItem -Path $dir -Name *.doc? -Recurse)){
        Write-Host $fich
        Copy-Item $dir\$fich $dir_copia
    }
}else{
    Write-Host "El directorio no existe"
}