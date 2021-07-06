package com.amerd.schoolapp.util.converters;

import com.amerd.schoolapp.entities.Schoolstaff;
import com.amerd.schoolapp.entities.facades.local.SchoolstaffFacadeLocal;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
@FacesConverter("staffConverter")
public class StaffConverter implements Converter {
    
    @Inject
    SchoolstaffFacadeLocal staffFacadeLocal;
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((null == value) || (value.trim().isEmpty())) {
            return null; 
        }
         return staffFacadeLocal.findById(Integer.valueOf(value)).get();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
            return ((Schoolstaff)value).getIdString();
    }

}
