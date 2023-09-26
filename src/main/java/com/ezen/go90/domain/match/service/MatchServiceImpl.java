package com.ezen.go90.domain.match.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ezen.go90.domain.match.dto.Participant;
import com.ezen.go90.domain.match.dto.Statistics;
import com.ezen.go90.domain.match.mapper.MatchMapper;

import lombok.RequiredArgsConstructor;

/**
 * 
 * 참여 경기 통계를 위한 트랜잭션 처리 및 메서드 구현체
 *
 * @author 윤동진
 * @since  2023. 9. 21.
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class MatchServiceImpl implements MatchService {
	
	private final MatchMapper matchMapper;

	@Override
	public List<Participant> loadOnlyMatch() {
		
		List<Participant> list = matchMapper.loadMatchHistory();
		return list;
	}

	@Override
	public Map<String, List<Participant>> loadAllHistory(String memberId) {
		Map<String, List<Participant>> resultMap = new HashMap<>();
		
		List<Participant> playerStats = matchMapper.loadPlayerStat(memberId);
		
		  // 가져온 기록을 resultMap에 match_id를 key로 맵핑
	    for (Participant participant : playerStats) {
	        String matchId = String.valueOf(participant.getMatchId());
	        
	        // resultMap에서 match_id에 해당하는 리스트 가져오기
	        List<Participant> matchList = resultMap.getOrDefault(matchId, new ArrayList<>());
	        
	        //participant를 matchList에 추가
	        matchList.add(participant);
	        
	        // resultMap에 다시 맵핑
	        resultMap.put(matchId, matchList);
	    }
		
		return resultMap;
	}

	/** 경기 팀 총득점, 선수 경기별 스탯 */
	@Override
	public  List<Statistics> statistics(int matchId, String memberId) {
		List<Statistics> list = matchMapper.statisticsMatchAndMember(matchId,memberId);
	return list;
	}
	
	
	
	
}
