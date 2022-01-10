create table employee(
id serial primary key,
name varchar(50),
adress text,
phone varchar(20)
);

insert into employee(name, adress, phone) values('Иван', 'Москва', '111101111');
insert into employee(name, adress, phone) values('Кирилл', 'Санкт-Петербург', '2200222');
insert into employee(name, adress, phone) values('Дмитрий', 'Кривой Рог', '3303303303');

select * from employee;

update employee set name = 'Денис' where id = 7;
update employee set adress = 'Нижний Новгород' where id = 9;

select * from employee;

delete from employee where id = 8;

select * from employee;
