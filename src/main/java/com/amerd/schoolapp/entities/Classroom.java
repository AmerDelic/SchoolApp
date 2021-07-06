
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "classroom")
@NamedQueries({
    @NamedQuery(name = "Classroom.findAll", query = "SELECT c FROM Classroom c"),
    @NamedQuery(name = "Classroom.findById", query = "SELECT c FROM Classroom c WHERE c.id = :id"),
    @NamedQuery(name = "Classroom.findByRoomCode", query = "SELECT c FROM Classroom c WHERE c.roomCode = :roomCode"),
    @NamedQuery(name = "Classroom.findByRoomCapacity", query = "SELECT c FROM Classroom c WHERE c.roomCapacity = :roomCapacity"),
    @NamedQuery(name = "Classroom.findByAvEquipped", query = "SELECT c FROM Classroom c WHERE c.avEquipped = :avEquipped")})
public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "room_code")
    private String roomCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "room_capacity")
    private int roomCapacity;
    @Column(name = "av_equipped")
    private boolean avEquipped;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classroomId")
    private List<Classgroup> classgroupList;

    public Classroom() {
    }

    public Classroom(Integer id) {
        this.id = id;
    }

    public Classroom(Integer id, String roomCode, int roomCapacity) {
        this.id = id;
        this.roomCode = roomCode;
        this.roomCapacity = roomCapacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public boolean getAvEquipped() {
        return avEquipped;
    }

    public void setAvEquipped(boolean avEquipped) {
        this.avEquipped = avEquipped;
    }

    public List<Classgroup> getClassgroupList() {
        return classgroupList;
    }

    public void setClassgroupList(List<Classgroup> classgroupList) {
        this.classgroupList = classgroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Classroom)) {
            return false;
        }
        Classroom other = (Classroom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public String isAvEquipped() {
        return avEquipped ? "yes" : "no";
    }

    @Override
    public String toString() {
        return "Classroom " + roomCode + ", AV: " + isAvEquipped();
    }
    
    public String getIdString() {
        return String.valueOf(id);
    }
    
}
