package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    private List<UserModel> getAll(){

        return userService.getUsers();
    }
    @GetMapping("{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id) {
        return userService.getUser(id);

    }
    @PostMapping
    public void saveUpdate(@RequestBody UserModel user){
        UserModel UserModel;
        userService.saveOrUpdate(UserModel);
    }
    @DeleteMapping("/{id}")
    public void saveUpdate(@PathVariable("id") Long id ){
        userService.delete(id);
    }
}
