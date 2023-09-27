package com.codewitharjun.fullstackapp.controller;

import com.codewitharjun.fullstackapp.model.User;
import com.codewitharjun.fullstackapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/api/add")
    public User addUser(@RequestBody  User user){
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        System.out.println(user.getUsername());
        return userRepository.save(user);

    }
    @GetMapping("api/all")
    public List<User> allUsers(){
        return userRepository.findAll();
    }
}
