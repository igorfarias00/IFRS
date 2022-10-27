use bd2;

SHOW FULL TABLES WHERE table_type= 'VIEW';

CREATE VIEW setor_chefe AS SELECT setor.setor_id, 
								  setor.empresa_id, 
								  setor.nome, 
                                  setor.andar, 
                                  funcionario.nome AS chefe 
	FROM setor 
    LEFT JOIN funcionario ON(setor.chefe=funcionario.funcionario_id);
    
-- nao atualizavel, pois possui um left join. 
-- UPDATE setor_chefe SET chefe = 'Isabela Costa Martins' WHERE setor_id = 1;
    
SELECT * FROM setor_chefe;



-- ---------------------------------------------------------
-- 2º exemplo ----------------------------------------------
CREATE VIEW funcionario_base AS SELECT funcionario_id, 
									   setor_id, 
                                       nome, 
                                       nascimento, 
                                       sexo 
	FROM funcionario;
   
SELECT * FROM funcionario; 
  
SELECT * FROM funcionario_base;

UPDATE funcionario_base SET nome = 'Isabela Costa Martins' WHERE funcionario_base.funcionario_id=5;

SELECT * FROM funcionario; 
  
SELECT * FROM funcionario_base;