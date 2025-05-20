package edu.yonsei.ws6.community_chat.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.yonsei.ws6.community_chat.post.entity.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<PostEntity> postList = new ArrayList<>();

    public void updateName(String name) {
        this.name = name;
    }
}


