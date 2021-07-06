
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.StudentClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.StudentClassgroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * Note: Just a auto-generated, unsused class. Needs modification.
 */
@Stateless
public class StudentClassgroupFacade extends AbstractFacade<StudentClassgroup> implements StudentClassgroupFacadeLocal {

    @PersistenceContext(unitName = "school_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentClassgroupFacade() {
        super(StudentClassgroup.class);
    }
    
}
