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
@Table(name = "tipo_license")
public class TipoLicense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_LICENSE_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_TIPO_LICENSE", allocationSize = 6, name = "TIPO_LICENSE_SEQ")
    @Column(name = "id_tipo_license", unique = true, nullable = false)
    private Integer idTipoLicense;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "fornecedor", nullable = true)
    private String fornecedor;
    @Column(name = "quantidade", nullable = true)
    private Integer quantidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_open_license", nullable = false, foreignKey = @ForeignKey(name = "id_tipo_open"))
    private OpenLicense idOpenLicense;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_license", nullable = false, foreignKey = @ForeignKey(name = "id_tipo_licen"))
    private License license;
//    @Column(name = "id_open_license", nullable = true)
//    private Integer idOpenLicense;

    public Integer getIdTipoLicense() {
        return idTipoLicense;
    }

    public void setIdTipoLicense(Integer idTipoLicense) {
        this.idTipoLicense = idTipoLicense;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

//    public Integer getIdOpenLicense() {
//        return idOpenLicense;
//    }
//
//    public void setIdOpenLicense(Integer idOpenLicense) {
//        this.idOpenLicense = idOpenLicense;
//    }

    public OpenLicense getIdOpenLicense() {
        return idOpenLicense;
    }

    public void setIdOpenLicense(OpenLicense idOpenLicense) {
        this.idOpenLicense = idOpenLicense;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    

}
