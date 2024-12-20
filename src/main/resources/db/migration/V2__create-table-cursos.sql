CREATE TABLE cursos (

    id bigint not null auto_increment,
    nome varchar(200) not null,
    duracao int not null,
    id_usuario bigint not null,
    foreign key (id_usuario) references usuarios(id),

    primary key(id)
);