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
<<<<<<< HEAD
	@PostMapping("insert")
	public String insertboard(Board b, @AuthenticationPrincipal UserDetails user) {
=======
	@PostMapping("insertboard")
	public void insertboard(Board b, @AuthenticationPrincipal UserDetails user) {
>>>>>>> aab9b893c12aa7a7054a1bf0f7175be9c8fe06d2
		b.setMemberid(user.getUsername());
		service.insertboard(b);
		return "redirect:/board/board";
	}
	
}	