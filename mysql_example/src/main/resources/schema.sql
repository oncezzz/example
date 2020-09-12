drop table if exists auto_user;
create table auto_user(
    id bigint auto_increment primary key,
    name varchar(32),
    mobile varchar(32),
    address varchar(256)
);

drop table if exists uuid_user;
create table uuid_user(
    id varchar(32) primary key,
    name varchar(32),
    mobile varchar(32),
    address varchar(256)
);

drop table if exists snow_user;
create table snow_user(
    id bigint primary key,
    name varchar(32),
    mobile varchar(32),
    address varchar(256)
);

drop table if exists object_user;
create table object_user(
    id varchar(32) primary key,
    name varchar(32),
    mobile varchar(32),
    address varchar(256)
);
