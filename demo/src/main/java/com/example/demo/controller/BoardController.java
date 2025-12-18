package com.example.demo.controller;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.handler.PagingHandler;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
        boardService.insert(boardVO);
        return "redirect:/board/list";
    }
    @GetMapping("/list")
    public void list(Model model, PagingVO pagingVO) {
        List<BoardVO> list = boardService.getList(pagingVO);
        int totalCount = boardService.getTotalCount(pagingVO);
        PagingHandler ph = new PagingHandler(totalCount, pagingVO); // 검색어를 포함 (전체 페이지 개수)
        model.addAttribute("list", list);
        model.addAttribute("ph", ph);
    }

    @GetMapping("/detail")
    public void detail(Model model, @RequestParam("bno") long bno) {
        BoardVO boardVO = boardService.getDetail(bno);
        model.addAttribute("board", boardVO);
    }
    @PostMapping("/modify")
    public String modify(BoardVO boardVO, RedirectAttributes redirectAttributes){
        boardService.update(boardVO);
        redirectAttributes.addAttribute("bno",boardVO.getBno());
        return "redirect:/board/detail";
    }

//    @PostMapping("/delete")
//    public String delete(@RequestParam("bno") long bno) {
//        boardService.delete(bno);
//        return "redirect:/board/list";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bno") long bno) {
        boardService.delete(bno);
        return "redirect:/board/list";
    }


}
