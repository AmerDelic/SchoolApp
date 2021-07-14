package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.controllers.navigation.ViewNavigator;
import com.amerd.schoolapp.entities.Classgroup;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.StudentClassgroup;
import com.amerd.schoolapp.entities.facades.local.ClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.StudentClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import com.amerd.schoolapp.util.constants.UIMessages;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@RequestScoped
@Named
public class ClassgroupProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    private Classgroup _currentClassgroup;
    private List<Student> _classMembers;
    private Student _selectedMember;

    @Inject
    FacesContext facesContext;
    @Inject
    StudentFacadeLocal studentFacade;
    @Inject
    ClassgroupFacadeLocal classFacade;
    @Inject
    StudentClassgroupFacadeLocal classMemberFacade;
    @Inject
    ViewNavigator nav;

    public ClassgroupProfile() {
    }

    // Problem ... When do these get called exactly?
    @PostConstruct
    public void onInit() {
        Integer intId = null;
        String testId = (String) facesContext.getAttributes().get("facesAtr");
        if ((null != testId) && !(testId.isBlank())) {
            nav.setClassgroupId(testId);
            intId = Integer.valueOf(testId);
            this._currentClassgroup = classFacade.findById(intId).get();
            this._classMembers = classFacade.getClassMembers(this._currentClassgroup);
        }
        // if I remove the 'else' 
        else {
            testId = nav.getClassgroupId();
            intId = Integer.valueOf(testId);
            this._currentClassgroup = classFacade.findById(intId).get();
            this._classMembers = classFacade.getClassMembers(this._currentClassgroup);
        }
    }

    @Transactional
    public void removeClassMember() {
        if (this._currentClassgroup != null && this._selectedMember != null) {
            Optional<Student> studentOpt = studentFacade.findById(_selectedMember.getId());
            if (studentOpt.isPresent()) {
                Student student = studentOpt.get();
                StudentClassgroup studentMembership = student.getStudentClassgroup();
                studentFacade.removeClassgroupReference(student);
                classFacade.removeMemberReference(_currentClassgroup, studentMembership);
                classMemberFacade.remove(studentMembership);
                setUImessage(FacesMessage.SEVERITY_INFO, _selectedMember.toString() + " removed from " + this._currentClassgroup.toString());
                /*
                    If I don't refresh here, the table doesn't update,
                    even though the onInit()should do that.
                */
                refreshTableData();
            }
        } else {
            System.err.println("Something is null in removeClassMember");
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
        }
    }

    // Problem : not sure when and why I need this..but I do need it.
    private void refreshTableData() {
        String testId = nav.getClassgroupId();
        Integer intId = Integer.valueOf(testId);
        this._currentClassgroup = classFacade.findById(intId).get();
        this._classMembers = classFacade.getClassMembers(this._currentClassgroup);
    }

    public Classgroup getCurrentClassgroup() {
        return _currentClassgroup;
    }

    public void setCurrentClassgroup(Classgroup _currentClassgroup) {
        this._currentClassgroup = _currentClassgroup;
    }

    public List<Student> getClassMembers() {
        return _classMembers;
    }

    public void setClassMembers(List<Student> _classMembers) {
        this._classMembers = _classMembers;
    }

    public Student getSelectedMember() {
        return _selectedMember;
    }

    public void setSelectedMember(Student _selectedMember) {
        this._selectedMember = _selectedMember;
    }
    
    private void setUImessage(FacesMessage.Severity severity, String msg) {
        facesContext.addMessage(null, new FacesMessage(severity, msg, null));
    }
}
