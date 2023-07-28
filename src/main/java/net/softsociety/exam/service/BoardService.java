package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

	public void insertboard(Board b);
	
	/**
	 * 2023.07.27
	 * board.html에서 판매 정보를 띄우는 컨트롤러
	 * @author 수정
	 * @return ArrayList<Board>
	 */
	public ArrayList<Board> boardlist(Board b);
	
	/**
	 * 2023.07.28
	 * board.html의 글제목을 클릭하면 내용을 읽는 컨트롤러
	 * @author 수정
	 * @return Board
	 */
	public Board read(int boardnum);

	/**
	 * 2023.07.27
	 * board.html의 글을 삭제하는 컨트롤러
	 * @param Board b
	 * @return int
	 */
	public int deleteBoard(Board b);

	public int buyBoard(Board b);
	
	


}
