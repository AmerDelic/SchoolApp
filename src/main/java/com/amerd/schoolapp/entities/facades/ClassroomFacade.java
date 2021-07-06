
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.Classgroup;
import com.amerd.schoolapp.entities.facades.local.ClassroomFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Classroom;
import java.util.List;
import java.util.ListIterator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ClassroomFacade extends AbstractFacade<Classroom> implements ClassroomFacadeLocal {

    @PersistenceContext(unitName = "school_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassroomFacade() {
        super(Classroom.class);
    }

    @Override
    public void removeClassgroupReference(Classgroup group, Classroom fromClassroom) {
        Classroom classroom = findById(fromClassroom.getId()).get();
        List<Classgroup> classgroups = classroom.getClassgroupList();
        ListIterator<Classgroup> itr = classgroups.listIterator();
        while(itr.hasNext()) {
            if(group.equals(itr.next())) {
                itr.remove();
            }
        }
        classroom.setClassgroupList(classgroups);
        edit(classroom);
    }
    
}
