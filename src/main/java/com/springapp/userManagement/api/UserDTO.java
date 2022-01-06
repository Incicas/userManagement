package com.springapp.userManagement.api;

public class UserDTO {

    private long id;
    private String email;
    private String password;

    public UserDTO(long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void setId(long newId){
        this.id = newId;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    public long getId(){
        return this.id;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }

}
