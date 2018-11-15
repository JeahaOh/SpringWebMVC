/*  @RequestMapping - HTTP 요청에서 Accept header 다루기.
    HTTP 요청에서 "Accept" 헤더의 값에 따라 호출될 method를 구분하기
    =>  client가 return 받기를 원하는 타입이 무엇인지를 지정하는 header가 Accept임.
    //  이 부분 110기가 더 나은듯?
    
    http://localhost:8888/exam04_3.html
 */
package bitcamp.mvc.web.exam04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_3")
public class Exam04_3 {
  
  @GetMapping(value="get", produces="text/plain")
  @ResponseBody  
  public String m1() {
    //  이 method는 실행한 결과를 순수한 text로 만들어서 보냄.
      return "Exam04_3.m1()";
  }
  
  @GetMapping(value="get", produces="text/html")
  @ResponseBody  
  public String m2() {
    //  이 method는 실행한 결과를 HTML text로 만들어서 보냄.
      return "Exam04_3.m2()";
  }
  
  @GetMapping(value="get", produces="application/pdf")
  @ResponseBody  
  public String m3() {
    //  이 method는 실행한 결과를 pdf로 만들어서 보냄.
      return "Exam04_3.m3()";
  }
}
