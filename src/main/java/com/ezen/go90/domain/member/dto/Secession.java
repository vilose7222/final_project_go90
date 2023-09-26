package com.ezen.go90.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
/**
 *탈퇴 회원 관리 위한 DTO
 *
 * @author 윤동진
 * @since  2023. 9. 18.
 * @version 1.0
 */
public class Secession {
	private int secessionId;
	private String memberId;
	private String secessionName;
	private String secessionNumber;
	private String secessionBirth;
	private String secessionDate;
}





