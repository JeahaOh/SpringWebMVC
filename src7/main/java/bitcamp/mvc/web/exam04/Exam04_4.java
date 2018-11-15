/*  @RequestMapping - HTTP 요청에서 Content-Type header 다루기.
    HTTP 요청에서 "Content-Type" 헤더의 값에 까라 호출될 method를 구분하기
    =>  client는 POST 요청으로 데이터를 보낼 때
        서버에 그 데이터 타입을 알려줘야 한다.
        이때 사용하는 header가 "Content-Type"이다.
    
    http://localhost:8888/exam04_4.html
 */
package bitcamp.mvc.web.exam04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_4")
public class Exam04_4 {
  
  //    클라이언트가 보낸 데이터가 "변수=값&변수=값&변수=값" 형태라면.
  @PostMapping(value="post", consumes="application/x-www-form-urlencorded")
  @ResponseBody
  public String m1() {
    return "Exam04_4.m1()";
  }
  
  //    클라이언트가 csv(comma-separated values) 형식으로 데이터를 보낸다면
  @PostMapping(value="post", consumes="text/csv")
  @ResponseBody
  public String m2() {
    return "Exam04_4.m2()";
  }
  
  //    클라이언트가 JSON 형식으로 데이터를 보낸다면.
  @PostMapping(value="post", consumes="application/json")
  @ResponseBody
  public String m3() {
    return "Exam04_4.m3()";
  }
}

/*
  POST 요청
POST /mvc/exam04_4/post HTTP/1.1
Host: localhost:8888

...

User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36
Content-Type: application/x-www-form-urlencorded

...


Request Payload
name=JEJE&age=21&tel=14-71011727
*/