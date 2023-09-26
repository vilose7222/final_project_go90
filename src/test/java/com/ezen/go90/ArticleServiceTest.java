package com.ezen.go90;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.go90.domain.article.dto.ArticleDTO;
import com.ezen.go90.domain.article.service.ArticleService;

@SpringBootTest
public class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;
	
	
	@Test
	@Transactional
	public void removeArticleTest() {
		ArticleDTO articleDTO = ArticleDTO.builder().articleId(21).build();
		int articleId = articleDTO.getArticleId();
		articleService.deleteArticle(articleId);
	
		
	}
	
	
	
}
