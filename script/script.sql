CREATE DATABASE jogo;
USE jogo;

CREATE TABLE quiz (
	id_quiz INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    tema VARCHAR(255),
    PRIMARY KEY (id_quiz)
);

CREATE TABLE pergunta (
    id_pergunta INTEGER NOT NULL AUTO_INCREMENT,
    id_quiz INTEGER,
    numero INTEGER NOT NULL,
    descricao TEXT NOT NULL,
    valor_pontuacao INTEGER NOT NULL,
    PRIMARY KEY (id_pergunta),
    FOREIGN KEY (id_quiz) REFERENCES quiz(id_quiz)
);