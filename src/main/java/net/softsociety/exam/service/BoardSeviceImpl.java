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

}
