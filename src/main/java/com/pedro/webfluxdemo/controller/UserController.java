package com.pedro.webfluxdemo.controller;

import com.pedro.webfluxdemo.model.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        User pedro = User.builder().id(1L).username("pedro").age(23).build();
        return Mono.just(pedro);
    }

    @GetMapping("")
    public Flux<User> getUsers() {
        User pedro = User.builder().id(1L).username("pedro").age(23).build();
        return Flux.just(pedro);
    }

    @DeleteMapping("/{id}")
    public Mono<User> deleteUser(@PathVariable Long id) {
        return Mono.empty();
    }

}
