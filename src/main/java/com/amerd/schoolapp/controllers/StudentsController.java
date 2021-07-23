package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.entities.Appuser;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.StudentClassgroup;
import com.amerd.schoolapp.entities.Studentmark;
import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import com.amerd.schoolapp.util.constants.Privilege;
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
public class StudentsController extends UsersController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String _name;
    private String _surname;
    private String _email;
    private StudentClassgroup _studentClassgroup;
    private List<Studentmark> _studentmarkList;
    private List<Student> _students;
    private List<Student> _unassignedStudents;
    private Student selectedStudent;

    @Inject
    StudentFacadeLocal studentFacade;

    public StudentsController() {
    }

    @Override
    @PostConstruct
    public void onInit() {
        refreshTableData();
    }

    public Student findStudentByAppId() {
        return null;
    }

    @Transactional
    public void addStudentUser() {
       Appuser theUser = null;
        setPrivilege(Privilege.STUDENT);
        theUser = addUser();
        if(theUser == null) {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
            return;
        }
        
        Student newStudent = new Student();
        newStudent.setAppuserId(theUser);
        newStudent.setName(_name);
        newStudent.setSurname(_surname);
        newStudent.setEmail(_email);    
        studentFacade.create(newStudent);
        setUImessage(FacesMessage.SEVERITY_INFO, "New Student added!");
        refreshTableData();
    }

    @Transactional
    public void deleteStudent() {
        if (selectedStudent != null) {
            Appuser studentUser = selectedStudent.getAppuserId();
            studentUser.setStudent(null);
            appuserFacadeLocal.edit(studentUser);
            studentFacade.remove(selectedStudent);
            setUImessage(FacesMessage.SEVERITY_INFO, 
                    "Student '" + selectedStudent.getName() + " " + selectedStudent.getSurname() + "' removed.");
            this.selectedStudent = null;
            refreshTableData();
        } else {
            setUImessage(FacesMessage.SEVERITY_ERROR, "No student selected");
        }
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getSurname() {
        return _surname;
    }

    public void setSurname(String _surname) {
        this._surname = _surname;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public List<Student> getStudents() {
        return _students;
    }

    public void setStudents(List<Student> _students) {
        this._students = _students;
    }

    public StudentClassgroup getStudentClassgroup() {
        return _studentClassgroup;
    }

    public void setStudentClassgroup(StudentClassgroup _studentClassgroup) {
        this._studentClassgroup = _studentClassgroup;
    }

    public List<Studentmark> getStudentmarkList() {
        return _studentmarkList;
    }

    public void setStudentmarkList(List<Studentmark> _studentmarkList) {
        this._studentmarkList = _studentmarkList;
    }

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    @Override
    protected void refreshTableData() {
        this._students = studentFacade.findAll();
        this._unassignedStudents = studentFacade.findAllUnassignedStudents();
        super.refreshTableData();
    }

    public List<Student> getUnassignedStudents() {
        return _unassignedStudents;
    }

    public void setUnassignedStudents(List<Student> _unassignedStudents) {
        this._unassignedStudents = _unassignedStudents;
    }
}
