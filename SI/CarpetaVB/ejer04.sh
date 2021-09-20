#!/bin/bash
if [ -f $1 ]
then
	echo El fichero $1 existe
else
	echo El fichero $1 NO existe
fi
