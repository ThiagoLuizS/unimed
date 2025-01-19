create table if not exists tb_pedido (
    id int auto_increment primary key not null,
    cliente_id int not null,
    data_criacao datetime not null,
    status varchar(100) not null
);

alter table tb_pedido
    ADD CONSTRAINT tb_pedido_cliente_fkey FOREIGN KEY (cliente_id) REFERENCES tb_cliente (id);