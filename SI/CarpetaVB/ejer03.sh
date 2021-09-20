#!/bin/bash
if [ -d $1 ]
then
	echo El directorio $1 existe
else
	echo El directorio $1 NO existe
fi
