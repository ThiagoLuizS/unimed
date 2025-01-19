create table if not exists tb_produto (
    id int auto_increment primary key not null,
    nome varchar(100) not null,
    preco decimal(10,2) not null
);