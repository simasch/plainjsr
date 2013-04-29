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
        for (Employee e : list) {
            e.getPhones();
        }
        return list;
    }

    public Employee getEmployee(Long id) {
        return em.find(Employee.class, id);
    }

    @TransactionAttribute(REQUIRED)
    public void saveEmployee(Employee e) {
        em.merge(e);
    }

    @TransactionAttribute(REQUIRED)
    public void deleteEmployee(Long id) {
        Employee e = em.find(Employee.class, id);
        em.remove(e);
    }

}
