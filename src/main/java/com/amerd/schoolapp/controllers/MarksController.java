
package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.controllers.navigation.ViewNavigator;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.Studentmark;
import com.amerd.schoolapp.entities.facades.local.StudentmarkFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class MarksController implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Student _selectedStudent;
    private List<Studentmark> _studentsMarks;
    
    @Inject
    StudentmarkFacadeLocal markFacade;

    public MarksController() {
    }

    public Student getSelectedStudent() {
        return _selectedStudent;
    }

    public void setSelectedStudent(Student _selectedStudent) {
        this._selectedStudent = _selectedStudent;
    }

    public List<Studentmark> getStudentsMarks() {
        this._studentsMarks = _selectedStudent.getStudentmarkList();
      //  TODO: query marks
        return _studentsMarks;
    }

    public void setStudentsMarks(List<Studentmark> _studentsMarks) {
        this._studentsMarks = _studentsMarks;
    }
    
    private void refreshData() {
        if(null != _selectedStudent) {
            
        }
    }
    
}
