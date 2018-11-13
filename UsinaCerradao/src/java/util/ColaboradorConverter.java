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
import model.Colab;
import model.Computador;

/**
 *
 * @author aj
 */

@FacesConverter(value = "colaboradorConverter")
public class ColaboradorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Dao dao = new Dao();
        Colab colab = dao.buscarColabConverter(string);
        return colab;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Colab colab = new Colab();
        colab = (Colab) o;
        return colab.getNome();
    }
    
}
