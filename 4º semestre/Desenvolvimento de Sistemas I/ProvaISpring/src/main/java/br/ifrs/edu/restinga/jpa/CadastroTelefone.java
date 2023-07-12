package br.ifrs.edu.restinga.jpa;

import br.ifrs.edu.restinga.domain.model.Cliente;
import br.ifrs.edu.restinga.domain.model.Livro;
import br.ifrs.edu.restinga.domain.model.Telefone;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CadastroTelefone {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void adicionarLista(List<Telefone> listaCliente){
        List<Telefone> busca = this.buscarPorCliente(listaCliente.get(0).getId());
        if(busca.size() > 2 || listaCliente.size() > 2){
            System.out.println("Cliente já possui 2 telefones cadastrados ou esta tentando cadastrar mais de 2 telefones!");
        } if(busca.size() == 1 && busca.get(0).getTelefone().compareTo(listaCliente.get(1).getTelefone()) == 0  ){
            System.out.println("Telefone " + listaCliente.get(1)+ " já cadastrado!");
        } else {
            for (Telefone t : listaCliente) {
                manager.merge(t);
            }
        }

    }

    @Transactional
    public void adicionarUm(Telefone novoTelefone){
        List<Telefone> busca = this.buscarPorCliente(novoTelefone.getId());

        if(busca.size() > 2){
            System.out.println("Cliente já possui 2 telefones cadastrados ou esta tentando cadastrar mais de 2 telefones!");
        } if(busca.size() == 1 && busca.get(0).getTelefone().compareTo(novoTelefone.getTelefone()) == 0){
            System.out.println("Telefone já esta cadsatrado!");
        } else {
            manager.merge(novoTelefone);
        }
    }




    public List<Telefone> buscarPorCliente(Long id){
        String textoQuery = "FROM Telefone where clienteId = " + Long.toString(id);

        TypedQuery<Telefone> query = manager.createQuery(textoQuery, Telefone.class);


        return query.getResultList();

    }


}
