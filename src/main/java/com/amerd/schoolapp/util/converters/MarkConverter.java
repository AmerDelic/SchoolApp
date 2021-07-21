package com.amerd.schoolapp.util.converters;

import com.amerd.schoolapp.entities.Studentmark;
import com.amerd.schoolapp.entities.facades.local.StudentmarkFacadeLocal;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@FacesConverter("markConverter")
public class MarkConverter implements Converter {

    @Inject
    StudentmarkFacadeLocal markFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((null == value) || (value.trim().isEmpty())) {
            return null;
        }
        return (Studentmark) markFacade.findById(Integer.valueOf(value)).get();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        return ((Studentmark) value).getIdString();
    }

}
