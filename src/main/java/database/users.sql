create table users
(
    user_id serial
        primary key,
    name    varchar(32) not null,
    age     smallint    not null
);

alter table users
    owner to "LAnat";

