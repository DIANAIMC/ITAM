--C�MO OBTENEMOS TODOS LOS NOMBRES Y CORREOS DE NUESTROS CLIENTES CANADIENSES PARA 
--UNA CAMPA�A?
--Soluci�n con where
select c.first_name || ' ' || c.last_name as nombres, c.email correos, c3.country pais
from customer c join address a using (address_id)
join city c2 using (city_id)
join country c3 using (country_id)
where c3.country = 'Canada'
order by 1 asc;
--Soluci�n con group by y having
select c.first_name || ' ' || c.last_name as nombres, c.email correos, c3.country pais
from customer c join address a using (address_id)
join city c2 using (city_id)
join country c3 using (country_id)
group by c.customer_id, c3.country_id 
having c3.country = 'Canada'
order by 1 asc;

--�QU� CLIENTE HA RENTADO M�S DE NUESTRA SECCI�N DE ADULTOS? *Hacerlo con max
--POR UNIDADES
--Usando where
select c.first_name || ' ' || c.last_name full_name, count(r.customer_id)
from film f join inventory i using(film_id) 
join rental r using(inventory_id)
join customer c using(customer_id)
where f.rating = 'NC-17'
group by c.customer_id 
order by 2 desc
limit 2;
--Usando having
select c.first_name || ' ' || c.last_name nombre, count(r.customer_id) as total
from film f join inventory i using(film_id) 
join rental r using(inventory_id)
join customer c using(customer_id)
group by c.customer_id, f.rating  
having f.rating = 'NC-17'
order by 2 desc
limit 2;
--POR TOTAL EN $$
select c.first_name || ' ' || c.last_name nombre, sum(p.amount) as total
from film f join inventory i using(film_id) 
join rental r using(inventory_id)
join customer c using(customer_id)
join payment p using (customer_id)
where f.rating = 'NC-17'
group by c.customer_id 
order by 2 desc
limit 1;

--�QU� PEL�CULAS SON LAS M�S RENTADAS EN TODAS NUESTRAS STORES?
--Aunque sean 2 tiendas es m�s f�cil identificar a la tienda por pais que por id
select distinct on (s.store_id) s.store_id tienda, c2.country pais, f.title pelicula, count(f.film_id) as total 
from film f join inventory i using(film_id)
join rental r using(inventory_id)
join store s using (store_id)
join address a using (address_id)
join city c using (city_id)
join country c2 using (country_id)
group by s.store_id, c2.country_id, f.film_id
order by 1,4 desc;

--�CU�L ES NUESTRO REVENUE POR STORE?
--Aunque sean 2 tiendas es m�s f�cil identificar a la tienda por pais que por id
select i.store_id tienda, c2.country pais, sum(p.amount)
from inventory i join rental r using(inventory_id)
join payment p using(rental_id)
join store s using (store_id)
join address a using (address_id)
join city c using (city_id)
join country c2 using (country_id)
group by i.store_id, c2.country 
order by 1 asc;
