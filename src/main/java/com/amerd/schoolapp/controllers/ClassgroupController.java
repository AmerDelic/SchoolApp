package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.controllers.navigation.ViewNavigator;
import com.amerd.schoolapp.entities.Classgroup;
import com.amerd.schoolapp.entities.Classroom;
import com.amerd.schoolapp.entities.Schoolstaff;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.StudentClassgroup;
import com.amerd.schoolapp.entities.StudentClassgroupPK;
import com.amerd.schoolapp.entities.facades.local.ClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.ClassroomFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.StudentClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import com.amerd.schoolapp.util.constants.UIMessages;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RequestScoped
@Named
public class ClassgroupController extends StaffController implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Classroom> _classrooms;
    private List<Classgroup> _classgroups;
    private List<Integer> _grades;
    private Classgroup _selectedClassgroup;
    private Schoolstaff _selectedTeacher;
    private Classroom _selectedClassroom;
    private Integer _selectedGrade;
    private Student _selectedStudent;
    private List<Student> _unassignedStudents;
    private List<Student> _classMembers;
    private Student _selectedMember;

    @Inject
    ClassroomFacadeLocal classroomFacade;
    @Inject
    ClassgroupFacadeLocal classFacade;
    @Inject
    StudentFacadeLocal studentFacade;
    @Inject
    StudentClassgroupFacadeLocal classMemberFacade;
    @Inject
    ViewNavigator nav;

    public ClassgroupController() {
    }

    @Override
    @PostConstruct
    public void onInit() {
        this._grades = Arrays.asList(1, 2, 3, 4);
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
        Optional<Classgroup> ClassOpt;
        Classgroup theClass;
        if (null != this._selectedClassgroup) {
            ClassOpt = classFacade.findById(_selectedClassgroup.getId());
            if (ClassOpt.isPresent()) {
                theClass = ClassOpt.get();
                if (theClass.getStudentClassgroupList().isEmpty()) {
                    Schoolstaff headTeacher = theClass.getHeadStaffId();
                    Classroom classroom = theClass.getClassroomId();
                    staffFacade.removeClassgroupReference(headTeacher);
                    classroomFacade.removeClassgroupReference(_selectedClassgroup, classroom);
                    classFacade.remove(theClass);
                    setUImessage(FacesMessage.SEVERITY_INFO, theClass.toString() + " deleted");
                    refreshTableData();
                } else {
                    setUImessage(FacesMessage.SEVERITY_ERROR, "Class still has student members.");
                }
            } else {
                setUImessage(FacesMessage.SEVERITY_WARN, "Class is null");
            }
        } else {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
        }
    }

    @Transactional
    public void addClassMember() {
        if (null != this._selectedStudent && null != this._selectedClassgroup) {
            StudentClassgroup newClassMember = new StudentClassgroup();
            newClassMember.setStudent(this._selectedStudent);
            newClassMember.setClassgroup(this._selectedClassgroup);
            newClassMember.setStudentClassgroupPK(new StudentClassgroupPK(_selectedStudent.getId(), this._selectedClassgroup.getId()));
            classMemberFacade.create(newClassMember);
            setUImessage(FacesMessage.SEVERITY_INFO, _selectedStudent.toString() + " added to " + this._selectedClassgroup);
            refreshTableData();
        } else {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
        }
    }

    // TODO: remove student from classgroup.
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

    @Override
    protected void refreshTableData() {
        this._classgroups = classFacade.findAll();
        this._classrooms = classroomFacade.findAll();
        this._unassignedStudents = studentFacade.findAllUnassignedStudents();
        super.refreshTableData();
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

    public Student getSelectedStudent() {
        return _selectedStudent;
    }

    public void setSelectedStudent(Student _selectedStudent) {
        this._selectedStudent = _selectedStudent;
    }

    public List<Student> getUnassignedStudents() {
        return _unassignedStudents;
    }

    public void setUnassignedStudents(List<Student> _unassignedStudents) {
        this._unassignedStudents = _unassignedStudents;
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

    public String forwardToSelectedClassHome() {
        facesContext.getAttributes().put("facesAtr", this._selectedClassgroup.getIdString());
        return nav.toHomeroomPage();
    }
}
