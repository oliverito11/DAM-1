<#               Declaración de variables
 Puedo no pasar parámetros al programa y que se tomen estos valores
 por defecto. Sin embargo, si pasamos argumentos, se reemplazarán los valores
 por defecto por los valores pasados como parámetros
 
 Si solo quiero hacer referencia a una variable puedo usar el operador "-" y el nombre
 de la variable a continuación.
#>
param(
    [string] $nombre="Pepe",
    [Parameter(Mandatory=$true)][int] $edad=10, #Variable obligatoria
    [switch] $Recursivo,        # Variable que toma valor si se llama a la hora de ejecutar el programa o no
    [datetime] $fecha           # Fecha en formato mm/dd/aaaa
)

Write-Host "Hola $nombre, el año que viene tendrás $($edad+1)"