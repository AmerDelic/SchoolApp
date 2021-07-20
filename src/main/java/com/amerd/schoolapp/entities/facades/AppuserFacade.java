package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.AppuserFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Appuser;
import com.amerd.schoolapp.util.constants.Privilege;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

    @Override
    public List<Appuser> retrieveGenericUsers(String ofPrivilege) {
        List<Appuser> genericUsers = new ArrayList<>();
        switch (ofPrivilege) {
            case Privilege.STAFF:
                genericUsers = findAll()
                        .stream()
                        .filter(u -> (u.getAppPrivilege().equals(Privilege.STAFF))
                        && (null == u.getSchoolstaff())
                        && (null == u.getStudent()))
                        .collect(Collectors.toList());
                break;
            case Privilege.STUDENT:
                genericUsers = findAll()
                        .stream()
                        .filter(u -> (u.getAppPrivilege().equals(Privilege.STUDENT))
                        && (null == u.getSchoolstaff())
                        && (null == u.getStudent()))
                        .collect(Collectors.toList());
                break;
                default:
                    break;
        }
        return genericUsers;
    }

}
