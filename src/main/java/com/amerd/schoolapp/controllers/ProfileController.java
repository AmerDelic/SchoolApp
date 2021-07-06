
package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.entities.Appuser;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.facades.local.AppuserFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

@RequestScoped
@Named
public class ProfileController implements Serializable {

    private Appuser _currentUser;
    private Student _student;
    
    private String testString;

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }
    

    public ProfileController() {
    }

    @Inject
    AppuserFacadeLocal appuserFacade;

    @Inject
    StudentFacadeLocal studentFacade;

    @Inject
    SecurityContext securityContext;

    @Inject
    FacesContext facesContext;

    @PostConstruct
    public void onInit() {
        this._currentUser = appuserFacade.retrieveAppuserByUsername(getExternalContext().getRemoteUser()).get();
            this._student = _currentUser.getStudent();
        this.testString = securityContext.getCallerPrincipal().getName();
    }

    public Appuser getUser() {
        return _currentUser;
    }

    public void setUser(Appuser _user) {
        this._currentUser = _user;
    }

    public Student getStudent() {
        return _student;
    }

    public void setStudent(Student _student) {
        this._student = _student;
    }

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }
}
