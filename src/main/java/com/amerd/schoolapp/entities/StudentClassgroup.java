
package com.amerd.schoolapp.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Note: Just a auto-generated, unsused class. Needs modification.
 */
@Entity
@Table(name = "student_classgroup")
@NamedQueries({
    @NamedQuery(name = "StudentClassgroup.findAll", query = "SELECT s FROM StudentClassgroup s"),
    @NamedQuery(name = "StudentClassgroup.findByStudentId", query = "SELECT s FROM StudentClassgroup s WHERE s.studentClassgroupPK.studentId = :studentId"),
    @NamedQuery(name = "StudentClassgroup.findByClassgroupId", query = "SELECT s FROM StudentClassgroup s WHERE s.studentClassgroupPK.classgroupId = :classgroupId")})
public class StudentClassgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentClassgroupPK studentClassgroupPK;
    @JoinColumn(name = "classgroup_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Classgroup classgroup;
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Student student;

    public StudentClassgroup() {
    }

    public StudentClassgroup(StudentClassgroupPK studentClassgroupPK) {
        this.studentClassgroupPK = studentClassgroupPK;
    }

    public StudentClassgroup(int studentId, int classgroupId) {
        this.studentClassgroupPK = new StudentClassgroupPK(studentId, classgroupId);
    }

    public StudentClassgroupPK getStudentClassgroupPK() {
        return studentClassgroupPK;
    }

    public void setStudentClassgroupPK(StudentClassgroupPK studentClassgroupPK) {
        this.studentClassgroupPK = studentClassgroupPK;
    }

    public Classgroup getClassgroup() {
        return classgroup;
    }

    public void setClassgroup(Classgroup classgroup) {
        this.classgroup = classgroup;
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
        hash += (studentClassgroupPK != null ? studentClassgroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentClassgroup)) {
            return false;
        }
        StudentClassgroup other = (StudentClassgroup) object;
        if ((this.studentClassgroupPK == null && other.studentClassgroupPK != null) || (this.studentClassgroupPK != null && !this.studentClassgroupPK.equals(other.studentClassgroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amerd.schoolapp.entities.StudentClassgroup[ studentClassgroupPK=" + studentClassgroupPK + " ]";
    }
    
}
