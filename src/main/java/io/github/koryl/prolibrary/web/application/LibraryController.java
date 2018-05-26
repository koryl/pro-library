package io.github.koryl.prolibrary.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @GetMapping
    public String library() {

        return "library";
    }


    @GetMapping("/error/access-denied")
    public String accessDenied() {

        return "access-denied";
    }
}
