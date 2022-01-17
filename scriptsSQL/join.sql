select * from users join role r on users.role_id = r.id;

select * from item join category c2 on item.category_id = c2.id;

select uu."First_name" as имя, r.admin as администратор from users as uu
join role r on uu.role_id = r.id;

select i.items as заявка, c.export as экспорт from item as i
join category c on i.category_id = c.id;

select u."First_name" as имя, i as заявка from item as i
join users u on i.users_id = u.id

select i.category_id as категория, users."First_name" as имя from users
join item i on users.id = i.users_id;

select a as файл, item as заявка from item
join attach a on a.item_id = a.id;