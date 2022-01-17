create table rules
(
    id          serial primary key,
    read        bool,
    write       bool,
    add_users   bool,
    redact_item bool,
    redact_cat  bool
);

create table role
(
    id         serial primary key,
    admin      boolean,
    contractor boolean,
    agent      boolean
);

create table users
(
    id           serial primary key,
    "First_name" varchar(50) not null,
    "Last_name"  varchar(50) not null,
    "Tel_number" text,
    email        text,
    role_id      int references role (id)
);

create table role_rules
(
    id       serial primary key,
    role_id  int references role (id),
    rules_id int references rules (id)
);

create table category
(
    id     serial primary key,
    export boolean,
    moving bool
);


create table status
(
    id       serial primary key,
    executed int
);

create table item
(
    id          serial primary key,
    items       varchar(255),
    users_id    int references users (id),
    category_id int references category (id),
    status_id   int references status (id)
);

create table attach
(
    id      serial primary key,
    attachs text,
    item_id int references item (id)
);

create table comments
(
    id      serial primary key,
    comment text,
    item_id int references item (id)
);

