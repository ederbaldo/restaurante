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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import model.License;
import model.ListaOpenLicense;
import model.Marca;
import model.OpenLicense;
import model.SerialOpenLicense;
import model.TipoLicense;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class OpenLicenseMB implements Serializable {

    private Dao dao = new Dao();
    private OpenLicense openLicense;
    private List<OpenLicense> listarContrato;
    private TipoLicense tipoLicenca;
    private List<TipoLicense> listaTipoLicense;
    private List<ListaOpenLicense> listaTabelaOpenLicense;
    private ListaOpenLicense tabelaOpenLicense;
    private List<License>listaLicense;

    public OpenLicenseMB() {
        novo();
    }

    public void novo() {
        dao = new Dao();
        openLicense = new OpenLicense();
        tipoLicenca = new TipoLicense();
        tabelaOpenLicense = new ListaOpenLicense();
        //listaOpenLicense = new ArrayList<OpenLicense>();
        //listaTipoLicense = new ArrayList<TipoLicense>();
        setListaTabelaOpenLicense(new ArrayList<ListaOpenLicense>());
        tabOpenLicense();
    }

    public void gravar(ActionEvent evt) {
        try {
            dao.gravar(openLicense);
            openLicense = new OpenLicense();

            FacesUtil.addInfoMessage("Informação", " Contrato salvo com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    public void adicionar() {
        tabelaOpenLicense = (ListaOpenLicense) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("openLicense");
        openLicense.setIdOpenLicense(tabelaOpenLicense.getIdOpen().intValue());
        openLicense.setContrato(tabelaOpenLicense.getContrato().intValue());
        tipoLicenca.setIdOpenLicense(openLicense);
        //System.out.println("----------------------------" + tipoLicenca.getIdOpenLicense().getIdOpenLicense());
        listaTipoLicense = (List<TipoLicense>) dao.buscarContrato(tabelaOpenLicense.getIdOpen());

    }

    public void gravarTipoLicenca(ActionEvent evt) {
        try {
            
            tipoLicenca.setIdOpenLicense(openLicense);
            //tipoLicenca.setIdOpenLicense(tabelaOpenLicense.getIdOpen().intValue());
            dao.gravar(tipoLicenca);
            tipoLicenca = new TipoLicense();

            FacesUtil.addInfoMessage("Informação", " Tipo de Licença salvo com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    
    public void tabOpenLicense() {
        //setListaTabelaOpenLicense(new ArrayList<ListaOpenLicense>());
        List<Object[]> results = dao.listarTabelaOpenLicense();
        ListaOpenLicense lis;

        for (Object[] result : results) {
            lis = new ListaOpenLicense();
            lis.setContrato((BigDecimal) result[0]);
            lis.setTipoDescricao((String) result[1]);
            lis.setTipofornecedor((String) result[2]);
            lis.setTipoQtde((BigDecimal) result[3]);
            lis.setIdOpen((BigDecimal) result[4]);
            getListaTabelaOpenLicense().add(lis);
        }
    }

    public List<License> buscarLicense(String nome){
        setListaLicense((List<License>) dao.buscarLicense(nome));
        return getListaLicense();
    }
    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public OpenLicense getOpenLicense() {
        return openLicense;
    }

    public void setOpenLicense(OpenLicense openLicense) {
        this.openLicense = openLicense;
    }

    public List<OpenLicense> getListarContrato() {
        return listarContrato;
    }

    public void setListarContrato(List<OpenLicense> listarContrato) {
        this.listarContrato = listarContrato;
    }

    public TipoLicense getTipoLicenca() {
        return tipoLicenca;
    }

    public void setTipoLicenca(TipoLicense tipoLicenca) {
        this.tipoLicenca = tipoLicenca;
    }

    public List<TipoLicense> getListaTipoLicense() {
        return listaTipoLicense;
    }

    public void setListaTipoLicense(List<TipoLicense> listaTipoLicense) {
        this.listaTipoLicense = listaTipoLicense;
    }

    public List<ListaOpenLicense> getListaTabelaOpenLicense() {
        return listaTabelaOpenLicense;
    }

    public void setListaTabelaOpenLicense(List<ListaOpenLicense> listaTabelaOpenLicense) {
        this.listaTabelaOpenLicense = listaTabelaOpenLicense;
    }

    public ListaOpenLicense getTabelaOpenLicense() {
        return tabelaOpenLicense;
    }

    public List<License> getListaLicense() {
        return listaLicense;
    }

    public void setListaLicense(List<License> listaLicense) {
        this.listaLicense = listaLicense;
    }

    

}
