create table if not exists tb_cliente (
    id int auto_increment primary key not null,
    nome varchar(100) not null,
    email varchar(100) not null
);