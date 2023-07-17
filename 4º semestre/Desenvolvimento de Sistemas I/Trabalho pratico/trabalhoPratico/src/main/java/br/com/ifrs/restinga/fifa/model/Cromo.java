// PROGRAMA DESENVOLVIDO PELO ALUNO IGOR BALEST FARIAS
// Disciplina: Dev I
// Trabalho final

package br.com.ifrs.restinga.fifa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Cromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean extra;

    @Column(nullable = false)
    private boolean raro;


    @Column(nullable = false, length = 10)
    @Size(max = 10)
    private String versao;

    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100)
    private String nome;

    @Column(nullable = true)
    private LocalDate nascimento;

    @Column(nullable = true)
    //@Size(max = 3)
    private String selecao;

    @Column(nullable = true)
    //@Size(max = 3)
    private String posicao;

    @Column(nullable = true)
    private int anoConvocacao;

    @Column(nullable = true)
    //@Size(min = 0)
    private double altura;

    @Column(nullable = true)
    private int peso;

    @ManyToOne(targetEntity = Album.class, fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private Album album;

    // ---------  Construtores  -------------------------
    public Cromo(){

    }

    public Cromo(boolean extra, boolean raro, String versao, String nome){
        this.setExtra(extra);
        this.setRaro(raro);
        this.setVersao(versao);
        this.setNome(nome);
    }



    // ---------  metodos --------------------------------
    @Override
    public String toString(){
        String str = "";

        str += "Nome: "                 + this.getNome() +  " | ";
        str += "Extra: "                + this.isExtra() +  " | ";
        str += "Raro: "                 + this.isRaro() +  " | ";
        str += "Versao: "               + this.getVersao() +  " | ";
        str += "nascimento: "           + this.getNascimento() +  " | ";
        str += "seleção: "              + this.getSelecao() +  " | ";
        str += "Posição: "              + this.getPosicao() +  " | ";
        str += "ano da convocação: "    + this.getAnoConvocacao() +  " | ";
        str += "altura: "               + this.getAltura()  +  " | ";
        str += "Peso: "                 + this.getPeso()  +  "\n";


        return str;
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

    public boolean isRaro() {
        return raro;
    }

    public void setRaro(boolean raro) {
        this.raro = raro;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
