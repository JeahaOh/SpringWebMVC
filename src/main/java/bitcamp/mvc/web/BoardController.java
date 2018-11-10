package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import bitcamp.mvc.dao.BoardDao;
import bitcamp.mvc.vo.Board;

//  http://localhost:8888/mvc/board/add
@Controller("web.BoardController")
public class BoardController {
  
  BoardDao boardDao;

  public BoardController(BoardDao boardDao) {
    super();
    this.boardDao = boardDao;
  }
  
  @RequestMapping("/board/add")
  public String add() {
    Board board = new Board();
    board.setTitle("title");
    board.setContent("Content");
    
    boardDao.insert(board);
    
    return "/board/add.jsp";
  }
}
