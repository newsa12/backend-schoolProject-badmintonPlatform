package edu.yonsei.ws6.community_chat.comment.entity;

import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "written_at")
    private LocalDateTime writtenAt;

    // 댓글 N : 1 게시글
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity postEntity;

    @PrePersist
    protected void onCreate() {
        this.writtenAt = LocalDateTime.now();
    }

    public void update(String content) {
        this.content = content;
        this.writtenAt = LocalDateTime.now();
    }
}
