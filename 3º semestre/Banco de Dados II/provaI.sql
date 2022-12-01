-- Resolva as seguintes questões (cole o código SQL como texto e envie). 
-- Considerando o banco de dados (bd2) disponível no moodle e usado em aula, faça as seguintes consultas: 
USE bd2;

CREATE USER 'professor'@'localhost' IDENTIFIED BY 'roboto';
GRANT SELECT,INSERT ON bd2.empresa TO 'professor'@'localhost';

SHOW GRANTS FOR 'professor'@'localhost';
DROP USER 'professor'@'localhost';

-- 1 ** ---------------------------------------------------------------------------------------------------
-- 		selecione todos os funcionários que tenham Salário menor que 1500 e que tenham um chefe com salário maior que 1500. 
--  	Faça 2 consultas, uma com o uso de subconsultas e outra sem o uso de subconsultas.

-- s/ subconsultas
SELECT funcionario.nome, funcionario.salario, funcionario.setor_id
		FROM funcionario 
        INNER JOIN setor USING (setor_id) 
        WHERE funcionario.salario < 1500 OR (setor.chefe = funcionario.funcionario_id AND 
			  funcionario.salario > 1500) 
		ORDER BY salario DESC;

SELECT funcionario.salario, setor.setor_id FROM funcionario INNER JOIN setor USING (setor_id) WHERE funcionario.funcionario_id = setor.chefe ORDER BY funcionario.salario DESC;

-- c/ subconsulta

SELECT funcionario.nome, funcionario.salario
	FROM funcionario 
    WHERE funcionario.salario < 1500 OR 
		  ((SELECT setor.chefe FROM setor WHERE setor.chefe = funcionario.funcionario_id)  AND funcionario.salario < 1500)
	ORDER BY salario DESC;
    

-- 2 ** ----------------------------------------------------------------------------------------------------
-- Resolva as seguintes questões (cole o código SQL como texto e envie). 
-- Considerando o banco de dados (bd2) disponível no moodle e usado em aula, faça as seguintes consultas: 
-- 				Selecione o nome da empresa e a média salarial dos funcionários da empresa com id diferente de 2 
-- 				que estão apontados como sexo 
-- 				"masculino". Faça 2 consultas, uma com o uso de subconsultas e outra sem o uso de subconsultas.


SELECT empresa.nome, AVG(funcionario.salario) FROM empresa INNER JOIN funcionario, setor WHERE setor.setor_id = funcionario.setor_id AND empresa.empresa_id = setor.empresa_id AND funcionario.sexo = "masculino";

SELECT empresa.nome, (	SELECT AVG(funcionario.salario) 	
								FROM funcionario 
                                INNER JOIN setor USING(setor_id) 
                                WHERE setor.empresa_id = empresa.empresa_id AND
									  funcionario.sexo="masculino") AS média
	 FROM empresa ;
     
     
-- correção 

SELECT empresa.nome, AVG(funcionario.salario) 
	FROM empresa 
	JOIN setor USING (empresa_id ) 
    JOIN funcionario USING(setor_id) 
    WHERE empresa.empresa_id !=2 AND 
		  funcionario.sexo = "masculino"
	GROUP BY empresa.nome;

SELECT empresa.nome, (
		SELECT AVG(funcionario.salario) FROM funcionario WHERE
			funcionario.sexo = "masculino" AND
            funcionario.setor AND
            funcionario.setor_id IN (
				SELECT setor.setor_id FROM setor WHERE
                setor.setor_id = funcionario.setor_id AND
                setor.empresa_id = empresa.empresa_id AND 
                setor.empresa_id is not NULL
            )
		) FROM empresa WHERE empresa.empresa != 2;
            
-- 3 ** --------------------------------------------------------------------------------------------------------
-- Selecione os funcionários que não são chefes e que estão em setor de andar 0 que ganham entre 1300 e 1500, 
-- ordenando pela ordem alfabética.  Resolva a questão e entregue as strings SQL sem e com subconsultas.


SELECT funcionario.nome, funcionario.salario 
	FROM funcionario 
    LEFT JOIN setor 
    USING(setor_id) 
    WHERE (salario >= 1300 AND salario <= 1500) AND 
		  (funcionario.funcionario_id != setor.chefe) AND
          setor.andar = 0 ORDER BY funcionario.nome;
          
SELECT * FROM setor;



-- c/ subconsultas

SELECT funcionario.nome, funcionario.salario 
	FROM funcionario 
    WHERE funcionario.funcionario_id != ( SELECT setor.chefe FROM setor WHERE setor.setor_id = funcionario.setor_id) AND 
		  0 = (SELECT setor.andar FROM setor WHERE setor.setor_id = funcionario.setor_id) AND 
          funcionario.salario >= 1300 AND funcionario.salario <= 1500
	ORDER BY funcionario.nome;
    
-- correção
SELECT funcionario.nome 
	FROM funcionario 
    JOIN setor 
    ON funcionario.funcionario_id != setor.chefe AND 
	   setor.chefe is not NULL and setor.andar = 0 AND 
	   funcionario.salario > 1300 and funcionario.salario < 1500 ORDER by funcionario.nome;

-- SELECT funcionario.nome FROM funcionario WHERE funcionario.salario > 1300 AND funcionario.salario < 1500 AND funcionario.funcionario_id NOT IN(
-- 	SELECT chefe FROM setor WHERE chefe;
-- ----------------------------
-- 4 **
-- Crie uma visão (VIEW) para o banco db2 que contenha o nome da empresa, e nome dos setor que possuam média salarial maior que 1200.
--  Faça uma consulta para exibir todos os dados da view.

SELECT empresa.nome AS empresa, setor.nome AS setor, (SELECT AVG(funcionario.salario) 
										 FROM funcionario 
                                         LEFT JOIN setor AS setorSub USING(setor_id) 
                                         WHERE setor.setor_id = setorSub.setor_id) AS media 
	  FROM empresa 
      INNER JOIN setor 
      WHERE setor.empresa_id = empresa.empresa_id 
      HAVING media > 1200;
      
-- -------------------------------------------------------------------------------------------------------------

CREATE VIEW questao4 AS SELECT empresa.nome AS empresa, setor.nome AS setor, (SELECT AVG(funcionario.salario) 
										 FROM funcionario 
                                         LEFT JOIN setor AS setorSub USING(setor_id) 
                                         WHERE setor.setor_id = setorSub.setor_id) AS media 
	  FROM empresa 
      INNER JOIN setor 
      WHERE setor.empresa_id = empresa.empresa_id 
      HAVING media > 1200;
      
SELECT * FROM questao4;


-- 5 ** -----------------------------------------------------------------------------------------------------------
-- Crie uma visão (VIEW) com o nome do setor, o andar e o id do setor. Atualize os dados da VIEW, 
-- mudando o andar de cada setor para 1 andar acima se o andar for diferente de 0. Faça uma consulta na view criada e 
-- outra consulta na tabela funcionários para ver todos os dados.

SELECT setor.nome as NOME, setor.andar as ANDAR, setor.setor_id as ID FROM setor ORDER BY ANDAR;

CREATE VIEW questao5 AS SELECT setor.nome as NOME, setor.andar as ANDAR, setor.setor_id as ID FROM setor;

DROP VIEW questao5;

SELECT * FROM questao5 ORDER BY ANDAR;

UPDATE questao5 SET ANDAR = ANDAR+1 WHERE ANDAR != 0;

SELECT * FROM questao5 ORDER BY ANDAR;
SELECT setor.nome as NOME, setor.andar as ANDAR, setor.setor_id as ID FROM setor ORDER BY ANDAR;