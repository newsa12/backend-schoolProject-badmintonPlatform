package edu.yonsei.ws6.community_chat.chatmessage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessagePayload {

    private Long roomId;
    private Long userId;
    private String message;
}
