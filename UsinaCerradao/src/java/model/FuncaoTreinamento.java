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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author enascimento
 */
@Entity
@Table(name = "rh_funcao_treinamento")
public class FuncaoTreinamento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH_FUNCAO_TREINAMENTO_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_RH_FUNCAO_TREINAMENTO",initialValue = 1, allocationSize = 1, name = "RH_FUNCAO_TREINAMENTO_SEQ")
    @Column(name = "id", unique = true, nullable = false)
    private BigDecimal idFuncaoTreinamento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_treinamento", nullable = false, foreignKey = @ForeignKey(name = "id_treinamento_funcao"))
    private TreinamentoQualidade idTreinamento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcao", nullable = false, foreignKey = @ForeignKey(name = "id_funcao_treinamento"))
    private FuncaoQualidade idFuncao;

    public BigDecimal getIdFuncaoTreinamento() {
        return idFuncaoTreinamento;
    }

    public void setIdFuncaoTreinamento(BigDecimal idFuncaoTreinamento) {
        this.idFuncaoTreinamento = idFuncaoTreinamento;
    }

    public TreinamentoQualidade getIdTreinamento() {
        return idTreinamento;
    }

    public void setIdTreinamento(TreinamentoQualidade idTreinamento) {
        this.idTreinamento = idTreinamento;
    }

    public FuncaoQualidade getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(FuncaoQualidade idFuncao) {
        this.idFuncao = idFuncao;
    }

    public void setIdFuncao(BigDecimal func) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
