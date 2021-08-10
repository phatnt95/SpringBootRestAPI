package com.example.springrestapi.service;

import com.example.springrestapi.exception.NotFoundException;
import com.example.springrestapi.model.User;
import com.example.springrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceImpl{
    @Autowired
    private UserRepository userRepository;
    private static List<User> userList = new ArrayList<User>();
//    static {
//        userList.add(new User(1,"Robert"));
//        userList.add(new User(2,"John"));
//        userList.add(new User(3,"Jackson"));
//        userList.add(new User(4,"Jenifer"));
//        userList.add(new User(5,"Andy"));
//    }
    @Override
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }
    @Override
    public List<User> search(String name) {
        List<User> listRes = new ArrayList<>();
        for (User u : userList){
            if(u.getName().contains(name)){
                listRes.add(u);
            }
        }
        return listRes;
    }

    @Override
    public Optional<User> getByID(long id) {
//        for (User user : userList){
//            if(user.getId()==id){
//                return user;
//            }
//        }
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser;
//        throw new NotFoundException("User not found!");
    }

    @Override
    public void save(User user, boolean isDelete){
        if (isDelete) {
            user.setStatus(0);
        }
        userRepository.save(user);
    }
}
