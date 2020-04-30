package br.com.douglasramiro.sorteador.controller;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/",
        produces = MediaType.TEXT_PLAIN_VALUE)
public class IndexController {

    @GetMapping
    public LocalDateTime index(){
        return LocalDateTime.now();
    }
}
