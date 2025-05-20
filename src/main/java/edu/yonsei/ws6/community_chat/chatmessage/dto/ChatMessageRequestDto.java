package edu.yonsei.ws6.community_chat.chatmessage.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageRequestDto {

    @NotNull(message = "채팅방 ID는 필수입니다.")
    private Long roomId;

    @NotNull(message = "작성자 ID는 필수입니다.")
    private Long userId;

    @NotNull(message = "메시지 내용은 비워둘 수 없습니다.")
    private String message;
}
