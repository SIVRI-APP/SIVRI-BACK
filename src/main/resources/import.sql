-- Insertar un registro en la tabla tipousuario para obtener el id
INSERT INTO tipousuario (id) VALUES (1); -- Aquí debes proporcionar el valor correcto para el id

-- Insertar un registro de Posgrado utilizando el id generado en la tabla tipousuario
INSERT INTO posgrado (id, programaIdPrograma) VALUES (1, 123);