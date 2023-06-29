package br.com.ifrs.restinga.brasfootIbtfs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class Jogador {

    @Id
    private int cod;
    private String nome;



    private String nacionalidade;
    private Date nascimento;
    private String apelido;
    private String posicao;
    private int qualidade;
    private int cartoes;
    private boolean suspenso;


    @OneToOne
    private Time time;


    public Jogador(){

    }

    public Jogador(String nome, String nacionalidade, String posicao, Date nascimento, int qualidade){

    }

    public Jogador(String nome, String nacionalidade, Date nascimento,
                   String apelido, String posicao, int qualidade, int cartoes, boolean suspenso, Time time){


    }


    public boolean verificarCondicaoDeJogo(){
        if(this.getCartoes() <= 3 && !this.isSuspenso()){
            return true;
        } else {
            return false;
        }

    }

    public void aplicarCartaoVermelho(){
        this.setCartoes(0);
        this.setSuspenso(true);
    }

    @Override
    public String toString(){
        return "";
    }







    // getters e setters
    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getQualidade() {
        return qualidade;
    }

    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
    }

    public int getCartoes() {
        return cartoes;
    }

    public void setCartoes(int cartoes) {
        this.cartoes = cartoes;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
