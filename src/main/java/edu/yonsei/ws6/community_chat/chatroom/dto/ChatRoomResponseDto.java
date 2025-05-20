package edu.yonsei.ws6.community_chat.chatroom.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ChatRoomResponseDto {

    private Long roomId;
    private Long matchId;
    private LocalDateTime createdAt;
}
