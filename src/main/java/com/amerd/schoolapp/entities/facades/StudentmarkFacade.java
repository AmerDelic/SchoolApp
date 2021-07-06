
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.StudentmarkFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Studentmark;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * Note: Just a auto-generated, unsused class. Needs modification.
 */
@Stateless
public class StudentmarkFacade extends AbstractFacade<Studentmark> implements StudentmarkFacadeLocal {

    @PersistenceContext(unitName = "school_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentmarkFacade() {
        super(Studentmark.class);
    }
    
}
