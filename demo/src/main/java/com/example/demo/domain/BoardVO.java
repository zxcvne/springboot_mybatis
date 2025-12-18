package com.example.demo.domain;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {

//            +------------+--------------+------+-----+-------------------+-------------------+
//            | Field      | Type         | Null | Key | Default           | Extra             |
//            +------------+--------------+------+-----+-------------------+-------------------+
//            | bno        | bigint       | NO   | PRI | NULL              | auto_increment    |
//            | title      | varchar(200) | NO   |     | NULL              |                   |
//            | writer     | varchar(200) | NO   |     | NULL              |                   |
//            | content    | text         | YES  |     | NULL              |                   |
//            | is_del     | varchar(5)   | YES  |     | N                 |                   |
//            | reg_date   | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
//            | read_count | int          | YES  |     | 0                 |                   |
//            | cmt_qty    | int          | YES  |     | 0                 |                   |
//            | file_qty   | int          | YES  |     | 0                 |                   |
//            +------------+--------------+------+-----+-------------------+-------------------+

    private long bno;
    private String title;
    private String writer;
    private String content;
    private String isDel;
    private String regDate;
    private int readCount;
    private int cmtQty;
    private int fileQty;
}
