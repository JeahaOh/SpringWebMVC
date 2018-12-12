//  RequestHandler의 parameter - Client가 보낸 data 받기
//  http://localhost:8888/mvc/exam05_02/m1?name=JEJE&age=21
//  http://localhost:8888/mvc/exam05_02/m2?name=EKEK&age=20
//  http://localhost:8888/mvc/exam05_02/m3?name=JEJE&age=22
//  http://localhost:8888/mvc/exam05_02/m4?age=20
//  http://localhost:8888/mvc/exam05_02/m5?name=EKEK

package bitcamp.mvc.web.exam05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_02")
public class Exam05_02 {
  
  //    FrontController로 부터 클라이언트가 보낸 값을 parameter로 바로 받을 수 있다.
  //    => parameter 변수에 @RequestParam annotation을 붙이면 된다.
  //    => FrontController는 Client가 보낸 문자열 data를 
  //       primitive type(자바 기본 데이터형)으로 자동 변환해 준다.
  @GetMapping(value="m1")
  @ResponseBody
  public String m1 (
      @RequestParam("name") String name,
      @RequestParam("age") int age) {
    return String.format("Exam05_2.m1() : name=%s, age=%d", name, age);
  }
  
  //    만약 Client가 보낸 값의 이름과 파라미터의 이름이 같을 경우
  //    @RequestParam에 이름을 생략할 수 있다.
  @GetMapping(value="m2")
  @ResponseBody
  public String m2 (
      @RequestParam String name,
      @RequestParam int age) {
    return String.format("Exam05_2.m2() : name=%s, age=%d", name, age);
  }
  
  //    만약 Client가 보낸 값의 이름과 파라미터의 이름이 같을 경우
  //    @RequestParam에 이름을 생략해도 된다.
  //    => 이 annotation을 붙이지 않으면 parameter의 값을 선택사항으로 다룬다.
  //    => 즉, parameter 값이 넘어오지 않으면 null값을 갖게 된다.
  //    => parameter의 type이 문자열이 아닐경우 형변환 할 때 오류가 발생한다.
  @GetMapping(value="m3")
  @ResponseBody
  public String m3 (
      String name,
      int age) {
    return String.format("Exam05_2.m3() : name=%s, age=%d", name, age);
  }
  
  //    @RequestParam에서 [필수/선택] 여부를 지정할 수 있다.
  //    => required 속성의 값을 false로 지정한다. (생략하면 true)
  @GetMapping(value="m4")
  @ResponseBody
  public String m4 (
      @RequestParam(required=false) String name,
      @RequestParam(required=false) int age) {
    return String.format("Exam05_2.m4() : name=%s, age=%d", name, age);
  }
  
  //    Client가 값을 보내지 않으면 기본 값을 넣어 지정할 수 있다.
  @GetMapping(value="m5")
  @ResponseBody
  public String m5 (
      String name,
      @RequestParam(defaultValue="20") int age) {
    return String.format("Exam05_2.m5() : name=%s, age=%d", name, age);
  }
}
