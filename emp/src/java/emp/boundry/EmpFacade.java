package emp.boundry;

import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
@Produces({"application/json"})
@Consumes({"application/json"})
public class EmpFacade {

    private EmpService service;

    public EmpFacade() throws NamingException {
        InitialContext ic = new InitialContext();
        service = (EmpService) ic.lookup("java:global/emp/EmpService");
    }

    @GET
    public List<EmployeeDTO> list() {
        return service.listEmployees();
    }

    @GET
    @Path("{id}")
    public Employee get(@PathParam("id") Long id) throws WebApplicationException{
        Employee e = service.getEmployee(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        else {
            return e;
        }
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Employee e = service.getEmployee(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        else {
            service.deleteEmployee(e);
        }
    }

    @POST
    public void save(Employee e) {
        service.saveEmployee(e);
    }
}
