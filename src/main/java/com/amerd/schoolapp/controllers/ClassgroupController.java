package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.entities.Classgroup;
import com.amerd.schoolapp.entities.Classroom;
import com.amerd.schoolapp.entities.Schoolstaff;
import com.amerd.schoolapp.entities.facades.local.ClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.ClassroomFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.SchoolstaffFacadeLocal;
import com.amerd.schoolapp.util.constants.UIMessages;
import java.io.Serializable;
import java.util.Arrays;
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
public class ClassgroupController implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Classroom> _classrooms;
    private List<Classgroup> _classgroups;
     private List<Integer> _grades;
    private Classgroup _selectedClassgroup;
    private Schoolstaff _selectedTeacher;
    private Classroom _selectedClassroom;
    private Integer _selectedGrade;

    @Inject
    ClassroomFacadeLocal classroomFacade;
    @Inject
    ClassgroupFacadeLocal classFacade;
    @Inject
    SchoolstaffFacadeLocal staffFacade;
    @Inject
    FacesContext facesContext;

    public ClassgroupController() {
    }

    @PostConstruct
    public void onInit() {
        this._grades = Arrays.asList(1,2,3,4);
        refreshTableData();
    }

    @Transactional
    public void createClassgroup() {
        if (null != this._selectedTeacher && null != this._selectedClassroom) {
            Classgroup newClassGroup = new Classgroup();
            newClassGroup.setHeadStaffId(_selectedTeacher);
            newClassGroup.setClassroomId(_selectedClassroom);
            newClassGroup.setGrade(_selectedGrade);
            classFacade.create(newClassGroup);
            setUImessage(FacesMessage.SEVERITY_INFO,
                    _selectedTeacher.toString() + " assigned to " + _selectedClassroom.toString());
            refreshTableData();
        } else {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
        }
    }

    @Transactional
    public void deleteClassgroup() {
        if (null != this._selectedClassgroup) {
            Schoolstaff headTeacher = this._selectedClassgroup.getHeadStaffId();
            Classroom classroom = this._selectedClassgroup.getClassroomId();
            staffFacade.removeClassgroupReference(headTeacher);
            classroomFacade.removeClassgroupReference(_selectedClassgroup, classroom);
            classFacade.remove(_selectedClassgroup);
            setUImessage(FacesMessage.SEVERITY_INFO, _selectedClassgroup.toString() + " deleted");
            this._selectedClassgroup = null;
            refreshTableData();
        } else {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
        }
    }

    public List<Classgroup> getClassgroups() {
        return _classgroups;
    }

    public void setClassgroups(List<Classgroup> _classgroups) {
        this._classgroups = _classgroups;
    }

    public Schoolstaff getSelectedTeacher() {
        return _selectedTeacher;
    }

    public void setSelectedTeacher(Schoolstaff _selectedTeacher) {
        this._selectedTeacher = _selectedTeacher;
    }

    public Classroom getSelectedClassroom() {
        return _selectedClassroom;
    }

    public void setSelectedClassroom(Classroom _selectedClassroom) {
        this._selectedClassroom = _selectedClassroom;
    }

    private void refreshTableData() {
        this._classgroups = classFacade.findAll();
        this._classrooms = classroomFacade.findAll();
    }

    public Classgroup getSelectedClassgroup() {
        return _selectedClassgroup;
    }

    public void setSelectedClassgroup(Classgroup _selectedClassgroup) {
        this._selectedClassgroup = _selectedClassgroup;
    }

    public List<Classroom> getClassrooms() {
        return _classrooms;
    }

    public void setClassrooms(List<Classroom> _classrooms) {
        this._classrooms = _classrooms;
    }

    public List<Integer> getGrades() {
        return _grades;
    }

    public void setGrades(List<Integer> _grades) {
        this._grades = _grades;
    }

    public Integer getSelectedGrade() {
        return _selectedGrade;
    }

    public void setSelectedGrade(Integer _selectedGrade) {
        this._selectedGrade = _selectedGrade;
    }

    protected void setUImessage(FacesMessage.Severity severity, String msg) {
        facesContext.addMessage(null, new FacesMessage(severity, msg, null));
    }

}
