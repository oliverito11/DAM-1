#!/bin/bash
#Ejemplo: Comprobar si existe un directorio, y si existe comprobar si hay archivos dentro.
#Este script se guarda, se le dan permisos de ejecución y se comprueba que funciona en los 3 casos. 
directorio=/home/profesor
if [ ! -d $directorio ]
then 
     echo "El directorio no existe"
else 
     if [ "$(ls $directorio)" ]
     then  
         echo "el directorio tiene algo"
     else 
         echo "el directorio está vacío"
     fi
fi
