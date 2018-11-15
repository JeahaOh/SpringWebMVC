/*  @RequestMapping - HTTP Parameter로 method 구분하기
    HTTP 요청에서 특정 header의 존재 유무에 따라 호출될 method를 구분할 수 있다.
    
    ?
 */
package bitcamp.mvc.web.exam04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_2")
public class Exam04_2 {
  
  @GetMapping(value="get", headers="name")  
  @ResponseBody  
  public String m1() {
      return "Exam04_2.m1()";
  }
  
  @GetMapping(value="get", headers="age")  
  @ResponseBody  
  public String m2() {
      return "Exam04_2.m2()";
  }
  
  @GetMapping(value="get", headers={"name","age"})  
  @ResponseBody  
  public String m3() {
      return "Exam04_2.m3()";
  }
}
