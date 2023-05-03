package com.example.demo.service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<UserModel> getUsers(){
        return UserRepository.findAll();
    }
    public Optional<UserModel> getUser(Long id){
        return UserRepository.findById(id);
    }

    public void saveOrUpdate(UserModel userModel){
        userRepository.save(userModel);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
