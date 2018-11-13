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
import javax.persistence.OneToOne;
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
@Table (name = "ip")
public class Ip implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IP_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_IP", allocationSize = 1, name = "IP_SEQ")
    @Column(name = "id_ip", unique = true, nullable = false)
    private int idIp;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_computador", nullable = false, foreignKey = @ForeignKey(name = "id_computador_ip"))
    private Computador computador;
    @Column(name = "colab_id", nullable = true)
    private int colabId;
    @Column(name = "numero_ip", nullable = true)
    private int numeroIp;
    @Column(name = "faixa", nullable = true)
    private int faixa;
    @Column(name = "solicitante_id", nullable = true)
    private int solicitanteId;
    @Column(name = "mac", nullable = true)
    private String mac;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_fim", nullable = false)
    private Date dataFim;
    @Column(name = "dispositivo", nullable = true)
    private String dispositivo;
    @Column(name = "terceiro", nullable = true)
    private String terceiro;
    @Type(type = "yes_no")
    @Column(name = "tipo", nullable = false)
    private Boolean tipo;
    

    public int getIdIp() {
        return idIp;
    }

    public void setIdIp(int idIp) {
        this.idIp = idIp;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public int getColabId() {
        return colabId;
    }

    public void setColabId(int colabId) {
        this.colabId = colabId;
    }

    public int getNumeroIp() {
        return numeroIp;
    }

    public void setNumeroIp(int numeroIp) {
        this.numeroIp = numeroIp;
    }

    public int getFaixa() {
        return faixa;
    }

    public void setFaixa(int faixa) {
        this.faixa = faixa;
    }

    public int getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(int solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getTerceiro() {
        return terceiro;
    }

    public void setTerceiro(String terceiro) {
        this.terceiro = terceiro;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }


    
    
}
