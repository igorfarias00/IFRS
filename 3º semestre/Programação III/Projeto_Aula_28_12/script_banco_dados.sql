create database tabajara;
use tabajara;
create table clientes (
  cpf varchar(11) not null,
  nome varchar(100) not null,
  telefone varchar(13),
  endereco text,
  primary key (cpf)
);
select * from clientes;