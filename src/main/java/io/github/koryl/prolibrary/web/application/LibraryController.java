package io.github.koryl.prolibrary.web.application;

import io.github.koryl.prolibrary.data.entity.User;
import io.github.koryl.prolibrary.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    @Autowired
    private UserRepository userService;

    @GetMapping({"/library", "/"})
    public String library(Model model) {

        model.addAttribute("user", getLoggedUser());
        return "library";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {

        return "access-denied";
    }

    private User getLoggedUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByEmail(auth.getName());
    }
}
