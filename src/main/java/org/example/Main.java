package org.example;
import org.example.dao.UserDAO;
import org.example.exceptions.EnterValidInputError;
import org.example.models.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws EnterValidInputError {
        Logger logger= LoggerFactory.getLogger(Main.class);
        List<User> userList=new ArrayList<>();
        UserService userManager=new UserService();
            userManager.addUserService(new User("madhu","jaya", BigInteger.valueOf(9999999999L), LocalDate.now()));
        /*userManager.deleteUser(new User("jaya","khm", BigInteger.valueOf(33328870), LocalDate.now()));*/
        /*userManager.updateUser(new User("jayalakshmi","khm", BigInteger.valueOf(3332887), LocalDate.now()),BigInteger.valueOf(3332887));*/
        userList=userManager.getUserService();
        for(User user:userList){
            logger.info("user "+user);
        }
        User user=userManager.searchUserByNameService("jaya");
        logger.info("search operation user:"+user);
    }
}