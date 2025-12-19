package com.example.demo.service;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;

import java.util.List;

public interface BoardService {


    void insert(BoardVO boardVO);

    List<BoardVO> getList(PagingVO pagingVO);

    BoardVO getDetail(long bno);

    int getTotalCount(PagingVO pagingVO);

    void update(BoardVO boardVO);

    void delete(long bno);
}
