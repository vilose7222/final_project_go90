package com.ezen.go90;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.go90.domain.match.dto.Participant;
import com.ezen.go90.domain.match.dto.Statistics;
import com.ezen.go90.domain.match.mapper.MatchMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 경기 관리 및 선수 스탯 DB연동 테스트
 *
 * @author 윤동진
 * @since  2023. 9. 20.
 * @version 1.0
 */
@SpringBootTest
@Slf4j
public class MatchMapperTest {
	@Autowired
	MatchMapper matchMapper;
	
	@Test
	@Disabled
	@Transactional
	public void loadPlayerStatTest() {
		Participant participant = Participant.builder()
				 .memberId("bangry313")
				 .build();
		List<Participant> list = matchMapper.loadPlayerStat(participant.getMemberId());
		for (Participant a : list) {
			log.info("player1의 총 스탯 :  {}",a);
		}
	}
	
	@Test
	@Disabled
	public void loadAllHistoryTest() {
		Participant participant = Participant.builder()
											 .memberId("bangry313")
											 .build();
		List<Participant> list = matchMapper.loadAllHistory(participant);
		for (Participant a : list) {
			log.info("제 1경기 스탯 : {}",a);
		}
	}
	
	@Test
	@Disabled
	public void loadMatchHistoryTest() {
	List<Participant> list = matchMapper.loadMatchHistory(); 
	for (Participant a : list) {
		log.info("경기정보 : {}",a);
	}
	}
	
	
	
	@Test
	public void statisticsMatchAndMemberTest(){
		List<Statistics> list = matchMapper.statisticsMatchAndMember(2, "player11");
		log.info("2번경기 총 득점과 2번경기 선수 스탯 : {}",list);
	}
	
}
