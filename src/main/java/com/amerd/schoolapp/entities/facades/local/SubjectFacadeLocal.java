
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.StaffSubject;
import com.amerd.schoolapp.entities.Subject;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;


@Local
public interface SubjectFacadeLocal {

    void create(Subject subject);

    void edit(Subject subject);

    void remove(Subject subject);

    Optional<Subject> findById(Object id);

    List<Subject> findAll();

    List<Subject> findRange(int[] range);

    int count();
    
    void removeTeacherReference(StaffSubject teacher, Subject fromSubject);
}
