package emp.control;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import emp.entity.Employee;

public class EmpService {

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployees() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query q = pm.newQuery(Employee.class);
			List<Employee> list = (List<Employee>) q.execute();
			return list;
		} finally {
			pm.close();
		}
	}

	public Employee getEmployee(String id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			return pm.getObjectById(Employee.class, id);
		} finally {
			pm.close();
		}
	}

	public Employee saveEmployee(Employee e) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			e = pm.makePersistent(e);
			return e;
		} finally {
			pm.close();
		}
	}

	public void deleteEmployee(Employee e) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.deletePersistent(e);
		} finally {
			pm.close();
		}
	}
}
