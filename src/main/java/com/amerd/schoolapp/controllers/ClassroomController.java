
package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.entities.Classroom;
import com.amerd.schoolapp.entities.facades.local.ClassroomFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class ClassroomController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Classroom> _classrooms;
    private Classroom _selectedClassroom;
    
    @Inject
    ClassroomFacadeLocal classroomFacade;
    
    public ClassroomController() {
    }
    
    @PostConstruct
    public void onInit() {
        this._classrooms = classroomFacade.findAll();
    }

    public List<Classroom> getClassrooms() {
        return _classrooms;
    }

    public void setClassrooms(List<Classroom> _classrooms) {
        this._classrooms = _classrooms;
    }

    public Classroom getSelectedClassroom() {
        return _selectedClassroom;
    }

    public void setSelectedClassroom(Classroom _selectedClassroom) {
        this._selectedClassroom = _selectedClassroom;
    }
    
    
}
