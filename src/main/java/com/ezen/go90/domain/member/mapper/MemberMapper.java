package com.ezen.go90.domain.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ezen.go90.domain.member.dto.Member;
import com.ezen.go90.domain.member.dto.MemberSearchCondition;

@Mapper
/**
 * 
 * 회원 기능 관련 DB처리를 위한 메서드 명세
 *
 * @author 윤동진
 * @since  2023. 9. 18.
 * @version 1.0
 */
public interface MemberMapper {
	
	public List<Member> findByAll();
	
	public Member findById(String id);
	
	public Member findByIdAndPasswd(@Param("id") String id, @Param("passwd") String passwd,@Param("rank") String rank);
	
	public List<Member> findByNameLike(String name);
	
	public void create(Member member);
	
	public void update(Member member);
	
	// 검색 타입별 회원 검색
	public List<Member> findBySearchType(@Param("type") String type, @Param("value") String value);
	
	// 통합 검색
	public List<Member> findBySearchAll(String value);
	
	// 통합 검색
	public List<Member> findBySearchAllOption(MemberSearchCondition searchCondition);
	
	/** 탈퇴 회원 데이터 전송 */
	public void transfer(String memberId);
	
	/**회원 탈퇴*/
	public void delete(String memberId);
	
	/**
	 * 
	 * 이름과 이메일 입력으로 아이디 찾기
	 * @since 23.10.01
	 * @author 윤동진
	 * @param  name = 회원 이름 
	 * @param  email = 회원 이메일 주소 
	 * @return 회원 객체에 저장된 아이디 (이름과 이메일이 일치하는 정보)
	 */
	public Member findMemberId(@Param("name") String name, @Param("email") String email);

}







