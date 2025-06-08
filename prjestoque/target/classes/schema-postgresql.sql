CREATE TABLE IF NOT EXISTS produto(
    id serial PRIMARY KEY,
    nome varchar(100),
    valor float,
    categoria varchar(100),
    quantidade int
);