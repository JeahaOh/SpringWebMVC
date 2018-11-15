//    http://localhost:8888/mvc/exam01_1/m1
package bitcamp.mvc.web.exam01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //  PageController를 가리킬때 보통 이 annotation을 붙인다.
@RequestMapping("/exam01_1/m1") //  요청 핸들어와 URL을 연결할 때 이 annotation을 붙인다.
public class Exam01_1 {
  
  @RequestMapping       //  위에서 지정한 URL 요청을 처리할 method를 지정한다.
  @ResponseBody         //  이 method의 리턴 값은 client에게 리턴할 content임을 지정한다.
  public String m1() {
    return "Exam01_1.m1()!";
  }
  
  /*
  *     다음과 같이 RequestMapping이 붙은 method를 또 정의 하면
  *     "/exam01_1/m1" 요청에 대해 어떤 method를 호출할 지 결정할 수 없기 때문에 실행 오류가 발생한다.
  @RequestMapping
  @ResponseBody
  public String m2() {
    return "Exam01_1.m2()!";
  }
  */
}
