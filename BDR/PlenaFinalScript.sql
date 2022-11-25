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
	ginecologia bool not null,
	nutricion bool not null,
	psicologia bool not null,
	sexologia bool not null,
	sueño bool not null
);
create sequence especialidad_id_especialidad_seq start 1 increment 1;
alter table especialidad alter column id_especialidad set default nextval('especialidad_id_especialidad_seq');

--Pregunta
create table pregunta(
	id_pregunta numeric(7,0) constraint pk_pregunta primary key,
	id_especialidad numeric(7,0) references especialidad (id_especialidad),
	texto_pregunta varchar(200) not null,
	tipo_respuesta bool not null
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
	contacto varchar(25) not null
);
create sequence paciente_id_paciente_seq start 1 increment 1;
alter table paciente alter column id_paciente set default nextval('paciente_id_paciente_seq');

--Catalogo_respuesta
create table catalogo_respuesta(
	id_catalogo_respuesta numeric(7,0) constraint pk_catalogo_respuesta primary key,
	id_paciente numeric(7,0) references paciente (id_paciente),
	id_pregunta numeric(7,0) references pregunta (id_pregunta),
	respuesta varchar(50) not null
);
create sequence catalogo_respuesta_id_catalogo_respuesta_seq start 1 increment 1;
alter table catalogo_respuesta alter column id_catalogo_respuesta set default nextval('catalogo_respuesta_id_catalogo_respuesta_seq');

--Respuestas_abiertas
create table expediente_abiertas(
	id_expediente_abiertas numeric(7,0) constraint pk_respuestas_abiertas primary key,
	id_paciente numeric(7,0) references paciente (id_paciente),
	id_pregunta numeric(7,0) references pregunta (id_pregunta),
	respuesta_boolean bool,
	respuesta_numeric numeric(4,2), --*
	respuesta_date date,
	respuesta_varchar varchar(200),
	fecha date not null
);
create sequence expediente_abiertas_id_expediente_abiertas_seq start 1 increment 1;
alter table expediente_abiertas alter column id_expediente_abiertas set default nextval('expediente_abiertas_id_expediente_abiertas_seq');

--Respuestas_catalogo
create table expediente_catalogo(
	id_expediente_catalogo numeric(7,0) constraint pk_respuestas_catalogos primary key,
	id_paciente numeric(7,0) references paciente (id_paciente),
	id_pregunta numeric(7,0) references pregunta (id_pregunta),
	id_catalogo_respuesta numeric(7,0) references catalogo_respuesta (id_catalogo_respuesta),
	fecha date not null
);
create sequence expediente_catalogo_id_expediente_catalogo_seq start 1 increment 1;
alter table expediente_catalogo alter column id_expediente_catalogo set default nextval('expediente_catalogo_id_expediente_catalogo_seq');

--Doctora
create table doctora(
	id_doctora numeric(7,0) constraint pk_doctora primary key,
	id_especialidad numeric(7,0) references especialidad (id_especialidad),
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
--create sequence paciente_doctora_id_paciente_doctora_seq start 1 increment 1;
--alter table paciente_doctora alter column id_paciente_doctora set default nextval('paciente_doctora_id_paciente_doctora_seq');

--Diagnostico_plan
create table diagnostico_plan(
	id_diagnostico_plan numeric(7,0) constraint pk_diagnostico_plan primary key,
	id_paciente numeric(7,0) references paciente (id_paciente),
	id_doctora numeric(7,0) references doctora (id_doctora),
	plan_seguimiento varchar(480) not null,
	diagnostico varchar(50) not null,
	fecha date not null
);
create sequence diagnostico_plan_id_diagnostico_plan_seq start 1 increment 1;
alter table diagnostico_plan alter column id_diagnostico_plan set default nextval('diagnostico_plan_id_diagnostico_plan_seq');

--PACIENTES INSERTADOS
insert into paciente
(nombres, primer_apellido, segundo_apellido, fecha_nacimiento, genero, sexo, contacto)
values
	('Juana','Martínez','López','1992-07-16','Mujer','Femenino','5522853756'),  --va a ginecologia 
	('Ángeles','Ramírez','González','1973-09-02','Mujer','Femenino','2836047809'), --va a nutricion 
	('Mónica','Lovato','Loma','1976-02-23','Mujer','Femenino','7446982465'), --va a psicologia 
	('Lorena Antonieta','Fernández','Mota','1987-10-28','Mujer','Femenino','6569875432'), --va a sexologia 
	('Mariana','Quiroz','García','1990-10-10','Mujer','Femenino','5539872342'), --va a sueño
	('Fernanda','Marín','Rubio','1995-03-22','Mujer Transgénero','Masculino','9874563211'), --va a ginecologia 
	('Michelle','Gamboa','Peña','2000-09-07','Mujer Transgénero','Masculino','9517896782'), --va a nutricion 
	('Denisse','Robles','Moreno','1983-05-19','Mujer Transgénero','Masculino','7762394222'), --va a psicologia 
	('Marcela','Montero','Castilla','2001-07-07','Mujer Transgénero','Masculino','6234289365'), --va a sexologia 
	('Suiza','García','Rivera','1978-11-30','Mujer Transgénero','Masculino','5873459872'), --va a sueño 
	('Roberto','Torres','Medina','1989-12-05','Hombre Transgénero','Femenino','8976545672'), --va a ginecologia 
	('André','Ramírez','Landero','1994-01-11','Hombre Transgénero','Femenino','7658769872'), --va a nutricion 
	('Marco','Mendieta','Durán','1997-04-26','Hombre Transgénero','Femenino','4568762349'), --va a psicologia 
	('Jesús','Félix','Cuevas','1974-09-09','Hombre Transgénero','Femenino','2938467293'), --va a sexologia 
	('Álvaro','Acebedo','Barbosa','1962-07-28','Hombre Transgénero','Femenino','2334568879'), --va a sueño 
	('Emilia','Trinidad','Zepeda','1998-06-30','Hombre','Femenino','8932346785'),  --va a ginecologia 
	('Alejandro','López','Aguirre','1988-08-31','Hombre','Femenino','9823406785'), --va a nutricion 
	('Sebastián','Alcántara','Medina','1963-02-28','Hombre','Femenino','2395048832'), --va a psicologia
	('Esteban','Quiroz','García','1958-12-24','Hombre','Femenino','2934567799'), --va a sexologia 
	('Ángel','Mejía','González','1991-12-23','Hombre','Femenino','9876541234'), --va a sueño
	('Natalia','Martínez','Espinoza','1955-11-12','Mujer','Intersexual','8975678231'), --va a ginecologia 
	('Luz María','Mendoza','Enrriquez','1969-12-14','Mujer','Intersexual','7655678899'), --va a nutricion 
	('Namibia','León','Ugalde','1999-01-12','Mujer','Intersexual','3456780987'), --va a psicologia 
	('Natalia','Santiago','Zamora','1993-03-10','Mujer','Intersexual','6374843433'), --va a sexologia 
	('Irene','Méndez','Muñoz','2002-06-18','Mujer','Intersexual','7464738393'), --va a sueño
	('Estefanía','León','Sosa','1994-10-19','Género no binario','Femenino','4324567387'), --va a ginecologia 
	('Ana Paola','Campos','Zazueta','2003-12-12','Género no binario','Femenino','7652345567'), --va a nutricion 
	('Medea','Guerra','Duarte','2000-01-01','Género no binario','Femenino','9946631234'), --va a psicologia 
	('María Fernanda','Guerrero','Luna','1999-12-31','Género no binario','Femenino','7655666791'), --va a sexologia 
	('Rosa','Saldívar','Lerma','1980-03-15','Género no binario','Femenino','4211237655'), --va a sueño 
	('Erik','Sánchez','Cordero','2002-08-06','Hombre','Intersexual','5678468499'), --va a ginecologia 
	('Penelope','Cerda','Robles','1997-03-22','Hombre','Intersexual','6792453801'), --va a nutricion 
	('Alma Marcela','Silva','Alegría','1987-09-13','Hombre','Intersexual','7854368734'), --va a psicologia 
	('Antonio','Casamadrid','Vivanco','1992-10-10','Hombre','Intersexual','5678876523'), --va a sexologia 
	('Benito','Juárez','Díaz','1965-01-29','Hombre','Intersexual','789856764598'); --va a sueño
	
--ADMINISTRADORES INSERTADOS
insert into administrador
(acceso,contraseña)
values
	('Diana Muñoz','Diana196914'),
	('Adaya Escobar','Adaya198054'),
	('Ruben Robles','Ruben195666'),
	('Mariel Zapien','Mariel195525');

--ESPECIALIDADES INSERTADAS 
insert into especialidad 
(ginecologia,nutricion,psicologia,sexologia,sueño)
values 
	(true,false,false,false,false), --ginecologia id = 1
	(false,true,false,false,false), --nutrición id = 2
	(false,false,true,false,false), --psicologia id = 3
	(false,false,false,true,false), --sexologia id = 4
	(false,false,false,false,true); --sueño id = 5
	
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
	(5, 'Renata', 'Vázquez', 'Escobar', 72679548, 'password', 'renatavasquez');

--PREGUNTAS INSERTADAS 
insert into pregunta 
(id_especialidad,texto_pregunta,tipo_respuesta)
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

insert into paciente_doctora
(id_doctora,id_paciente)
values 
	--ginecología--
	--(1,1),
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

