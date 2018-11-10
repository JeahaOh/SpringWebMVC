package bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HellController {
  
  @RequestMapping("/hell")
  public String hello() {
    return "/hello.jsp";
  }
}
