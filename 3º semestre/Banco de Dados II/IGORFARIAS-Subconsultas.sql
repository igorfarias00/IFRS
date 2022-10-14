-- Gerem consultas com e sem subconsultas para as seguintes solicitações:

-- Selecione os funcionários de setores que não possuam chefe. 
-- Selecione o nome dos funcionários (deve ser chamado de NomeDoFuncionario) e nome do setor (deve ser chamado de NomeDoSetor) que sejam apenas dos setores 3 ou 4. 
-- Selecione o nome dos funcionários (deve ser chamado de NomeDoFuncionario), salário do funcionário  (deve ser chamado de Salário), e nome do setor (deve ser chamado de NomeDoSetor) que sejam apenas dos setores 3 ou 4 ordenados pelo salário em cada setor. 
-- Liste todos os nomes de chefe de setor (Chefe), o respectivo nome do setor (Setor), o salario (Salário) e o nome da empresa (Empresa), ordenados pelo salário (do maior para o menor).
-- Envie o sql na página para conferência.

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
SELECT nome as NomeDoFuncionario, (SELECT nome FROM setor WHERE funcionario.setor_id=setor.setor_id) as NomeDoSetor FROM funcionario WHERE setor_id=3 OR setor_id=4;

-- sem subconsulta

-- 3ª consulta
SELECT nome as NomeDoFuncionario, 
		salario,
		(SELECT nome FROM setor WHERE funcionario.setor_id = setor.setor_id AND 
									  setor_id IN (3,4) AND 
                                      setor.nome IS NOT NULL) as NomeDoSetor 
		FROM funcionario ORDER BY  NomeDoSetor, salario DESC;


