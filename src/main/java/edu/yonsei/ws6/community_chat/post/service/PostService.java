package edu.yonsei.ws6.community_chat.post.service;

import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import edu.yonsei.ws6.community_chat.board.repository.BoardRepository;
import edu.yonsei.ws6.community_chat.post.service.PostConverter;
import edu.yonsei.ws6.community_chat.post.dto.PostRequestDto;
import edu.yonsei.ws6.community_chat.post.dto.PostResponseDto;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import edu.yonsei.ws6.community_chat.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final PostConverter postConverter;

    public List<PostResponseDto> getPostsByBoard(Long boardId) {
        BoardEntity board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));
        return postRepository.findByBoardEntity(board).stream()
                .map(PostConverter::toResponse)
                .toList();
    }

    public PostResponseDto getPostById(Long id) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return postConverter.toResponse(post);
    }

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        BoardEntity board = boardRepository.findById(requestDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("게시판이 존재하지 않습니다."));
        PostEntity post = requestDto.toEntity(board);
        return postConverter.toResponse(postRepository.save(post));
    }

    @Transactional
    public PostResponseDto updatePost(Long postId, PostRequestDto dto) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        post.update(dto.getTitle(), dto.getContent());
        return postConverter.toResponse(post);
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
