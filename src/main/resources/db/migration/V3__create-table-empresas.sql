CREATE TABLE empresas (

    id bigint not null auto_increment,
    email varchar(200) not null unique,
    cnpj varchar(50) not null unique,

    primary key(id)
);