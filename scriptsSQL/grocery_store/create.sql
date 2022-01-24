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