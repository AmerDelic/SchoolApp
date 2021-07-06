package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.SchoolstaffFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Schoolstaff;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SchoolstaffFacade extends AbstractFacade<Schoolstaff> implements SchoolstaffFacadeLocal {

    @PersistenceContext(unitName = "school_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SchoolstaffFacade() {
        super(Schoolstaff.class);
    }

    @Override
    public void removeTeacherReference(Schoolstaff fromStaff) {
        fromStaff.setStaffSubject(null);
        edit(fromStaff);
    }
    
    @Override
    public void removeClassgroupReference(Schoolstaff fromStaff) {
        fromStaff.setClassgroup(null);
        edit(fromStaff);
    }

    @Override
    public List<Schoolstaff> findAllStaffByStatus(boolean isTeacher) {
        List<Schoolstaff> result;
        if (isTeacher) {
            result = findAll()
                    .stream()
                    .filter(s -> s.getStaffSubject() != null)
                    .collect(Collectors.toList());

        } else {
            result = findAll()
                    .stream()
                    .filter(s -> s.getStaffSubject() == null)
                    .collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public List<Schoolstaff> findNonHeadTeacherStaff() {
        List<Schoolstaff> regularTeachers = findAllStaffByStatus(true)
                .stream()
                .filter(t -> t.getClassgroup() == null)
                .collect(Collectors.toList());
        return regularTeachers;
    }

}
