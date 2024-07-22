package eu.nourishedminds;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

import com.vaadin.flow.server.VaadinServlet;
import eu.nourishedminds.config.MyVaadinConfig;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Order(100)
public class VaadinAppInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// Create and register the Spring context for the UI module
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MyVaadinConfig.class);
		context.setServletContext(servletContext);

		// Register the Vaadin servlet
		ServletRegistration.Dynamic vaadinServlet = servletContext.addServlet("vaadinServlet", new VaadinServlet());
		vaadinServlet.setLoadOnStartup(1);
		vaadinServlet.addMapping("/nui/*");
	}
}


