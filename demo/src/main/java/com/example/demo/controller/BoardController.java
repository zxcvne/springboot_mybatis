package com.example.demo.controller;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public String register(BoardVO boardVO){
        int isOk = boardService.insert(boardVO);
        log.info(">>> insert >> {}", (isOk > 0)? "ok" : "fail");

        return "index";
    }
}
