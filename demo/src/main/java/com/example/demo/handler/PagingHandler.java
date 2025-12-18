package com.example.demo.handler;

import com.example.demo.domain.PagingVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PagingHandler {
    private int qty; // 하단 페이지네이션 개수 (1 2 3 ... 10)
    private int startPage; // 페이지네이션 시작번호
    private int endPage; // 페이지네이션 끝번호
    private boolean prev, next; // 이전, 다음 여부

    private int totalCount; //전체 개시글 수(DB 조회 후 파라미터로 받기)
    private PagingVO pgvo; // 파라미터로 받기

    private int realEndPage; // 정말 마지막 페이지

    // 생성자에서 모든 값 계산
    public PagingHandler(int totalCount, PagingVO pgvo) {
        this.qty = 10;
        this.pgvo = pgvo;
        this.totalCount = totalCount;

        // 1~10 / 11~20 / 21~30
        // pageNo => 1 2 3... 10 => 10
        // pageNo => 11 12 13... 20 => 20
        // pageNo => 21 22 23... 30 => 30
        // pageNo 1,2,3,...10 까지는 endPage 변함없이 10

        // pageNo(1) / qty(10) => 0.1 결과를 올림 => 1 * qty(10) => 10
        // pageNo(11) / qty(10) => 1.1 결과를 올림 => 2 * qty(10) => 20
        // 정수 / 정수 = 정수 (한쪽 형변환 필수)
        // (int)Math.ceil(this.pgvo.getPageNo() / (double)this.qty)*this.qty
        this.endPage = (int)Math.ceil(this.pgvo.getPageNo() / (double)this.qty)*this.qty;
        this.startPage = this.endPage - (this.qty-1);

        // 실제 마지막 페이지
        // 전체 게시글 수 / 한페이지에 표시되는 게시글 수 (올림)
        // 2005 / 10 => 200.5 (올림) => 201
        this.realEndPage = (int)Math.ceil(this.totalCount / (double)this.pgvo.getQty());

        // 이전, 다음 여부
        this.prev = this.startPage > 1; // 1 11 21 31
        this.next = this.endPage < this.realEndPage;

        // 진짜 마지막 페이지가 endpage보다 작으면
        // 진짜 마지막 = 201 / endPage 210
        if(endPage > realEndPage) {
            this.endPage = realEndPage;
        }

    }
}
