create database calendweb;

use calendweb;

CREATE TABLE usuario (
  usu_id INTEGER AUTO_INCREMENT NOT NULL,
  usu_login VARCHAR(15) NOT NULL,
  usu_senha VARCHAR(20) NOT NULL,
  usu_nome VARCHAR(50) NOT NULL,
  usu_email VARCHAR(60) NOT NULL,
  usu_telefone VARCHAR(15),
  CONSTRAINT PRIMARY KEY (usu_id)
);

CREATE TABLE  evento (
  even_id INTEGER AUTO_INCREMENT NOT NULL,
  even_nome VARCHAR(30),
  even_local VARCHAR (50),
  even_descricao VARCHAR(150),
  even_hr_ini DATE,
  even_hr_fim DATE,
  even_id_usuario INTEGER NOT NULL,
  CONSTRAINT PRIMARY KEY (even_id)
);

ALTER TABLE evento ADD CONSTRAINT fk_id_usuario
FOREIGN KEY (even_id_usuario) REFERENCES usuario (usu_id);
