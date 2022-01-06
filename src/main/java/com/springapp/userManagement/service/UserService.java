package com.springapp.userManagement.service;

import com.springapp.userManagement.api.UserDTO;
import com.springapp.userManagement.dao.UserRepository;
import com.springapp.userManagement.exception.UserNotFoundException;
import com.springapp.userManagement.exception.WeakPasswordException;
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
        if (user == null){
            throw new UserNotFoundException("The user with id "+id+" can not be found .");
        }
        return user;
    }

    public boolean checkPassword(String password){
        if (password.length() < 8){
            return false;
        }
        boolean isDigit = false;
        boolean isLetter = false;

        for (int i=0; i<password.length();i++){
            if (Character.isDigit(password.charAt(i))){
                isDigit = true;
            }
            if (Character.isLetter(password.charAt(i))){
                isLetter = true;
            }
        }
        return isDigit && isLetter;
    }

    public UserDTO createUser(UserDTO userCreated){
        if (!checkPassword(userCreated.getPassword())){
            throw new WeakPasswordException("The password must be at least 8 characters and have digits and letters.");
        }
        UserDTO user = userRepository.createUser(userCreated);
        return user;
    }

    public UserDTO updateUser(long id, UserDTO userUpdated){
        UserDTO user = userRepository.getUserById(id);
        user.setEmail(userUpdated.getEmail());
        user.setId(userUpdated.getId());
        user.setPassword(userUpdated.getPassword());
        return userRepository.updateUser(id, user);
    }
    public UserDTO deleteUser(long id){
        UserDTO user = userRepository.getUserById(id);
        userRepository.deleteUser(user.getId());
        return user;
    }

}
