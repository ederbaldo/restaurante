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
public class TreinamentoFeito implements Serializable{
    private BigDecimal idTreinamento;
    private BigDecimal idCurso;
    private BigDecimal turma;
    private String treinamento;
    private BigDecimal cdColab;
    private String nomeColab;
    @Temporal(value = TemporalType.DATE)
    private Date data;

    public BigDecimal getIdTreinamento() {
        return idTreinamento;
    }

    public void setIdTreinamento(BigDecimal idTreinamento) {
        this.idTreinamento = idTreinamento;
    }

    public BigDecimal getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(BigDecimal idCurso) {
        this.idCurso = idCurso;
    }

    public BigDecimal getTurma() {
        return turma;
    }

    public void setTurma(BigDecimal turma) {
        this.turma = turma;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
