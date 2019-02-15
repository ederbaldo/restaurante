/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import dao.Dao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.Computador;
import model.OpenLicense;
import model.TipoLicense;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class TipoLicenseMB implements Serializable {

    private TipoLicense tipoLicense;
    private OpenLicense openLicense;
    private List<OpenLicense> listaOpenLicense;
    private Dao dao = new Dao();
    List<TipoLicense> listaTipoLincense = new ArrayList<TipoLicense>();
    private BigDecimal numeroContrato;
    private BigDecimal idContrato;
    
    public TipoLicenseMB() {
        novo();
    }

    public void novo() {
        
        tipoLicense = new TipoLicense();
        listaTipoLincense = new ArrayList<TipoLicense>();
        listaTipoLincense = (List<TipoLicense>) dao.buscarTodos(TipoLicense.class);

        
    }
    
     public void gravar(ActionEvent evt) {
        try {
            //       
            dao.gravar(tipoLicense);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            tipoLicense = new TipoLicense();
            buscarTabelaTipoLicense(getIdContrato());
            FacesUtil.addInfoMessage("Informação", "Tipo License salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
     
     public void buscarContrato() throws ParseException {
        List<Object[]> results = dao.buscarContrato(getNumeroContrato());
        results.stream().map((result) -> {
            setIdContrato((BigDecimal) result[0]);
            return result;
        }).forEachOrdered((result) -> {
            setNumeroContrato((BigDecimal) result[1]);
        });
        tipoLicense.setIdOpenLicense(getIdContrato());  
        System.out.println("-----------ID CONTRATO----------- " + getIdContrato());
        System.out.println("-----------NUMERO CONTRATO-----------" + getNumeroContrato());
        buscarTabelaTipoLicense(getIdContrato());

    }
     public List<OpenLicense> buscarTabelaTipoLicense(BigDecimal numero) {
        setListaTipoLincense((List<TipoLicense>) dao.buscarTabelaTipoLicense(numero));
        return getListaOpenLicense();
    }

    public TipoLicense getTipoLicense() {
        return tipoLicense;
    }

    public void setTipoLicense(TipoLicense tipoLicense) {
        this.tipoLicense = tipoLicense;
    }

    public List<OpenLicense> getListaOpenLicense() {
        return listaOpenLicense;
    }

    public void setListaOpenLicense(List<OpenLicense> listaOpenLicense) {
        this.listaOpenLicense = listaOpenLicense;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<TipoLicense> getListaTipoLincense() {
        return listaTipoLincense;
    }

    public void setListaTipoLincense(List<TipoLicense> listaTipoLincense) {
        this.listaTipoLincense = listaTipoLincense;
    }

    public BigDecimal getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(BigDecimal numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public BigDecimal getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(BigDecimal idContrato) {
        this.idContrato = idContrato;
    }

    public OpenLicense getOpenLicense() {
        return openLicense;
    }

    public void setOpenLicense(OpenLicense openLicense) {
        this.openLicense = openLicense;
    }

    
       
}
