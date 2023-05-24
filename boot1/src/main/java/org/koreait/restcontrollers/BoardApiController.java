package org.koreait.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.koreait.models.board.Board;
import org.koreait.models.board.BoardDao;
import org.koreait.models.board.BoardListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardListService listService;
    private final BoardDao boardDao;

    @GetMapping("/list")
    public List<Board> list() {
        List<Board> items = listService.gets();

        return items;
    }

    @GetMapping("/view/{id}")
    public Board info(@PathVariable Long id) {
        Board board = boardDao.get(id);

        return board;
    }

    @GetMapping("/nobody")
    public void nobody() {

    }

    @GetMapping("/hello")
    public String hello() {

        return "안녕하세요!";
    }
}
