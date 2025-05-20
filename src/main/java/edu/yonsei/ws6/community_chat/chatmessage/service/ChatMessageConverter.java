package edu.yonsei.ws6.community_chat.chatmessage.service;

import edu.yonsei.ws6.community_chat.chatmessage.dto.ChatMessageRequestDto;
import edu.yonsei.ws6.community_chat.chatmessage.dto.ChatMessageResponseDto;
import edu.yonsei.ws6.community_chat.chatmessage.entity.ChatMessageEntity;
import edu.yonsei.ws6.community_chat.chatroom.entity.ChatRoomEntity;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageConverter {

    public ChatMessageEntity toEntity(ChatMessageRequestDto dto, ChatRoomEntity chatRoomEntity) {
        return ChatMessageEntity.builder()
                .chatRoom(chatRoomEntity)
                .userId(dto.getUserId())
                .message(dto.getMessage())
                .build();
    }

    public ChatMessageResponseDto toResponse(ChatMessageEntity entity) {
        return ChatMessageResponseDto.builder()
                .messageId(entity.getMessageId())
                .roomId(entity.getChatRoom().getRoomId())
                .userId(entity.getUserId())
                .message(entity.getMessage())
                .sentAt(entity.getSentAt())
                .build();
    }
}
