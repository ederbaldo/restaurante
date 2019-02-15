/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author enascimento
 */
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

@Entity
@Table(name = "cana_dia_frente")
public class FrenteCapacDiaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FRENTE_CAPAC_DIARIA_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_FRENTE_CAPAC_DIARIA", allocationSize = 1, name = "FRENTE_CAPAC_DIARIA_SEQ")
    @Column(name = "id_cana_dia_frente", unique = true, nullable = false)
    private int idCanaDiaFrente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frente_id", nullable = true, foreignKey = @ForeignKey(name = "id_frente_capac_diaria"))
    private CanaDiaFrente frenteId;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_inic", nullable = false)
    private Date dataInic;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_fim", nullable = false)
    private Date dataFim;
    @Column(name = "capac_colhe", nullable = true)
    private Integer capacColhe;
    

    public int getIdCanaDiaFrente() {
        return idCanaDiaFrente;
    }

    public void setIdCanaDiaFrente(int idCanaDiaFrente) {
        this.idCanaDiaFrente = idCanaDiaFrente;
    }

    public CanaDiaFrente getFrenteId() {
        return frenteId;
    }

    public void setFrenteId(CanaDiaFrente frenteId) {
        this.frenteId = frenteId;
    }

   

    public Date getDataInic() {
        return dataInic;
    }

    public void setDataInic(Date dataInic) {
        this.dataInic = dataInic;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getCapacColhe() {
        return capacColhe;
    }

    public void setCapacColhe(Integer capacColhe) {
        this.capacColhe = capacColhe;
    }

}
