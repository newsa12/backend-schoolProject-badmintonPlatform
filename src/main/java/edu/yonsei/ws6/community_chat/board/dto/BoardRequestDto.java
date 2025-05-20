package edu.yonsei.ws6.community_chat.board.dto;

import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BoardRequestDto {

    @NotBlank(message = "게시판 이름은 필수입니다.")
    private String name;

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .name(this.name)
                .build();
    }
}
