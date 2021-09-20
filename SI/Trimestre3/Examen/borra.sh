#!/bin/bash

#Creación de la papelera
papelera=/home/$(whoami)/PAPELERA/
if [ ! -d $papelera ]
then
        mkdir $papelera
fi

#Comprobación de parámetros
if [ ! -e $1 ]
then
        echo "No existe el directorio $1"
else
        for fich in $(ls $1)
        do
                cp $fich $papelera
        done
fi