
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


@Entity
@Table(name = "staff_subject")
@NamedQueries({
    @NamedQuery(name = "StaffSubject.findAll", query = "SELECT s FROM StaffSubject s"),
    @NamedQuery(name = "StaffSubject.findBySchoolstaffId", query = "SELECT s FROM StaffSubject s WHERE s.staffSubjectPK.schoolstaffId = :schoolstaffId"),
    @NamedQuery(name = "StaffSubject.findBySubjectId", query = "SELECT s FROM StaffSubject s WHERE s.staffSubjectPK.subjectId = :subjectId")})
public class StaffSubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StaffSubjectPK staffSubjectPK;
    @JoinColumn(name = "schoolstaff_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Schoolstaff schoolstaff;
    @JoinColumn(name = "subject_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subject subject;

    public StaffSubject() {
    }

    public StaffSubject(StaffSubjectPK staffSubjectPK) {
        this.staffSubjectPK = staffSubjectPK;
    }

    public StaffSubject(int schoolstaffId, int subjectId) {
        this.staffSubjectPK = new StaffSubjectPK(schoolstaffId, subjectId);
    }

    public StaffSubjectPK getStaffSubjectPK() {
        return staffSubjectPK;
    }

    public void setStaffSubjectPK(StaffSubjectPK staffSubjectPK) {
        this.staffSubjectPK = staffSubjectPK;
    }

    public Schoolstaff getSchoolstaff() {
        return schoolstaff;
    }

    public void setSchoolstaff(Schoolstaff schoolstaff) {
        this.schoolstaff = schoolstaff;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffSubjectPK != null ? staffSubjectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StaffSubject)) {
            return false;
        }
        StaffSubject other = (StaffSubject) object;
        if ((this.staffSubjectPK == null && other.staffSubjectPK != null) || (this.staffSubjectPK != null && !this.staffSubjectPK.equals(other.staffSubjectPK))) {
            return false;
        }
        return true;
    }
    
    public String getIdString() {
        return String.valueOf(this.schoolstaff.getId());
    }

     @Override
    public String toString() {
        return schoolstaff.toString();
    }
    
    
    
}
