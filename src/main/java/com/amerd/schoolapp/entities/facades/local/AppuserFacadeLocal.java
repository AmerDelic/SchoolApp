
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.Appuser;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;


@Local
public interface AppuserFacadeLocal {

    void create(Appuser appuser);

    void edit(Appuser appuser);

    void remove(Appuser appuser);

    Optional<Appuser> findById(Object id);

    List<Appuser> findAll();

    List<Appuser> findRange(int[] range);

    int count();
    
    Optional<Appuser> retrieveAppuserByUsername(String username);
    
    public void removeStaffReference(Appuser fromAppuser);
    
}
