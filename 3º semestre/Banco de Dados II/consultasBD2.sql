USE bd2;

#DESCRIBE empresa;
#DESCRIBE funcionario;
#DESCRIBE setor;

#SELECT * FROM empresa;
#SELECT * FROM funcionario;
#SELECT * FROM setor;

#testar o que aconetece em um teste logico (<=>) se ambos forem NULL 
#SELECT nome, salario FROM funcionario WHERE(sexo="masculino");
#SELECT CONCAT(IF(sexo="feminino", "Prezada ", "Prezado "), nome), salario FROM funcionario;

#SELECT * FROM funcionario JOIN empresa, setor;
#SELECT * FROM empresa JOIN setor USING (empresa_id);
#SELECT * FROM empresa JOIN setor ON (empresa.empresa_id=setor.empresa_id);

#SELECT * FROM funcionario LEFT JOIN setor USING (nome) ;
#SELECT * FROM funcionario RIGHT JOIN setor USING (setor_id);
#SELECT * FROM funcionario JOIN setor USING(setor_id);

#SELECT * FROM funcionario ORDER BY salario DESC;
#SELECT * FROM funcionario ORDER BY salario ASC;


#SELECT SUM(salario) FROM funcionario;
#SELECT COUNT(salario) FROM funcionario;
#SELECT AVG(salario) FROM funcionario;
#SELECT MAX(salario) FROM funcionario;
#SELECT MIN(salario) FROM funcionario;

#Fazer analise 
SELECT sexo, AVG(salario) FROM funcionario GROUP BY sexo;

