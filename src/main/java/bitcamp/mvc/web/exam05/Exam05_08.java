//  RequestHandler의 parameter - Cookie 받기.
//  http://localhost:8888/exam05_9.html
package bitcamp.mvc.web.exam05;

import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_8")
public class Exam05_8 {
  
  /*    @Cookie annotation을 이용하여 client가 보낸 cookie 값을
        FrontController로 부터 받을 수 있다.
        
        http://localhost:8888/mvc/exam05_8/m1
        http://localhost:8888/mvc/exam05_8/m2
  */
  @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String m1(HttpServletResponse response) {
    try {
      Cookie c1 = new Cookie("name",
          URLEncoder.encode("제하제하", "UTF-8"));
      Cookie c2 = new Cookie("age", "21");
      
      response.addCookie(c1);
      response.addCookie(c2);
      
      return "쿠키 보냄";
    }   catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String m2(
      //    URL 인코딩된 쿠키 값을 받을 때는 Cookie 객체로 받아야 문자가 깨지지 않음.
      @CookieValue(value="name", defaultValue="") Cookie name,
      
      //    URL  인코딩된 값이 아닌 경우 다음과 같이 특정 타입으로 바로 받아도 된다.
      @CookieValue(value="age", defaultValue="20") int age) {
    try {
      System.out.println(name.getValue());
      //    %EC%A0%9C%ED%95%98%EC%A0%9C%ED%95%98
      
      return String.format("Exam05_8.m2() : name=%s, age=%d", 
          URLDecoder.decode(name.getValue(), "UTF-8"), age); 
    }   catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
}
