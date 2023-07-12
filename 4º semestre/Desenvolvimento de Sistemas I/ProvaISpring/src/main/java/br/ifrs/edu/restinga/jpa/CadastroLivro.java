package br.ifrs.edu.restinga.jpa;




import java.util.Calendar;
import br.ifrs.edu.restinga.domain.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroLivro {

    @PersistenceContext
    private EntityManager manager;

    public CadastroLivro (){

    }

    public List<Livro> listar(){
        TypedQuery<Livro> query = manager.createQuery("FROM Livro", Livro.class);

        return query.getResultList();
    }

    @Transactional
    public void adicionar(Livro novoLivro){
        if( novoLivro.getTitulo() != null && novoLivro.getAutorPrimeiroNome() != null && novoLivro.getAutorSegundoNome() != null && novoLivro.getEditor() != null){
                if(Integer.parseInt(novoLivro.getAnoPublicacao()) >= 1800 && Integer.parseInt(novoLivro.getAnoPublicacao()) <= 2023){
                    if((novoLivro.getTitulo().length() >= 10 && novoLivro.getTitulo().length() <= 100)) {
                        manager.merge(novoLivro);

                    } else {
                        System.out.println("O nome da obra deve ter o comprimento minimo de 10 caracteres e no maximo 100");
                    }
                } else {
                    System.out.println("Data de publicação inválida! deve ser posterior a 1800, até o ano atual.");
                }
        } else {
            System.out.println("Inválido. Nome do titulo, do autor ou da editora estão em branco!");

        }



    }

    public Livro buscar(Long id){
        return manager.find(Livro.class, id);
    }

    @Transactional
    public void remover(Livro livro){
        manager.remove(buscar(livro.getId()));
    }

    @Transactional
    public void atualizar(Livro novoLivro){
        this.adicionar(novoLivro);
    }


}
