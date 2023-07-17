package br.com.ifrs.restinga.trabalhoPratico.model;


import jakarta.persistence.*;
import javax.validation.constraints.Size;


import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String paisSede;

    @Column(nullable = false)
    private int ano;

   @ElementCollection
   @CollectionTable(name = "selecoes", joinColumns = @JoinColumn(name = "album_id"))
   @Column(nullable = false, name = "selecoes")
    private List<String> selecoes;

    @Column(nullable = false, length = 10)
    private String capa;

    @Column(nullable = true)
    private int cromos;

    @Column(nullable = true)
    private int cromosEspeciais;

    @Column(nullable = true)
    private int cromosExtras;

    // ---------- construtores ---------------------------

    public Album(){

    }

    public Album(String nome, String paisSede, int ano, List<String> selecoes, String capa){

    }


    // ---------- metodos --------------------------------

    @Override
    public String toString(){

        return "";
    }




    // ---------- getters e setters ----------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisSede() {
        return paisSede;
    }

    public void setPaisSede(String paisSede) {
        this.paisSede = paisSede;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<String> getSelecoes() {
        return selecoes;
    }

    public void setSelecoes(List<String> selecoes) {
        this.selecoes = selecoes;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public int getCromos() {
        return cromos;
    }

    public void setCromos(int cromos) {
        this.cromos = cromos;
    }

    public int getCromosEspeciais() {
        return cromosEspeciais;
    }

    public void setCromosEspeciais(int cromosEspeciais) {
        this.cromosEspeciais = cromosEspeciais;
    }

    public int getCromosExtras() {
        return cromosExtras;
    }

    public void setCromosExtras(int cromosExtras) {
        this.cromosExtras = cromosExtras;
    }
}
