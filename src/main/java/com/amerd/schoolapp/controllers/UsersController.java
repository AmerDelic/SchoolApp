package com.amerd.schoolapp.controllers;

import com.amerd.schoolapp.entities.Appuser;
import com.amerd.schoolapp.entities.facades.local.AppuserFacadeLocal;
import com.amerd.schoolapp.util.constants.Privilege;
import com.amerd.schoolapp.util.constants.UIMessages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;

@RequestScoped
@Named
public class UsersController implements Serializable {
    private static final long serialVersionUID = 1L;

    private String _username;
    private String _password;
    private String _privilege;
    private List<Appuser> _users;
    private Appuser selectedUser;
    private List<Appuser> _genericStaffUsers;
    private List<Appuser> _genericStudentUsers;
    private List<String> _privileges;
    @Inject
    AppuserFacadeLocal appuserFacadeLocal;
    @Inject
    FacesContext facesContext;
    @Inject
    Pbkdf2PasswordHash passwordHasher;

    public UsersController() {
    }

    @PostConstruct
    public void onInit() {
        this._privileges = Arrays.asList(Privilege.SUPERADMIN, Privilege.STAFF, Privilege.STUDENT);
        refreshTableData();
    }

    public List<Appuser> getUsers() {
        return _users;
    }

    @Transactional
    public Appuser addUser() {
        if (_username.isBlank() || _password.isBlank() || _privilege.isBlank()) {
            setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.MISSING_FORM_INPUT);
            return null;
        }
        Appuser newUser = new Appuser();
        newUser.setAppUsername(_username);
        newUser.setAppPassword(passwordHasher.generate(_password.toCharArray()));
        newUser.setAppPrivilege(_privilege);
        appuserFacadeLocal.create(newUser);
        if (newUser.getId() != null) {
            setUImessage(FacesMessage.SEVERITY_INFO, UIMessages.SAVE_USER_SUCCESS);
        } else {
            setUImessage(FacesMessage.SEVERITY_ERROR, UIMessages.SAVE_PROBLEM);
        }
        refreshTableData();
        return newUser;
    }

    @Transactional
    public void deleteUser() {
        if (selectedUser != null) {
            appuserFacadeLocal.remove(selectedUser);
            refreshTableData();
            setUImessage(FacesMessage.SEVERITY_INFO, "User '" + selectedUser.getAppUsername() + "' removed.");
            this.selectedUser = null;
        } 
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getPrivilege() {
        return _privilege;
    }

    public void setPrivilege(String _privilege) {
        this._privilege = _privilege;
    }

    public Appuser getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Appuser selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<Appuser> getGenericStudentUsers() {
        return _genericStudentUsers;
    }

    public void setGenericStudentUsers(List<Appuser> _genericStudentUsers) {
        this._genericStudentUsers = _genericStudentUsers;
    }
    
    public List<Appuser> getGenericStaffUsers() {
        return _genericStaffUsers;
    }

    public void setGenericStaffUsers(List<Appuser> _genericStaffUsers) {
        this._genericStaffUsers = _genericStaffUsers;
    }

    public List<String> getPrivileges() {
        return _privileges;
    }

    public void setPrivileges(List<String> _privileges) {
        this._privileges = _privileges;
    }
    
    protected void setUImessage(Severity severity, String msg) {
        facesContext.addMessage(null, new FacesMessage(severity, msg, null));
    }

    protected void refreshTableData() {
        this._genericStaffUsers = appuserFacadeLocal.retrieveGenericUsers(Privilege.STAFF);
        this._genericStudentUsers = appuserFacadeLocal.retrieveGenericUsers(Privilege.STUDENT);
        this._users = appuserFacadeLocal.findAll();
    }
}
