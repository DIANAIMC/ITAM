--CREAR TABLAS Y SECUENCIAS--

create table especializacion(
  id_especializacion numeric(4) constraint pk_especializacion primary key,
  nombre varchar(250) not null
);

--
create sequence especializacion_id_especializacion_seq start 1 increment 1;
alter table especializacion alter column id_especializacion set default nextval('especializacion_id_especializacion_seq')
--

create table doctor (
  id_doctor numeric(4,0) constraint pk_doctor primary key,
  nombres varchar(50) NOT NULL ,
  apellidos varchar(50) NOT NULL ,
  fecha_contratacion date NOT NULL ,
  sueldo numeric(8,2) NOT NULL ,
  id_especializacion numeric(4) REFERENCES especializacion (id_especializacion) 
);

--
CREATE SEQUENCE doctor_id_doctor_seq START 1 INCREMENT 1 ;
ALTER TABLE doctor ALTER COLUMN id_doctor SET DEFAULT nextval('doctor_id_doctor_seq');
--

create table paciente (
	id_paciente numeric(4,0) constraint pk_paciente primary key,
	nombres varchar(50) NOT NULL ,
  	apellidos varchar(50) NOT NULL ,
  	tipo_sangre varchar(2) not NULL,
  	factor_rh varchar(1) not NULL,
  	peso numeric(5,2) not null, 
  	estatura numeric(4,1) not null
);

CREATE SEQUENCE paciente_id_paciente_seq START 1 INCREMENT 1 ;
ALTER TABLE paciente ALTER COLUMN id_paciente SET DEFAULT nextval('paciente_id_paciente_seq');

create table paciente_doctor (
	id_doctor numeric(4) REFERENCES doctor (id_doctor) ON UPDATE cascade,
	id_paciente numeric(4) REFERENCES paciente (id_paciente) ON UPDATE CASCADE ON DELETE CASCADE,
	constraint pk_paciente_doctor primary key (id_paciente, id_doctor)
);

create table estudio (
	id_estudio numeric(4,0) constraint pk_estudio primary key,
	fecha_prescripcion date not null,
	fecha_realizacion date not null,
	id_paciente numeric(4) REFERENCES paciente (id_paciente)
);

CREATE SEQUENCE estudio_id_estudio_seq START 1 INCREMENT 1 ;
ALTER TABLE estudio ALTER COLUMN id_estudio SET DEFAULT nextval('estudio_id_estudio_seq');

create table tipo_estudio (
	id_tipo_estudio numeric(4) constraint pk_tipo_estudio primary key,
	nombre varchar(50) NOT null,
	id_especializacion numeric(4) references especializacion (id_especializacion),
	id_estudio numeric(4) references estudio (id_estudio)
);

CREATE SEQUENCE tipo_estudio_id_tipo_estudio START 1 INCREMENT 1 ;
ALTER TABLE tipo_estudio ALTER COLUMN id_tipo_estudio SET DEFAULT nextval('tipo_estudio_id_tipo_estudio');



--INSERTAR DATOS--

insert into especializacion (nombre)
values
	('Pediatría'),
	('Cardiología'),
	('Cirugía'),
	('Diagnóstico Diferencial'),
	('Genética'),
	('Ocultismo'),
	('Santería');

INSERT INTO doctor
(nombres, apellidos, fecha_contratacion, sueldo, id_especializacion)
VALUES
	('Meredith', 'Grey', '2005-05-27', 225000.00, 3),
	('Gregory', 'House', '2004-11-16', 192000, 4),
	('Stephen', 'Strange', '2016-12-13', 320000, 3),
	('Helen', 'Cho', '2015-04-13', 250000, 5),
	('Gregorio', 'Casas', '2006-07-23', 823371.24, 2),
	('Otto', 'Octavius', '2016-11-04', 523371.24, 4),
	('Dr', 'Who', '2008-04-19', 723371.24, 5);

insert into paciente 
(nombres, apellidos, tipo_sangre, factor_rh, peso, estatura)
values
	('Roger','Waters', 'O', true,78,190),
	('Alejandro','Mejía', 'O', false,70,175),
	('Raúl','Fernandez', 'AB', true,79,180),
	('Sebastián','Dulong', 'B', false,68,172),
	('Ulises','Quevedo', 'A', true,78,188);


insert into paciente_doctor 
(id_paciente, id_doctor)
values 
	(1,	3),
	(1,	4),
	(2,	1),
	(3,	1),
	(3,	4),
	(4,	2),
	(4,	3),
	(4,	4),
	(5,	2),
	(5,	4);
	
--drop table hospital.doctor;

select * from paciente p;

delete from paciente 
where nombres='Ulises' and apellidos='Quevedo'

select * from paciente_doctor pd;

--alter table paciente_doctor drop constraint paciente_doctor_id_doctor_fkey foreing key (id_doctor) references doctor (id_doctor);
--alter table paciente_doctor drop constraint paciente_doctor_id_paciente_fkey foreing key (id_paciente) references paciente (id_paciente);

--alter table paciente_doctor add constraint paciente_doctor_id_doctor_fkey foreing key (id_doctor) references doctor (id_doctor);
--alter table paciente_doctor add constraint paciente_doctor_id_paciente_fkey foreing key (id_paciente) references paciente (id_paciente);

--truncate paciente;

--delete from paciente;

select * from paciente pd;

delete from paciente 
where nombres = 'Sebastián' and apellidos='Duloung';

select * from paciente pd;