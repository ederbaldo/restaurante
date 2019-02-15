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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Computador;
import model.ComputadorSoftware;
import model.Software;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class ComputadorSoftwareMB implements Serializable {

    private ComputadorSoftware compSoft;
    private Dao dao = new Dao();
    private List<Computador> listaComputador;
    private List<Software> listaSoftware;
    private String micro;
    private String software;
    private String teste;
    List<ComputadorSoftware> listarCompSoft = new ArrayList<ComputadorSoftware>();

    public ComputadorSoftwareMB() {
        compSoft = new ComputadorSoftware();
        compSoft.setComputador(new Computador());
        compSoft.setSoftware(new Software());
        listarCompSoft = new ArrayList<ComputadorSoftware>();
        listarCompSoft = (List<ComputadorSoftware>) dao.buscarTodos(ComputadorSoftware.class);
    }

    public void gravar(ActionEvent evt) {
        try {
            dao.gravar(compSoft);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            compSoft = new ComputadorSoftware();
            FacesUtil.addInfoMessage("Informação", "Relacionamento salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    public void alterar() {
        compSoft = (ComputadorSoftware) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("compSoft");
    }

    public void excluir(ActionEvent evt) {
        try {
            dao.remover(compSoft);
            compSoft = new ComputadorSoftware();
            FacesUtil.addInfoMessage("Informação", "Relacionamento excluido com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }

    }

    public List<Software> buscarSoftware(String nome) {
        setListaSoftware((List<Software>) dao.buscarSoftware(nome));
        return getListaSoftware();
    }

    public void buscarSoftRelacionadoMicro() {
        List<Object[]> results = dao.buscarSoftRelacionadoMicro(compSoft.getSoftware().getKey());
        results.stream().map((result) -> {
            setMicro((String) result[0]);
            return result;
        }).forEachOrdered((result) -> {
            setSoftware((String) result[1]);
            if (result != null) {
                FacesUtil.addWarnMessage("Informação", " Licensa ja relacionada com o " + getMicro());
            }
        });
        setTeste(getMicro());
        System.out.println("----------------------" + getTeste());
    }

    public List<Computador> buscarComputador(String nome) {
        setListaComputador((List<Computador>) dao.buscarComputador(nome));
        return getListaComputador();
    }

    public ComputadorSoftware getCompSoft() {
        return compSoft;
    }

    public void setCompSoft(ComputadorSoftware compSoft) {
        this.compSoft = compSoft;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Computador> getListaComputador() {
        return listaComputador;
    }

    public void setListaComputador(List<Computador> listaComputador) {
        this.listaComputador = listaComputador;
    }

    public List<Software> getListaSoftware() {
        return listaSoftware;
    }

    public void setListaSoftware(List<Software> listaSoftware) {
        this.listaSoftware = listaSoftware;
    }

    public List<ComputadorSoftware> getListarCompSoft() {
        return listarCompSoft;
    }

    public void setListarCompSoft(List<ComputadorSoftware> listarCompSoft) {
        this.listarCompSoft = listarCompSoft;
    }

    public String getMicro() {
        return micro;
    }

    public void setMicro(String micro) {
        this.micro = micro;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

}
