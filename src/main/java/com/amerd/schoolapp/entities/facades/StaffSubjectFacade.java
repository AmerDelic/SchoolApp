
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.StaffSubjectFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.StaffSubject;
import com.amerd.schoolapp.util.constants.Miscellaneous;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;


@Stateless
public class StaffSubjectFacade extends AbstractFacade<StaffSubject> implements StaffSubjectFacadeLocal {

    @PersistenceContext(unitName = Miscellaneous.SCHOOL_APP_PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffSubjectFacade() {
        super(StaffSubject.class);
    }
    
    @Override
    public Optional<StaffSubject> findByStaffId(int id) {
        TypedQuery query = em.createNamedQuery("StaffSubject.findBySchoolstaffId", StaffSubject.class);
        query.setParameter("schoolstaffId", id);
       return query.getResultList().stream().findFirst();
    }
}
