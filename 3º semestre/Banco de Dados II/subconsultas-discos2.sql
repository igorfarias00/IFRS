use discos2;

INSERT INTO album VALUES (
    "The Game",
    "The Queen"
    "Rock"
);

SELECT * FROM album;
SELECT * FROM disco;
SELECT * FROM gravadora;
SELECT * FROM musica;

SELECT nome, banda FROM album WHERE EXISTS(SELECT * FROM disco WHERE data_producao LIKE '1969%' AND disco.album_id = album.album_id);
