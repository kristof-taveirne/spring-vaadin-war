package eu.nourishedminds.config;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableVaadin
public class MyVaadinConfig {
	public MyVaadinConfig() {
		System.out.println("VaadinConfig created");
	}

}
