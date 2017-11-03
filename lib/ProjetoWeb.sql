create database Projeto;

create table usuario(

id serial,
name varchar(100),
login varchar(20),
senha varchar(100),
email varchar(50),
endereco varchar(20),
telefone varchar(20),
foto varchar(100)
);

create table postagem(
	id serial,
	usuario_id integer,
	titulo varchar(20),
	texto varchar(300),
	imagem varchar(100)
);