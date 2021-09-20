#!/bin/bash
#Ejemplos de uso del for
for i in {10..1}
do
	echo valor: $i
done

for fichero in $(ls /home/profesor/cubo/)
do
	echo $fichero
done

for alumno in hector oliver adrian
do
	echo $alumno
done

for fichero2 in $(ls /home/profesor/cubo/*.txt)
do
	echo $fichero2
done
