package com.example.springrestapi.services;

import com.example.springrestapi.modal.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    public static List<User> users= new ArrayList<>();
    private static int userCount = 3;
    static {
        users.add(new User(1,"Adam", new Date()));
        users.add(new User(2,"Tom", new Date()));
        users.add(new User(3,"Ornaldo", new Date()));

    }

    public static List<User> getUsers() {
        return users;
    }
    public User saveUser(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
users.add(user);
        return  user;
    }
    public User findUser(Integer id){
        for(User user:users){
            if(user.getId()== id){
                return  user;
            }

        }
        return null;
    }

    public User deleteUserById(Integer id){
        Iterator iterator = users.iterator();
        while (iterator.hasNext()){
            User user = (User) iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return  user;
            }
        }
        return null;
    }
}
