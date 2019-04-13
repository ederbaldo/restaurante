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
import model.Colab;
import model.Computador;
import model.Ip;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class IpMB implements Serializable {
    private Ip ip;
    private List<SelectItem> selectComputador; 
    private List<Computador> listaComputador;
    private Dao dao = new Dao();
    private List<Ip> listarIp= new ArrayList<Ip>();
    private Colab colab;
    private Integer colabId;
    private Integer solicitanteId;
    private String colabSelecionado;
    private String solicitantecolabSelecionado;
    private List<Colab> listaColab;
    private String nomeSeleconado;
    private BigDecimal matricula;
    private String nomeColab;
    
    public IpMB(){
        ip = new Ip();
        ip.setComputador(new Computador());
        colab = new Colab();
        listarIp= new ArrayList<Ip>();
        listaColab = new ArrayList<Colab>();
        listarIp = (List<Ip>) dao.buscarTodos(Ip.class);
        //BuscarColab();
    }
    public List<Computador> buscarComputador(String nome) {
        setListaComputador((List<Computador>) dao.buscarComputador(nome));
        return getListaComputador();
    }
    public void buscarColaboradores() {
//        //setListaColab((List<Colab>) dao.buscarColaborador(mat));
        
        List<Object[]> results = dao.buscarColaboradores(getMatricula());
        Colab colab = null;
        
        for (Object[] result : results) {
            colab = new Colab();
            colab.setColabId((BigDecimal) result[0]);
            colab.setMatricula((BigDecimal) result[1]);
            colab.setNome((String) result[2]);
            getListaColab().add(colab);
            ip.setColabId(colab.getColabId());
            setMatricula(colab.getMatricula());
            setNomeColab(colab.getNome());
            
        }       
    }
    public void buscarColaboradoresId() {

    }
    public void buscarMicro(ActionEvent evt) {
        ip = (Ip) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("ip");
        System.out.println("-------------" + ip.getColabId());
        List<Object[]> results = dao.buscarColaboradoresId(ip.getColabId());
        Colab colab = null;
        
        for (Object[] result : results) {
            colab = new Colab();
            colab.setColabId((BigDecimal) result[0]);
            colab.setMatricula((BigDecimal) result[1]);
            colab.setNome((String) result[2]);
            getListaColab().add(colab);
            setMatricula(colab.getMatricula());
            setNomeColab(colab.getNome());
            
        }       
        System.out.println("-------------" + getNomeColab());
    }
    public void gravar (ActionEvent evt)
    {
        try {
            dao.gravar(ip);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            ip = new Ip();
             FacesUtil.addInfoMessage("Informação", "Ip salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
    public void BuscarColaboradores() {
        //novoTotal();
        
    }
    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }

    public List<SelectItem> getSelectComputador() {
        return selectComputador;
    }

    public void setSelectComputador(List<SelectItem> selectComputador) {
        this.selectComputador = selectComputador;
    }

    public List<Computador> getListaComputador() {
        return listaComputador;
    }

    public void setListaComputador(List<Computador> listaComputador) {
        this.listaComputador = listaComputador;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Ip> getListarIp() {
        return listarIp;
    }

    public void setListarIp(List<Ip> listarIp) {
        this.listarIp = listarIp;
    }

    public Integer getColabId() {
        return colabId;
    }

    public void setColabId(Integer colabId) {
        this.colabId = colabId;
    }

    public Integer getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Integer solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public String getColabSelecionado() {
        return colabSelecionado;
    }

    public void setColabSelecionado(String colabSelecionado) {
        this.colabSelecionado = colabSelecionado;
    }

    public String getSolicitantecolabSelecionado() {
        return solicitantecolabSelecionado;
    }

    public void setSolicitantecolabSelecionado(String solicitantecolabSelecionado) {
        this.solicitantecolabSelecionado = solicitantecolabSelecionado;
    }

    public List<Colab> getListaColab() {
        return listaColab;
    }

    public void setListaColab(List<Colab> listaColab) {
        this.listaColab = listaColab;
    }

    public String getNomeSeleconado() {
        return nomeSeleconado;
    }

    public void setNomeSeleconado(String nomeSeleconado) {
        this.nomeSeleconado = nomeSeleconado;
    }

    public BigDecimal getMatricula() {
        return matricula;
    }

    public void setMatricula(BigDecimal matricula) {
        this.matricula = matricula;
    }

    

    public String getNomeColab() {
        return nomeColab;
    }

    public void setNomeColab(String nomeColab) {
        this.nomeColab = nomeColab;
    }

    public Colab getColab() {
        return colab;
    }

    public void setColab(Colab colab) {
        this.colab = colab;
    }

    
    
    
}
