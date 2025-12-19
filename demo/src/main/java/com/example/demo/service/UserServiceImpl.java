package com.example.demo.service;

import com.example.demo.domain.UserVO;
import com.example.demo.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Transactional
    @Override
    public void insert(UserVO userVO) {
        userDAO.insert(userVO);
        userDAO.insertAuth(userVO.getEmail());
    }

    @Override
    public void modifyNoPwd(UserVO userVO) {
        userDAO.modifyNoPwd(userVO);
    }

    @Override
    public void modify(UserVO userVO) {
        userDAO.modify(userVO);
    }

    @Transactional
    @Override
    public void delete(String email) {
        userDAO.authDelete(email);
        userDAO.delete(email);

    }

    @Override
    public List<UserVO> getList() {
        List<UserVO> list = userDAO.getList();
        for(UserVO userVO : list){
            userVO.setAuthList(userDAO.getUserAuth(userVO.getEmail()));
        }
        return list;
    }


}
