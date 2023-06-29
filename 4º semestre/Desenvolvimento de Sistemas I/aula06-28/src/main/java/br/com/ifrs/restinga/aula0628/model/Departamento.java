package br.com.ifrs.restinga.aula0628.model;


import jakarta.persistence.*;

@Entity
public class Departamento {
    @Id
    private long id;
    private String nome;
    private int numeroFuncionarios;
    private String andar;

    @ManyToOne(targetEntity = Empresa.class, fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Departamento(){

    }
}
