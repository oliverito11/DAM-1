#!/bin/bash
#Se tienen que usar distintos parámetros para las comparaciones, estos vienen en el fichero dado por el profesor
if [ -d $1 ]
then
	echo Es un directorio
else
	echo No es un directorio
fi
