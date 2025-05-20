package edu.yonsei.ws6.community_chat.post.dto;

import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostRequestDto {

    @NotNull(message = "작성자 ID는 필수입니다.")
    private Long userId;

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    @NotNull(message = "게시판 ID는 필수입니다.")
    private Long boardId;

    public PostEntity toEntity(BoardEntity boardEntity) {
        return PostEntity.builder()
                .userId(this.userId)
                .title(this.title)
                .content(this.content)
                .boardEntity(boardEntity)
                .build();
    }
}
