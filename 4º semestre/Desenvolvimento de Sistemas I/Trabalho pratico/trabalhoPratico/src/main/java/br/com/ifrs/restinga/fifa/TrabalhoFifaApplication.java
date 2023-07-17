// PROGRAMA DESENVOLVIDO PELO ALUNO IGOR BALEST FARIAS
// Disciplina: Dev I
// Trabalho final

package br.com.ifrs.restinga.fifa;

import br.com.ifrs.restinga.fifa.DAO.AlbumDAO;
import br.com.ifrs.restinga.fifa.DAO.CromoDAO;
import br.com.ifrs.restinga.fifa.model.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TrabalhoFifaApplication {

	@Autowired
	AlbumDAO albumDAO;

	@Autowired
	CromoDAO cromoDAO;




	public static void main(String[] args) {
		SpringApplication.run(TrabalhoFifaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialData(){
		return (args) -> {

			List<String> selecoes = new ArrayList<>();
			List<Cromo> cromos = new ArrayList<>();

			// adicionando selecoes
			selecoes.add("Brasil");
			selecoes.add("Alemanha");
			selecoes.add("Croacia");
			selecoes.add("Bélgica");
			selecoes.add("Arábia Saudita");
			selecoes.add("Argentina");

			// criando albuns
			Album album1 = new Album("Copa do Mundo de 2010", "Africa do sul", 2010, selecoes, "COPA FIFA");
			Album album2 = new Album("Copa do Mundo de 2014", "Brasil", 2014, selecoes, "COPA FIFA");
			Album album3 = new Album("Copa do Mundo feminina de 2014", "Brasil", 2014, selecoes, "COPA FIFA");
			Album album4 = new Album("Copa do Mundo de 2018", "Russia", 2018, selecoes, "COPA FIFA");
			Album album5 = new Album("Copa do Mundo de 2022", "Quatar", 2022, selecoes, "COPA FIFA");

			album1.setCromosEspeciais(25);
			album2.setCromosEspeciais(35);
			album3.setCromosEspeciais(25);
			album4.setCromosEspeciais(40);
			album5.setCromosEspeciais(45);


			// criando cromos
			Cromo fig1 = new Cromo(false,false, "1", "Luka Modric");
			fig1.setSelecao(selecoes.get(2));
			fig1.setPosicao("MEI");

			Cromo fig2 = new Cromo(true,true, "1", "Neymar JR.");
			fig2.setSelecao(selecoes.get(0));
			fig2.setPosicao("ATA");

			Cromo fig3 = new Cromo(true,true,"1", "Grafitti");
			fig3.setSelecao(selecoes.get(0));
			fig3.setPosicao("MEO");

			Cromo fig4 = new Cromo(true, true, "1", "Pato");
			fig4.setSelecao(selecoes.get(0));
			fig4.setPosicao("ATA");

			Cromo fig5 = new Cromo(true, true, "1","Thomas Müller");
			fig5.setSelecao(selecoes.get(1));
			fig5.setPosicao("MEI");

			Cromo fig6 = new Cromo(false, false, "1", "Matthias Ginter");
			fig6.setSelecao(selecoes.get(1));
			fig6.setPosicao("ZAG");

			Cromo fig7 = new Cromo(true, false, "1", "Leon Goretzka");
			fig7.setSelecao(selecoes.get(1));
			fig7.setPosicao("MCC");

			Cromo fig8 = new Cromo(false, true, "1", "İlkay Neyrindo soquenao Gündoğan");
			fig8.setSelecao(selecoes.get(1));
			fig8.setPosicao("MEI");

			Cromo fig9 = new Cromo(false,true, "1", "Josko Gvardiol");
			fig1.setSelecao(selecoes.get(2));
			fig1.setPosicao("ZAG");

			Cromo fig10 = new Cromo(false,false, "1", "Ivan Perisic");
			fig1.setSelecao(selecoes.get(2));
			fig1.setPosicao("MEI");

			Cromo fig11 = new Cromo(true,true, "1", "Romelu Lukaku");
			fig1.setSelecao(selecoes.get(3));
			fig1.setPosicao("ATA");

			Cromo fig12 = new Cromo(true,false, "1", "Thibaut Courtois");
			fig1.setSelecao(selecoes.get(3));
			fig1.setPosicao("GOL");

			Cromo fig13 = new Cromo(false,true, "1", "Kevin de Bruyne");
			fig1.setSelecao(selecoes.get(3));
			fig1.setPosicao("MEI");

			Cromo fig14 = new Cromo(true,true, "1", "Salem Al-Dawsari");
			fig1.setSelecao(selecoes.get(4));
			fig1.setPosicao("MEI");

			Cromo fig15 = new Cromo(true,false, "1", "Yasser Al-Shahrani");
			fig1.setSelecao(selecoes.get(4));
			fig1.setPosicao("ZAG");

			Cromo fig16 = new Cromo(true,true, "1", "Lionel Messi");
			fig1.setSelecao(selecoes.get(5));
			fig1.setPosicao("ATA");

			// setando o album ao qual a figurinha pertence
			fig1.setAlbum(album2);
			fig2.setAlbum(album2);
			fig3.setAlbum(album2);
			fig4.setAlbum(album2);
			fig5.setAlbum(album2);
			fig6.setAlbum(album2);
			fig7.setAlbum(album2);
			fig8.setAlbum(album2);
			fig9.setAlbum(album2);
			fig10.setAlbum(album2);
			fig11.setAlbum(album2);
			fig12.setAlbum(album2);
			fig13.setAlbum(album2);
			fig14.setAlbum(album2);
			fig15.setAlbum(album2);
			fig16.setAlbum(album2);


			// adicionando os cromos a lista
			cromos.add(fig1);
			cromos.add(fig2);
			cromos.add(fig3);
			cromos.add(fig4);
			cromos.add(fig5);
			cromos.add(fig6);
			cromos.add(fig7);
			cromos.add(fig8);
			cromos.add(fig9);
			cromos.add(fig10);
			cromos.add(fig11);
			cromos.add(fig12);
			cromos.add(fig13);
			cromos.add(fig14);
			cromos.add(fig15);
			cromos.add(fig16);


			// e salvando a lista no album
			album2.setListaDeCromos(cromos);

			// persistindo os albuns no banco
			albumDAO.save(album1);
			albumDAO.save(album2);
			albumDAO.save(album3);
			albumDAO.save(album4);
			albumDAO.save(album5);




			// Item C
			// i ) Implementar uma consulta que retorne uma lista de álbuns que
			//contenham uma determinada String nome (a ser repassada como parâmetro)
			//em seu atributo nome. O método deverá consultar as instâncias do modelo
			//Album persistidos na base de dados, e retornar aquelas que contenham em
			//seu nome a string informada e o retorno deve ser ordenado em ordem
			//alfabética crescente.
			System.out.println("-------- ITEM C --------------------------");
			System.out.println(" I ========================================");
			List<Album> retornoDeConsulta = albumDAO.findByNomeContainingOrderByNome("feminina");
			for (Album t: retornoDeConsulta ) {
				System.out.println(t.getNome());
			}
			System.out.println("\n=================================================================\n");

			// ii ) Implementar uma consulta que retorne uma lista de álbuns que
			//possuam uma determinada String pais (a ser repassada como parâmetro) em
			//seu atributo paisSede. O método deverá consultar as instâncias do modelo
			//Album persistidos na base de dados, e retornar aquelas que possuam em seu
			//atributo paisSede a string informada e o retorno deve ser ordenado em ordem
			//alfabética crescente
			System.out.println(" II ========================================");
			retornoDeConsulta = albumDAO.findByPaisSedeContainingOrderByPaisSede("R");
			for (Album t: retornoDeConsulta ) {
				System.out.println(t.getPaisSede());
			}

			System.out.println("\n=================================================================\n");
			// iii )Implementar uma consulta que retorne uma lista de álbuns que
			//sejam de mais recentes que um determinado int ano (a ser repassado como
			//parâmetro), para tanto considerar o atributo ano. O método deverá consultar
			//as instâncias do modelo Album persistidos na base de dados, e retornar
			//aquelas que sejam mais recentes que o ano passado como parâmetro
			System.out.println(" III ========================================");
			retornoDeConsulta = albumDAO.findAlbumByAnoAfter(2016);
			for (Album t: retornoDeConsulta ) {
				System.out.println("Nome: " + t.getNome() + " | ano: " + t.getAno());
			}
			System.out.println("\n=================================================================\n");

			// iv ) ) Implementar uma consulta que retorne uma lista de álbuns que
			//possuam de mais cromosEspeciais que um determinado int quantidade (a ser
			//repassado como parâmetro), para tanto considerar o atributo
			//cromosEspeciais. O método deverá consultar as instâncias do modelo Album
			//persistidos na base de dados, e retornar aquelas que possuam um número
			//maior de cromosEspeciais que a quantidade passada como parâmetro.
			System.out.println(" IV ========================================");
			retornoDeConsulta = albumDAO.findAlbumByCromosEspeciaisAfter(30);
			for (Album t: retornoDeConsulta ) {
				System.out.println("Nome: " + t.getNome() + " | Quantidade de cromos especiais: " + t.getCromosEspeciais());
			}
			System.out.println("\n=================================================================\n");

			// v ) Implementar uma consulta que retorne uma lista de cromos que
			//sejam raros, ou seja, que seu atributo raro seja igual a true. O método deverá
			//consultar as instâncias do modelo Cromo persistidos na base de dados, e
			//retornar aquelas que sejam consideradas raras.
			// Consulta pelo raridade
			System.out.println(" V ========================================");
			System.out.println("===================== Consulta se a Cromo é Rara  =========================");
			List<Cromo> retornoDeConsultaCromo = albumDAO.findByCromoIsRaro();
			for (Cromo t: retornoDeConsultaCromo ) {
				System.out.println("Nome: " + t.getNome() + " | Album: " + t.getAlbum().getNome());
			}
			System.out.println("\n=================================================================\n");


			// vi ) ) Implementar uma consulta que retorne uma lista de cromos que
			//possuam uma determinada String selecao (a ser repassada como parâmetro)
			//em seu atributo selecao. O método deverá consultar as instâncias do modelo
			//Cromo persistidos na base de dados, e retornar aquelas que possuam em seu
			//atributo selecao a string informada como parâmetro e o retorno deve ser
			//ordenado em ordem alfabética decrescente
			// Consulta pela selecao
			System.out.println(" VI ========================================");
			System.out.println("===================== Consulta pela selecao =========================");
			retornoDeConsultaCromo = albumDAO.findByCromoWhereSelecaoContainingDesc("Alemanha");
			for (Cromo t: retornoDeConsultaCromo ) {
				System.out.println("Nome: " + t.getNome() + " | Album: " + t.getAlbum().getNome() + " | Seleção: " + t.getSelecao());
			}
			System.out.println("\n=================================================================\n");

			// vii ) ) Implementar uma consulta que retorne uma lista de cromos que
			//sejam de uma determinada String posicao (a ser repassada como parâmetro),
			//utilizar para tanto o atributo posicao. O método deverá consultar as instâncias
			//do modelo Cromo persistidos na base de dados, e retornar aquelas que
			//possuam em seu atributo posicao a string informada como parâmetro e o
			//retorno deve ser ordenado em ordem alfabética decrescente.
			// Consulta pela Posicao
			System.out.println(" VII ========================================");
			System.out.println("===================== Consulta pela Posicao =========================");
			retornoDeConsultaCromo = albumDAO.findByCromoWherePosicaoDesc("MEI");
			for (Cromo t: retornoDeConsultaCromo ) {
				System.out.println("Nome: " + t.getNome() + " | Posicao: " + t.getPosicao());
			}
			System.out.println("\n=================================================================\n");


			// viii ) Implementar uma consulta que retorne uma lista de cromos que
			//sejam de uma determinada String posicao e de uma determinda String selecao
			//(ambas a serem repassada como parâmetros), utilizar para tanto os atributos
			//posição e selecao. O método deverá consultar as instâncias do modelo Cromo
			//persistidos na base de dados, e retornar aquelas que possuam em seus
			//atributos posição e selecao asstringsinformadas como parâmetros e o retorno
			//deve ser ordenado em ordem alfabética decrescente de selecao.
			// Consulta pela posicao e selecao
			System.out.println(" VIII ========================================");
			System.out.println("===================== Consulta por posicao e selecao =========================");
			retornoDeConsultaCromo = albumDAO.findByCromoWherePosicaoAndSelecaoDesc("MCC", "Alemanha");
			for (Cromo t: retornoDeConsultaCromo ) {
				System.out.println("Nome: " + t.getNome() + " | Posicao: " + t.getPosicao() + " | seleção: "+ t.getSelecao());
			}
			System.out.println("\n=================================================================\n");

			// Item D

			// i ) Implementar o método getCromosByAlbum no DAO do modelo
			//Cromo, o qual ao receber um Album album, deverá retornar uma lista com
			//todas as instâncias do modelo Cromos associados a este album que estão
			//persistidos na base de dados. É obrigatório utilizar JPQL para implementar esta
			//consulta.
			// Consulta Cromos pelo album
			System.out.println("-------- ITEM D --------------------------");
			System.out.println(" I ========================================");
			System.out.println("===================== Consulta Cromos pelo album  =========================");
			retornoDeConsultaCromo = cromoDAO.getCromosByAlbum(album2);
			for (Cromo t: retornoDeConsultaCromo ) {
				System.out.println("Nome: " + t.getNome() + " | Album: " + t.getAlbum().getNome());
			}


			// ii ) Implementar o método getCromosByAlbumAndSelecao no DAO
			//do modelo Cromo, o qual ao receber um Album album e uma String selecao,
			//deverá retornar uma lista com todas as instâncias do modelo Cromos
			//associados a este album que estão persistidos na base de dados e que sejam
			//da selecao informada como parâmetro na consulta. É obrigatório utilizar JPQL
			//para implementar esta consulta.
			// Consulta Cromo pelo album e Selecao
			System.out.println(" II ========================================");
			System.out.println("===================== Consulta Cromo pelo album e selecao =========================");
			retornoDeConsultaCromo = cromoDAO.getCromosByAlbumAndSelecao(album2, "Alemanha");
			for (Cromo t: retornoDeConsultaCromo ) {
				System.out.println("Nome: " + t.getNome() + " | Selecao: "+ t.getSelecao() + " | Album: " + t.getAlbum().getNome());
			}

			// iii ) Implementar o método getAlbumByCromo no DAO do modelo
			//Album, o qual ao receber um Cromo cromo, deverá retornar a instância do
			//modelo Album associada a este cromo que esteja persistida na base de dados.
			//É obrigatório utilizar JPQL para implementar esta consulta.
			// Consulta Album pela Cromo
			System.out.println(" III ========================================");
			System.out.println("===================== Consulta Album pela Cromo =========================");
			Album retornoDeUmAlbum = cromoDAO.getAlbumByCromo(fig5);
			System.out.println("Pesquisando album por Cromo: " + fig5.getNome());
			System.out.println("Nome: " + retornoDeUmAlbum.getNome() + " | Capa: "+ retornoDeUmAlbum.getCapa() + " | Pais sede: " + retornoDeUmAlbum.getPaisSede());


			// Item E
			// IV

			System.out.println("-------- ITEM E --------------------------");
			System.out.println(" IV ========================================");
			Iterable<Album> todosOsAlbuns = albumDAO.findAll();
			System.out.println("+=========================+++==========================+");
			System.out.println("Todos os albuns na base: ");
			for (Album r: todosOsAlbuns ) {

				System.out.println(r.toString());
				System.out.println("V^V^V^V^V^V^V^V^V^V^V");
			}
			System.out.println("+=========================+++==========================+");

			Iterable<Cromo> todosOsCromos = cromoDAO.findAll();
			System.out.println("+=========================+++==========================+");
			System.out.println("Todos os cromos na base: ");
			for (Cromo r: todosOsCromos ) {

				System.out.println(r.toString());
				System.out.println("V^V^V^V^V^V^V^V^V^V^V");
			}
			System.out.println("+=========================+++==========================+");

			// extra
			// Consulta pelo nome na Cromo
			System.out.println("===================== Consulta Nome da Cromo =========================");
			retornoDeConsultaCromo = albumDAO.findByCromoContaining("Ney");
			for (Cromo t: retornoDeConsultaCromo ) {
				System.out.println("Nome: " + t.getNome() + " | Album: " + t.getAlbum().getNome());
			}



		};
	}

}
