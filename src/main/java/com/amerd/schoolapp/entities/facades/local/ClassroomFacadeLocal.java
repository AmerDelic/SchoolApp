
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.Classgroup;
import com.amerd.schoolapp.entities.Classroom;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;


@Local
public interface ClassroomFacadeLocal {

    void create(Classroom classroom);

    void edit(Classroom classroom);

    void remove(Classroom classroom);

    Optional<Classroom> findById(Object id);

    List<Classroom> findAll();

    List<Classroom> findRange(int[] range);

    int count();
    
    void removeClassgroupReference(Classgroup group, Classroom fromClassroom);
    
}
