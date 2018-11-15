//  @RequestMapping - GET/POST/PUT 등 요청 구분 I
package bitcamp.mvc.web.exam03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam03_1")
public class Exam03_1 {
  
  //    GET/POST/PUT 등 HTTP 요청을 특별히 구분하지 않으면
  //    모든 경우에 대해 호출한다.
  //    test
  //        http://localhost:8888/exam03_1.html
  
  @RequestMapping("m1")
  @ResponseBody
  public String m1() {
    return "Exam03_1.m1()";
  }

}
