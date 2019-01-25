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
public class CanaDiaFrente implements Serializable{
    private String frente;
    private BigDecimal capacColhe;
    private float cota;

    public String getFrente() {
        return frente;
    }

    public void setFrente(String frente) {
        this.frente = frente;
    }

    public BigDecimal getCapacColhe() {
        return capacColhe;
    }

    public void setCapacColhe(BigDecimal capacColhe) {
        this.capacColhe = capacColhe;
    }

    public float getCota() {
        return cota;
    }

    public void setCota(float cota) {
        this.cota = cota;
    }
    
    
}
