-- CREAR TABLAS Y SECUENCIAS --

--CLIENTE
create table cliente (
  id_cliente numeric(4,0) constraint pk_cliente primary key,
  nombre_cliente varchar(50) NOT NULL ,
  apellido_cliente varchar(50) NOT NULL ,
  edad_cliente numeric(2),
  forma_pago bool not null
);

--
CREATE SEQUENCE cliente_id_cliente_seq START 1 INCREMENT 1 ;
ALTER TABLE cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_id_cliente_seq');
--

--HUESPED
create table huesped (
	id_huesped numeric(4,0) constraint pk_huesped primary key,
	id_cliente numeric(4) REFERENCES cliente (id_cliente),
	nombre_huesped varchar(50) NOT null,
	apellido_cliente varchar(50) NOT NULL,
  	edad_cliente numeric(2)
);

--
CREATE SEQUENCE huesped_id_huesped_seq START 1 INCREMENT 1 ;
ALTER TABLE huesped ALTER COLUMN id_huesped SET DEFAULT nextval('huesped_id_huesped_seq');
--

--RESTAURANTE 
create table restaurante (
	id_restaurante numeric(4,0) constraint pk_restaurante primary key,
	nombre_restaurante varchar(50) NOT NULL 
);

--
CREATE SEQUENCE restaurante_id_restaurante_seq START 1 INCREMENT 1 ;
ALTER TABLE restaurante ALTER COLUMN id_restaurante SET DEFAULT nextval('restaurante_id_restaurante_seq');
--

--CÓDIGO DE DESCUENTO
create table codigo_descuento (
	id_codigo_descuento numeric(4,0) constraint pk_codigo_descuento primary key,
	id_restaurante numeric(4) REFERENCES restaurante (id_restaurante) on update cascade ,
	codigo_descuento varchar(50) not null,
	fecha_generacion date not null
);

--
CREATE SEQUENCE codigo_descuento_id_codigo_descuento_seq START 1 INCREMENT 1 ;
ALTER TABLE codigo_descuento ALTER COLUMN id_codigo_descuento SET DEFAULT nextval('codigo_descuento_id_codigo_descuento_seq');
--

--CIUDAD
create table ciudad (
	id_ciudad numeric(4,0) constraint pk_ciudad primary key,
	nombre_ciudad varchar(50) NOT NULL 
);

--
CREATE SEQUENCE ciudad_id_ciudad_seq START 1 INCREMENT 1 ;
ALTER TABLE ciudad ALTER COLUMN id_ciudad SET DEFAULT nextval('ciudad_id_ciudad_seq');
--

--CIUDAD_RESTAURANTE
create table ciudad_restaurante (
	id_ciudad numeric(4) references ciudad (id_ciudad) on update cascade,
	id_restaurante numeric(4) references restaurante (id_restaurante) on update cascade,
	constraint pk_ciudad_restaurante primary key (id_ciudad, id_restaurante)
);

--HOTEL 
create table hotel(
	id_hotel numeric(4) constraint pk_hotel primary key,
	nombre_hotel varchar(50) not null,
	fecha_inicio_convenio date not null,
	calificacion numeric(1)
);

--
CREATE SEQUENCE hotel_id_hotel_seq START 1 INCREMENT 1 ;
ALTER TABLE hotel ALTER COLUMN id_hotel SET DEFAULT nextval('hotel_id_hotel_seq');
--

--HOTEL_CIUDAD
create table hotel_ciudad (
	id_hotel numeric(4) references hotel (id_hotel) on update cascade,
	id_ciudad numeric(4) references ciudad (id_ciudad) on update cascade,
	constraint pk_hotel_ciudad primary key (id_hotel, id_ciudad)
);

--HABITACIÓN
create table habitacion (
	id_habitacion numeric(4) constraint pk_habitacion primary key,
	id_hotel numeric(4) REFERENCES hotel (id_hotel),
	disponibilidad bool not null,
	tipo varchar(100) not null 
);

--
CREATE SEQUENCE habitacion_id_habitacion_seq START 1 INCREMENT 1 ;
ALTER TABLE habitacion ALTER COLUMN id_habitacion SET DEFAULT nextval('habitacion_id_habitacion_seq');
--

--RESERVACIÓN
create table reservacion (
	id_reservacion numeric(4) constraint pk_reservacion primary key,
	id_habitacion numeric (4) REFERENCES habitacion (id_habitacion) on update cascade,
	id_cliente numeric (4) REFERENCES cliente (id_cliente) on update cascade,
	precio numeric (6) not null,
	tipo_precio bool not null,
	fecha_reservacion date not null,
	fecha_checkin date not null,
	estado bool not null
);

--
CREATE SEQUENCE reservacion_id_reservacion_seq START 1 INCREMENT 1 ;
ALTER TABLE reservacion ALTER COLUMN id_reservacion SET DEFAULT nextval('reservacion_id_reservacion_seq');
--

