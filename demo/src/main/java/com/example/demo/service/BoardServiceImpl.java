package com.example.demo.service;

import com.example.demo.domain.BoardVO;
import com.example.demo.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;

    @Override
    public int insert(BoardVO boardVO) {
        return boardDAO.insert(boardVO);
    }
}
