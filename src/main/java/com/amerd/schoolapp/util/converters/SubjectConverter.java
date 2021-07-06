
package com.amerd.schoolapp.util.converters;

import com.amerd.schoolapp.entities.facades.local.SubjectFacadeLocal;
import com.amerd.schoolapp.entities.Subject;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
@FacesConverter("subjectConverter")
public class SubjectConverter implements Converter{
    
    @Inject
    SubjectFacadeLocal subjectFacade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((null == value) || (value.trim().isEmpty())) {
            return null; 
        }
         return subjectFacade.findById(Integer.valueOf(value)).get();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
            return ((Subject)value).getIdString();
    }
}
