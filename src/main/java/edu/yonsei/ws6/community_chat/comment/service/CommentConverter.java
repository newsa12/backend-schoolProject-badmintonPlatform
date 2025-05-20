package edu.yonsei.ws6.community_chat.comment.service;

import edu.yonsei.ws6.community_chat.comment.dto.CommentResponseDto;
import edu.yonsei.ws6.community_chat.comment.entity.CommentEntity;
import org.springframework.stereotype.Component;


@Component
public class CommentConverter {

    public static CommentResponseDto toResponse(CommentEntity entity) {
        return CommentResponseDto.builder()
                .commentId(entity.getCommentId())
                .userId(entity.getUserId())
                .content(entity.getContent())
                .writtenAt(entity.getWrittenAt())
                .build();
    }
}
