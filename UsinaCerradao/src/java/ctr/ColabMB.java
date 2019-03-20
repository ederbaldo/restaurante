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
import model.Colab;

/**
 *
 * @author enascimento
 */
@ManagedBean
@ViewScoped
public class ColabMB implements Serializable {
    private Dao dao = new Dao();
    private Colab colab;
    private List<Colab> listaColab;
    private Integer matricula;

    
    
    public ColabMB(){
       dao = new Dao();
       novo();
       
    }
    public void novo() {
        setListaColab(new ArrayList<Colab>());
        BuscarColab();
    }
//BUSCA TODOS COLABORADORES ATIVOS DO SGI E JOGA NA LISTACOLAB
public void BuscarColab() {
        //novoTotal();
        
        List<Object[]> results = dao.buscarColab();
        Colab colab;
        for (Object[] result : results) {
            colab = new Colab();
            colab.setNome((String) result[0]);
            colab.setMatricula((BigDecimal) result[1]);
            getListaColab().add(colab);
        }
    }
    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Colab> getListaColab() {
        return listaColab;
    }

    public void setListaColab(List<Colab> listaColab) {
        this.listaColab = listaColab;
    }

    public Colab getColab() {
        return colab;
    }

    public void setColab(Colab colab) {
        this.colab = colab;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    
    
}
