CREATE TABLE usuarios (

    id bigint not null,
    email varchar(200) not null unique,
    cpf varchar(50) not null unique,

    primary key(id)
);