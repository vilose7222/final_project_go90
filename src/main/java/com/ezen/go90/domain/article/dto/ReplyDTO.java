package com.ezen.go90.domain.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @Project : final_project_go90
 * @설명 : reply dto
 * @author 윤동진
 * @Date : 2023. 9. 8.
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReplyDTO {

	int replyId;
	String replyWriter;
	String replyRegdate;
	String replyContent;
	int orderNo;
	int levelNo;
	int articleId;
	
}
