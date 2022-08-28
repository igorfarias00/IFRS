USE diarioDeClasse;

#INSERT INTO endereco(id, logradouro, bairro, cep, cidade) VALUE(12, "Avenida das dores", "vinhedo", 95112, "viamao");
#INSERT INTO Telefone(id, telefones) VALUE(33, 85123546);

DELETE FROM professor WHERE id > 0;

SELECT * FROM endereco;
SELECT * FROM Telefone;
SELECT * FROM professor;