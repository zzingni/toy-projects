package com.study.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // @Entity 는 테이블을 의미함. 이 class 가 db에 있는 table 을 의미한다는 것.
@Data
public class Board { // 테이블이름과 일치시키는 것이 좋음.

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private String filename;

    private String filepath;

}
