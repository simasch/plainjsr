package jhr.control;

import static javax.ejb.TransactionAttributeType.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jhr.entity.Employee;

@Stateless
@TransactionAttribute(NOT_SUPPORTED)
public class EmpService {

    @PersistenceContext
    private EntityManager em;

    public List<Employee> listEmployees() {
        TypedQuery q = em.createQuery("select e from Employee e", Employee.class);
        List<Employee> list = q.getResultList();
        return list;
    }

    public Employee getEmployee(Long id) {
        Employee e = em.find(Employee.class, id);
        e.getPhones();
        return e;
    }

    @TransactionAttribute(REQUIRED)
    public void saveEmployee(Employee e) {
        em.merge(e);
    }

    @TransactionAttribute(REQUIRED)
    public void deleteEmployee(Employee e) {
        e = em.merge(e);
        em.remove(e);
    }
}
