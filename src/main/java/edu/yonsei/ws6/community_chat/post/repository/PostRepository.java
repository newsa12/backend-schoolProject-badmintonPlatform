package edu.yonsei.ws6.community_chat.post.repository;

import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByBoardEntity(BoardEntity boardEntity);
    List<PostEntity> findByUserId(Long userId);
    void deleteById(Long postId);
}

