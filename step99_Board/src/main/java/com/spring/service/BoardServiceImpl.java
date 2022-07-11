package com.spring.service;

import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.dto.BoardDTO;

import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.entity.Board;
import com.spring.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository boardRepo;
	
	@Transactional
	@Override
	public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO){
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("boardNo").descending());
		Page<Board> result = boardRepo.findAll(pageable);
		Function<Board, BoardDTO> function = (boardEntity -> boardEntity.toDTO(boardEntity));

		return new PageResultDTO<BoardDTO, Board>(result, function);
	};

	@Transactional
	@Override
	public Board getBoardByBoardNo(Long boardNo) {
		return boardRepo.findBoardByBoardNo(boardNo);
	};
	
	@Transactional
	@Override
	public void insertBoard(BoardDTO boardDTO) {
		Board boardEntity = boardDTO.toEntity(boardDTO);
		
		boardRepo.save(boardEntity);
	};
	
	@Transactional
	@Override
	public void updateBoard(BoardDTO boardDTO) {
		Board board = getBoardByBoardNo(boardDTO.getBoardNo());
		board.updateBoardTitleAndContent(boardDTO);
		
		boardRepo.save(board);
		
	};
	
	@Transactional
	@Override
	public void deleteBoardByBoardNo(Long boardNo) {
		boardRepo.deleteBoardByBoardNo(boardNo);
	};
	
}
