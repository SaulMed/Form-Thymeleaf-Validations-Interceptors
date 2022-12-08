package mx.springboot.form.app.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("tiempoTranscurrido")
public class TimeLoadInterceptor implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(TimeLoadInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//Evitar que calcule el tiempo transcurrido en una peticion POST, solo en GET
		if(request.getMethod().equalsIgnoreCase("post")) {	
			return true;
		}
		
		if(handler instanceof HandlerMethod) {
				HandlerMethod metodo = (HandlerMethod) handler;
				System.out.println("Soy un metodo de controlador " + metodo.getMethod().getName());
		}
		
		logger.info("Tiempo Transcurrido Interceptor, entrando en preHandle... ");
		logger.info("Interceptando: " + handler);
		
		//Pasar tiempo inicio atraves de la peticion
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		//Simular retraso en la carga
		Random randomSleep = new Random();
		Integer delay = randomSleep.nextInt(250);
		Thread.sleep(delay);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		//Evitar que calcule el tiempo transcurrido en una peticion POST, solo en GET
		if(request.getMethod().equalsIgnoreCase("post")) {
			return;
		}
		
		long endTime = System.currentTimeMillis();
		long startTime = (Long) request.getAttribute("startTime");
		long finalTime = endTime - startTime;
		
		if(handler instanceof HandlerMethod && modelAndView != null) {
			modelAndView.addObject("finalTime", finalTime);
		}
		
		logger.info("Tiempo Transucrrido: " + finalTime + " milisegundos.");
		logger.info("Tiempo Transcurrido Interceptor, saliendo de postHandle...");
	}

}
