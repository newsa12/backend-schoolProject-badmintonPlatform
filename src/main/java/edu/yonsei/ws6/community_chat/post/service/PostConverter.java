package edu.yonsei.ws6.community_chat.post.service;

import edu.yonsei.ws6.community_chat.post.dto.PostResponseDto;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public static PostResponseDto toResponse(PostEntity entity) {
        return PostResponseDto.builder()
                .postId(entity.getPostId())
                .userId(entity.getUserId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writtenAt(entity.getWrittenAt())
                .build();
    }
}