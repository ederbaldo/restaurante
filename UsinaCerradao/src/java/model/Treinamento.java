/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    private BigDecimal validade;
    @Temporal(value = TemporalType.DATE)
    private Date data;
    private String contadorDiasRestantes;


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

    public BigDecimal getValidade() {
        return validade;
    }

    public void setValidade(BigDecimal validade) {
        this.validade = validade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getContadorDiasRestantes() {
        return contadorDiasRestantes;
    }

    public void setContadorDiasRestantes(String contadorDiasRestantes) {
        this.contadorDiasRestantes = contadorDiasRestantes;
    }

       
    
    
}
