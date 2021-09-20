#!/bin/bash
if [ -d $2 ]
then
	cp $1 $2
else
	echo No existe el directorio.
fi
