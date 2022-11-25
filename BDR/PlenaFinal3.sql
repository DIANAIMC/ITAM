--NOTAS: 
--	*ID de 7 carácteres
--	*ginecologia id = 1, nutrición id = 2, psicologia id = 3, sexologia id = 4, sueño id = 5
--	*tipo_respuesta : true=respuestas_catalogo, false=respuestas_abiertas 
--	*preguntas_catalogo : ginecologia id = 4, nutricion id = 10

--Administrador
create table administrador(
	id_administrador numeric(7,0) constraint pk_administrador primary key,
	acceso varchar(15) not null,
	contraseña varchar(15) not null
);
create sequence administrador_id_administrador_seq start 1 increment 1;
alter table administrador alter column id_administrador set default nextval('administrador_id_administrador_seq'); 

--Especialidad
create table especialidad(
	id_especialidad numeric(7,0) constraint pk_especialidad primary key,
	nombre_especialidad varchar(50) not null
);

create sequence especialidad_id_especialidad_seq start 1 increment 1;
alter table especialidad alter column id_especialidad set default nextval('especialidad_id_especialidad_seq');

--Pregunta
create table pregunta(
	id_pregunta numeric(7,0) constraint pk_pregunta primary key,
	id_especialidad numeric(7,0) references especialidad (id_especialidad) not null,
	texto_pregunta varchar(200) not null,
	tipo_catalogo bool not null
);

create sequence pregunta_id_pregunta_seq start 1 increment 1;
alter table pregunta alter column id_pregunta set default nextval('pregunta_id_pregunta_seq');

--Paciente
create type genero_enum as enum ('Mujer','Hombre','Mujer Transgénero','Hombre Transgénero','Género no binario');
create type sexo_enum as enum ('Femenino','Masculino','Intersexual');

create table paciente(
	id_paciente numeric(7,0) constraint pk_paciente primary key,
	nombres varchar(25) not null,
	primer_apellido varchar(20) not null,
	segundo_apellido varchar(20) not null,
	fecha_nacimiento date not null,
	genero genero_enum not null,
	sexo sexo_enum not null,
	contacto varchar(25) not null,
	estado bool not null
);
create sequence paciente_id_paciente_seq start 1 increment 1;
alter table paciente alter column id_paciente set default nextval('paciente_id_paciente_seq');

--Catalogo_respuesta
create table catalogo_respuesta(
	id_catalogo_respuesta numeric(7,0) constraint pk_catalogo_respuesta primary key,
	id_pregunta numeric(7,0) references pregunta (id_pregunta) not null,
	respuesta varchar(50) not null
);
create sequence catalogo_respuesta_id_catalogo_respuesta_seq start 1 increment 1;
alter table catalogo_respuesta alter column id_catalogo_respuesta set default nextval('catalogo_respuesta_id_catalogo_respuesta_seq');

--Respuestas_abiertas
create table expediente_abiertas(
	id_expediente_abiertas numeric(7,0) constraint pk_respuestas_abiertas primary key,
	id_paciente numeric(7,0) references paciente (id_paciente) not null,
	id_pregunta numeric(7,0) references pregunta (id_pregunta) not null,
	respuesta_boolean bool,
	respuesta_numeric numeric(4,2),
	respuesta_date date,
	respuesta_varchar varchar(200),
	fecha date not null
);
create sequence expediente_abiertas_id_expediente_abiertas_seq start 1 increment 1;
alter table expediente_abiertas alter column id_expediente_abiertas set default nextval('expediente_abiertas_id_expediente_abiertas_seq');

--Respuestas_catalogo
create table expediente_catalogo(
	id_expediente_catalogo numeric(7,0) constraint pk_respuestas_catalogos primary key,
	id_paciente numeric(7,0) references paciente (id_paciente) not null,
	id_pregunta numeric(7,0) references pregunta (id_pregunta) not null,
	id_catalogo_respuesta numeric(7,0) references catalogo_respuesta (id_catalogo_respuesta),
	fecha date not null
);
create sequence expediente_catalogo_id_expediente_catalogo_seq start 1 increment 1;
alter table expediente_catalogo alter column id_expediente_catalogo set default nextval('expediente_catalogo_id_expediente_catalogo_seq');

--Doctora
create table doctora(
	id_doctora numeric(7,0) constraint pk_doctora primary key,
	id_especialidad numeric(7,0) references especialidad (id_especialidad) not null,
	nombres varchar(25) not null,
	primer_apellido varchar(20) not null,
	segundo_apellido varchar(20) not null,
	cedula numeric(11,0) not null,
	contraseña varchar(15) not null,
	acceso varchar(15) not null
);
create sequence doctora_id_doctora_seq start 1 increment 1;
alter table doctora alter column id_doctora set default nextval('doctora_id_doctora_seq');

--Paciente_doctora
create table paciente_doctora(
	id_paciente numeric (7,0) references paciente (id_paciente) on update cascade,
	id_doctora numeric (7,0) references doctora (id_doctora) on update cascade,
	primary key (id_paciente,id_doctora)
);

--Diagnostico_plan
create table diagnostico_plan(
	id_diagnostico_plan numeric(7,0) constraint pk_diagnostico_plan primary key,
	id_paciente numeric(7,0) references paciente (id_paciente) not null,
	id_doctora numeric(7,0) references doctora (id_doctora) not null,
	plan_seguimiento varchar(480) not null,
	diagnostico varchar(200) not null,
	fecha date not null
);
create sequence diagnostico_plan_id_diagnostico_plan_seq start 1 increment 1;
alter table diagnostico_plan alter column id_diagnostico_plan set default nextval('diagnostico_plan_id_diagnostico_plan_seq');

--PACIENTES INSERTADOS
insert into paciente
(nombres, primer_apellido, segundo_apellido, fecha_nacimiento, genero, sexo, contacto,estado)
values
	('Juana','Martínez','López','1992-07-16','Mujer','Femenino','5522853756',true),  --va a ginecologia 
	('Ángeles','Ramírez','González','1973-09-02','Mujer','Femenino','2836047809',true), --va a nutricion 
	('Mónica','Lovato','Loma','1976-02-23','Mujer','Femenino','7446982465',true), --va a psicologia 
	('Lorena Antonieta','Fernández','Mota','1987-10-28','Mujer','Femenino','6569875432',true), --va a sexologia 
	('Mariana','Quiroz','García','1990-10-10','Mujer','Femenino','5539872342',true), --va a sueño
	('Fernanda','Marín','Rubio','1995-03-22','Mujer Transgénero','Masculino','9874563211',true), --va a ginecologia 
	('Michelle','Gamboa','Peña','2000-09-07','Mujer Transgénero','Masculino','9517896782',true), --va a nutricion 
	('Denisse','Robles','Moreno','1983-05-19','Mujer Transgénero','Masculino','7762394222',true), --va a psicologia 
	('Marcela','Montero','Castilla','2001-07-07','Mujer Transgénero','Masculino','6234289365',true), --va a sexologia 
	('Suiza','García','Rivera','1978-11-30','Mujer Transgénero','Masculino','5873459872',true), --va a sueño 
	('Roberto','Torres','Medina','1989-12-05','Hombre Transgénero','Femenino','8976545672',true), --va a ginecologia 
	('André','Ramírez','Landero','1994-01-11','Hombre Transgénero','Femenino','7658769872',true), --va a nutricion 
	('Marco','Mendieta','Durán','1997-04-26','Hombre Transgénero','Femenino','4568762349',true), --va a psicologia 
	('Jesús','Félix','Cuevas','1974-09-09','Hombre Transgénero','Femenino','2938467293',true), --va a sexologia 
	('Álvaro','Acebedo','Barbosa','1962-07-28','Hombre Transgénero','Femenino','2334568879',true), --va a sueño 
	('Emilia','Trinidad','Zepeda','1998-06-30','Hombre','Femenino','8932346785',true),  --va a ginecologia 
	('Alejandro','López','Aguirre','1988-08-31','Hombre','Femenino','9823406785',true), --va a nutricion 
	('Sebastián','Alcántara','Medina','1963-02-28','Hombre','Femenino','2395048832',true), --va a psicologia
	('Esteban','Quiroz','García','1958-12-24','Hombre','Femenino','2934567799',true), --va a sexologia 
	('Ángel','Mejía','González','1991-12-23','Hombre','Femenino','9876541234',true), --va a sueño
	('Natalia','Martínez','Espinoza','1955-11-12','Mujer','Intersexual','8975678231',true), --va a ginecologia 
	('Luz María','Mendoza','Enrriquez','1969-12-14','Mujer','Intersexual','7655678899',true), --va a nutricion 
	('Namibia','León','Ugalde','1999-01-12','Mujer','Intersexual','3456780987',true), --va a psicologia 
	('Natalia','Santiago','Zamora','1993-03-10','Mujer','Intersexual','6374843433',true), --va a sexologia 
	('Irene','Méndez','Muñoz','2002-06-18','Mujer','Intersexual','7464738393',true), --va a sueño
	('Estefanía','León','Sosa','1994-10-19','Género no binario','Femenino','4324567387',true), --va a ginecologia 
	('Ana Paola','Campos','Zazueta','2003-12-12','Género no binario','Femenino','7652345567',true), --va a nutricion 
	('Medea','Guerra','Duarte','2000-01-01','Género no binario','Femenino','9946631234',true), --va a psicologia 
	('María Fernanda','Guerrero','Luna','1999-12-31','Género no binario','Femenino','7655666791',true), --va a sexologia 
	('Rosa','Saldívar','Lerma','1980-03-15','Género no binario','Femenino','4211237655',true), --va a sueño 
	('Erik','Sánchez','Cordero','2002-08-06','Hombre','Intersexual','5678468499',true), --va a ginecologia 
	('Penelope','Cerda','Robles','1997-03-22','Hombre','Intersexual','6792453801',true), --va a nutricion 
	('Alma Marcela','Silva','Alegría','1987-09-13','Hombre','Intersexual','7854368734',true), --va a psicologia 
	('Antonio','Casamadrid','Vivanco','1992-10-10','Hombre','Intersexual','5678876523',true), --va a sexologia 
	('Benito','Juárez','Díaz','1965-01-29','Hombre','Intersexual','789856764598',true); --va a sueño
--delete from paciente;
	
--ADMINISTRADORES INSERTADOS
insert into administrador
(acceso,contraseña)
values
	('Diana Muñoz','Diana196914'),
	('Adaya Escobar','Adaya198054'),
	('Ruben Robles','Ruben195666'),
	('Mariel Zapien','Mariel195525');
--delete from administrador ;

--ESPECIALIDADES INSERTADAS 
insert into especialidad 
(nombre_especialidad)
values 
	('ginecología'), --ginecologia id = 1
	('nutrición'), --nutrición id = 2
	('psicología'), --psicologia id = 3
	('sexología'), --sexologia id = 4
	('sueño'), --sueño id = 5
	('general'); --general id = 6
--delete from especialidad;
	
--DOCTORAS INSERTADAS
insert into doctora
(id_especialidad, nombres, primer_apellido, segundo_apellido, cedula, contraseña, acceso)
values
--ginecologas: 1
	(1, 'Ana María', 'Orozco', 'Osabe', 02948021, 'q536ee3g', 'anamariaorozco'),
	(1, 'Marcela', 'Valencia', 'Fernández', 10537777, 'ZWM2bfmU', 'marcelavalencia'),	
	(1, 'Estefanía', 'Gómez', 'Pena', 67508359, 'kZBxqa4S', 'estefaniagomez'),
	(1, 'Rosa', 'Milano', 'Huerto', 95859499, 'edNtL5Ff', 'rosamilano'),
	(1, 'Julia', 'Solano', 'Cadavid', 49807177, 'wXkUYYS9', 'juliasolano'),
--nutricion: 2
	(2, 'Dora', 'Cadavid', 'Pineda', 65067206, 'HvTuSLYs', 'doracadavid'),
	(2, 'Alisson', 'León', 'Munoz', 75002491, 'VL8ebMjE', 'alissonleon'),	
	(2, 'Aura', 'Fuentes', 'Rico', 40857722, 'UEDcHGC2', 'aurafuentes'),
	(2, 'Frida', 'Kaori', 'Stewart', 73776128, 'TGYE4C99', 'fridakaori'),
	(2, 'Adriana', 'Franco', 'Martinez', 85083049, 'y2xmpEaQ', 'adrianafranco'),
--psicologia:3
	(3, 'Patricia', 'Pérez', 'López', 89993827, 'cnhjR5MK', 'patriciaperez'),
	(3, 'Ana Paulina', 'Robles', 'Arroyo', 92615660, 'ANqsJtvx', 'anapaurobles'),	
	(3, 'Ximena', 'Esearte', 'Díaz', 77117801, 'PxRAwnN5', 'ximenaesearte'),
	(3, 'Camila', 'Bosch', 'Cornu', 84270505, 'hBPCp3wL', 'camilabosch'),
	(3, 'Liliana', 'Giral', 'Navarrete', 06366464, '7nxHae9W', 'lilianagiral'),
--sexologia:4
	(4, 'Inés', 'Ramírez', 'Muriel', 21970232, 'YGywykV8', 'inesramirez'),
	(4, 'María', 'Gómez', 'Torres', 84898897, 'ZTup4qtZ', 'mariagomez'),	
	(4, 'Rafaela', 'Hyakuya', 'Ichinose', 64155304, 'XKuNcYWy', 'rafaelahyakuya'),
	(4, 'Nuria', 'Cifuentes', 'Esponda', 64155304, 'qzvjk9CD', 'nuriacifuentes'),
	(4, 'Valeria', 'Gómez', 'Darlington', 35341796, 'wWRSNEsj', 'valeriagomez'),
--sueño:5
	(5, 'Mariana', 'Monreal', 'Escobar', 70097888, '9LCACrYA', 'marianamonreal'),
	(5, 'Paola', 'Padrón', 'Escobar', 39920482, 'qzvjk9CD', 'paolapadron'),	
	(5, 'Ana Lisa', 'Martínez', 'Escobar', 31570606, 'eMH6abzg', 'analisamartinez'),
	(5, 'Clio', 'Dulong', 'Escobar', 31570606, 'C\VC&r=5M)', 'cliodulong'),
	(5, 'Renata', 'Vázquez', 'Escobar', 72679548, 'password', 'renatavasquez'),
--general:6
	(6,'María Fernanda','Hernández','Gómez',5529660573,'rewqasdrf','mariafernanda');
--delete from doctora ;

--PREGUNTAS INSERTADAS 
insert into pregunta 
(id_especialidad,texto_pregunta,tipo_catalogo)
values 
	(1,'Fecha de la primera menstruación',false), --id = 1
	(1,'Fecha de la última menstruación',false), --id = 2
	(1,'¿A qué edad inició tu vida sexual?',false), --id = 3
	(1,'¿Qué método o métodos anticonceptivo usa?',true), --id = 4
	(2,'Peso',false), -- id = 5
	(2,'Talla',false), -- id = 6
	(2,'¿Cuántos litros de agua toma al día?',false), -- id = 7
	(2,'¿Hace ejercicio?',false), --8
	(2,'¿Cuántos días a la semana realiza actividad física/ejercicio?',false), -- id = 9
	(2,'¿Qué tipo o tipos de ejercicio hace?',true), --id = 10
	(3,'¿Cuáles son sus preocupaciones?',false), -- id = 11
	(3,'¿Desde cuándo siente esto?',false), -- id = 12
	(3,'¿Cuándo terminas de trabajar se siente agotado emocionalmente?',false), -- id = 13
	(3,'¿Considera que esto afecta su vida?',false), -- id = 14
	(4,'¿Presenta dificultades para llegar al orgasmo?',false), -- id = 15
	(4,'¿Cada cuando presenta dificultades para llegar al orgasmo?',false), -- id = 16
	(4,'¿Está conforme con su vida sexual?',false), -- id = 17
	(4,'¿Se siente segura y satisfecha con su sexualidad?',false), -- id = 18
	(5,'¿Cuántas horas duerme por la noche?',false), -- id = 19
	(5,'¿Ronca?',false), -- id = 20
	(5,'¿Se levanta por la noche?',false), -- id = 21
	(5,'¿Tiene pesadillas?',false); -- id = 22
--delete from pregunta;
	
--CATALOGO_RESPUESTA INSERTADAS 
insert into catalogo_respuesta 
(id_pregunta,respuesta)
values 
	(4,'Condón'), -- id = 1
	(4,'Mirena'), -- id = 2
	(4,'Kyleena'), -- id = 3
	(4,'DIU de cobre'), -- id = 4
	(4,'DIU de plata'), -- id = 5
	(4,'Implante subdérmico'), -- id = 6
	(4,'Anticonceptivos orales combinados'), -- id = 7
	(4,'Anillo vaginal'), -- id = 8
	(4,'Parche'), -- id = 9
	(4,'Inyección'), -- id = 10
	(4,'Ciclo natural'), -- id = 11
	(4,'Espermicidas'), -- id = 12
	(4,'Coitus Interruptus'), -- id = 13
	(4,'Ligación o corte de trompas uterinas'), -- id = 14
	(4,'Vasectomía'), -- id = 15
	(4,'Ninguno'), -- id = 16
	(10,'Caminar'), -- id = 17
	(10,'Elíptica'), -- id = 18
	(10,'Bicicleta estática'), -- id = 19
	(10,'Pesas o ejercicios de fuerza'), -- id = 20
	(10,'Yoga'), -- id = 21
	(10,'Actividades al aire libre'), -- id = 22
	(10,'Otros'); -- id = 23
--delete from catalogo_respuesta;

--EXPEDIENTE_ABIERTAS BOOL INSERTADAS
--'¿Hace ejercicio?'-- id = 8, nutrición 
--'¿Considera que esto afecta su vida?'-- id = 14, psicologia 
--'¿Presenta dificultades para llegar al orgasmo?'-- id = 15, sexologia 
--'¿Está conforme con su vida sexual?'-- id = 17, sexologia 
--'¿Se siente segura y satisfecha con su sexualidad?'-- id = 18, sexologia 
--'¿Ronca?'--id = 20, sueño
--'¿Se levanta por la noche?'--id = 21, sueño 
--'¿Tiene pesadillas?'--id = 22, sueño 
insert into expediente_abiertas 
(id_paciente,id_pregunta,respuesta_boolean,fecha)
values 
	--'Ángeles','Ramírez' id = 2 nutrición 
	(2,8,true,'2022-05-30'), -- id = 1
	--'Mónica','Lovato' id = 3 psicologia 
	(3,14,false,'2022-05-30'), -- id = 2
	--'Lorena Antonieta' id = 4 sexologia 
	(4,15,true,'2022-05-30'), -- id = 3
	(4,17,false,'2022-05-30'), -- id = 4
	(4,18,false,'2022-05-30'), -- id = 5
	--'Mariana','Quiroz' id = 5 sueño
	(5,20,false,'2022-05-30'), -- id = 6
	(5,21,true,'2022-05-30'), -- id = 7
	(5,22,false,'2022-05-30'), -- id = 8
	--'Michelle','Gamboa' id = 7 nutrición 
	(7,8,true,'2022-05-30'), -- id = 9
	--'Denisse','Robles' id = 8 psicologia
	(8,14,true,'2022-05-30'), -- id = 10
	--'Marcela','Montero' id = 9 sexologia 
	(9,15,true,'2022-05-30'), -- id = 11
	(9,17,true,'2022-05-30'), -- id = 12
	(9,18,true,'2022-05-30'), -- id = 13
	--'Suiza','García' id = 10 sueño 
	(10,20,false,'2022-05-30'), -- id = 14
	(10,21,false,'2022-05-30'), -- id = 15
	(10,22,false,'2022-05-30'), -- id = 16
	--'André','Ramírez' id = 12 nutrición 
	(12,8,true,'2022-05-30'), -- id = 17
	--'Marco','Mendieta' id = 13 psicologia 
	(13,14,true,'2022-05-30'), -- id = 18
	--'Jesús','Félix' id = 14 sexologia
	(14,15,true,'2022-05-30'), -- id = 19
	(14,17,true,'2022-05-30'), -- id = 20
	(14,18,true,'2022-05-30'), -- id = 21
	--'Álvaro','Acebedo' id = 15 sueño
	(15,20,false,'2022-05-30'), -- id = 22
	(15,21,false,'2022-05-30'), -- id = 23
	(15,22,false,'2022-05-30'); -- id = 24
	
--EXPEDIENTE_ABIERTAS DATE INSERTADAS
--(1,'Fecha de la última menstruación',false), --id = 2
insert into expediente_abiertas 
(id_paciente,id_pregunta,respuesta_date,fecha)
values 
	--'Juana','Martinez' id = 1 ginecologia 
	(1,2,'2022-05-12','2022-05-30'), -- id = 25
	--'Fernanda','Marín' id = 6 ginecologia 
	(6,2,null,'2022-05-30'), -- id = 26
	--'Roberto','Torres' id = 11 ginecologia 
	(11,2,'2022-04-30','2022-05-30'); -- id = 27

--EXPEDIENTE_ABIERTAS NUMERIC INSERTADAS
--'¿A qué edad inició tu vida sexual?' --id = 3 ginecologia 
--'Peso' -- id = 5 nutrición 
--'Talla' -- id = 6 nutrición 
--'¿Cuántos litros de agua toma al día?' -- id = 7 nutrición 
--'¿Cuántos días a la semana realiza actividad física/ejercicio?' -- id = 9 nutrición 
--'¿Cuántas horas duerme por la noche?' -- id = 19 sueño
insert into expediente_abiertas 
(id_paciente,id_pregunta,respuesta_numeric,fecha)
values 
	--'Juana','Martinez' id = 1 ginecologia 
	(1,3,18,'2022-05-30'), --id = 28
	--'Ángeles','Ramírez' id = 2 nutrición 
	(2,5,55,'2022-05-30'), --id = 29
	(2,6,1.60,'2022-05-30'), --id = 30
	(2,7,1.50,'2022-05-30'), --id = 31
	(2,9,3.00,'2022-05-30'), --id = 32 
	--'Mariana','Quiroz' id = 5 sueño
	(5,19,6,'2022-05-30'), --id = 33
	--'Fernanda','Marín' id = 6 ginecologia
	(6,3,17,'2022-05-30'), --id = 34
	--'Michelle','Gamboa' id = 7 nutrición 
	(7,5,78,'2022-05-30'), --id = 35
	(7,6,1.62,'2022-05-30'), --id = 36
	(7,7,1,'2022-05-30'), --id = 37
	(7,9,0,'2022-05-30'), --id = 38
	--'Suiza','García' id = 10 sueño 
	(10,19,9,'2022-05-30'), --id = 39
	--'Roberto','Torres' id = 11 ginecologia 
	(11,3,13,'2022-05-30'), --id = 40
	--'André','Ramírez' id = 12 nutrición 
	(12,5,1.80,'2022-05-30'), --id = 41
	(12,6,80,'2022-05-30'), --id = 42
	(12,7,2,'2022-05-30'), --id = 43
	(12,9,5,'2022-05-30'), --id = 44
	--'Álvaro','Acebedo' id = 15 sueño
	(15,19,8,'2022-05-30'); --id = 45

--EXPEDIENTE_ABIERTAS VARCHAR INSERTADAS
insert into expediente_abiertas 
(id_paciente,id_pregunta,respuesta_varchar,fecha)
values 
	--'Juana','Martinez' id = 1 ginecologia
	(1,1,'Antes de los 12 años','2022-05-30'), -- id = 46
	--'Mónica','Lovato' id = 3 psicologia
	(3,11,'Perder mi trabajo','2022-05-30'),  -- id = 47
	(3,12,'Hace 2 semanas','2022-05-30'), -- id = 48
	(3,13,'Frecuentemente','2022-05-30'), -- id = 49
	--'Lorena Antonieta' id = 4 sexologia 
	(4,16,'Otro','2022-05-30'), -- id = 50
	--'Mariana','Quiroz' id = 5 sueño
	(5,21,'Pocas veces','2022-05-30'), -- id = 51
	--'Fernanda','Marín' id = 6 ginecologia
	(6,1,'Después de los 14 años','2022-05-30'),  -- id = 52
	--'Denisse','Robles' id = 8 psicologia 
	(8,11,'No salir de la universidad','2022-05-30'),  -- id = 53
	(8,12,'Hace más de un mes','2022-05-30'), -- id = 54
	(8,13,'Siempre','2022-05-30'),  -- id = 55
	--'Marcela','Montero' id = 9 sexologia 
	(9,16,'En determinada circunstancia','2022-05-30'),  -- id = 56
	--'Suiza','García' id = 10 sueño 
	(10,21,'Siempre','2022-05-30'),  -- id = 57
	--'Roberto','Torres' id = 11 ginecologia 
	(11,1,'De los 10 años a los 14 años','2022-05-30'),  -- id = 58
	--'Marco','Mendieta' id = 13 psicologia 
	(13,11,'Que un profe me humille','2022-05-30'),  -- id = 59
	(13,12,'Hace más de dos semanas','2022-05-30'), -- id = 60
	(13,13,'Frecuentemente','2022-05-30'), -- id = 61
	--'Jesús','Félix' id = 14 sexologia
	(14,16,'Siempre','2022-05-30'), -- id = 62
	--'Álvaro','Acebedo' id = 15 sueño
	(15,21,'Nunca','2022-05-30'); -- id = 63
--delete from expediente_abiertas;
	
--EXPEDIENTE_CATALOGO INSERTADAS
--4, '¿Qué método o métodos anticonceptivo usa?'
--10, '¿Qué tipo o tipos de ejercicio hace?'
insert into expediente_catalogo --4,10
(id_paciente,id_pregunta,id_catalogo_respuesta,fecha)
values 
	--'Juana','Martinez' id = 1 ginecologia
	(1,4,1,'2022-05-30'), -- id = 1
	(1,4,4,'2022-05-30'), -- id = 2
	--'Ángeles','Ramírez' id = 2 nutrición 
	(2,10,17,'2022-05-30'), -- id = 3
	(2,10,18,'2022-05-30'), -- id = 4
	(2,10,19,'2022-05-30'), -- id = 5
	--'Fernanda','Marín' id = 6 ginecologia --trans mujer
	(6,4,1,'2022-05-30'), -- id = 6
	(6,4,15,'2022-05-30'), -- id = 7
	--'Michelle','Gamboa' id = 7 nutrición --trans mujer 
	(7,10,19,'2022-05-30'), -- id = 8
	(7,10,20,'2022-05-30'), -- id = 9
	(7,10,21,'2022-05-30'), -- id = 10
	--'Roberto','Torres' id = 11 ginecologia --trans hombre
	(11,4,1,'2022-05-30'), -- id = 11
	--'André','Ramírez' id = 12 nutrición --trans hombre
	(12,10,22,'2022-05-30'); -- id = 12
--delete from expediente_catalogo;
	
--RELACIONES PACIENTE_DOCTORA INSERTADOS
insert into paciente_doctora
(id_doctora,id_paciente)
values 
	--ginecología--
	(1,1),
	--id_doctora=1, id_paciente=1
	--Ana María Orozco con Juana Martínez
	(2,6),
	--id_doctora=2, id_paciente=6
	--Marcela Valencia con Fernanda Marín
	(3,11),
	--id_doctora=3, id_paciente=11
	--Estefania Gomez con Roberto Torres
	(4,16),
	--id_doctora=4, id_paciente=16
	--Rosa Milano con Emilia Trinidad
	(5,21),
	--id_doctora=5, id_paciente=21
	--Julia Solano con Natalia Martínez
	(1,26),
	--id_doctora=1, id_paciente=26
	--Ana María Orozco con Estefanía León
	(2,31),
	--id_doctora=2, id_paciente 31
	--Marcela Valencia con Erik Sánchez
	
	--nutricion--
	(6,2),
	--id_doctora=6, id_paciente=2
	--Dora Cadavid con Ángeles Ramírez
	(7,7),
	--id_doctora=7, id_paciente=7
	--Alisson Leon con Michelle Gamboa
	(8,12),
	--id_doctora=8, id_paciente=12
	--Aura fuentes con André Ramirez
	(9,17),
	--id_doctora=9, id_paciente=17
	--Frida Kaori con Alejandro López
	(10,22),
	--id_doctora=10, id_paciente=22
	--Adriana Franco con Luz María Martínez
	(6,27),
	--id_doctora=6, id_paciente=27
	--Dora Cadavid con Ana Paola Campos
	(7,32),
	--id_doctora=7, id_paciente=32
	--Alisson Leon con Penélope Cerda 
	
	--psicología--
	(11,3),
	--id_doctora=11, id_paciente=3
	--Patricia Pérez con Mónica lovato
	(12,8),
	--id_doctora=12, id_paciente=8
	--Ana Paulina Robles con Denisse Robles
	(13,13),
	--id_doctora=13, id_paciente=13
	--Ximena Esearte con Marco Mendieta
	(14,18),
	--id_doctora=14, id_paciente=18
	--Camila Bosch con Sebastián Alcántara
	(15,23),
	--id_doctora=15, id_paciente=23
	--Liliana Giral con Namibia León
	(11,28),
	--id_doctora=11, id_paciente=28
	--Patricia Pérez con Medea Guerra
	(12,33),
	--id_doctora=12, id_paciente=33
	--Ana Paulina Robles con Alma Marcela Silva
	
	--sexología--
	(16,4),
	--id_doctora=16 , id_paciente=4
	--Ines Ramirez con Lorena Antonieta Fernández
	(17,9),
	--id_doctora=17, id_paciente=9
	--Maria Gomez con Marcela Montero
	(18,14),
	--id_doctora=18, id_paciente=14
	--Rafaela Hyakuya con Jesús Félix
	(19,19),
	--id_doctora=19, id_paciente=19
	--Nuria Cifuentes con Esteban Quiroz
	(20,24),
	--id_doctora=20, id_paciente=24
	--Valeria Gomez con Natalia Santiago
	(16,29),
	--id_doctora=16, id_paciente=29
	--Ines Ramírez con María Fernanda Guerrero
	(17,34),
	--id_doctora=17, id_paciente=34
	--Maria Gomez con Antonio Casamadrid
	
	--sueño--
	(21,5),
	--id_doctora=21 , id_paciente=5
	--Mariana Monreal con Mariana Quiroz
	(22,10),
	--id_doctora=22, id_paciente=10
	--Paola Padrón con Suiza García
	(23,15),
	--id_doctora=23, id_paciente=15
	--Ana Lisa Martínez con Álvaro Acebedo
	(24,20),
	--id_doctora=24, id_paciente=20
	--Clio Dulong con Ángel Mejía
	(25,25),
	--id_doctora=25, id_paciente=25
	--Renata Vazques con Irene Méndez
	(21,30),
	--id_doctora=21, id_paciente=30
	--Mariana Monreal con Rosa Saldivar
	(22,35);
	--id_doctora=22, id_paciente=35
	--Paola Padrón con Benito Juárez
--delete from paciente_doctora;

--DIAGNOSTICO_PLAN INSERTADAS
insert into diagnostico_plan
(id_paciente, id_doctora, plan_seguimiento, diagnostico, fecha)
values
--la fecha de todos es el 30 de mayo de 2022 (aaaa-mm-dd)
	--paciente 1, doctora 1, especialidad ginecología 1)
	(1,1, 'esperar a los resultados de los estudios', 'posible ovario poliquístico', '2022-05-30'),
	--paciente 2, doctora 6, especialidad nutrición 2)
	(2,6,'se confirma en la próxima cita en 2 semanas', 'hipertiroidismo', '2022-05-30'),
	--paciente 3, doctora 11, especialidad psicología 3)
	(3,11, 'se harán pruebas de narcisismo la próxima semana', 'sospecha de narcisismo', '2022-05-30'),
	--paciente 4, doctora 16, especialidad sexología 4)
	(4,16, 'confirmaremos papiloma con exámenes en la siguiente cita', 'sospecha de papiloma', '2022-05-30'),
	--paciente 5, doctora 21, especialidad sueño 5)
	(5,21, 'veremos con estudios qué pasa el estimular su cerebro mientras duerme', 'paciente sonámbulo', '2022-05-30'),
	--paciente 6, doctora 2, especialidad ginecología 6)
	(6, 2, 'se notaron quistes en el ultrasonido en el ovario derecho', 'quiste en ovario izquierdo', '2022-05-30'),
	--paciente 7, doctora 7, especialidad nutrición 7)
	(7,7, 'la mayor preocupación es la falta de hierro', 'anemia', '2022-05-30'),
	--paciente 8, doctora 12, especialidad psicología 8)
	(8,12, 'lo más importante a tratar es la tristeza constante', 'depresión', '2022-05-30'),
	--paciente 9, doctora 17, especialidad sexología 9)
	(9,17, 'lo preocupante es la ausencia de orgasmos','insensibilidad', '2022-05-30'),
	--paciente 10, doctora 22, especialidad sueño 10)
	(10,22, 'la paciente presenta cansancio extremo durante el día','somnolencia constante', '2022-05-30'),
	--paciente 11, doctora 3, especialidad ginecología 11)
	(11,3, 'la paciente reporta náuseas matutinas y ausencia de menstruación','posible embarazo','2022-05-30'),
	--paciente 12, doctora 8, especialidad nutrición 12)
	(12,8,'la paciente reporta sed extrema y cansancio', 'posible diabetes','2022-05-30'),
	--paciente 13, doctora 13, especialidad psicología 13)
	(13,13, 'sus preocupaciones dan a relucir un apego ansioso a la pareja', 'dependencia emocional','2022-05-30'),
	--paciente 14, doctora 18, especialidad sexología 14)
	(14,18, 'la paciente se siente insatisfecha con su vida sexual', 'insatisfacción sexual','2022-05-30'),
	--paciente 15, doctora 23, especialidad sueño 15)
	(15,23, 'la paciente presenta pesadillas frecuentes', 'pesadillas constantes','2022-05-30');
--delete from diagnostico_plan;

--Queries:
--Administrador
--	Insertar nueva especialidad
--	Insertar nueva pregunta
--	Si es de catálogo que inserte las nuevas respuestas posibles.
--	Actualizar el estado de las pacientes
--	Ingresar un nuevo paciente
--	Ingresar una nueva doctora
--	Editar la información de X paciente.
--	Editar la información de X doctora.
--Doctora general
--	Asignar una doctora a un paciente.
--	Cambiar la doctora de un paciente.
--	Mostrar a todos los pacientes que atiende X doctora.
select p.nombres  || ' ' || p.primer_apellido || ' ' || p.segundo_apellido pacientes
from doctora d join paciente_doctora pd using (id_doctora)
join paciente p using (id_paciente)
group by d.id_doctora, p.id_paciente 
having d.nombres = 'Ana María' and d.primer_apellido = 'Orozco'
order by 1 asc;

--	Mostrar a todas las doctoras que atienden a X paciente.
select d.nombres  || ' ' || d.primer_apellido || ' ' || d.segundo_apellido doctoras,
e.nombre_especialidad especialidad
from especialidad e join doctora d using (id_especialidad)
join paciente_doctora pd using (id_doctora)
join paciente p using (id_paciente)
group by e.nombre_especialidad, d.id_doctora, p.id_paciente 
having p.nombres = 'Juana' and p.primer_apellido = 'Martínez'
order by 1 asc;

--Doctoras especialidad
--	Agregar un diagnóstico a X paciente.
--	Actualizar las respuestas de X paciente de su especialidad.
--Comparten general y de especialidad (para que los vea la de especialidad TIENE que ser su doctora)

--	Mostrar la información personal de X paciente.
select p.nombres  || ' ' || p.primer_apellido || ' ' || p.segundo_apellido nombres,
p.fecha_nacimiento, p.genero, p.sexo, p.contacto, p.estado
from paciente p
where p.nombres = 'Juana' and p.primer_apellido = 'Martínez';

--	Ver todos los diagnósticos de X paciente por X especialidad. También filtrar por intervalo de tiempo.
select p.nombres || ' ' || p.primer_apellido || ' ' || p.segundo_apellido as paciente, dp.diagnostico 
as diagnostico, dp.plan_seguimiento as plan, e.id_especialidad as especialidad, dp.fecha as fecha
from especialidad e join doctora d using (id_especialidad)
join paciente_doctora pd using (id_doctora)
join paciente p using (id_paciente) join diagnostico_plan dp using (id_paciente) 
where p.nombres = 'Juana' and p.primer_apellido = 'Martínez'
order by 1 asc;

--	Ver el último diagnóstico de X paciente por X especialidad.
select p.nombres || ' ' || p.primer_apellido || ' ' || p.segundo_apellido as paciente, dp.diagnostico 
as diagnostico, dp.plan_seguimiento as plan, e.id_especialidad as especialidad, max(dp.fecha) as fecha
from especialidad e join doctora d using (id_especialidad)
join paciente_doctora pd using (id_doctora)
join paciente p using (id_paciente) join diagnostico_plan dp using (id_paciente)
group by paciente, diagnostico, plan, especialidad, fecha
order by 1 asc;

--	Mostrar el expediente (sus respuestas) de X paciente por X especialidad. También filtrar por intervalo de tiempo.
select 
p.texto_pregunta pregunta, CAST ( ea.respuesta_boolean AS varchar(10))  as respuesta, ea.fecha as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join expediente_abiertas ea using (id_pregunta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ea.respuesta_boolean is not null
and ea.fecha = '2022-05-30'
UNION--numeric
select 
p.texto_pregunta pregunta, CAST ( ea.respuesta_numeric AS varchar(10))  as respuesta, ea.fecha as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join expediente_abiertas ea using (id_pregunta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ea.respuesta_numeric is not null
and ea.fecha = '2022-05-30'
UNION--varchar 
select 
p.texto_pregunta pregunta, ea.respuesta_varchar respuesta, ea.fecha as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join expediente_abiertas ea using (id_pregunta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ea.respuesta_varchar is not null
and ea.fecha = '2022-05-30'
UNION--date
select 
p.texto_pregunta pregunta, CAST ( ea.respuesta_date AS varchar(10))  as respuesta, ea.fecha as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join expediente_abiertas ea using (id_pregunta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ea.respuesta_date is not null
and ea.fecha = '2022-05-30'
UNION--catalogo
select
p.texto_pregunta pregunta, STRING_AGG(cr.respuesta, ', ') as respuesta, ec.fecha fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join catalogo_respuesta cr using (id_pregunta)
join expediente_catalogo ec using (id_catalogo_respuesta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ec.id_catalogo_respuesta is not null
and ec.fecha = '2022-05-30'
GROUP BY  pregunta, fecha_registro 
order by 1 asc;

--	Mostrar la última actualización del expediente de X paciente por X especialidad. 
select
p.texto_pregunta pregunta, CAST ( ea.respuesta_boolean AS varchar(10))  as respuesta, max(ea.fecha) as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join expediente_abiertas ea using (id_pregunta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ea.respuesta_boolean is not null
group by pregunta, respuesta, fecha
UNION--numeric
select 
p.texto_pregunta pregunta, CAST ( ea.respuesta_numeric AS varchar(10))  as respuesta, max(ea.fecha) as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join expediente_abiertas ea using (id_pregunta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ea.respuesta_numeric is not null
group by pregunta, respuesta, fecha
UNION--varchar 
select 
p.texto_pregunta pregunta, ea.respuesta_varchar respuesta, max(ea.fecha) as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join expediente_abiertas ea using (id_pregunta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ea.respuesta_varchar is not null
group by pregunta, respuesta, fecha
UNION--date
select 
p.texto_pregunta pregunta, CAST ( ea.respuesta_date AS varchar(10))  as respuesta, max(ea.fecha) as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join expediente_abiertas ea using (id_pregunta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ea.respuesta_date is not null
group by pregunta, respuesta, fecha
UNION--catalogo
select 
p.texto_pregunta pregunta, STRING_AGG(cr.respuesta, ', ') as respuesta, max(ec.fecha) as fecha_registro
from especialidad e join pregunta p using (id_especialidad)
join catalogo_respuesta cr using (id_pregunta)
join expediente_catalogo ec using (id_catalogo_respuesta)
join paciente pa using (id_paciente)
where e.nombre_especialidad = 'nutrición' and pa.nombres = 'Ángeles' and ec.id_catalogo_respuesta is not null
group by pregunta, fecha
order by 1 asc;




