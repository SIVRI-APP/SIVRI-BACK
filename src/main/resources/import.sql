-- |***** ACADEMICA *****|

-- -- FACULTAD
INSERT INTO facultad (idFacultad, nombre) VALUES (1, 'Ingeniería Electronica y Telecomunicaciones');

-- -- DEPARTAMENTO
INSERT INTO departamento (id, nombre, facultadId) VALUES (1, 'Sistemas', 1);

-- -- PROGRAMAS
INSERT INTO programa (id, nombre, departamentoId) VALUES (1, 'Ingeniería de Sistemas', 1);
INSERT INTO programa (id, nombre, departamentoId) VALUES (2, 'Ingeniería civil', 1);
INSERT INTO programa (id, nombre, departamentoId) VALUES (3, 'Ingeniería Electronica', 1);





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





-- |***** USUARIO *****|

-- ROL FUNCIONARIO
INSERT INTO rol_funcionario (id, nombre) VALUES (1, 'SUPER_ADMIN');
INSERT INTO rol_funcionario (id, nombre) VALUES (2, 'USUARIOS');
INSERT INTO rol_funcionario (id, nombre) VALUES (3, 'GRUPOS');
INSERT INTO rol_funcionario (id, nombre) VALUES (4, 'SEMILLEROS');
INSERT INTO rol_funcionario (id, nombre) VALUES (5, 'PROYECTOS_INTERNOS');
INSERT INTO rol_funcionario (id, nombre) VALUES (6, 'PROYECTOS_EXTERNOS');
INSERT INTO rol_funcionario (id, nombre) VALUES (7, 'VICERRECTOR');

-- USUARIO
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (1, 'miguel@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10611', 'MASCULINO', 'ADMINISTRATIVO', 'Miguel', 'Mosquera', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (2, 'yurani@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10612', 'FEMENINO', 'ADMINISTRATIVO', 'Yurani', 'Mosquera', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (3, 'yurany@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10613', 'FEMENINO', 'ADMINISTRATIVO', 'Yurani', 'Guevara', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (4, 'susana@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10614', 'FEMENINO', 'ADMINISTRATIVO', 'susana', 'Guevara', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (5, 'usu1@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10615', 'MASCULINO', 'ADMINISTRATIVO', 'usuario1', 'Guevara', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (6, 'usu2@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10616', 'FEMENINO', 'ADMINISTRATIVO', 'usuario2', 'Guevara', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (7, 'usu3@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10617', 'MASCULINO', 'ADMINISTRATIVO', 'usuario3', 'Guevara', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (8, 'usu4@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10618', 'FEMENINO', 'ADMINISTRATIVO', 'usuario4', 'Guevara', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (9, 'usu5@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10619', 'MASCULINO', 'ADMINISTRATIVO', 'usuario5', 'Guevara', '3225864404' );

-- CREDENTIAL
INSERT INTO _credencial (id, email, password, usuarioId) VALUES (1, 'miguel@unicauca.edu.co', '$2a$10$vjVgOf/KeycZ05g7ZCBFOe.QgoGRJe5w0uyODmA18A1r.3fzIgmAa', 1)
INSERT INTO _credencial (id, email, password, usuarioId) VALUES (2, 'yurani@unicauca.edu.co', '$2a$10$vjVgOf/KeycZ05g7ZCBFOe.QgoGRJe5w0uyODmA18A1r.3fzIgmAa', 2);
INSERT INTO _credencial (id, email, password, usuarioId) VALUES (3, 'yurany@unicauca.edu.co', '$2a$10$vjVgOf/KeycZ05g7ZCBFOe.QgoGRJe5w0uyODmA18A1r.3fzIgmAa', 3);
INSERT INTO _credencial (id, email, password, usuarioId) VALUES (4, 'susana@unicauca.edu.co', '$2a$10$vjVgOf/KeycZ05g7ZCBFOe.QgoGRJe5w0uyODmA18A1r.3fzIgmAa', 4);

-- FUNCIONARIO
INSERT INTO funcionario (id, usuarioId) VALUES (1, 1);
INSERT INTO funcionario (id, usuarioId) VALUES (2, 2);
INSERT INTO funcionario (id, usuarioId) VALUES (3, 3);
INSERT INTO funcionario (id, usuarioId) VALUES (4, 4);

-- ROL ADMINISTRATIVO
INSERT INTO rol_administrativo (id, funcionarioId, rolFuncionarioId, estado, fechaInicio) VALUES (1, 1, 1, true, '2024-01-01');
INSERT INTO rol_administrativo (id, funcionarioId, rolFuncionarioId, estado, fechaInicio) VALUES (2, 2, 4, true, '2023-12-08');
INSERT INTO rol_administrativo (id, funcionarioId, rolFuncionarioId, estado, fechaInicio) VALUES (3, 4, 3, true, '2023-12-08');





-- |***** UTILIDADES *****|

-- MAIL TEMPLATE
INSERT INTO templates (id, nombreTemplate, description, vars) VALUES (1, 'template.html', 'correo para crear credenciales de Usuario', 'nombre,tipoUsuario,grupoInvestigacion,rolGrupo');













--***************************--





-- organismo de investigacion
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (1,'GRUPO DE CIENCIA','2023-03-08','Desarrollar investigación científica ','mision del grupo','El grupo GCISA-TSEJK tiene');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (2,'ÁGORA - INVESTIGACION POLITICA','2023-03-08','Impulsar el interés investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (3,'semillero1','2023-03-08','Impulsar el interés investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (4,'semillero2','2023-03-08','Impulsar  ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (5,'semillero3','2023-03-08','Impulsar el ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (6,'semillero4','2023-03-08','Impulsar el interés', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (7,'semillero5','2023-03-08','Impulsar el investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (8,'semillero6','2023-03-08','interés investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');

--AREA DE GRUPO
INSERT INTO area (idArea, area) VALUES (1, 'Ingenierpia y Tecnología');
INSERT INTO area (idArea, area) VALUES (2, 'Humanidades');

--subarea de grupo
INSERT INTO sub_area (idSubArea, subArea, idArea) VALUES (1, 'Biotecnologia ambiental', 1);
INSERT INTO sub_area (idSubArea, subArea, idArea) VALUES (2, 'Ingeniería Ambiental', 1);
INSERT INTO sub_area (idSubArea, subArea, idArea) VALUES (3, 'Arte', 2);

--DISCIPLINA
INSERT INTO disciplina (id, disciplina, idSubArea) VALUES (1,'Biotecnología Ambiental',1);
INSERT INTO disciplina (id, disciplina, idSubArea) VALUES (2,'Ëtica Relacionada con Biotecnología Ambiental',1);
INSERT INTO disciplina (id, disciplina, idSubArea) VALUES (3,'Geotécnicas',2);

--documento semillero
INSERT INTO documento_semillero(id, tipo, rutaDocumento, observacion, estado) VALUES(1,'AVAL_DEPARTAMENTO','documento 1','','APROBADO');
INSERT INTO documento_semillero(id, tipo, rutaDocumento, observacion, estado) VALUES(2,'OTROS','documento 2','','APROBADO');
INSERT INTO documento_semillero(id, tipo, rutaDocumento, observacion, estado) VALUES(3,'AVAL_DEPARTAMENTO','documento 3','','REVISION');

--compromiso Semillero
INSERT INTO compromiso_semillero(id,nombre) VALUES(1, 'compromiso 1');

--evidencia actividad
INSERT INTO evidencia_actividad(id,evidencia) VALUES(1,'evidencia');

--grupo
INSERT INTO grupo (grupoId,facultadId,estado, direccion, telefono, email, sitioWeb, escalafonColciencias, direccionGrupLac, codigoColciencias, centroInvestigaciones, realizaciones, perspectivas) VALUES (1,1,'ACTIVO','Facultad de Ingeniería','2-8209800','jccasas@unicauca.edu.co','No','A','http://scienti.colciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000012079','COL0119567','centro investigacion','Desarrollo y aprobación de 5 trabajos de Pregrado en el Departamento de Ingeniería Ambiental y Sanitaria, Facultad de Ingeniería Civil.','perspectivas del grupo');

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

--semillero
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (2,1,'ACTIVO','agora@correo.edu.co','popayan');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (3,1,'ACTIVO','semillero3@correo.edu.co','popayan');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (4,1,'ACTIVO','semillero4@correo.edu.co','popayan');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (5,1,'ACTIVO','agora5@correo.edu.co','popayan');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (6,1,'ACTIVO','agora6@correo.edu.co','popayan');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (7,1,'ACTIVO','agora7@correo.edu.co','popayan');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (8,1,'ACTIVO','agora8@correo.edu.co','popayan');

--rol semillero
INSERT INTO rol_semillero(id,rolSemillero) VALUES(1,'COORDINADOR');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(2,'MENTOR');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(3,'MIEMBRO_ACTIVO_PROFESOR');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(4,'MIEMBRO_ACTIVO_ESTUDIANTE_POSGRADO');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(5,'MIEMBRO_ACTIVO_EGRESADO');
INSERT INTO rol_semillero(id,rolSemillero) VALUES(6,'SEMILLAS');

--linea de investigacion
INSERT INTO linea_investigacion(id,semilleroId,linea) VALUES(1,2,'linea 1');

--observacion semillero
INSERT INTO observacion_semillero(id,semilleroId,funcionarioId,observacion,fecha) VALUES (1,2,2,'','2023-09-04')

-- integrantesemillero
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(1,2,3,2, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(2,4,5,1, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(3,5,4,6, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(4,6,6,6, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(5,7,7,6, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(6,8,8,6, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(7,2,9,6, 'activo', '2023-09-04',NULL);


--semillero documentacion
INSERT INTO semillero_documentacion(semilleroId,idDocumentoSemillero,fecha) VALUES(2,1,'2023-09-04');
INSERT INTO semillero_documentacion(semilleroId,idDocumentoSemillero,fecha) VALUES(2,2,'2023-09-04');
INSERT INTO semillero_documentacion(semilleroId,idDocumentoSemillero,fecha) VALUES(2,3,'2023-10-10');

--semillero programa
INSERT INTO semillero_programa(semilleroId,idPrograma) VALUES(2,1);
INSERT INTO semillero_programa(semilleroId,idPrograma) VALUES(2,2);

--plan de trabajo
INSERT INTO plan_trabajo(id,semilleroId,nombrePlan, estado) VALUES(1,2, 'plan 2023','formulado');

--actividad plan de trabajo
INSERT INTO actividad_plan_trabajo(id,planTrabajoId,compromisoSemilleroId,objetivo,actividad,fechaInicio,fechaFin,responsableId,evidenciaId)VALUES(1,1,1,'obj','act','2023-03-08','2023-08-05',3,1);

--INTEGRANTE GRUPO
INSERT INTO integrante_grupo(id,rolGrupoId,usuarioId,grupoId,estado,fechaInicio,fechaFin) VALUES(1,1,3,1,'Activo','2023-09-07',NULL);
INSERT INTO integrante_grupo(id,rolGrupoId,usuarioId,grupoId,estado,fechaInicio,fechaFin) VALUES(2,2,2,1,'Activo','2023-09-07',NULL);

--observacion grupo
INSERT INTO observacion_grupo(idObservacion,funcionarioId,grupoId,observacion,fecha)VALUES(1,2,1,'observacion de un grupo','2023-09-08');

--GRUPO DISCIPLINA
INSERT INTO grupo_disciplina(disciplinaId,grupoId) VALUES(1,1);







