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
@Table(name = "rh_funcao_qualidade")
public class FuncaoQualidade implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH_FUNCAO_QUALIDADE_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_RH_FUNCAO_QUALIDADE",initialValue = 111, allocationSize = 1, name = "RH_FUNCAO_QUALIDADE_SEQ")
    @Column(name = "id", unique = true, nullable = false)
    private BigDecimal idFuncao;
    
    @Column(name = "funcao", nullable = false)
    private String funcao;

    public BigDecimal getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(BigDecimal idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    
}
