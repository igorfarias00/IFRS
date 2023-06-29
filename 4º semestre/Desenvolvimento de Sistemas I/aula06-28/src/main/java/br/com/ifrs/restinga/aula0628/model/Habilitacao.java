package br.com.ifrs.restinga.aula0628.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Habilitacao {
    @Id
    private long id;
    @Column(nullable = false)
    private String numero;

    @Temporal(TemporalType.DATE)
    private LocalDate validade;
    private String categoria;

    @OneToOne(targetEntity = Pessoa.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    public Habilitacao(){

    }
}
