package io.github.koryl.prolibrary.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class MainController {

    @GetMapping
    public String getLibrary() {

        return "library";
    }

    @GetMapping("/books")
    public String getBooks() {

        return "books";
    }

    @GetMapping("/account")
    public String getMyAccount() {

        return "my-account";
    }
}
