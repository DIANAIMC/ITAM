--DIANA MU�OZ
--
--			EJERCICIOS DE TAREA 1 QUERIES			--
--
--�Qu� contactos de proveedores tiene la posici�n de sales representative?
select s.contact_name sales_representative from suppliers s where s.contact_title = 'Sales Representative';

--�Qu� contactos de proveedores no son marketing managers?
select s.contact_name marketing_manager from suppliers s where s.contact_title != 'Marketing Manager';

--�Cu�les ordenes no vienen de clientes de Estados Unidos?*** con join
select o.order_id,  c.country pais_cliente from orders o, customers c
where c.country != 'USA';

--�Qu� productos de los que transportamos son quesos? 
--Solo los que se est�n transportando, distinct elimina repetidos
select distinct p.product_id, p.product_name quesos from categories c 
join products p using (category_id) 
join order_details od using (product_id)
join orders o using (order_id) where shipped_date is not null 
and c.description = 'Cheeses';

--�Qu� ordenes van a B�lgica o Francia?
select o.order_id, o.ship_country ordenes_a_Belgica_o_Francia from orders o 
where (o.ship_country = 'France' or o.ship_country = 'Belgium') and shipped_date is null ;

--�Qu� ordenes van a LATAM?
select o.order_id, o.ship_country ordenes_a_LATAM from orders o where o.ship_country 
in ('Mexico','Argentina','Brazil','Venezuela') and shipped_date is null;

--�Qu� ordenes NO van a LATAM?
select o.order_id, o.ship_country ordenes_no_LATAM from orders o where o.ship_country 
not in ('Mexico','Argentina','Brazil','Venezuela') and shipped_date is null;

--Necesitamos los nombre completos de los empleados, nombres y apellidos unidos en un mismo registro***
select concat(e.first_name, ' ', e.last_name) nombre_clientes  from employees e;

--�Cu�nta lana tenemos en el inventario?
select sum(p.unit_price*p.units_in_stock) dinero_inventario from products p where p.units_in_stock != 0;

--�C�antos clientes tenemos de cada pa�s?
select c.country pais, count(c.contact_name) total_clientes  from customers c group by c.country;


--			EJERCICIOS DE TAREA 1 CONTINUACI�N		--

--Obtener un reporte de edades de los empleados para checar su elegibilidad para seguro de gastos m�dicos menores.
select e.first_name nombres, e.last_name apellidos, age(e.birth_date) edad_exacta  
from employees e;

--�Cu�l es la orden m�s reciente por cliente? 
--Orden m�s reciente por cliente 
select c.contact_name, max(o.order_date) fecha
from orders o join customers c on (c.customer_id = o.customer_id)
group by c.contact_name;  

--�De nuestros clientes, qu� funci�n desempe�an y cu�ntos son? 
select c.contact_title posici�n , count(c.contact_title) total 
from customers c
group by c.contact_title
order by conteo desc;

--�Cu�ntos productos tenemos de cada categor�a? 
select c.category_name categoria, count(p.category_id) total_productos
from products p join categories c on(c.category_id = p.category_id)
group by p.category_id, c.category_name
order by p.category_id asc;

--�C�mo podemos generar el reporte de reorder? 
select reorder_level,  product_name producto, product_id id_producto, units_in_stock
from products p order by reorder_level desc;

--�A donde va nuestro env�o m�s voluminoso? --Direcci�n
select od.quantity cantida_maxima, o.ship_country pais, o.ship_address direcci�n
from order_details od join orders o on (od.order_id = o.order_id)
order by od.quantity desc limit 1;

--�C�mo creamos una columna en customers que nos diga si un cliente es bueno, regular, o malo?
--Lo hice con el criterio de cuanto unidades de producto pide
select o.customer_id, sum(od.quantity) as unidades_totales,
CASE
    WHEN sum(od.quantity) > 500000 THEN 'bueno'
    WHEN sum(od.quantity) < 200000 THEN 'malo'
    else 'regular'
end as calificacion
from order_details od, orders o group by o.customer_id 
order by unidades_totales desc;

--�Qu� colaboradores chambearon durante las fiestas de navidad?
select e.first_name nombres, e.last_name apellidos, e.employee_id id_empleado
from orders o join employees e on (o.employee_id = e.employee_id)
where (extract(month from o.shipped_date) = 12 and extract(day from o.shipped_date) = 25)
or (extract(month from o.order_date) = 12 and extract(day from o.order_date) = 25) group by e.employee_id ;

--�Qu� productos mandamos en navidad? 
select p.product_name productos from products p 
join order_details od on (p.product_id = od.product_id) 
join orders o on (od.order_id = o.order_id)
where extract(month from o.shipped_date) = 12 and extract(day from o.shipped_date) = 25;

--�Qu� pa�s recibe el mayor volumen de producto?
select o.ship_country pais, sum(od.quantity) suma_productos
from orders o join order_details od on o.order_id = od.order_id
group by o.ship_country
order by suma_productos desc limit 1;


