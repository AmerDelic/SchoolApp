package com.amerd.schoolapp.util.converters;

import com.amerd.schoolapp.entities.Appuser;
import com.amerd.schoolapp.entities.facades.local.AppuserFacadeLocal;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@FacesConverter("appuserConverter")
public class AppuserConverter implements Converter {

    @Inject
    AppuserFacadeLocal appuserFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((null == value) || (value.trim().isEmpty())) {
            return null;
        }
        return (Appuser) appuserFacade.findById(Integer.valueOf(value)).get();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        return ((Appuser) value).getIdString();
    }
}
