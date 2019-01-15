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
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import model.Computador;
import model.Marca;
import model.NotaFiscal;

import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class ComputadorMB implements Serializable {
    
    private Computador computador;
    private NotaFiscal notaFiscal;
     private Dao dao = new Dao();
     private List<SelectItem> selectMarca; 
    private List<Marca> listaMarca;
    private List<NotaFiscal>listaNf;
    List<Computador> listarComputador= new ArrayList<Computador>();
    private Date teste;

    public ComputadorMB() {
        computador = new  Computador();
        notaFiscal = new  NotaFiscal();
        computador.setMarca(new Marca());
        listarComputador= new ArrayList<Computador>();
        listaNf = new ArrayList<NotaFiscal>();
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

public void buscarNf() throws ParseException {
    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    String sData = fmt.format(computador.getData());
    
    //computador = new  Computador();
    System.out.println("-------------------------------" + computador.getNf());
    System.out.println("-------------------------------" + sData);
    Date data = fmt.parse(sData);
    List<Object[]> results = dao.buscarNfPorCodigo(computador.getNf(),sData);
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
            computador.setFornecedor(nf.getRazaoSocial());
        computador.setNroDanf(nf.getDanf());
        }
        
       
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

    public List<NotaFiscal> getListaNf() {
        return listaNf;
    }

    public void setListaNf(List<NotaFiscal> listaNf) {
        this.listaNf = listaNf;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Date getTeste() {
        return teste;
    }

    public void setTeste(Date teste) {
        this.teste = teste;
    }
    
    

}
