#No podemos usar esto para que nos devuelva el valor
Write-Host "Hola $args[0] tienes $args[1] años"

#Tenemos que indicarlo de la siguiente manera
Write-Host "Hola $($args[0]) tienes $($args[1]) años"

Write-Host "Se han pasado $($args.count) argumentos"

#Para mostrar todos los argumentos pasados al prográma, ponemos simplemente $args
Write-Host $args