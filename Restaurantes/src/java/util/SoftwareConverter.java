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
import model.Software;

/**
 *
 * @author aj
 */

@FacesConverter(value = "softwareConverter")
public class SoftwareConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Dao dao = new Dao();
        Software software = dao.buscarSoftwareConverter(string);
        return software;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Software software = new Software();
        software = (Software) o;
        return software.getKey();
    }
    
}
