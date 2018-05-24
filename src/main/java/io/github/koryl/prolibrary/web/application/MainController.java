package io.github.koryl.prolibrary.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class MainController {

    @GetMapping
    public String library() {

        return "library";
    }

    @GetMapping("/account")
    public String myAccount() {

        return "my-account";
    }

    @GetMapping("/error/access-denied")
    public String accessDenied() {

        return "my-account";
    }
}
