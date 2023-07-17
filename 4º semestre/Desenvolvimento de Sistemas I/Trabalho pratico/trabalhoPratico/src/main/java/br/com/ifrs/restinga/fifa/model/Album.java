// PROGRAMA DESENVOLVIDO PELO ALUNO IGOR BALEST FARIAS
// Disciplina: Dev I
// Trabalho final

package br.com.ifrs.restinga.fifa.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    @Size(min = 10, max = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    @Size(min= 3, max = 100)
    private String paisSede;

    @Column(nullable = false)
    private int ano;

   @ElementCollection
   @CollectionTable(name = "selecoes", joinColumns = @JoinColumn(name = "album_id"))
   @Column(nullable = false, name = "selecao")
   @Size(min = 3, max = 100)
    private List<String> selecoes;

    @Column(nullable = false, length = 10)
    @Size(min= 4, max = 10)
    private String capa;

    @Column(nullable = true)
    private int cromos;

    @Column(nullable = true)
    private int cromosEspeciais;

    @Column(nullable = true)
    private int cromosExtras;

    @OneToMany(targetEntity = Cromo.class, fetch = FetchType.EAGER, mappedBy = "album", cascade = CascadeType.ALL)
    private List<Cromo> listaDeCromos;

    // ---------- construtores ---------------------------

    public Album(){
        this.listaDeCromos = null;
    }

    public Album(String nome, String paisSede, int ano, List<String> selecoes, String capa){
        this.setNome(nome);
        this.setPaisSede(paisSede);
        this.setAno(ano);
        this.setSelecoes(selecoes);
        this.setCapa(capa);
        this.listaDeCromos = null;
    }


    // ---------- metodos --------------------------------

    @Override
    public String toString(){
        String str = "";

        str += "Nome: "             + this.getNome() +  " | ";
        str += "País sede: "        + this.getPaisSede() +  " | ";
        str += "Ano: "              + this.getAno() +  " | ";
        str += "Capa: "             + this.getCapa() +  " | ";
        str += "Cromos: "           + this.getCromos() +  " | ";
        str += "Cromos Especiais: " + this.getCromosEspeciais() +  " | ";
        str += "Cromos Extras: "    + this.getCromosExtras()+  "\n";

        return str;
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

    public List<Cromo> getListaDeCromos() {
        return listaDeCromos;
    }

    public void setListaDeCromos(List<Cromo> listaDeCromos) {
        this.listaDeCromos = listaDeCromos;
        this.setCromos(this.getCromos() + listaDeCromos.size());
    }

    public boolean listaDeCromosIsNull(){
        if (this.listaDeCromos.size() == 0 || this.listaDeCromos == null ) {
            return true;
        } else {
            return false;
        }
    }

    public void addListaDeCromos(Cromo novoCromo){
        this.listaDeCromos.add(novoCromo);
        this.setCromos(this.getCromos() + 1);
    }

    public void removeListaDeCromos(Cromo cromo){
        this.listaDeCromos.remove(cromo);
    }
}
