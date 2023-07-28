package net.softsociety.exam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;
import net.softsociety.exam.service.BoardService;

/**
 * 상품게시판 관련 콘트롤러
 */

/**
 * 20230727 
 * @author user
 *
 */

@Slf4j
@RequestMapping("board")
@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	/**
	 * 2023.07.27
	 * board.html에서 판매 정보를 띄우는 컨트롤러
	 * @author 수정
	 * @param Board b, Model m
	 * @return ArrayList<Board>
	 */
	@GetMapping("board")
	public String board(Board b, Model m)
	{
		ArrayList<Board> boardlist = service.boardlist(b);
		m.addAttribute("boardlist", boardlist); //앞이 이름 뒤가 값
		log.debug("boardlist 값 : {}",m);
		return "board/board";
	}
	
	/**
	 * 2023.07.28
	 * board.html의 글제목을 클릭하면 내용을 읽는 컨트롤러
	 * @author 수정
	 * @param Model m, 
	 * @param @RequestParam(name="boardnum", defaultValue = "0") int boardnum
	 * @return Board
	 */
	@GetMapping("read")
	public String read(	Model m,
						@RequestParam(name="boardnum", defaultValue = "0") int boardnum)
	{
		log.debug("Clicked boardnum: {}", boardnum);
		if (boardnum == 0) return "redirect:/board/list";
		             
		Board b = service.read(boardnum);
		log.debug("{}",b);
		m.addAttribute("read", b);
		log.debug("{}",b);
		
		return "board/read";
	}
	
	@GetMapping("deleteBoard")
	public String deleteBoard(@RequestParam(name="boardnum", defaultValue = "0") int boardnum
							, @AuthenticationPrincipal UserDetails user)
	{
		Board b = new Board();				//아무것도 안 든 새로운 보드를 생성
		b.setMemberid(user.getUsername());	//보드 안에 유저 아이디 넣음
		b.setBoardnum(boardnum);	//보드 안에 글 번호 넣음
		log.debug("{}",b);
		int i = service.deleteBoard(b);	
		if (i == 0)
		{
			log.debug("{삭제 실패}");
		}
		if (i == 1)
		{
			log.debug("{삭제 성공}");
		}
			return "redirect:/board/board";
			
	}
	
	@GetMapping("buyBoard")
	public String buyBoard(	@AuthenticationPrincipal UserDetails user
							, @RequestParam(name="boardnum", defaultValue = "0") int boardnum)
	{
		Board b = new Board();				//아무것도 안 든 새로운 보드를 생성
		b.setMemberid(user.getUsername());	//보드 안에 유저 아이디 넣음
		b.setBoardnum(boardnum);	//보드 안에 글 번호 넣음
		log.debug("{}",b);
		service.buyBoard(b);
		return "redirect:/board/board";
	}

	@GetMapping("search")
	public String search() {
		return "board/search";
	}
	
	@GetMapping("write")
	public String write(Model model,
			@AuthenticationPrincipal UserDetails user) {
		String id = user.getUsername();
		
		log.debug("id값 : {}",id);
		model.addAttribute("userid", id);
		return "board/write";
	}
	/**
	 * @author ChaJaeHeon
	 * @return ArrayList
	 * @Param selectboard
	 * 게시글 조회 기능 (개발중)
	 */
	
	/**
	 * 
	 * 20230727
	 * @author ChaJaeHeon
	 * @return void
	 * @param insertboard
	 * 게시글 작성 확인 필요 (로그인이랑 조회 완성후 확인)
	 */
	@ResponseBody
	@PostMapping("insertboard")
	public void insertboard(Board b, @AuthenticationPrincipal UserDetails user) {
		b.setMemberid(user.getUsername());
		service.insertboard(b);
	}
	
}	