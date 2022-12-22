USE bd2;

SELECT * FROM setor;

START TRANSACTION;

UPDATE funcionario SET nome = 'Roben C. Lunardi' WHERE funcionario_id = 82 ;

