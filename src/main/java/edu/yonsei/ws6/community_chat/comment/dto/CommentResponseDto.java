package edu.yonsei.ws6.community_chat.comment.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import edu.yonsei.ws6.community_chat.comment.entity.CommentEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentResponseDto {

    private Long commentId;
    private Long userId;
    private String content;
    private LocalDateTime writtenAt;

    public static CommentResponseDto from(CommentEntity entity) {
        return CommentResponseDto.builder()
                .commentId(entity.getCommentId())
                .userId(entity.getUserId())
                .content(entity.getContent())
                .writtenAt(entity.getWrittenAt())
                .build();
    }
}
