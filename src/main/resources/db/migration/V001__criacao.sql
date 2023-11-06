create table role (
    id bigint not null auto_increment,
    role_nome varchar(255),
    primary key (id)
                  ) engine=InnoDB;

create table usuario (
    id bigint not null auto_increment,
    login varchar(255) not null,
    nome varchar(255) not null,
    senha varchar(255) not null,
    ativo boolean,
    role varchar(50),
        primary key (id)
                     ) engine=InnoDB;

create table usuario_roles (
    usuario_id bigint not null,
    roles_id bigint not null,
        primary key (
            usuario_id,
            roles_id
            )
                        ) engine=InnoDB;