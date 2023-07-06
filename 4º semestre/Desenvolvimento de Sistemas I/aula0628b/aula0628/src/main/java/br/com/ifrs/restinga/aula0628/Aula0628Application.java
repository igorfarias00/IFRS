package br.com.ifrs.restinga.aula0628;

import br.com.ifrs.restinga.aula0628.DAO.EmpresaDAO;
import br.com.ifrs.restinga.aula0628.model.Departamento;
import br.com.ifrs.restinga.aula0628.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula0628Application {
	@Autowired
	EmpresaDAO empresaDAO;


	public static void main(String[] args) {
		SpringApplication.run(Aula0628Application.class, args);
		//ApplicationContext applicationContext =
		//		new SpringApplicationBuilder(Aula0628Application.class)
		//				.web(WebApplicationType.NONE)
		//				.run(args);


	}

	@Bean
	public CommandLineRunner initialData(){
		return (args) -> {
			Empresa angar = new Empresa("angar", "2345121", "Angar aviação");
			Departamento dep1 = new Departamento("Rh", "1º", angar);
			Departamento dep2 = new Departamento("TI", "2", angar);
			Departamento dep3 = new Departamento("Manutencao", "terreo", angar);

			angar.addDepartamento(dep1);
			//angar.addDepartamento(dep2);
			//angar.addDepartamento(dep3);

			empresaDAO.save(angar);


		};

	}

}
