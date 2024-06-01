package com.ishasingh.book_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getAllUser(){
        return userService.findall();
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }

}
