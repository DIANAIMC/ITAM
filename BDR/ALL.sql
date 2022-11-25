select p.amount , concat(c.first_name, ' ', c.last_name) as cliente, concat(s.first_name, ' ', s.last_name) as staff 
from payment p join customer c using (customer_id)
join staff s using (staff_id)
where p.amount  = (select max(p.amount) from payment p);

select ci.city 
from city ci 
where ci.country_id = (select co.country_id from country co where co.country = 'India');

select ci.city 
from city ci 
where ci.country_id in (select co.country_id from country co where co.country <> 'India');

--no está correcta pues incluye costumers que al menos an tenido un pago mayor a cero y queremos
--que nunca han tenido un pago igual cero, esto solo se puede hacer con subqueries.
select distinct c2.first_name, c2.last_name
from payment p join customer c2 using (customer_id)
where p.amount > 0;

select distinct c2.first_name, c2.last_name
from payment p join customer c2 using (customer_id)
where c2.customer_id not in (select p2.customer_id from payment p2
where p2.amount <= 0);

explain analyze select r.customer_id , count(*)
from rental r
group by r.customer_id 
having count(*) > all (
	select count(*)
 	from rental r2 join customer c2 using (customer_id)
 	join address a2 using (address_id)
 	join city c3 using (city_id)
 	join country c4 using (country_id)
 	where c4.country in ('United States', 'Mexico', 'Canada')
 	group by c2.customer_id 
 	order by 1 desc 
 	limit 1
 );
 
--- count > all (subquery)
explain analyze select r.customer_id , count(*)
from rental r
group by r.customer_id 
having count(*) > all ( -- count > reg1 AND count > reg2 AND ...
	select count(*) rentas_totales
 	from rental r2 join customer c2 using (customer_id)
 	join address a2 using (address_id)
 	join city c3 using (city_id)
 	join country c4 using (country_id)
 	where c4.country in ('United States', 'Mexico', 'Canada')
 	group by c2.customer_id
 );
 
--Cómo podemos obtener los clientes cuyo gasto con nosotros supera el revenue concentrado 
--aportado por Bolivia, Paraguay o Chile?

select c2.customer_id , sum(p2.amount) as pago_total
from payment p2 join customer c2 using (customer_id)
group by c2.customer_id 
having sum(p2.amount) > any (
	select sum(p.amount)
	from payment p join customer c using (customer_id)
	join address a using (address_id)
	join city ci using (city_id)
	join country co using (country_id)
	where co.country in ('Bolivia', 'Paraguay', 'Chile')
	group by co.country 
	);
	
select outer_customer.first_name, outer_customer.last_name
from customer outer_customer
where exists (
	select 1 from payment p 
	where p.amount > 11
	and p.customer_id = outer_customer.customer_id
	)
order by outer_customer.first_name, outer_customer.last_name;

select c.first_name, c.last_name
from customer c
where exists (
	select 1 from rental r
	where r.rental_date < '2005-05-25'
	and r.customer_id = c.customer_id 
	);
--El subquery con el statement select 1 es solo para que regrese algún dato. 
--Es de uso estándar cuando solo te interesa los renglones que se regresan, y no su contenido.