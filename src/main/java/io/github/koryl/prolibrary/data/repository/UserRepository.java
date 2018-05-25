package io.github.koryl.prolibrary.data.repository;

import io.github.koryl.prolibrary.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
