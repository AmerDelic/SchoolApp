
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.StudentClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.StudentClassgroup;
import com.amerd.schoolapp.util.constants.Miscellaneous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class StudentClassgroupFacade extends AbstractFacade<StudentClassgroup> implements StudentClassgroupFacadeLocal {

    @PersistenceContext(unitName = Miscellaneous.SCHOOL_APP_PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentClassgroupFacade() {
        super(StudentClassgroup.class);
    }
    
}
