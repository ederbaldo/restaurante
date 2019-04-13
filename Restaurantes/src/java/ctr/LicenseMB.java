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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.License;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class LicenseMB implements Serializable {
    private Dao dao = new Dao();
    private License license;
    private List<License>listaLicense;
    private String nomeSelecionado;
    
    public LicenseMB(){
        license = new  License();
        listaLicense= new ArrayList<License>();
        listaLicense = (List<License>) dao.buscarTodos(License.class);
    }
    
    public void gravar (ActionEvent evt)
    {
        try {
            dao.gravar(license);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            license = new License();
             FacesUtil.addInfoMessage("Informação", "Licença salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
    public void alterar(){
        license = (License) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("tipoLicenca");
    }
    public void excluir (ActionEvent evt)
    {
        try {
            license = (License) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("tipoLicenca");
            dao.remover(license);
            license = new License();
             FacesUtil.addInfoMessage("Informação", "Licença excluida com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
    public void pesquisarLicense(){
        setListaLicense(dao.pesquisarLicense(getNomeSelecionado()));
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public List<License> getListaLicense() {
        return listaLicense;
    }

    public void setListaLicense(List<License> listaLicense) {
        this.listaLicense = listaLicense;
    }

    public String getNomeSelecionado() {
        return nomeSelecionado;
    }

    public void setNomeSelecionado(String nomeSelecionado) {
        this.nomeSelecionado = nomeSelecionado;
    }
    
    
    
}
