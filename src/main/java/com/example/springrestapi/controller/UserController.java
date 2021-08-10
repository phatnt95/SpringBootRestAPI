package com.example.springrestapi.controller;

import com.example.springrestapi.model.User;
import com.example.springrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getUsers(){
//        List<User> users = userService.getAll();
        Iterable<User> iterableUser = userService.getAll();
        return ResponseEntity.ok(iterableUser);
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "name", required = false, defaultValue = "") String name){
        List<User> users = userService.search(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUsers(@PathVariable long id){
//        User users = userService.getByID(id);
        Optional<User> optionalUser = userService.getByID(id);
        return ResponseEntity.ok(optionalUser);
    }
}
