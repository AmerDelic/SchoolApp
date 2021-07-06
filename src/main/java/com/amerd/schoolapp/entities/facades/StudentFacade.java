
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "school_pu")
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
    
}
