package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PagingVO {

    private int pageNo; // 현재 페이지번호 (선택한 하단 페이지네이션의 번호)
    private int qty; // 한페이지에 출력할 게시글 수

    private String type;
    private String keyword;

    public PagingVO() {
        // 페이지 값이 들어오지 않으면
        this.pageNo = 1;
        this.qty = 10;
    }

    public int getPageStart() {
        return (this.pageNo - 1) * this.qty;
    }

    public String[] getTypeToArray() {
        return this.type == null ? new String[]{} : this.type.split("");
    }
}
