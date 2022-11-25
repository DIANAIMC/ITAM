--NOTAS: 
--	*ID de 7 car�cteres
--	*ginecologia id = 1, nutrici�n id = 2, psicologia id = 3, sexologia id = 4, sue�o id = 5
--	*tipo_respuesta : true=respuestas_catalogo, false=respuestas_abiertas 
--	*preguntas_catalogo : ginecologia id = 4, nutricion id = 10

--Administrador
create table administrador(
	id_administrador numeric(7,0) constraint pk_administrador primary key,
	acceso varchar(15) not null,
	contrase�a varchar(15) not null
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
	sue�o bool not null
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
create type genero_enum as enum ('Mujer','Hombre','Mujer Transg�nero','Hombre Transg�nero','G�nero no binario');
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
	contrase�a varchar(15) not null,
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
	('Juana','Mart�nez','L�pez','1992-07-16','Mujer','Femenino','5522853756'),  --va a ginecologia 
	('�ngeles','Ram�rez','Gonz�lez','1973-09-02','Mujer','Femenino','2836047809'), --va a nutricion 
	('M�nica','Lovato','Loma','1976-02-23','Mujer','Femenino','7446982465'), --va a psicologia 
	('Lorena Antonieta','Fern�ndez','Mota','1987-10-28','Mujer','Femenino','6569875432'), --va a sexologia 
	('Mariana','Quiroz','Garc�a','1990-10-10','Mujer','Femenino','5539872342'), --va a sue�o
	('Fernanda','Mar�n','Rubio','1995-03-22','Mujer Transg�nero','Masculino','9874563211'), --va a ginecologia 
	('Michelle','Gamboa','Pe�a','2000-09-07','Mujer Transg�nero','Masculino','9517896782'), --va a nutricion 
	('Denisse','Robles','Moreno','1983-05-19','Mujer Transg�nero','Masculino','7762394222'), --va a psicologia 
	('Marcela','Montero','Castilla','2001-07-07','Mujer Transg�nero','Masculino','6234289365'), --va a sexologia 
	('Suiza','Garc�a','Rivera','1978-11-30','Mujer Transg�nero','Masculino','5873459872'), --va a sue�o 
	('Roberto','Torres','Medina','1989-12-05','Hombre Transg�nero','Femenino','8976545672'), --va a ginecologia 
	('Andr�','Ram�rez','Landero','1994-01-11','Hombre Transg�nero','Femenino','7658769872'), --va a nutricion 
	('Marco','Mendieta','Dur�n','1997-04-26','Hombre Transg�nero','Femenino','4568762349'), --va a psicologia 
	('Jes�s','F�lix','Cuevas','1974-09-09','Hombre Transg�nero','Femenino','2938467293'), --va a sexologia 
	('�lvaro','Acebedo','Barbosa','1962-07-28','Hombre Transg�nero','Femenino','2334568879'), --va a sue�o 
	('Emilia','Trinidad','Zepeda','1998-06-30','Hombre','Femenino','8932346785'),  --va a ginecologia 
	('Alejandro','L�pez','Aguirre','1988-08-31','Hombre','Femenino','9823406785'), --va a nutricion 
	('Sebasti�n','Alc�ntara','Medina','1963-02-28','Hombre','Femenino','2395048832'), --va a psicologia
	('Esteban','Quiroz','Garc�a','1958-12-24','Hombre','Femenino','2934567799'), --va a sexologia 
	('�ngel','Mej�a','Gonz�lez','1991-12-23','Hombre','Femenino','9876541234'), --va a sue�o
	('Natalia','Mart�nez','Espinoza','1955-11-12','Mujer','Intersexual','8975678231'), --va a ginecologia 
	('Luz Mar�a','Mendoza','Enrriquez','1969-12-14','Mujer','Intersexual','7655678899'), --va a nutricion 
	('Namibia','Le�n','Ugalde','1999-01-12','Mujer','Intersexual','3456780987'), --va a psicologia 
	('Natalia','Santiago','Zamora','1993-03-10','Mujer','Intersexual','6374843433'), --va a sexologia 
	('Irene','M�ndez','Mu�oz','2002-06-18','Mujer','Intersexual','7464738393'), --va a sue�o
	('Estefan�a','Le�n','Sosa','1994-10-19','G�nero no binario','Femenino','4324567387'), --va a ginecologia 
	('Ana Paola','Campos','Zazueta','2003-12-12','G�nero no binario','Femenino','7652345567'), --va a nutricion 
	('Medea','Guerra','Duarte','2000-01-01','G�nero no binario','Femenino','9946631234'), --va a psicologia 
	('Mar�a Fernanda','Guerrero','Luna','1999-12-31','G�nero no binario','Femenino','7655666791'), --va a sexologia 
	('Rosa','Sald�var','Lerma','1980-03-15','G�nero no binario','Femenino','4211237655'), --va a sue�o 
	('Erik','S�nchez','Cordero','2002-08-06','Hombre','Intersexual','5678468499'), --va a ginecologia 
	('Penelope','Cerda','Robles','1997-03-22','Hombre','Intersexual','6792453801'), --va a nutricion 
	('Alma Marcela','Silva','Alegr�a','1987-09-13','Hombre','Intersexual','7854368734'), --va a psicologia 
	('Antonio','Casamadrid','Vivanco','1992-10-10','Hombre','Intersexual','5678876523'), --va a sexologia 
	('Benito','Ju�rez','D�az','1965-01-29','Hombre','Intersexual','789856764598'); --va a sue�o
	
--ADMINISTRADORES INSERTADOS
insert into administrador
(acceso,contrase�a)
values
	('Diana Mu�oz','Diana196914'),
	('Adaya Escobar','Adaya198054'),
	('Ruben Robles','Ruben195666'),
	('Mariel Zapien','Mariel195525');

--ESPECIALIDADES INSERTADAS 
insert into especialidad 
(ginecologia,nutricion,psicologia,sexologia,sue�o)
values 
	(true,false,false,false,false), --ginecologia id = 1
	(false,true,false,false,false), --nutrici�n id = 2
	(false,false,true,false,false), --psicologia id = 3
	(false,false,false,true,false), --sexologia id = 4
	(false,false,false,false,true); --sue�o id = 5
	
--DOCTORAS INSERTADAS
insert into doctora
(id_especialidad, nombres, primer_apellido, segundo_apellido, cedula, contrase�a, acceso)
values
--ginecologas: 1
	(1, 'Ana Mar�a', 'Orozco', 'Osabe', 02948021, 'q536ee3g', 'anamariaorozco'),
	(1, 'Marcela', 'Valencia', 'Fern�ndez', 10537777, 'ZWM2bfmU', 'marcelavalencia'),	
	(1, 'Estefan�a', 'G�mez', 'Pena', 67508359, 'kZBxqa4S', 'estefaniagomez'),
	(1, 'Rosa', 'Milano', 'Huerto', 95859499, 'edNtL5Ff', 'rosamilano'),
	(1, 'Julia', 'Solano', 'Cadavid', 49807177, 'wXkUYYS9', 'juliasolano'),
--nutricion: 2
	(2, 'Dora', 'Cadavid', 'Pineda', 65067206, 'HvTuSLYs', 'doracadavid'),
	(2, 'Alisson', 'Le�n', 'Munoz', 75002491, 'VL8ebMjE', 'alissonleon'),	
	(2, 'Aura', 'Fuentes', 'Rico', 40857722, 'UEDcHGC2', 'aurafuentes'),
	(2, 'Frida', 'Kaori', 'Stewart', 73776128, 'TGYE4C99', 'fridakaori'),
	(2, 'Adriana', 'Franco', 'Martinez', 85083049, 'y2xmpEaQ', 'adrianafranco'),
--psicologia:3
	(3, 'Patricia', 'P�rez', 'L�pez', 89993827, 'cnhjR5MK', 'patriciaperez'),
	(3, 'Ana Paulina', 'Robles', 'Arroyo', 92615660, 'ANqsJtvx', 'anapaurobles'),	
	(3, 'Ximena', 'Esearte', 'D�az', 77117801, 'PxRAwnN5', 'ximenaesearte'),
	(3, 'Camila', 'Bosch', 'Cornu', 84270505, 'hBPCp3wL', 'camilabosch'),
	(3, 'Liliana', 'Giral', 'Navarrete', 06366464, '7nxHae9W', 'lilianagiral'),
--sexologia:4
	(4, 'In�s', 'Ram�rez', 'Muriel', 21970232, 'YGywykV8', 'inesramirez'),
	(4, 'Mar�a', 'G�mez', 'Torres', 84898897, 'ZTup4qtZ', 'mariagomez'),	
	(4, 'Rafaela', 'Hyakuya', 'Ichinose', 64155304, 'XKuNcYWy', 'rafaelahyakuya'),
	(4, 'Nuria', 'Cifuentes', 'Esponda', 64155304, 'qzvjk9CD', 'nuriacifuentes'),
	(4, 'Valeria', 'G�mez', 'Darlington', 35341796, 'wWRSNEsj', 'valeriagomez'),
--sue�o:5
	(5, 'Mariana', 'Monreal', 'Escobar', 70097888, '9LCACrYA', 'marianamonreal'),
	(5, 'Paola', 'Padr�n', 'Escobar', 39920482, 'qzvjk9CD', 'paolapadron'),	
	(5, 'Ana Lisa', 'Mart�nez', 'Escobar', 31570606, 'eMH6abzg', 'analisamartinez'),
	(5, 'Clio', 'Dulong', 'Escobar', 31570606, 'C\VC&r=5M)', 'cliodulong'),
	(5, 'Renata', 'V�zquez', 'Escobar', 72679548, 'password', 'renatavasquez');

--PREGUNTAS INSERTADAS 
insert into pregunta 
(id_especialidad,texto_pregunta,tipo_respuesta)
values 
	(1,'Fecha de la primera menstruaci�n',false), --id = 1
	(1,'Fecha de la �ltima menstruaci�n',false), --id = 2
	(1,'�A qu� edad inici� tu vida sexual?',false), --id = 3
	(1,'�Qu� m�todo o m�todos anticonceptivo usa?',true), --id = 4
	(2,'Peso',false), -- id = 5
	(2,'Talla',false), -- id = 6
	(2,'�Cu�ntos litros de agua toma al d�a?',false), -- id = 7
	(2,'�Hace ejercicio?',false), --8
	(2,'�Cu�ntos d�as a la semana realiza actividad f�sica/ejercicio?',false), -- id = 9
	(2,'�Qu� tipo o tipos de ejercicio hace?',true), --id = 10
	(3,'�Cu�les son sus preocupaciones?',false), -- id = 11
	(3,'�Desde cu�ndo siente esto?',false), -- id = 12
	(3,'�Cu�ndo terminas de trabajar se siente agotado emocionalmente?',false), -- id = 13
	(3,'�Considera que esto afecta su vida?',false), -- id = 14
	(4,'�Presenta dificultades para llegar al orgasmo?',false), -- id = 15
	(4,'�Cada cuando presenta dificultades para llegar al orgasmo?',false), -- id = 16
	(4,'�Est� conforme con su vida sexual?',false), -- id = 17
	(4,'�Se siente segura y satisfecha con su sexualidad?',false), -- id = 18
	(5,'�Cu�ntas horas duerme por la noche?',false), -- id = 19
	(5,'�Ronca?',false), -- id = 20
	(5,'�Se levanta por la noche?',false), -- id = 21
	(5,'�Tiene pesadillas?',false); -- id = 22

--CATALOGO_RESPUESTA INSERTADAS 
insert into catalogo_respuesta 
(id_pregunta,respuesta)
values 
	(4,'Cond�n'), -- id = 1
	(4,'Mirena'), -- id = 2
	(4,'Kyleena'), -- id = 3
	(4,'DIU de cobre'), -- id = 4
	(4,'DIU de plata'), -- id = 5
	(4,'Implante subd�rmico'), -- id = 6
	(4,'Anticonceptivos orales combinados'), -- id = 7
	(4,'Anillo vaginal'), -- id = 8
	(4,'Parche'), -- id = 9
	(4,'Inyecci�n'), -- id = 10
	(4,'Ciclo natural'), -- id = 11
	(4,'Espermicidas'), -- id = 12
	(4,'Coitus Interruptus'), -- id = 13
	(4,'Ligaci�n o corte de trompas uterinas'), -- id = 14
	(4,'Vasectom�a'), -- id = 15
	(4,'Ninguno'), -- id = 16
	(10,'Caminar'), -- id = 17
	(10,'El�ptica'), -- id = 18
	(10,'Bicicleta est�tica'), -- id = 19
	(10,'Pesas o ejercicios de fuerza'), -- id = 20
	(10,'Yoga'), -- id = 21
	(10,'Actividades al aire libre'), -- id = 22
	(10,'Otros'); -- id = 23
	
--EXPEDIENTE_ABIERTAS BOOL INSERTADAS
--'�Hace ejercicio?'-- id = 8, nutrici�n 
--'�Considera que esto afecta su vida?'-- id = 14, psicologia 
--'�Presenta dificultades para llegar al orgasmo?'-- id = 15, sexologia 
--'�Est� conforme con su vida sexual?'-- id = 17, sexologia 
--'�Se siente segura y satisfecha con su sexualidad?'-- id = 18, sexologia 
--'�Ronca?'--id = 20, sue�o
--'�Se levanta por la noche?'--id = 21, sue�o 
--'�Tiene pesadillas?'--id = 22, sue�o 
insert into expediente_abiertas 
(id_paciente,id_pregunta,respuesta_boolean,fecha)
values 
	--'�ngeles','Ram�rez' id = 2 nutrici�n 
	(2,8,true,'2022-05-30'), -- id = 1
	--'M�nica','Lovato' id = 3 psicologia 
	(3,14,false,'2022-05-30'), -- id = 2
	--'Lorena Antonieta' id = 4 sexologia 
	(4,15,true,'2022-05-30'), -- id = 3
	(4,17,false,'2022-05-30'), -- id = 4
	(4,18,false,'2022-05-30'), -- id = 5
	--'Mariana','Quiroz' id = 5 sue�o
	(5,20,false,'2022-05-30'), -- id = 6
	(5,21,true,'2022-05-30'), -- id = 7
	(5,22,false,'2022-05-30'), -- id = 8
	--'Michelle','Gamboa' id = 7 nutrici�n 
	(7,8,true,'2022-05-30'), -- id = 9
	--'Denisse','Robles' id = 8 psicologia
	(8,14,true,'2022-05-30'), -- id = 10
	--'Marcela','Montero' id = 9 sexologia 
	(9,15,true,'2022-05-30'), -- id = 11
	(9,17,true,'2022-05-30'), -- id = 12
	(9,18,true,'2022-05-30'), -- id = 13
	--'Suiza','Garc�a' id = 10 sue�o 
	(10,20,false,'2022-05-30'), -- id = 14
	(10,21,false,'2022-05-30'), -- id = 15
	(10,22,false,'2022-05-30'), -- id = 16
	--'Andr�','Ram�rez' id = 12 nutrici�n 
	(12,8,true,'2022-05-30'), -- id = 17
	--'Marco','Mendieta' id = 13 psicologia 
	(13,14,true,'2022-05-30'), -- id = 18
	--'Jes�s','F�lix' id = 14 sexologia
	(14,15,true,'2022-05-30'), -- id = 19
	(14,17,true,'2022-05-30'), -- id = 20
	(14,18,true,'2022-05-30'), -- id = 21
	--'�lvaro','Acebedo' id = 15 sue�o
	(15,20,false,'2022-05-30'), -- id = 22
	(15,21,false,'2022-05-30'), -- id = 23
	(15,22,false,'2022-05-30'); -- id = 24
	
--EXPEDIENTE_ABIERTAS DATE INSERTADAS
--(1,'Fecha de la �ltima menstruaci�n',false), --id = 2
insert into expediente_abiertas 
(id_paciente,id_pregunta,respuesta_date,fecha)
values 
	--'Juana','Martinez' id = 1 ginecologia 
	(1,2,'2022-05-12','2022-05-30'), -- id = 25
	--'Fernanda','Mar�n' id = 6 ginecologia 
	(6,2,null,'2022-05-30'), -- id = 26
	--'Roberto','Torres' id = 11 ginecologia 
	(11,2,'2022-04-30','2022-05-30'); -- id = 27

--EXPEDIENTE_ABIERTAS NUMERIC INSERTADAS
--'�A qu� edad inici� tu vida sexual?' --id = 3 ginecologia 
--'Peso' -- id = 5 nutrici�n 
--'Talla' -- id = 6 nutrici�n 
--'�Cu�ntos litros de agua toma al d�a?' -- id = 7 nutrici�n 
--'�Cu�ntos d�as a la semana realiza actividad f�sica/ejercicio?' -- id = 9 nutrici�n 
--'�Cu�ntas horas duerme por la noche?' -- id = 19 sue�o
insert into expediente_abiertas 
(id_paciente,id_pregunta,respuesta_numeric,fecha)
values 
	--'Juana','Martinez' id = 1 ginecologia 
	(1,3,18,'2022-05-30'), --id = 28
	--'�ngeles','Ram�rez' id = 2 nutrici�n 
	(2,5,55,'2022-05-30'), --id = 29
	(2,6,1.60,'2022-05-30'), --id = 30
	(2,7,1.50,'2022-05-30'), --id = 31
	(2,9,3.00,'2022-05-30'), --id = 32 
	--'Mariana','Quiroz' id = 5 sue�o
	(5,19,6,'2022-05-30'), --id = 33
	--'Fernanda','Mar�n' id = 6 ginecologia
	(6,3,17,'2022-05-30'), --id = 34
	--'Michelle','Gamboa' id = 7 nutrici�n 
	(7,5,78,'2022-05-30'), --id = 35
	(7,6,1.62,'2022-05-30'), --id = 36
	(7,7,1,'2022-05-30'), --id = 37
	(7,9,0,'2022-05-30'), --id = 38
	--'Suiza','Garc�a' id = 10 sue�o 
	(10,19,9,'2022-05-30'), --id = 39
	--'Roberto','Torres' id = 11 ginecologia 
	(11,3,13,'2022-05-30'), --id = 40
	--'Andr�','Ram�rez' id = 12 nutrici�n 
	(12,5,1.80,'2022-05-30'), --id = 41
	(12,6,80,'2022-05-30'), --id = 42
	(12,7,2,'2022-05-30'), --id = 43
	(12,9,5,'2022-05-30'), --id = 44
	--'�lvaro','Acebedo' id = 15 sue�o
	(15,19,8,'2022-05-30'); --id = 45

--EXPEDIENTE_ABIERTAS VARCHAR INSERTADAS
insert into expediente_abiertas 
(id_paciente,id_pregunta,respuesta_varchar,fecha)
values 
	--'Juana','Martinez' id = 1 ginecologia
	(1,1,'Antes de los 12 a�os','2022-05-30'), -- id = 46
	--'M�nica','Lovato' id = 3 psicologia
	(3,11,'Perder mi trabajo','2022-05-30'),  -- id = 47
	(3,12,'Hace 2 semanas','2022-05-30'), -- id = 48
	(3,13,'Frecuentemente','2022-05-30'), -- id = 49
	--'Lorena Antonieta' id = 4 sexologia 
	(4,16,'Otro','2022-05-30'), -- id = 50
	--'Mariana','Quiroz' id = 5 sue�o
	(5,21,'Pocas veces','2022-05-30'), -- id = 51
	--'Fernanda','Mar�n' id = 6 ginecologia
	(6,1,'Despu�s de los 14 a�os','2022-05-30'),  -- id = 52
	--'Denisse','Robles' id = 8 psicologia 
	(8,11,'No salir de la universidad','2022-05-30'),  -- id = 53
	(8,12,'Hace m�s de un mes','2022-05-30'), -- id = 54
	(8,13,'Siempre','2022-05-30'),  -- id = 55
	--'Marcela','Montero' id = 9 sexologia 
	(9,16,'En determinada circunstancia','2022-05-30'),  -- id = 56
	--'Suiza','Garc�a' id = 10 sue�o 
	(10,21,'Siempre','2022-05-30'),  -- id = 57
	--'Roberto','Torres' id = 11 ginecologia 
	(11,1,'De los 10 a�os a los 14 a�os','2022-05-30'),  -- id = 58
	--'Marco','Mendieta' id = 13 psicologia 
	(13,11,'Que un profe me humille','2022-05-30'),  -- id = 59
	(13,12,'Hace m�s de dos semanas','2022-05-30'), -- id = 60
	(13,13,'Frecuentemente','2022-05-30'), -- id = 61
	--'Jes�s','F�lix' id = 14 sexologia
	(14,16,'Siempre','2022-05-30'), -- id = 62
	--'�lvaro','Acebedo' id = 15 sue�o
	(15,21,'Nunca','2022-05-30'); -- id = 63

--EXPEDIENTE_CATALOGO INSERTADAS
--4, '�Qu� m�todo o m�todos anticonceptivo usa?'
--10, '�Qu� tipo o tipos de ejercicio hace?'
insert into expediente_catalogo --4,10
(id_paciente,id_pregunta,id_catalogo_respuesta,fecha)
values 
	--'Juana','Martinez' id = 1 ginecologia
	(1,4,1,'2022-05-30'), -- id = 1
	(1,4,4,'2022-05-30'), -- id = 2
	--'�ngeles','Ram�rez' id = 2 nutrici�n 
	(2,10,17,'2022-05-30'), -- id = 3
	(2,10,18,'2022-05-30'), -- id = 4
	(2,10,19,'2022-05-30'), -- id = 5
	--'Fernanda','Mar�n' id = 6 ginecologia --trans mujer
	(6,4,1,'2022-05-30'), -- id = 6
	(6,4,15,'2022-05-30'), -- id = 7
	--'Michelle','Gamboa' id = 7 nutrici�n --trans mujer 
	(7,10,19,'2022-05-30'), -- id = 8
	(7,10,20,'2022-05-30'), -- id = 9
	(7,10,21,'2022-05-30'), -- id = 10
	--'Roberto','Torres' id = 11 ginecologia --trans hombre
	(11,4,1,'2022-05-30'), -- id = 11
	--'Andr�','Ram�rez' id = 12 nutrici�n --trans hombre
	(12,10,22,'2022-05-30'); -- id = 12

insert into paciente_doctora
(id_doctora,id_paciente)
values 
	--ginecolog�a--
	--(1,1),
	--id_doctora=1, id_paciente=1
	--Ana Mar�a Orozco con Juana Mart�nez
	(2,6),
	--id_doctora=2, id_paciente=6
	--Marcela Valencia con Fernanda Mar�n
	(3,11),
	--id_doctora=3, id_paciente=11
	--Estefania Gomez con Roberto Torres
	(4,16),
	--id_doctora=4, id_paciente=16
	--Rosa Milano con Emilia Trinidad
	(5,21),
	--id_doctora=5, id_paciente=21
	--Julia Solano con Natalia Mart�nez
	(1,26),
	--id_doctora=1, id_paciente=26
	--Ana Mar�a Orozco con Estefan�a Le�n
	(2,31),
	--id_doctora=2, id_paciente 31
	--Marcela Valencia con Erik S�nchez
	
	--nutricion--
	(6,2),
	--id_doctora=6, id_paciente=2
	--Dora Cadavid con �ngeles Ram�rez
	(7,7),
	--id_doctora=7, id_paciente=7
	--Alisson Leon con Michelle Gamboa
	(8,12),
	--id_doctora=8, id_paciente=12
	--Aura fuentes con Andr� Ramirez
	(9,17),
	--id_doctora=9, id_paciente=17
	--Frida Kaori con Alejandro L�pez
	(10,22),
	--id_doctora=10, id_paciente=22
	--Adriana Franco con Luz Mar�a Mart�nez
	(6,27),
	--id_doctora=6, id_paciente=27
	--Dora Cadavid con Ana Paola Campos
	(7,32),
	--id_doctora=7, id_paciente=32
	--Alisson Leon con Pen�lope Cerda 
	
	--psicolog�a--
	(11,3),
	--id_doctora=11, id_paciente=3
	--Patricia P�rez con M�nica lovato
	(12,8),
	--id_doctora=12, id_paciente=8
	--Ana Paulina Robles con Denisse Robles
	(13,13),
	--id_doctora=13, id_paciente=13
	--Ximena Esearte con Marco Mendieta
	(14,18),
	--id_doctora=14, id_paciente=18
	--Camila Bosch con Sebasti�n Alc�ntara
	(15,23),
	--id_doctora=15, id_paciente=23
	--Liliana Giral con Namibia Le�n
	(11,28),
	--id_doctora=11, id_paciente=28
	--Patricia P�rez con Medea Guerra
	(12,33),
	--id_doctora=12, id_paciente=33
	--Ana Paulina Robles con Alma Marcela Silva
	
	--sexolog�a--
	(16,4),
	--id_doctora=16 , id_paciente=4
	--Ines Ramirez con Lorena Antonieta Fern�ndez
	(17,9),
	--id_doctora=17, id_paciente=9
	--Maria Gomez con Marcela Montero
	(18,14),
	--id_doctora=18, id_paciente=14
	--Rafaela Hyakuya con Jes�s F�lix
	(19,19),
	--id_doctora=19, id_paciente=19
	--Nuria Cifuentes con Esteban Quiroz
	(20,24),
	--id_doctora=20, id_paciente=24
	--Valeria Gomez con Natalia Santiago
	(16,29),
	--id_doctora=16, id_paciente=29
	--Ines Ram�rez con Mar�a Fernanda Guerrero
	(17,34),
	--id_doctora=17, id_paciente=34
	--Maria Gomez con Antonio Casamadrid
	
	--sue�o--
	(21,5),
	--id_doctora=21 , id_paciente=5
	--Mariana Monreal con Mariana Quiroz
	(22,10),
	--id_doctora=22, id_paciente=10
	--Paola Padr�n con Suiza Garc�a
	(23,15),
	--id_doctora=23, id_paciente=15
	--Ana Lisa Mart�nez con �lvaro Acebedo
	(24,20),
	--id_doctora=24, id_paciente=20
	--Clio Dulong con �ngel Mej�a
	(25,25),
	--id_doctora=25, id_paciente=25
	--Renata Vazques con Irene M�ndez
	(21,30),
	--id_doctora=21, id_paciente=30
	--Mariana Monreal con Rosa Saldivar
	(22,35);
	--id_doctora=22, id_paciente=35
	--Paola Padr�n con Benito Ju�rez

