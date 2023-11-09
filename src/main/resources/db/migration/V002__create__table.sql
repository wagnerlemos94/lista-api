create table lista (
    id bigint not null auto_increment,
    usuario_id bigint not null,
    ativo boolean,
    primary key (id),
    FOREIGN key (usuario_id) references usuario(id)
                  ) engine=InnoDB;

create table itens (
    id bigint not null auto_increment,
    produto varchar(255) null,
    nome varchar(255) null,
        primary key (id)
                     ) engine=InnoDB;


create table lista_itens (
    lista_id bigint not null,
    itens_id bigint not null,
        primary key (
            lista_id,
            itens_id
            )
                        ) engine=InnoDB;