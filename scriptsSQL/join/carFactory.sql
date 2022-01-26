create table body(
    id serial primary key,
    body_type varchar(100),
    body_color varchar(100)
);

create table engine(
    id serial primary key,
    eng_type varchar(50),
    eng_volume int,
    eng_capacity float
);

create table transmission(
    id serial primary key,
    trns_type varchar(50),
    trns_gears int
);

create table car(
    id serial primary key,
    car_name varchar(100),
    id_body int references body(id) not null,
    id_eng int references engine(id) not null,
    id_trns int references transmission(id) not null
);

insert into body (body_type, body_color)
values ('sedan', 'black'), ('wagon', 'red'), ('cabriolet', 'white');

insert into body (body_type, body_color)
values ('SUV', 'green');


insert into engine (eng_type, eng_volume, eng_capacity)
values ('gasoline', 150, 2.5),
       ('diesel', 160, 2.7),
       ('gasoline', 99, 1.3),
       ('diesel', 249, 3.3);

insert into transmission (trns_type, trns_gears)
values ('manual', 5),
       ('automate', 8),
       ('robot', 12);

insert into car (car_name, id_body, id_eng, id_trns)
values ('skoda', 1, 1, 1),
       ('lada', 3, 4, 2),
       ('mercedes', 2, 3, 1);

select c.car_name as модель,
       b.body_type as кузов,
       e.eng_type as двигатель,
       e.eng_capacity as объем,
       t.trns_type as кпп
from car c
left outer join body b on b.id = c.id_body
left outer join engine e on e.id = c.id_eng
left outer join transmission t on t.id = c.id_trns;

select b.body_type
from body b
left join car c on b.id = c.id_body
where c.id is null;

select e.eng_type, e.eng_capacity, e.eng_volume
from engine e
left join car c on e.id = c.id_eng
where c.id is null;

select t.trns_type, t.trns_gears
from transmission t
left join car c on t.id = c.id_trns
where c.id is null;