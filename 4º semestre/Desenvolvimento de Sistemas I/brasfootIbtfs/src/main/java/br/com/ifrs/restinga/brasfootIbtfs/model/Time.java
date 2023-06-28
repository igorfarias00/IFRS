package br.com.ifrs.restinga.brasfootIbtfs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Time {
    @Id
    private int cod;
    private String nome;
    private String apelido;
    private Date fundacao;
    private String cidade;
    private ArrayList<Jogador> platel; // verificar lista em persistencia
    private ArrayList<Jogador> relacionados;


    public Time(){

    }

    public Time(String nome, Date fundacao, String cidade){

    }

    public Time(String nome, String apelido, Date fundacao, String cidade, List<Jogador> platel, List<Jogador> relacionados){

    }

    public ArrayList<Jogador> relacionarJogadores(){
        ArrayList<Jogador> lista = new ArrayList<>();

        return lista;
    }















    //getter e setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getFundacao() {
        return fundacao;
    }

    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Jogador> getPlatel() {
        return platel;
    }

    public void setPlatel(List<Jogador> platel) {
        this.platel = platel;
    }

    public List<Jogador> getRelacionados() {
        return relacionados;
    }

    public void setRelacionados(List<Jogador> relacionados) {
        this.relacionados = relacionados;
    }
}
