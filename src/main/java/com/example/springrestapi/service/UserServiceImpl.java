package com.example.springrestapi.service;

import com.example.springrestapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceImpl {
    Iterable<User> getAll();
    List<User> search(String name);
    Optional<User> getByID(long id);
    void save(User user, boolean isDelete);
}
