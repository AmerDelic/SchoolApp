package com.amerd.schoolapp.controllers;
import com.amerd.schoolapp.entities.Classgroup;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.StudentClassgroup;
import com.amerd.schoolapp.entities.facades.local.ClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.StudentClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import com.amerd.schoolapp.util.constants.UIMessages;
import java.io.Serializable;
import java.util.List;
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
     
    public ClassgroupProfile() {
    }
    
    @PostConstruct
    public void onInit() {
        var testGroup = classFacade.findById(23).get();  
        this._classMembers = classFacade.getClassMembers(testGroup);
//        if(null != this._currentClassgroup) {
//            this._classMembers = classFacade.getClassMembers(_currentClassgroup);
//        }
    }
    
     @Transactional
    public void removeClassMember() {
        if (this._currentClassgroup != null && this._selectedMember != null) {
            StudentClassgroup studentMember = _selectedMember.getStudentClassgroup();
            studentFacade.removeClassgroupReference(_selectedMember);
            classFacade.removeMemberReference(_currentClassgroup, studentMember);
            classMemberFacade.remove(studentMember);
            setUImessage(FacesMessage.SEVERITY_INFO, _selectedMember.toString() + " removed from " + this._currentClassgroup.toString());
            refreshTableData();
        } else {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
        }
    }
    
    private void setUImessage(FacesMessage.Severity severity, String msg) {
        facesContext.addMessage(null, new FacesMessage(severity, msg, null));
    }
    private void refreshTableData() {
        
        //this._classMembers = classFacade.getClassMembers(_currentClassgroup);
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
    
    
    
}
