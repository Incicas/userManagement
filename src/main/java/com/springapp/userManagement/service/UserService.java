package com.springapp.userManagement.service;

import com.springapp.userManagement.api.UserDTO;
import com.springapp.userManagement.dao.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public UserDTO getUserById(long id){
        UserDTO user = userRepository.getUserById(id);
        return user;
    }

    public UserDTO createUser(UserDTO userCreated){
        UserDTO user = userRepository.createUser(userCreated);
        return user;
    }

    public UserDTO updateUser(long id, UserDTO userUpdated){
        UserDTO user = userRepository.updateUser(id, userUpdated);
        return user;
    }
    public void deleteUser(long id){
        userRepository.deleteUser(id);
    }

}
