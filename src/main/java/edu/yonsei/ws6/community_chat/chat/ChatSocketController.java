package edu.yonsei.ws6.community_chat.chat;

import edu.yonsei.ws6.community_chat.chatmessage.dto.ChatMessagePayload;
import edu.yonsei.ws6.community_chat.chatroom.entity.ChatRoomEntity;
import edu.yonsei.ws6.community_chat.chatroom.repository.ChatRoomRepository;
import edu.yonsei.ws6.community_chat.chatmessage.entity.ChatMessageEntity;
import edu.yonsei.ws6.community_chat.chatmessage.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ChatSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat.send") // /app/chat.send
    public void sendMessage(ChatMessagePayload payload) {
        ChatRoomEntity room = chatRoomRepository.findById(payload.getRoomId())
                .orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다."));

        ChatMessageEntity saved = chatMessageRepository.save(ChatMessageEntity.builder()
                .chatRoom(room)
                .userId(payload.getUserId())
                .message(payload.getMessage())
                .sentAt(LocalDateTime.now())
                .build());

        messagingTemplate.convertAndSend("/topic/chat.room." + payload.getRoomId(), payload);
    }
}
