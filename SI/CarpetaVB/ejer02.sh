#!/bin/bash
if [ $(grep -w ^$1 /etc/group) ]
then
	echo El grupo $1 existe
else
	echo El grupo $1 NO existe
fi
