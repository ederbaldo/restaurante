/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import dao.Dao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import model.NotaFiscal;
import model.SerialOpenLicense;
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
    private List<SerialOpenLicense> listaSerialOpen;
    private List<NotaFiscal>listaNf;
    private Dao dao = new Dao();
    List<Software> listaSoftware = new ArrayList<Software>();
    
    public SoftwareMB(){
        software = new Software();
        software.setSerialOpenLicenca(new SerialOpenLicense());
        software.setTipoSoftware(new TipoSoftware());
        listaSoftware= new ArrayList<Software>();
        listaNf = new ArrayList<NotaFiscal>();
        listaSoftware = (List<Software>) dao.buscarTodos(Software.class);
    }
    public void gravar (ActionEvent evt)
    {
        try {
            if(software.getTipo().equals(false))
            {
               software.setSerialOpenLicenca(null); 
            }
            software.setSituacao("ATIVADO");
            dao.gravar(software);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            software = new Software();
             FacesUtil.addInfoMessage("Informação", "Software salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
    public void alterar(){
        software = (Software) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("software");
    }
    public void desativar(ActionEvent evt){
         try {
            if(software.getTipo().equals(false))
            {
               software.setSerialOpenLicenca(null); 
            }
            software.setSituacao("DESATIVADO");
            dao.gravar(software);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            software = new Software();
             FacesUtil.addInfoMessage("Informação", "Software desativado com sucesso!");
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
    public List<SerialOpenLicense> buscarSerialOpen(String nome) {
        setListaSerialOpen((List<SerialOpenLicense>) dao.buscarSerialOpen(nome));
        System.out.println("-----------------nome" + getListaSerialOpen());
        return getListaSerialOpen();
        
    }
    public void buscarNf() throws ParseException {
    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    String sData = fmt.format(software.getData());
    
    //computador = new  Computador();
    System.out.println("-------------------------------" + software.getNf());
    System.out.println("-------------------------------" + sData);
    Date data = fmt.parse(sData);
    List<Object[]> results = dao.buscarNfPorCodigo(software.getNf(),sData);
        NotaFiscal nf = null;
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
            software.setFornecedor(nf.getRazaoSocial());
        software.setDanf(nf.getDanf());
        }
        
       
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

    public List<SerialOpenLicense> getListaSerialOpen() {
        return listaSerialOpen;
    }

    public void setListaSerialOpen(List<SerialOpenLicense> listaSerialOpen) {
        this.listaSerialOpen = listaSerialOpen;
    }

    public List<NotaFiscal> getListaNf() {
        return listaNf;
    }

    public void setListaNf(List<NotaFiscal> listaNf) {
        this.listaNf = listaNf;
    }
    
    
}
