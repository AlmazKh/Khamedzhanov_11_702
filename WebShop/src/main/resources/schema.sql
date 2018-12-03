create table shop_user (
  id bigserial primary key,
  name varchar(30)
);

create table product (
  id bigserial primary key,
  title varchar(30)
);

create table basket (
  id bigserial primary key,
  user_id bigint,
  foreign key (user_id) references shop_user(id)
);

create table basket_product (
  basket_id bigint,
  product_id bigint,
  foreign key (basket_id) references basket(id),
  foreign key (product_id) references product(id)
);

|-----------------------------------------|
|---------действующий варик---------------|
|-----------------------------------------|
create table shop_user (
  id bigserial primary key,
  name varchar(30)
);

create table product (
  id bigserial primary key,
  name varchar(30)
);

create table basket (
  id bigserial primary key,
  user_id bigint,
  foreign key (user_id) references shop_user(id)
);

alter table basket_product ADD COLUMN count INTEGER;

create table basket_product (
  id bigint primary key,
  basket_id bigint,
  product_id bigint,
  foreign key (basket_id) references basket(id),
  foreign key (product_id) references product(id)
);

ALTER TABLE shop_user ADD COLUMN password_hash VARCHAR(70);

CREATE table auth (
  id BIGSERIAL primary key,
  user_id bigint,
  cookie_value varchar(100)
);
