/*   @RequestMapping - 한 클래스에 여러 개의 요청 핸들러 두기 I
    한 클래스에 여러 개의 RequestHandler를 정의 할 때는
    각각의 @RequestMapping annotation에 URL을 지정한다.
    
    http://localhost:8888/mvc/exam01_2/m1
    http://localhost:8888/mvc/exam01_2/m2
 */
package bitcamp.mvc.web.exam01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Exam01_2 {
  
  @RequestMapping("/exam01_2/m1")
  @ResponseBody
  public String m1() {
    return "Exam01_2.m1()!";
  }
  
  @RequestMapping("/exam01_2/m2")
  @ResponseBody
  public String m2() {
    return "Exam01_2.m2()!";
  }
}
