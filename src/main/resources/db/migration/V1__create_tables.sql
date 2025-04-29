CREATE TABLE curso (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    carga_horaria INTEGER NOT NULL
);

CREATE TABLE aluno (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE inscricao (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    curso_id INTEGER NOT NULL,
    aluno_id INTEGER NOT NULL,
    data_inscricao DATE NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);