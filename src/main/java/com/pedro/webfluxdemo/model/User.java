package com.pedro.webfluxdemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;

    private String username;

    private Integer age;
}
