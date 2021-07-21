
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.StudentClassgroup;
import com.amerd.schoolapp.util.constants.Miscellaneous;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = Miscellaneous.SCHOOL_APP_PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }
    
    @Override
    public Student retrieveStudentByAppId(Integer appuserId) {   
           TypedQuery<Student> query = em.createNamedQuery("Student.findByAppId", Student.class);
            query.setParameter("appuserId", appuserId);
            Student s = query.getSingleResult();
            return s;
    }
    
    @Override
    public List<Student> findAllUnassignedStudents() {
        List<Student> allSs = findAll();
        List<Student> unassignedSs = allSs.stream()
                .filter(s -> s.getStudentClassgroup() == null)
                .collect(Collectors.toList());
        return unassignedSs;
    }

    @Override
    public void removeClassgroupReference(Student fromStudent) {
        fromStudent.setStudentClassgroup(null);
        edit(fromStudent);
//       List<Student> students = fromStudents.stream().map(s -> s.getStudent()).collect(Collectors.toList());
//       students.forEach(s -> s.setStudentClassgroup(null));
//       students.forEach(s -> edit(s));
       
       
    }
    
    
    
}
