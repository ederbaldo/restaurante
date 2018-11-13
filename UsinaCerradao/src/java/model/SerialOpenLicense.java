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
@Table (name = "serial_open_lincese")
public class SerialOpenLicense implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_serial", unique = true, nullable = false)
    private int idSerial;
    @Column(name = "serial", nullable = true)
    private String serial;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_license", nullable = false, foreignKey = @ForeignKey(name = "id_tipo_license_serial_open_lincese"))
    private TipoLicense idTipoLicense;

    public int getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(int idSerial) {
        this.idSerial = idSerial;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoLicense getIdTipoLicense() {
        return idTipoLicense;
    }

    public void setIdTipoLicense(TipoLicense idTipoLicense) {
        this.idTipoLicense = idTipoLicense;
    }


   
    
    
}
