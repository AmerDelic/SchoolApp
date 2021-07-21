
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.StaffSubject;
import com.amerd.schoolapp.entities.facades.local.SubjectFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Subject;
import com.amerd.schoolapp.util.constants.Miscellaneous;
import java.util.List;
import java.util.ListIterator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class SubjectFacade extends AbstractFacade<Subject> implements SubjectFacadeLocal {

    @PersistenceContext(unitName = Miscellaneous.SCHOOL_APP_PU)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubjectFacade() {
        super(Subject.class);
    }

    @Override
    public void removeTeacherReference(StaffSubject teacher, Subject fromSubject) {
       Subject subject = findById(fromSubject.getId()).get();
       List<StaffSubject> teachersOnSubject = subject.getStaffSubjectList();
        ListIterator<StaffSubject> itr = teachersOnSubject.listIterator();
        while(itr.hasNext()) {
            if(teacher.equals(itr.next())) {
                itr.remove();
            }
        }
        subject.setStaffSubjectList(teachersOnSubject);
        edit(subject);
    }
    
}
