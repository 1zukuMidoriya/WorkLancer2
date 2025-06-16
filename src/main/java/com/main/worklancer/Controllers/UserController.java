package com.main.worklancer.Controllers;

import com.main.worklancer.Models.User;
import com.main.worklancer.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/Users")
    ResponseEntity<List<User>> GetAllUsers() {
    return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);

    };

    @PostMapping("/Users")
    ResponseEntity<User> postUser(@RequestBody User user) {
        User savedUser = userRepo.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
