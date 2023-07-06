package br.com.ifrs.restinga.aula0628.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Empresa {
    @Id
    private long id;
    private String nome;
    @Column(nullable = false, length = 14)
    private String cnpj;
    private String nomeFantasia;

    @OneToMany(targetEntity = Departamento.class, fetch = FetchType.EAGER, mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Departamento> departamento;



    public Empresa(){

    }

    public Empresa(String nome, String cnpj, String nomeFantasia){
        this.setNome(nome);
        this.setCnpj(cnpj);
        this.setNomeFantasia(nomeFantasia);
        this.departamento = new ArrayList<>();
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Departamento> getDepartamentos() {
        return departamento;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamento = departamentos;
    }

    public void addDepartamento(Departamento departamento){
        this.departamento.add(departamento);
    }
}
