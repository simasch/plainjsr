package emp.boundry;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import emp.control.EmpService;
import emp.entity.Employee;

@Path("employees")
public class EmpFacade {

	private EmpService service;

	public EmpFacade() {
		service = new EmpService();
	}

	@GET
	@Produces(APPLICATION_JSON)
	public List<Employee> list() {
		return service.listEmployees();
	}

	@GET
	@Produces(APPLICATION_JSON)
	@Path("{id}")
	public Employee get(@PathParam("id") Long id)
			throws WebApplicationException {
		Employee e = service.getEmployee(id);
		if (e == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return e;
		}
	}

	@DELETE
	@Consumes(APPLICATION_JSON)
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		Employee e = service.getEmployee(id);
		if (e == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			service.deleteEmployee(e);
		}
	}

	@POST
	@Consumes(APPLICATION_JSON)
	public void save(Employee e) {
		service.saveEmployee(e);
	}
}
