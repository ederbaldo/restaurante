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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.NotaFiscal;
import model.OpenLicense;
import model.SerialOpenLicense;
import model.TipoLicense;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class OpenLicenseMB implements Serializable {

    private OpenLicense openLicense;
    private TipoLicense tipoLicense;
    private SerialOpenLicense serialOpenLicense;
    List<OpenLicense> listaOpenLicense = new ArrayList<OpenLicense>();
    private Dao dao = new Dao();
    private BigDecimal numeroContrato;
    private BigDecimal idContrato;

    public OpenLicenseMB() {
        novo();
    }

    public void novo() {
        openLicense = new OpenLicense();
        tipoLicense = new TipoLicense();
        serialOpenLicense = new SerialOpenLicense();
        listaOpenLicense = new ArrayList<OpenLicense>();
        listaOpenLicense = (List<OpenLicense>) dao.buscarTodos(OpenLicense.class);
    }

    public void gravar(ActionEvent evt) {
        try {

            dao.gravar(openLicense);
            
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            openLicense = new OpenLicense();
            
            FacesUtil.addInfoMessage("Informação", "Tipo License salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }
    

    public void adicionar(ActionEvent evt) {

    }

    public OpenLicense getOpenLicense() {
        return openLicense;
    }

    public void setOpenLicense(OpenLicense openLicense) {
        this.openLicense = openLicense;
    }

    public TipoLicense getTipoLicense() {
        return tipoLicense;
    }

    public void setTipoLicense(TipoLicense tipoLicense) {
        this.tipoLicense = tipoLicense;
    }

    public SerialOpenLicense getSerialOpenLicense() {
        return serialOpenLicense;
    }

    public void setSerialOpenLicense(SerialOpenLicense serialOpenLicense) {
        this.serialOpenLicense = serialOpenLicense;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<OpenLicense> getListaOpenLicense() {
        return listaOpenLicense;
    }

    public void setListaOpenLicense(List<OpenLicense> listaOpenLicense) {
        this.listaOpenLicense = listaOpenLicense;
    }

    public BigDecimal getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(BigDecimal numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

   
    

    public BigDecimal getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(BigDecimal idContrato) {
        this.idContrato = idContrato;
    }

}
