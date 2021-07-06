
package com.amerd.schoolapp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/*
 * Note: Just a auto-generated, unsused class. Needs modification.
 */
@Embeddable
public class StudentClassgroupPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classgroup_id")
    private int classgroupId;

    public StudentClassgroupPK() {
    }

    public StudentClassgroupPK(int studentId, int classgroupId) {
        this.studentId = studentId;
        this.classgroupId = classgroupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassgroupId() {
        return classgroupId;
    }

    public void setClassgroupId(int classgroupId) {
        this.classgroupId = classgroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) classgroupId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentClassgroupPK)) {
            return false;
        }
        StudentClassgroupPK other = (StudentClassgroupPK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.classgroupId != other.classgroupId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amerd.schoolapp.entities.StudentClassgroupPK[ studentId=" + studentId + ", classgroupId=" + classgroupId + " ]";
    }
    
}
