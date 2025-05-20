package edu.yonsei.ws6.community_chat.chatroom.repository;

import edu.yonsei.ws6.community_chat.chatroom.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
    //필요 시 matchid 확장 가능
}
