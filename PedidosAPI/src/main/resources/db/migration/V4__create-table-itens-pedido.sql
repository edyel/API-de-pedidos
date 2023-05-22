CREATE TABLE itens_pedido(
id bigint not null auto_increment,
preco_unidade decimal not null,
quantidade int,
produto_id bigint,
pedido_id bigint,

primary key(id),
CONSTRAINT fk_prodPedido FOREIGN KEY (produto_id) REFERENCES catalogo_produtos (id),
CONSTRAINT fk_ItensPedidos FOREIGN KEY (pedido_id) REFERENCES pedidos (id)
);