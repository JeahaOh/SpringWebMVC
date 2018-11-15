//  RequestHandler의 return value - content를 직접 return. II
package bitcamp.mvc.web.exam06;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam06_02")
public class Exam06_02 {
  
  //    RequestHander 에서 content를 직접 return할 때
  //    HttpEntity에 담아서 return할 수 있다.
  @GetMapping("m1")
  public HttpEntity<String> m1() {
    //  마찬가지로 응답 content의 기본 타입은
    //  "text/html;charset=ISO-8859-1" 이다.
    HttpEntity<String> entity = new HttpEntity<>(
        "Exam06_02.m1() ==> 012ASDFqwer#!@가각간");
    
    return entity;
    //  결과
    //  http://localhost:8888/mvc/exam06_02/m1
    //  Exam06_02.m1() ==> 012ASDFqwer#!@???
  }
  
  @GetMapping("m2")
  @ResponseBody
  public HttpEntity<String> m2() {
    //  응답 content의 type과 문자표를 설정하고 싶다면
    //  응답 header를 명시적으로 지정하라.
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/plain;charset=UTF-8");
    
    HttpEntity<String> entity = new HttpEntity<>(
        "Exam05_02.m2() ==> 012ASDFqwer#!@가각간", headers);
    
    return entity;
    //  결과
    //  http://localhost:8888/mvc/exam06_02/m2
    //  Exam05_02.m1() ==> 012ASDFqwer#!@가각간
  }
  
  @GetMapping("m3")
  public ResponseEntity<String> m3() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Contoent-Type", "text/plain;charset=UTF-8");
    
    //    ResponseEntity는 HttpEntity의 하위 클래스이다.
    //    응답할 때 상태코드를 설정할 수 있다.
    ResponseEntity<String> entity = new ResponseEntity<>(
        "Exam05_02.m3() ==> 012ASDFqwer#!@가각간",
        headers,
        HttpStatus.OK);
    
    return entity;
    
    //  http://localhost:8888/mvc/exam06_02/m3
    //  Exam05_02.m3() ==> 012ASDFqwer#!@???
  }
}
