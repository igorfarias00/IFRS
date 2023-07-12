package br.ifrs.edu.restinga.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="telefone")
public class Telefone {
    @Id
    @GeneratedValue
    private long id;

    private long clienteId;

    private String telefone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return id == telefone.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
