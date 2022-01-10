create table family(
    id serial primary key,
    name varchar(255)
);

create table animals(
    id serial primary key,
    name varchar(255),
    family_id int references "family"(id)
);

insert into "family"(name) values ('псовые');
insert into "family"(name) values ('кошачьи');
insert into "family"(name) values ('заячьи');
insert into animals(name, family_id) VALUES ('Собака', 1);
insert into animals(name, family_id) VALUES ('Лисица', 1);
insert into animals(name, family_id) VALUES ('Лев', 2);
insert into animals(name, family_id) VALUES ('Гепард', 2);
insert into animals(name, family_id) VALUES ('Заяц беляк', 3);

select * from animals;

select * from "family" where id in (select id from animals);