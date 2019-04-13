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
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Treinamento;
import model.TreinamentoFeito;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class TreinamentoMB implements Serializable {

    private Dao dao = new Dao();
    private List<Treinamento> listaTreinamento;
    private Treinamento treinamento;
    private List<TreinamentoFeito> listaTreinamentoFeito;
    private TreinamentoFeito treinamentoFeito;
    //private BigDecimal id;
    private Integer id;
    private String nomeTreinamento;

    public TreinamentoMB() {
        dao = new Dao();
        //buscarTreinamento();
        setListaTreinamento(new ArrayList<Treinamento>());

    }

    public void buscarTreinamento() throws ParseException {
        setListaTreinamento(new ArrayList<Treinamento>());
        List<Object[]> results = dao.buscarTreinamento(getId());
        System.out.println("----------------id---------------" + getId());
        Treinamento trei;
        Date data = new Date();
        for (Object[] result : results) {
            trei = new Treinamento();
            trei.setIdTreinamento((BigDecimal) result[0]);
            trei.setTreinamento((String) result[1]);
            trei.setCdColab((BigDecimal) result[2]);
            trei.setNomeColab((String) result[3]);
            trei.setNomeCargo((String) result[4]);
            trei.setDescLocalTrab((String) result[5]);
            trei.setValidade((BigDecimal) result[6]);
            trei.setData((Date) result[7]);

            if (trei.getData() != (null)) {
                Calendar cal1 = new GregorianCalendar();
                cal1.setTime(trei.getData());
                Calendar cal2 = new GregorianCalendar();
                cal2.setTime(data);

                Integer validades = trei.getValidade().intValue();

                long dia = ((cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (24 * 60 * 60 * 1000));

                Integer totalDia = (int)(long) dia;
                Integer validade = (validades * 365)-totalDia;
//                System.out.println("Validade = " + validade + " dias");
//                System.out.println("Data Atual = " + data);
//                System.out.println("Data ultimo Treinamento = " + trei.getData() + " dias");
//                System.out.println("Contador = " + (validade - totalDia)  + " dias");
                
                String diasRestantes = String.valueOf(validade);
                trei.setContadorDiasRestantes(diasRestantes);
//                 System.out.println("---------------" + trei.getNomeColab());
//                System.out.println("total de dias = " + dias + " dias");
            }

            getListaTreinamento().add(trei);
            setNomeTreinamento(trei.getTreinamento());

        }
    }

    public void treinamentoFeito(ActionEvent evt) {
        treinamento = (Treinamento) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("treinamento");
        System.out.println("---------------- " + treinamento.getCdColab());
        setListaTreinamentoFeito(new ArrayList<TreinamentoFeito>());
        List<Object[]> results2 = dao.buscarTreinamentoFeito(getId(), treinamento.getCdColab());
        TreinamentoFeito treiFeito;
        for (Object[] result2 : results2) {
            treiFeito = new TreinamentoFeito();
            //treiFeito.setCdColab((BigDecimal) result2[4]);
            //System.out.println("------------- " + trei.getCdColab() + " ------ " + treiFeito.getCdColab());
            treiFeito.setIdTreinamento((BigDecimal) result2[0]);
            treiFeito.setIdCurso((BigDecimal) result2[1]);
            treiFeito.setTurma((BigDecimal) result2[2]);
            treiFeito.setTreinamento((String) result2[3]);
            treiFeito.setCdColab((BigDecimal) result2[4]);
            treiFeito.setNomeColab((String) result2[5]);
            treiFeito.setData((Date) result2[6]);
            getListaTreinamentoFeito().add(treiFeito);
        }
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Treinamento> getListaTreinamento() {
        return listaTreinamento;
    }

    public void setListaTreinamento(List<Treinamento> listaTreinamento) {
        this.listaTreinamento = listaTreinamento;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

//    public BigDecimal getId() {
//        return id;
//    }
//
//    public void setId(BigDecimal id) {
//        this.id = id;
//    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TreinamentoFeito> getListaTreinamentoFeito() {
        return listaTreinamentoFeito;
    }

    public void setListaTreinamentoFeito(List<TreinamentoFeito> listaTreinamentoFeito) {
        this.listaTreinamentoFeito = listaTreinamentoFeito;
    }

    public TreinamentoFeito getTreinamentoFeito() {
        return treinamentoFeito;
    }

    public void setTreinamentoFeito(TreinamentoFeito treinamentoFeito) {
        this.treinamentoFeito = treinamentoFeito;
    }

    public String getNomeTreinamento() {
        return nomeTreinamento;
    }

    public void setNomeTreinamento(String nomeTreinamento) {
        this.nomeTreinamento = nomeTreinamento;
    }

}
