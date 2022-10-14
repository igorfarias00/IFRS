-- Gerem consultas com e sem subconsultas para as seguintes solicitações:

-- 1 - Selecione os funcionários de setores que não possuam chefe. 
-- 2 - Selecione o nome dos funcionários (deve ser chamado de NomeDoFuncionario) e nome do setor (deve ser chamado de NomeDoSetor) que sejam apenas dos setores 3 ou 4. 
-- 3 - Selecione o nome dos funcionários (deve ser chamado de NomeDoFuncionario), salário do funcionário  (deve ser chamado de Salário), e nome do setor (deve ser chamado de NomeDoSetor) que sejam apenas dos setores 3 ou 4 ordenados pelo salário em cada setor. 
-- 4 - Liste todos os nomes de chefe de setor (Chefe), o respectivo nome do setor (Setor), o salario (Salário) e o nome da empresa (Empresa), ordenados pelo salário (do maior para o menor).


-- P.S.: consultas comentadas foram trabalhadas em aula

USE bd2;

-- SELECT * FROM funcionario WHERE  EXISTS (
-- 	SELECT setor.setor_id FROM setor WHERE chefe IS NULL AND setor.setor_id = funcionario.setor_id
-- );

-- SELECT * FROM funcionario JOIN setor on setor.setor_id = funcionario.funcionario_id AND setor.setor_id IS NULL;


-- SELECT * FROM funcionario LEFT JOIN setor on setor.setor_id = funcionario.funcionario_id AND setor.setor_id IS NULL AND funcionario.setor_id IS NULL;

-- 1ª consulta
(SELECT * FROM funcionario WHERE EXISTS(SELECT funcionario.setor_id WHERE funcionario.setor_id IS NULL)) 
UNION 
( SELECT * FROM funcionario WHERE EXISTS(SELECT setor.setor_id FROM setor WHERE chefe IS NULL AND setor.setor_id = funcionario.setor_id));


-- 2ª consulta
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
		WHERE empresa.empresa_id = (SELECT setor.empresa_id 
										FROM setor 
                                        WHERE setor.chefe = funcionario.funcionario_id)) AS Empresa
	FROM funcionario 
    WHERE funcionario.funcionario_id = (SELECT setor.chefe 
											   FROM setor 
                                               WHERE setor.chefe = funcionario.funcionario_id) 
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
       
-- SELECT * FROM setor; -- d

