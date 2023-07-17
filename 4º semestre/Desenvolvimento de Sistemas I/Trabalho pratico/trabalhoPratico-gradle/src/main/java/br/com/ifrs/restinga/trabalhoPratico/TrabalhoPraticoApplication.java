package br.com.ifrs.restinga.trabalhoPratico;

import br.com.ifrs.restinga.trabalhoPratico.DAO.AlbumDAO;
import br.com.ifrs.restinga.trabalhoPratico.DAO.CromoDAO;
import br.com.ifrs.restinga.trabalhoPratico.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrabalhoPraticoApplication {

	//@Autowired
	//AlbumDAO albumDAO;

	//@Autowired
	//CromoDAO cromoDAO;



	public static void main(String[] args) {
		SpringApplication.run(TrabalhoPraticoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialData(){
		return (args) -> {
			//Album album1 = new Album();
			//Cromo figurinha1 = new Cromo();





		};
	}

}
