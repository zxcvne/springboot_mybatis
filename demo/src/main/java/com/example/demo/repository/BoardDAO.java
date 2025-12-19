package com.example.demo.repository;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardDAO {
    void insert(BoardVO boardVO);
    List<BoardVO> getList(PagingVO pagingVO);

    BoardVO getDetail(long bno);

    int getTotalCount(PagingVO pagingVO);

    void update(BoardVO boardVO);

    void delete(long bno);

    void readCountUpdate(@Param("bno") long bno, @Param("i") int i);
}
