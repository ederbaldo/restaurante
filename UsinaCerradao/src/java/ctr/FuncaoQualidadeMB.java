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
import model.FuncaoQualidadeSgi;
import model.FuncaoTreinamento;
import model.ListaFuncaoFilha;
import model.ListaNovasFuncoes;
import model.TreinamentoQualidade;
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
    private List<FuncaoTreinamento> selectFuncaoTreinamento;
    private List<TreinamentoQualidade> listaTreinamentoQualidade;
    private List<TreinamentoQualidade> selectTreinamentoQualidade;
    private String nomeSelecionado;
    private List<ListaNovasFuncoes> listaNovasFuncoes;
    private ListaFuncaoFilha funcaoFilha;
    private List<ListaFuncaoFilha> listaFuncaoFilhas;
    private List<ListaFuncaoFilha> selectFuncaoFilhas;
    private FuncaoQualidadeSgi funcaoQualidadeSgi;
    private List<FuncaoQualidadeSgi> listaFuncaoQualidadeSgi;

    public FuncaoQualidadeMB() {
        funcaoQualidade = new FuncaoQualidade();
        funcaoTreinamento = new FuncaoTreinamento();
        funcaoQualidadeSgi = new FuncaoQualidadeSgi();
        listaFuncaoQualidade = new ArrayList<FuncaoQualidade>();
        listaTreinamentoQualidade = new ArrayList<TreinamentoQualidade>();
        listaNovasFuncoes = new ArrayList<ListaNovasFuncoes>();
        listaFuncaoFilhas = new ArrayList<ListaFuncaoFilha>();
        buscarFuncao();
        buscarNovaFuncao();
        //buscarFilha();
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

    public void buscarNovaFuncao() {
        List<Object[]> results = dao.BuscarNovaFuncao();
        ListaNovasFuncoes fun;

        for (Object[] result : results) {
            fun = new ListaNovasFuncoes();
            fun.setMatricula((BigDecimal) result[0]);
            fun.setNomeColab((String) result[1]);
            fun.setNomeCargo((String) result[2]);
            fun.setCdCusto((BigDecimal) result[3]);
            fun.setFuncaoId((BigDecimal) result[4]);
            getListaNovasFuncoes().add(fun);
        }

    }

//    public void buscarFuncaoFilha() {
//        List<Object[]> results = dao.BuscarFuncaoFilha();
//        ListaFuncaoFilha fun;
//
//        for (Object[] result : results) {
//            fun = new ListaFuncaoFilha();
//            fun.setNomeCargo((String) result[0]);
//            fun.setFuncaoId((BigDecimal) result[1]);
//            getListaFuncaoFilhas().add(fun);
//        }
//
//    }
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

    public void gravarFuncaoFilha(ActionEvent evt) {
        try {
            for (ListaFuncaoFilha res : selectFuncaoFilhas) {
                funcaoQualidadeSgi.setFuncaoSgi(res.getFuncaoId());
                funcaoQualidadeSgi.setFuncaoQualidade(getFuncaoQualidade());
                System.out.println("-------- " + funcaoQualidadeSgi.getFuncaoQualidade().getIdFuncao() + "  " + funcaoQualidadeSgi.getFuncaoSgi());
                dao.gravar(funcaoQualidadeSgi);
                funcaoQualidadeSgi = new FuncaoQualidadeSgi();
            }

            FacesUtil.addInfoMessage("Informação", "Função vinculado com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    public void excluirTreinamentoVinculado(ActionEvent evt) {
        try {
            BigDecimal idFuncao, ftIdFuncao, resIdTreinamento, ftIdTreinamento;
            for (TreinamentoQualidade res : selectTreinamentoQualidade) {
                //System.out.println("------------ " + getFuncaoQualidade().getIdFuncao());
                //System.out.println("------------ " + res.getIdTreinamento() + " " + res.getTreinamento());
                for (FuncaoTreinamento ft : listaFuncaoTreinamento) {
                    //System.out.println("------------ " + ft.getIdFuncao().getFuncao() + " " + ft.getIdTreinamento().getIdTreinamento());
                    idFuncao = getFuncaoQualidade().getIdFuncao();
                    ftIdFuncao = ft.getIdFuncao().getIdFuncao();
                    resIdTreinamento = res.getIdTreinamento();
                    ftIdTreinamento = ft.getIdTreinamento().getIdTreinamento();
                    //System.out.println("------------ " + idFuncao + "  " + ftIdFuncao + " " + resIdTreinamento + " " + ftIdTreinamento);
                    if (idFuncao.equals(ftIdFuncao) && ftIdTreinamento.equals(resIdTreinamento)) {
                        //System.out.println("------------" + idFuncao + "" + ftIdFuncao + "" + resIdTreinamento + "" + ftIdTreinamento);
                        dao.remover(ft);
                    }
                }
            }

//            for (FuncaoTreinamento res : selectFuncaoTreinamento) {
//                System.out.println("------ " + res);
//                //dao.remover(res);
//            }
            FacesUtil.addInfoMessage("Informação", "Função removido com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    public void excluirFuncaoFilhaVinculado(ActionEvent evt) {
        try {
            BigDecimal idFuncao, fqsIdFuncaoSgi, resId, fqsIdTreinamento;
            for (ListaFuncaoFilha res : selectFuncaoFilhas) {
                //System.out.println("------------ " + getFuncaoQualidade().getIdFuncao());
                //System.out.println("------------ " + res.getIdTreinamento() + " " + res.getTreinamento());
                for (FuncaoQualidadeSgi fqs : listaFuncaoQualidadeSgi) {
                    //System.out.println("------------ " + ft.getIdFuncao().getFuncao() + " " + ft.getIdTreinamento().getIdTreinamento());
                    idFuncao = getFuncaoQualidade().getIdFuncao(); // traz o id da funcaoQualidade

                    fqsIdFuncaoSgi = fqs.getFuncaoSgi(); // traz a funcaoSgi da FuncaoQualidadeSgi 

                    resId = res.getFuncaoId(); //  traz o id da ListaFuncaoFilha

                    fqsIdTreinamento = fqs.getFuncaoQualidade().getIdFuncao(); // traz o id da funcao qalidade

                    if (idFuncao.equals(fqsIdTreinamento) && fqsIdFuncaoSgi.equals(resId)) {
                        System.out.println("------------ " + idFuncao + "  " + fqsIdFuncaoSgi + " " + resId + " " + fqsIdTreinamento);
                        dao.remover(fqs);
                    }
                }
            }

//            for (FuncaoTreinamento res : selectFuncaoTreinamento) {
//                System.out.println("------ " + res);
//                //dao.remover(res);
//            }
            FacesUtil.addInfoMessage("Informação", "Treinamento removido com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

    public void vincularTreinamento() {
        funcaoQualidade = (FuncaoQualidade) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("funcao");
        setTipo(false);
        verificar();
        System.out.println("------------------------------" + funcaoQualidade.getFuncao());
    }

    public void vincularFuncaoFilha() {
        funcaoQualidade = (FuncaoQualidade) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("funcao");
        setTipo(false);
        verificarFuncaoFilha();
        //System.out.println("------------------------------" + funcaoQualidade.getFuncao());

    }

    public void verificar() {
        if (getTipo()) {
            listaTreinamentoQualidade = (List<TreinamentoQualidade>) dao.buscarTreinamentoQualidadeOrderAlfabetica();
        } else {
            listaTreinamentoQualidade = (List<TreinamentoQualidade>) dao.buscarTreinamentoVinculado(funcaoQualidade.getIdFuncao());
            listaFuncaoTreinamento = (List<FuncaoTreinamento>) dao.buscarTreinamentoVinculado2(funcaoQualidade.getIdFuncao());
        }
    }

    public void verificarFuncaoFilha() {
        if (getTipo()) {
            listaFuncaoFilhas = new ArrayList<ListaFuncaoFilha>();
            buscarFilha();
        } else {
            listaFuncaoFilhas = new ArrayList<ListaFuncaoFilha>();
            buscarFilhaVinculado();
            listaFuncaoQualidadeSgi = (List<FuncaoQualidadeSgi>) dao.buscarFuncaoFilhaVinculadas2(funcaoQualidade.getIdFuncao());

//            listaTreinamentoQualidade = (List<TreinamentoQualidade>) dao.buscarTreinamentoVinculado(funcaoQualidade.getIdFuncao());
//            listaFuncaoTreinamento = (List<FuncaoTreinamento>) dao.buscarTreinamentoVinculado2(funcaoQualidade.getIdFuncao());
        }
    }

    public void buscarFilha() {
        List<Object[]> results = dao.BuscarFuncaoFilha();
        ListaFuncaoFilha fun;

        for (Object[] result : results) {
            fun = new ListaFuncaoFilha();
            fun.setNomeCargo((String) result[0]);
            fun.setFuncaoId((BigDecimal) result[1]);
            getListaFuncaoFilhas().add(fun);
        }

    }

    public void buscarFilhaVinculado() {
        List<Object[]> results = dao.BuscarFuncaoFilhaVinculadas(funcaoQualidade.getIdFuncao());
        ListaFuncaoFilha fun;

        for (Object[] result : results) {
            fun = new ListaFuncaoFilha();
            fun.setNomeCargo((String) result[0]);
            fun.setFuncaoId((BigDecimal) result[1]);
            getListaFuncaoFilhas().add(fun);
        }

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

    public void pesquisarFuncaoQualidade() {
        setListaFuncaoQualidade(dao.pesquisarFuncaoQualidade(getNomeSelecionado()));
    }

    public void pesquisarTreinamentoQualidade() {
        setListaTreinamentoQualidade(dao.pesquisarTreinamentolidade(getNomeSelecionado()));
    }

    public void pesquisarTreinamentoVinculado() {
        setListaTreinamentoQualidade(dao.pesquisarTreinamentoVinculado(getNomeSelecionado(), getFuncaoQualidade().getIdFuncao()));
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

    public List<FuncaoTreinamento> getSelectFuncaoTreinamento() {
        return selectFuncaoTreinamento;
    }

    public void setSelectFuncaoTreinamento(List<FuncaoTreinamento> selectFuncaoTreinamento) {
        this.selectFuncaoTreinamento = selectFuncaoTreinamento;
    }

    public String getNomeSelecionado() {
        return nomeSelecionado;
    }

    public void setNomeSelecionado(String nomeSelecionado) {
        this.nomeSelecionado = nomeSelecionado;
    }

    public List<ListaNovasFuncoes> getListaNovasFuncoes() {
        return listaNovasFuncoes;
    }

    public void setListaNovasFuncoes(List<ListaNovasFuncoes> listaNovasFuncoes) {
        this.listaNovasFuncoes = listaNovasFuncoes;
    }

    public List<ListaFuncaoFilha> getListaFuncaoFilhas() {
        return listaFuncaoFilhas;
    }

    public void setListaFuncaoFilhas(List<ListaFuncaoFilha> listaFuncaoFilhas) {
        this.listaFuncaoFilhas = listaFuncaoFilhas;
    }

    public List<ListaFuncaoFilha> getSelectFuncaoFilhas() {
        return selectFuncaoFilhas;
    }

    public void setSelectFuncaoFilhas(List<ListaFuncaoFilha> selectFuncaoFilhas) {
        this.selectFuncaoFilhas = selectFuncaoFilhas;
    }

    public ListaFuncaoFilha getFuncaoFilha() {
        return funcaoFilha;
    }

    public void setFuncaoFilha(ListaFuncaoFilha funcaoFilha) {
        this.funcaoFilha = funcaoFilha;
    }

    public FuncaoQualidadeSgi getFuncaoQualidadeSgi() {
        return funcaoQualidadeSgi;
    }

    public void setFuncaoQualidadeSgi(FuncaoQualidadeSgi funcaoQualidadeSgi) {
        this.funcaoQualidadeSgi = funcaoQualidadeSgi;
    }

    public List<FuncaoQualidadeSgi> getListaFuncaoQualidadeSgi() {
        return listaFuncaoQualidadeSgi;
    }

    public void setListaFuncaoQualidadeSgi(List<FuncaoQualidadeSgi> listaFuncaoQualidadeSgi) {
        this.listaFuncaoQualidadeSgi = listaFuncaoQualidadeSgi;
    }

}
