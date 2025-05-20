package edu.yonsei.ws6.community_chat.chatroom.service;

import edu.yonsei.ws6.community_chat.chatroom.dto.ChatRoomRequestDto;
import edu.yonsei.ws6.community_chat.chatroom.dto.ChatRoomResponseDto;
import edu.yonsei.ws6.community_chat.chatroom.entity.ChatRoomEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ChatRoomConverter {

    public ChatRoomEntity toEntity(ChatRoomRequestDto dto) {
        return ChatRoomEntity.builder()
                .matchId(dto.getMatchId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public ChatRoomResponseDto toResponse(ChatRoomEntity entity) {
        return ChatRoomResponseDto.builder()
                .roomId(entity.getRoomId())
                .matchId(entity.getMatchId())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
