// PROGRAMA DESENVOLVIDO PELO ALUNO IGOR BALEST FARIAS
// Disciplina: Dev I
// Trabalho final

package br.com.ifrs.restinga.fifa.DAO;

import br.com.ifrs.restinga.fifa.model.Album;
import br.com.ifrs.restinga.fifa.model.Cromo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface CromoDAO extends GenericCrudRepository<Cromo, Long>{
    // Item D
    // I
    @Query("SELECT o FROM Album e JOIN e.listaDeCromos o WHERE o.album = :album")
    List<Cromo> getCromosByAlbum(@Param("album") Album album);

    // II
    @Query("SELECT o FROM Album e JOIN e.listaDeCromos o WHERE o.album = :album AND o.selecao = :selecao")
    List<Cromo> getCromosByAlbumAndSelecao(@Param("album") Album album, @Param("selecao") String selecao);

    // III
    @Query("SELECT e FROM Album e WHERE  :cromo MEMBER OF e.listaDeCromos")
    Album getAlbumByCromo(@Param("cromo") Cromo cromo);

}
