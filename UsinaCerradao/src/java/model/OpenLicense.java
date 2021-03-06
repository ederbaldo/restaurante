/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author enascimento
 */
@Entity
@Table(name = "open_license")
public class OpenLicense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OPEN_LICENSE_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_OPEN_LICENSE", allocationSize = 6, name = "OPEN_LICENSE_SEQ")
    @Column(name = "id_open_license", unique = true, nullable = false)
    private Integer idOpenLicense;

    @Column(name = "contrato", nullable = true)
    private Integer contrato;

    public Integer getIdOpenLicense() {
        return idOpenLicense;
    }

    public void setIdOpenLicense(Integer idOpenLicense) {
        this.idOpenLicense = idOpenLicense;
    }

    public Integer getContrato() {
        return contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

 
}
