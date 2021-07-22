package com.amerd.schoolapp.controllers.navigation;

import com.amerd.schoolapp.entities.facades.local.ClassgroupFacadeLocal;
import com.amerd.schoolapp.util.constants.UIMessages;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named
public class ViewNavigator implements Serializable {

    private static final long serialVersionUID = 1L;

    private String role;
    private String classgroupId;
    private String studentId;

    @Inject
    FacesContext facesContext;
    @Inject
    ClassgroupFacadeLocal classFacade;

    public ViewNavigator() {
    }

    @PostConstruct
    public void onInit() {
        refreshUserRole();
    }

    public void toStudentsPage() {
        refreshUserRole();
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
        refreshUserRole();
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
        refreshUserRole();
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
        refreshUserRole();
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
        refreshUserRole();
        try {
            switch (role) {
                case "student":
                    redirectToProfile();
                    break;
                case "staff":
                    redirectToProfile();
                    break;
                case "superadmin":
                    redirectToProfile();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toTeachersPage() {
        refreshUserRole();
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
        refreshUserRole();
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
        refreshUserRole();
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    redirectToClassgroups();
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
        refreshUserRole();
        try {
            switch (role) {
                case "student":
                    redirectToProfile();
                    break;
                case "staff":
                    redirectToClassgroups();
                    break;
                case "superadmin":
                    redirectToUsers();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toHomeroomPage() {
        refreshUserRole();
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    redirectToHomeroom();
                    break;
                case "superadmin":
                    redirectToHomeroom();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toAddNewStudentSection() {
        refreshUserRole();
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "superadmin":
                    redirectToStudentCreation();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toAddNewStaffSection() {
        refreshUserRole();
        try {
            switch (role) {
                case "student":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "staff":
                    setUImessage(FacesMessage.SEVERITY_WARN, UIMessages.NO_PERMISSION_WARN);
                    break;
                case "superadmin":
                    redirectToStaffCreation();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toLoginPage() {
        refreshUserRole();
        try {
            redirectToLogin();
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshPage() {
        refreshUserRole();
        try {
            getExternalContext().redirect(getExternalContext().getRequestContextPath() + facesContext.getViewRoot().getViewId());
        } catch (IOException ex) {
            Logger.getLogger(ViewNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }

    private void refreshUserRole() {
        if (getExternalContext().isUserInRole("superadmin")) {
            this.role = "superadmin";
        } else if (getExternalContext().isUserInRole("staff")) {
            this.role = "staff";
        } else if (getExternalContext().isUserInRole("student")) {
            this.role = "student";
        } else {
            this.role = "No User Role";
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getClassgroupId() {
        return classgroupId;
    }

    public void setClassgroupId(String classgroupId) {
        this.classgroupId = classgroupId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    private void redirectToHomeroom() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/homeroom.xhtml");
    }

    private void redirectToLogin() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/login.xhtml");
    }

    private void redirectToStudentCreation() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/students.xhtml#addStudentBox");
    }

    private void redirectToStaffCreation() throws IOException {
        getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/app/management/staff.xhtml#addStaffBox");
    }

    private void setUImessage(Severity severity, String msg) {
        facesContext.addMessage(null, new FacesMessage(severity, msg, null));
    }
}
