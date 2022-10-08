use bd2;

SELECT setor.nome FROM setor WHERE EXISTS(
	SELECT * FROM funcionario 
		WHERE setor.setor_id = funcionario.setor_id
			AND funcionario.salario >= 1700
);

SELECT *  FROM setor WHERE NOT EXISTS(
	SELECT * FROM funcionario 
		WHERE setor.setor_id = funcionario.setor_id
			AND funcionario.salario > 1700 
);

-- o nome dos funcionarios que sao chefe
SELECT funcionario.nome FROM funcionario WHERE funcionario.funcionario_id IN (
	SELECT chefe FROM setor
);	


SELECT funcionario.nome FROM funcionario WHERE funcionario.funcionario_id NOT IN (
	SELECT chefe FROM setor WHERE chefe IS NOT NULL
);

-- Retorna os funcionarios que ganham mais que todos os funcionarios do setor 2
SELECT funcionario.nome FROM funcionario WHERE funcionario.salario >ALL(
	SELECT salario FROM funcionario WHERE setor_id = 2
);

SELECT funcionario.nome FROM funcionario WHERE funcionario.salario >ANY(
	SELECT salario FROM funcionario WHERE funcionario.setor_id=2
);

SELECT funcionario.nome FROM funcionario WHERE funcionario.nascimento = (
	SELECT MAX(funcionario.nascimento) FROM funcionario
);

SELECT setor.setor_id, (
	SELECT funcionario.nome FROM funcionario WHERE funcionario.setor_id = setor.setor_id ORDER BY salario DESC LIMIT 1 
) FROM setor;


SELECT funcionario.nome, (
	SELECT setor.nome FROM setor WHERE setor.setor_id = funcionario.setor_id 
) FROM funcionario ORDER BY funcionario.setor_id;

SELECT funcionario.nome, IF(EXISTS(
	SELECT * FROM setor WHERE funcionario.funcionario_id = setor.chefe
), "CHEFINHO", "subalterno") FROM funcionario;

SELECT funcionario.nome, setor.chefe FROM funcionario INNER JOIN setor WHERE setor.chefe = funcionario.funcionario_id;


(SELECT * FROM funcionario WHERE funcionario.setor_id=2) UNION (SELECT * FROM funcionario WHERE funcionario.setor_id=3);

(SELECT empresa.nome, empresa.empresa_id FROM empresa) UNION (SELECT setor.nome, setor.setor_id FROM setor);

