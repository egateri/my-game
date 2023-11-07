package com.moringaschool.student.service;

import com.moringaschool.student.model.User;


import java.util.List;

public interface UserService {

    public User addUser (User user);

    public List getUsers ();
    public User getUser (String id);

    public User editUser (User user);
//            throws UserException;

    public void deleteUser (String id);

}
