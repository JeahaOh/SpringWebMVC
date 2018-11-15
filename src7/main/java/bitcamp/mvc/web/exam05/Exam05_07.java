//  RequestHandler의 parameter - Map, Model 받기.  
package bitcamp.mvc.web.exam05;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("exam05_7")
public class Exam05_7 {
  
  /*  View Component(JSP)에게 전달할 data가 있다면
      FrontController애개 Map 또는 Model 객체를 요구하라.
      그리고 이들 객체에 값을 담아 놓으면,
      FrontController가 이들 객체에 담아 놓은 값을 View Component가 사용할 수 있도록
      다시 ServletRequest 보관소에 복사한다. 
      
      http://localhost:8888/mvc/exam05_7/m1
      http://localhost:8888/mvc/exam05_7/m2
      http://localhost:8888/mvc/exam05_7/m3
   */
  @GetMapping(value="m1")
  public String m1(Map<String, Object> map) {
    map.put("name", "JEJE");
    map.put("age", 21);
    
    return "/exam05_7.jsp";
  }
  
  @GetMapping(value="m2")
  public String m2(Model model) {
    model.addAttribute("name", "EKEK");
    model.addAttribute("age", 20);
    
    return "/exam05_7.jsp";
  }
  
  @GetMapping(value="m3")
  public ModelAndView m3() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "JEJE");
    mv.addObject("age", 21);
    mv.setViewName("/exam05_7.jsp");
    
    return mv;
  }
}
