package com.ezen.go90.domain.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.go90.domain.member.dto.Member;
import com.ezen.go90.domain.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체 
 *
 * @author 윤동진
 * @since  2023. 9. 18.
 * @version 1.0
 */
public class MemberServiceImpl implements MemberService{
	
	private final MemberMapper memberMapper;
	
	@Override
	@Transactional
//	@Transactional(propagation = Propagation.REQUIRED)
	public void register(Member member) {
		memberMapper.create(member);
	}

	@Override
	public Member isMember(String id, String passwd,String rank) {
		return memberMapper.findByIdAndPasswd(id, passwd,rank);
	}

	@Override
	public List<Member> getMemberList() {
		return memberMapper.findByAll();
	}

	@Override
	public Member getMember(String id) {
		return memberMapper.findById(id);
	}

	@Override
	@Transactional
	public void editMember(Member member) {
		memberMapper.update(member);
	}

	@Override
	public void secession(String memberId) {
		memberMapper.transfer(memberId);
		memberMapper.delete(memberId);
	}

	@Override
	public Member findMemberId(String name, String email) {
		return memberMapper.findMemberId(name, email);
	}
	
	

}
