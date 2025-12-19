package com.example.demo.repository;

import com.example.demo.domain.AuthVO;
import com.example.demo.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    void insert(UserVO userVO);

    void insertAuth(String email);

    UserVO getUser(String username);

    List<AuthVO> getUserAuth(String username);

    void modifyNoPwd(UserVO userVO);

    void modify(UserVO userVO);

    void delete(String email);

    void authDelete(String email);

    List<UserVO> getList();
}
