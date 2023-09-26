package com.ezen.go90.domain.article.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @Project : final_project_go90
 * @설명 : 게시글 컴포넌트
 * @author 장원종
 * @Date : 2023. 9. 8.
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ArticleDTO {

	int articleId;
	int boardId;
	String memberId;
	String articleWriter;
	String articleRegdate;
	String articleContent;
	String articleTitle;
	String imagePath;
	int hitcount;
	List<ReplyDTO> replyList;
}
