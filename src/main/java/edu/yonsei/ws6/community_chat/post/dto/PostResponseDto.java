package edu.yonsei.ws6.community_chat.post.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostResponseDto {

    private Long postId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime writtenAt;

    public static PostResponseDto from(PostEntity entity) {
        return PostResponseDto.builder()
                .postId(entity.getPostId())
                .userId(entity.getUserId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writtenAt(entity.getWrittenAt())
                .build();
    }
}


