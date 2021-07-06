
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.StaffSubject;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;


@Local
public interface StaffSubjectFacadeLocal {

    void create(StaffSubject staffSubject);

    void edit(StaffSubject staffSubject);

    void remove(StaffSubject staffSubject);

    Optional<StaffSubject> findById(Object id);

    List<StaffSubject> findAll();

    List<StaffSubject> findRange(int[] range);

    int count();
    
    Optional<StaffSubject> findByStaffId(int id);
}
