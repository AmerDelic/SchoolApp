
package com.amerd.schoolapp.util.converters;

import com.amerd.schoolapp.entities.Classroom;
import com.amerd.schoolapp.entities.facades.local.ClassroomFacadeLocal;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@FacesConverter("classroomConverter") 
public class ClassroomConverter implements Converter {
    
    @Inject
    ClassroomFacadeLocal classroomFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if ((null == value) || (value.trim().isEmpty())) {
             System.err.println("CLASSROOM CONVERTER FAIL");
            return null;
        }
       return classroomFacade.findById(Integer.valueOf(value)).get();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value == null) {
             System.err.println("CLASSROOM CONVERTER FAIL");
            return "";
        }
         return ((Classroom)value).getIdString();
    }
    
}
