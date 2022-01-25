
--create database
create database grocery_store_db;



--create table

create table type(
                     id serial primary key,
                     name text
);

create table product(
                        id serial primary key,
                        name text,
                        expired_date date,
                        price float4,
                        type_id int references type(id)
);


--inset table
insert into type (name)
VALUES ('Молочные'),
       ('Хлебобулочные'),
       ('Сыры'),
       ('Снеки');

set datestyle to DMY;

insert into product (name, expired_date, price, type_id)
values ('Молоко Домик в деревне', '23/01/2022', 65, 1),
       ('Молоко Буренка', '01/01/2022', 50, 1),
       ('Молоко Простоквашино', '25/01/2022', 55.99, 1),
       ('Кефир Простоквашино', '24/01/2022', 35.40, 1),
       ('Ряженка', '24/01/2022', 47.50, 1);


insert into product (name, expired_date, price, type_id)
values ('Хлеб черны круглый', '04/02/2022', 70, 2),
       ('Хлеб черный кирпич', '09/01/2022', 55.39, 2),
       ('Хлеб белый круглый', '05/02/2022', 65, 2),
       ('Печенье сдобное', '23/02/2022', 40, 2),
       ('Круасан', '11/02/2022', 20.50, 2);

insert into product (name, expired_date, price, type_id)
values ('Сыр Российский не съедобный', '18/01/2022', 155.71, 3),
       ('Сыр Белгород', '16/02/2022', 199.99, 3),
       ('Сыр творожный', '24/01/2022', 117.60, 3),
       ('Сыр вкусный', '24/01/2022', 117.60, 3),
       ('Сыр очень вкусный', '24/01/2022', 117.60, 3),
       ('Сыр не вкусный', '24/01/2022', 117.60, 3),
       ('Сыр Украинский', '24/01/2022', 117.60, 3),
       ('Сыр Французкий', '24/01/2022', 117.60, 3),
       ('Сыр такой себе', '24/01/2022', 855.30, 3);

insert into product (name, expired_date, price, type_id)
values ('Сухарики ржаные', '18/04/2022', 35, 4),
       ('Сухарики квадратные', '23/05/2022', 40, 4),
       ('Таранка с перцем', '23/05/2022', 77, 4);


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
select t.name, p.name
from type t
join product p on t.id = p.type_id
where t.name LIKE '%Сыр%';

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