package edu.yonsei.ws6.community_chat.chatmessage.repository;

import edu.yonsei.ws6.community_chat.chatmessage.entity.ChatMessageEntity;
import edu.yonsei.ws6.community_chat.chatroom.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {
    List<ChatMessageEntity> findByChatRoomOrderBySentAtAsc(ChatRoomEntity chatRoom);
}
