
package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.controllers.navigation.ViewNavigator;
import com.amerd.schoolapp.entities.Appuser;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.Studentmark;
import com.amerd.schoolapp.entities.facades.local.AppuserFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

@RequestScoped
@Named
public class ProfileController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Appuser _currentUser;
    private Student _student;  
    private boolean _isStudentUser;
     private List<Studentmark> _studentsMarks;
    
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
    @Inject
    MarksController marksController;
    @Inject
    ViewNavigator nav;

    @PostConstruct
    public void onInit() {
        this._isStudentUser = false;
        this._currentUser = appuserFacade.retrieveAppuserByUsername(securityContext.getCallerPrincipal().getName()).get();
        if(null != _currentUser.getStudent()) {
            this._student = _currentUser.getStudent();
            this._isStudentUser = true;
        } else if (null != nav.getStudentId()) {
            String studentIdString = nav.getStudentId();
            Integer studentId = Integer.valueOf(studentIdString);
            Optional<Student> s = studentFacade.findById(studentId);
            if(s.isPresent()) {
                this._student = s.get();
                marksController.setSelectedStudent(this._student);
                this._studentsMarks = marksController.getStudentsMarks();
            }
        }
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

    public boolean isIsStudentUser() {
        return _isStudentUser;
    }

    public void setIsStudentUser(boolean _isStudentUser) {
        this._isStudentUser = _isStudentUser;
    }

    public List<Studentmark> getStudentsMarks() {
        
        return _studentsMarks;
    }

    public void setStudentsMarks(List<Studentmark> _studentsMarks) {
        this._studentsMarks = _studentsMarks;
    }
    
    
}
