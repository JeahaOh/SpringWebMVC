package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Exam01 {
  
  //    http://localhost:8888/mvc/exam01/m1
  @RequestMapping("/exam01/m1")
  @ResponseBody  //  리턴값이 View URL이 아니라 내용물임.(Hello! 출력함)  
  public String m1() {
    return "Hello!";
  }
  
}
