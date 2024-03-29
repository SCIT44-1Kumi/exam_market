package net.softsociety.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.dao.MemberDAO;
import net.softsociety.exam.domain.Member;

/**
 * 2023.07.27
 * @author 수정작성
 */

@Slf4j
@Service
public class MemberSeviceImpl implements MemberService
{
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//회원가입 정보 저장
	@Override
	public void joinForm(Member m)
	{
		String pw = passwordEncoder.encode(m.getMemberpw());
		
		log.debug("암호화 전 : {}", m.getMemberpw());
		log.debug("암호화 후 : {}", pw);
		
		m.setMemberpw(pw);
		dao.joinForm(m);
	}

   

}
