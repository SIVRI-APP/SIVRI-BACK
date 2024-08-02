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

-- CONVOCATORIA
INSERT INTO convocatoria (fechaFin, fechaInicio, id, nombre, oferente, descripcion, objetivos, estado, tipoFinanciacion) VALUES('2024-12-31', '2024-09-01', 1, 'Convocatoria de Innovación Tecnológica', 'Ministerio de Energía y Minas', 'Convocatoria destinada a financiar proyectos de innovación tecnológica en el sector de las energías renovables.', 'Fomentar la investigación y desarrollo en tecnologías limpias y sostenibles.', 'ABIERTA', 'PROYECTOS_INTERNOS');

INSERT INTO checklist (id, convocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio, completado) VALUES (1, 1, 1, 'PRE_EJECUCION', 'ORGANISMO_DE_INVESTIGACION', 1, 1, 0);


-- |***** USUARIO *****|

-- USUARIO
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (1, 'mandresmosquera@gmail.com', 'CEDULA_CIUDADANIA', '10611', 'MASCULINO', 'ADMINISTRATIVO', 'Miguel', 'Mosquera', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (2, 'yurani@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10612', 'MASCULINO', 'ADMINISTRATIVO', 'Yurani', 'Mosquera', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono, departamentoId) VALUES (3, 'miguelmonje@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10613', 'MASCULINO', 'DOCENTE', 'Miguel', 'Monje', '3225864404', 1);
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono, departamentoId) VALUES (4, 'daniel@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10614', 'MASCULINO', 'DOCENTE', 'Daniel', 'Paz', '3225864404', 2);

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
INSERT INTO credencial (id, email, password, userId) VALUES (3, 'miguelmonje@unicauca.edu.co', '$2a$10$18wfrpKUmiVKzIAnm6trUe67Q0XHaqwbbMG/jLObycUuFE/6OwwAy', 3);

-- -- FUNCIONARIO
INSERT INTO funcionario (id, usuarioId, rolId, estado, fechaInicio) VALUES (1, 1, 1, true, '2024-01-01');
INSERT INTO funcionario (id, usuarioId, rolId, estado, fechaInicio) VALUES (2, 2, 1, true, '2024-01-01');

-- SOLICITUD DE USUARIO
INSERT INTO usuario_solicitud (id, creadoPorUsuarioId, programaId, correo, tipoDocumento, numeroDocumento, sexo, estado, tipoUsuario, nombre, apellido, telefono, nota) VALUES (1, 1, 1, 'angee@gmail.com', 'CEDULA_CIUDADANIA', '1062', 'MASCULINO', 'REVISION_VRI', 'ADMINISTRATIVO', 'Angee Vannessa', 'Hincapie', '3225864404', 'no me lo nieguen porfa');

-- SOLICITUD DE USUARIO OBSERVACIONES
INSERT INTO usuario_solicitud_observaciones(id, solicitudUsuarioId, funcionarioId, observacion, fechaObservacion, resuelta, notificacionDeVencimiento) VALUES (1, 1, 1, 'Porfavor no nieguen esta solicitud', '2024-01-01', false, false);

-- SOLICITUD DE USUARIO OBSERVACIONES CONVERSACIÓN
INSERT INTO usuario_solicitud_conversacion(id, usuarioSolicitudObservacionesId, autor, mensaje, fechaMensaje) VALUES (1, 1, 'Miguel Mosquera', 'Me parece injusta la observaciones', '2024-01-01');
INSERT INTO usuario_solicitud_conversacion(id, usuarioSolicitudObservacionesId, autor, mensaje, fechaMensaje) VALUES (2, 1, 'Daniel Paz', 'Pues de malas', '2024-01-01');









-- **************** import yurany *****************************
--rol semillero
INSERT INTO rol_semillero(id,rolSemillero) VALUES(1,'COORDINADOR');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(2,'MENTOR');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(3,'MIEMBRO_ACTIVO_PROFESOR');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(4,'MIEMBRO_ACTIVO_ESTUDIANTE_POSGRADO');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(5,'MIEMBRO_ACTIVO_EGRESADO');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(6,'SEMILLAS');

--ROL GRUPO
INSERT INTO rol_grupo(id,rolGrupo) VALUES(1,'DIRECTOR');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(2,'COINVESTIGADOR');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(3,'ASESOR');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(4,'ESTUDIANTE_PREGRADO');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(5,'ESTUDIANTE_ESPECIALIZACION');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(6,'ESTUDIANTE_MAESTRIA');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(7,'ESTUDIANTE_DOCTORADO');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(8,'ESTUDIANTE_POSDOCTORADO');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(9,'INVESTIGADOR_EXTERNO');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(10,'JOVEN_INVESTIGADOR');

-- organismo de investigacion
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (1,'GRUPO DE CIENCIA','2023-03-08','Desarrollar investigación científica ','mision del grupo','El grupo GCISA-TSEJK tiene');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (2,'ÁGORA - INVESTIGACION POLITICA','2023-03-08','Impulsar el interés investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (3,'semillero1','2023-03-08','Impulsar el interés investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (4,'semillero2','2023-03-08','Impulsar  ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (5,'semillero3','2023-03-08','Impulsar el ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (6,'semillero4','2023-03-08','Impulsar el interés', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (7,'semillero5','2023-03-08','Impulsar el investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (8,'semillero6','2023-03-08','interés investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');

--grupo
INSERT INTO grupo (grupoId,departamentoId,estado, direccion, telefono, email, sitioWeb, escalafonColciencias, direccionGrupLac, codigoColciencias, centroInvestigaciones, realizaciones, perspectivas) VALUES (1,1,'ACTIVO','Facultad de Ingeniería','2-8209800','jccasas@unicauca.edu.co','No','A','http://scienti.colciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000012079','COL0119567','centro investigacion','Desarrollo y aprobación de 5 trabajos de Pregrado en el Departamento de Ingeniería Ambiental y Sanitaria, Facultad de Ingeniería Civil.','perspectivas del grupo');

--semillero
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (2,1,'ACTIVO','agora@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (3,1,'ACTIVO','semillero3@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (4,1,'ACTIVO','semillero4@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (5,1,'ACTIVO','agora5@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (6,1,'ACTIVO','agora6@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (7,1,'ACTIVO','agora7@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (8,1,'ACTIVO','agora8@correo.edu.co','POPAYAN');

-- integrante semillero
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(1,2,3,2, 'activo', '2023-09-04',NULL);

--integrante grupo
INSERT INTO integrante_grupo(id,rolGrupoId,usuarioId,grupoId,estado,fechaInicio,fechaFin) VALUES(1,1,3,1,'Activo','2023-09-07',NULL);



-- |***** PROYECTO *****|

INSERT INTO rol_proyecto(id, nombre) VALUES (1, 'DIRECTOR');
INSERT INTO rol_proyecto(id, nombre) VALUES (2, 'CO_INVESTIGADOR');

-- PROYECTO
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (1, 'Proyecto Internos 2023', 'Formulado', '2024-08-30', '2024-08-30', 'Este sera un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 1);

-- INTEGRANTE PROYECTO
INSERT INTO integrante_proyecto (id, estado, fechaInicio, rolId, proyectoId, usuarioId) VALUES(1, 1, '2024-08-30', 1, 1, 3);

-- COOPERACION
INSERT INTO cooperacion (id, estado, fechaInicio, organismoDeInvestigacionId, principal, proyectoId) VALUES (1, 1, '2024-08-30', 2, 1, 1);

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







-- |***** UTILIDADES *****|

-- MAIL TEMPLATE
INSERT INTO templates (id, nombreTemplate, description, vars) VALUES (1, 'bienvenidoSIVRI.html', 'Correo para crear credenciales de Usuario', 'nombreCompleto, passwordCode');
INSERT INTO templates (id, nombreTemplate, description, vars) VALUES (2, 'recuperarContraseña.html', 'Correo para recuperar la contraseña de un usuario', 'correo,codigo');
INSERT INTO templates (id, nombreTemplate, description, vars) VALUES (3, 'notificacionSIVRI.html', 'Notificacion generica de SIVRI', 'mensaje');
