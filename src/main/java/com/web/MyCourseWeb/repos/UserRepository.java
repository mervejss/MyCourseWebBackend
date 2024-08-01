package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserMail(String userMail);




}
