package emp.boundry;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

import emp.control.EmpService;
import emp.entity.Employee;

@Api(name = "empapi", version = "v1", description = "Employee API")
public class EmpEndpoint {

	private EmpService service;

	public EmpEndpoint() {
		service = new EmpService();
	}

	@ApiMethod(name = "list", path = "employees", httpMethod = HttpMethod.GET)
	public List<Employee> list() {
		return service.listEmployees();
	}

	@ApiMethod(name = "get", path = "employees/{id}", httpMethod = HttpMethod.GET)
	public Employee get(@Named("id") Long id) throws WebApplicationException {
		Employee e = service.getEmployee(id);
		if (e == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return e;
		}
	}

	@ApiMethod(name = "delete", path = "employees/{id}", httpMethod = HttpMethod.DELETE)
	public void delete(@Named("id") Long id) {
		Employee e = service.getEmployee(id);
		if (e == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			service.deleteEmployee(e);
		}
	}

	@ApiMethod(name = "save", path = "employees", httpMethod = HttpMethod.POST)
	public void save(Employee e) {
		service.saveEmployee(e);
	}
}
