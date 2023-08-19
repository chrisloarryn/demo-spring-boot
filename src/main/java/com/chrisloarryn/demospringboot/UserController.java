package com.chrisloarryn.demospringboot;

import com.chrisloarryn.demospringboot.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {



    @GetMapping("/users")
    List<User> getUsers() {
        return null;
    }
}
