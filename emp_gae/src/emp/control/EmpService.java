package emp.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import emp.entity.Employee;

public class EmpService {

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployees() {
		EntityManager em = EMF.get().createEntityManager();
		Query q = em.createQuery("select e from Employee e order by e.id");
		List<Employee> list = q.getResultList();
		em.close();
		return list;
	}

	public Employee getEmployee(Long id) {
		EntityManager em = EMF.get().createEntityManager();
		Employee e = em.find(Employee.class, id);
		e.getPhones();
		em.close();
		return e;
	}

	public void saveEmployee(Employee e) {
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.merge(e);
		trx.commit();
		em.close();
	}

	public void deleteEmployee(Employee e) {
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		e = em.merge(e);
		em.remove(e);
		trx.commit();
		em.close();
	}
}
