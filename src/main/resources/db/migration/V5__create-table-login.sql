CREATE TABLE logins(

    id bigint not null auto_increment,
    email varchar(200) not null unique,
    senha varchar(200) not null,

    primary key(id)
);