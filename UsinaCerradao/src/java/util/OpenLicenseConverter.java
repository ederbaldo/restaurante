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
import model.OpenLicense;

/**
 *
 * @author aj
 */

@FacesConverter(value = "openLicenseConverter")
public class OpenLicenseConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Dao dao = new Dao();
        OpenLicense openLicense;
        openLicense = dao.buscarContratoConverter(string);
        return openLicense;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        OpenLicense openLicense = new OpenLicense();
        openLicense = (OpenLicense) o;
        return openLicense.getContrato().toString();
    }
    
}
