-- TODAS LAS EJECUCIONES QUEDAN REGISTRADAS EN LA HERRAMIENTA Y EN EL DICCIONARIO DE DATOS (DD) --

    -- CREAR USUARIO --
CREATE USER DAM5
    IDENTIFIED BY DAM5;

    -- MODIFICAR USUARIO --
ALTER USER DAM5
    IDENTIFIED BY DAM5
    DEFAULT TABLESPACE USERS
    TEMPORARY TABLESPACE TEMP
    QUOTA 500K ON USERS;

    -- BORRAR USUARIO --

DROP USER DAM5 CASCADE; 
-- CON CASCADE BORRA TODOS LOS OBJETOS ASIGNADOS A ESTE USUARIO ANTES DE BORRAR AL PROPIO USUARIO --

    -- VISUALIZAR USUARIOS --
-- Para ello, se tiene que entrar dentro de la herramienta y dentro de un usuario,
-- ir al apartado de OTROS USUARIOS --

            -- PRIVILEGIOS DE SISTEMA Y DE OBJETOS --
                        -- AÑADIR --
-- A la hora de indicar que puede crear una tabla, se indica explicitamente que puede
-- modificarla, consultarla, etc. Para otorgar permisos en modo comando se indica lo siguiente:

-- DE SISTEMA --
GRANT [PRIVILEGIO], [PRIVILEGIO2]..., ALL PRIVILEGES
    TO [USER], [USER2]
    [WITH ADMIN OPTION]; -- PUEDE CONCEDER SUS PRIVILEGIOS A OTROS USUARIOS --

-- DE OBJETO --
GRANT [PRIVILEGIO], [PRIVILEGIO2]..., ALL PRIVILEGES
    TO [USER.]OBJETO
    [WITH GRANT OPTION]; -- PUEDE CONCEDER SUS PRIVILEGIOS A OTROS USUARIOS --
    
-- EJEMPLO DE SISTEMA: El usuario DAM5 podrá iniciar sesión, crear una tabla en su esquema y consultar cualquier tabla --
GRANT CREATE SESSION, CREATE TABLE, SELECT ANY TABLE
    TO DAM5;

-- EJEMPLO DE OBJETOS: Los usuarios DAM1 y DAM5 podrán consultar, borrar, modificar e insertar datos en la tabla T_ASIR --
GRANT SELECT, DELETE, UPDATE, INSERT
    ON ASIR1.T_ASIR
    TO DAM1, DAM5;

-- PODEMOS CONSEGUIR ESTE EFECTO SOBRE CIERTAS COLUMNAS CON EL SIGUIENTE EJEMPLO:
-- Tener en cuenta que de estas opciones solo se puede modificar o insertar --
GRANT SELECT, DELETE, UPDATE(COLUMNA_B), INSERT(COLUMNA_A)
    ON ASIR1.T_ASIR
    TO DAM1, DAM5;

                            -- RETIRAR --
-- DE SISTEMA --
REVOKE PRIVILEGIOS
    FROM USER;

-- DE OBJETO --
REVOKE PRIVILEGIO_OBJETO
    ON [USUARIO.]OBJETO
    FROM USUARIO;

-- EJEMPLO DE SISTEMA --
REVOKE SELECT ANY TABLE
    FROM DAM5;

-- EJEMPLO DE OBJETOS --
REVOKE DELETE, UPDATE
    ON ASIR1.T_ASIR
    FROM DAM1;
-- DE ESTA MANERA SOLO PODEMOS QUITAR LOS PRIVILEGIOS DE TODAS LAS COLUMNAS.
-- SI QUEREMOS HACERLO SOBRE SOLO UNA, TENDREMOS QUE QUITAR TODAS Y VOLVER A INSERTAR EL
-- QUE QUERAMOS QUE SIGA MANTENIENDO. --

        -- TODAS ESTAS OPERAICONES SE PUEDEN APLICAR A UN ROL EN VEZ DE A UN USUARIO --

                        -- GESTIÓN DE ROLES --
                        -- CREAR UN ROL --
-- Se puede asignar un rol a otro rol --
CREATE ROLE ROLDAM1;

GRANT SELECT
    ON ASIR1.T_ASIR -- ASIGNAMOS PERMISOS DE OBJETO --
    TO ROLDAM1;

GRANT CREATE TABLE  -- ASIGNAMOS PERMISOS DE SISTEMA --
    TO ROLDAM1;

GRANT ROLDAM1       -- ASIGNAMOS EL ROL A UN USUARIO --
    TO DAM5;

                        -- PERFILES --
            -- Restricciones que se pueden aplicar a usuarios, como por ejemplo restringir el tiempo de sesión.
            -- Existe un perfil por defecto para cada nuevo usuario. Este perfil se tiene que establecer --

-- CREAR PERFIL --
CREATE PROFILE NOMBRE
    LIMIT RECURSO {ENTERO | UNLIMITED | DEFAULT};

-- BORRAR PERFIL --
DROP PROFILE NOMBRE [CASCADE];

-- EJEMPLO DE PERFIL --
-- Limita la cantidad de sesiones que un usuario puede realizar --
CREATE PROFILE PERFIL
    LIMIT SESSIONS_PER_USER 1;

-- Para asignarle el perfil a un usuario se tiene que hacer de la siguiente manera: --
ALTER USER USUARIO
    IDENTIFIED BY USUARIO_CLAVE
    PROFILE PERFIL;

                        -- CONSULTAS AL DD --
-- DBA para usuarios que tienen privilegios DBA / USER para consultar datos en el ámbito de usuario / ALL para intentar visualizar datos con todos los privilegios posibles del usuario
-- TABLAS --
SELECT * FROM TAB;

-- USUARIOS --
DESC DBA_USERS | USER_USERS | ALL_USERS

-- ROLES --
DESC DBA_ROLES

-- ROLES ASIGNADOS A ROLES O A USUARIOS --
DESC DBA_ROLE_PRIVS

-- PRIVILEGIOS DEL SISTEMA --
DESC DBA_SYS_PRIVS;

-- PERMISOS SOBRE TABLAS --
DESC DBA_TAB_PRIVS;

-- PERMISOS SOBRE COLUMNAS --
DESC DBA_COL_PRIVS;