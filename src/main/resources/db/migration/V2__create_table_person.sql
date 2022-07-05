create table person(
    id bigint not null,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into person values(1, 'Jean Fernandes', 'jean@email.com');