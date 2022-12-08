package mx.springboot.form.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import mx.springboot.form.app.interceptors.TimeLoadInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Autowired
	@Qualifier("tiempoTranscurrido")
	private TimeLoadInterceptor interceptorTime;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//Aplicar interceptor unicamente a la ruta /form/**
		registry.addInterceptor(interceptorTime).addPathPatterns("/form/**");
	}
	
	

}
