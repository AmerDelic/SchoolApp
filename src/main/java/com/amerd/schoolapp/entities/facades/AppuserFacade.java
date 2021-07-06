
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.AppuserFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Appuser;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class AppuserFacade extends AbstractFacade<Appuser> implements AppuserFacadeLocal {

    @PersistenceContext(unitName = "school_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppuserFacade() {
        super(Appuser.class);
    }

    @Override
    public Optional<Appuser> retrieveAppuserByUsername(String username) {
        
        Query query = em.createNamedQuery("Appuser.findByAppUsername", Appuser.class);
        query.setParameter("appUsername", username);
        Optional<Appuser> result = query.getResultList().stream().findFirst();
        return result;
    }
    
    @Override
    public void removeStaffReference(Appuser fromAppuser) {
        fromAppuser.setSchoolstaff(null);
        edit(fromAppuser);
    }

}
    
