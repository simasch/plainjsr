package emp.boundry;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import emp.control.EmpService;
import emp.entity.Employee;

public class EmpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private EmpService service = new EmpService();
	ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if (pathInfo != null) {
			String id = pathInfo.replace("/", "");
			Employee e = service.getEmployee(id);
			service.deleteEmployee(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if (pathInfo == null) {
			List<Employee> list = service.listEmployees();
			mapper.writeValue(resp.getWriter(), list);
		} else {
			String id = pathInfo.replace("/", "");
			Employee e = service.getEmployee(id);
			mapper.writeValue(resp.getWriter(), e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Employee e = mapper.readValue(req.getInputStream(), Employee.class);
		service.saveEmployee(e);
		mapper.writeValue(resp.getWriter(), e);
	}
}
