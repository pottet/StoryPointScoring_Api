package com.turksat.StoryPointScoring.controllers;

import com.turksat.StoryPointScoring.entitys.User;
import com.turksat.StoryPointScoring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping
    public List<User> getStudents(){
        return userService.getUsers();
    }

    @PostMapping
    public void RegisterStudent(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void DeleteStudent(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void UpdateStudent(
            @PathVariable("userId") Integer userId,
            @RequestParam(required = false) String name){
        userService.updateUser(userId,name);
    }


}
