//  RequestHandler의 parameter - custom property editor 등록하기 I

package bitcamp.mvc.web.exam05;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import bitcamp.mvc.vo.Member;

@Controller
@RequestMapping("/exam05_04")
public class Exam05_04 {
  
  //    FrontController가 PageController를 호출할 때 기본적으로
  //    클라이언트가 보낸 문자열 데이터를 primitive type의 값으로 변환시켜준다.
  //    그 외의 타입에 대해서는 개발자가 property editor(프로퍼티 값 변환기)를 등록해야 한다.
  //    http://localhost:8888/mvc/exam05_04/m1?title=aaa&content=bbb&createdDate=2018-06-04
  @GetMapping("m1")
  @ResponseBody
  public String m1(String title, String content, Date createdDate) {
    return String.format("Exam05_4.m1() :\n %s\n%s\n%s", title, content, createdDate);
  }
  
  
  //    문자열로 넘어온 값을 custom property editor를 통해 Member 객체로 받을 수 있다.
  //    단, parameter 타입 앞에 @RequestParam을 반드시 붙여야 한다.
  //    http://localhost:8888/mvc/exam05_04/m2?member=hong,hong@test.com,11111
  @GetMapping("m2")
  @ResponseBody
  public String m2(@RequestParam Member member) {
    //  Member parameter 앞에 @RequestParam이 붙게 되면
    //  반드시 파라미터명("member")으로 들어온 값을 처리한다.
    //  그냥 "id", "email", "password"로 넘어온 값은 처리 하지 않는다.
    return String.format("Exam05_4.m2() :\n id=%s\nemail=%s\npassword=%s",
        member.getId(), member.getEmail(), member.getPassword());
  }
  
  
  /*  각 PageController에 property editor를 등록할 수 있다.
      메소드 형식:
          public void 메소드명(WebDataBinder binder) {...}
      그리고 요청이 들어올 때 마다 이 메소드를 먼저 실행하고록 설정해야 한다.
          @InitBinder annotation을 붙이면 됨.
      @InitBinter : FrontController가 RequestHandler를 호출하기 전에 먼저 이 메소드를 호출함.
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    
    //  이 메소드는 요청이 들어올 때 마다 parameter 값을 준비하기 위해
    //  파라미터의 개수 만큼 호출된다.
    System.out.println("Exam05_4.initBinder()");
    
    //  java.lang.String ===> java.sql.Data 변환 시켜주는 property editor 등록
    binder.registerCustomEditor(
        java.sql.Date.class,    //  RequestHandler의 parameterType
        new PropertyEditorSupport() {
         @Override
         public void setAsText(String text) throws IllegalArgumentException {
           System.out.println(text);
           //   "text" parameter는 client가 보낸 data임.
           //   이렇게 문자열로 보낸 데이터는 java.sql.Date 객체로 바꿔야 함.
           this.setValue(Date.valueOf(text));
         }
        });
    
    //  java.lang.String ===> bitcamp.mvc.vo.Member 객체로 변환시켜주는 property editor 등록
    binder.registerCustomEditor(
        bitcamp.mvc.vo.Member.class,    //  RequestHandler의 parameterType
        new PropertyEditorSupport() {
          @Override
          public void setAsText(String text) throws IllegalArgumentException {
            System.out.println(text);
            //  client가 csv format으로 넘긴 회원 정보를
            //  Member 객체로 바꿀 수 있다.
            //  예) JeJe, jeaha1217@test.com, 1020
            String[] values = text.split(",");
            Member obj = new Member();
            obj.setId(values[0]);
            obj.setEmail(values[1]);
            obj.setPassword(values[2]);
            this.setValue(obj);
          }
        });
  }
  
  
}
