/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author enascimento
 */
public class NotaFiscal implements Serializable{
    private BigDecimal numero;
    private String serie;
    private String razaoSocial;
    private String danf;
    private String cdProduto;
    private String descrProduto;
    @Temporal(value = TemporalType.DATE)
    private Date data;

    public BigDecimal getNumero() {
        return numero;
    }

    public String getCdProduto() {
        return cdProduto;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    
   

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getDanf() {
        return danf;
    }

    public void setDanf(String danf) {
        this.danf = danf;
    }

    
    

    public void setCdProduto(String cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getDescrProduto() {
        return descrProduto;
    }

    public void setDescrProduto(String descrProduto) {
        this.descrProduto = descrProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
