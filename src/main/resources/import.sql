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
INSERT INTO checklist (id, convocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio, completado) VALUES (2, 1, 2, 'PRE_EJECUCION', 'VRI', 1, 1, 0);
INSERT INTO checklist (id, convocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio, completado) VALUES (3, 1, 3, 'EJECUCION', 'ORGANISMO_DE_INVESTIGACION', 3, 1, 0);
INSERT INTO checklist (id, convocatoriaId, documentoConvocatoriaId, etapaDocumento, responsableDocumento, cantidad, obligatorio, completado) VALUES (4, 1, 4, 'POST_EJECUCION', 'ORGANISMO_DE_INVESTIGACION', 1, 1, 0);


-- |***** USUARIO *****|

-- USUARIO
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (1, 'mandresmosquera@gmail.com', 'CEDULA_CIUDADANIA', '10611', 'MASCULINO', 'ADMINISTRATIVO', 'Miguel', 'Mosquera', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono, departamentoId) VALUES (7, 'miguelmonje@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10613', 'MASCULINO', 'DOCENTE', 'Miguel', 'Monje', '3225864404', 1);
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono, departamentoId) VALUES (8, 'daniel@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10614', 'MASCULINO', 'DOCENTE', 'Daniel', 'Paz', '3225864404', 2);
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (2, 'yurani@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10612', 'MASCULINO', 'ADMINISTRATIVO', 'Yurani', 'Guevara', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (3, 'yurany@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10613', 'FEMENINO', 'DOCENTE', 'yurany', 'guevara', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (4, 'andrea@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10614', 'FEMENINO', 'DOCENTE', 'andrea', 'robles', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (5, 'maicol@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10615', 'FEMENINO', 'ADMINISTRATIVO', 'maicol', 'paredes', '3225864404' );
INSERT INTO usuario (id, correo, tipoDocumento, numeroDocumento, sexo, tipoUsuario, nombre, apellido, telefono) VALUES (6, 'sebastian@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10616', 'MASCULINO', 'ADMINISTRATIVO', 'sebastian', 'perez', '3225864404' );

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
INSERT INTO credencial (id, email, password, userId) VALUES (6, 'miguelmonje@unicauca.edu.co', '$2a$10$18wfrpKUmiVKzIAnm6trUe67Q0XHaqwbbMG/jLObycUuFE/6OwwAy', 7);
INSERT INTO credencial (id, email, password, userId) VALUES (2, 'yurani@unicauca.edu.co', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 2);
INSERT INTO credencial (id, email, password, userId) VALUES (3, 'yurany@unicauca.edu.co', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 3);
INSERT INTO credencial (id, email, password, userId) VALUES (4, 'andrea@unicauca.edu.co', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 4);
INSERT INTO credencial (id, email, password, userId) VALUES (5, 'maicol@unicauca.edu.co', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 5);

-- -- FUNCIONARIO
INSERT INTO funcionario (id, usuarioId, rolId, estado, fechaInicio) VALUES (1, 1, 1, true, '2024-01-01');
INSERT INTO funcionario (id, usuarioId, rolId, estado, fechaInicio) VALUES (2, 3, 4, true, '2024-01-01');
INSERT INTO funcionario (id, usuarioId, rolId, estado, fechaInicio) VALUES (3, 5, 4, true, '2024-01-01');

-- SOLICITUD DE USUARIO
INSERT INTO usuario_solicitud (id, creadoPorUsuarioId, programaId, correo, tipoDocumento, numeroDocumento, sexo, estado, tipoUsuario, nombre, apellido, telefono, nota) VALUES (1, 1, 1, 'angee@gmail.com', 'CEDULA_CIUDADANIA', '1062', 'MASCULINO', 'REVISION_VRI', 'ADMINISTRATIVO', 'Angee Vannessa', 'Hincapie', '3225864404', 'no me lo nieguen porfa');

-- SOLICITUD DE USUARIO OBSERVACIONES
INSERT INTO usuario_solicitud_observaciones(id, solicitudUsuarioId, funcionarioId, observacion, fechaObservacion, resuelta, notificacionDeVencimiento) VALUES (1, 1, 1, 'Porfavor no nieguen esta solicitud', '2024-01-01', false, false);

-- SOLICITUD DE USUARIO OBSERVACIONES CONVERSACIÓN
INSERT INTO usuario_solicitud_conversacion(id, usuarioSolicitudObservacionesId, autor, mensaje, fechaMensaje) VALUES (1, 1, 'Miguel Mosquera', 'Me parece injusta la observaciones', '2024-01-01');
INSERT INTO usuario_solicitud_conversacion(id, usuarioSolicitudObservacionesId, autor, mensaje, fechaMensaje) VALUES (2, 1, 'Daniel Paz', 'Pues de malas', '2024-01-01');



-- |***** PROYECTO *****|

INSERT INTO rol_proyecto(id, nombre) VALUES (1, 'DIRECTOR');
INSERT INTO rol_proyecto(id, nombre) VALUES (2, 'CO_INVESTIGADOR');

-- PROYECTO
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (1, 'Método de Ingeniería de Requisitos para Manejo de Discrepancias', 'FORMULADO', '2024-08-30', '2024-08-30', 'Este será un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (2, 'Desarrollo Sostenible en Zonas Rurales', 'APROBADO', '2024-01-15', '2025-12-30', 'Promover prácticas sostenibles en comunidades rurales', 'Mejorar la calidad de vida a través de la sostenibilidad', 'Implementar energías renovables, fomentar la agricultura orgánica', 'Las zonas rurales necesitan un desarrollo equilibrado con la naturaleza', 'Investigación cualitativa y cuantitativa, análisis de campo', 'Cumplimiento de regulaciones ambientales y sociales', 'Protección de datos de comunidades locales', 'Impactos ambientales negativos mitigados', 'Aumento de la autosuficiencia y resiliencia en las comunidades', 'Inclusión de todas las voces de la comunidad en la toma de decisiones', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (3, 'Innovación en Tecnología Educativa', 'REVISION_VRI', '2024-05-10', '2025-05-10', 'Desarrollar nuevas herramientas tecnológicas para la educación superior', 'Facilitar el aprendizaje a través de la tecnología', 'Crear aplicaciones móviles y plataformas en línea', 'La tecnología puede transformar la educación, haciéndola más accesible', 'Diseño centrado en el usuario, pruebas piloto en entornos educativos', 'Cumplimiento de normativas de accesibilidad y privacidad', 'Gestión adecuada de datos de estudiantes y profesores', 'Posibles resistencias al cambio por parte del profesorado', 'Mejora de la experiencia educativa y los resultados de aprendizaje', 'Monitoreo continuo de la efectividad de las herramientas', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (4, 'Impacto del Cambio Climático en la Biodiversidad', 'EJECUCION', '2024-02-01', '2026-02-01', 'Estudiar cómo el cambio climático afecta la biodiversidad en ecosistemas críticos', 'Desarrollar estrategias de conservación adaptativas', 'Monitorear especies clave, evaluar cambios en los ecosistemas', 'La biodiversidad es esencial para el equilibrio ecológico', 'Investigación de campo, análisis de datos ambientales', 'Cumplimiento de normativas ambientales internacionales', 'Confidencialidad de datos sensibles sobre especies en peligro', 'Alteración de hábitats naturales durante la investigación', 'Generación de planes de conservación efectivos y viables', 'Consideración de variables climáticas en constante cambio', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (5, 'Salud Mental y Bienestar Estudiantil', 'FORMULADO_OBSERVACIONES', '2024-03-01', '2025-03-01', 'Evaluar el estado de salud mental entre estudiantes universitarios', 'Mejorar los servicios de apoyo psicológico en la universidad', 'Realizar encuestas y entrevistas, desarrollar programas de apoyo', 'La salud mental es fundamental para el éxito académico y personal', 'Investigación cualitativa y cuantitativa, análisis de casos', 'Cumplimiento de normativas de privacidad y ética en salud', 'Protección de la identidad de los participantes', 'Posibles efectos secundarios de intervenciones psicológicas', 'Reducción de la ansiedad y el estrés entre los estudiantes', 'Necesidad de recursos adicionales para implementar programas efectivos', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (6, 'Energías Renovables y Sostenibilidad', 'APROBADO', '2024-04-15', '2026-04-15', 'Investigar el uso de energías renovables en áreas urbanas', 'Reducir la huella de carbono a través de energías limpias', 'Instalar paneles solares, promover el uso de bicicletas', 'Las ciudades deben adoptar energías renovables para combatir el cambio climático', 'Estudios de viabilidad técnica y económica, análisis de impacto ambiental', 'Cumplimiento de normativas de sostenibilidad urbana', 'Protección de datos sobre el consumo energético', 'Resistencia al cambio por parte de industrias tradicionales', 'Reducción significativa de emisiones de gases de efecto invernadero', 'Involucrar a la comunidad en la adopción de energías limpias', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (7, 'Optimización de Procesos Industriales', 'REVISION_VRI', '2024-06-01', '2025-06-01', 'Mejorar la eficiencia de procesos industriales en la región', 'Optimizar el uso de recursos en plantas industriales', 'Implementar tecnologías de automatización, reducir desperdicios', 'La eficiencia industrial es clave para la competitividad económica', 'Modelado y simulación de procesos, pruebas en planta', 'Cumplimiento de normativas de seguridad y medio ambiente', 'Confidencialidad de información estratégica de las empresas', 'Interrupciones temporales en la producción durante la implementación', 'Mejoras en la rentabilidad y sostenibilidad de las operaciones', 'Evaluación continua de los procesos optimizados', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (8, 'Inteligencia Artificial y Ética', 'FORMULADO', '2024-07-01', '2025-07-01', 'Explorar las implicaciones éticas del uso de la inteligencia artificial', 'Garantizar un uso ético de la inteligencia artificial en aplicaciones diversas', 'Identificar riesgos, proponer regulaciones', 'La IA plantea desafíos éticos que deben ser abordados', 'Análisis de casos de estudio, desarrollo de marcos éticos', 'Cumplimiento de normativas internacionales sobre ética en IA', 'Protección de datos personales y privacidad', 'Uso indebido de IA en aplicaciones críticas', 'Desarrollo de guías y recomendaciones para el uso ético de IA', 'Consideración de las implicaciones sociales y económicas', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (9, 'Estudio de Ecosistemas Acuáticos', 'EJECUCION', '2024-08-01', '2026-08-01', 'Analizar la salud de los ecosistemas acuáticos en la región', 'Proteger y restaurar ecosistemas acuáticos', 'Monitorear la calidad del agua, evaluar la biodiversidad acuática', 'Los ecosistemas acuáticos son vitales para la salud ambiental', 'Investigación de campo, análisis de muestras de agua', 'Cumplimiento de regulaciones ambientales', 'Protección de datos sobre especies en peligro', 'Alteración de hábitats acuáticos durante la investigación', 'Mejoras en la calidad del agua y la biodiversidad', 'Consideración de factores estacionales y climáticos', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (10, 'Ciencia de Datos para la Toma de Decisiones', 'FORMULADO_OBSERVACIONES', '2024-09-01', '2025-09-01', 'Aplicar ciencia de datos para mejorar la toma de decisiones en organizaciones', 'Optimizar procesos de toma de decisiones mediante el análisis de datos', 'Desarrollar modelos predictivos, implementar dashboards', 'La ciencia de datos puede transformar la toma de decisiones', 'Análisis de datos históricos, desarrollo de algoritmos', 'Cumplimiento de normativas de protección de datos', 'Confidencialidad de información sensible de las organizaciones', 'Posibles errores en los modelos predictivos', 'Mejoras en la precisión y rapidez de las decisiones', 'Monitoreo continuo de los modelos implementados', 0, 1);
INSERT INTO proyecto (id, nombre, estado, fechaInicio, fechaFin, planteamiento, objetivoGeneral, objetivosEspecificos, justificacion, enfoqueMetodologico, aspectosEticosLegales, confidencialidadDeInformacion, efectosAdversos, impactosResultadosEsperados, consideraciones, eliminadoLogico, convocatoriaId) VALUES (11, 'Desarrollo de Vacunas contra Enfermedades Tropicales', 'APROBADO', '2024-10-01', '2026-10-01', 'Desarrollar y probar vacunas efectivas contra enfermedades tropicales', 'Reducir la incidencia de enfermedades tropicales en comunidades vulnerables', 'Realizar ensayos clínicos, evaluar la efectividad de las vacunas', 'Las enfermedades tropicales son un problema de salud pública urgente', 'Investigación en laboratorio, pruebas en campo', 'Cumplimiento de normativas internacionales de ensayos clínicos', 'Confidencialidad de datos de pacientes', 'Efectos secundarios potenciales de las vacunas', 'Desarrollo de vacunas seguras y eficaces', 'Consideración de la logística de distribución en áreas remotas', 0, 1);

-- EVIDENCIA PROYECTO DOC CONVOCATORIA
INSERT INTO evidencia_proyecto_documento_convocatoria (`DocumentoConvocatoriaId`, `id`, `proyectoId`, `nombre`) VALUES ('1', 1, '1', 'escudo-departamento-del-cauca.png');

-- INTEGRANTE PROYECTO
INSERT INTO integrante_proyecto (id, estado, fechaInicio, rolId, proyectoId, usuarioId) VALUES(1, 1, '2024-08-30', 1, 1, 7);


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
INSERT INTO organismo_de_investigacion (id, nombre, fechaCreacion, objetivo, mision, vision) VALUES (9,'Grupo I+D en Tecnologías de la Información','2023-03-08', '1. Fortalecer la infraestructura humana, técnica, investigativa y de formación especializada en diferentes áreas, de todo el Grupo de Investigación de Unicauca. 2. Definir, diseñar e implementar proyectos que propendan por la interdisciplinariedad de áreas dentro y fuera de La universidad Del Cauca.', 'El grupo se propone crear la infraestructura base que facilite la generación de soluciones informáticas para la comunidad en general y brinde asesorías en cuanto al aprovechamiento de nuevas tecnologías de la información para los sectores productivos y académicos.', 'Preservar y estimular el crecimiento de la capacidad de investigación e innovación en el área las Tecnologías de la Información de la Universidad del Cauca, a través de los integrantes del grupo GTI, por medio de la creación de espacios adecuados donde la crítica y el debate intelectual se constituyan en fuente de nuevo conocimiento. El GTI promoverá el desarrollo de su talento humano (profesores, investigadores y estudiantes), aportará la infraestructura requerida y establecerá alianzas estratégicas con centros de investigación de reconocido prestigio internacional para el desarrollo de su labor, con el propósito de agregar valor a su relación con la sociedad. Los principios de calidad, transparencia, independencia de criterio, compromiso y servicio, orientarán las actuaciones del GTI y se constituirán en su diferencial competitivo con respecto de otros grupos en el área. A largo plazo el GTI pretende ser: ¿Un centro tecnológico en Investigación y Desarrollo con reconocimiento nacional e internacional generador de proyectos ');


--grupo
INSERT INTO grupo (grupoId,departamentoId,estado, direccion, telefono, email, sitioWeb, escalafonColciencias, direccionGrupLac, codigoColciencias, centroInvestigaciones, realizaciones, perspectivas) VALUES (1,1,'ACTIVO','Facultad de Ingeniería','2-8209800','jccasas@unicauca.edu.co','No','A','http://scienti.colciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000012079','COL0119567','centro investigacion','Desarrollo y aprobación de 5 trabajos de Pregrado en el Departamento de Ingeniería Ambiental y Sanitaria, Facultad de Ingeniería Civil.','perspectivas del grupo');
INSERT INTO grupo (grupoId,departamentoId,estado, direccion, telefono, email, sitioWeb, escalafonColciencias, direccionGrupLac, codigoColciencias, centroInvestigaciones, realizaciones, perspectivas) VALUES (9,1,'ACTIVO','Sector Tulcan - FIET','8233031','gti@unicauca.edu.co','No','A','http://scienti.minciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000002157','COL0023303', 'centro investigacion','valor','¿Productividad investigativa medida por índices de eficiencia, eficacia y calidad de los proyectos. ¿Aporte de proyectos significativos, innovadores y útiles, que propendan por el mejoramiento y la calidad de vida de los posibles usuarios de los mismos. ¿Creación de alianzas estratégicas regionales, nacionales e internacionales, que generen vínculos entre distintos estamentos, brindando con ello: saber científico, financiamiento, investigación y todo tipo de apoyo al GTI.');


--semillero
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (2,1,'ACTIVO','agora@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (3,1,'FORMULADO','semillero3@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (4,1,'ACTIVO','semillero4@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (5,1,'ACTIVO','agora5@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (6,9,'ACTIVO','agora6@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (7,1,'ACTIVO','agora7@correo.edu.co','POPAYAN');
INSERT INTO semillero(semilleroId,grupoId, estado,correo,sede) VALUES (8,1,'ACTIVO','agora8@correo.edu.co','POPAYAN');

-- integrante semillero
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(1,2,3,2, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(2,2,4,1, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(3,2,5,6, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(4,2,6,6, 'activo', '2023-09-04',NULL);
INSERT INTO integrante_semillero(idIntegranteSemillero,semilleroId,usuarioId,rolId, estado, fechaIngreso, fechaRetiro)VALUES(5,3,3,2, 'activo', '2023-09-05',NULL);

--integrante grupo
INSERT INTO integrante_grupo(id,rolGrupoId,usuarioId,grupoId,estado,fechaInicio,fechaFin) VALUES(1,1,3,1,'ACTIVO','2023-09-07',NULL);
INSERT INTO integrante_grupo(id,rolGrupoId,usuarioId,grupoId,estado,fechaInicio,fechaFin) VALUES(3,2,7,1,'ACTIVO','2023-09-07',NULL);
INSERT INTO integrante_grupo(id,rolGrupoId,usuarioId,grupoId,estado,fechaInicio,fechaFin) VALUES(2,1,4,9,'ACTIVO','2023-09-07',NULL);


--compromiso Semillero
INSERT INTO compromiso_semillero(id,nombre) VALUES(1, 'compromiso 1');
INSERT INTO compromiso_semillero(id,nombre) VALUES(2, 'compromiso 2');
INSERT INTO compromiso_semillero(id,nombre) VALUES(3, 'compromiso 3');




--plan de trabajo
INSERT INTO plan_trabajo(id,semilleroId,nombrePlan,anio, estado) VALUES(1,2, 'plan', 2023,'FINALIZADO');
INSERT INTO plan_trabajo(id,semilleroId,nombrePlan,anio, estado) VALUES(2,2, 'plan de trabajo', 2024, 'FORMULADO');

--actividad plan de trabajo
INSERT INTO actividad_plan_trabajo(id,planTrabajoId,compromisoSemilleroId,objetivo,actividad,fechaInicio,fechaFin,responsableId)VALUES(1,1,1,'obj','act','2023-03-08','2023-08-05',3);
INSERT INTO actividad_plan_trabajo(id,planTrabajoId,compromisoSemilleroId,objetivo,actividad,fechaInicio,fechaFin,responsableId)VALUES(2,1,2,'obj','act','2023-03-08','2023-08-05',3);
INSERT INTO actividad_plan_trabajo(id,planTrabajoId,compromisoSemilleroId,objetivo,actividad,fechaInicio,fechaFin,responsableId)VALUES(3,2,3,'obj','act','2023-03-08','2023-08-05',3);

--evidencia actividad
INSERT INTO evidencia_actividad(id,actividadId,evidencia) VALUES(1,1,'evidencia');
INSERT INTO evidencia_actividad(id,actividadId,evidencia) VALUES(2,2,'evidencia');

--linea de investigacion
INSERT INTO linea_investigacion(id,semilleroId,linea) VALUES(1,2,'calidad de procesos');
INSERT INTO linea_investigacion(id,semilleroId,linea) VALUES(2,2,'calidad de sotware');

--semillero programa
INSERT INTO semillero_programa(semilleroId,idPrograma) VALUES(2,1);
INSERT INTO semillero_programa(semilleroId,idPrograma) VALUES(2,2);

--observacion semillero
INSERT INTO observacion_semillero(id,semilleroId,funcionarioId,observacion,fecha) VALUES (1,2,1,'revisando el semillero se encuentra que no ha subido los documentos','2023-09-04');






-- COOPERACION
INSERT INTO cooperacion (id, estado, fechaInicio, organismoDeInvestigacionId, principal, proyectoId) VALUES (1, 1, '2024-08-30', 2, 1, 1);