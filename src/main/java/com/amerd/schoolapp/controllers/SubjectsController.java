
package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.entities.Subject;
import com.amerd.schoolapp.entities.facades.local.SubjectFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class SubjectsController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Subject> _subjects;
    
    @Inject
    SubjectFacadeLocal subjectFacade;
    
    public SubjectsController() {
    }
    
    @PostConstruct
    public void onInit() {
        this._subjects = subjectFacade.findAll();
    }

    public List<Subject> getSubjects() {
        return _subjects;
    }

    public void setSubjects(List<Subject> _subjects) {
        this._subjects = _subjects;
    }
    
    
}
