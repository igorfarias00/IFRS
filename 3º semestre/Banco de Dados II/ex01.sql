USE bd2;

#1
SELECT * FROM empresa WHERE nome LIKE "%Filial%";

#2
SELECT CONCAT(IF(sexo="feminino", "A funcionária " , "O funcionário "),  funcionario.nome, 
				" pertence ao setor:", setor.nome ) 
	FROM funcionario LEFT JOIN setor using(setor_id);

#3
SELECT setor.nome, funcionario.nome FROM setor INNER JOIN funcionario ON(setor.chefe=funcionario.funcionario_id);

#4
SELECT empresa.nome, setor.nome, funcionario.nome FROM empresa JOIN setor, funcionario WHERE empresa.empresa_id = setor.empresa_id AND setor.setor_id = funcionario.setor_id;

#5
SELECT * FROM setor JOIN funcionario on funcionario.setor_id=setor.setor_id WHERE funcionario.setor_id="null"; 

#6
SELECT funcionario.funcionario_id, setor.chefe, funcionario.nome, funcionario.salario FROM funcionario RIGHT JOIN setor on setor.chefe=funcionario.funcionario_id;

#7
SELECT nome, salario FROM funcionario ORDER BY salario DESC LIMIT 3;

SELECT nome, salario FROM funcionario ORDER BY salario ASC LIMIT 3; 

SELECT nome, salario FROM funcionario WHERE sexo="masculino" ORDER BY salario DESC LIMIT 1;
SELECT nome, salario FROM funcionario WHERE sexo="feminino" ORDER BY salario DESC LIMIT 1;

