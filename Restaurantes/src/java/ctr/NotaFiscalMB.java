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
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.NotaFiscal;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class NotaFiscalMB implements Serializable{
    private Dao dao = new Dao();
    private NotaFiscal nf;
    private List<NotaFiscal>listaNf;
    
    public NotaFiscalMB(){
        dao = new Dao();
        novo();
    }
    private void novo() {
        setListaNf(new ArrayList<NotaFiscal>());
        buscaNotaFical();
     }
    public void buscaNotaFical(){
     List<Object[]> results = dao.buscarNF();
        NotaFiscal nf;
        for (Object[] result : results) {
            nf = new NotaFiscal();
            nf.setNumero((BigDecimal) result[0]);
            nf.setSerie((String) result[1]);
            nf.setData((Date) result[2]);
            nf.setRazaoSocial((String) result[3]);
            nf.setDanf((String) result[4]);
            nf.setCdProduto((String) result[5]);
            nf.setDescrProduto((String) result[6]);
            getListaNf().add(nf);
        }
    }
    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public NotaFiscal getNf() {
        return nf;
    }

    public void setNf(NotaFiscal nf) {
        this.nf = nf;
    }

    public List<NotaFiscal> getListaNf() {
        return listaNf;
    }

    public void setListaNf(List<NotaFiscal> listaNf) {
        this.listaNf = listaNf;
    }

    
    
    
    
    
    
    
}
