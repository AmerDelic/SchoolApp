package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.entities.Appuser;
import com.amerd.schoolapp.entities.Classgroup;
import com.amerd.schoolapp.entities.Schoolstaff;
import com.amerd.schoolapp.entities.StaffSubject;
import com.amerd.schoolapp.entities.facades.local.SchoolstaffFacadeLocal;
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
public class StaffController extends UsersController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Appuser _appuserId;
    private String _name;
    private String _surname;
    private String _email;
    private Classgroup _classgroup;
    private StaffSubject _staffSubject;
    private List<Schoolstaff> _allstaff;
    private List<Schoolstaff> _unassignedStaff;
    private List<Schoolstaff> _nonHeadTeachers;
    private Schoolstaff _selectedStaff;
   

    @Inject
    SchoolstaffFacadeLocal staffFacade;

    public StaffController() {
    }

    @Override
    @PostConstruct
    public void onInit() {
        refreshTableData();
    }

    @Transactional
    public void createStaffUser() {
        Appuser theUser = null;
        setPrivilege(Privilege.STAFF);
        theUser = addUser();
        if(theUser == null) {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
            return;
        }
      //  theUser = appuserFacadeLocal.retrieveAppuserByUsername(theUser.getAppUsername()).get();
        Schoolstaff newStaff = new Schoolstaff();
        newStaff.setAppuserId(theUser);
        newStaff.setName(_name);
        newStaff.setSurname(_surname);
        newStaff.setEmail(_email);

        staffFacade.create(newStaff);
        setUImessage(FacesMessage.SEVERITY_INFO, "New Staff added!");
        refreshTableData();
    }

    @Transactional
    public void deleteStaff() {
        if (_selectedStaff != null) {
            appuserFacadeLocal.removeStaffReference(_selectedStaff.getAppuserId());
            staffFacade.remove(_selectedStaff);
            setUImessage(FacesMessage.SEVERITY_INFO,
                    "Staff '" + _selectedStaff.getName() + " " + _selectedStaff.getSurname() + "' removed.");
            this._selectedStaff = null;
            refreshTableData();
        } else {
            setUImessage(FacesMessage.SEVERITY_ERROR, UIMessages.MISSING_FORM_INPUT);
        }
    }

    public Appuser getAppuserId() {
        return _appuserId;
    }

    public void setAppuserId(Appuser _appuserId) {
        this._appuserId = _appuserId;
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

    public Classgroup getClassgroup() {
        return _classgroup;
    }

    public void setClassgroup(Classgroup classgroup) {
        this._classgroup = classgroup;
    }

    public StaffSubject getStaffSubject() {
        return _staffSubject;
    }

    public void setStaffSubject(StaffSubject staffSubject) {
        this._staffSubject = staffSubject;
    }

    public List<Schoolstaff> getAllstaff() {
        return _allstaff;
    }

    public void setAllstaff(List<Schoolstaff> _allstaff) {
        this._allstaff = _allstaff;
    }

    public Schoolstaff getSelectedStaff() {
        return _selectedStaff;
    }

    public void setSelectedStaff(Schoolstaff selectedStaff) {
        this._selectedStaff = selectedStaff;
    }

    public List<Schoolstaff> getUnassignedStaff() {
        return _unassignedStaff;
    }

    public void setUnassignedStaff(List<Schoolstaff> _unassignedStaff) {
        this._unassignedStaff = _unassignedStaff;
    }

    public List<Schoolstaff> getNonHeadTeachers() {
        return _nonHeadTeachers;
    }

    public void setNonHeadTeachers(List<Schoolstaff> _nonHeadTeachers) {
        this._nonHeadTeachers = _nonHeadTeachers;
    }

    @Override
    protected void refreshTableData() {
        this._allstaff = staffFacade.findAll();
        this._unassignedStaff = staffFacade.findAllStaffByStatus(false);
        this._nonHeadTeachers = staffFacade.findNonHeadTeacherStaff();
        super.refreshTableData();
    }

}
