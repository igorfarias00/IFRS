#DROP DATABASE diarioDeClasse;
Create database diarioDeClasse;
USE diarioDeClasse;
CREATE TABLE Endereco(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
logradouro VARCHAR(40) NOT NULL,
bairro VARCHAR(30) NOT NULL,
cep INT NOT NULL,
cidade VARCHAR(30) NOT NULL
);
CREATE TABLE Telefone(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
telefones INT NOT NULL
);
CREATE TABLE DiasDaSemana(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
diasDeAula DATETIME
);
CREATE TABLE MesReferencia(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
mes INT NOT NULL,
totalDeDias INT NOT NULL
);
CREATE TABLE Professor(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
matricula INT NOT NULL,
numero INT NOT NULL,
complemento VARCHAR(45),
salario DOUBLE,
nivel_formacao VARCHAR(40),
coordenador BOOLEAN NOT NULL,
Endereco_id INT,
Telefone_id INT,
FOREIGN KEY(Endereco_id) REFERENCES Endereco(id),
FOREIGN KEY(Telefone_id) REFERENCES Telefone(id)
);
CREATE TABLE Curso(
codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
sigla VARCHAR(5),
nome VARCHAR(30),
Professor_id INT,
FOREIGN KEY(Professor_id) REFERENCES Professor(id)
);
CREATE TABLE Turma(
codigo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
percentual_infrequencia INT,
nome_turma VARCHAR(45) NOT NULL,
quant_periodos INT,
turno_aula VARCHAR(40),
Curso_codigo INT,
Professor_id INT,
MesReferencia_id INT,
FOREIGN KEY(Curso_codigo) REFERENCES Curso(codigo),
FOREIGN KEY(Professor_id) REFERENCES Professor(id),
FOREIGN KEY(MesReferencia_id) REFERENCES MesReferencia(id)
);
CREATE TABLE Turma_Dia(
turmaCodigo int,
diaId int,
PRIMARY KEY (turmaCodigo, diaId),
FOREIGN KEY (turmaCodigo) REFERENCES Turma(codigo),
FOREIGN KEY (diaId) REFERENCES DiasDaSemana(id)
);
CREATE TABLE Aluno(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
percentual_infrequencia INT,
frequencia INT,
cpf VARCHAR(11) NOT NULL,
rg VARCHAR(10) NOT NULL,
orgao_emissor VARCHAR(40),
numero INT NOT NULL,
complemento VARCHAR(40),
Endereco_id INT,
Telefone_id INT,
MesReferencia_id INT,
FOREIGN KEY(Endereco_id) REFERENCES Endereco(id),
FOREIGN KEY(Telefone_id) REFERENCES Telefone(id),
FOREIGN KEY(MesReferencia_id) REFERENCES MesReferencia(id)
);
CREATE TABLE Turma_Aluno(
turmaCodigo int,
alunoId int,
PRIMARY KEY (turmaCodigo, alunoId),
FOREIGN KEY (turmaCodigo) REFERENCES Turma(codigo),
FOREIGN KEY (alunoId) REFERENCES Aluno(id)
);