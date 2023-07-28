package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {


	public int insertboard(Board b);

	/**
	 * 2023.07.27
	 * board.html에서 판매 정보를 띄우는 컨트롤러
	 * @author 수정
	 * @return ArrayList<Board>
	 */
	public ArrayList<Board> boardlist(Board b);


}
