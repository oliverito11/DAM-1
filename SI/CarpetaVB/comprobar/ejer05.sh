#!/bin/bash

#Usuario
if [ grep -w ^$1 /etc/passwd ]
then
	echo "No existe el usuario"
else
	echo "El usuario sí existe"
fi

#Grupo
if [ grep -w ^$1 /etc/group ]
then
	echo "No existe el grupo"
else
	echo "El grupo sí existe"
fi
