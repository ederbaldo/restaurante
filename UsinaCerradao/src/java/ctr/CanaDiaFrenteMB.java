/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import dao.Dao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.CanaDiaFrente;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class CanaDiaFrenteMB implements Serializable {

    private CanaDiaFrente canaDiaFrente;
    private Dao dao = new Dao();
    private List<CanaDiaFrente> litaCanaDiaFrente;

    public CanaDiaFrenteMB() {
        dao = new Dao();
        novo();
    }

    public void novo() {
        setLitaCanaDiaFrente(new ArrayList<CanaDiaFrente>());
        entradaDeCanaFrente();
    }

    public void entradaDeCanaFrente() {
        List<Object[]> results = dao.buscarEntradaDeCanaFrente();
        List<Object[]> resul = dao.buscarEntradaDeCanaFrente();
        CanaDiaFrente canaDiaFrentes;
        DecimalFormat df = new DecimalFormat("0.00%");
        for (Object[] result : results) {
            canaDiaFrentes = new CanaDiaFrente();
            canaDiaFrentes.setFrente((String) result[0]);
            canaDiaFrentes.setCapacColhe((BigDecimal) result[1]);
            canaDiaFrentes.setTotal((BigDecimal) result[2]);
            Float CapacColhe = canaDiaFrentes.getCapacColhe().floatValue();
            Float tot = canaDiaFrentes.getTotal().floatValue();
            System.out.println("-------------" + CapacColhe + tot );
            canaDiaFrentes.setCota(df.format((CapacColhe)/tot));
            System.out.println("-------------" + canaDiaFrentes.getCota());
            getLitaCanaDiaFrente().add(canaDiaFrentes);

        }

        
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
