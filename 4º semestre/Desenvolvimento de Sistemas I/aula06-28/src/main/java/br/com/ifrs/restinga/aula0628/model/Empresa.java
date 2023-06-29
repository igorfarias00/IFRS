package br.com.ifrs.restinga.aula0628.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empresa {
    @Id
    private long id;
    private String nome;
    @Column(nullable = false, length = 14)
    private String cnpj;
    private String nomeFantasia;

    public Empresa(){

    }
}
