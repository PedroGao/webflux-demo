package com.pedro.webfluxdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Article {

    @Id
    private Long id;

    private String title;

    private String content;
}
