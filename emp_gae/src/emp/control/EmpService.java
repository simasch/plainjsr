package emp.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import emp.entity.Employee;

public class EmpService {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
	public List<Employee> listEmployees() {
        Query q = em.createQuery("select e from Employee e order by e.id");
        List<Employee> list = q.getResultList();
        return list;
    }

    public Employee getEmployee(Long id) {
        Employee e = em.find(Employee.class, id);
        e.getPhones();
        return e;
    }

    public void saveEmployee(Employee e) {
        em.merge(e);
    }

    public void deleteEmployee(Employee e) {
        e = em.merge(e);
        em.remove(e);
    }
}
