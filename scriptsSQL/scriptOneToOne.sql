create table people(
    id serial primary key,
    person_num int,
    contract int
);


create table employees(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    pasport int
);

create table employee_persona(
    id serial primary key,
    people_id int references people(id) unique,
    epmloyee_id int references employees(id) unique
);

insert into people(person_num, contract) values (1111, 5555);
insert into employees(first_name, last_name, pasport) values ('Ivan', 'Ivanov', 1122333444);

select * from "employees" where id in (select id from people);

select * from "people" where id in (select id from employees);

