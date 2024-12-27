CREATE TABLE vagas (

    id bigint not null auto_increment,
    nome varchar(200) not null,
    atribuicao text not null,
    ativa tinyint not null,
    id_empresa bigint not null,
    foreign key (id_empresa) references empresas(id),

    primary key(id)
);