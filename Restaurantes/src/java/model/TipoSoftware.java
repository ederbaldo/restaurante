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
@Table (name = "tipo_software")
public class TipoSoftware implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_SOFTWARE_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_TIPO_SOFTWARE", allocationSize = 1, name = "TIPO_SOFTWARE_SEQ")
    @Column(name = "id_tipo_software", unique = true, nullable = false)
    private int idTipoSoftware;
    @Column(name = "descricao", length = 20, nullable = false)
    private String descricao;

    public int getIdTipoSoftware() {
        return idTipoSoftware;
    }

    public void setIdTipoSoftware(int idTipoSoftware) {
        this.idTipoSoftware = idTipoSoftware;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void toUpperCase() {
        this.setDescricao(this.getDescricao().toUpperCase());
    }
}
