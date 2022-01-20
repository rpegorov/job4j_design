create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price)
values ('iPhone11', 80000),
       ('watch1', 10500),
       ('headphones1', 3200);
insert into devices(name, price)
values ('samsung1', 10000),
       ('watch2', 2320),
       ('headphones2', 14899);
insert into devices(name, price)
values ('samsung2', 14500),
       ('watch3', 34999),
       ('headphones3', 24999);
insert into devices(name, price)
values ('iPhone12', 120000),
       ('headphones1', 3200);

insert into people(name)
values ('Alex');
insert into people(name)
values ('Sergo');
insert into people(name)
values ('Julia');
insert into people(name)
values ('Cris');
insert into people(name)
values ('Jan');

insert into devices_people(device_id, people_id)
values (1, 1),
       (2, 1),
       (3, 1);
insert into devices_people(device_id, people_id)
values (2, 2),
       (6, 2);
insert into devices_people(device_id, people_id)
values (10, 3),
       (11, 3);


-- средяя стоимость всех устройств
select avg(price)
from devices;

-- самое дешевое устройство
select min(price)
from devices;

-- самое дорогое устройство
select max(price)
from devices;


-- средняя стоимость устройств у людей
select p.name, avg(price)
from devices_people dp
         join people p on dp.people_id = p.id
         join devices d on dp.device_id = d.id
group by p.name;

-- средняя стоимость устройств
select avg(price)
from devices;


-- средняя цена устройств при условии, что она больше 30 000
select p.name, avg(d.price)
from devices_people dp
         join people as p on dp.people_id = p.id
         join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 30000;


-- средняя цена устройств у человка при условии, что она дешевле 20 000
select p.name, avg(d.price)
from devices_people dp
         join people as p on dp.people_id = p.id
         join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) < 20000;

-- самое дешевое устройство у человека
select p.name, min(d.price)
from devices_people dp
         join people as p on dp.people_id = p.id
         join devices as d on dp.device_id = d.id
group by p.name;


-- самое дорогое устройство у человека
select p.name, max(d.price)
from devices_people dp
         join people as p on dp.people_id = p.id
         join devices as d on dp.device_id = d.id
group by p.name;

-- список людей, устройств и  цены
select p.name, d.name, d.price
from   devices_people dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name, d.name, d.price;