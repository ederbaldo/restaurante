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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author enascimento
 */
@Entity
@Table (name = "computador")
public class Computador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPUTADOR_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_COMPUTADOR", allocationSize = 1, name = "COMPUTADOR_SEQ")
    @Column(name = "id_computador",  unique = true, nullable = false)
    private int idComputador;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "fornecedor", nullable = true)
    private String fornecedor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false, foreignKey = @ForeignKey(name = "id_marca_computador"))
    private Marca marca;
    @Column(name = "memoria", nullable = true)
    private String memoria;
    @Column(name = "nf", nullable = true)
    private int nf;
    @Column(name = "observacao", nullable = true)
    private String observacao;
    @Column(name = "processador", nullable = true)
    private String processador;
    @Column(name = "situacao", nullable = true)
    private String situacao;
    @Column(name = "dipositivo_armazenamento", nullable = true)
    private String dipositivoArmazenamento;
    @Column(name = "tipo", nullable = true)
    private String tipo;
    @Column(name = "nro_danf", nullable = true)
    private String nroDanf;

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
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

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDipositivoArmazenamento() {
        return dipositivoArmazenamento;
    }

    public void setDipositivoArmazenamento(String dipositivoArmazenamento) {
        this.dipositivoArmazenamento = dipositivoArmazenamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
     public void toUpperCase() {
        this.setDescricao(this.getDescricao().toUpperCase());
    }

    public String getNroDanf() {
        return nroDanf;
    }

    public void setNroDanf(String nroDanf) {
        this.nroDanf = nroDanf;
    }
     
     

}
