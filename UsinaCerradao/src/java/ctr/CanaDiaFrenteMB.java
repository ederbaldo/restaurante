/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import model.CanaDiaFrente;

/**
 *
 * @author enascimento
 */
public class CanaDiaFrenteMB implements Serializable{
    
    private CanaDiaFrente canaDiaFrente;
    private Dao dao = new Dao();
    private List<CanaDiaFrente> litaCanaDiaFrente;
    
    public CanaDiaFrenteMB(){
        
    }

    public CanaDiaFrente getCanaDiaFrente() {
        return canaDiaFrente;
    }

    public void setCanaDiaFrente(CanaDiaFrente canaDiaFrente) {
        this.canaDiaFrente = canaDiaFrente;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<CanaDiaFrente> getLitaCanaDiaFrente() {
        return litaCanaDiaFrente;
    }

    public void setLitaCanaDiaFrente(List<CanaDiaFrente> litaCanaDiaFrente) {
        this.litaCanaDiaFrente = litaCanaDiaFrente;
    }
    
}
