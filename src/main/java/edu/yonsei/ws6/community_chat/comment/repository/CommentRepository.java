package edu.yonsei.ws6.community_chat.comment.repository;

import edu.yonsei.ws6.community_chat.comment.entity.CommentEntity;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByPostEntity(PostEntity postEntity);
    void deleteById(Long commentId);
}

