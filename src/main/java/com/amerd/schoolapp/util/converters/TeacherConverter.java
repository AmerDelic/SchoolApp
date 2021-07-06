
package com.amerd.schoolapp.util.converters;

import com.amerd.schoolapp.entities.StaffSubject;
import com.amerd.schoolapp.entities.facades.local.StaffSubjectFacadeLocal;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@FacesConverter("teacherConverter")
public class TeacherConverter implements Converter {
    
    @Inject
    StaffSubjectFacadeLocal teacherFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((null == value) || (value.trim().isEmpty())) {
            return null; 
        }
        return teacherFacade.findByStaffId(Integer.valueOf(value)).get();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value == null) {
            return "";
        }
       return ((StaffSubject)value).getIdString();
    }
    
}
