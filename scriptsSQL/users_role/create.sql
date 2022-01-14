create table rules
(
    id        serial primary key,
    read      bool,
    write     bool,
    add_users bool,
    redact_item bool,
    redact_cat bool
);

create table role
(
    id         serial primary key,
    admin      boolean,
    contractor boolean,
    agent      boolean,
    rules_id   int references rules (id)
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

create table role_users
(
    id       serial primary key,
    user_name varchar(50) not null,
    users_id int references users (id),
    role_id  int references role (id)
);

create table role_rule(
  id serial primary key,
  user_name varchar(50) not null,
  role_id int references role (id),
  rule_id int references rules (id)
);

create table cat_state
(
    id          serial primary key,
    category_id int references category (id),
    status_id   int references status (id)
);

create table comments
(
    id      serial primary key,
    comment text
);

create table attach
(
    id      serial primary key,
    attachs json
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
    attach_id   int references attach (id),
    comments_id int references comments (id),
    users_id    int references users (id)
);


