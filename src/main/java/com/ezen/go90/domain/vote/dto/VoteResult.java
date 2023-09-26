package com.ezen.go90.domain.vote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 투표 결과 정보 DTO
 * 
 * @author 윤동진
 * @since  2023. 9. 18.
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class VoteResult {
	private int voteResultId;
	private String attend;
	private int voteId;
	private String memberId;
}
