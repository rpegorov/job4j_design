create table driver(
id serial primary key,
name varchar(100),
phone int
);

create table car(
id serial primary key,
model varchar(100),
number varchar (20),
driver_id int references driver(id)
);

create table car_driver(
    id serial primary key,
    car_id int references car(id),
    driver_id int references driver(id)
);


insert into driver(name, phone) VALUES ('driver1', 11111111);
insert into driver(name, phone) VALUES ('driver2', 11111112);
insert into driver(name, phone) VALUES ('driver3', 11111113);

insert into car(model, number, driver_id) VALUES ('car1', 111, 1);
insert into car(model, number, driver_id) VALUES ('car2', 222, 2);
insert into car(model, number, driver_id) VALUES ('car3', 333, 3);
insert into car(model, number, driver_id) VALUES ('car1', 111, 1);
insert into car(model, number, driver_id) VALUES ('car1', 111, 1);

select * from driver join car c on driver_id = c.id;

select d.name as Имя, c.number from car c
join driver d on c.driver_id = d.id;

select d.name as имя, c.model as марка, c.driver_id позывной from car c
join driver d on c.driver_id = d.id;

select d.name, d.phone, c.model, c.number from car c
join driver d on c.driver_id = d.id;