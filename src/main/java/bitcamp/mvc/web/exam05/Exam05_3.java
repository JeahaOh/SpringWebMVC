//  RequestHandler의 parameter - Client가 보낸 data를 object로 받기

package bitcamp.mvc.web.exam05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import bitcamp.mvc.vo.Board;

@Controller
@RequestMapping("/exam05_3")
public class Exam05_3 {
  
  //    FrontController로부터 Client가 보낸 값들을 객체에 담아서 받을 수 있다.
  //    http://localhost:8888/mvc/exam05_3/m1?no=11&title=aaaa&content=bbbb
  @GetMapping(value="m1")
  @ResponseBody
  public String m1 (Board board) {
    return String.format("Exam05_3.m1() : no=%d, title=%s, content=%s",
        board.getNo(),
        board.getTitle(),
        board.getContent());
  }
  
  //    object로 받을 수 있는 것은 받고, 낱개로고 받을 수 있다.
  //    http://localhost:8888/mvc/exam05_3/m2?no=11&title=aaaa&content=bbbb&writer=hongkildong
  @GetMapping(value="m2")
  @ResponseBody
  public String m2 (Board board, String writer) {
  return String.format("Exam05_3.m2() : no=%d, title=%s, content=%s, writer=%s",
      board.getNo(),
      board.getTitle(),
      board.getContent(),
      writer);
  }
  
  //    객체 안에 있는 객체 프로퍼티 값 설정하기.
  //    http://localhost:8888/mvc/exam05_3/m3?no=11&title=aaaa&content=bbbb&user.id=hong&user.email=hong@test.com&user.password=1111
  @GetMapping(value="m3")
  @ResponseBody
  public String m3 (Board board) {
  return String.format("Exam05_3.m2() : %s", board);
  }
}
