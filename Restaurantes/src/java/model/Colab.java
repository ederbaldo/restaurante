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
public class Colab implements Serializable {
    private String nome;
    private BigDecimal matricula;
    private BigDecimal colabId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getMatricula() {
        return matricula;
    }

    public void setMatricula(BigDecimal matricula) {
        this.matricula = matricula;
    }

    public BigDecimal getColabId() {
        return colabId;
    }

    public void setColabId(BigDecimal colabId) {
        this.colabId = colabId;
    }

    

    








    
}
