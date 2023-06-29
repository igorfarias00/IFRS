package br.com.ifrs.restinga.aula0628.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pessoa {
    @Id
    private long id;
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;


    public Pessoa(){

    }
}
