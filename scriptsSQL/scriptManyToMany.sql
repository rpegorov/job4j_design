
create table family(
    id serial primary key,
    name varchar(255)
);


create table animals(
    id serial primary key,
    name varchar(255),
    family_id int references "family"(id)
);

create table squad(
    id serial primary key,
    name varchar(255),
    family_id int references "family"(id),
    animals_id int references animals(id)
);

insert into "family"(name) values ('псовые');
insert into "family"(name) values ('кошачьи');
insert into "family"(name) values ('заячьи');

insert into animals(name, family_id) VALUES ('Собака', 1);
insert into animals(name, family_id) VALUES ('Лисица', 1);
insert into animals(name, family_id) VALUES ('Лев', 2);
insert into animals(name, family_id) VALUES ('Гепард', 2);
insert into animals(name, family_id) VALUES ('Заяц беляк', 3);

insert into squad(name, family_id, animals_id) values ('хищные', 1, 19);
insert into squad(name, family_id, animals_id) values ('хищные', 1, 20);
insert into squad(name, family_id, animals_id) values ('хищные', 2, 21);
insert into squad(name, family_id, animals_id) values ('хищные', 2, 22);
insert into squad(name, family_id, animals_id) values ('грызуны', 3, 23);


select * from animals;
select * from squad;
select * from "family";

select * from "family" where id in (select id from animals);
select * from "squad" where id in (select id from animals);