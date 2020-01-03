package com.pedro.webfluxdemo.repositoriy;

import com.pedro.webfluxdemo.model.Article;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ArticleRepository extends ReactiveCrudRepository<Article, Long> {

    @Query("SELECT * FROM article WHERE fts @@ to_tsquery($1)")
    Flux<Article> searchByKeyword(String keyword);

    @Query(value = "SELECT id, title, content FROM article LIMIT $1 OFFSET $2")
    Flux<Article> getArticlePage(Long size, Long page);
}
