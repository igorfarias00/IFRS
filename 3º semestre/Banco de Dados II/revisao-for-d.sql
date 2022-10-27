-- SELECT >>>   <<<
-- 			 ^^^ colunas de retorno na tabela resultado

-- FROM >>>   <<<
--     	   ^^^ tableas que contem colunas que sejam usadas

-- WHERE >>>   <<<
--          ^^^ condição/filtro da consulta

-- SELECT __a__, __b__, __c__  FROM x O y WHERE  a > 50;

-- a  |  b  |  c  
-- 

use bd2;

SELECT funcionario.nome, funcionario.salario, funcionario.nascimento FROM funcionario WHERE funcionario.salario > 1000;

SELECT setor_id AS id, nome 
	FROM setor 
    WHERE andar > 1;


SELECT funcionario.nome, funcionario.nascimento, setor.nome 
	FROM funcionario 
    JOIN setor 
    WHERE funcionario.setor_id = setor.setor_id;

-- forma correta com desempenho melhor
SELECT funcionario.nome, funcionario.nascimento, setor.nome 
	FROM funcionario 
    JOIN setor
    ON (funcionario.setor_id = setor.setor_id);
-- diferenca entre on e where?
-- forma correta 2 com desempenho melhor

SELECT funcionario.nome, funcionario.nascimento, setor.nome
	FROM funcionario
    JOIN setor
    USING (setor_id);
-- using é utilizado quando há dois nomes de colunas iguais em duas tabelas diferentes, e esse campo será usada para a vinculação entre elas


-- exiba o nome do setor, o andar do setor e o nome do chefe do setor

SELECT setor.nome, setor.andar, funcionario.nome 
	FROM setor 
    JOIN funcionario 
    ON (setor.chefe = funcionario.funcionario_id);

