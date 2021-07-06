
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.Classgroup;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;


@Local
public interface ClassgroupFacadeLocal {

    void create(Classgroup classgroup);

    void edit(Classgroup classgroup);

    void remove(Classgroup classgroup);

    Optional<Classgroup> findById(Object id);

    List<Classgroup> findAll();

    List<Classgroup> findRange(int[] range);

    int count();
    
}
