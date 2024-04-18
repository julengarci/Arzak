DROP TABLE IF EXISTS MENU_PLATOS CASCADE;
DROP TABLE IF EXISTS RESERVAS CASCADE;
DROP TABLE IF EXISTS MENU CASCADE;
DROP TABLE IF EXISTS CLIENTES CASCADE;
DROP TABLE IF EXISTS PLATOS CASCADE;
DROP TABLE IF EXISTS INGREDIENTES CASCADE;


CREATE TABLE MENU(
    ID_MENU INT NOT NULL AUTO_INCREMENT,
    PRECIO DECIMAL(5,2),
    FECHA_INICIO DATE,
    FECHA_FIN DATE,
    PRIMARY KEY (ID_MENU)
);

CREATE TABLE MENU_PLATOS(
    ID_MENU INT NOT NULL,
    ID_PLATOS INT NOT NULL
);

CREATE TABLE PLATOS(
    ID_PLATOS INT NOT NULL AUTO_INCREMENT,
    NOMBRE VARCHAR(100) NOT NULL,
    TIPO VARCHAR(100) NOT NULL,
    ID_INGREDIENTE INT NOT NULL,
    PRIMARY KEY (ID_PLATOS)
);

CREATE TABLE RESERVAS(
    ID_RESERVA INT NOT NULL AUTO_INCREMENT,
    HORA_RESERVA DATETIME NOT NULL,
    FECHA_RESERVA DATE NOT NULL,
    NUM_PERSONAS INT NOT NULL,
    OBSERVACIONES VARCHAR(200),
    ALERGENOS VARCHAR(100),
    ID_CLIENTE INT NOT NULL,
    ID_MENU INT NOT NULL,
    PRIMARY KEY (ID_RESERVA)
);

CREATE TABLE CLIENTES(
    ID_CLIENTE INT NOT NULL AUTO_INCREMENT,
    NOMBRE_CLIENTE VARCHAR(100) NOT NULL,
    TELEFONO VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID_CLIENTE)
);

CREATE TABLE INGREDIENTES(
    ID_INGREDIENTE INT NOT NULL AUTO_INCREMENT,
    NOMBRE VARCHAR(100) NOT NULL,
    ALERGENOS ENUM('NINGUNO', 'GLUTEN', 'CRUSTACEOS', 'MOLUSCOS', 'PESCADO', 'HUEVOS', 'ALTRAMUCES', 'MOSTAZA', 'CACAHUETES', 'FRUTOS SECOS', 'SOJA', 'SESAMO', 'APIO', 'LECHE', 'ANHIDRIDO SULFUROSO') NOT NULL,
    PRIMARY KEY (ID_INGREDIENTE)
);

-- Eliminar los procedimientos almacenados si existen
DROP PROCEDURE IF EXISTS insert_menu;
DROP PROCEDURE IF EXISTS insert_ingrediente;
DROP PROCEDURE IF EXISTS insert_plato;
DROP PROCEDURE IF EXISTS insert_cliente;
DROP PROCEDURE IF EXISTS insert_reserva;

-- Crear el procedimiento almacenado para insertar datos en la tabla MENU
DELIMITER $$
CREATE PROCEDURE insert_menu (precio DECIMAL(5,2), fecha_inicio DATE, fecha_fin DATE) 
BEGIN 
    INSERT INTO MENU (PRECIO, FECHA_INICIO, FECHA_FIN) 
    VALUES(precio, fecha_inicio, fecha_fin);
END$$
DELIMITER ;

-- Crear el procedimiento almacenado para insertar datos en la tabla INGREDIENTES
DELIMITER $$
CREATE PROCEDURE insert_ingrediente (nombre VARCHAR(50), alergenos VARCHAR(100)) 
BEGIN 
    INSERT INTO INGREDIENTES (NOMBRE, ALERGENOS) 
    VALUES(nombre, alergenos);
END$$
DELIMITER ;

-- Crear el procedimiento almacenado para insertar datos en la tabla PLATOS
DELIMITER $$
CREATE PROCEDURE insert_plato (nombre VARCHAR(50), tipo VARCHAR(16), id_ingrediente INT) 
BEGIN
    INSERT INTO PLATOS (NOMBRE, TIPO, ID_INGREDIENTE)
    VALUES(nombre, tipo, id_ingrediente);
END$$
DELIMITER ;

-- Crear el procedimiento almacenado para insertar datos en la tabla CLIENTES
DELIMITER $$
CREATE PROCEDURE insert_cliente (nombre_cliente VARCHAR(16), telefono VARCHAR(11), email VARCHAR(30)) 
BEGIN
    INSERT INTO CLIENTES (NOMBRE_CLIENTE, TELEFONO, EMAIL)
    VALUES(nombre_cliente, telefono, email);
END$$
DELIMITER ;

-- Crear el procedimiento almacenado para insertar datos en la tabla RESERVAS
DELIMITER $$
CREATE PROCEDURE insert_reserva (hora_reserva TIMESTAMP, fecha_reserva DATE, n_personas INT, observaciones VARCHAR(200), alergenos VARCHAR(100), id_cliente INT, id_menu INT) 
BEGIN
    INSERT INTO RESERVAS (HORA_RESERVA, FECHA_RESERVA, NUM_PERSONAS, OBSERVACIONES, ALERGENOS, ID_CLIENTE, ID_MENU)
    VALUES(hora_reserva, fecha_reserva, num_personas, observaciones, alergenos, id_cliente, id_menu);
END$$
DELIMITER ;

-- Ejecución de los procedimientos para agregar datos a las tablas
CALL insert_menu(30, '2024-05-23', '2024-05-30');
CALL insert_ingrediente('Huevo', 'HUEVOS');
CALL insert_plato('tortilla de patata', 'Segundo', 1);
CALL insert_cliente('Joaquin', '697439798', 'JOAQUIN@GMAIL.COM');
CALL insert_reserva('2024-04-16 18:00:00', '2024-04-16', 3, 'Sin restricciones dietéticas', 'NINGUNO', 1, 1);
