package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.board.BoardForm;
import org.koreait.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardSaveTests {

    @Autowired
    private BoardSaveService saveService;


    private BoardForm getBoardForm() {
        BoardForm boardForm = new BoardForm();
        boardForm.setSubject("제목!");
        boardForm.setContent("내용!");

        return boardForm;
    }

    @Test
    @DisplayName("게시글 등록 성공시 예외 없음")
    void registerSuccessTest() {
        assertDoesNotThrow(() -> {
            BoardForm boardForm = getBoardForm();
            saveService.save(boardForm);
        });
    }
}
