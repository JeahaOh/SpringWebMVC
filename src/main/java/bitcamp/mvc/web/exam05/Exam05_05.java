//  RequestHandler의 parameter - custom property editor 등록하기 II
//  http://localhost:8888/mvc/exam05_05/m1?title=asdf&content=1q2w3e4r&createdDate=2018-11-02

package bitcamp.mvc.web.exam05;

import java.sql.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_05")
public class Exam05_05 {
  @GetMapping("m1")
  @ResponseBody
  public String m1(String title, String content, Date createdDate) {
    return String.format("Exam05_5.m1() : %s, %s, %s",
        title, content, createdDate);
  }
  
  /*
      GrobalControllerAdvice 객체에 따로 propertyEditor를 초기화 시키는 method를 정의해 두었기 때문에
      다음 method를 이 Controller에 등록하지 않아도 된다.
  @InitBinder
  public void initBinder (WebDataBinder binder) {
    System.out.println("Exam05_5_LocalControllerAdvice.initBinder()");
    binder.registerCustomEditor(
        java.sql.Date.class,
        new PropertyEditorSupport() {
          @Override
          public void setAsText(String text) throws IllegalArgumentException {
            this.setValue(Date.valueOf(text));
          }
        });
  }
  */
}
