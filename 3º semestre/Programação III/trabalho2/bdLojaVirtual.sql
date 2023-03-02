CREATE database lojaVirtual;
use lojavirtual;
drop table clientes, produtos;

CREATE TABLE produtos (
	produto_id int primary key not null auto_increment,
    nome varchar(100) not null,
    descricao text,
    unidade varchar(3),
    preco_unitario float
) ;

CREATE TABLE clientes (
	cliente_id int primary key not null auto_increment,
    nome VARCHAR(100),
    data_nascimento DATE,
    cpf VARCHAR (15),
    rg VARCHAR (15),
    orgao_emissor VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(20),
    whats TINYINT,
    logradouro VARCHAR(100),
    numero VARCHAR(20),
    bairro VARCHAR(45),
    cidade VARCHAR(45),
    estado VARCHAR(2)
);
DROP TABLE usuarios;
CREATE TABLE usuarios (
	cpf varchar(15) primary key not null,
    nome varchar(100),
    data_nascimento date,
    email varchar(45),
    telefone varchar(20),
    whats tinyint,
    username varchar(15),
    senha varchar (255)
);
drop table pedidos;
CREATE TABLE pedidos (
	numero int primary key auto_increment not null,
    data_emissao date,
    valor_frete float,
    data_entrega date,
    cliente_id int,
    CONSTRAINT fk_UsuarioPedido foreign key (cliente_id) REFERENCES clientes (cliente_id)
);

Create TABLE produtos_has_pedidos (
	produtos_id int,
    pedidos_numero int,
    quantidade int,
    preco_unitario float,
    unidade varchar(3),
    foreign key (produtos_id) REFERENCES produtos (produto_id),
    foreign key (pedidos_numero) REFERENCES pedidos (numero)
);
SELECT * FROM usuarios;
insert into usuarios(cpf, nome, data_nascimento) Values ("1", 'alberto', 21/01/2023);
insert into usuarios(cpf, nome, data_nascimento) Values ("2", 'beto', 21/01/2023);
insert into usuarios(cpf, nome, data_nascimento) Values ("3", 'carlos', 21/01/2023);
insert into usuarios(cpf, nome, data_nascimento) Values ("6", 'v', 21-01-2023);

insert into clientes(cliente_id, nome, data_nascimento) Values ("2", 'adamastor', 21/01/2023);
insert into clientes(cliente_id, nome, data_nascimento) Values ("1", 'daniel', 21/01/2023);
insert into clientes(cliente_id, nome, data_nascimento) Values ("3", 'rogeri', 21/01/2023);
insert into clientes(cliente_id, nome, data_nascimento) Values ("5", 'v', 21/01/2023);

insert into produtos(nome, descricao, unidade, preco_unitario) values ("leite","leite de mula", "lts", "1.99");

update usuarios SET nome="igor", data_nascimento= 01/10/1997, email="igor@balest", 
					telefone="999", username="asdas", senha="alagos" WHERE cpf="5";
