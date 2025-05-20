package edu.yonsei.ws6.community_chat.comment.dto;

import edu.yonsei.ws6.community_chat.comment.entity.CommentEntity;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CommentRequestDto {

    @NotNull(message = "작성자 ID는 필수입니다.")
    private Long userId;

    @NotBlank(message = "댓글 내용은 비워둘 수 없습니다.")
    private String content;

    @NotNull(message = "게시글 ID는 필수입니다.")
    private Long postId;

    public CommentEntity toEntity(PostEntity postEntity) {
        return CommentEntity.builder()
                .userId(this.userId)
                .content(this.content)
                .postEntity(postEntity)
                .build();
    }
}
