create table catalogo_produtos(
id bigint not null auto_increment,
nome varchar(100) not null,
valor decimal not null,
descricao varchar(200) not null,
categoria varchar(100) not null,

primary key(id)
);