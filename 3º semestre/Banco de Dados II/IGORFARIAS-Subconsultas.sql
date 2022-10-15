-- Gerem consultas com e sem subconsultas para as seguintes solicitações:

-- 1 - Selecione os funcionários de setores que não possuam chefe. 
-- 2 - Selecione o nome dos funcionários (deve ser chamado de NomeDoFuncionario) e nome do setor (deve ser chamado de NomeDoSetor) que sejam apenas dos setores 3 ou 4. 
-- 3 - Selecione o nome dos funcionários (deve ser chamado de NomeDoFuncionario), salário do funcionário  (deve ser chamado de Salário), e nome do setor (deve ser chamado de NomeDoSetor) que sejam apenas dos setores 3 ou 4 ordenados pelo salário em cada setor. 
-- 4 - Liste todos os nomes de chefe de setor (Chefe), o respectivo nome do setor (Setor), o salario (Salário) e o nome da empresa (Empresa), ordenados pelo salário (do maior para o menor).


-- P.S.: consultas comentadas foram trabalhadas em aula

USE bd2;
-- 1ª consulta

-- SELECT * FROM funcionario WHERE  EXISTS (
-- 	SELECT setor.setor_id FROM setor WHERE chefe IS NULL AND setor.setor_id = funcionario.setor_id
-- );

-- SELECT * FROM funcionario JOIN setor on setor.setor_id = funcionario.funcionario_id AND setor.setor_id IS NULL;


-- SELECT * FROM funcionario LEFT JOIN setor on setor.setor_id = funcionario.funcionario_id AND setor.setor_id IS NULL AND funcionario.setor_id IS NULL;


(SELECT * FROM funcionario WHERE EXISTS(SELECT funcionario.setor_id WHERE funcionario.setor_id IS NULL)) 
UNION 
( SELECT * FROM funcionario WHERE EXISTS(SELECT setor.setor_id FROM setor WHERE chefe IS NULL AND setor.setor_id = funcionario.setor_id));

-- ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨

-- sem subconsultas



-- ----------------------------------------------------------------------------------------

-- 2ª consulta - Selecione o nome dos funcionários (deve ser chamado de NomeDoFuncionario) 
--               e nome do setor (deve ser chamado de NomeDoSetor) 
--               que sejam apenas dos setores 3 ou 4. 


-- com subconsulta
SELECT nome as NomeDoFuncionario, 
	   (SELECT nome FROM setor WHERE funcionario.setor_id=setor.setor_id) as NomeDoSetor 
       FROM funcionario 
       WHERE (setor_id=3 OR setor_id=4);
       
-- SELECT funcionario.nome AS NomeDoFuncionario,
--		  ( SELECT setor.nome 
--				FROM setor 
--				WHERE funcionario.setor_id = setor.setor_id AND (setor.setor_id =3 OR setor.setor_id = 4) as NomeDoSetor,
--        FROM funcionario;

-- ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨

-- sem subconsulta
SELECT funcionario.nome as NomeDoFuncionario, 
	   setor.nome AS NomeDoSetor 
       FROM funcionario 
       JOIN setor 
       WHERE funcionario.setor_id=setor.setor_id AND setor.setor_id IN (3,4);

-- SELECT funcionario.nome AS NomeDoFuncionario,
--        setor.nome AS NomeDoSetor,
--        FROM setor JOIN funcionariio USING(setor_id)
--        WHERE funcionario.setor_id = 3 OR funcionario.setor_id =4;
          
-- ---------------------------------------------------

-- 3ª consulta - Selecione o nome dos funcionários (deve ser chamado de NomeDoFuncionario), 
--                           salário do funcionário  (deve ser chamado de Salário), 
--                           e nome do setor (deve ser chamado de NomeDoSetor) 
--                           que sejam apenas dos setores 3 ou 4 ordenados pelo salário em cada setor. 

-- com subconsultas
SELECT nome as NomeDoFuncionario, 
	   salario,
	   (SELECT nome 
			FROM setor 
            WHERE funcionario.setor_id = setor.setor_id 
					AND setor_id IN (3,4) ) as NomeDoSetor
	   FROM funcionario 
       WHERE funcionario.setor_id IN (3,4) 
       ORDER BY NomeDoSetor, salario DESC;

-- sem subconsultas
SELECT funcionario.nome as NomeDoFuncionario, 
	   funcionario.salario,
       setor.nome as NomeDoSetor
       FROM funcionario
       JOIN setor 
       WHERE setor.setor_id = funcionario.setor_id 
			 AND setor.setor_id IN (3,4) 
       ORDER BY setor.nome, salario DESC;
       
       
-- ------------------------------------------------------------------------------------------------

-- 4ª consulta - - Liste todos os nomes de chefe de setor (Chefe), 
--                 o respectivo nome do setor (Setor), 
--                 o salario (Salário) e o nome da empresa (Empresa), ordenados pelo salário (do maior para o menor).

-- com subconsultas
SELECT nome AS Chefe,
	(SELECT setor.nome FROM setor WHERE setor.chefe = funcionario.funcionario_id) AS Setor,
    salario,
    (SELECT empresa.nome 
		FROM empresa 
		WHERE empresa_id = (SELECT setor.empresa_id 
										FROM setor 
                                        WHERE setor.chefe = funcionario.funcionario_id )) AS Empresa
	FROM funcionario 
    WHERE funcionario.funcionario_id = (SELECT setor.chefe 
											   FROM setor 
                                               WHERE setor.chefe = funcionario.funcionario_id 
													 AND setor.empresa_id IS NOT NULL) 
	ORDER BY salario DESC;

-- SELECT setor.nome, funcionario.nome FROM setor JOIN funcionario WHERE funcionario.funcionario_id = setor.chefe; -- d

-- sem subconsultas
SELECT funcionario.nome as Chefe, 
	   setor.nome as Setor, 
	   funcionario.salario, 
       empresa.nome as Empresa  
       FROM funcionario
       JOIN setor ON (funcionario.funcionario_id = setor.chefe)
       JOIN empresa ON ( setor.empresa_id = empresa.empresa_id)
	   ORDER BY salario DESC;


SELECT funcionario.nome as Chefe,
	   setor.nome as Setor,
       funcionario.salario,
       empresa.nome as Empresa
       FROM setor 
       JOIN funcionario 
			ON(funcionario.funcionario_id = setor.chefe)
	   JOIN empresa
			ON(setor.empresa_id = empresa.empresa_id)
		ORDER BY salario DESC;
        
-- ###############################################################################################

-- resoluções da Lista 1 - Agora com subconsultas

--  1) Liste todas as empresas que tenham "filial" no nome
--  2) Liste todos os funcionários com o seu setor, formando um campo neste formato: "A funcionária {nome} pertence ao 
-- setor: {setor}" ou "O funcionário {nome} pertence ao setor: {setor}", dependendo do sexo.
--  3) Liste todos os setores, exibindo o nome do chefe, caso o tenha
--  4) Liste todas as empresas, seus setores e funcionários, incluindo as empresas que não têm setor e setores que não
-- tenham funcionários
--  5) Liste todos os setores que não tenham funcionários
--  6) Liste todos os chefes e seus salários
--  7) Liste os 3 funcionários com maior salário
--  8) Liste os 3 funcionários com menor salário
--  9) Liste o homem com o maior salário
--  10) Liste a mulher com o maior salário

-- ---------------------------------------------------------------------------
-- 1) Liste todas as empresas que tenham "filial" no nome

SELECT nome FROM empresa;

-- ---------------------------------------------------------------------------
-- 2) Liste todos os funcionários com o seu setor, formando um campo neste formato: "A funcionária {nome} pertence ao 
-- setor: {setor}" ou "O funcionário {nome} pertence ao setor: {setor}", dependendo do sexo.

SELECT IF(sexo = 'Masculino',
		  (CONCAT("O funcionario ",nome) , CONCAT(" pertence ao setor: ",(SELECT setor.nome FROM setor WHERE setor.setor_id = funcionario.setor_id))),
          nome) FROM funcionario;

