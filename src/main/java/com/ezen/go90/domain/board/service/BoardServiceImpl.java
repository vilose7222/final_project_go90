package com.ezen.go90.domain.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.go90.domain.board.dto.BoardDTO;
import com.ezen.go90.domain.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

   private final BoardMapper boardMapper;
   
   @Override
   @Transactional
   public List<BoardDTO> load() {
      return boardMapper.findAll();
   }
   
   @Override
   public List<BoardDTO> searchByBoardId(int boardId) {
      List<BoardDTO> list = boardMapper.findByBoardId(boardId);
      return list;
   }


}

