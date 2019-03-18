/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author enascimento
 */
@Entity
@Table (name = "rh_treinamento_qualidade")
public class TreinamentoQualidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH_TREINAMENTO_QUALIDADE_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_RH_TREINAMENTO_QUALIDADE",initialValue = 148, allocationSize = 1, name = "RH_TREINAMENTO_QUALIDADE_SEQ")
    @Column(name = "id", unique = true, nullable = false)
    private BigDecimal idTreinamento;
    
    @Column(name = "treinamento", nullable = false)
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
