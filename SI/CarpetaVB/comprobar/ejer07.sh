#!/bin/bash
if [ -z $3 ]
then
	echo Se han pasado más de 2 parámetros
elif [ -z $2 ]
then
	echo Se han pasado 2 parámetros
else
	echo Se ha pasado 1 parámetro
fi
