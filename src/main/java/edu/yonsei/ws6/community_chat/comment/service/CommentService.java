package edu.yonsei.ws6.community_chat.comment.service;

import edu.yonsei.ws6.community_chat.comment.service.CommentConverter;
import edu.yonsei.ws6.community_chat.comment.dto.CommentRequestDto;
import edu.yonsei.ws6.community_chat.comment.dto.CommentResponseDto;
import edu.yonsei.ws6.community_chat.comment.entity.CommentEntity;
import edu.yonsei.ws6.community_chat.comment.repository.CommentRepository;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import edu.yonsei.ws6.community_chat.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentConverter commentConverter;

    public List<CommentResponseDto> getCommentsByPost(Long postId) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return commentRepository.findByPostEntity(post).stream()
                .map(CommentConverter::toResponse)
                .toList();
    }

    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        PostEntity post = postRepository.findById(requestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        CommentEntity comment = requestDto.toEntity(post);
        return commentConverter.toResponse(commentRepository.save(comment));
    }

    @Transactional
    public CommentResponseDto updateComment(Long commentId, CommentRequestDto dto) {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));
        comment.update(dto.getContent());
        return commentConverter.toResponse(comment);
    }

    @Transactional
    public void deleteComment(Long id) {
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        commentRepository.delete(comment);
    }
}
