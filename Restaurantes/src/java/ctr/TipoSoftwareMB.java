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
import model.TipoSoftware;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class TipoSoftwareMB implements Serializable {
    private TipoSoftware tipoSoftware;
    private Dao dao = new Dao();
    List<TipoSoftware> listaTipoSoftware = new ArrayList<TipoSoftware>();
    
    public TipoSoftwareMB(){
        tipoSoftware = new TipoSoftware();
        listaTipoSoftware= new ArrayList<TipoSoftware>();
        listaTipoSoftware = (List<TipoSoftware>) dao.buscarTodos(TipoSoftware.class);
    }
    
    public void gravar (ActionEvent evt)
    {
        try {
            tipoSoftware.toUpperCase();
            dao.gravar(tipoSoftware);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            tipoSoftware = new TipoSoftware();
             FacesUtil.addInfoMessage("Informação", "Tipo Software salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    public TipoSoftware getTipoSoftware() {
        return tipoSoftware;
    }

    public void setTipoSoftware(TipoSoftware tipoSoftware) {
        this.tipoSoftware = tipoSoftware;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<TipoSoftware> getListaTipoSoftware() {
        return listaTipoSoftware;
    }

    public void setListaTipoSoftware(List<TipoSoftware> listaTipoSoftware) {
        this.listaTipoSoftware = listaTipoSoftware;
    }
    
}
