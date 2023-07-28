package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;


@Transactional
@Slf4j
@Service
public class BoardSeviceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public void insertboard(Board b) {
		dao.insertboard(b);
	}

	/**
	 * 2023.07.27
	 * board.html에서 판매 정보를 띄우는 컨트롤러
	 * @author 수정
	 * @return ArrayList<Board>
	 */
	@Override
	public ArrayList<Board> boardlist(Board b) {
		ArrayList<Board> boardlist = dao.boardlist(b);
		return boardlist;
	}

}
