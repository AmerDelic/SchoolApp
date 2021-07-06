
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.StudentClassgroup;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

/*
 * Note: Just a auto-generated, unsused class. Needs modification.
 */
@Local
public interface StudentClassgroupFacadeLocal {

    void create(StudentClassgroup studentClassgroup);

    void edit(StudentClassgroup studentClassgroup);

    void remove(StudentClassgroup studentClassgroup);

    Optional<StudentClassgroup> findById(Object id);

    List<StudentClassgroup> findAll();

    List<StudentClassgroup> findRange(int[] range);

    int count();
    
}
