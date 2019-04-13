/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import dao.Dao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import model.SerialOpenLicense;
import model.TipoLicense;
import util.FacesUtil;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class SerialOpenLicenseMB implements Serializable {

    private SerialOpenLicense serialOpenLicense;
    Dao dao = new Dao();
    List<SerialOpenLicense> listaSerialOpenLicense = new ArrayList<SerialOpenLicense>();
    private List<TipoLicense> listTipoLicense;
    private List<SelectItem> selectTipoLicense;
    private BigDecimal numeroContrato;
    private BigDecimal idContrato;

    public SerialOpenLicenseMB() {
        novo();

    }

    public void novo() {
        serialOpenLicense = new SerialOpenLicense();
        serialOpenLicense.setIdTipoLicense(new TipoLicense());
        listaSerialOpenLicense = new ArrayList<SerialOpenLicense>();
        listaSerialOpenLicense = (List<SerialOpenLicense>) dao.buscarTodos(SerialOpenLicense.class);
    }
    
    public void gravar(ActionEvent evt) {
        try {
            //       
            dao.gravar(serialOpenLicense);
            /*listarMarcaVeiculo = (List<Marca>) dao.buscarTodos(Marca.class);*/
            serialOpenLicense = new SerialOpenLicense();
            buscarTabelaTipoLicense(getIdContrato());
            FacesUtil.addInfoMessage("Informação", "Serial salva com sucesso!");
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Erro", "Entre em contato com suporte!");
            ex.printStackTrace();
        }
    }

//    public void buscarContrato() throws ParseException {
//        List<Object[]> results = dao.buscarContrato(getNumeroContrato());
//        results.stream().map((result) -> {
//            setIdContrato((BigDecimal) result[0]);
//            return result;
//        }).forEachOrdered((result) -> {
//            setNumeroContrato((BigDecimal) result[1]);
//        });
//        System.out.println("-----------CONTRATO-----------" + getIdContrato());
//        buscarTabelaTipoLicense(getIdContrato());
//    }

    public List<SerialOpenLicense> buscarTabelaTipoLicense(BigDecimal numero) {
        System.out.println("-----------CONTRATO2-----------" + numero);
        setListaSerialOpenLicense((List<SerialOpenLicense>) dao.buscarTabelaSerial(numero));
        return getListaSerialOpenLicense();
    }
    public List<SelectItem> getSelectTipoLicense() {

        selectTipoLicense = new ArrayList<SelectItem>();
        listTipoLicense = new ArrayList<TipoLicense>();
        //listTipoLicense = (List<TipoLicense>) dao.buscarTabelaTipoLicense(getIdContrato());
        selectTipoLicense.add(new SelectItem(0, "Selecione"));
        for (TipoLicense c : listTipoLicense) {
            selectTipoLicense.add(new SelectItem(c.getIdTipoLicense(), c.getDescricao()));
        }
        return selectTipoLicense;
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

    public List<SerialOpenLicense> getListaSerialOpenLicense() {
        return listaSerialOpenLicense;
    }

    public void setListaSerialOpenLicense(List<SerialOpenLicense> listaSerialOpenLicense) {
        this.listaSerialOpenLicense = listaSerialOpenLicense;
    }

    public List<TipoLicense> getListTipoLicense() {
        return listTipoLicense;
    }

    public void setListTipoLicense(List<TipoLicense> listTipoLicense) {
        this.listTipoLicense = listTipoLicense;
    }

    public void setSelectTipoLicense(List<SelectItem> selectTipoLicense) {
        this.selectTipoLicense = selectTipoLicense;
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
