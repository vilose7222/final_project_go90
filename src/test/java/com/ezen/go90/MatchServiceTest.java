package com.ezen.go90;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.go90.domain.match.dto.Participant;
import com.ezen.go90.domain.match.dto.Statistics;
import com.ezen.go90.domain.match.service.MatchService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 서비스 클래스
 *
 * @author 윤동진
 * @since  2023. 9. 21.
 * @version 1.0
 */
@SpringBootTest
@Slf4j
public class MatchServiceTest {
	@Autowired
	private MatchService matchService;
	
	
	@Test
	@Transactional
	@Disabled
	public void loadAllHistoryTest() { 
		String memberId = "bangry313";
	Map<String, List<Participant>> resultMap = matchService.loadAllHistory(memberId);
	log.info(" 방그리 경기 데이터 모음 :{}", resultMap);
	log.info(" 방그리가 참여한 경기 :{}", resultMap.keySet());
	}
	
	@Test
	@Transactional
	public void statiscticsTest() {
		List<Statistics> list = matchService.statistics(2, "player11");
		
		log.info("2번경기 팀 총득점, 선수 총득점 : {}",list);
	}
}
