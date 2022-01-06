package com.springapp.userManagement.dao;


import com.springapp.userManagement.api.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRepository {


    public static final Map<Long, UserDTO> users = new HashMap<>();

    public UserRepository(){
        UserDTO user1 = new UserDTO(1, "incicas.beniamin@yahoo.com", "1234rtyui");
        UserDTO user2 = new UserDTO(2, "madalinalipoavanu@gmail.com", "mada12415315");
        UserDTO user3 = new UserDTO(3, "anagace@yahoo.com", "ana3214252");

        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);

    }

    public List<UserDTO> getAllUsers(){
        return new ArrayList<>(users.values());
    }
    public UserDTO getUserById(long id){
        UserDTO user = users.get(id);

        return user;
    }
    public UserDTO createUser(UserDTO userCreated){
        UserDTO user = users.put(userCreated.getId(), userCreated);
        return user;
    }

    public UserDTO updateUser(long id, UserDTO userUpdated){
        UserDTO user = users.put(id, userUpdated);
        return user;
    }

    public void deleteUser(long id){
        users.remove(id);
    }

}
