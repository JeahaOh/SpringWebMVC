package bitcamp.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    /*  WebApplication을 시작할 때 이 method를 호출함.
        ServletContainer (ex: Tomcat Server)
          ==> spring-web.jar 파일에서
              /META-INF/services/javax.servlet.ServletContainerInitializer 파일을 찾음.
          ==> 그 파일에서 구현체 정보를 알아내어 객체를 생성한 후 호출함.
          ==> SpringServletContainerInitializer.onStartup() 호출.
            ===> WebApplicationInitializer 구현체의 onStart()를 호출.
            ===> MyWebApplicationInitializer.onStartup() 호출.
     */
    System.out.println("===> MyApplicationInitailizer.onStartup()");
    
    //  여기에서 FrontController를 등록할 것임.
    //  1) FrontController가 사용할 Spring IoC Container를 만듦.
    XmlWebApplicationContext iocContainer = new XmlWebApplicationContext();
    iocContainer.setConfigLocation("/WEB-INF/spring/mvc-servlet.xml");
    
    //  2) FrontController를 만든다.
    DispatcherServlet mvcDispatcher = new DispatcherServlet(iocContainer);
    
    //  3) FrontController를 WebApplication에 등록한다.
    //  => addServlet()의 리턴 값은 Servlet URL 패턴 등을 설정하는 도구.
    Dynamic registration = servletContext.addServlet("mvc", mvcDispatcher);
    
    //  4) load-on-startup 값 설정.
    registration.setLoadOnStartup(1);
    registration.addMapping("/mvc/*");
  }
}
