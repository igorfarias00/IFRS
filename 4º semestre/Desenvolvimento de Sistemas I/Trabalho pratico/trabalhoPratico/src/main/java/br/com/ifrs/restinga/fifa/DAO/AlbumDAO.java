// PROGRAMA DESENVOLVIDO PELO ALUNO IGOR BALEST FARIAS
// Disciplina: Dev I
// Trabalho final

package br.com.ifrs.restinga.fifa.DAO;

import br.com.ifrs.restinga.fifa.model.Album;
import br.com.ifrs.restinga.fifa.model.Cromo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumDAO extends GenericCrudRepository<Album, Long>{

    // Item C
    // I
    List<Album> findByNomeContainingOrderByNome(String nome);

    // II
    List<Album> findByPaisSedeContainingOrderByPaisSede(String pais);

    // III
    List<Album> findAlbumByAnoAfter(int ano);

    // IV
    List<Album> findAlbumByCromosEspeciaisAfter(int quantidade);

    // V
    @Query("SELECT o FROM Album e JOIN e.listaDeCromos o WHERE o.raro = true")
    List<Cromo> findByCromoIsRaro();

    // VI
    @Query("SELECT o FROM Album e JOIN e.listaDeCromos o WHERE o.selecao  like %:selecao% ORDER BY o.nome DESC")
    List<Cromo> findByCromoWhereSelecaoContainingDesc(@Param("selecao") String selecao);

    // VII
    @Query("SELECT o FROM Album e JOIN e.listaDeCromos o WHERE o.posicao = :posicao ORDER BY o.nome DESC")
    List<Cromo> findByCromoWherePosicaoDesc(@Param("posicao") String posicao);

    // VIII
    @Query("SELECT o FROM Album e JOIN e.listaDeCromos o WHERE o.posicao = :posicao AND o.selecao = :selecao ORDER BY o.selecao DESC")
    List<Cromo> findByCromoWherePosicaoAndSelecaoDesc(@Param("posicao") String posicao, @Param("selecao") String selecao);

    // extra
    @Query("SELECT o FROM Album e JOIN e.listaDeCromos o WHERE o.nome  like %:nome%")
    List<Cromo> findByCromoContaining(@Param("nome") String nome);



}
