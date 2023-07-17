package br.com.ifrs.restinga.trabalhoPratico.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Cromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean extra;

    @Column(nullable = false, length = 10)
    private String versao;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = true)
    private LocalDate nascimento;

    @Column(nullable = true)
    private String selecao;

    @Column(nullable = true)
    private String posicao;

    @Column(nullable = true)
    private int anoConvocacao;

    @Column(nullable = true)
    private double altura;

    @Column(nullable = true)
    private int peso;

    // ---------  Construtores  -------------------------
    public Cromo(){

    }

    public Cromo(boolean extra, boolean raro, String versao, String nome){

    }



    // ---------  metodos --------------------------------
    @Override
    public String toString(){

        return "";
    }




    // --------- getters e setters  -------------------------

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getSelecao() {
        return selecao;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getAnoConvocacao() {
        return anoConvocacao;
    }

    public void setAnoConvocacao(int anoConvocacao) {
        this.anoConvocacao = anoConvocacao;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
