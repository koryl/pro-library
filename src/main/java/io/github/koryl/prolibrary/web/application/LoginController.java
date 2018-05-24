package io.github.koryl.prolibrary.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getHome() {
        return "login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
