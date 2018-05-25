package io.github.koryl.prolibrary.business.service;

import io.github.koryl.prolibrary.data.entity.User;
import io.github.koryl.prolibrary.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
