/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.Dao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Computador;

/**
 *
 * @author aj
 */

@FacesConverter(value = "computadorConverter")
public class ComputadorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Dao dao = new Dao();
        Computador computador = dao.buscarComputadorConverter(string);
        return computador;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Computador computador = new Computador();
        computador = (Computador) o;
        return computador.getDescricao();
    }
    
}
