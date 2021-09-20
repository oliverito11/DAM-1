<#
 # PAPELERA
 # Consistirá en un programa al que se le pasará un directorio y 
 # se copiarán todos sus ficheros en una PAPELERA para, posteriormente,
 # ser eleminados de su ruta original
#>
param($dir)
$papelera="$HOME\Papelera"

#Se comprueba si existe el fichero pasado como parámetro
if(Test-Path $dir){

    #Si no existe la papelera, se crea una nueva
    if(-Not (Test-Path $papelera)){
        New-Item -Path $papelera -Type Directory
    }

    foreach($fich in Get-ChildItem -Path $dir -Recurse){
        Write-Host "Copiando y borrando $dir\$fich en $papelera"
        Copy-Item $dir\$fich $papelera
        Remove-Item $dir\$fich
    }
}else{
    Write-Host "No existe el directorio $dir"
}