create table departments
(
    id       serial primary key,
    name_dep varchar(100)
);

create table emploers
(
    id             serial primary key,
    name_emploers  varchar(200),
    id_departments int references departments (id)
);

create table teens(
    id serial primary key,
    name varchar(200),
    gender char
);

insert into departments (name_dep)
values ('Services');
insert into departments (name_dep)
values ('Engineering');
insert into departments (name_dep)
values ('Research and Development');
insert into departments (name_dep)
values ('Legal');

insert into emploers (name_emploers, id_departments)
values ('Fawnia', 1);
insert into emploers (name_emploers, id_departments)
values ('Lissie', 1);
insert into emploers (name_emploers, id_departments)
values ('Lorri', null);
insert into emploers (name_emploers, id_departments)
values ('Fayina', 2);
insert into emploers (name_emploers, id_departments)
values ('Sarita', null);
insert into emploers (name_emploers, id_departments)
values ('Christalle', 2);
insert into emploers (name_emploers, id_departments)
values ('Cassy', 3);
insert into emploers (name_emploers, id_departments)
values ('Maurise', 3);
insert into emploers (name_emploers, id_departments)
values ('Vasilis', 4);
insert into emploers (name_emploers, id_departments)
values ('Rhett', 4);

insert into teens (name, gender) values ('Davey', 'M');
insert into teens (name, gender) values ('Daile', 'F');
insert into teens (name, gender) values ('Kiley', 'F');
insert into teens (name, gender) values ('Toby', 'F');
insert into teens (name, gender) values ('Guido', 'M');
insert into teens (name, gender) values ('Dannie', 'F');
insert into teens (name, gender) values ('Rubin', 'M');
insert into teens (name, gender) values ('Gerrie', 'M');
insert into teens (name, gender) values ('Pauletta', 'F');
insert into teens (name, gender) values ('Klement', 'M');

-- соеденяем гендоры
select a.name, b.name, (a.name, b.name) as "a and b = "
from teens a cross join teens b
where a.gender != b.gender;

-- пересечение департаментов и их работников
select *
from departments
         left join emploers e on departments.id = e.id_departments;

-- пересечение всех департаментов и всех работников
select *
from departments
         right outer join emploers e on departments.id = e.id_departments;

-- пересечение всех работников и департаментов (депы нулл)
select *
from emploers
         left join departments d on d.id = emploers.id_departments;


-- работники без департамента
select *
from emploers
         left join departments d on d.id = emploers.id_departments
where name_dep is null;


-- удалим работников из 2 департамента
UPDATE public.emploers SET id_departments = null::integer WHERE id = 4::integer;
UPDATE public.emploers SET id_departments = null::integer WHERE id = 6::integer;


-- показать департаменты без работников
select *
from emploers
right outer join departments d on emploers.id_departments = d.id
where name_emploers is null;

-- Все возможные работники для каждого департамента
select * from departments cross join emploers e;
