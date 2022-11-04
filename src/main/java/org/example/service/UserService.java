package org.example.service;

import org.example.dao.UserDAO;
import org.example.exceptions.EnterValidInputError;
import org.example.models.User;
import org.example.userinterface.UserOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;
@Service
public class UserService implements UserOperations {
    private Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserDAO userDAO;
    @Override
    public void addUserService(User user) throws EnterValidInputError {
        logger.info("In add method");
        if (user.getName() == null || user.getPhnno() == null || user.getCity() == null || user.getDob() == null) {
            throw new EnterValidInputError("Enter All Fields of User");
        }
        if ((user.getPhnno()).toString().length() != 10) {
            throw new EnterValidInputError("Phone Number must be of 10 digits");
        }else {
            userDAO.addUser(user);
        }
    }
    @Override
    public void deleteUserService(User user) throws EnterValidInputError {
        if (user.getName() == null || user.getPhnno() == null || user.getCity() == null || user.getDob() == null) {
            throw new EnterValidInputError("Enter All Fields of User");
        }
        if (user.getPhnno().toString().length() != 10) {
            throw new EnterValidInputError("Phone Number must be of 10 digits");
        }else {
            userDAO.deleteUser(user);
        }
    }
    @Override
    public void updateUserService(User user, BigInteger phnno) throws EnterValidInputError {
        if (user.getName() == null || user.getPhnno() == null || user.getCity() == null || user.getDob() == null) {
            throw new EnterValidInputError("Enter All Fields of User");
        }
        if (phnno.toString().length() != 10) {
            throw new EnterValidInputError("Phone Number must be of 10 digits");
        }
        if (user.getPhnno().toString().length()!= 10) {
            throw new EnterValidInputError("Phone Number must be of 10 digits");
        }else {
            userDAO.updateUser(user, phnno);
        }
    }
    @Override
    public User searchUserByNameService(String name) throws EnterValidInputError {
        if(name==null){
            throw new EnterValidInputError("UserName not be null to search");
        }
        return userDAO.searchUserByName(name);
    }

    @Override
    public List<User> getUserService() {
       return  userDAO.getUsers();
    }

}
