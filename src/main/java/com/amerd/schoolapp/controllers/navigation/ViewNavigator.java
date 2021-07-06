package com.amerd.schoolapp.controllers.navigation;

import com.amerd.schoolapp.util.constants.UIMessages;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class ViewNavigator implements Serializable {

    private static final long serialVersionUID = 1L;

    private String role;
    @Inject
    FacesContext facesContext;

    public ViewNavigator() {
    }

    @PostConstruct
    public void onInit() {
        this.role = null;
        if (getExternalContext().isUserInRole("superadmin")) {
            this.role = "superadmin";
        } else if (getExternalContext().isUserInRole("staff")) {
            this.role = "staff";
        } else {
            this.role = "student";
        }
    }

    public void toStudentsPage() {
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    redirectToStudents();
                    break;
                case "superadmin":
                    redirectToStudents();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toUsersPage() {
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "superadmin":
                    redirectToUsers();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toSubjectsPage() {
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    redirectToSubjects();
                    break;
                case "superadmin":
                    redirectToSubjects();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toStaffPage() {
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "superadmin":
                    redirectToStaff();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toProfilePage() {
        try {
            switch (role) {
                case "student":
                    redirectToProfile();
                    break;
                case "staff":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.STUDENT_ONLY);
                    break;
                case "superadmin":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.STUDENT_ONLY);
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toTeachersPage() {
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "superadmin":
                    redirectToTeachers();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toClassroomsPage() {
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "superadmin":
                    redirectToClassrooms();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toClassgroupsPage() {
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "superadmin":
                    redirectToClassgroups();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void directFromLogin() {
        try {
            switch (role) {
                case "student":
                    redirectToProfile();
                    break;
                case "staff":
                    redirectToStudents();
                    break;
                case "superadmin":
                    redirectToUsers();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refreshPage() {
        try {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + facesContext.getViewRoot().getViewId());
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private void redirectToProfile() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/profile.xhtml");
    }

    private void redirectToSubjects() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/subjects.xhtml");
       
    }

    private void redirectToUsers() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/management/users.xhtml");
    }

    private void redirectToStudents() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/students.xhtml");
    }

    private void redirectToStaff() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/management/staff.xhtml");
    }

    private void redirectToTeachers() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/management/teachers.xhtml");
    }
    
    private void redirectToClassrooms() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/management/classrooms.xhtml");
    }
    
    private void redirectToClassgroups() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/management/classgroups.xhtml");
    }

    private void setUImessage(Severity severity, String msg) {
        facesContext.addMessage(null, new FacesMessage(severity, msg, null));
    }
}
