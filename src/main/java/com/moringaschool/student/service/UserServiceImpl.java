package com.moringaschool.student.service;

import com.moringaschool.student.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserServiceImpl implements UserService{
    public static Map<Object, Object> users = new HashMap<>();
    private static final AtomicInteger count = new AtomicInteger(0);

    @Override
    public User addUser(User user) {
        int currentId =count.incrementAndGet();
        User newUser = new User(currentId,user.getFirstName(), user.getLastName(), user.getEmail());
        users.put(String.valueOf(currentId),newUser);
        return newUser;

    }

    @Override
    public List getUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUser(String id) {
        return (User) users.get(id);
    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {
        users.remove(id);

    }

}
