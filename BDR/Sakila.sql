--1. Cuantos actores comparten apellido con al menos otro actor?
--Si queremos solo listar los apellidos repetidos (apellidos que pertenecen a >=2 actores):

select a.last_name 
from actor a 
group by a.last_name 
having count(*)>=2;

--Si queremos CONTAR los apellidos repetidos:

select count(t.cuenta)
from(
	select a.last_name, count(*) as cuenta  
	from actor a 
	group by a.last_name 
	having count(*)>=2
) as t;

--Si queremos contar LOS ACTORES con apellidos repetidos:

select sum(t.cuenta)
from(
	select a.last_name, count(*) as cuenta  
	from actor a 
	group by a.last_name 
	having count(*)>=2
) as t;

--2. De nuestros empleados, cuál es el que más negocio trajo a nuestro store en 2005?
select sum(p.amount), s.first_name || ' ' || s.last_name 
from payment p join staff s using (staff_id)
where p.payment_date between '2005-01-01 00:00:00' and '2005-12-31 23:59:59'
group by s.staff_id 
order by 1 desc 
limit 2;

-- De nuestros empleados, cuál es el que más negocio trajo a nuestro store en 2005? POR TIENDA
select sum(p.amount), s.first_name || ' ' || s.last_name as empleado
from payment p join staff s using (staff_id)
where p.payment_date between '2005-01-01 00:00:00' and '2005-12-31 23:59:59'
group by s.store_id, s.staff_id 
order by 1 desc;

select sum(p.amount), s.first_name || ' ' || s.last_name as empleado, 
extract(year from p.payment_date) as payment_year 
from payment p join staff s using (staff_id)
group by s.staff_id, payment_year
having extract(year from p.payment_date) = 2005
order by 1 desc;

--3. Cuantos películas tienen un ensemble cast (5 o más actores 5?)?
select f.title, count(fa.film_id)
from film f join film_actor fa using (film_id)
group by film_id
having count(*) >= 5;

--¿ Cuál ha sido nuestro cliente más redituable cada año?
select sum(p.amount) as monto, c.first_name || '' || c.last_name as nombre, extract(year from p.payment_date) as payment_year 
from payment p join customer c using (customer_id)
group by c.customer_id , payment_year 
order by 3,1 desc 
limit 2;