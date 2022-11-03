package org.example.userinterface;

import org.example.models.User;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
public interface UserOperations {
    public void addUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user, BigInteger phnno);
    public User searchUser(String name);
    public List<User> getUsers();
}
