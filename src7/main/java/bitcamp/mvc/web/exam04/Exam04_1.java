/*  @RequestMapping - HTTP Parameter로 method 구분하기
    Parameter 값의 존재 여부에 따라 mehtod를 구분할 수 있다.
    GetMapping의 value가 get인 것을 잊지 말라.
    
    http://localhost:8888/mvc/exam04_1/get?name=aaa
    http://localhost:8888/mvc/exam04_1/get?age=x
    http://localhost:8888/mvc/exam04_1/get?name=aaa&age=x
 */
package bitcamp.mvc.web.exam04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_1")
public class Exam04_1 {
  
  @GetMapping(value="get", params="name")  
  @ResponseBody  
  public String m1() {
      return "Exam04_1.m1()";
  }
  
  @GetMapping(value="get", params="age")  
  @ResponseBody  
  public String m2() {
      return "Exam04_1.m2()";
  }
  
  @GetMapping(value="get", params={"name","age"})  
  @ResponseBody  
  public String m3() {
      return "Exam04_1.m3()";
  }
}
