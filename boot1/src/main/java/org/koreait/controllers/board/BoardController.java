package org.koreait.controllers.board;

import jakarta.validation.Valid;
import org.koreait.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardSaveService saveService;

    @GetMapping("/write")
    public String write(@ModelAttribute BoardForm boardForm) {

        return "board/write";
    }

    @PostMapping("/save")
    public String save(@Valid BoardForm boardForm, Errors errors) {
        if (errors.hasErrors()) {
            return "board/write";
        }

        // 저장 처리
        saveService.save(boardForm);

        return "redirect:/board/list"; // 작성 완료 후 목록으로 이동
    }
}
