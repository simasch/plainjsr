package emp.boundry;

import org.restlet.Context;
import org.restlet.ext.jaxrs.JaxRsApplication;

public class JaxRsEmpApplication extends JaxRsApplication {

	public JaxRsEmpApplication(Context context) {
		super(context);
		this.add(new EmpApplication());
	}

}
