//  RequestHandelr의 parameter - multipart/form-data 형식으로 넘어온 값 꺼내기.
package bitcamp.mvc.web.exam05;

import java.io.File;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/exam05_10")
public class Exam05_10 {
  
  /*    멀티파트 형식으로 넘어 온 데이터를 꺼낼 때는 기존의 파라미터 변수를 선언하는 방식과 같다.
        주의!
        => Spring WebMVC에 multipart data를 처리하는 객체를 등록해랴 한다.
           또한 그 객체가 의존하는 아파치의 commons-fileupload lib도 추가 해야 한다.
           http://localhost:8888/exam05_10.html
  */
  @Autowired ServletContext sc;
  
  @PostMapping(value="m1", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String m1(
      String name,
      int age,
      MultipartFile photo
      ) throws Exception {
    
    String filePath = sc.getRealPath("/" + photo.getOriginalFilename());
    photo.transferTo(new File(filePath));
    
    return String.format("Exam05_10.m1() : name=%s, age=%d, photo=%s",
        name,
        age,
        photo.getOriginalFilename());
  }
}
