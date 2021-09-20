<#
1º CREAR ARCHIVO de texto plano "usuarios.csv"

en la primera línea:               nombre,contrasenia
en las siguientes líneas           alumno01,Fernando3
                                   alumno02,Fernando3
                                   alumno03,Fernando3
#>

#Creación de usuarios de forma masiva.
$usuarios=Import-Csv -Path .\usuarios.csv   #EL FICHERO DEBE EXISTIR
foreach  ($i in $usuarios){
    $pn=$i.nombre + "@eldominio141.es"
    $clave=ConvertTo-SecureString $i.contrasenia -AsPlainText -Force
    New-ADUser -Name $i.nombre -Path:"OU=AULA522,DC=eldominio225,DC=es" -AccountPassword $clave -PasswordNeverExpires:$true -Enabled $true -UserPrincipalName $pn -GivenName $i.nombre
    # prueba es una OU (Unidad Organizativa)
    # eldominio225.es es el dominio
    # si cambiamos el parámetro -Path:"CN=Users,DC=eldominio225,DC=es"  en este caso pasa a ser miembro de "usuarios del dominio"
   
    Add-ADGroupMember -Identity DAM1 -Members $i.nombre #añadimos al grupo ALUMNOSDECLASE
}