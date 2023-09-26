package com.ezen.go90.domain.vote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 경기 설문에 대한 DTO
 *
 * @author 윤동진
 * @since  2023. 9. 10.
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Vote {
	
	private int voteId;
	private String voteTitle;
	private String voteDate;
	private String voteContent;
	private String location;
	private String matchDate;
	
}
