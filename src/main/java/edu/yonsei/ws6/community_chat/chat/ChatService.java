package edu.yonsei.ws6.community_chat.chat;

import edu.yonsei.ws6.community_chat.chatmessage.dto.ChatMessageRequestDto;
import edu.yonsei.ws6.community_chat.chatmessage.dto.ChatMessageResponseDto;
import edu.yonsei.ws6.community_chat.chatmessage.entity.ChatMessageEntity;
import edu.yonsei.ws6.community_chat.chatmessage.service.ChatMessageConverter;
import edu.yonsei.ws6.community_chat.chatroom.dto.ChatRoomRequestDto;
import edu.yonsei.ws6.community_chat.chatroom.dto.ChatRoomResponseDto;
import edu.yonsei.ws6.community_chat.chatroom.entity.ChatRoomEntity;
import edu.yonsei.ws6.community_chat.chatmessage.repository.ChatMessageRepository;
import edu.yonsei.ws6.community_chat.chatroom.repository.ChatRoomRepository;
import edu.yonsei.ws6.community_chat.chatroom.service.ChatRoomConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomConverter chatRoomConverter;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatMessageConverter chatMessageConverter;

    @Transactional
    public ChatMessageResponseDto sendMessage(ChatMessageRequestDto dto) {
        ChatRoomEntity chatRoom = chatRoomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다."));
        ChatMessageEntity message = chatMessageConverter.toEntity(dto, chatRoom);
        chatMessageRepository.save(message);
        return chatMessageConverter.toResponse(message);
    }

    @Transactional(readOnly = true)
    public List<ChatMessageResponseDto> getMessages(Long roomId) {
        ChatRoomEntity chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다."));
        return chatMessageRepository.findByChatRoomOrderBySentAtAsc(chatRoom)
                .stream()
                .map(chatMessageConverter::toResponse)
                .collect(Collectors.toList());
    }
    @Transactional
    public ChatRoomResponseDto createRoom(ChatRoomRequestDto dto) {
        ChatRoomEntity chatRoom = chatRoomConverter.toEntity(dto);
        chatRoomRepository.save(chatRoom);
        return chatRoomConverter.toResponse(chatRoom);
    }

}
