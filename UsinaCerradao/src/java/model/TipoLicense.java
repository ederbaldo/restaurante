/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author enascimento
 */
@Entity
@Table (name = "tipo_license")
public class TipoLicense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_license", unique = true, nullable = false)
    private int idTipoLicense;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "quantidade", nullable = true)
    private int quantidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_open_license", nullable = false, foreignKey = @ForeignKey(name = "id_open_license_tipo_license"))
    private OpenLicense idOpenLicense;

    public int getIdTipoLicense() {
        return idTipoLicense;
    }

    public void setIdTipoLicense(int idTipoLicense) {
        this.idTipoLicense = idTipoLicense;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public OpenLicense getIdOpenLicense() {
        return idOpenLicense;
    }

    public void setIdOpenLicense(OpenLicense idOpenLicense) {
        this.idOpenLicense = idOpenLicense;
    }
 
    
}
