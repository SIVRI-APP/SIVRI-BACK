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
INSERT INTO convocatoria (id, nombre, objetivos, oferente, fechaInicio, fechaFin, estado, recurrente, eliminadoLogico, tipoFinanciacionId) VALUES (4, 'Externo Gobernacion del Cauca', 'Plan para mejorar el sistema de producción', 'Licorería del Cauca', '2024-01-01', '2024-12-31', 'PROGRAMADA', true, false, 2);





-- |***** PROYECTO *****|

-- PROYECTO
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (1, 'Proyecto Internos 2023', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (2, 'Proyecto Internos 2022', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 2);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (3, 'Proyecto Internos 2024', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 3);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (4, 'Proyecto Externo Gobernacion del Cauca', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 4);

-- ENFOQUE DIFERENCIAL
INSERT INTO enfoque_diferencial (id, nombre) VALUES (1, 'Comunidad Afro');
INSERT INTO enfoque_diferencial (id, nombre) VALUES (2, 'Comunidad Palenquera');
INSERT INTO enfoque_diferencial (id, nombre) VALUES (3, 'Comunidad Indigena');
INSERT INTO enfoque_diferencial (id, nombre) VALUES (4, 'Comunidad LGBTIQ+');

-- ENFOQUE DIFERENCIAL PROYECTO
INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (1, 1, 1);
INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (2, 2, 1);
INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (3, 3, 1);
INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (4, 4, 2);





-- |***** ACADEMICA *****|

-- FACULTAD
INSERT INTO facultad (id, nombre) VALUES (1, 'Ingeniria Electronica y Telecomunicaciones');

-- DEPARTAMENTO
INSERT INTO departamento (id, nombre, facultadId) VALUES (1, 'Departamento de Sistemas', 1);

-- PROGRAMA
INSERT INTO programa (id, nombre, departamentoId) VALUES (1, 'Ingenieria de Sistemas', 1);





-- |***** USUARIO *****|

-- USUARIO
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10611', 'cc', 'masculino', 'Miguel', 'Proyectos', '3225864404', 'miguelmonje@unicauca.edu.co');
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10612', 'cc', 'masculino', 'Yurani', 'Semilleros', '3225864404', 'correoSemilleros@unicauca.edu.co');
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10613', 'cc', 'femenino', 'Daniel', 'Grupos', '3225864404', 'correoGrupos@unicauca.edu.co');
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10614', 'cc', 'masculino', 'Martin', 'Investigador Externo', '3225864404', 'correo4@unicauca.edu.co');
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10615', 'cc', 'masculino', 'Jacob', 'Docente', '3225864404', 'correo5@unicauca.edu.co');
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10616', 'cc', 'masculino', 'Jacob', 'Egresado', '3225864404', 'correo6@unicauca.edu.co');
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10617', 'cc', 'masculino', 'Jacob', 'Pregrado', '3225864404', 'correo7@unicauca.edu.co');
INSERT INTO usuario (numeroDocumento, tipoDocumento, sexo, nombres, apellidos, telefono, correo) VALUES ('10618', 'cc', 'masculino', 'Jacob', 'Posgrado', '3225864404', 'correo8@unicauca.edu.co');

-- ROL USUARIO
INSERT INTO rol_usuario (id, estado, fechaInicio, usuarioNumeroDocumento) VALUES (1, 'ACTIVO', '2023-08-30', '10611');
INSERT INTO rol_usuario (id, estado, fechaInicio, usuarioNumeroDocumento) VALUES (2, 'ACTIVO', '2023-08-30', '10612');
INSERT INTO rol_usuario (id, estado, fechaInicio, usuarioNumeroDocumento) VALUES (3, 'ACTIVO', '2023-08-30', '10613');
INSERT INTO rol_usuario (id, estado, fechaInicio, usuarioNumeroDocumento) VALUES (4, 'ACTIVO', '2023-08-30', '10614');
INSERT INTO rol_usuario (id, estado, fechaInicio, usuarioNumeroDocumento) VALUES (5, 'ACTIVO', '2023-08-30', '10615');
INSERT INTO rol_usuario (id, estado, fechaInicio, usuarioNumeroDocumento) VALUES (6, 'ACTIVO', '2023-08-30', '10616');
INSERT INTO rol_usuario (id, estado, fechaInicio, usuarioNumeroDocumento) VALUES (7, 'ACTIVO', '2023-08-30', '10617');
INSERT INTO rol_usuario (id, estado, fechaInicio, usuarioNumeroDocumento) VALUES (8, 'ACTIVO', '2023-08-30', '10618');
INSERT INTO rol_usuario (id, estado, fechaInicio, fechaFin, usuarioNumeroDocumento) VALUES (20, 'INACTIVO', '2023-08-30', '2023-08-30', '10611');
INSERT INTO rol_usuario (id, estado, fechaInicio, fechaFin, usuarioNumeroDocumento) VALUES (21, 'INACTIVO', '2023-08-30', '2023-08-30', '10611');
INSERT INTO rol_usuario (id, estado, fechaInicio, fechaFin, usuarioNumeroDocumento) VALUES (22, 'INACTIVO', '2023-08-30', '2023-08-30', '10611');

-- ROL FUNCIONARIO
INSERT INTO rol_funcionario (rolUsuarioId) VALUES (1);
INSERT INTO rol_funcionario (rolUsuarioId) VALUES (2);
INSERT INTO rol_funcionario (rolUsuarioId) VALUES (3);

-- FUNCIÓN ADMINISTRATIVA
INSERT INTO funcion_administrativa (id, nombre) VALUES (1, 'Apoyo a Proyectos');
INSERT INTO funcion_administrativa (id, nombre) VALUES (2, 'Apoyo a Semilleros');
INSERT INTO funcion_administrativa (id, nombre) VALUES (3, 'Apoyo a Grupos');

-- FUNCIÓN ADMINISTRATIVA FUNCIONARIO
INSERT INTO funcion_administrativa_funcionario (id, estado, fechaInicio, fechaFin, funcionAdministrativaId, rolFuncionarioId) VALUES (1, 'ACTIVO', '2023-08-30', '2023-08-30', 1, 1);
INSERT INTO funcion_administrativa_funcionario (id, estado, fechaInicio, fechaFin, funcionAdministrativaId, rolFuncionarioId) VALUES (2, 'ACTIVO', '2023-08-30', '2023-08-30', 2, 2);
INSERT INTO funcion_administrativa_funcionario (id, estado, fechaInicio, fechaFin, funcionAdministrativaId, rolFuncionarioId) VALUES (3, 'ACTIVO', '2023-08-30', '2023-08-30', 3, 3);

-- ROL INVESTIGADOR EXTERNO
INSERT INTO rol_investigador_externo (rolUsuarioId) VALUES (4);

-- ROL DOCENTE
INSERT INTO rol_docente (rolUsuarioId, CvLAC, departamentoId) VALUES (5, 'www.cvlac.com', 1);

-- ROL EGRESADO
INSERT INTO rol_egresado (rolUsuarioId) VALUES (6);

-- ROL PREGRADO
INSERT INTO rol_pregrado (rolUsuarioId, programaId) VALUES (7,1);

-- ROL POSGRADO
INSERT INTO rol_posgrado (rolUsuarioId, programaId) VALUES (8,1);






-- -- -- ROL PROYECTO
-- -- INSERT INTO rolproyecto (id, nombre) VALUES (1, 'Director de Proyecto');
-- --
-- -- -- INTEGRANTE PROYECTO
-- -- INSERT INTO integrante_proyecto (id, fechaInicio, fechaFin, estado, proyectoId, usuarioId, rolId) VALUES (1, '2024-08-30', '2024-08-30', 'activo', 1, '10611', 1);
-- --
