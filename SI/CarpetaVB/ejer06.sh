#!/bin/bash
if [ ! -d $1 ] || [ ! -d $2 ]
then
	echo Uno de los dos directorios no existe
else
	cp -r $1 $2
fi
