//   RequestHandler의 return value - view Component URL 또는 이름 return하기
package bitcamp.mvc.web.exam06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/exam06_03")
public class Exam06_03 {
  
  //    requestHandler에서 view URL을 return하면
  //    FrontController는 그  URL을 include한다.
  @GetMapping("m1")
  public String m1() {
    //  return 값으로 jsp의 url을 알려주면 된다.
    return "/exam06_03.jsp";
  }
  
  @GetMapping("m2")
  public View m2() {
    //  view Component URL을 View 구현체에 담아서 return할 수 있다.
    return new JstlView("/exam06_03.jsp");
  }
  
  @GetMapping("m3")
  public View me() {
    //  view component URL을 View 구현체에 담아서 return할 수 있다.
    return new RedirectView("../exam06_01/m1");
  }
  
  @GetMapping("m4")
  public String m4() {
    //  보통 redirect는 URL에 "redirect:"라는 접두어를 붙여서 문자열로 리턴한다.
    return "redirect:../exam06_01/m2";
  }
  
  @GetMapping("m5")
  public ModelAndView m5() {
    //  데이터와 함께 view URL을 리턴할 때는 ModelAndView 객체를 사용하기도 한다.
    //  -> ModelAndView에 저장된 data는 FrontController가 ServletRequest 보관소로 복사한다.
    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "JEJE");
    mv.addObject("age", 21);
    mv.setViewName("/exam06_03.jsp");
    return mv;
  }
}
