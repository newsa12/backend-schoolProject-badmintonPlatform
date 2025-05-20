package edu.yonsei.ws6.community_chat.board.service;

import edu.yonsei.ws6.community_chat.board.dto.BoardResponseDto;
import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import edu.yonsei.ws6.community_chat.post.dto.PostResponseDto;

import java.util.stream.Collectors;

public class BoardConverter {

    public static BoardResponseDto toResponse(BoardEntity entity) {
        return BoardResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .postList(entity.getPostList().stream()
                        .map(PostResponseDto::from)
                        .collect(Collectors.toList()))
                .build();
    }
}

