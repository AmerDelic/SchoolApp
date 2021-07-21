
package com.amerd.schoolapp.entities.facades;

import com.amerd.schoolapp.entities.facades.local.ClassgroupFacadeLocal;
import com.amerd.schoolapp.entities.facades.abstracts.AbstractFacade;
import com.amerd.schoolapp.entities.Classgroup;
import com.amerd.schoolapp.entities.Student;
import com.amerd.schoolapp.entities.StudentClassgroup;
import com.amerd.schoolapp.entities.facades.local.StudentFacadeLocal;
import com.amerd.schoolapp.util.constants.Miscellaneous;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ClassgroupFacade extends AbstractFacade<Classgroup> implements ClassgroupFacadeLocal {

    @PersistenceContext(unitName = Miscellaneous.SCHOOL_APP_PU)
    private EntityManager em;
    
    @Inject
    FacesContext facesContext;
    @Inject
    StudentFacadeLocal studentFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassgroupFacade() {
        super(Classgroup.class);
    } 

    @Override
    public void removeMemberReference(Classgroup fromClass, StudentClassgroup studentMember) {
        Classgroup clazz = findById(fromClass.getId()).get(); 
        List<StudentClassgroup> members = clazz.getStudentClassgroupList();
        ListIterator itr = members.listIterator();
        while(itr.hasNext()) {
            if(studentMember.equals(itr.next())) {
                itr.remove();
            }
        }
        clazz.setStudentClassgroupList(members);
        edit(clazz);
    }

    @Override
    public List<Student> getClassMembers(Classgroup fromClass) {
        Optional<Classgroup> classOpt = findById(fromClass.getId());
        if(classOpt.isPresent()) {
            Classgroup theClass = classOpt.get();
            List<StudentClassgroup> members = theClass.getStudentClassgroupList();
            List<Student> students = members.stream().map(m -> m.getStudent()).collect(Collectors.toList());
            students.stream().forEach(studentFacade::edit);
            return students;
        } else {
            setUImessage(FacesMessage.SEVERITY_ERROR, "Couldn't locate class in db");
            return null;
        }     
    }
    
    private void setUImessage(FacesMessage.Severity severity, String msg) {
        facesContext.addMessage(null, new FacesMessage(severity, msg, null));
    }
}
