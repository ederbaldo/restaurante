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
import model.FuncaoQualidade;
import model.FuncaoTreinamento;
import model.TreinamentoQualidade;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.annotations.Type;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class FuncaoQualidadeMB implements Serializable {

    Dao dao = new Dao();
    private FuncaoQualidade funcaoQualidade;
    private List<FuncaoQualidade> listaFuncaoQualidade;
    private BigDecimal funcaoID;
    private BigDecimal id;
    private String funcao;
    @Type(type = "yes_no")
    private Boolean tipo;
    private FuncaoTreinamento funcaoTreinamento;
    private List<FuncaoTreinamento> listaFuncaoTreinamento;
    private List<TreinamentoQualidade> listaTreinamentoQualidade;
    private List<TreinamentoQualidade> selectTreinamentoQualidade;

    public FuncaoQualidadeMB() {
        funcaoQualidade = new FuncaoQualidade();
        funcaoTreinamento = new FuncaoTreinamento();
        listaFuncaoQualidade = new ArrayList<FuncaoQualidade>();
        buscarFuncao();
    }

    public void buscarFuncaoSgi() {
//        //setListaColab((List<Colab>) dao.buscarColaborador(mat));
        List<Object[]> results = dao.BuscarFuncaoSGI(getFuncaoID());
        //System.out.println("---------------------" + getFuncaoID());
        results.stream().map((result) -> {
            setId((BigDecimal) result[0]);
            return result;
        }).forEachOrdered((result) -> {
            setFuncao((String) result[1]);
        });

    }

    public void gravar(ActionEvent evt) {
        try {
            System.out.println("---------------------" + getFuncao());
            funcaoQualidade.setFuncao(getFuncao());
            dao.gravar(funcaoQualidade);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            funcaoQualidade = new FuncaoQualidade();
            FacesUtil.addInfoMessage("Informação", "Função salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    public void gravarFuncaoTreinamento(ActionEvent evt) {
        try {
            for (TreinamentoQualidade res : selectTreinamentoQualidade) {
                funcaoTreinamento.setIdTreinamento(res);
                funcaoTreinamento.setIdFuncao(getFuncaoQualidade());
                dao.gravar(funcaoTreinamento);
                funcaoTreinamento = new FuncaoTreinamento();
            }

            FacesUtil.addInfoMessage("Informação", "Treinamento vinculado com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    public void vincularTreinamento() {
        funcaoQualidade = (FuncaoQualidade) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("funcao");
        listaTreinamentoQualidade = (List<TreinamentoQualidade>) dao.buscarTreinamentoQualidadeOrderAlfabetica();
        listaFuncaoTreinamento = (List<FuncaoTreinamento>) dao.buscarTreinamentoVinculado(funcaoQualidade.getIdFuncao());
        System.out.println("------------------------------" + funcaoQualidade.getFuncao());
    }

    public void buscarFuncao() {
        setListaFuncaoQualidade(new ArrayList<FuncaoQualidade>());
        List<Object[]> results = dao.buscarFuncao();
        FuncaoQualidade fun;

        for (Object[] result : results) {
            fun = new FuncaoQualidade();
            fun.setIdFuncao((BigDecimal) result[0]);
            fun.setFuncao((String) result[1]);
            getListaFuncaoQualidade().add(fun);
        }
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public FuncaoQualidade getFuncaoQualidade() {
        return funcaoQualidade;
    }

    public void setFuncaoQualidade(FuncaoQualidade funcaoQualidade) {
        this.funcaoQualidade = funcaoQualidade;
    }

    public List<FuncaoQualidade> getListaFuncaoQualidade() {
        return listaFuncaoQualidade;
    }

    public void setListaFuncaoQualidade(List<FuncaoQualidade> listaFuncaoQualidade) {
        this.listaFuncaoQualidade = listaFuncaoQualidade;
    }

    public BigDecimal getFuncaoID() {
        return funcaoID;
    }

    public void setFuncaoID(BigDecimal funcaoID) {
        this.funcaoID = funcaoID;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public FuncaoTreinamento getFuncaoTreinamento() {
        return funcaoTreinamento;
    }

    public void setFuncaoTreinamento(FuncaoTreinamento funcaoTreinamento) {
        this.funcaoTreinamento = funcaoTreinamento;
    }

    public List<FuncaoTreinamento> getListaFuncaoTreinamento() {
        return listaFuncaoTreinamento;
    }

    public void setListaFuncaoTreinamento(List<FuncaoTreinamento> listaFuncaoTreinamento) {
        this.listaFuncaoTreinamento = listaFuncaoTreinamento;
    }

    public List<TreinamentoQualidade> getListaTreinamentoQualidade() {
        return listaTreinamentoQualidade;
    }

    public void setListaTreinamentoQualidade(List<TreinamentoQualidade> listaTreinamentoQualidade) {
        this.listaTreinamentoQualidade = listaTreinamentoQualidade;
    }

    public List<TreinamentoQualidade> getSelectTreinamentoQualidade() {
        return selectTreinamentoQualidade;
    }

    public void setSelectTreinamentoQualidade(List<TreinamentoQualidade> selectTreinamentoQualidade) {
        this.selectTreinamentoQualidade = selectTreinamentoQualidade;
    }

}
