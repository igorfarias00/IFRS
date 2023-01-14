/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import java.util.Calendar;

/**
 *
 * @author SAMSUNG
 */
public class Fatura {
    private Calendar dataEmissao;
    private Calendar dataVencimento;
    private Cliente c;
    private Servico s[];

    /**
     * @return the dataEmissao
     */
    public Calendar getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Calendar dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the dataVencimento
     */
    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the c
     */
    public Cliente getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Cliente c) {
        this.c = c;
    }

    /**
     * @return the s
     */
    public Servico[] getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(Servico[] s) {
        this.s = s;
    }
}
