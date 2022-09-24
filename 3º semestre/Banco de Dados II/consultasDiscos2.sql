USE discos2;

#SELECT nome FROM gravadora;
#SELECT nome FROM album;
#SELECT nome FROM musica;
#SELECT data_producao FROM disco;

#SELECT * FROM disco JOIN gravadora WHERE disco.gravadora_id=gravadora.gravadora_id;

#SELECT musica.nome, album.nome, album.banda FROM musica JOIN album WHERE musica.album_id=album.album_id;
-- apresentar todos os nomes de gravadoras

-- mostrar todos os discos da gravador

-- mostrar todas as musicas  e seus respectivos da gravadora atlantic
#SELECT musica.nome, album.nome, album.banda, gravadora.nome FROM musica 
#	JOIN album, gravadora 
#    WHERE musica.album_id = album.album_id 
#		AND gravadora.gravadora_id = album.gravadora_id 
#       AND album.gravadora_id=1;

# todas as musicas do estilo rock


#SELECT musica.nome, album.nome, album.banda, album.estilo 
#	FROM musica 
#    JOIN album 
#    WHERE album.estilo LIKE 'Rock' 
#		AND musica.album_id = album.album_id ;

#SELECT musica.nome, album.nome, album.banda, album.estilo FROM musica JOIN album Where musica.album_id = album.album_id;

# concatenar a musica com o album e Ordenar pela forma ascendente 

#SELECT CONCAT(album.nome, " - ", musica.nome) FROM musica JOIN album WHERE musica.album_id = album.album_id ORDER BY album.nome, musica.nome ASC;

SELECT CONCAT(album.nome, " - ", musica.nome) FROM musica 
	JOIN album 
	USING (album_id) 
	ORDER BY album.nome;