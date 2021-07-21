package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.controllers.navigation.ViewNavigator;
import com.amerd.schoolapp.entities.Subject;
import com.amerd.schoolapp.entities.Schoolstaff;
import com.amerd.schoolapp.entities.StaffSubject;
import com.amerd.schoolapp.entities.StaffSubjectPK;
import com.amerd.schoolapp.entities.facades.local.StaffSubjectFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.SubjectFacadeLocal;
import com.amerd.schoolapp.util.constants.UIMessages;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@RequestScoped
@Named
public class TeacherController extends StaffController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<StaffSubject> _teachers;
    private StaffSubject _selectedTeacher;
    private Schoolstaff _selectedStaff;
    private Subject _selectedSubject;

    @Inject
    StaffSubjectFacadeLocal teacherFacade;
    @Inject
    SubjectFacadeLocal subjectFacade;
    @Inject
    ViewNavigator nav;

    public TeacherController() {
    }

    @Override
    @PostConstruct
    public void onInit() {
        refreshTableData();
    }

    @Transactional
    public void assignSubjectToStaff() {
        if (null != _selectedStaff) {
            StaffSubject newTeacher = new StaffSubject();
            newTeacher.setSchoolstaff(_selectedStaff);
            newTeacher.setSubject(_selectedSubject);
            newTeacher.setStaffSubjectPK(new StaffSubjectPK(_selectedStaff.getId(), _selectedSubject.getId()));
            teacherFacade.create(newTeacher);
            setUImessage(FacesMessage.SEVERITY_INFO,
                    newTeacher.toString() + " assigned to " + _selectedSubject.getSubjectName());
            refreshTableData();

        } else {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
        }
    }

    @Transactional
    public void deleteTeacher() {
        if (null != _selectedTeacher) {
            Schoolstaff staff = _selectedTeacher.getSchoolstaff();
            Subject subject = _selectedTeacher.getSubject();
            staffFacade.removeTeacherReference(staff);
            subjectFacade.removeTeacherReference(_selectedTeacher, subject);
            teacherFacade.remove(_selectedTeacher);
            setUImessage(FacesMessage.SEVERITY_INFO, staff.toString() + " removed from teaching position");
            this._selectedTeacher = null;
            refreshTableData();
        } else {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
        }
    }

    public List<StaffSubject> getTeachers() {
        return _teachers;
    }

    public void setTeachers(List<StaffSubject> _teachers) {
        this._teachers = _teachers;
    }

    @Override
    public Schoolstaff getSelectedStaff() {
        return _selectedStaff;
    }

    @Override
    public void setSelectedStaff(Schoolstaff _selectedStaff) {
        this._selectedStaff = _selectedStaff;
    }

    public Subject getSelectedSubject() {
        return _selectedSubject;
    }

    public void setSelectedSubject(Subject _selectedSubject) {
        this._selectedSubject = _selectedSubject;
    }

    public StaffSubject getSelectedTeacher() {
        return _selectedTeacher;
    }

    public void setSelectedTeacher(StaffSubject _selectedTeacher) {
        this._selectedTeacher = _selectedTeacher;
    }

    @Override
    protected void refreshTableData() {
        this._teachers = teacherFacade.findAll();
        super.refreshTableData();
    }

}
