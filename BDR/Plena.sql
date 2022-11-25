--YA CORR�
create table especialidad(
	id_especialidad numeric(4,0) constraint pk_especialidad primary key,
	ginecologia bool not null,
	nutricion bool not null,
	psicologia bool not null,
	sexologia bool not null,
	sue�o bool not null
);
create sequence especialidad_id_especialidad_seq start 1 increment 1;
alter table especialidad alter column id_especialidad set default nextval('especialidad_id_especialidad_seq'); 
---FALTA CORRER
create table doctora(
	id_doctora numeric(4,0) constraint pk_doctora primary key,
	id_especialidad numeric(4,0) references especialidad (id_especialidad),
	nombres varchar(50) not null,
	apellido_paterno varchar(50) not null,
	apellido_materno varchar(50) not null,
	cedula numeric(15,0) not null,
	contrase�a varchar(10) not null,
	acceso enum ('general','especialista') not null --
);
create sequence doctora_id_doctora_seq start 1 increment 1;
alter table doctora alter column id_doctora set default nextval('doctora_id_doctora_seq'); 
---FALTA CORRER
create table paciente(
	id_paciente numeric(4,0) constraint pk_paciente primary key,
	id_expediente numeric(4,0) references expediente (id_expediente),
	nombres varchar(50) not null,
	apellido_paterno varchar(50) not null,
	apellido_materno varchar(50) not null,
	fecha_nacimiento date not null,
	genero enum ('Mujer','Hombre','Mujer Transg�nero','Hombre Transg�nero','G�nero no binario') not null, --
	sexo enum ('Femenino','Masculino','Intersexual') not null, --
	contacto varchar (50) not null,
);
create sequence paciente_id_paciente_seq start 1 increment 1;
alter table paciente alter column id_paciente set default nextval('paciente_id_paciente_seq'); 
--FALTA CORRER 
create table paciente_doctora(
	id_paciente numeric (4,0) references paciente (id_paciente) on update cascade,
	id_doctora numeric (4,0) references doctora (id_doctora) on update cascade,
	constraint pk_paciente_doctora primary key (id_paciente, id_doctora)
);
--FALTA CORRER 
create table administrador(
	id_administrador numeric(4,0) constraint pk_administrador primary key,
	id_paciente numeric(4,0) references paciente (id_paciente),
	id_doctora numeric(4,0) references doctora (id_doctora),
	id_paciente_doctora numeric(4,0) references paciente_doctora (id_paciente_doctora),
	contrase�a varchar(10) not null
);
create sequence administrador_id_administrador_seq start 1 increment 1;
alter table administrador alter column id_administrador set default nextval('administrador_id_administrador_seq'); 
--FALTA CORRER 
create table notas(
	id_notas numeric(4,0) constraint pk_notas primary key,
	id_doctora numeric(4,0) references doctora (id_doctora),
	texto varchar(500) not null
);
create sequence notas_id_notas_seq start 1 increment 1;
alter table notas alter column id_notas set default nextval('notas_id_notas_seq');
--FALTA CORRER 
create table ficha_personal(
	id_ficha_personal numeric(4,0) constraint pk_ficha_personal primary key,
	diabetes bool not null,
	hipotiroidismo bool not null,
	sindrome_ovario bool not null,
	anemia bool not null, 
	hipertension bool not null,
	medicamento varchar(100) not null --podemos poner primero booleano en caso de que si, que ingrese los medicamentos que toma
);
create sequence ficha_personal_id_ficha_personal_seq start 1 increment 1;
alter table ficha_personal alter column id_ficha_personal set default nextval('ficha_personal_id_ficha_personal_seq');

---FALTA CORRER---
create table ginecologia(
	id_ginecologia numeric(4,0) constraint pk_ginecologia primary key,
	menstruacion enum ('Antes de los 10 a�os','De los 10 a�os a los 14 a�os','Despu�s de los 14 a�os'),
	ultima_menstruacion date not null, 
	primera_menstruacion date not null,
	inicio_vida_sexual bool not null, -- lo dejamos o no?
	edad_inicio_sexual numeric(2,0),
	metodo_anticonceptivo enum ('Cond�n','Mirena','Kyleena','DIU de cobre', 'DIU de plata','Implante subd�rmico','Anticonceptivos orales combinados',
	'Anillo vaginal', 'Parche', 'Inyecci�n', 'Ciclo natural', 'Espermicidas', 'Coitus Interruptus', 'Ligaci�n o corte de trompas uterinas',
	'Vasectom�a','Ninguno') not null -- �Qu� pasa si usa varios m�todos?
);
create sequence ginecologia_id_ginecologia_seq start 1 increment 1;
alter table ginecologia alter column id_ginecologia set default nextval('ginecologia_id_ginecologia_seq');

---FALTA CORRER---
create table nutricion(
	id_nutricion numeric(4,0) constraint pk_nutricion primary key,
	peso numeric(3,2) not null,
	talla numeric(3,2) not null,
	litros_dia numeric(1,1) not null,
	ejercicio bool not null,
	tipo_ejercicio enum ('Caminar','El�ptica','Bicicleta est�tica', 'Pesas o ejercicios de fuerza', 'Yoga',
	'Actividades al aire libre', 'Otros') not null--�qu� pasa si hace varias de estas actividades?
);
create sequence nutricion_id_nutricion_seq start 1 increment 1;
alter table nutricion alter column id_nutricion set default nextval('nutricion_id_nutricion_seq');

---FALTA CORRER---
create table preocupacion(
	id_preocupacion numeric(4,0) constraint pk_preocupacion primary key,
	preocupacion varchar (30),
	tiempo_preocupacion enum('Hace m�s de un mes', 'Hace m�s de 2 semanas','Hace menos de 2 semanas') not null,
	desgaste_trabajo enum('Siempre','Pocas veces','Frecuentemente','Siempre') not null,
	afecta_vida bool not null 
);
create sequence preocupacion_id_preocupacion_seq start 1 increment 1;
alter table preocupacion alter column id_preocupacion set default nextval('preocupacion_id_preocupacion_seq');

---FALTA CORRER---
create table psicologia(
	id_psicologia numeric(4,0) constraint pk_psicologia primary key,
	id_preocupacion numeric(4,0) references pk_psicologia primary key,
);
create sequence psicologia_id_psicologia_seq start 1 increment 1;
alter table psicologia alter column id_psicologia set default nextval('psicologia_id_psicologia_seq');
---FALTA CORRER 
create table sexologia(
	id_sexologia numeric(4,0) constraint pk_sexologia primary key,
	difucultad_orgasmo bool not null,
	cada_cuando enum('Siempre','En determina circunstancia','Otro') not null,
	conformidad_sexualidad bool not null,
	satisfaccion bool not null
);
create sequence sexologia_id_sexologia_seq start 1 increment 1;
alter table sexologia alter column id_sexologia set default nextval('sexologia_id_sexologia_seq');
--FALTA CORRER 
create table sue�o(
	id_sue�o numeric(4,0) constraint pk_sue�o primary key,
	horas_sue�o numeric (2,1) not null,
	ronca bool not null,
	interrupcion enum ('Nunca','Pocas veces','Frecuentemente','Siempre') not null,
	pesadillas bool not null
);
create sequence sue�o_id_sue�o_seq start 1 increment 1;
alter table sue�o alter column id_sue�o set default nextval('sue�o_id_sue�o_seq');
--FALTA CORRER 
create table expediente(
	id_expediente numeric(4,0) constraint pk_expediente primary key,
	id_notas numeric (4,0) references notas (id_notas),
	id_ficha_personal numeric (4,0) references ficha_personal (id_ficha_personal),
	id_ginecologia numeric (4,0) references ginecologia (id_ginecologia),
	id_nutricion numeric (4,0) references nutricion (id_nutricion),
	id_psicologia numeric (4,0) references psicologia (id_psicologia),
	id_sexologia numeric (4,0) references sexologia (id_sexologia),
	id_sue�o numeric (4,0) references sue�o (id_sue�o)
);
create sequence expediente_id_expediente_seq start 1 increment 1;
alter table expediente alter column id_expediente set default nextval('expediente_id_expediente_seq');


id_paciente numeric(4,0) constraint pk_paciente primary key,
	id_expediente numeric (4,0) references expediente (id_expediente),
	nombre varchar (50) not null,
	apellido_paterno varchar (50) not null,
	apellido_materno varchar (50) not null,
	fecha_nacimiento date not null,
	genero enum ('Mujer','Hombre','Mujer Transg�nero','Hombre Transg�nero','G�nero no binario') not null, --
	sexo enum ('Femenino','Masculino','Intersexual') not null,
	contacto varchar (50) not null,

--PACIENTES A INCERTAR
insert into paciente
(nombres, apellido_paterno, apellido_materno, fecha_nacimiento, genero, sexo, contacto)
values
	('Juana','Martinez','Lopez','1992-07-16','Mujer','Femenino','5522853756'),
	('�ngeles','Ram�rez','Gonz�lez','1973-09-02','Mujer','Femenino','2836047809'),
	('M�nica','Lovato','Loma','1976-02-23','Mujer','Femenino','7446982465'),
	('Lorena Antonieta','Fernandez','Mota','1987-10-28','Mujer','Femenino','6569875432'),
	('Mariana','Quiroz','Garc�a','1990-10-10','Mujer','Femenino','5539872342'),
	('Fernanda','Mar�n','Rubio','1995-03-22','Mujer Transg�nero','Masculino','9874563211'),
	('Michelle','Gamboa','Pe�a','2000-09-07','Mujer Transg�nero','Masculino','9517896782'),
	('Denisse','Robles','Moreno','1983-05-19','Mujer Transg�nero','Masculino','7762394222'),
	('Marcela','Montero','Castilla','2001-07-07','Mujer Transg�nero','Masculino','6234289365'),
	('Suiza','Garc�a','Rivera','1978-11,30','Mujer Transg�nero','Masculino','5873459872'),
	('Roberto','Torres','Medina','1989-12-05','Hombre Transg�nero','Femenino','8976545672'),
	('Andr�','Ram�rez','Landero','1994-01-11','Hombre Transg�nero','Femenino','7658769872'),
	('Marco','Mendieta','Dur�n','1997-04-26','Hombre Transg�nero','Femenino','4568762349'),
	('Jes�s','F�lix','CuevaS','1974-09-09','Hombre Transg�nero','Femenino','2938467293'),
	('�lvaro','Acebedo','Barbosa','1962-07-28','Hombre Transg�nero','Femenino','2334568879'),
	('Emilia','Trinidad','Zepeda','1998-06-30','Hombre','Femenino','8932346785'),
	('Alejandro','L�pez','Aguirre','1988-08-31','Hombre','Femenino','9823406785'),
	('Sebasti�n','Alc�ntara','Medina','1963-02-28','Hombre','Femenino','2395048832'),
	('Esteban','Quiroz','Garc�a','1958-12-24','Hombre','Femenino','2934567799'),
	('�ngel','Mej�a','Gonz�lez','199i-12-23','Hombre','Femenino','9876541234'),
	('Natalia','Mart�nez','Espinoza','1955-11-12','Mujer','Intersexual','8975678231'),
	('Luz Mar�a','Mendoza','Enrriquez','1969-12-14','Mujer','Intersexual','7655678899'),
	('Namibia','Le�n','Ugalde','1999-01-12','Mujer','Intersexual','3456780987'),
	('Natalia','Santiago','Zamora','1993-03-10','Mujer','Intersexual','6374843433'),
	('Irene','M�ndez','Mu�oz','2002-06-18','Mujer','Intersexual','7464738393'),
	('Estefan�a','Le�n','Sosa','1994-10-19','G�nero no binario','Femenino','4324567387'),
	('Ana Paola','Campos','Zazueta','2003-12-12','G�nero no binario','Femenino','7652345567'),
	('Medea','Guerra','Duarte','2000-01-01','G�nero no binario','Femenino','9946631234'),
	('Mar�a Fernanda','Guerrero','Luna','1999-12-31','G�nero no binario','Femenino','7655666791'),
	('Rosa','Sald�var','Lerma','1980-03-15','G�nero no binario','Femenino','4211237655');