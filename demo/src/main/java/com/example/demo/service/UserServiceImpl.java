package com.example.demo.service;

import com.example.demo.domain.UserVO;
import com.example.demo.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
