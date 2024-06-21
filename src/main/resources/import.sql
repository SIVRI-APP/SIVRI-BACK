-- |***** ACADEMICA *****|

-- -- FACULTAD
INSERT INTO facultad (idFacultad, nombre) VALUES (1, 'Facultad de Artes');
INSERT INTO facultad (idFacultad, nombre) VALUES (2, 'Facultad de Ciencias Agrarias');
INSERT INTO facultad (idFacultad, nombre) VALUES (3, 'Facultad de Ciencias de la Salud');
INSERT INTO facultad (idFacultad, nombre) VALUES (4, 'Facultad de Ciencias Contables, Económicas y Administrativas');
INSERT INTO facultad (idFacultad, nombre) VALUES (5, 'Facultad de Ciencias Humanas y Sociales');
INSERT INTO facultad (idFacultad, nombre) VALUES (6, 'Facultad de Ciencias Naturales, Exactas y de la Educación');
INSERT INTO facultad (idFacultad, nombre) VALUES (7, 'Facultad de Derecho, Ciencias Políticas y Sociales');
INSERT INTO facultad (idFacultad, nombre) VALUES (8, 'Facultad de Ingeniería Civil');
INSERT INTO facultad (idFacultad, nombre) VALUES (9, 'Facultad de Ingeniería Electrónica y Telecomunicaciones');


-- -- DEPARTAMENTO
INSERT INTO departamento (id, nombre, facultadId) VALUES (1, 'Artes Plásticas', 1);
INSERT INTO departamento (id, nombre, facultadId) VALUES (2, 'Agroindustria', 2);
INSERT INTO departamento (id, nombre, facultadId) VALUES (3, 'Biología', 6);
INSERT INTO departamento (id, nombre, facultadId) VALUES (4, 'Ciencia Política', 7);
INSERT INTO departamento (id, nombre, facultadId) VALUES (5, 'Ciencias Administrativas', 4);
INSERT INTO departamento (id, nombre, facultadId) VALUES (6, 'Ciencias Agropecuarias', 2);
INSERT INTO departamento (id, nombre, facultadId) VALUES (7, 'Ciencias Económicas', 4);
INSERT INTO departamento (id, nombre, facultadId) VALUES (8, 'Ciencias Fisiológicas', 3);
INSERT INTO departamento (id, nombre, facultadId) VALUES (9, 'Ciencias Quirúrgicas', 3);
INSERT INTO departamento (id, nombre, facultadId) VALUES (10, 'Comunicación Social', 7);
INSERT INTO departamento (id, nombre, facultadId) VALUES (11, 'Derecho Laboral', 7);
INSERT INTO departamento (id, nombre, facultadId) VALUES (12, 'Derecho Privado', 7);
INSERT INTO departamento (id, nombre, facultadId) VALUES (13, 'Diseño', 1);
INSERT INTO departamento (id, nombre, facultadId) VALUES (14, 'Educación Física, Recreación y Deporte', 6);
INSERT INTO departamento (id, nombre, facultadId) VALUES (15, 'Enfermería', 3);
INSERT INTO departamento (id, nombre, facultadId) VALUES (16, 'Español y Literatura', 5);
INSERT INTO departamento (id, nombre, facultadId) VALUES (17, 'Estudios Interculturales', 5);
INSERT INTO departamento (id, nombre, facultadId) VALUES (18, 'Sistemas', 9);
INSERT INTO departamento (id, nombre, facultadId) VALUES (19, 'Desarrollo de Vías y Estructuras', 8);

-- -- PROGRAMAS
INSERT INTO programa (id, nombre, departamentoId) VALUES (1, 'Ingeniería de Sistemas', 9);
INSERT INTO programa (id, nombre, departamentoId) VALUES (2, 'Ingeniería civil', 1);
INSERT INTO programa (id, nombre, departamentoId) VALUES (3, 'Ingeniería Electronica', 1);
INSERT INTO programa (id, nombre, departamentoId) VALUES (4, 'Artes Plásticas', 1);






-- |***** CONVOCATORIA *****|

-- DOCUMENTO CONVOCATORIA
-- INSERT INTO documento_convocatoria (id, nombre) VALUES (1, 'PagaFor-24');
-- INSERT INTO documento_convocatoria (id, nombre) VALUES (2, 'PagaFor-25');
-- INSERT INTO documento_convocatoria (id, nombre) VALUES (3, 'PagaFor-26');
-- INSERT INTO documento_convocatoria (id, nombre) VALUES (4, 'PagaFor-27');
-- INSERT INTO documento_convocatoria (id, nombre) VALUES (5, 'PagaFor-28');


-- TIPO CONVOCATORIA
-- INSERT INTO tipo_convocatoria (id, nombre, tipoFinanciación) VALUES (1, 'Proyectos Internos 2024', 'PROYECTOS_INTERNOS');
-- INSERT INTO tipo_convocatoria (id, nombre, tipoFinanciación) VALUES (2, 'Proyectos Externos 2024', 'PROYECTOS_EXTERNOS');
-- INSERT INTO tipo_convocatoria (id, nombre, tipoFinanciación) VALUES (3, 'Alcaldía de Popayan', 'PROYECTOS_EXTERNOS');


-- LISTADO DE DOCUMENTOS
INSERT INTO documento_convocatoria (id, nombre) VALUES (1, 'Planilla de Seguridad Social');
INSERT INTO documento_convocatoria (id, nombre) VALUES (2, 'FOR-2');
INSERT INTO documento_convocatoria (id, nombre) VALUES (3, 'FOR-3');
INSERT INTO documento_convocatoria (id, nombre) VALUES (4, 'FOR-4');
INSERT INTO documento_convocatoria (id, nombre) VALUES (5, 'FOR-5');
INSERT INTO documento_convocatoria (id, nombre) VALUES (6, 'FOR-14');
INSERT INTO documento_convocatoria (id, nombre) VALUES (7, 'FOR-15');
INSERT INTO documento_convocatoria (id, nombre) VALUES (8, 'FOR-24');
INSERT INTO documento_convocatoria (id, nombre) VALUES (9, 'Registro civil de nacimiento');
INSERT INTO documento_convocatoria (id, nombre) VALUES (10, 'Acta de nacimiento del Proyecto');


-- INSERT INTO listado_de_documentos (id, tipoConvocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio) VALUES (6, 2, 1, 'PRE_EJECUCIÓN', 'DIRECTOR_PROYECTO', 1, true);
-- INSERT INTO listado_de_documentos (id, tipoConvocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio) VALUES (7, 2, 2, 'EJECUCIÓN', 'DIRECTOR_PROYECTO', 2, true);
-- INSERT INTO listado_de_documentos (id, tipoConvocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio) VALUES (8, 2, 3, 'POST_EJECUCIÓN', 'DIRECTOR_PROYECTO', 1, true);
--
-- INSERT INTO listado_de_documentos (id, tipoConvocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio) VALUES (9, 3, 3, 'PRE_EJECUCIÓN', 'DIRECTOR_PROYECTO', 1, true);
-- INSERT INTO listado_de_documentos (id, tipoConvocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio) VALUES (10, 3, 4, 'EJECUCIÓN', 'DIRECTOR_PROYECTO', 2, true);
-- INSERT INTO listado_de_documentos (id, tipoConvocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio) VALUES (11, 3, 5, 'POST_EJECUCIÓN', 'DIRECTOR_PROYECTO', 1, true);


-- CONVOCATORIA
INSERT INTO convocatoria (fechaFin, fechaInicio, id, nombre, oferente, descripcion, objetivos, estado, tipoFinanciacion) VALUES('2024-12-31', '2024-09-01', 1, 'Convocatoria de Innovación Tecnológica', 'Ministerio de Energía y Minas', 'Convocatoria destinada a financiar proyectos de innovación tecnológica en el sector de las energías renovables.', 'Fomentar la investigación y desarrollo en tecnologías limpias y sostenibles.', 'ABIERTA', 'PROYECTOS_INTERNOS');



-- |***** PROYECTO *****|

-- PROYECTO
-- INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (1, 'Proyecto Internos 2023', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 1);
-- INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (2, 'Proyecto Internos 2022', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 2);
-- INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (3, 'Proyecto Internos 2024', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 3);
-- INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (4, 'Proyecto Externo Gobernacion del Cauca', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 4);

-- ENFOQUE DIFERENCIAL
-- INSERT INTO enfoque_diferencial (id, nombre) VALUES (1, 'Comunidad Afro');
-- INSERT INTO enfoque_diferencial (id, nombre) VALUES (2, 'Comunidad Palenquera');
-- INSERT INTO enfoque_diferencial (id, nombre) VALUES (3, 'Comunidad Indigena');
-- INSERT INTO enfoque_diferencial (id, nombre) VALUES (4, 'Comunidad LGBTIQ+');

-- ENFOQUE DIFERENCIAL PROYECTO
-- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (1, 1, 1);
-- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (2, 2, 1);
-- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (3, 3, 1);
-- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (4, 4, 2);





-- |***** USUARIO *****|

-- USUARIO
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (1, 'mandresmosquera@gmail.com', 'CEDULA_CIUDADANIA', '10611', 'MASCULINO', 'ADMINISTRATIVO', 'Miguel', 'Mosquera', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (2, 'yurani@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10612', 'MASCULINO', 'ADMINISTRATIVO', 'Yurani', 'Mosquera', '3225864404' );

-- ROL FUNCIONARIO
INSERT INTO rol_funcionario (id, nombre) VALUES (1, 'SUPER_ADMIN');
INSERT INTO rol_funcionario (id, nombre) VALUES (2, 'USUARIOS');
INSERT INTO rol_funcionario (id, nombre) VALUES (3, 'GRUPOS');
INSERT INTO rol_funcionario (id, nombre) VALUES (4, 'SEMILLEROS');
INSERT INTO rol_funcionario (id, nombre) VALUES (5, 'PROYECTOS_INTERNOS');
INSERT INTO rol_funcionario (id, nombre) VALUES (6, 'PROYECTOS_EXTERNOS');
INSERT INTO rol_funcionario (id, nombre) VALUES (7, 'VICERRECTOR');

-- -- CREDENCIAL
INSERT INTO credencial (id, email, password, userId) VALUES (1, 'mandresmosquera@gmail.com', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 1);
INSERT INTO credencial (id, email, password, userId) VALUES (2, 'yurani@unicauca.edu.co', '$2a$10$vjVgOf/KeycZ05g7ZCBFOe.QgoGRJe5w0uyODmA18A1r.3fzIgmAa', 2);

-- -- FUNCIONARIO
INSERT INTO funcionario (id, usuarioId, rolId, estado, fechaInicio) VALUES (1, 1, 1, true, '2024-01-01');

-- SOLICITUD DE USUARIO
INSERT INTO usuario_solicitud (id, creadoPorUsuarioId, programaId, correo, tipoDocumento, numeroDocumento, sexo, estado, tipoUsuario, nombre, apellido, telefono, nota) VALUES (1, 1, 1, 'miguelmonje@unicauca.edu.co', 'CEDULA_CIUDADANIA', '1061', 'MASCULINO', 'REVISION_VRI', 'ADMINISTRATIVO', 'Miguel Andres', 'Mosquera', '3225864404', 'no me lo nieguen porfa');
INSERT INTO usuario_solicitud (id, creadoPorUsuarioId, programaId, correo, tipoDocumento, numeroDocumento, sexo, estado, tipoUsuario, nombre, apellido, telefono, nota) VALUES (2, 1, 1, 'angeehin24@gmail.com', 'CEDULA_CIUDADANIA', '1062', 'MASCULINO', 'REVISION_VRI', 'ADMINISTRATIVO', 'Angee Vannessa', 'Hincapie', '3225864404', 'no me lo nieguen porfa');

-- SOLICITUD DE USUARIO OBSERVACIONES
INSERT INTO usuario_solicitud_observaciones(id, solicitudUsuarioId, funcionarioId, observacion, fechaObservacion, resuelta, notificacionDeVencimiento) VALUES (1, 1, 1, 'Porfavor no nieguen esta solicitud', '2024-01-01', false, false);

-- SOLICITUD DE USUARIO OBSERVACIONES CONVERSACIÓN
INSERT INTO usuario_solicitud_conversacion(id, usuarioSolicitudObservacionesId, autor, mensaje, fechaMensaje) VALUES (1, 1, 'Miguel Mosquera', 'Me parece injusta la observaciones', '2024-01-01');
INSERT INTO usuario_solicitud_conversacion(id, usuarioSolicitudObservacionesId, autor, mensaje, fechaMensaje) VALUES (2, 1, 'Daniel Paz', 'Pues de malas', '2024-01-01');




-- |***** UTILIDADES *****|

-- MAIL TEMPLATE
INSERT INTO templates (id, nombreTemplate, description, vars) VALUES (1, 'bienvenidoSIVRI.html', 'Correo para crear credenciales de Usuario', 'nombreCompleto, passwordCode');
INSERT INTO templates (id, nombreTemplate, description, vars) VALUES (2, 'recuperarContraseña.html', 'Correo para recuperar la contraseña de un usuario', 'correo,codigo');
INSERT INTO templates (id, nombreTemplate, description, vars) VALUES (3, 'notificacionSIVRI.html', 'Notificacion generica de SIVRI', 'mensaje');