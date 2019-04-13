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
import model.Colab;
import model.ColaboradorTreinamento;
import org.hibernate.annotations.Type;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class ColaboradorTreinamentoMB implements Serializable {

    private ColaboradorTreinamento colabTreinamento;
    private Dao dao;
    private List<ColaboradorTreinamento> listaColaboradorTreinamento;
    private List<Colab> listaColab;
    private String nomeColab;
    @Type(type = "yes_no")
    private Boolean tipo;
    private BigDecimal mat;
    private String nomeSelecionado;
    private BigDecimal empresa;

    public ColaboradorTreinamentoMB() {
        dao = new Dao();
        colabTreinamento = new ColaboradorTreinamento();
        listaColaboradorTreinamento = new ArrayList<ColaboradorTreinamento>();
        listaColab = new ArrayList<Colab>();

    }

    public void typo() {
        if (getTipo()) {
            System.out.println("---------------EMPRESA------------" + getEmpresa());
            System.out.println("---------------matricula------------" + colabTreinamento.getMatricula());
            
            listaColaboradorTreinamento = new ArrayList<ColaboradorTreinamento>();
            buscarColabTreinamentoObrigatorio();
        } else {
            listaColaboradorTreinamento = new ArrayList<ColaboradorTreinamento>();
            buscarColabTreinamentoRealizado();
        }
    }


    public void setarMatricula() {
        colabTreinamento.setMatricula(getMat());
        System.out.println("---------------EMPRESA------------" + getEmpresa());
        listaColaboradorTreinamento = new ArrayList<ColaboradorTreinamento>();
        setTipo(true);
        typo();
        BuscarColab();
    }

    public void buscarColabTreinamentoObrigatorio() {
        List<Object[]> results = dao.buscarColabTreinamentoObrigatorio(colabTreinamento.getMatricula(),getEmpresa());
        ColaboradorTreinamento col = null;
        for (Object[] result : results) {

            col = new ColaboradorTreinamento();
            col.setMatricula((BigDecimal) result[0]);
            col.setNome((String) result[1]);
            col.setIdTreinamento((BigDecimal) result[2]);
            col.setTreinamento((String) result[3]);
            col.setData((Date) result[4]);
            getListaColaboradorTreinamento().add(col);
            setNomeColab(col.getNome());
        }

    }

    public void buscarColabTreinamentoRealizado() {
        List<Object[]> results = dao.buscarColabTreinamentoRealizado(colabTreinamento.getMatricula(),getEmpresa());
        ColaboradorTreinamento col = null;
        for (Object[] result : results) {

            col = new ColaboradorTreinamento();
            col.setMatricula((BigDecimal) result[0]);
            col.setNome((String) result[1]);
            col.setIdTreinamento((BigDecimal) result[2]);
            col.setTreinamento((String) result[3]);
            col.setData((Date) result[4]);
            getListaColaboradorTreinamento().add(col);
            setNomeColab(col.getNome());
        }

    }

    public void BuscarColab() {
        //novoTotal();

        List<Object[]> results = dao.buscarColaboradoresT(colabTreinamento.getMatricula(),getEmpresa());
        Colab colab;
        for (Object[] result : results) {
            colab = new Colab();
            colab.setColabId((BigDecimal) result[0]);
            colab.setMatricula((BigDecimal) result[1]);
            colab.setNome((String) result[2]);
            getListaColab().add(colab);
            setNomeColab(colab.getNome());
        }
    }

    
    public ColaboradorTreinamento getColabTreinamento() {
        return colabTreinamento;
    }

    public void setColabTreinamento(ColaboradorTreinamento colabTreinamento) {
        this.colabTreinamento = colabTreinamento;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<ColaboradorTreinamento> getListaColaboradorTreinamento() {
        return listaColaboradorTreinamento;
    }

    public void setListaColaboradorTreinamento(List<ColaboradorTreinamento> listaColaboradorTreinamento) {
        this.listaColaboradorTreinamento = listaColaboradorTreinamento;
    }

    public String getNomeColab() {
        return nomeColab;
    }

    public void setNomeColab(String nomeColab) {
        this.nomeColab = nomeColab;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMat() {
        return mat;
    }

    public void setMat(BigDecimal mat) {
        this.mat = mat;
    }

    public List<Colab> getListaColab() {
        return listaColab;
    }

    public void setListaColab(List<Colab> listaColab) {
        this.listaColab = listaColab;
    }

    public String getNomeSelecionado() {
        return nomeSelecionado;
    }

    public void setNomeSelecionado(String nomeSelecionado) {
        this.nomeSelecionado = nomeSelecionado;
    }

    public BigDecimal getEmpresa() {
        return empresa;
    }

    public void setEmpresa(BigDecimal empresa) {
        this.empresa = empresa;
    }

    

    
    
}
