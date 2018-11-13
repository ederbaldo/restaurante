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
import model.Computador;
import model.Marca;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class ComputadorMB implements Serializable {
    
    private Computador computador;
     private Dao dao = new Dao();
     private List<SelectItem> selectMarca; 
    private List<Marca> listaMarca;
    List<Computador> listarComputador= new ArrayList<Computador>();

    public ComputadorMB() {
        computador = new  Computador();
        computador.setMarca(new Marca());
        listarComputador= new ArrayList<Computador>();
        listarComputador = (List<Computador>) dao.buscarTodos(Computador.class);
    }
    public void gravar (ActionEvent evt)
    {
        try {
            computador.toUpperCase();
            dao.gravar(computador);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            computador = new Computador();
             FacesUtil.addInfoMessage("Informação", "Computador salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
public List<SelectItem> getSelectMarca() {
        selectMarca = new ArrayList<SelectItem>();
        listaMarca = new ArrayList<Marca>();
        listaMarca = (List<Marca>) dao.buscarTodos(Marca.class);
        selectMarca.add(new SelectItem(0, "Selecione"));
        for (Marca c : listaMarca) {
            selectMarca.add(new SelectItem(c.getIdMarca(), c.getDescricao()));
        }
        return selectMarca;
    }
    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Computador> getListarComputador() {
        return listarComputador;
    }

    public void setListarComputador(List<Computador> listarComputador) {
        this.listarComputador = listarComputador;
    }

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public void setSelectMarca(List<SelectItem> selectMarca) {
        this.selectMarca = selectMarca;
    }
    
    

}
