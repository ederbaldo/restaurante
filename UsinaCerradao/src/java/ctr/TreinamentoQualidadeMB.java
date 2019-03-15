/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import dao.Dao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.TreinamentoQualidade;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class TreinamentoQualidadeMB implements Serializable{
    private Dao dao = new Dao();
    private TreinamentoQualidade treinamentoQualidade;
    private List<TreinamentoQualidade> listaTreinamentoQualidade;
    
    
    public TreinamentoQualidadeMB(){
        dao = new Dao();
        //setListaTreinamentoQualidade(new ArrayList<TreinamentoQualidade>());
        buscarTreinamento();
    }
    
    
    public void buscarTreinamento() {
        setListaTreinamentoQualidade(new ArrayList<TreinamentoQualidade>());
        List<Object[]> results = dao.buscarTreinamentoQualidade();
        TreinamentoQualidade trei;

        for (Object[] result : results) {
            trei = new TreinamentoQualidade();
            trei.setIdTreinamento((BigDecimal) result[0]);
            trei.setTreinamento((String) result[1]);
            getListaTreinamentoQualidade().add(trei);

        }
    }
    public TreinamentoQualidade getTreinamentoQualidade() {
        return treinamentoQualidade;
    }

    public void setTreinamentoQualidade(TreinamentoQualidade treinamentoQualidade) {
        this.treinamentoQualidade = treinamentoQualidade;
    }

    public List<TreinamentoQualidade> getListaTreinamentoQualidade() {
        return listaTreinamentoQualidade;
    }

    public void setListaTreinamentoQualidade(List<TreinamentoQualidade> listaTreinamentoQualidade) {
        this.listaTreinamentoQualidade = listaTreinamentoQualidade;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
    
    
    
    
}
