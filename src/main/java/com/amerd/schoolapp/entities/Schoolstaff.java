
package com.amerd.schoolapp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "schoolstaff")
@NamedQueries({
    @NamedQuery(name = "Schoolstaff.findAll", query = "SELECT s FROM Schoolstaff s"),
    @NamedQuery(name = "Schoolstaff.findById", query = "SELECT s FROM Schoolstaff s WHERE s.id = :id"),
    @NamedQuery(name = "Schoolstaff.findByName", query = "SELECT s FROM Schoolstaff s WHERE s.name = :name"),
    @NamedQuery(name = "Schoolstaff.findBySurname", query = "SELECT s FROM Schoolstaff s WHERE s.surname = :surname"),
    @NamedQuery(name = "Schoolstaff.findByEmail", query = "SELECT s FROM Schoolstaff s WHERE s.email = :email")})
public class Schoolstaff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "surname")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "appuser_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Appuser appuserId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "headStaffId")
    private Classgroup classgroup;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "schoolstaff")
    private StaffSubject staffSubject;

    public Schoolstaff() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Appuser getAppuserId() {
        return appuserId;
    }

    public void setAppuserId(Appuser appuserId) {
        this.appuserId = appuserId;
    }

    public Classgroup getClassgroup() {
        return classgroup;
    }

    public void setClassgroup(Classgroup classgroup) {
        this.classgroup = classgroup;
    }

    public StaffSubject getStaffSubject() {
        return staffSubject;
    }

    public void setStaffSubject(StaffSubject staffSubject) {
        this.staffSubject = staffSubject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Schoolstaff)) {
            return false;
        }
        Schoolstaff other = (Schoolstaff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  surname + ", " + name;
    }
    
    public String getIdString() {
        return String.valueOf(id);
    }
    
}
