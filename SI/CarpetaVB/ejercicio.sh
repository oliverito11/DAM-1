#!/bin/bash
i=0
for fichero in $(ls /home/profesor/cubo/)
do
	let i=i+1
done
echo Hay $i ficheros en ese directorio
