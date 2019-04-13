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
public class ListaOpenLicense implements Serializable{
    private String tipoDescricao;
    private String tipofornecedor;
    private BigDecimal contrato;
    private BigDecimal tipoQtde;
    private BigDecimal idOpen;
    

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
    }

    public String getTipofornecedor() {
        return tipofornecedor;
    }

    public void setTipofornecedor(String tipofornecedor) {
        this.tipofornecedor = tipofornecedor;
    }

    public BigDecimal getTipoQtde() {
        return tipoQtde;
    }

    public void setTipoQtde(BigDecimal tipoQtde) {
        this.tipoQtde = tipoQtde;
    }
    

    public BigDecimal getContrato() {
        return contrato;
    }

    public void setContrato(BigDecimal contrato) {
        this.contrato = contrato;
    }

    public BigDecimal getIdOpen() {
        return idOpen;
    }

    public void setIdOpen(BigDecimal idOpen) {
        this.idOpen = idOpen;
    }

    
    
}
