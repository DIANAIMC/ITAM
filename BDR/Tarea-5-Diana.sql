--Parte de la infraestructura es dise�ar contenedores cil�ndricos giratorios para facilitar la colocaci�n y 
--extracci�n de discos por brazos automatizados. Cada cajita de Blu-Ray mide 20cm x 13.5cm x 1.5cm, y para que 
--el brazo pueda manipular adecuadamente cada cajita, debe estar contenida dentro de un arn�s que cambia las 
--medidas a 30cm x 21cm x 8cm para un espacio total de 5040 cent�metros c�bicos y un peso de 500 gr por pel�cula.

--Se nos ha encargado formular la medida de dichos cilindros de manera tal que quepan todas las copias de los
--Blu-Rays de cada uno de nuestros stores. Las medidas deben ser est�ndar, es decir, la misma para todas nuestras
--stores, y en cada store pueden ser instalados m�s de 1 de estos cilindros. Cada cilindro aguanta un peso m�ximo 
--de 50kg como m�ximo. El vol�men de un cilindro se calcula de [�sta forma.](volume of a cylinder)

--VOLUMEN DE CADA CILINDRO

with peliculas_x_cilindro as (
	select 5000/50 as peliculas
),
--Altura del cilindro, aqu� suponemos que est�n pegadas todas las pel�culas
altura_cilindro as (
	select 1.5*pc.peliculas as altura  from peliculas_x_cilindro pc
),
--Radio de la base del cilindro, el diametro del cilindro debe ser suficiente para almacenar la pel�cula.
--Entrar�n exacto si el radio es igual a la mitad de una diagonal de una pel�cula
radio_cilindro as (
	select sqrt(power(30/2,2) + power(21/2,2)) as radio
)
 select altura, radio, pi()*power(r."radio",2)*h.altura as volumen from radio_cilindro r, altura_cilindro h;

--CILINDROS NECESARIOS PARA CADA TIENDA

--Cantidad de pel�culas en cada tienda
with num_peliculas as (
	select s.store_id as tienda, count(i.inventory_id) as num_peliculas
 	from inventory i join store s using(store_id)
 	group by s.store_id
 ), 
--Para saber cuantos cilindros necesita cada tienda dividimos el n�mero de pel�culas entre 100
cilindros_x_tienda as (
	select np.tienda, ceiling(np.num_peliculas/100 :: numeric) as num_cilindros
	from num_peliculas np
)
select * 
from cilindros_x_tienda;

