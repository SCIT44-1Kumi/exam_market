package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

<<<<<<< HEAD
	public int insertboard(Board b);
=======
	public void insertboard(Board b);
	
	/**
	 * 2023.07.27
	 * board.html에서 판매 정보를 띄우는 컨트롤러
	 * @author 수정
	 * @return ArrayList<Board>
	 */
	public ArrayList<Board> boardlist(Board b);
>>>>>>> aab9b893c12aa7a7054a1bf0f7175be9c8fe06d2


}
