-- |***** CONVOCATORIA *****|

-- DOCUMENTACION
INSERT INTO documentacion (id, nombre) VALUES (1, 'PagaFor-24');
INSERT INTO documentacion (id, nombre) VALUES (2, 'PagaFor-25');
INSERT INTO documentacion (id, nombre) VALUES (3, 'PagaFor-26');
INSERT INTO documentacion (id, nombre) VALUES (4, 'PagaFor-27');
INSERT INTO documentacion (id, nombre) VALUES (5, 'PagaFor-28');

-- TIPO FINANCIACION
INSERT INTO tipofinanciacion (id, tipo) VALUES (1, 'Interno');
INSERT INTO tipofinanciacion (id, tipo) VALUES (2, 'Externo');

-- CHECKLIST
INSERT INTO checklist (id, tipoFinanciacionId, documentacionId) VALUES (1, 1, 1);
INSERT INTO checklist (id, tipoFinanciacionId, documentacionId) VALUES (2, 1, 2);
INSERT INTO checklist (id, tipoFinanciacionId, documentacionId) VALUES (3, 1, 3);
INSERT INTO checklist (id, tipoFinanciacionId, documentacionId) VALUES (4, 2, 4);
INSERT INTO checklist (id, tipoFinanciacionId, documentacionId) VALUES (5, 2, 5);

-- CONVOCATORIA
INSERT INTO convocatoria (id, nombre, objetivos, oferente, fechaInicio, fechaFin, estado, recurrente, eliminadoLogico, tipoFinanciacionId) VALUES (1, 'Internos 2023', 'Ayudar a la investigación de la U 2023', 'Universidad del Cauca', '2023-01-01', '2023-12-31', 'ABIERTA', true, false, 1);
INSERT INTO convocatoria (id, nombre, objetivos, oferente, fechaInicio, fechaFin, estado, recurrente, eliminadoLogico, tipoFinanciacionId) VALUES (2, 'Internos 2022', 'Ayudar a la investigación de la U 2022', 'Universidad del Cauca', '2022-01-01', '2024-12-31', 'CERRADA', true, false, 1);
INSERT INTO convocatoria (id, nombre, objetivos, oferente, fechaInicio, fechaFin, estado, recurrente, eliminadoLogico, tipoFinanciacionId) VALUES (3, 'Internos 2024', 'Ayudar a la investigación de la U 2024', 'Universidad del Cauca', '2024-01-01', '2024-12-31', 'PROGRAMADA', true, false, 1);
INSERT INTO convocatoria (id, nombre, objetivos, oferente, fechaInicio, fechaFin, estado, recurrente, eliminadoLogico, tipoFinanciacionId) VALUES (4, 'Sistemas de producción mejorados Licorera del Cauca', 'Plan para mejorar el sistema de producción', 'Licorería del Cauca', '2024-01-01', '2024-12-31', 'PROGRAMADA', true, false, 2);




-- |***** PROYECTO *****|

-- PROYECTO
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (1, 'Proyecto super Elegante', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 1);


-- |***** ACADEMICA *****|
--
-- -- FACULTAD
-- INSERT INTO facultad (id, nombre) VALUES (1, 'Ingeniería Electronica y Telecomunicaciones');
--
-- -- DEPARTAMENTO
-- INSERT INTO departamento (id, nombre, facultadId) VALUES (1, 'Sistemas', 1);
--
-- -- PROGRAMAS
-- INSERT INTO programa (id, nombre, departamentoId) VALUES (1, 'Ingeniería de Sistemas', 1);
--
--
--
--
-- -- |***** USUARIO *****|
--
-- -- USUARIO
-- INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10611', 'cc', 'masculino', 'Miguel', 'Mosquera', '3225864404', 'miguelmonje@unicauca.edu.co');
--
-- -- ROL USUARIO
-- INSERT INTO rol_usuario (id, usuarioNumeroDocumento, estado, fechaInicio) VALUES (1, '10611', 'activo', '2023-08-30');
--
-- -- ROL POSGRADO
-- INSERT INTO rol_posgrado (rolUsuarioId, programaId) VALUES (1,1);
--
-- -- ROL PREGRADO
-- INSERT INTO rol_pregrado (rolUsuarioId, programaId) VALUES (1,1);
--
-- -- ROL EGRESADO
-- INSERT INTO rol_egresado (rolUsuarioId) VALUES (1);
--
-- -- ROL INVESTIGADOR EXTERNO
-- INSERT INTO rol_investigador_externo (rolUsuarioId) VALUES (1);
--
-- -- ROL DOCENTE
-- INSERT INTO rol_docente (rolUsuarioId, CvLAC, departamentoId) VALUES (1, 'www.cvlac.com', 1);
--
-- -- ROL FUNCIONARIO
-- INSERT INTO rol_funcionario (rolUsuarioId) VALUES (1);
--
--
--
--
--
--
--

-- -- -- ROL PROYECTO
-- -- INSERT INTO rolproyecto (id, nombre) VALUES (1, 'Director de Proyecto');
-- --
-- -- -- INTEGRANTE PROYECTO
-- -- INSERT INTO integrante_proyecto (id, fechaInicio, fechaFin, estado, proyectoId, usuarioId, rolId) VALUES (1, '2024-08-30', '2024-08-30', 'activo', 1, '10611', 1);
-- --
-- -- -- ENFOQUE DIFERENCIAL
-- -- INSERT INTO enfoque_diferencial (id, nombre) VALUES (1, 'Comunidad LGBTIQ+');
-- --
-- -- -- ENFOQUE DIFERENCIAL PROYECTO
-- -- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (1, 1, 1);