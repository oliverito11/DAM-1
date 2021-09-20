#!/bin/bash
usuario="alberto"
grupo="bucaneros"
rutaOrigen="/media/sf_CarpetaVB/ejercicio3"
addgroup $grupo
adduser $1
usermod $grupo $1

mkdir /home/$1/ejercicio3
cp -r $rutaOrigen/* /home/$1/ejercicio3
chown -R $1 /home/$1/ejercicio3
chgrp -R $grupo /home/$1/ejercicio3
