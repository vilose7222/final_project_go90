package com.ezen.go90;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.go90.domain.member.dto.Member;
import com.ezen.go90.domain.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void findMemberIdTest() {
		Member member = memberService.findMemberId("김기정", "bangry313@gmail.com");
	log.info("찾은 정보 : {}",member);	
	}
	
	
}







