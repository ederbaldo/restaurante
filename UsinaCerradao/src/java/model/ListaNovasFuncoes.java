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
public class ListaNovasFuncoes implements Serializable{
    
    private String nomeCargo;
    private BigDecimal CdCusto;
    private BigDecimal funcaoId;
    private BigDecimal matricula;
    private String nomeColab;

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public BigDecimal getCdCusto() {
        return CdCusto;
    }

    public void setCdCusto(BigDecimal CdCusto) {
        this.CdCusto = CdCusto;
    }

    

    public BigDecimal getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(BigDecimal funcaoId) {
        this.funcaoId = funcaoId;
    }

    public BigDecimal getMatricula() {
        return matricula;
    }

    public void setMatricula(BigDecimal matricula) {
        this.matricula = matricula;
    }

    public String getNomeColab() {
        return nomeColab;
    }

    public void setNomeColab(String nomeColab) {
        this.nomeColab = nomeColab;
    }
    
    
    
}
