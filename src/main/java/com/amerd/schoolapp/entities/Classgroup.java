
package com.amerd.schoolapp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "classgroup")
@NamedQueries({
    @NamedQuery(name = "Classgroup.findAll", query = "SELECT c FROM Classgroup c"),
    @NamedQuery(name = "Classgroup.findById", query = "SELECT c FROM Classgroup c WHERE c.id = :id"),
    @NamedQuery(name = "Classgroup.findByGrade", query = "SELECT c FROM Classgroup c WHERE c.grade = :grade")})
public class Classgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grade")
    private int grade;
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classroom classroomId;
    @JoinColumn(name = "head_staff_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Schoolstaff headStaffId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classgroup")
    private List<StudentClassgroup> studentClassgroupList;

    public Classgroup() {
    }

    public Classgroup(Integer id) {
        this.id = id;
    }

    public Classgroup(Integer id, int grade) {
        this.id = id;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Classroom getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Classroom classroomId) {
        this.classroomId = classroomId;
    }

    public Schoolstaff getHeadStaffId() {
        return headStaffId;
    }

    public void setHeadStaffId(Schoolstaff headStaffId) {
        this.headStaffId = headStaffId;
    }

    public List<StudentClassgroup> getStudentClassgroupList() {
        return studentClassgroupList;
    }

    public void setStudentClassgroupList(List<StudentClassgroup> studentClassgroupList) {
        this.studentClassgroupList = studentClassgroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Classgroup)) {
            return false;
        }
        Classgroup other = (Classgroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public String getIdString() {
        return String.valueOf(id);
    }

    @Override
    public String toString() {
        String suffix = "";
        switch(grade) {
            case 1:
                suffix = "st grade";
                break;
            case 2: 
                suffix = "nd grade";
                break;
            case 3:
                suffix = "rd grade";
                break;
            default:
                suffix = "th grade";
        }
        return grade + suffix + 
                System.lineSeparator() +
                ", " + headStaffId.getSurname() + ", " + headStaffId.getName() + 
                System.lineSeparator() +
                ", homeroom: " + classroomId.getRoomCode();
    }
    
}
