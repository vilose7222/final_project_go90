package com.ezen.go90.domain.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.go90.domain.board.dto.BoardDTO;

/**
 * board 테이블 관련 명세
 * member 했던것처럼 
 */
@Mapper
public interface BoardMapper {
	
	/** 신규 게시판 생성 */
	public void create(BoardDTO board);
	
	/** 전체 게시판 목록 반환 */
	public List<BoardDTO> findAll();
	
	/** 게시판 번호로 해당하는 게시판 반환*/
	public List<BoardDTO> findByBoardId(int boardId);
 	/**삭제*/
}
