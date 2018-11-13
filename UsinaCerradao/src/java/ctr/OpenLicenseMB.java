/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import dao.Dao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
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
    private OpenLicense openLicense;
    private TipoLicense tipoLicense;
    private SerialOpenLicense serialOpenLicense;
    List<OpenLicense> listaOpenLicense = new ArrayList<OpenLicense>();
    private Dao dao = new Dao();
    
    public OpenLicenseMB(){
        novo();
    }

    public void novo(){
        openLicense = new OpenLicense();
        tipoLicense= new TipoLicense();
        tipoLicense.setIdOpenLicense(new OpenLicense());
        listaOpenLicense= new ArrayList<OpenLicense>();
        listaOpenLicense = (List<OpenLicense>) dao.buscarTodos(OpenLicense.class);
    }
    public void gravar (ActionEvent evt)
    {
        try {
            tipoLicense.setIdOpenLicense(openLicense);
            openLicense.getListaTipoLicense().add(tipoLicense);
            dao.gravar(openLicense);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/

             FacesUtil.addInfoMessage("Informação", "Open License salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
    public void adicionar(ActionEvent evt){
        
    }
    public OpenLicense getOpenLicense() {
        return openLicense;
    }

    public void setOpenLicense(OpenLicense openLicense) {
        this.openLicense = openLicense;
    }

    public TipoLicense getTipoLicense() {
        return tipoLicense;
    }

    public void setTipoLicense(TipoLicense tipoLicense) {
        this.tipoLicense = tipoLicense;
    }

    public SerialOpenLicense getSerialOpenLicense() {
        return serialOpenLicense;
    }

    public void setSerialOpenLicense(SerialOpenLicense serialOpenLicense) {
        this.serialOpenLicense = serialOpenLicense;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    
    
    
}
