create table if not exists tb_item_pedido (
    id int auto_increment primary key not null,
    pedido_id int not null,
    produto_id int not null,
    quantidade int not null default 0
);

alter table tb_item_pedido
    ADD CONSTRAINT tb_item_pedido_pedido_fkey FOREIGN KEY (pedido_id) REFERENCES tb_pedido (id);

alter table tb_item_pedido
    ADD CONSTRAINT tb_item_pedido_produto_fkey FOREIGN KEY (produto_id) REFERENCES tb_produto (id);