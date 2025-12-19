package com.example.demo.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthVO {
    private long id;
    private String email;
    private String auth;
}
