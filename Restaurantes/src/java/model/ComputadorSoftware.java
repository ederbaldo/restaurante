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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author enascimento
 */
@Entity
@Table (name = "computador_software")
public class ComputadorSoftware implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPUTADOR_SOFTWARE_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_COMPUTADOR_SOFTWARE", allocationSize = 1, name = "COMPUTADOR_SOFTWARE_SEQ")
    @Column(name = "id_computador_software",  unique = true, nullable = false)
    private int idComputadorSoftware;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_computador", nullable = false, foreignKey = @ForeignKey(name = "id_comp_soft_computador"))
    private Computador computador;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_software", nullable = false, foreignKey = @ForeignKey(name = "id_comp_soft_software"))
    private Software software;

    
    public int getIdComputadorSoftware() {
        return idComputadorSoftware;
    }

    public void setIdComputadorSoftware(int idComputadorSoftware) {
        this.idComputadorSoftware = idComputadorSoftware;
    }
    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }
    
    
}
