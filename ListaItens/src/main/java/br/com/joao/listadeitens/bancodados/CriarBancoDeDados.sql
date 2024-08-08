create schema if not exists biblioteca_itens;
create table if not exists itens(id INT, nome VARCHAR(50), descricao VARCHAR(200), quantidade DECIMAL(10,2),Primary key(id));
 
