package edu.yonsei.ws6.community_chat.chatmessage.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ChatMessageResponseDto {

    private Long messageId;
    private Long roomId;
    private Long userId;
    private String message;
    private LocalDateTime sentAt;
}
