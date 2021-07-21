
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.Studentmark;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

@Local
public interface StudentmarkFacadeLocal {

    void create(Studentmark studentmark);

    void edit(Studentmark studentmark);

    void remove(Studentmark studentmark);

    Optional<Studentmark> findById(Object id);

    List<Studentmark> findAll();

    List<Studentmark> findRange(int[] range);

    int count();
    
}
