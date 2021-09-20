#!/bin/bash
if [ $(grep -w ^$1 /etc/passwd) ] && [ $(grep -w ^$2 /etc/group) ]
then
	echo Tanto el usuario $1 como el grupo $2 existen
else
	if [ ! $(grep -w ^$1 /etc/passwd) ]
	then
		echo El usuario $1 no existe
	else
		echo El usuario $1 existe
	fi

	if [ ! $(grep -w ^$2 /etc/group) ]
	then
		echo El grupo $2 no existe
	else
		echo El grupo $2 existe
	fi
fi
