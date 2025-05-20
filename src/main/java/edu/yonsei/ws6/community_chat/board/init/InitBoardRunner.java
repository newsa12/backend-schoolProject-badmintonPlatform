package edu.yonsei.ws6.community_chat.board.init;

import edu.yonsei.ws6.community_chat.board.entity.BoardEntity;
import edu.yonsei.ws6.community_chat.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitBoardRunner implements CommandLineRunner {

    private final BoardRepository boardRepository;

    @Override
    public void run(String... args) {
        createBoardIfNotExists("공지사항");
        createBoardIfNotExists("문의하기");
        createBoardIfNotExists("이용안내");
    }

    private void createBoardIfNotExists(String name) {
        if (boardRepository.findByName(name).isEmpty()) {
            boardRepository.save(BoardEntity.builder().name(name).build());
            System.out.println( name + "게시판이 생성되었습니다.");
        } else {
            System.out.println( name + "게시판은 이미 존재합니다.");
        }
    }
}
