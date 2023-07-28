package net.softsociety.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

/**
 * 게시판 관련 매퍼
 */
@Mapper
public interface BoardDAO {

	void insertboard(Board b);

	/**
	 * 2023.07.27
	 * board.html에서 판매 정보를 띄우는 컨트롤러
	 * @author 수정
	 * @return ArrayList<Board>
	 */
	ArrayList<Board> boardlist(Board b);
}
