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
import org.hibernate.annotations.Type;

/**
 *
 * @author enascimento
 */
@Entity
@Table(name = "computador")
public class Computador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPUTADOR_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_COMPUTADOR", allocationSize = 1, name = "COMPUTADOR_SEQ")
    @Column(name = "id_computador", unique = true, nullable = false)
    private Integer idComputador;
    @Column(name = "tipo", nullable = true)
    private String tipo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false, foreignKey = @ForeignKey(name = "id_marca_computador"))
    private Marca marca;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;
    @Column(name = "nf", nullable = false)
    private Integer nf;
    @Column(name = "situacao", length = 8, nullable = true)
    private String  situacao;
    @Column(name = "memoria", nullable = true)
    private String memoria;
    @Column(name = "processador", nullable = true)
    private String processador;
    @Column(name = "disp_armaz", nullable = true)
    private String dipositivoArmazenamento;
    @Column(name = "tamanho_disp_armaz", nullable = true)
    private String tamanhoDipositivoArmazenamento;
    @Column(name = "service_tag", nullable = false)
    private String serviceTag;

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getNf() {
        return nf;
    }

    public void setNf(Integer nf) {
        this.nf = nf;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getDipositivoArmazenamento() {
        return dipositivoArmazenamento;
    }

    public void setDipositivoArmazenamento(String dipositivoArmazenamento) {
        this.dipositivoArmazenamento = dipositivoArmazenamento;
    }

    public String getTamanhoDipositivoArmazenamento() {
        return tamanhoDipositivoArmazenamento;
    }

    public void setTamanhoDipositivoArmazenamento(String tamanhoDipositivoArmazenamento) {
        this.tamanhoDipositivoArmazenamento = tamanhoDipositivoArmazenamento;
    }

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

   

    public void toUpperCase() {
        this.setDescricao(this.getDescricao().toUpperCase());
        this.setServiceTag(this.getServiceTag().toUpperCase());
        this.setProcessador(this.getProcessador().toUpperCase());
    }

}
