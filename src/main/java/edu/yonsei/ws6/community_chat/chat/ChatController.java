package edu.yonsei.ws6.community_chat.chat;

import edu.yonsei.ws6.community_chat.chatmessage.dto.ChatMessageRequestDto;
import edu.yonsei.ws6.community_chat.chatmessage.dto.ChatMessageResponseDto;
import edu.yonsei.ws6.community_chat.chat.ChatService;
import edu.yonsei.ws6.community_chat.chatroom.dto.ChatRoomRequestDto;
import edu.yonsei.ws6.community_chat.chatroom.dto.ChatRoomResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    // 메시지 전송
    @PostMapping
    public ResponseEntity<ChatMessageResponseDto> sendMessage(@RequestBody @Valid ChatMessageRequestDto dto) {
        return ResponseEntity.ok(chatService.sendMessage(dto));
    }

    // 채팅방 내 모든 메시지 조회
    @GetMapping("/{roomId}")
    public ResponseEntity<List<ChatMessageResponseDto>> getMessages(@PathVariable Long roomId) {
        return ResponseEntity.ok(chatService.getMessages(roomId));
    }

    @PostMapping("/rooms")
    public ResponseEntity<ChatRoomResponseDto> createRoom(@RequestBody ChatRoomRequestDto dto) {
        return ResponseEntity.ok(chatService.createRoom(dto));
    }

}
