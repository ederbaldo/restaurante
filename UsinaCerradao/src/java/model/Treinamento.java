/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author enascimento
 */
public class Treinamento implements Serializable{
    private BigDecimal idTreinamento;
    private String treinamento;
    private BigDecimal cdColab;
    private String nomeColab;
    private String nomeCargo;
    private String descLocalTrab;

    public BigDecimal getIdTreinamento() {
        return idTreinamento;
    }

    public void setIdTreinamento(BigDecimal idTreinamento) {
        this.idTreinamento = idTreinamento;
    }

    

    public String getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(String treinamento) {
        this.treinamento = treinamento;
    }

    public BigDecimal getCdColab() {
        return cdColab;
    }

    public void setCdColab(BigDecimal cdColab) {
        this.cdColab = cdColab;
    }

    public String getNomeColab() {
        return nomeColab;
    }

    public void setNomeColab(String nomeColab) {
        this.nomeColab = nomeColab;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getDescLocalTrab() {
        return descLocalTrab;
    }

    public void setDescLocalTrab(String descLocalTrab) {
        this.descLocalTrab = descLocalTrab;
    }
    
    
    
}
