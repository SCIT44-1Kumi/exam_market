package net.softsociety.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.service.MemberService;

/**
 * 회원 정보 관련 콘트롤러
 */

/**
 * 2023.07.27
 * @author 수정작성
 */

@Slf4j
@RequestMapping("member")
@Controller
public class MemberController
{
	@Autowired
	MemberService service;
	
	@GetMapping("join")
	public String join()
	{
		return "joinForm";
	}
	
	//회원가입 정보 저장
	@PostMapping("joinForm")
	public String joinForm(Member m)
	{
		log.debug("{}",m);
		service.joinForm(m);
		return "home";
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public String login()
	{
		return "loginForm";
	}


}
