
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.Schoolstaff;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;


@Local
public interface SchoolstaffFacadeLocal {

    void create(Schoolstaff schoolstaff);

    void edit(Schoolstaff schoolstaff);

    void remove(Schoolstaff schoolstaff);

    Optional<Schoolstaff> findById(Object id);

    List<Schoolstaff> findAll();

    List<Schoolstaff> findRange(int[] range);

    int count();
    
    void removeTeacherReference(Schoolstaff fromStaff);
    
    void removeClassgroupReference(Schoolstaff fromStaff);
    
    List<Schoolstaff> findAllStaffByStatus(boolean isTeacher);
    
    List<Schoolstaff> findNonHeadTeacherStaff();
    
}
