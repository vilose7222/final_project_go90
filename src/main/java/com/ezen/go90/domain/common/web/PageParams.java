package com.ezen.go90.domain.common.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 페이지 계산에 필요한 정보들 포장
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class PageParams {
	
	private int elementSize;    /** 페이지에 보여지는 목록 갯수 */
	private int pageSize;       /** 페이지에 보여지는 페이지 갯수 */
	private int requestPage;    /** 사용자 요청 페이지 */
	private int rowCount;       /** 테이블 목록 갯수 */
	private int boardId;
	private String input;
	private String type;
	
	public PageParams() {
//		this(10, 10, 1, 0, 10, null, null);
	}
	

	
	
	
}
