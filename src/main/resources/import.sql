-- =========================
-- CURSOS (6)
-- =========================

INSERT INTO Curso (anyo,nombreCurso,sector,email,nombreTutor) VALUES (2020,'DAW','Ciencia','carlos@instituto.es','Carlos Perez');
INSERT INTO Curso (anyo,nombreCurso,sector,email,nombreTutor) VALUES (2025,'ASIR','Ciencia','laura@instituto.es','Laura Gomez');
INSERT INTO Curso (anyo,nombreCurso,sector,email,nombreTutor) VALUES (2021,'Educacion Infantil','Educacion','sonia@instituto.es','Sonia Ruiz');
INSERT INTO Curso (anyo,nombreCurso,sector,email,nombreTutor) VALUES (2016,'Integracion Social','Educacion','miguel@instituto.es','Miguel Torres');
INSERT INTO Curso (anyo,nombreCurso,sector,email,nombreTutor) VALUES (2015,'Administracion y Finanzas','Empresa','luci@instituto.es','Lucia Navarro');
INSERT INTO Curso (anyo,nombreCurso,sector,email,nombreTutor) VALUES (2020,'Enfermeria','Sanidad','mikel@instituto.es','Miguel Romero');
INSERT INTO Curso (anyo,nombreCurso,sector,email,nombreTutor) VALUES (2016,'Veterinaria','Sanidad','lucifer@instituto.es','Lucia Fernandez');
INSERT INTO Curso (anyo,nombreCurso,sector,email,nombreTutor) VALUES (2026,'Dietetica','Sanidad','anita@instituto.es','Ana Martinez');
-- =========================
-- MODULOS (36)
-- =========================

INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Programacion Java',200,'Programacion');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Bases de Datos',180,'BBDD');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Entornos Desarrollo',120,'Entornos');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Lenguajes Marcas',140,'LMSGI');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Sistemas Informaticos',160,'Sistemas');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('FOL',90,'FOL');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Implantacion Sistemas',200,'Implantacion');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Seguridad Informatica',180,'Seguridad');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Servicios Red',160,'Servicios');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Hardware',140,'Hardware');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Sistemas Operativos',200,'SO');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Empresa e Iniciativa',90,'EIE');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Organizacion Alimentaria',150,'Organizacion');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Control Alimentario',160,'Control');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Microbiologia',180,'Microbiologia');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Fisiopatologia',150,'Fisiopatologia');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Educacion Sanitaria',120,'EducacionSanitaria');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Dietoterapia',170,'Dietoterapia');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Didactica',200,'Didactica');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Autonomia Personal',150,'Autonomia');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Juego Infantil',120,'Juego');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Desarrollo Cognitivo',160,'Cognitivo');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Expresion y Comunicacion',140,'Expresion');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Primeros Auxilios',90,'PrimerosAux');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Mediacion',160,'Mediacion');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Habilidades Sociales',150,'Habilidades');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Intervencion Familiar',170,'Intervencion');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Insercion Laboral',120,'Insercion');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Promocion Autonomia',140,'Promocion');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Metodologia Social',160,'Metodologia');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Contabilidad',200,'Contabilidad');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Gestion Financiera',180,'Finanzas');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Fiscalidad',160,'Fiscalidad');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('RRHH',140,'RRHH');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Ofimatica',120,'Ofimatica');
INSERT INTO Modulo (descripcion,horas,titulo) VALUES ('Proyecto Empresa',150,'Proyecto');

-- =========================
-- ALUMNOS (30)
-- =========================

INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Juan','Garcia','juan1@instituto.es',1);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Ana','Perez','ana2@instituto.es',1);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Luis','Martinez','luis3@instituto.es',1);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Marta','Sanchez','marta4@instituto.es',1);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Pablo','Romero','pablo5@instituto.es',1);

INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Lucia','Torres','lucia6@instituto.es',2);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Alberto','Navarro','alberto7@instituto.es',2);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Clara','Moreno','clara8@instituto.es',2);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('David','Jimenez','david9@instituto.es',2);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Sara','Ruiz','sara10@instituto.es',2);

INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Carlos','Lopez','carlos11@instituto.es',3);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Elena','Diaz','elena12@instituto.es',3);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Raul','Perez','raul13@instituto.es',3);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Paula','Garcia','paula14@instituto.es',3);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Mario','Santos','mario15@instituto.es',3);

INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Laura','Ortega','laura16@instituto.es',4);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Sergio','Cano','sergio17@instituto.es',4);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Irene','Vega','irene18@instituto.es',4);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Diego','Gil','diego19@instituto.es',4);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Celia','Ramos','celia20@instituto.es',4);

INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Andres','Hernandez','andres21@instituto.es',5);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Noelia','Suarez','noelia22@instituto.es',5);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Javier','Castro','javier23@instituto.es',5);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Cristina','Molina','cristina24@instituto.es',5);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Victor','Flores','victor25@instituto.es',5);

INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Alicia','Reyes','alicia26@instituto.es',6);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Adrian','Campos','adrian27@instituto.es',6);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Natalia','Rojas','natalia28@instituto.es',6);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Ivan','Serrano','ivan29@instituto.es',6);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Patricia','Leon','patricia30@instituto.es',6);


INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Alvaro','Hernandez','alvaro31@instituto.es',7);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Beatriz','Lopez','beatriz32@instituto.es',7);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Carlos','Molina','carlos33@instituto.es',7);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Daniela','Santos','daniela34@instituto.es',7);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Esteban','Garcia','esteban35@instituto.es',7);



INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Fátima','Navarro','fatima36@instituto.es',8);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Gabriel','Ruiz','gabriel37@instituto.es',8);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Helena','Torres','helena38@instituto.es',8);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Ignacio','Perez','ignacio39@instituto.es',8);
INSERT INTO Alumno (nombre,apellido,email,idCurso) VALUES ('Julia','Vega','julia40@instituto.es',8);

-- =========================
-- ACTIVIDADES (15)
-- =========================

INSERT INTO Actividad (titulo,descripcion) VALUES ('Practica Java 1','Primera práctica');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Examen BBDD','Examen BBDD');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Proyecto Final','Proyecto final');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Trabajo Seguridad','Trabajo seguridad');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Practica Redes','Practica redes');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Caso Practico','Caso practico');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Actividad Microbiologia','Microbiologia');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Simulacion Empresa','Simulacion');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Juego Didactico','Juego');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Intervencion Social','Intervencion');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Balance Contable','Balance');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Auditoria','Auditoria');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Evaluacion Parcial','Evaluacion');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Exposicion Oral','Exposicion');
INSERT INTO Actividad (titulo,descripcion) VALUES ('Practica Final','Practica final');

-- =========================
-- PERTENECE (5 módulos por curso)
-- =========================
-- =========================
-- SECTOR CIENCIA (Cursos 1-2)
-- =========================

-- CURSO 1 (DAW)
INSERT INTO Pertenece VALUES (1,1);
INSERT INTO Pertenece VALUES (1,2);
INSERT INTO Pertenece VALUES (1,3);
INSERT INTO Pertenece VALUES (1,4);
INSERT INTO Pertenece VALUES (1,5);
INSERT INTO Pertenece VALUES (1,6);
INSERT INTO Pertenece VALUES (1,7);
INSERT INTO Pertenece VALUES (1,8);

-- CURSO 2 (ASIR) comparte varios con DAW
INSERT INTO Pertenece VALUES (2,1);
INSERT INTO Pertenece VALUES (2,2);
INSERT INTO Pertenece VALUES (2,3);
INSERT INTO Pertenece VALUES (2,4);
INSERT INTO Pertenece VALUES (2,9);
INSERT INTO Pertenece VALUES (2,10);
INSERT INTO Pertenece VALUES (2,11);
INSERT INTO Pertenece VALUES (2,12);
INSERT INTO Pertenece VALUES (2,13);

-- =========================
-- SECTOR EDUCACIÓN (Cursos 3-4)
-- =========================

-- CURSO 3 (Educación Infantil)
INSERT INTO Pertenece VALUES (3,13);
INSERT INTO Pertenece VALUES (3,14);
INSERT INTO Pertenece VALUES (3,15);
INSERT INTO Pertenece VALUES (3,16);
INSERT INTO Pertenece VALUES (3,17);
INSERT INTO Pertenece VALUES (3,18);
INSERT INTO Pertenece VALUES (3,19);

-- CURSO 4 (Integración Social) comparte algunos con 3
INSERT INTO Pertenece VALUES (4,15);
INSERT INTO Pertenece VALUES (4,16);
INSERT INTO Pertenece VALUES (4,17);
INSERT INTO Pertenece VALUES (4,18);
INSERT INTO Pertenece VALUES (4,20);
INSERT INTO Pertenece VALUES (4,21);
INSERT INTO Pertenece VALUES (4,22);
INSERT INTO Pertenece VALUES (4,23);

-- =========================
-- SECTOR EMPRESA (Curso 5)
-- =========================

-- CURSO 5 (Administración y Finanzas)
INSERT INTO Pertenece VALUES (5,24);
INSERT INTO Pertenece VALUES (5,25);
INSERT INTO Pertenece VALUES (5,26);
INSERT INTO Pertenece VALUES (5,27);
INSERT INTO Pertenece VALUES (5,5);
INSERT INTO Pertenece VALUES (5,10);
INSERT INTO Pertenece VALUES (5,28);
INSERT INTO Pertenece VALUES (5,29);

-- =========================
-- SECTOR SANIDAD (Cursos 6-8)
-- =========================

-- CURSO 6 (Enfermería)
INSERT INTO Pertenece VALUES (6,20);
INSERT INTO Pertenece VALUES (6,21);
INSERT INTO Pertenece VALUES (6,22);
INSERT INTO Pertenece VALUES (6,23);
INSERT INTO Pertenece VALUES (6,24);
INSERT INTO Pertenece VALUES (6,30);
INSERT INTO Pertenece VALUES (6,19);

-- CURSO 7 (Veterinaria)
INSERT INTO Pertenece VALUES (7,20);
INSERT INTO Pertenece VALUES (7,21);
INSERT INTO Pertenece VALUES (7,22);
INSERT INTO Pertenece VALUES (7,25);
INSERT INTO Pertenece VALUES (7,26);
INSERT INTO Pertenece VALUES (7,30);
INSERT INTO Pertenece VALUES (7,18);
INSERT INTO Pertenece VALUES (7,29);

-- CURSO 8 (Dietética)
INSERT INTO Pertenece VALUES (8,20);
INSERT INTO Pertenece VALUES (8,21);
INSERT INTO Pertenece VALUES (8,23);
INSERT INTO Pertenece VALUES (8,24);
INSERT INTO Pertenece VALUES (8,27);
INSERT INTO Pertenece VALUES (8,28);
INSERT INTO Pertenece VALUES (8,30);
INSERT INTO Pertenece VALUES (8,16);

-- =========================
-- REALIZA (30 registros)
-- =========================
-- ALUMNOS 1–15
INSERT INTO Realiza VALUES (1,1,true,8.5);
INSERT INTO Realiza VALUES (2,1,true,7.0);
INSERT INTO Realiza VALUES (3,1,true,1.5);

INSERT INTO Realiza VALUES (2,2,true,6.8);
INSERT INTO Realiza VALUES (3,2,true,8.2);
INSERT INTO Realiza VALUES (4,2,false,0);

INSERT INTO Realiza VALUES (3,3,true,9.0);
INSERT INTO Realiza VALUES (4,3,true,7.3);
INSERT INTO Realiza VALUES (5,3,true,2.4);

INSERT INTO Realiza VALUES (4,4,true,6.5);
INSERT INTO Realiza VALUES (5,4,true,8.1);
INSERT INTO Realiza VALUES (6,4,false,0);

INSERT INTO Realiza VALUES (5,5,true,7.4);
INSERT INTO Realiza VALUES (6,5,true,9.2);
INSERT INTO Realiza VALUES (7,5,false,0);

INSERT INTO Realiza VALUES (6,6,true,8.0);
INSERT INTO Realiza VALUES (7,6,true,6.9);
INSERT INTO Realiza VALUES (8,6,false,0);

INSERT INTO Realiza VALUES (7,7,true,7.7);
INSERT INTO Realiza VALUES (8,7,true,8.6);
INSERT INTO Realiza VALUES (9,7,false,0);

INSERT INTO Realiza VALUES (8,8,true,9.1);
INSERT INTO Realiza VALUES (9,8,true,7.2);
INSERT INTO Realiza VALUES (10,8,false,0);

INSERT INTO Realiza VALUES (9,9,true,6.6);
INSERT INTO Realiza VALUES (10,9,true,8.4);
INSERT INTO Realiza VALUES (11,9,false,0);

INSERT INTO Realiza VALUES (10,10,true,8.9);
INSERT INTO Realiza VALUES (11,10,true,7.5);
INSERT INTO Realiza VALUES (12,10,false,0);

INSERT INTO Realiza VALUES (11,11,true,7.8);
INSERT INTO Realiza VALUES (12,11,true,6.7);
INSERT INTO Realiza VALUES (13,11,false,0);

INSERT INTO Realiza VALUES (12,12,true,8.3);
INSERT INTO Realiza VALUES (13,12,true,7.1);
INSERT INTO Realiza VALUES (14,12,false,0);

INSERT INTO Realiza VALUES (13,13,true,9.0);
INSERT INTO Realiza VALUES (14,13,true,8.2);
INSERT INTO Realiza VALUES (15,13,false,0);

INSERT INTO Realiza VALUES (14,14,true,6.9);
INSERT INTO Realiza VALUES (15,14,true,7.6);
INSERT INTO Realiza VALUES (1,14,false,0);

INSERT INTO Realiza VALUES (15,15,true,8.7);
INSERT INTO Realiza VALUES (1,15,true,7.4);
INSERT INTO Realiza VALUES (2,15,false,0);

-- ALUMNOS 16–30
INSERT INTO Realiza VALUES (1,16,true,8.1);
INSERT INTO Realiza VALUES (2,16,true,6.8);
INSERT INTO Realiza VALUES (3,16,false,0);

INSERT INTO Realiza VALUES (2,17,true,7.3);
INSERT INTO Realiza VALUES (3,17,true,8.5);
INSERT INTO Realiza VALUES (4,17,false,0);

INSERT INTO Realiza VALUES (3,18,true,9.4);
INSERT INTO Realiza VALUES (4,18,true,7.6);
INSERT INTO Realiza VALUES (5,18,false,0);

INSERT INTO Realiza VALUES (4,19,true,6.7);
INSERT INTO Realiza VALUES (5,19,true,8.9);
INSERT INTO Realiza VALUES (6,19,false,0);

INSERT INTO Realiza VALUES (5,20,true,7.2);
INSERT INTO Realiza VALUES (6,20,true,9.0);
INSERT INTO Realiza VALUES (7,20,false,0);

INSERT INTO Realiza VALUES (6,21,true,8.4);
INSERT INTO Realiza VALUES (7,21,true,6.5);
INSERT INTO Realiza VALUES (8,21,false,0);

INSERT INTO Realiza VALUES (7,22,true,7.9);
INSERT INTO Realiza VALUES (8,22,true,8.3);
INSERT INTO Realiza VALUES (9,22,false,0);

INSERT INTO Realiza VALUES (8,23,true,9.2);
INSERT INTO Realiza VALUES (9,23,true,7.0);
INSERT INTO Realiza VALUES (10,23,false,0);

INSERT INTO Realiza VALUES (9,24,true,6.4);
INSERT INTO Realiza VALUES (10,24,true,8.6);
INSERT INTO Realiza VALUES (11,24,false,0);

INSERT INTO Realiza VALUES (10,25,true,8.8);
INSERT INTO Realiza VALUES (11,25,true,7.7);
INSERT INTO Realiza VALUES (12,25,false,0);

INSERT INTO Realiza VALUES (11,26,true,7.5);
INSERT INTO Realiza VALUES (12,26,true,6.9);
INSERT INTO Realiza VALUES (13,26,false,0);

INSERT INTO Realiza VALUES (12,27,true,8.0);
INSERT INTO Realiza VALUES (13,27,true,7.2);
INSERT INTO Realiza VALUES (14,27,false,0);

INSERT INTO Realiza VALUES (13,28,true,9.3);
INSERT INTO Realiza VALUES (14,28,true,8.4);
INSERT INTO Realiza VALUES (15,28,false,0);

INSERT INTO Realiza VALUES (14,29,true,6.8);
INSERT INTO Realiza VALUES (15,29,true,7.9);
INSERT INTO Realiza VALUES (1,29,false,0);

INSERT INTO Realiza VALUES (15,30,true,8.6);
INSERT INTO Realiza VALUES (1,30,true,7.3);
INSERT INTO Realiza VALUES (2,30,false,0);

-- Alumno 31: Alvaro Hernandez
INSERT INTO Realiza VALUES (1,31,true,8.5);
INSERT INTO Realiza VALUES (2,31,true,7.0);
INSERT INTO Realiza VALUES (3,31,true,9.0);

-- Alumno 32: Beatriz Lopez (no ha entregado nada)
INSERT INTO Realiza VALUES (4,32,false,0);
INSERT INTO Realiza VALUES (5,32,false,0);
INSERT INTO Realiza VALUES (6,32,false,0);

-- Alumno 33: Carlos Molina (1 no entregada)
INSERT INTO Realiza VALUES (7,33,true,9.1);
INSERT INTO Realiza VALUES (8,33,false,0);
INSERT INTO Realiza VALUES (9,33,true,6.7);

-- Alumno 34: Daniela Santos (2 no entregadas)
INSERT INTO Realiza VALUES (10,34,false,0);
INSERT INTO Realiza VALUES (11,34,true,7.5);
INSERT INTO Realiza VALUES (12,34,false,0);

-- Alumno 35: Esteban Garcia
INSERT INTO Realiza VALUES (13,35,true,7.9);
INSERT INTO Realiza VALUES (14,35,true,8.4);
INSERT INTO Realiza VALUES (15,35,true,6.9);

-- Alumno 36: Fátima Navarro (1 no entregada)
INSERT INTO Realiza VALUES (1,36,true,8.2);
INSERT INTO Realiza VALUES (2,36,false,0);
INSERT INTO Realiza VALUES (3,36,true,9.0);

-- Alumno 37: Gabriel Ruiz
INSERT INTO Realiza VALUES (4,37,true,7.3);
INSERT INTO Realiza VALUES (5,37,true,8.7);
INSERT INTO Realiza VALUES (6,37,true,6.8);

-- Alumno 38: Helena Torres (2 no entregadas)
INSERT INTO Realiza VALUES (7,38,false,0);
INSERT INTO Realiza VALUES (8,38,true,8.0);
INSERT INTO Realiza VALUES (9,38,false,0);

-- Alumno 39: Ignacio Perez (no ha entregado nada)
INSERT INTO Realiza VALUES (10,39,false,0);
INSERT INTO Realiza VALUES (11,39,false,0);
INSERT INTO Realiza VALUES (12,39,false,0);

-- Alumno 40: Julia Vega
INSERT INTO Realiza VALUES (13,40,true,6.5);
INSERT INTO Realiza VALUES (14,40,true,8.3);
INSERT INTO Realiza VALUES (15,40,true,7.7);