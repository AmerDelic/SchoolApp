
package com.amerd.schoolapp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Note: Just a auto-generated, unsused class. Needs modification.
 */
@Entity
@Table(name = "studentmark")
@NamedQueries({
    @NamedQuery(name = "Studentmark.findAll", query = "SELECT s FROM Studentmark s"),
    @NamedQuery(name = "Studentmark.findById", query = "SELECT s FROM Studentmark s WHERE s.id = :id"),
    @NamedQuery(name = "Studentmark.findByMark", query = "SELECT s FROM Studentmark s WHERE s.mark = :mark"),
    @NamedQuery(name = "Studentmark.findByScore", query = "SELECT s FROM Studentmark s WHERE s.score = :score"),
    @NamedQuery(name = "Studentmark.findByType", query = "SELECT s FROM Studentmark s WHERE s.type = :type"),
    @NamedQuery(name = "Studentmark.findByGivenBy", query = "SELECT s FROM Studentmark s WHERE s.givenBy = :givenBy"),
    @NamedQuery(name = "Studentmark.findByGivenOn", query = "SELECT s FROM Studentmark s WHERE s.givenOn = :givenOn")})
public class Studentmark implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mark")
    private Character mark;
    @Column(name = "score")
    private Integer score;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "given_by")
    private String givenBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "given_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date givenOn;
    @Lob
    @Size(max = 65535)
    @Column(name = "optional_note")
    private String optionalNote;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student studentId;
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subject subjectId;

    public Studentmark() {
    }

    public Studentmark(Integer id) {
        this.id = id;
    }

    public Studentmark(Integer id, Character mark, String type, String givenBy, Date givenOn) {
        this.id = id;
        this.mark = mark;
        this.type = type;
        this.givenBy = givenBy;
        this.givenOn = givenOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getMark() {
        return mark;
    }

    public void setMark(Character mark) {
        this.mark = mark;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }

    public Date getGivenOn() {
        return givenOn;
    }

    public void setGivenOn(Date givenOn) {
        this.givenOn = givenOn;
    }

    public String getOptionalNote() {
        return optionalNote;
    }

    public void setOptionalNote(String optionalNote) {
        this.optionalNote = optionalNote;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentmark)) {
            return false;
        }
        Studentmark other = (Studentmark) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amerd.schoolapp.entities.Studentmark[ id=" + id + " ]";
    }
    
}
