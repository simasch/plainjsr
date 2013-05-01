package emp.boundry;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class EmpApplication extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> rrcs = new HashSet<Class<?>>();
		rrcs.add(EmpFacade.class);
		return rrcs;
	}
}
