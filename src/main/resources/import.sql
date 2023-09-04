-- |***** ACADEMICA *****|

-- FACULTAD
INSERT INTO facultad (id, nombre) VALUES (1, 'Ingeniería Electronica y Telecomunicaciones');

-- DEPARTAMENTO
INSERT INTO departamento (id, nombre, facultadId) VALUES (1, 'Sistemas', 1);

-- PROGRAMAS
INSERT INTO programa (id, nombre, departamentoId) VALUES (1, 'Ingeniería de Sistemas', 1);




-- |***** USUARIO *****|

-- USUARIO
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10611', 'cc', 'masculino', 'Miguel', 'Mosquera', '3225864404', 'miguelmonje@unicauca.edu.co');

-- ROL USUARIO
INSERT INTO rol_usuario (id, usuarioNumeroDocumento, estado, fechaInicio) VALUES (1, '10611', 'activo', '2023-08-30');

-- ROL POSGRADO
INSERT INTO rol_posgrado (rolUsuarioId, programaId) VALUES (1,1);

-- ROL PREGRADO
INSERT INTO rol_pregrado (rolUsuarioId, programaId) VALUES (1,1);

-- ROL EGRESADO
INSERT INTO rol_egresado (rolUsuarioId) VALUES (1);

-- ROL INVESTIGADOR EXTERNO
INSERT INTO rol_investigador_externo (rolUsuarioId) VALUES (1);

-- ROL DOCENTE
INSERT INTO rol_docente (rolUsuarioId, CvLAC, departamentoId) VALUES (1, 'www.cvlac.com', 1);

-- ROL FUNCIONARIO
INSERT INTO rol_funcionario (rolUsuarioId) VALUES (1);




-- |***** PROYECTO *****|

-- DOCUMENTACION
INSERT INTO documentacion (id, nombre) VALUES (1, 'PagaFor-24');

-- TIPO FINANCIACION
INSERT INTO tipofinanciacion (id, tipo) VALUES (1, 'interno');

-- CHECKLIST
INSERT INTO checklist (id, tipoFinanciacionId, documentacionId) VALUES (1, 1, 1);

-- CONVOCATORIA
INSERT INTO convocatoria (id, nombre, objetivos, oferente, fechaInicio, fechaFin, estado, recurrente, tipoFinanciacionId) VALUES (1, 'Internos 2023', 'Ayudar a la investigacion de la U', 'Universidad del Cauca', '2023-08-30', '2024-08-30', 'activa', true, 1);

-- PROYECTO
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, convocatoriaId) VALUES (1, 'Proyecto super Elegante', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', '', '', '', '', '', '', '', 1);

-- ROL PROYECTO
INSERT INTO rolproyecto (id, nombre) VALUES (1, 'Director de Proyecto');

-- INTEGRANTE PROYECTO
INSERT INTO integranteProyecto (id, fechaInicio, fechaFin, estado, proyectoId, usuarioId, rolId) VALUES (1, '2024-08-30', '2024-08-30', 'activo', 1, '10611', 1);