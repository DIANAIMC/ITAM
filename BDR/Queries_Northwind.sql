--muestra 10 productos
--limit pone el limite de hasta donde se va mostrar, el orden es el de las tablas
select * from products p limit 10;

--muestra todos los productos
select * from products p;

--Se están ordenando los datos por el product_id, en orden ascendente con límite 10
select * from products p order by product_id limit 10;

--Se están ordenando los datos por el product_id, en orden descendente con límite 10
select * from products p order by product_id desc limit 10;

--Obtener nombre de producto y cantidad de producto por unidad
select p.product_name , p.quantity_per_unit from products p;

--Obtener nombre de producto y su id
select p.product_name , p.product_id from products p;

--Obtener nombre de producto y su id de productos descontinuados
--WHERE funje como condicional
select p.product_id , p.product_name , p.discontinued from products p where p.discontinued = 1;

--Obtener el nombre y precio unitario del producto más caro y del más barato
--order by ordena la tabla, limite 1 para que solo enseña el más caro y el más barato
select p.product_name , p.unit_price from products p order by p.unit_price desc limit 1;
select p.product_name , p.unit_price from products p order by p.unit_price limit 1;

--Obtener el id, el nombre y el precio unitario para productos de menos de $20 en precio unitario
select p.product_id , p.product_name , p.unit_price from products p where p.unit_price < 20;

--Obtener el id, el nombre y el precio unitario para productos de menos de $20 en precio unitario y que esten orden ascendente con respecto al precio
select p.product_id , p.product_name , p.unit_price from products p where p.unit_price < 20 order by p.unit_price ;

--Obtener el id, el nombre y el precio unitario para productos que cuesten entre $15 y $25 y que esten orden ascendente con respecto al precio
select p.product_id , p.product_name , p.unit_price from products p where p.unit_price >= 15 and p.unit_price <= 25 order by p.unit_price ;

--Obtener nombre y precio unitario de productos por arriba del precio promedio de todo nuestro catálogo
--se usa un subquerie con el alias p2, tiene su propia visibilidad por lo tanto no puede tener el mismo nombre, lo que se encuentra dentro
--del paréntesis tiene el mismo nombre
--AVG es una función de agregación
select p.product_name , p.unit_price from products p where p.unit_price > (select avg(p2.unit_price) from products p2);

--Obtener el costo promedio por unidad 
select avg(p2.unit_price) from products p2;

--Nombres y precios unitarios de 10 productos más caros
select p.product_name , p.unit_price from products p order by p.unit_price desc limit 10;

--Conteo de los productos descontinuados y los que aún se tiene en inventario
--AVG, COUNT funciones de agregación
--cuando solo se tiene una tabla entonces se puede usar count(*) y obtendríamos el mismo resultado
select count(p.product_id) from products p where p.discontinued = 1 and p.units_in_stock != 0;

--Obtener los productos descontinuados y los que aún se encuentran en inventario
select p.product_name from products p  where p.discontinued = 1 and p.units_in_stock != 0;

--Obtener el nombre, la cantidad de unidades en órdenes y la cantidad en stock de productos cuya cantidad en órdenes sea mayor a la cantidad en stock
select p.product_name , p.units_in_stock ,p.units_on_order from products p where p.units_on_order > p.units_in_stock;

--Si agregamos el campo p.discontinued a ésta última consulta, podríamos contar la historia de 
--"tenemos una órden de 40 de un producto que tenemos en inventario solo 17 y este producto ha 
--sido descontinuado, por lo que tendremos problemas para hacerle fulfillment a esa orden y tendremos 
--que poner nuestra cara de idiotas y ofrecer reemplazo de producto".

--- GROUP BY --- 25/04/22

select c.contact_title, c.country, count(*) 
from customers c 
group by c.contact_title, c.country 
order by 2 desc;

--EJERCICIO 1

--El flete promedio que enviamos por cada shipping company.
select s.company_name , avg(o.freight) 
from orders o join shippers s on (o.ship_via = s.shipper_id)
group by s.shipper_id;

--La correlación entre el monto pagado por un producto en una orden y el descuento aplicado.
select od.product_id , corr(od.unit_price * od.quantity, od.discount) 
from orders o join order_details od using (order_id)
group by od.product_id

--Si algún producto de cada categoría está descontinuado.
select c.category_name , bool_or(cast(p.discontinued as boolean))
from products p join categories c using (category_id)
group by c.category_name

--- GROUP BY --- 02/05/22

-- Este query fue finalmente resuelto por el grupo de BD1 de OI2021 a las 15:14
-- Felicidades :D <3
select country,
	case 
		when export_amount is null and import_amount is null then 0
		when export_amount is null and import_amount > 0 then import_amount*-1
		when import_amount is null and export_amount > 0 then export_amount
		else export_amount - import_amount
	end as balanza_comercial
from (
	select c.country as country, sum(od.unit_price*od.quantity*(1-od.discount)) as export_amount
	from orders o join customers c using (customer_id)
	join order_details od using (order_id)
	join products p using (product_id)
	join suppliers s using (supplier_id)
	where s.country != c.country 
	group by c.country
) as exports full outer join (
	select s.country as country , sum(od.unit_price*od.quantity) as import_amount
	from orders o join customers c using (customer_id)
	join order_details od using (order_id)
	join products p using (product_id)
	join suppliers s using (supplier_id)
	where s.country != c.country
	group by s.country
) as imports using (country);


 
