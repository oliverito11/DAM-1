Write-Host "        Menú"
Write-Host "===================="
Write-Host "[1] - Ver el nombre del usuario activo"
Write-Host "[2] - Ver el nombre del directorio activo"
Write-Host "[3] - Ver los ficheros del directorio activo"
Write-Host "[4] - Comprobar si existe un directorio"
Write-Host "[5] - Salir"
$opc=Read-Host "Elige una opción"

switch ($opc)
{
    '1' {
        whoami
    }
    '2' {
        Get-Location
    }
    '3' {
        Get-ChildItem .\
    }
    '4' {
        $fich=Read-Host "Dame la ruta de un directorio"
        if(Test-Path -Path $fich){
            Write-Host "Sí existe el directorio $fich"
        }else{
            Write-Host "No existe el directorio $fich"
        }
    }
    '5' {
        Write-Host "Fin del programa"
    }
    Default {
        Write-Host "Opcion incorrecta"
    }
}