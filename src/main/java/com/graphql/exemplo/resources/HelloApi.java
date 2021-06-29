package com.graphql.exemplo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class HelloApi {

    @GetMapping
    public String index() {
        return "Acesse /graphiql ou /playground para testar a API.";
    }

    @GetMapping("/hello")
    public String testHello() {
        return "Hello Working";
    }
}
