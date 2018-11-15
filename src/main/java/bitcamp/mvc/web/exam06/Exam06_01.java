//  RequestHandler의 return value - content를 직접 return. I
package bitcamp.mvc.web.exam06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam06_01")
public class Exam06_01 {
  
  //    RequestHander 에서 content를 직접 return할 때는
  //    Method 선언부에 @ResponseBody를 붙여야 한다.
  @GetMapping("m1")
  @ResponseBody
  public String m1() {
    //  응답 content의 타입은 기본으로
    //  "text/html;charset=ISO-8859-1" 이다.
    return "Exam06_01.m1() ==> 012ASDFqwer#!@가각간";
    //  결과
    //  http://localhost:8888/mvc/exam06_01/m1
    //  Exam06_01.m1() ==> 012ASDFqwer#!@???
  }
  
  @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String m2() {
    /*  @ResponseBody로 content를 출력할 때 
        Content-Type을 설정하고 싶다면,
        @RequestMapping, @GetMapping, @PostMapping annotation에서
        produces 속성에 content type을 지정하라!
        원래 produces는 client의 HTTP RequestHeader인 Accept 값과 일치하는 지 비교할 때
        사용하는 속성이지만, 이렇게 콘텐트를 직접 출력할 때에
        FrontController는 Content-Type을 설정하는 용도로 사용한다.
    */
    return "Exam05_02.m1() ==> 012ASDFqwer#!@가각간";
    //  결과
    //  http://localhost:8888/mvc/exam06_01/m2
    //  Exam05_02.m1() ==> 012ASDFqwer#!@가각간
  }
}
