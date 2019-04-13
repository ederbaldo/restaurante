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
import model.SerialOpenLicense;


/**
 *
 * @author enascimento
 */@FacesConverter(value = "serialConverter")
public class SerialConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Dao dao = new Dao();
        SerialOpenLicense serial = dao.buscarSerialOpenConverter(string);
        return serial;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        SerialOpenLicense serial = new SerialOpenLicense();
        serial = (SerialOpenLicense) o;
        return serial.getSerial();
    }
}
