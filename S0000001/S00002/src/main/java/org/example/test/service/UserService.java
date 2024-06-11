package org.example.test.service;

import lombok.Data;
import org.example.test.model.User;

@Data
public class UserService {
    private User[] users;
    public void userService(int size){
        users = new User[size];
        users[0]= new User("12345","12345");
    }
}
