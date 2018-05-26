package io.github.koryl.prolibrary.web.application;

import io.github.koryl.prolibrary.data.entity.User;
import io.github.koryl.prolibrary.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library/account")
public class MyAccountController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String myAccount(Model model) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);

        model.addAttribute("user", user);
        return "my-account";
    }

}
