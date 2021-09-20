#Una función que llame siempre a lo mismo.
Clear-Host

#Llamada a la función
ejecuta Pepe 20
ejecuta Ana 40
ejecuta Hector 22

#Declaración de la función
function ejecuta($nombre, [int]$edad){
    Write-Host "Hola $nombre tienes $edad años"
}

<#
                    Otra forma

ejecuta Pepe 20
ejecuta Ana 40
ejecuta Hector 22

function ejecuta {
    $nombre=$args[0]
    $edad=$args[1]
    Write-Host "Hola $nombre tienes $edad años"
}
#>