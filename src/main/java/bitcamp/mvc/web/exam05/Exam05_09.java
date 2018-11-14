//  RequestHandler의 parameter - @RequestBody를 사용하여 통으로 넘어온 값 받기.
package bitcamp.mvc.web.exam05;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import bitcamp.mvc.vo.Board;

@Controller
@RequestMapping("/exam05_9")
public class Exam05_9 {
  //    Client로부터 한 통으로 된 값을 받을 때
  //    @RequestBody를 사용한다.
  
  @PostMapping("post")
  @ResponseBody
  public String m1 (
      //    application/x-www-form-urlencoded 형식으로 값이 넘어올 때는
      //    다음과 같이 각각의 값을 개별 변수로 받을 수 있다.
      String name, int age, String tel) {
    return String.format("Exam05_9.m1() : name=%s, age=%d, tel=%s",
        name, age, tel);
  }
  
  @PostMapping(value="post", consumes="text/plain")
  @ResponseBody
  public String m2 (
      //    text/plain, text/csv, application/jason 처럼
      //    통으로 값이 넘어올 때는 개별 변수로 받을 수 없다.
      //    통으로 받아야 하며 변수 명을 상관 없다.
      //    단, 변수명 앞에 @RequestBody annotation을 붙여야 한다.
      @RequestBody String content) {
    return String.format("Exam05_9.m2() : %s", content);
  }
  
  @PostMapping(value="post", consumes="text/csv")
  @ResponseBody
  public String m3 (
      @RequestBody String content) {
    String[] values = content.split(",");
    return String.format("Exam05_9.m3() : name=%s, age=%s, tel=%s",
        values[0], values[1], values[2]);
  }
  
  
  @PostMapping(value="post", consumes="application/json")
  @ResponseBody
  public String m4 (
      @RequestBody String content) {
    
    //  Google-gson lib를 사용해서 JSON 문자열을 자바 객체로 변환시킨다.
    @SuppressWarnings("unchecked")
    Map<String, Object> map = new Gson().fromJson(content, Map.class);
    
    return String.format("Exam05_9.m4() : name=%s, age=%s, tel=%s",
        map.get("name"), map.get("age"), map.get("tel"));
  }
  
  @PostMapping(value="post2", consumes="application/json")
  @ResponseBody
  public String m5 (
      @RequestBody String content) {
    
    //  Google-gson lib를 사용해서 JSON 문자열을 자바 객체로 변환시킨다.
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    Board board = gson.fromJson(content, Board.class);
    
    return String.format("Exam05_9.m5() : no=%d, title=%s, content=%s, createdDate=%s",
        board.getNo(),
        board.getTitle(),
        board.getContent(),
        board.getCreatedDate());
  }
}
