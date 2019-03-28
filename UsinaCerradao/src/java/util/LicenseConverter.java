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
import model.License;

/**
 *
 * @author aj
 */

@FacesConverter(value = "licenseConverter")
public class LicenseConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Dao dao = new Dao();
        License license = dao.buscarLicenseConverter(string);
        return license;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        License license = new License();
        license = (License) o;
        return license.getDescricao();
    }
    
}
