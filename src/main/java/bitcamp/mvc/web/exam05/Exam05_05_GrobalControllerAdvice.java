package bitcamp.mvc.web.exam05;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//  모든 PageController에 대해 조언을 수행하는 클래스 정의
//  => 다음 annotation을 붙이면 FrontController는 PageController를 실행하기 전에
//     먼저 이 클래스를 살펴볼 것이다.
@ControllerAdvice
public class Exam05_5_GrobalControllerAdvice {
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    System.out.println("Exam05_5_GrobalControllerAdvice.initBinder()");
    
    binder.registerCustomEditor(
        java.sql.Date.class,
        new PropertyEditorSupport() {
          @Override
          public void setAsText(String text) throws IllegalArgumentException {
            System.out.println(text);
            this.setValue(Date.valueOf(text));
          }
        });
  }
}