package com.example.demo.service;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;

    @Override
    public void insert(BoardVO boardVO) {
        boardDAO.insert(boardVO);
    }

    @Override
    public List<BoardVO> getList(PagingVO pagingVO) {
        return boardDAO.getList(pagingVO);
    }

    @Override
    public BoardVO getDetail(long bno) {
        return boardDAO.getDetail(bno);
    }

    @Override
    public int getTotalCount(PagingVO pagingVO) {
        return boardDAO.getTotalCount(pagingVO);
    }


}
