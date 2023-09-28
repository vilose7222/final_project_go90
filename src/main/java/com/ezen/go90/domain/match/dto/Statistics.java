package com.ezen.go90.domain.match.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 통계를 위해 만든 컴포넌트
 *
 * @author 윤동진
 * @since  2023. 9. 25.
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Statistics {
	private String memberId;
	private String matchDate;
	private int matchId;
	private int teamMatchScore;
	private int totalGoal;
	private int totalAssist;
	private int totalTackle;
	private int totalSave;
	private int totalMatchCount;
	private int playerMatchCount;
	
}
