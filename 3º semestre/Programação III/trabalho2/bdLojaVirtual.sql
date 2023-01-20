CREATE database lojaVirtual;

CREATE TABLE usuarios (
	id int primary key not null auto_increment,
    nome varchar(100) not null,
    descricao text,
    unidade varchar(3),
    preco_unitario float
) ;

CREATE TABLE clientes (
	id int primary key not null auto_increment,
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

