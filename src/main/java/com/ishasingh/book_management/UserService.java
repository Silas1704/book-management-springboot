package com.ishasingh.book_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findall(){
        return userRepository.findAll();
    }
    public User save(User user){
        return userRepository.save(user);
    }

}
