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
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.CanaDiaFrente;
import model.FrenteCapacDiaria;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class CanaDiaFrenteMB implements Serializable {

    private CanaDiaFrente canaDiaFrente;
    private FrenteCapacDiaria frenteCapac;
    private Dao dao = new Dao();
    private List<CanaDiaFrente> litaCanaDiaFrente;
    private List<FrenteCapacDiaria> litaFrenteCapacDiaria;

    public CanaDiaFrenteMB() {
        dao = new Dao();
        novo();
    }

    public void novo() {
        setLitaCanaDiaFrente(new ArrayList<CanaDiaFrente>());
        //entradaDeCanaFrente();
        canaDiaFrente.setListaFrenteCapacDiaria(new ArrayList<FrenteCapacDiaria>());
    }

//    public void entradaDeCanaFrente() {
//        List<Object[]> results = dao.buscarEntradaDeCanaFrente();
//
//        CanaDiaFrente canaDiaFrentes;
//        DecimalFormat df = new DecimalFormat("0.00%");
//        for (Object[] result : results) {
//            canaDiaFrentes = new CanaDiaFrente();
//            canaDiaFrentes.setFrente((String) result[0]);
//            canaDiaFrentes.setCapacColhe((BigDecimal) result[1]);
//            canaDiaFrentes.setTotal((BigDecimal) result[2]);
//            canaDiaFrentes.setFrenteId((BigDecimal) result[3]);
//            canaDiaFrentes.setDataInic((Date) result[4]);
//            canaDiaFrentes.setDataFim((Date) result[5]);
//            Float CapacColhe = canaDiaFrentes.getCapacColhe().floatValue();
//            Float tot = canaDiaFrentes.getTotal().floatValue();
//            System.out.println("-------------" + CapacColhe + tot);
//            canaDiaFrentes.setCota(df.format((CapacColhe) / tot));
//            System.out.println("-------------" + canaDiaFrentes.getCota());
//            System.out.println("------------- frente id" + canaDiaFrentes.getFrenteId());
//            System.out.println("------------- data inicio" + canaDiaFrentes.getDataInic());
//            System.out.println("-------------data fim" + canaDiaFrentes.getDataFim());
//
//            getLitaCanaDiaFrente().add(canaDiaFrentes);
//            List<Object[]> resultado = dao.buscarEntradaDeCanaFrente2(canaDiaFrentes.getFrenteId());
//            for (Object[] resul : resultado) {
//                canaDiaFrentes = new CanaDiaFrente();
//                canaDiaFrentes.setTonCana(((Long) resul[0]));
//                getLitaCanaDiaFrente().add(canaDiaFrentes);
//            }
//             getLitaCanaDiaFrente().add(canaDiaFrentes);
//        }

//    }

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

    public List<FrenteCapacDiaria> getLitaFrenteCapacDiaria() {
        return litaFrenteCapacDiaria;
    }

    public void setLitaFrenteCapacDiaria(List<FrenteCapacDiaria> litaFrenteCapacDiaria) {
        this.litaFrenteCapacDiaria = litaFrenteCapacDiaria;
    }

    public FrenteCapacDiaria getFrenteCapac() {
        return frenteCapac;
    }

    public void setFrenteCapac(FrenteCapacDiaria frenteCapac) {
        this.frenteCapac = frenteCapac;
    }

}
