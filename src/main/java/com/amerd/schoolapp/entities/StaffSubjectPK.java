
package com.amerd.schoolapp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class StaffSubjectPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "schoolstaff_id")
    private int schoolstaffId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subject_id")
    private int subjectId;

    public StaffSubjectPK() {
    }

    public StaffSubjectPK(int schoolstaffId, int subjectId) {
        this.schoolstaffId = schoolstaffId;
        this.subjectId = subjectId;
    }

    public int getSchoolstaffId() {
        return schoolstaffId;
    }

    public void setSchoolstaffId(int schoolstaffId) {
        this.schoolstaffId = schoolstaffId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) schoolstaffId;
        hash += (int) subjectId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StaffSubjectPK)) {
            return false;
        }
        StaffSubjectPK other = (StaffSubjectPK) object;
        if (this.schoolstaffId != other.schoolstaffId) {
            return false;
        }
        if (this.subjectId != other.subjectId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StaffSubjectPK[ schoolstaffId=" + schoolstaffId + ", subjectId=" + subjectId + " ]";
    }
    
}
