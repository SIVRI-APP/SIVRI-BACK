-- -- |***** ACADEMICA *****|

-- -- -- FACULTAD
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (1, 'Facultad de Artes');
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (2, 'Facultad de Ciencias Agrarias');
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (3, 'Facultad de Ciencias de la Salud');
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (4, 'Facultad de Ciencias Contables, Económicas y Administrativas');
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (5, 'Facultad de Ciencias Humanas y Sociales');
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (6, 'Facultad de Ciencias Naturales, Exactas y de la Educación');
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (7, 'Facultad de Derecho, Ciencias Políticas y Sociales');
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (8, 'Facultad de Ingeniería Civil');
INSERT INTO facultad (ID_FACULTAD, NOMBRE) VALUES (9, 'Facultad de Ingeniería Electrónica y Telecomunicaciones');

-- -- -- DEPARTAMENTO
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (1, 'Artes Plásticas', 1);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (2, 'Agroindustria', 2);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (3, 'Biología', 6);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (4, 'Ciencia Política', 7);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (5, 'Ciencias Administrativas', 4);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (6, 'Ciencias Agropecuarias', 2);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (7, 'Ciencias Económicas', 4);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (8, 'Ciencias Fisiológicas', 3);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (9, 'Ciencias Quirúrgicas', 3);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (10, 'Comunicación Social', 7);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (11, 'Derecho Laboral', 7);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (12, 'Derecho Privado', 7);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (13, 'Diseño', 1);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (14, 'Educación Física, Recreación y Deporte', 6);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (15, 'Enfermería', 3);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (16, 'Español y Literatura', 5);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (17, 'Estudios Interculturales', 5);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (18, 'Sistemas', 9);
INSERT INTO departamento (ID, NOMBRE, FACULTAD_ID) VALUES (19, 'Desarrollo de Vías y Estructuras', 8);

-- -- -- PROGRAMAS
INSERT INTO programa (ID, NOMBRE, DEPARTAMENTO_ID) VALUES (1, 'Ingeniería de Sistemas', 9);
INSERT INTO programa (ID, NOMBRE, DEPARTAMENTO_ID) VALUES (2, 'Ingeniería Civil', 1);
INSERT INTO programa (ID, NOMBRE, DEPARTAMENTO_ID) VALUES (3, 'Ingeniería Electrónica', 1);
INSERT INTO programa (ID, NOMBRE, DEPARTAMENTO_ID) VALUES (4, 'Artes Plásticas', 1);

-- -- |***** CONVOCATORIA *****|

-- -- LISTADO DE DOCUMENTOS
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (1, 'Planilla de Seguridad Social');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (2, 'FOR-2');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (3, 'FOR-3');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (4, 'FOR-4');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (5, 'FOR-5');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (6, 'FOR-14');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (7, 'FOR-15');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (8, 'FOR-24');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (9, 'Registro civil de nacimiento');
INSERT INTO documento_convocatoria (ID, NOMBRE) VALUES (10, 'Acta de nacimiento del Proyecto');

-- -- CONVOCATORIA
INSERT INTO convocatoria (FECHA_FIN, FECHA_INICIO, ID, NOMBRE, OFERENTE, DESCRIPCION, OBJETIVOS, ESTADO, TIPO_FINANCIACION) VALUES (TO_DATE('2024-12-31', 'YYYY-MM-DD'), TO_DATE('2024-09-01', 'YYYY-MM-DD'), 1, 'Convocatoria de Innovación Tecnológica', 'Ministerio de Energía y Minas', 'Convocatoria destinada a financiar proyectos de innovación tecnológica en el sector de las energías renovables.', 'Fomentar la investigación y desarrollo en tecnologías limpias y sostenibles.', 'ABIERTA', 'PROYECTOS_INTERNOS');

-- -- CONVOCATORIA CHECKLIST
INSERT INTO checklist (ID, CONVOCATORIA_ID, DOCUMENTO_CONVOCATORIA_ID, ETAPA_DOCUMENTO, RESPONSABLE_DOCUMENTO, CANTIDAD, OBLIGATORIO, COMPLETADO) VALUES (1, 1, 1, 'PRE_EJECUCION', 'ORGANISMO_DE_INVESTIGACION', 1, 1, 0);
INSERT INTO checklist (ID, CONVOCATORIA_ID, DOCUMENTO_CONVOCATORIA_ID, ETAPA_DOCUMENTO, RESPONSABLE_DOCUMENTO, CANTIDAD, OBLIGATORIO, COMPLETADO) VALUES (2, 1, 2, 'PRE_EJECUCION', 'VRI', 1, 1, 0);
INSERT INTO checklist (ID, CONVOCATORIA_ID, DOCUMENTO_CONVOCATORIA_ID, ETAPA_DOCUMENTO, RESPONSABLE_DOCUMENTO, CANTIDAD, OBLIGATORIO, COMPLETADO) VALUES (3, 1, 3, 'EJECUCION', 'ORGANISMO_DE_INVESTIGACION', 3, 1, 0);
INSERT INTO checklist (ID, CONVOCATORIA_ID, DOCUMENTO_CONVOCATORIA_ID, ETAPA_DOCUMENTO, RESPONSABLE_DOCUMENTO, CANTIDAD, OBLIGATORIO, COMPLETADO) VALUES (4, 1, 4, 'POST_EJECUCION', 'ORGANISMO_DE_INVESTIGACION', 1, 1, 0);

-- -- |***** USUARIO *****|

-- -- USUARIO
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO) VALUES (1, 'mandresmosquera@gmail.com', 'CEDULA_CIUDADANIA', '10611', 'MASCULINO', 'ADMINISTRATIVO', 'Miguel', 'Mosquera', '3225864404' );
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO) VALUES (2, 'yurani@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10612', 'MASCULINO', 'ADMINISTRATIVO', 'Yurani', 'Guevara', '3225864404');
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO) VALUES (3, 'yurany@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10613', 'FEMENINO', 'ADMINISTRATIVO', 'Yurany', 'Guevara', '3225864404');
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO) VALUES (4, 'andrea@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10614', 'FEMENINO', 'ADMINISTRATIVO', 'Andrea', 'Robles', '3225864404');
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO) VALUES (5, 'maicol@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10615', 'FEMENINO', 'ADMINISTRATIVO', 'Maicol', 'Paredes', '3225864404');
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO, PROGRAMA_ID) VALUES (6, 'sebastian@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10616', 'MASCULINO', 'PREGRADO', 'Sebastian', 'Perez', '3225864404', 1);
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO, DEPARTAMENTO_ID) VALUES (7, 'miguelmonje@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10613', 'MASCULINO', 'DOCENTE', 'Miguel', 'Monje', '3225864404', 1);
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO, DEPARTAMENTO_ID) VALUES (8, 'panita49545@gmail.com', 'CEDULA_CIUDADANIA', '10614', 'MASCULINO', 'DOCENTE', 'Daniel', 'Acosta', '3225864404', 2);
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO, DEPARTAMENTO_ID) VALUES (9, 'ynguevara01@gmail.com', 'CEDULA_CIUDADANIA', '10617', 'FEMENINO', 'DOCENTE', 'Carlos', 'Ardila', '3225864404', 18);
INSERT INTO usuario (ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO, PROGRAMA_ID) VALUES (10, 'sebas@unicauca.edu.co', 'CEDULA_CIUDADANIA', '10618', 'MASCULINO', 'PREGRADO', 'Cesar', 'Perez', '3225864404', 1);

-- -- ROL FUNCIONARIO
INSERT INTO rol_funcionario (ID, NOMBRE) VALUES (1, 'SUPER_ADMIN');
INSERT INTO rol_funcionario (ID, NOMBRE) VALUES (2, 'USUARIOS');
INSERT INTO rol_funcionario (ID, NOMBRE) VALUES (3, 'GRUPOS');
INSERT INTO rol_funcionario (ID, NOMBRE) VALUES (4, 'SEMILLEROS');
INSERT INTO rol_funcionario (ID, NOMBRE) VALUES (5, 'PROYECTOS_INTERNOS');
INSERT INTO rol_funcionario (ID, NOMBRE) VALUES (6, 'PROYECTOS_EXTERNOS');
INSERT INTO rol_funcionario (ID, NOMBRE) VALUES (7, 'VICERRECTOR');

-- -- -- CREDENCIAL
INSERT INTO credencial (ID, EMAIL, PASSWORD, USER_ID) VALUES (1, 'mandresmosquera@gmail.com', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 1);
INSERT INTO credencial (ID, EMAIL, PASSWORD, USER_ID) VALUES (6, 'miguelmonje@unicauca.edu.co', '$2a$10$18wfrpKUmiVKzIAnm6trUe67Q0XHaqwbbMG/jLObycUuFE/6OwwAy', 7);
INSERT INTO credencial (ID, EMAIL, PASSWORD, USER_ID) VALUES (2, 'yurani@unicauca.edu.co', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 2);
INSERT INTO credencial (ID, EMAIL, PASSWORD, USER_ID) VALUES (3, 'yurany@unicauca.edu.co', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 3);
INSERT INTO credencial (ID, EMAIL, PASSWORD, USER_ID) VALUES (4, 'andrea@unicauca.edu.co', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 4);
INSERT INTO credencial (ID, EMAIL, PASSWORD, USER_ID) VALUES (5, 'maicol@unicauca.edu.co', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 5);
INSERT INTO credencial (ID, EMAIL, PASSWORD, USER_ID) VALUES (7, 'panita49545@gmail.com', '$2a$10$JFFr5qTnU7yddAkGjFrJKOzDT6kUgDl2XwtYHs8bKnwkXnKG42yLi', 8);

-- -- -- FUNCIONARIO
INSERT INTO funcionario (ID, USUARIO_ID, ROL_ID, ESTADO, FECHA_INICIO) VALUES (1, 1, 1, 1, TO_DATE('2024-01-01', 'YYYY-MM-DD'));
INSERT INTO funcionario (ID, USUARIO_ID, ROL_ID, ESTADO, FECHA_INICIO) VALUES (2, 3, 4, 1, TO_DATE('2024-01-01', 'YYYY-MM-DD'));
INSERT INTO funcionario (ID, USUARIO_ID, ROL_ID, ESTADO, FECHA_INICIO) VALUES (3, 5, 4, 1, TO_DATE('2024-01-01', 'YYYY-MM-DD'));

-- -- SOLICITUD DE USUARIO
INSERT INTO usuario_solicitud (ID, CREADO_POR_USUARIO_ID, PROGRAMA_ID, CORREO, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, SEXO, ESTADO, TIPO_USUARIO, NOMBRE, APELLIDO, TELEFONO, NOTA) VALUES (1, 1, 1, 'angee@gmail.com', 'CEDULA_CIUDADANIA', '1062', 'MASCULINO', 'REVISION_VRI', 'ADMINISTRATIVO', 'Angee Vannessa', 'Hincapie', '3225864404', 'no me lo nieguen porfa');

-- -- SOLICITUD DE USUARIO OBSERVACIONES
INSERT INTO usuario_solicitud_obser (ID, SOLICITUD_USUARIO_ID, FUNCIONARIO_ID, OBSERVACION, FECHA_OBSERVACION, RESUELTA, NOTIFICACION_DE_VENCIMIENTO) VALUES (1, 1, 1, 'Por favor no nieguen esta solicitud', TO_DATE('2024-01-01', 'YYYY-MM-DD'), 0, 0);

-- -- SOLICITUD DE USUARIO OBSERVACIONES CONVERSACIÓN
INSERT INTO usuario_solicitud_conver (ID, USUA_SOLICITUD_OBSER_ID, AUTOR, MENSAJE, FECHA_MENSAJE) VALUES (1, 1, 'Miguel Mosquera', 'Me parece injusta la observación', TO_DATE('2024-01-01', 'YYYY-MM-DD'));
INSERT INTO usuario_solicitud_conver (ID, USUA_SOLICITUD_OBSER_ID, AUTOR, MENSAJE, FECHA_MENSAJE) VALUES (2, 1, 'Daniel Paz', 'Pues de malas', TO_DATE('2024-01-01', 'YYYY-MM-DD'));

-- -- |***** PROYECTO *****|

-- -- PRODUCTO PROYECTO
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (1, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'ARTICULOS_IMPRESOS_A1_Q1', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (2, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'ARTICULOS_IMPRESOS_A2_Q2', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (3, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'ARTICULOS_IMPRESOS_B_Q3', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (4, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'ARTICULOS_IMPRESOS_C_Q4', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (5, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'ARTICULOS_ELECTRONICOS_A1_Q1', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (6, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'ARTICULOS_ELECTRONICOS_A2_Q2', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (7, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'ARTICULOS_ELECTRONICOS_B_Q3', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (8, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'ARTICULOS_ELECTRONICOS_C_Q4', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (9, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'LIBROS', 'En fase de evaluación por pares. Proceso en el que el documento ha sido evaluado y cuenta con la aprobación para ser publicado- Entregable: Carta del editor que confirme la aprobación de la publicación del documento. Publicado: Entregable: documento en su versión final publicado por la editorial');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (10, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'CAPITULOS_DE_LIBRO', 'En fase de evaluación por pares. Proceso en el que el documento ha sido evaluado y cuenta con la aprobación para ser publicado- Entregable: Carta del editor que confirme la aprobación de la publicación del documento. Publicado: Entregable: documento en su versión final publicado por la editorial');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (11, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'NOTAS_CIENTIFICAS', 'En fase de evaluación por pares. Entregable: Comunicación o pantallazo de la revista que evidencie la evaluación del documento- Publicado: Entregable: documento en su versión final publicado por la revista');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (12, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'PATENTES', 'Documento radicado en la Superintendencia de Industria y Comercio');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (13, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'OBRAS_O_PRODUCTOS_DE_INVESTIGACION_CREACION_EN_ARTES_ARQUITECTURA_Y_DISENO', 'Certificado de la instancia de valoración de la obra o un certificado emitido por Rectoría donde indica la naturaleza de la obra o producto y su relación con un proyecto de investigación inscrito en la Vicerrectoría de Investigaciones NOTA: los certificados emitidos por la Rectoría de la Universidad del Cauca se gestionan en la VRI al correo: gruposvri@unicauca.edu.co');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (14, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'VARIEDAD_VEGETAL', '1. Certificado obtentor de variedad vegetal: Acto administrativo del ICA. 2. Diploma que entrega el ICA. Registro nacional. Inscripción en el registro nacional de cultivadores');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (15, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'NUEVA_RAZA_ANIMAL', 'Documento que expresa el estado de la solicitud, en proceso u obtenida o Certificado en Calidad de Bioseguridad (CCB) expedido por el ICA para animales modificados genéticamente');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (16, 'GENERACION_DE_NUEVO_CONOCIMIENTO', 'POBLACIONES_MEJORADAS_RAZAS_PECUARIAS', 'Certificación del registro de la raza mejorada emitido por el Ministerio de Agricultura; y Soporte con Catálogo de reproductores con mérito genético superior/Evaluación y estimadores de tendencia genética donde se observe el impacto positivo para las características mejoradas a través de varias generaciones');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (17, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_TECNOLOGICOS_CERTIFICADOS_O_VALIDADOS', 'DISENO_INDUSTRIAL', 'Documento de Registro diseño industrial');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (18, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_TECNOLOGICOS_CERTIFICADOS_O_VALIDADOS', 'CIRCUITO_INTEGRADO', 'Documento de Registro del esquema de trazado de circuito integrado');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (19, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_TECNOLOGICOS_CERTIFICADOS_O_VALIDADOS', 'SOFTWARE', '1. Software  2. Certificación de la entidad productora del software en el que se haga claridad sobre el nivel de innovación. NOTA: Este certificado es emitido por la Rectoría de la Universidad del Cauca y se gestionan en la VRI al correo: gruposvri@unicauca.edu.co');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (20, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_TECNOLOGICOS_CERTIFICADOS_O_VALIDADOS', 'PRODUCTOS_NUTRACEUTICOS', 'Documento de registro del INVIMA');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (21, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_TECNOLOGICOS_CERTIFICADOS_O_VALIDADOS', 'COLECCIONES_CIENTIFICAS', 'Soporte de certificación de curaduría, que indique vigencia y uso de la colección');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (22, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_TECNOLOGICOS_CERTIFICADOS_O_VALIDADOS', 'NUEVOS_REGISTROS_CIENTIFICOS', '1. Certificación de validación e incorporación de nuevos registros de productos de procesos de CTeI en sistemas de información científicos (La institución que certifique al nuevo registro debe ser diferente a la institución que emita el nuevo registro), o Artículo científico publicado en Categoría A1, A2, B o C');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (23, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_EMPRESARIALES', 'PLANTA_PILOTO', '1. Documento de Registro de la planta piloto. 2. Contratos de desarrollo de esta Planta Piloto.');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (24, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_EMPRESARIALES', 'PROTOTIPO_INDUSTRIAL', '1. Documento de Registro de prototipo industrial.');
INSERT INTO producto_proyecto (ID, CATEGORIA, TIPO, DESCRIPCION) VALUES (25, 'DESARROLLO_TECNOLOGICO_E_INNOVACION_EMPRESARIALES', 'SIGNOS_DISTINTIVOS', '1. Documento con el Número del registro del signo distintivo.');

-- -- ROL PROYECTO
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (1, 'DIRECTOR');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (2, 'CO_INVESTIGADOR');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (3, 'ASESOR');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (4, 'ESTUDIANTE_DOCTORADO');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (5, 'ESTUDIANTE_ESPECIALIZACION');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (6, 'ESTUDIANTE_MAESTRIA');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (7, 'ESTUDIANTE_POSTDOCTORADO');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (8, 'ESTUDIANTE_PREGRADO');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (9, 'INVESTIGADOR_EXTERNO');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (10, 'JOVEN_INVESTIGADOR');
INSERT INTO rol_proyecto (ID, NOMBRE) VALUES (11, 'PERSONAL_TECNICO');

-- -- PROYECTO
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (1, 'Método de Ingeniería de Requisitos para Manejo de Discrepancias', 'FORMULADO', TO_DATE('2024-08-30', 'YYYY-MM-DD'), TO_DATE('2024-08-30', 'YYYY-MM-DD'), 'Este será un proyecto super elegante', 'Elaborar un proyecto re elegante', 'Alcanzar la Elegancia', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 'Texto', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (2, 'Desarrollo Sostenible en Zonas Rurales', 'APROBADO', TO_DATE('2024-01-15', 'YYYY-MM-DD'), TO_DATE('2025-12-30', 'YYYY-MM-DD'), 'Promover prácticas sostenibles en comunidades rurales', 'Mejorar la calidad de vida a través de la sostenibilidad', 'Implementar energías renovables, fomentar la agricultura orgánica', 'Las zonas rurales necesitan un desarrollo equilibrado con la naturaleza', 'Investigación cualitativa y cuantitativa, análisis de campo', 'Cumplimiento de regulaciones ambientales y sociales', 'Protección de datos de comunidades locales', 'Impactos ambientales negativos mitigados', 'Aumento de la autosuficiencia y resiliencia en las comunidades', 'Inclusión de todas las voces de la comunidad en la toma de decisiones', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (3, 'Innovación en Tecnología Educativa', 'REVISION_VRI', TO_DATE('2024-05-10', 'YYYY-MM-DD'), TO_DATE('2025-05-10', 'YYYY-MM-DD'), 'Desarrollar nuevas herramientas tecnológicas para la educación superior', 'Facilitar el aprendizaje a través de la tecnología', 'Crear aplicaciones móviles y plataformas en línea', 'La tecnología puede transformar la educación, haciéndola más accesible', 'Diseño centrado en el usuario, pruebas piloto en entornos educativos', 'Cumplimiento de normativas de accesibilidad y privacidad', 'Gestión adecuada de datos de estudiantes y profesores', 'Posibles resistencias al cambio por parte del profesorado', 'Mejora de la experiencia educativa y los resultados de aprendizaje', 'Monitoreo continuo de la efectividad de las herramientas', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (4, 'Impacto del Cambio Climático en la Biodiversidad', 'EJECUCION', TO_DATE('2024-02-01', 'YYYY-MM-DD'), TO_DATE('2026-02-01', 'YYYY-MM-DD'), 'Estudiar cómo el cambio climático afecta la biodiversidad en ecosistemas críticos', 'Desarrollar estrategias de conservación adaptativas', 'Monitorear especies clave, evaluar cambios en los ecosistemas', 'La biodiversidad es esencial para el equilibrio ecológico', 'Investigación de campo, análisis de datos ambientales', 'Cumplimiento de normativas ambientales internacionales', 'Confidencialidad de datos sensibles sobre especies en peligro', 'Alteración de hábitats naturales durante la investigación', 'Generación de planes de conservación efectivos y viables', 'Consideración de variables climáticas en constante cambio', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (5, 'Salud Mental y Bienestar Estudiantil', 'FORMULADO_OBSERVACIONES', TO_DATE('2024-03-01', 'YYYY-MM-DD'), TO_DATE('2025-03-01', 'YYYY-MM-DD'), 'Evaluar el estado de salud mental entre estudiantes universitarios', 'Mejorar los servicios de apoyo psicológico en la universidad', 'Realizar encuestas y entrevistas, desarrollar programas de apoyo', 'La salud mental es fundamental para el éxito académico y personal', 'Investigación cualitativa y cuantitativa, análisis de casos', 'Cumplimiento de normativas de privacidad y ética en salud', 'Protección de la identidad de los participantes', 'Posibles efectos secundarios de intervenciones psicológicas', 'Reducción de la ansiedad y el estrés entre los estudiantes', 'Necesidad de recursos adicionales para implementar programas efectivos', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (6, 'Energías Renovables y Sostenibilidad', 'APROBADO', TO_DATE('2024-04-15', 'YYYY-MM-DD'), TO_DATE('2026-04-15', 'YYYY-MM-DD'), 'Investigar el uso de energías renovables en áreas urbanas', 'Reducir la huella de carbono a través de energías limpias', 'Instalar paneles solares, promover el uso de bicicletas', 'Las ciudades deben adoptar energías renovables para combatir el cambio climático', 'Estudios de viabilidad técnica y económica, análisis de impacto ambiental', 'Cumplimiento de normativas de sostenibilidad urbana', 'Protección de datos sobre el consumo energético', 'Resistencia al cambio por parte de industrias tradicionales', 'Reducción significativa de emisiones de gases de efecto invernadero', 'Involucrar a la comunidad en la adopción de energías limpias', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (7, 'Optimización de Procesos Industriales', 'REVISION_VRI', TO_DATE('2024-06-01', 'YYYY-MM-DD'), TO_DATE('2025-06-01', 'YYYY-MM-DD'), 'Mejorar la eficiencia de procesos industriales en la región', 'Optimizar el uso de recursos en plantas industriales', 'Implementar tecnologías de automatización, reducir desperdicios', 'La eficiencia industrial es clave para la competitividad económica', 'Modelado y simulación de procesos, pruebas en planta', 'Cumplimiento de normativas de seguridad y medio ambiente', 'Confidencialidad de información estratégica de las empresas', 'Interrupciones temporales en la producción durante la implementación', 'Mejoras en la rentabilidad y sostenibilidad de las operaciones', 'Evaluación continua de los procesos optimizados', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (8, 'Inteligencia Artificial y Ética', 'FORMULADO', TO_DATE('2024-07-01', 'YYYY-MM-DD'), TO_DATE('2025-07-01', 'YYYY-MM-DD'), 'Explorar las implicaciones éticas del uso de la inteligencia artificial', 'Garantizar un uso ético de la inteligencia artificial en aplicaciones diversas', 'Identificar riesgos, proponer regulaciones', 'La IA plantea desafíos éticos que deben ser abordados', 'Análisis de casos de estudio, desarrollo de marcos éticos', 'Cumplimiento de normativas internacionales sobre ética en IA', 'Protección de datos personales y privacidad', 'Uso indebido de IA en aplicaciones críticas', 'Desarrollo de guías y recomendaciones para el uso ético de IA', 'Consideración de las implicaciones sociales y económicas', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (9, 'Estudio de Ecosistemas Acuáticos', 'EJECUCION', TO_DATE('2024-08-01', 'YYYY-MM-DD'), TO_DATE('2026-08-01', 'YYYY-MM-DD'), 'Analizar la salud de los ecosistemas acuáticos en la región', 'Proteger y restaurar ecosistemas acuáticos', 'Monitorear la calidad del agua, evaluar la biodiversidad acuática', 'Los ecosistemas acuáticos son vitales para la salud ambiental', 'Investigación de campo, análisis de muestras de agua', 'Cumplimiento de regulaciones ambientales', 'Protección de datos sobre especies en peligro', 'Alteración de hábitats acuáticos durante la investigación', 'Mejoras en la calidad del agua y la biodiversidad', 'Consideración de factores estacionales y climáticos', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO, CONVOCATORIA_ID) VALUES (10, 'Ciencia de Datos para la Toma de Decisiones', 'FORMULADO_OBSERVACIONES', TO_DATE('2024-09-01', 'YYYY-MM-DD'), TO_DATE('2025-09-01', 'YYYY-MM-DD'), 'Aplicar ciencia de datos para mejorar la toma de decisiones en organizaciones', 'Optimizar procesos de toma de decisiones mediante el análisis de datos', 'Desarrollar modelos predictivos, implementar dashboards', 'La ciencia de datos puede transformar la toma de decisiones', 'Análisis de datos históricos, desarrollo de algoritmos', 'Cumplimiento de normativas de protección de datos', 'Confidencialidad de información sensible de las organizaciones', 'Posibles errores en los modelos predictivos', 'Mejoras en la precisión y rapidez de las decisiones', 'Monitoreo continuo de los modelos implementados', 0, 1);
INSERT INTO proyecto (ID, NOMBRE, ESTADO, FECHA_INICIO, FECHA_FIN, PLANTEAMIENTO, OBJETIVO_GENERAL, OBJETIVOS_ESPECIFICOS, JUSTIFICACION, ENFOQUE_METODOLOGICO, ASPECTOS_ETICOS_LEGALES, CONFIDENCIALIDAD, EFECTOS_ADVERSOS, IMPAC_RESUL_ESPERADOS, CONSIDERACIONES, ELIMINADO_LOGICO) VALUES (11, 'Desarrollo de Vacunas contra Enfermedades Tropicales', 'APROBADO', TO_DATE('2024-10-01', 'YYYY-MM-DD'), TO_DATE('2026-10-01', 'YYYY-MM-DD'), 'Desarrollar y probar vacunas efectivas contra enfermedades tropicales', 'Reducir la incidencia de enfermedades tropicales en comunidades vulnerables', 'Realizar ensayos clínicos, evaluar la efectividad de las vacunas', 'Las enfermedades tropicales son un problema de salud pública urgente', 'Investigación en laboratorio, pruebas en campo', 'Cumplimiento de normativas internacionales de ensayos clínicos', 'Confidencialidad de datos de pacientes', 'Efectos secundarios potenciales de las vacunas', 'Desarrollo de vacunas seguras y eficaces', 'Consideración de la logística de distribución en áreas remotas', 0);

-- -- EVIDENCIA PROYECTO DOC CONVOCATORIA
INSERT INTO evidencia_proyec_docu_conv (DOCUMENTO_CONVOCATORIA_ID, ID, PROYECTO_ID, NOMBRE) VALUES ('1', 1, '1', 'escudo-departamento-del-cauca.jpg');

-- -- INTEGRANTE PROYECTO
INSERT INTO integrante_proyecto (ID, ESTADO, FECHA_INICIO, ROL_ID, PROYECTO_ID, USUARIO_ID) VALUES(1, 1, TO_DATE('2024-08-30', 'YYYY-MM-DD'), 1, 1, 7);

-- -- ENFOQUE DIFERENCIAL
INSERT INTO enfoque_diferencial (ID, NOMBRE) VALUES (1, 'Comunidad Afro');
INSERT INTO enfoque_diferencial (ID, NOMBRE) VALUES (2, 'Comunidad Palenquera');
INSERT INTO enfoque_diferencial (ID, NOMBRE) VALUES (3, 'Comunidad Indigena');
INSERT INTO enfoque_diferencial (ID, NOMBRE) VALUES (4, 'Comunidad LGBTIQ+');

-- -- ENFOQUE DIFERENCIAL PROYECTO
-- -- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (1, 1, 1);
-- -- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (2, 2, 1);
-- -- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (3, 3, 1);
-- -- INSERT INTO enfoque_diferencial_proyecto(id, enfoqueDiferencialId, proyectoId) VALUES (4, 4, 2);


-- -- |***** UTILIDADES *****|

-- -- MAIL TEMPLATE
INSERT INTO templates (ID, NOMBRE_TEMPLATE, DESCRIPTION, VARS) VALUES (1, 'bienvenidoSIVRI.html', 'Correo para crear credenciales de Usuario', 'nombreCompleto, passwordCode');
INSERT INTO templates (ID, NOMBRE_TEMPLATE, DESCRIPTION, VARS) VALUES (2, 'recuperarContraseña.html', 'Correo para recuperar la contraseña de un usuario', 'correo,codigo');
INSERT INTO templates (ID, NOMBRE_TEMPLATE, DESCRIPTION, VARS) VALUES (3, 'notificacionSIVRI.html', 'Notificacion generica de SIVRI', 'mensaje');
INSERT INTO templates (ID, NOMBRE_TEMPLATE, DESCRIPTION, VARS) VALUES (4, 'notificacionRevisionVRI.html', 'Notificacion generica de envio a revision vri', 'semilleroId,nombreSemillero,nombreUsuario');
INSERT INTO templates (ID, NOMBRE_TEMPLATE, DESCRIPTION, VARS) VALUES (5, 'notificacionAlMentorSemillero.html', 'Notificacion generica al mentor de un semillero', 'semilleroId,nombreSemillero,nombreDirector');









-- -- **************** import yurany *****************************
-- --rol semillero
 INSERT INTO ROL_SEMILLERO (ID, ROL_SEMILLERO) VALUES(1,'COORDINADOR');
 INSERT INTO ROL_SEMILLERO (ID, ROL_SEMILLERO) VALUES(2,'MENTOR');
 INSERT INTO ROL_SEMILLERO (ID, ROL_SEMILLERO) VALUES(3,'MIEMBRO_ACTIVO_PROFESOR');
 INSERT INTO ROL_SEMILLERO (ID, ROL_SEMILLERO) VALUES(4,'MIEMBRO_ACTIVO_ESTUDIANTE_POSGRADO');
 INSERT INTO ROL_SEMILLERO (ID, ROL_SEMILLERO) VALUES(5,'MIEMBRO_ACTIVO_EGRESADO');
 INSERT INTO ROL_SEMILLERO (ID, ROL_SEMILLERO) VALUES(6,'SEMILLAS');

-- --ROL GRUPO
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(1,'DIRECTOR');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(2,'COINVESTIGADOR');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(3,'ASESOR');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(4,'ESTUDIANTE_PREGRADO');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(5,'ESTUDIANTE_ESPECIALIZACION');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(6,'ESTUDIANTE_MAESTRIA');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(7,'ESTUDIANTE_DOCTORADO');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(8,'ESTUDIANTE_POSDOCTORADO');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(9,'INVESTIGADOR_EXTERNO');
 INSERT INTO ROL_GRUPO (ID, ROL_GRUPO) VALUES(10,'JOVEN_INVESTIGADOR');


INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (1, 'GRUPO DE CIENCIA', TO_DATE('2023-03-08', 'YYYY-MM-DD'), 'Desarrollar investigación científica', 'mision del grupo', 'El grupo GCISA-TSEJK tiene');
INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (2, 'ÁGORA - INVESTIGACION POLITICA', TO_DATE('2023-03-08', 'YYYY-MM-DD'), 'Impulsar el interés investigativo ', 'El semillero tiene como propósito crear un nucleo', 'El semillero SIR');
INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (3, 'SEMILLERO INVESTIGACION', TO_DATE('2023-03-08', 'YYYY-MM-DD'), 'Impulsar el interés investigativo ', 'El semillero tiene como propósito crear un nucleo', 'El semillero SIR');
INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (4, 'CIENCIA E INGENIERIA ', TO_DATE('2023-03-08', 'YYYY-MM-DD'), 'Impulsar  ', 'El semillero tiene como propósito crear un nucleo', 'El semillero SIR');
INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (5, 'INGENIERIA AMBIENTAL', TO_DATE('2023-03-08', 'YYYY-MM-DD'), 'Impulsar el ', 'El semillero tiene como propósito crear un nucleo', 'El semillero SIR');
INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (6, 'SEMILLERO4', TO_DATE('2023-03-08', 'YYYY-MM-DD'), 'Impulsar el interés', 'El semillero tiene como propósito crear un nucleo', 'El semillero SIR');
INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (7, 'SEMILLERO5', TO_DATE('2023-03-08', 'YYYY-MM-DD'), 'Impulsar el investigativo ', 'El semillero tiene como propósito crear un nucleo', 'El semillero SIR');
INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (8, 'SEMILLERO6', TO_DATE('2023-03-08', 'YYYY-MM-DD'), 'interés investigativo ', 'El semillero tiene como propósito crear un nucleo', 'El semillero SIR');
INSERT INTO ORGANISMO_DE_INVESTIGACION (ID, NOMBRE, FECHA_CREACION, OBJETIVO, MISION, VISION) VALUES (9, 'GRUPO I+D EN TECNOLOGÍAS DE LA INFORMACIÓN', TO_DATE('2023-03-08', 'YYYY-MM-DD'), '1. Fortalecer la infraestructura humana, técnica, investigativa y de formación especializada en diferentes áreas, de todo el Grupo de Investigación de Unicauca. 2. Definir, diseñar e implementar proyectos que propendan por la interdisciplinariedad de áreas dentro y fuera de La universidad Del Cauca.', 'El grupo se propone crear la infraestructura base que facilite la generación de soluciones informáticas para la comunidad en general y brinde asesorías en cuanto al aprovechamiento de nuevas tecnologías de la información para los sectores productivos y académicos.', 'Preservar y estimular el crecimiento de la capacidad de investigación e innovación en el área las Tecnologías de la Información de la Universidad del Cauca, a través de los integrantes del grupo GTI, por medio de la creación de espacios adecuados donde la crítica y el debate intelectual se constituyan en fuente de nuevo conocimiento. El GTI promoverá el desarrollo de su talento humano (profesores, investigadores y estudiantes), aportará la infraestructura requerida y establecerá alianzas estratégicas con centros de investigación de reconocido prestigio internacional para el desarrollo de su labor, con el propósito de agregar valor a su relación con la sociedad. Los principios de calidad, transparencia, independencia de criterio, compromiso y servicio, orientarán las actuaciones del GTI y se constituirán en su diferencial competitivo con respecto de otros grupos en el área. A largo plazo el GTI pretende ser: ¿Un centro tecnológico en Investigación y Desarrollo con reconocimiento nacional e internacional generador de proyectos ');

-- --grupo
INSERT INTO GRUPO (GRUPO_ID, DEPARTAMENTO_ID, ESTADO, DIRECCION, TELEFONO, EMAIL, SITIO_WEB, ESCALAFON_COLCIENCIAS, DIRECCION_GRUP_LAC, CODIGO_COLCIENCIAS, CENTRO_INVESTIGACIONES, REALIZACIONES, PERSPECTIVAS) VALUES (1,1,'ACTIVO','Facultad de Ingeniería','2-8209800','jccasas@unicauca.edu.co','No','A','http://scienti.colciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000012079','COL0119567','centro investigacion','Desarrollo y aprobación de 5 trabajos de Pregrado en el Departamento de Ingeniería Ambiental y Sanitaria, Facultad de Ingeniería Civil.','perspectivas del grupo');
INSERT INTO GRUPO (GRUPO_ID, DEPARTAMENTO_ID, ESTADO, DIRECCION, TELEFONO, EMAIL, SITIO_WEB, ESCALAFON_COLCIENCIAS, DIRECCION_GRUP_LAC, CODIGO_COLCIENCIAS, CENTRO_INVESTIGACIONES, REALIZACIONES, PERSPECTIVAS) VALUES (9,1,'ACTIVO','Sector Tulcan - FIET','8233031','gti@unicauca.edu.co','No','A','http://scienti.minciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000002157','COL0023303', 'centro investigacion','valor','¿Productividad investigativa medida por índices de eficiencia, eficacia y calidad de los proyectos. ¿Aporte de proyectos significativos, innovadores y útiles, que propendan por el mejoramiento y la calidad de vida de los posibles usuarios de los mismos. ¿Creación de alianzas estratégicas regionales, nacionales e internacionales, que generen vínculos entre distintos estamentos, brindando con ello: saber científico, financiamiento, investigación y todo tipo de apoyo al GTI.');
--
--
-- --semillero
 INSERT INTO SEMILLERO (SEMILLERO_ID, GRUPO_ID, ESTADO, CORREO, SEDE) VALUES (2,1,'ACTIVO','agora@correo.edu.co','POPAYAN');
 INSERT INTO SEMILLERO (SEMILLERO_ID, GRUPO_ID, ESTADO, CORREO, SEDE) VALUES (3,1,'FORMULADO','semillero3@correo.edu.co','POPAYAN');
 INSERT INTO SEMILLERO (SEMILLERO_ID, GRUPO_ID, ESTADO, CORREO, SEDE) VALUES (4,1,'ACTIVO','semillero4@correo.edu.co','POPAYAN');
 INSERT INTO SEMILLERO (SEMILLERO_ID, GRUPO_ID, ESTADO, CORREO, SEDE) VALUES (5,1,'ACTIVO','agora5@correo.edu.co','POPAYAN');
 INSERT INTO SEMILLERO (SEMILLERO_ID, GRUPO_ID, ESTADO, CORREO, SEDE) VALUES (6,9,'ACTIVO','agora6@correo.edu.co','POPAYAN');
 INSERT INTO SEMILLERO (SEMILLERO_ID, GRUPO_ID, ESTADO, CORREO, SEDE) VALUES (7,1,'ACTIVO','agora7@correo.edu.co','POPAYAN');
 INSERT INTO SEMILLERO (SEMILLERO_ID, GRUPO_ID, ESTADO, CORREO, SEDE) VALUES (8,1,'ACTIVO','agora8@correo.edu.co','POPAYAN');

-- -- integrante semillero
 INSERT INTO INTEGRANTE_SEMILLERO (ID_INTEGRANTE_SEMILLERO, SEMILLERO_ID, USUARIO_ID, ROL_ID, ESTADO, FECHA_INGRESO, FECHA_RETIRO) VALUES (1,2,3,2, 'ACTIVO', TO_DATE('2023-09-04', 'YYYY-MM-DD'),NULL);
 INSERT INTO INTEGRANTE_SEMILLERO (ID_INTEGRANTE_SEMILLERO, SEMILLERO_ID, USUARIO_ID, ROL_ID, ESTADO, FECHA_INGRESO, FECHA_RETIRO) VALUES (2,2,4,1, 'ACTIVO', TO_DATE('2023-09-04', 'YYYY-MM-DD'),NULL);
 INSERT INTO INTEGRANTE_SEMILLERO (ID_INTEGRANTE_SEMILLERO, SEMILLERO_ID, USUARIO_ID, ROL_ID, ESTADO, FECHA_INGRESO, FECHA_RETIRO) VALUES (3,2,10,6, 'ACTIVO', TO_DATE('2023-09-04', 'YYYY-MM-DD'),NULL);
 INSERT INTO INTEGRANTE_SEMILLERO (ID_INTEGRANTE_SEMILLERO, SEMILLERO_ID, USUARIO_ID, ROL_ID, ESTADO, FECHA_INGRESO, FECHA_RETIRO) VALUES (4,2,6,6, 'ACTIVO', TO_DATE('2023-09-04', 'YYYY-MM-DD'),NULL);
 INSERT INTO INTEGRANTE_SEMILLERO (ID_INTEGRANTE_SEMILLERO, SEMILLERO_ID, USUARIO_ID, ROL_ID, ESTADO, FECHA_INGRESO, FECHA_RETIRO) VALUES (5,3,2,2, 'ACTIVO', TO_DATE('2023-09-04', 'YYYY-MM-DD'),NULL);
--
-- --integrante grupo

 INSERT INTO INTEGRANTE_GRUPO (ID, ROL_GRUPO_ID, USUARIO_ID, GRUPO_ID, ESTADO, FECHA_INICIO, FECHA_FIN) VALUES (1, 1, 3, 9, 'ACTIVO', TO_DATE('2023-09-07', 'YYYY-MM-DD'), NULL);
 INSERT INTO INTEGRANTE_GRUPO (ID, ROL_GRUPO_ID, USUARIO_ID, GRUPO_ID, ESTADO, FECHA_INICIO, FECHA_FIN) VALUES (2,1,4,1,'ACTIVO',TO_DATE('2023-09-07', 'YYYY-MM-DD'),NULL);
 INSERT INTO INTEGRANTE_GRUPO (ID, ROL_GRUPO_ID, USUARIO_ID, GRUPO_ID, ESTADO, FECHA_INICIO, FECHA_FIN) VALUES (3,2,6,1,'ACTIVO',TO_DATE('2023-09-07', 'YYYY-MM-DD'),NULL);
 INSERT INTO INTEGRANTE_GRUPO (ID, ROL_GRUPO_ID, USUARIO_ID, GRUPO_ID, ESTADO, FECHA_INICIO, FECHA_FIN) VALUES (4,1,7,1,'ACTIVO',TO_DATE('2023-09-07', 'YYYY-MM-DD'),NULL);
 INSERT INTO INTEGRANTE_GRUPO (ID, ROL_GRUPO_ID, USUARIO_ID, GRUPO_ID, ESTADO, FECHA_INICIO, FECHA_FIN) VALUES (5,1,8,1,'ACTIVO',TO_DATE('2023-09-07', 'YYYY-MM-DD'),NULL);
 INSERT INTO INTEGRANTE_GRUPO (ID, ROL_GRUPO_ID, USUARIO_ID, GRUPO_ID, ESTADO, FECHA_INICIO, FECHA_FIN) VALUES (6,3,2,1,'ACTIVO',TO_DATE('2023-09-07', 'YYYY-MM-DD'),NULL);

--compromiso Semillero
 INSERT INTO COMPROMISO_SEMILLERO (ID, NOMBRE) VALUES(1, 'BOLETÍN DIVULGATIVO DE RESULTADOS DE INVESTIGACIÓN');
 INSERT INTO COMPROMISO_SEMILLERO (ID, NOMBRE) VALUES(2, 'CONSULTORÍAS CIENTÍFICO-TECNOLÓGICAS');
 INSERT INTO COMPROMISO_SEMILLERO (ID, NOMBRE) VALUES(3, 'DOCUMENTO DE TRABAJO (WORKING PAPER)');

-- --plan de trabajo
 INSERT INTO PLAN_TRABAJO (ID, SEMILLERO_ID, NOMBRE_PLAN, ANIO, ESTADO) VALUES (1,2, 'plan', 2023,'FINALIZADO');
 INSERT INTO PLAN_TRABAJO (ID, SEMILLERO_ID, NOMBRE_PLAN, ANIO, ESTADO) VALUES (2,2, 'plan de trabajo', 2024, 'FORMULADO');
--
-- --actividad plan de trabajo
 INSERT INTO ACTIVIDAD_PLAN_TRABAJO (ID, PLAN_TRABAJO_ID, COMPROMISO_SEMILLERO_ID, OBJETIVO, ACTIVIDAD, FECHA_INICIO, FECHA_FIN, RESPONSABLE_ID) VALUES(1,1,1,'obj','act',TO_DATE('2023-03-08', 'YYYY-MM-DD'),TO_DATE('2023-08-05', 'YYYY-MM-DD'),3);
 INSERT INTO ACTIVIDAD_PLAN_TRABAJO (ID, PLAN_TRABAJO_ID, COMPROMISO_SEMILLERO_ID, OBJETIVO, ACTIVIDAD, FECHA_INICIO, FECHA_FIN, RESPONSABLE_ID) VALUES(2,1,2,'obj','act',TO_DATE('2023-03-08', 'YYYY-MM-DD'),TO_DATE('2023-08-05', 'YYYY-MM-DD'),3);
 INSERT INTO ACTIVIDAD_PLAN_TRABAJO (ID, PLAN_TRABAJO_ID, COMPROMISO_SEMILLERO_ID, OBJETIVO, ACTIVIDAD, FECHA_INICIO, FECHA_FIN, RESPONSABLE_ID) VALUES(3,2,3,'obj','act',TO_DATE('2023-03-08', 'YYYY-MM-DD'),TO_DATE('2023-08-05', 'YYYY-MM-DD'),3);
--
-- --evidencia actividad
 INSERT INTO EVIDENCIA_ACTIVIDAD (ID, ACTIVIDAD_ID, EVIDENCIA) VALUES(1,1,'evidencia');
 INSERT INTO EVIDENCIA_ACTIVIDAD (ID, ACTIVIDAD_ID, EVIDENCIA) VALUES(2,2,'evidencia');
--
-- --linea de investigacion
 INSERT INTO LINEA_INVESTIGACION (ID, SEMILLERO_ID, LINEA) VALUES (1,2,'calidad de procesos');
 INSERT INTO LINEA_INVESTIGACION (ID, SEMILLERO_ID, LINEA) VALUES (2,2,'calidad de sotware');
--
-- --semillero programa
 INSERT INTO SEMILLERO_PROGRAMA(ID,SEMILLERO_ID,ID_PROGRAMA) VALUES(1,2,1);
 INSERT INTO SEMILLERO_PROGRAMA(ID,SEMILLERO_ID,ID_PROGRAMA) VALUES(2,2,2);
--
-- --observacion semillero
--INSERT INTO  OBSERVACION_SEMILLERO (ID, SEMILLERO_ID, FUNCIONARIO_ID, OBSERVACION, FECHA) VALUES (1,2,1,'revisando el semillero se encuentra que no ha subido los documentos',TO_DATE('2023-09-04', 'YYYY-MM-DD'));




-- -- COOPERACION
INSERT INTO COOPERACION (ID, ESTADO, FECHA_INICIO, ORGANISMO_DE_INVESTIGACION_ID, PRINCIPAL, PROYECTO_ID) VALUES (1, 1, TO_DATE('2024-08-30', 'YYYY-MM-DD'), 2, 1, 1);
