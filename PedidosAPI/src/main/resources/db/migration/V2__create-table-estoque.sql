CREATE TABLE estoque (
id_produto bigint unique,
quantidade int,

CONSTRAINT fk_prodEstoque FOREIGN KEY (id_produto) REFERENCES catalogo_produtos (id)
);