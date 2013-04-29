package jhr.boundry;

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
import jhr.control.EmpService;
import jhr.entity.Employee;

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
    public List<Employee> list() {
        return service.listEmployees();
    }

    @GET
    @Path("{id}")
    public Employee get(@PathParam("id") Long id) {
        return service.getEmployee(id);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        service.deleteEmployee(id);
    }

    @POST
    public void save(Employee e) {
        service.saveEmployee(e);
    }
}
