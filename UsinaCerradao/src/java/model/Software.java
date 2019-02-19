/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author enascimento
 */
@Entity
@Table (name = "software")
public class Software implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOFTWARE_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_SOFTWARE", allocationSize = 1, name = "SOFTWARE_SEQ")
    @Column(name = "id_software", unique = true, nullable = false)
    private int idSoftware;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;
    @Column(name = "fornecedor", nullable = true)
    private String fornecedor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_software", nullable = false, foreignKey = @ForeignKey(name = "id_tipo_software_software"))
    private TipoSoftware tipoSoftware;
    @Column(name = "nf", nullable = true)
    private int nf;
    @Column(name = "observacao", nullable = true)
    private String observacao;
    @Column(name = "situacao", nullable = true)
    private String situacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_serial",nullable = true, foreignKey = @ForeignKey(name = "id_ser_ope_software"))
    private SerialOpenLicense serialOpenLicenca;
    @Column(name = "product_id", nullable = true)
    private String productId;
    @Column(name = "key", nullable = true)
    private String key;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "senha", nullable = true)
    private String senha;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "danf", nullable = true)
    private String danf;
    @Type(type = "yes_no")
    @Column(name = "tipo", nullable = true)
    private Boolean tipo;

    public int getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(int idSoftware) {
        this.idSoftware = idSoftware;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public TipoSoftware getTipoSoftware() {
        return tipoSoftware;
    }

    public void setTipoSoftware(TipoSoftware tipoSoftware) {
        this.tipoSoftware = tipoSoftware;
    }

    public int getNf() {
        return nf;
    }

    public void setNf(int nf) {
        this.nf = nf;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public SerialOpenLicense getSerialOpenLicenca() {
        return serialOpenLicenca;
    }

    public void setSerialOpenLicenca(SerialOpenLicense serialOpenLicenca) {
        this.serialOpenLicenca = serialOpenLicenca;
    }

    

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDanf() {
        return danf;
    }

    public void setDanf(String danf) {
        this.danf = danf;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    
}
