package net.softsociety.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Member;

/**
 * 회원정보 관련 매퍼
 */

/**
 * 2023.07.27
 * @author 수정작성
 */
@Mapper
public interface MemberDAO
{
	//회원가입 정보 저장
	public void joinForm(Member m);
}
