#!/bin/bash
if [ ! -z $3 ]
then
	echo Hay más de dos parámetros
elif [ ! -z $2 ]
then
	echo Hay dos parámetros
elif [ ! -z $1 ]
then
	echo Hay un parámetro
fi
