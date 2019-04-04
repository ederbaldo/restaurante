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
public class ListaFuncaoFilha implements Serializable{
    private String nomeCargo;
    private BigDecimal funcaoId;

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public BigDecimal getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(BigDecimal funcaoId) {
        this.funcaoId = funcaoId;
    }
    
}
