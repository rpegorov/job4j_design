--selects

--Просроченные продукты
select p.name, p.expired_date
from product p
where current_date > p.expired_date;

--Показать самый дорогой продукт
select *
from product
where price = (select max(price) from product);

-- Тип и общее кол-во продуктов по типу
select t.name, count(p.name)
from product p
         join type t on p.type_id = t.id
group by t.name;

-- Показать все сыры
select p.name, p.price, p.expired_date
from product p
where name LIKE '%Сыр%';

--Показать все продукты из типа Сыры и Молочные
select p.name, p.type_id
from product p
where type_id
          in (select type.id
              from type
              where name in ('Сыры', 'Молочные'));

--Показать типы продуктов которых меньше 4
select t.name, count(type_id)
from type t
         join product p on t.id = p.type_id
group by t.name
having count(t.name) < 4;

--Показать типы продуктов которых больше 10
select t.name, count(type_id)
from type t
         join product p on t.id = p.type_id
group by t.name
having count(t.name) > 10;

-- Показать имена продуктов и имена типов (вывести все)
select p.name, t.name
from product p
join type t on t.id = p.type_id;