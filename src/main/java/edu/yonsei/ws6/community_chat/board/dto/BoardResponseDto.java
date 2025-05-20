package edu.yonsei.ws6.community_chat.board.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import edu.yonsei.ws6.community_chat.post.dto.PostResponseDto;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardResponseDto {

    private Long id;
    private String name;
    private List<PostResponseDto> postList;

    public static BoardResponseDto from(BoardEntity entity) {
        return BoardResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .postList(
                        entity.getPostList().stream()
                                .map(PostResponseDto::from)
                                .collect(Collectors.toList())
                )
                .build();
    }
}