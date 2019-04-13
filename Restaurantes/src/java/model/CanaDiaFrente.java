/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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

/**
 *
 * @author enascimento
 */
@Entity
@Table(name = "cana_dia_frente")
public class CanaDiaFrente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANA_DIA_FRENTE_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_CANA_DIA_FRENTE", allocationSize = 1, name = "CANA_DIA_FRENTE_SEQ")
    @Column(name = "id_cana_dia_frente", unique = true, nullable = false)
    private int idCanaDiaFrente;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;
    @Column(name = "frente_id", nullable = true)
    private Integer frenteId;
    @Column(name = "frente_descr", nullable = true)
    private String frenteDescr;
    @Column(name = "peso_bruto", nullable = true)
    private Float pesoBruto;
    @Column(name = "ton_cana", nullable = true)
    private Float tonCana;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "frenteId")
    List<FrenteCapacDiaria> listaFrenteCapacDiaria = new ArrayList<FrenteCapacDiaria>();

    public int getIdCanaDiaFrente() {
        return idCanaDiaFrente;
    }

    public void setIdCanaDiaFrente(int idCanaDiaFrente) {
        this.idCanaDiaFrente = idCanaDiaFrente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getFrenteId() {
        return frenteId;
    }

    public void setFrenteId(Integer frenteId) {
        this.frenteId = frenteId;
    }

    public String getFrenteDescr() {
        return frenteDescr;
    }

    public void setFrenteDescr(String frenteDescr) {
        this.frenteDescr = frenteDescr;
    }

    public Float getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(Float pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public Float getTonCana() {
        return tonCana;
    }

    public void setTonCana(Float tonCana) {
        this.tonCana = tonCana;
    }

    public List<FrenteCapacDiaria> getListaFrenteCapacDiaria() {
        return listaFrenteCapacDiaria;
    }

    public void setListaFrenteCapacDiaria(List<FrenteCapacDiaria> listaFrenteCapacDiaria) {
        this.listaFrenteCapacDiaria = listaFrenteCapacDiaria;
    }
    
    
    
}
