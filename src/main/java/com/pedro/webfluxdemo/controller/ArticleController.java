package com.pedro.webfluxdemo.controller;

import com.pedro.webfluxdemo.model.Article;
import com.pedro.webfluxdemo.repositoriy.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/{id}")
    public Mono<Article> getArticle(@PathVariable @Positive Long id) {
        Mono<Article> articleMono = articleRepository.findById(id);
        return articleMono;
    }

    @GetMapping("")
    public Flux<Article> searchArticle(@RequestParam(value = "keyword", required = false) String keyword) {
        Flux<Article> articleFlux = articleRepository.searchByKeyword(keyword);
        return articleFlux;
    }

    @GetMapping("/page")
    public Flux<Article> getArticlePage(@RequestParam(required = false, defaultValue = "0") @PositiveOrZero Long page,
                                        @RequestParam(required = false, defaultValue = "10") @PositiveOrZero Long size) {
        Flux<Article> articleFlux = articleRepository.getArticlePage(size, page);
        return articleFlux;
    }

}
