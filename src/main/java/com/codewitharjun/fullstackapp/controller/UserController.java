package com.codewitharjun.fullstackapp.controller;

import com.codewitharjun.fullstackapp.exceptions.UserNotFoundException;
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

    @GetMapping("api/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("api/update/{id}")
    public User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setName(newUser.getName());
                    user.setUsername(newUser.getUsername());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }
    @DeleteMapping("api/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id of "+id+" deleted!!!";
    }
}
