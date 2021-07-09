
package com.amerd.schoolapp.entities.facades.local;

import com.amerd.schoolapp.entities.Student;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;


@Local
public interface StudentFacadeLocal {

    void create(Student student);

    void edit(Student student);

    void remove(Student student);

    Optional<Student> findById(Object id);

    List<Student> findAll();

    List<Student> findRange(int[] range);

    int count();
    
    public Student retrieveStudentByAppId(Integer appuserId);
    
    List<Student> findAllUnassignedStudents();
}
