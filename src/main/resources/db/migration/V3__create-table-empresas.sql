CREATE TABLE empresas (

    id bigint not null,
    email varchar(200) not null unique,
    cnpj varchar(50) not null unique,

    primary key(id)
);