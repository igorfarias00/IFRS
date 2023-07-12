package br.ifrs.edu.restinga.jpa;



import br.ifrs.edu.restinga.domain.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class CadastroCliente {

    @PersistenceContext
    private EntityManager manager;

    public List<Cliente> listar(){
        TypedQuery<Cliente> query = manager.createQuery("FROM Cliente", Cliente.class);

        return query.getResultList();
    }

    @Transactional
    public void adicionar(Cliente novoCliente) {
        boolean clienteCadastrado = false;
        long idUltimoCadastrado = 0;
        if (novoCliente.getNome() != null && novoCliente.getCpf() != null && novoCliente.getEmail() != null){
            List<Cliente> lista = this.listar();

            // pode gerar problema de performance
            for(Cliente x: lista){                                          // procura nos clientes cadastrados se já existe o cpf do novo cliente
                if(x.getCpf().compareTo(novoCliente.getCpf()) == 0 ) {
                    System.out.println("Cliente " + novoCliente.getNome() + " já está cadastrado");
                    clienteCadastrado = true;
                    break;
                } else {
                    idUltimoCadastrado = x.getId();
                }
            }


            if(!clienteCadastrado) {
                manager.merge(novoCliente);
                novoCliente.setId(idUltimoCadastrado+1);

            } else {
                System.out.println("Cliente já cadastrado");
            }


        } else {
            System.out.println("Inválido. Nome , CPF ou EMAIL estão em branco!");
        }

    }


    public Cliente buscar(Long id){

        return manager.find(Cliente.class, id);
    }

    @Transactional
    public void remover(Cliente cliente){
        manager.remove(buscar(cliente.getId()));
    }

    @Transactional
    public void atualizar(Cliente novoCliente){
        this.adicionar(novoCliente);
    }


}