#!/bin/bash
if [ ! -d /home/$1 ]
then
	echo El usuario no existe
else
	echo El usuario sí existe
fi
