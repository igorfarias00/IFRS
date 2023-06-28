CREATE USER Aluno identified by 'BancoDeDados2';
GRANT SELECT,INSERT,UPDATE ON bd2.* TO 'Aluno'@'%';
GRANT SELECT,INSERT,UPDATE ON discos2.gravadora TO 'Aluno'@'%';
ALTER USER 'Aluno'@'%' WITH MAX_USER_CONNECTIONS 2;

SHOW GRANTS FOR 'Aluno';


use bd2;

CREATE TABLE antigo_chefe(
	id int AUTO_INCREMENT PRIMARY KEY,
	chefe varchar(30),
    andar int
);

CREATE TRIGGER antigo_chefe
AFTER UPDATE ON setor
FOR EACH ROW
INSERT INTO
antigo_chefe(chefe, andar)
VALUES(OLD.chefe, OLD.andar);

DROP TRIGGER antigo_chefe;

SELECT * FROM setor;
SELECT * FROM antigo_chefe;

SELECT * FROM empresa WHERE cnpj = '123456-0002';


SELECT 	chefe from setor where (
		(select funcionario.funcionario_id from funcionario 

		where funcionario_id = setor.chefe) AS chefe,

        setor.nome as Setor, 

        MAX((select AVG(salario) from funcionario 

        where funcionario.setor_id = setor.setor_id)) AS salario,

        (select nome from empresa 

        where empresa.cnpj = '123456-0002') AS empresa

        from setor 

        WHERE setor.chefe is NOT NULL

        order by salario DESC;
        
        
        
UPDATE setor SET chefe = 2 WHERE chefe = (SELECT (select funcionario.funcionario_id from funcionario 

		where funcionario_id = setor.chefe) AS chefe,

        setor.nome as Setor, 

        MAX((select AVG(salario) from funcionario 

        where funcionario.setor_id = setor.setor_id)) AS salario,

        (select nome from empresa 

        where empresa.cnpj = '123456-0002') AS empresa

        from setor 

        WHERE setor.chefe is NOT NULL

        order by salario DESC) COLUMN chefe;

UPDATE setor SET chefe = 10 WHERE setor.setor_id = 1;


START TRANSACTION;
INSERT INTO empresa(nome,cnpj) VALUES (
	"rodolfo armações", 12423525
);


INSERT INTO setor(empresa_id,nome,andar) VALUES (6, "almoxarifado", 0);

UPDATE setor SET chefe = 3 WHERE setor_id = 3 OR setor_id = 2 OR setor_id = 1;

COMMIT;

SELECT * FROM empresa WHERE cnpj = 12423525;
SELECT * FROM setor where empresa_id = 6;