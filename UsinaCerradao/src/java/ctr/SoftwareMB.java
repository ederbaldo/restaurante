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
import javax.faces.model.SelectItem;
import model.Software;
import model.TipoSoftware;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class SoftwareMB implements Serializable{
    private Software software;
    private List<TipoSoftware> listaTipoSoftware;
    private List<SelectItem> selectTipoSoftware;
    private Dao dao = new Dao();
    List<Software> listaSoftware = new ArrayList<Software>();
    
    public SoftwareMB(){
        software = new Software();
        software.setTipoSoftware(new TipoSoftware());
        listaSoftware= new ArrayList<Software>();
        listaSoftware = (List<Software>) dao.buscarTodos(Software.class);
    }
    public void gravar (ActionEvent evt)
    {
        try {
            software.setSituacao("Ativo");
            dao.gravar(software);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            software = new Software();
             FacesUtil.addInfoMessage("Informação", "Software salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
    public List<SelectItem> getSelectTipoSoftware() {
        selectTipoSoftware = new ArrayList<SelectItem>();
        listaTipoSoftware = new ArrayList<TipoSoftware>();
        listaTipoSoftware = (List<TipoSoftware>) dao.buscarTodos(TipoSoftware.class);
        selectTipoSoftware.add(new SelectItem(0, "Selecione"));
        for (TipoSoftware c : listaTipoSoftware) {
            selectTipoSoftware.add(new SelectItem(c.getIdTipoSoftware(), c.getDescricao()));
        }
        return selectTipoSoftware;
    }
    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public List<TipoSoftware> getListaTipoSoftware() {
        return listaTipoSoftware;
    }

    public void setListaTipoSoftware(List<TipoSoftware> listaTipoSoftware) {
        this.listaTipoSoftware = listaTipoSoftware;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Software> getListaSoftware() {
        return listaSoftware;
    }

    public void setListaSoftware(List<Software> listaSoftware) {
        this.listaSoftware = listaSoftware;
    }


    public void setSelectTipoSoftware(List<SelectItem> selectTipoSoftware) {
        this.selectTipoSoftware = selectTipoSoftware;
    }
    
    
}
