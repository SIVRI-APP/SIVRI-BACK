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
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombres, apellidos, telefono) VALUES (2, 'yurani@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10611', 'MASCULINO', 'ADMINISTRATIVO', 'Yurani', 'Mosquera', '3225864404' );

-- CREDENTIAL
INSERT INTO _credential (id, email, password, created, usuario_id) VALUES (1, 'miguel@unicauca.edu.co', '$2a$10$vjVgOf/KeycZ05g7ZCBFOe.QgoGRJe5w0uyODmA18A1r.3fzIgmAa', 1, 1)
INSERT INTO _credential (id, email, password, created, usuario_id) VALUES (2, 'yurani@unicauca.edu.co', '$2a$10$vjVgOf/KeycZ05g7ZCBFOe.QgoGRJe5w0uyODmA18A1r.3fzIgmAa', 1, 2)

-- FUNCIONARIO
INSERT INTO funcionario (id, usuarioId) VALUES (1, 1);

-- ROL ADMINISTRATIVO
INSERT INTO rol_administrativo (id, funcionarioId, rolFuncionarioId, estado, fechaInicio) VALUES (1, 1, 1, true, '2024-01-01');





-- |***** MAIL TEMPLATE *****|
INSERT INTO templates (id, nombreTemplate, description, vars) VALUES (1, 'template.html', 'correo para crear credenciales de Usuario', 'nombre,tipoUsuario,grupoInvestigacion,rolGrupo');








--***************************--
-- organismo de investigacion
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (1,'GRUPO DE CIENCIA','2023-03-08','Desarrollar investigación científica ','mision del grupo','El grupo GCISA-TSEJK tiene');
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (2,'ÁGORA - INVESTIGACION POLITICA','2023-03-08','Impulsar el interés investigativo ', 'El semillero tiene como propósito crear un nucleo','El semillero SIR');

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
INSERT INTO documento_semillero(id, avalDepartamento, otros, observacion, estado) VALUES(1,'aval','otr','','en revision');

--compromisoSemillero
INSERT INTO compromiso_semillero(id,nombre) VALUES(1, 'compromiso 1');

--evidencia actividad
INSERT INTO evidencia_actividad(id,evidencia) VALUES(1,'evidencia');

--grupo
INSERT INTO grupo (grupoId,facultadId,estado, direccion, telefono, email, sitioWeb, escalafonColciencias, direccionGrupLac, codigoColciencias, centroInvestigaciones, realizaciones, perspectivas) VALUES (1,1,'ACTIVO','Facultad de Ingeniería','2-8209800','jccasas@unicauca.edu.co','No','A','http://scienti.colciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000012079','COL0119567','centro investigacion','Desarrollo y aprobación de 5 trabajos de Pregrado en el Departamento de Ingeniería Ambiental y Sanitaria, Facultad de Ingeniería Civil.','perspectivas del grupo');

--ROL GRUPO
INSERT INTO rol_grupo(id,rolGrupo) VALUES(1,'Director de Grupo');
INSERT INTO rol_grupo(id,rolGrupo) VALUES(2,'Coinvestigador');

--semillero
INSERT INTO semillero(semilleroId,grupoId, estado,sede) VALUES (2,1,'ACTIVO','popayan');

--rol semillero
INSERT INTO rol_semillero(id,rolSemillero) VALUES(1,'mentor');

--linea de investigacion
INSERT INTO linea_investigacion(id,semilleroId,linea) VALUES(1,2,'linea 1');

--observacion semillero
INSERT INTO observacion_semillero(id,semilleroId,/*rolFuncionarioId,*/observacion,fecha) VALUES (1,2/*,1*/, '','2023-09-04')

-- integrantesemillero
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,/*usuarioNumeroDocumento,*/rolId, estado, semestre, fechaIngreso, fechaRetiro)VALUES(1,2,/*10611,*/1, 'activo', 'n.a', '2023-09-04',NULL);

--semillero documentacion
INSERT INTO semillero_documentacion(semilleroId,idDocumentoSemillero,fecha) VALUES(2,1,'2023-09-04');

--semillero programa
INSERT INTO semillero_programa(semilleroId,idPrograma) VALUES(2,1);
INSERT INTO semillero_programa(semilleroId,idPrograma) VALUES(2,2);

--plan de trabajo
INSERT INTO plan_trabajo(id,semilleroId,nombrePlan, estado) VALUES(1,2, 'plan 2023','formulado');

--actividad plan de trabajo
INSERT INTO actividad_plan_trabajo(id,planTrabajoId,compromisoSemilleroId,objetivo,actividad,fechaInicio,fechaFin/*,responsable*/)VALUES(1,1,1,'obj','act','2023-03-08','2023-08-05'/*,10611*/);

--INTEGRANTE GRUPO
INSERT INTO integrante_grupo(id,rolGrupoId/*,usuarioNumeroDocumento*/,grupoId,estado,fechaInicio,fechaFin) VALUES(1,1/*,10611*/,1,'Activo','2023-09-07',NULL);

--observacion grupo
INSERT INTO observacion_grupo(idObservacion,grupoId,/*rolFuncionarioId,*/observacion,fecha)VALUES(1,1,/*1,*/'observacion de un grupo','2023-09-08');

--GRUPO DISCIPLINA
INSERT INTO grupo_disciplina(disciplinaId,grupoId) VALUES(1,1);




-- |***** ACADEMICA *****|
--
-- -- FACULTAD
 INSERT INTO facultad (idFacultad, nombre) VALUES (1, 'Ingeniería Electronica y Telecomunicaciones');
--
-- -- DEPARTAMENTO
 INSERT INTO departamento (id, nombre, facultadId) VALUES (1, 'Sistemas', 1);
--
-- -- PROGRAMAS
INSERT INTO programa (id, nombre, departamentoId) VALUES (1, 'Ingeniería de Sistemas', 1);
INSERT INTO programa (id, nombre, departamentoId) VALUES (2, 'Ingeniería civil', 1);
INSERT INTO programa (id, nombre, departamentoId) VALUES (3, 'Ingeniería Electronica', 1);


