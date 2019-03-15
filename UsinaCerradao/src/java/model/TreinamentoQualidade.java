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
public class TreinamentoQualidade implements Serializable {
    private BigDecimal idTreinamento;
    private String treinamento;

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
    
}
