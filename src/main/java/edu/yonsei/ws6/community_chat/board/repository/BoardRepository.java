package edu.yonsei.ws6.community_chat.board.repository;

import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    Optional<BoardEntity> findByName(String name);
}
