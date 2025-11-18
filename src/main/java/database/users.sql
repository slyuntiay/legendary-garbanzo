create table users
(
    user_id serial
        primary key,
    name    varchar(32) not null,
    age     smallint    not null
);

alter table users
    owner to "LAnat";

INSERT INTO public.users (user_id, name, age) VALUES (1, 'Пупкин Василий', 30);
INSERT INTO public.users (user_id, name, age) VALUES (2, 'Иванова Ольга', 31);
