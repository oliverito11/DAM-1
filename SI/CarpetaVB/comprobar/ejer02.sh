#!/bin/bash
if [ grep -w $1 /etc/group ]
then
	echo "Existe el grupo"
else
	echo "El grupo no existe"
fi
