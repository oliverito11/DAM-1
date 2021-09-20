#!/bin/bash

if [ $(grep -w $1 /etc/passwd) ]
then
	echo El usuario $1 existe
else
	echo El usuario $1 NO existe
fi
