package com.ezen.go90.domain.member.service;

import java.util.List;

import com.ezen.go90.domain.member.dto.Member;

/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리
 * 
 * @author 윤동진
 * @since  2023. 9. 18.
 * @version 1.0
 */
public interface MemberService {
	
	public void register(Member member);
	
	public Member isMember(String id, String passwd,String rank);
	
	public List<Member> getMemberList();
	
	public Member getMember(String id);
	
	public void editMember(Member member);
	
	public void secession(String memberId);

}
