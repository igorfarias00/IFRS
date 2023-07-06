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

    public Departamento(String nome, String andar, Empresa empresa ){
        this.setNome(nome);
        this.setAndar(andar);
        this.setEmpresa(empresa);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
