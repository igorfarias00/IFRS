package br.ifrs.edu.restinga;

import br.ifrs.edu.restinga.domain.model.Cliente;
import br.ifrs.edu.restinga.domain.model.Livro;
import br.ifrs.edu.restinga.jpa.CadastroCliente;
import br.ifrs.edu.restinga.jpa.CadastroLivro;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProvaISpringApplication {

	public static void main(String[] args) {
//		SpringApplication.run( ProvaISpringApplication.class, args);
		ApplicationContext applicationContext =
				new SpringApplicationBuilder(ProvaISpringApplication.class)
						.web(WebApplicationType.NONE)
						.run(args);
		CadastroLivro cadastroLivro = applicationContext.getBean(CadastroLivro.class);
		CadastroCliente cadastroCliente = applicationContext.getBean(CadastroCliente.class);

		Livro livro1 = new Livro();
		Livro livro2 = new Livro();
		Livro livro3 = new Livro();

		livro1.setTitulo("Vinte mil ");
		livro1.setAutorPrimeiroNome("Julio");
		livro1.setAutorSegundoNome("Verne");
		livro1.setEditor("Darkseid");
		livro1.setAnoPublicacao("2012");

		livro2.setTitulo("Iracema kkkok");
		livro2.setAutorPrimeiroNome("Jose");
		livro2.setAutorSegundoNome("de Alencar");
		livro2.setEditor("Camara dos deputados");
		livro2.setAnoPublicacao("2012");



		livro3.setTitulo("Percy jackson ");
		livro3.setAutorPrimeiroNome("Rick");
		livro3.setAutorSegundoNome("Riordan");
		livro3.setEditor("Arqueiro");
		livro3.setAnoPublicacao("2012");



		cadastroLivro.adicionar(livro1);
		cadastroLivro.adicionar(livro2);
		cadastroLivro.adicionar(livro3);

		livro1.setTitulo("Viagem ao centro da terra");
		livro1.setId(1L);
		cadastroLivro.atualizar(livro1);

		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();

		cliente1.setNome("Igor");
		cliente1.setCpf("12314");
		cliente1.setEmail("brastemp@arroba.com");

		cliente2.setNome("Rafael");
		cliente2.setCpf("12314");
		cliente2.setEmail("campari@rp.com.br");

		cliente3.setNome("Dionisio");
		cliente3.setCpf("12332");
		cliente3.setEmail("rx@ix.br");

		cadastroCliente.adicionar(cliente1);
		cadastroCliente.adicionar(cliente2);
		cadastroCliente.adicionar(cliente3);


		List<Livro> listaLivros = cadastroLivro.listar();
		List<Cliente> listaClientes = cadastroCliente.listar();

		for (Livro y: listaLivros) {
			System.out.println(y.getId()+ ": " + y.getTitulo());
		}


		for (Cliente c: listaClientes) {
			System.out.println(c.getId()+ ": " + c.getNome());
		}

		//Livro livroBusca = cadastroLivro.buscar(2L);

		//System.out.println(livroBusca.getTitulo());




		//Livro livroDeletar = new Livro();
		//livroDeletar.setId(2L);
		//cadastroLivro.remover(livroDeletar);


	}

}
