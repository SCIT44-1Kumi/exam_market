package net.softsociety.exam.service;

import net.softsociety.exam.domain.Member;

/** 
 * 회원정보 관련 서비스
 */

/**
 * 2023.07.27
 * @author 수정작성
 */
public interface MemberService
{
	//회원가입 정보 저장
	public void joinForm(Member m);
}
