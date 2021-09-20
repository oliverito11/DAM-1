
#Comprobaciones de todos los parámetros
if($args.Count -lt 2){
    #Comprobación de argumentos
    Write-Host "El programa requiere de argumentos (grupo, UO)"
}elseif(-Not (Test-Path -Path '.\usuarios 1.csv')){
    #Comprobación del fichero csv
    Write-Host "El programa requiere de un fichero .csv válido"
}elseif(-Not (Get-ADGroup -Filter "Name -eq '$($args[0])'")){
    #Comprobación de la existencia del grupo. En caso de que no exista, se crea
    Write-Host "No existe el grupo $($args[0]), creando uno nuevo..."
    New-ADGroup -Name $($args[0]) -GroupScope Global
}elseif(-Not (Get-ADOrganizationalUnit -Filter "Name -eq '$($args[1])'")){
    #Comprobación de la existencia de la UO. En caso de que no exista, se crea
    Write-Host "No existe la UO $($args[1]), creando una nueva..."
    New-ADOrganizationalUnit -Name $($args[1]) -ProtectedFromAccidentalDeletion $false
}

#Import de los usuarios del fichero csv
$usuarios=Import-Csv -Path '.\usuarios 1.csv' -Delimiter ';'

#Por cada usuario del archivo csv...
foreach($u in $usuarios){
    #Nombre de inicio de sesión
    $nom=$u.nombre + "@dominio141.dom"
    
    #Contraseña
    $clave=ConvertTo-SecureString $u.contrasenia -AsPlainText -Force

    #Si el usuario ya existe, se le indica al usuario. En caso contrario, se crea con las propiedades pedidas y a continuación se añade al grupo.
    if(Get-ADUser -Filter "Name -eq '$($u.nombre)'" -){
        Write-Host "Ya existe el usuario $($u.nombre)"
    }else{
        New-ADUser -Name $u.nombre -Path:"OU=$($args[1]),DC=dominio141,DC=dom" -AccountPassword $clave -PasswordNeverExpires:$true -Enabled $true -UserPrincipalName $nom -GivenName $u.nombre
        Add-ADGroupMember -Identity $($args[0]) -Members $u.nombre
    }
}