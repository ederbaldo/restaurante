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
import javax.faces.event.ActionEvent;
import model.TreinamentoQualidade;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class TreinamentoQualidadeMB implements Serializable {

    private Dao dao = new Dao();
    private TreinamentoQualidade treinamentoQualidade;
    private List<TreinamentoQualidade> listaTreinamentoQualidade;
    private BigDecimal funcaoID;
    private BigDecimal id;
    private String treinamento;

    public TreinamentoQualidadeMB() {
        treinamentoQualidade = new TreinamentoQualidade();
        listaTreinamentoQualidade = new ArrayList<TreinamentoQualidade>();
        //setListaTreinamentoQualidade(new ArrayList<TreinamentoQualidade>());
        buscarTreinamento();
    }

    public void buscarFuncaoSgi() {
//        //setListaColab((List<Colab>) dao.buscarColaborador(mat));
        List<Object[]> results = dao.BuscarFuncaoSGI(getFuncaoID());
        //System.out.println("---------------------" + getFuncaoID());
        results.stream().map((result) -> {
            setId((BigDecimal)result[0]);
            return result;
        }).forEachOrdered((result) -> {
            setTreinamento((String) result[1]);
        });
        
    }
    public void gravar(ActionEvent evt) {
        try {
            System.out.println("---------------------" + getTreinamento());
            treinamentoQualidade.setTreinamento(getTreinamento());
            dao.gravar(treinamentoQualidade);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            treinamentoQualidade = new TreinamentoQualidade();
            FacesUtil.addInfoMessage("Informação", "Treinamento salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
    public void buscarTreinamento() {
        setListaTreinamentoQualidade(new ArrayList<TreinamentoQualidade>());
        List<Object[]> results = dao.buscarTreinamentoQualidade();
        TreinamentoQualidade trei;

        for (Object[] result : results) {
            trei = new TreinamentoQualidade();
            trei.setIdTreinamento((BigDecimal) result[0]);
            trei.setTreinamento((String) result[1]);
            getListaTreinamentoQualidade().add(trei);

        }
    }

    public TreinamentoQualidade getTreinamentoQualidade() {
        return treinamentoQualidade;
    }

    public void setTreinamentoQualidade(TreinamentoQualidade treinamentoQualidade) {
        this.treinamentoQualidade = treinamentoQualidade;
    }

    public List<TreinamentoQualidade> getListaTreinamentoQualidade() {
        return listaTreinamentoQualidade;
    }

    public void setListaTreinamentoQualidade(List<TreinamentoQualidade> listaTreinamentoQualidade) {
        this.listaTreinamentoQualidade = listaTreinamentoQualidade;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
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

    public String getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(String treinamento) {
        this.treinamento = treinamento;
    }

}
