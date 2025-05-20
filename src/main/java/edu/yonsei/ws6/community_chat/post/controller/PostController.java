package edu.yonsei.ws6.community_chat.post.controller;

import edu.yonsei.ws6.community_chat.post.dto.PostRequestDto;
import edu.yonsei.ws6.community_chat.post.dto.PostResponseDto;
import edu.yonsei.ws6.community_chat.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<PostResponseDto>> getPostsByBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(postService.getPostsByBoard(boardId));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody @Valid PostRequestDto requestDto) {
        return ResponseEntity.ok(postService.createPost(requestDto));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable Long postId,
            @RequestBody PostRequestDto requestDto
    ) {
        return ResponseEntity.ok(postService.updatePost(postId, requestDto));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
