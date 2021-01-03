package com.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
public class BoardVO {
    private int seq;

    private String title;

    private String writer;

    private String content;

    private Date regDate;
}
