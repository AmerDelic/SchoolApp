
package com.amerd.schoolapp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "appuser")
@NamedQueries({
    @NamedQuery(name = "Appuser.findAll", query = "SELECT a FROM Appuser a"),
    @NamedQuery(name = "Appuser.findById", query = "SELECT a FROM Appuser a WHERE a.id = :id"),
    @NamedQuery(name = "Appuser.findByAppUsername", query = "SELECT a FROM Appuser a WHERE a.appUsername = :appUsername"),
    @NamedQuery(name = "Appuser.findByAppPassword", query = "SELECT a FROM Appuser a WHERE a.appPassword = :appPassword"),
    @NamedQuery(name = "Appuser.findByAppPrivilege", query = "SELECT a FROM Appuser a WHERE a.appPrivilege = :appPrivilege")})
public class Appuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "app_username")
    private String appUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "app_password")
    private String appPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "app_privilege")
    private String appPrivilege;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appuserId")
    private Schoolstaff schoolstaff;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appuserId")
    private Student student;

    public Appuser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppUsername() {
        return appUsername;
    }

    public void setAppUsername(String appUsername) {
        this.appUsername = appUsername;
    }

    public String getAppPassword() {
        return appPassword;
    }

    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword;
    }

    public String getAppPrivilege() {
        return appPrivilege;
    }

    public void setAppPrivilege(String appPrivilege) {
        this.appPrivilege = appPrivilege;
    }

    public Schoolstaff getSchoolstaff() {
        return schoolstaff;
    }

    public void setSchoolstaff(Schoolstaff schoolstaff) {
        this.schoolstaff = schoolstaff;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appuser[ id=" + id + ", Username="+ appUsername + " ]";
    }
    
}
