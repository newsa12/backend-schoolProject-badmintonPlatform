package edu.yonsei.ws6.community_chat.board.service;

import edu.yonsei.ws6.community_chat.board.dto.BoardRequestDto;
import edu.yonsei.ws6.community_chat.board.dto.BoardResponseDto;
import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import edu.yonsei.ws6.community_chat.board.repository.BoardRepository;
import edu.yonsei.ws6.community_chat.board.service.BoardConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponseDto> getAllBoards() {
        return boardRepository.findAll().stream()
                .map(BoardConverter::toResponse)
                .toList();
    }

    public BoardResponseDto getBoardById(Long id) {
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));
        return BoardConverter.toResponse(board);
    }

    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        BoardEntity board = requestDto.toEntity();
        return BoardConverter.toResponse(boardRepository.save(board));
    }

    @Transactional
    public void deleteBoard(Long id) {
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));
        boardRepository.delete(board);
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto) {
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));
        board.updateName(requestDto.getName());
        return BoardConverter.toResponse(board);
    }
}

