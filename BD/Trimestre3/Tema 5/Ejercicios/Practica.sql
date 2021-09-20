-- Crear un perfil en el que un usuario solo pueda tener 2 conexiones activas --
CREATE PROFILE SESIONES
    LIMIT SESSIONS_PER_USER 2;

ALTER USER DAM1
    IDENTIFIED BY DAM1
    PROFILE SESIONES;

-- Para comprobar que funciona, nos conectamos con este usuario 3 veces y veremos que la tercera sesión no nos dejaría --
-- AÑADIR TIEMPO DE CONEXIÓN Y TIEMPO DE INACTIVIDAD --
ALTER PROFILE SESIONES
    LIMIT CONNECT_TIME 2 IDLE_TIME 1;