package com.example.demo.controller;


import com.example.demo.domain.UserVO;
import com.example.demo.service.BoardService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@RequiredArgsConstructor
@RequestMapping("/user/*")
@Slf4j
@Controller
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public void signup(){}

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/signup")
    public String signup(UserVO userVO){
        userVO.setPwd(passwordEncoder.encode(userVO.getPwd()));
        userService.insert(userVO);

        return "redirect:/";
    }

    @GetMapping("/modify")
    public void modify(){

    }
    @PostMapping("/modify")
    public String modify(UserVO userVO) {
        if(userVO.getPwd().isEmpty() || userVO.getPwd() == null){
            userService.modifyNoPwd(userVO);
        }else {
            userVO.setPwd(passwordEncoder.encode((userVO.getPwd())));
            userService.modify(userVO);
        }
        return "redirect:/user/logout";
    }

    @GetMapping("/remove")
    public String remove(Principal principal){
        String email = principal.getName(); // username
        userService.delete(email);
        return "redirect:/user/logout";
    }

    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("list", userService.getList());
    }

}
