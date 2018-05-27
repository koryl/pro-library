package io.github.koryl.prolibrary.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibraryController {

    @GetMapping("/library")
    public String library() {

        return "library";
    }


    @GetMapping("/access-denied")
    public String accessDenied() {

        return "access-denied";
    }
}
