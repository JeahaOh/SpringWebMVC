//  RequestHandler의 parameter - HTTP RequestHeader 값 받기.
//  http://localhost:8888/mvc/exam05_6/m1
package bitcamp.mvc.web.exam05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("exam05_6")
public class Exam05_6 {
  
  //    @RequestHeader("헤더명")을 사용하면 HTTP RequestHeader의 값을 parameter로 받을 수 있다.
  @GetMapping(value="m1", produces="text/plain")
  @ResponseBody
  public String m1(
      @RequestHeader("User-Agent") String userAgent,
      @RequestHeader(required=false, value="Content-Type") String contentType,
      @RequestHeader("Accept") String accept ) {
    
    return String.format("Exam05_6.m1() :\n userAgent: %s\n contentType: %s\n accept: %s\n", userAgent, contentType, accept);
  }
}
