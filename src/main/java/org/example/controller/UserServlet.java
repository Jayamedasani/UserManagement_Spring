package org.example.controller;
import org.example.exceptions.EnterValidInputError;
import org.example.models.User;
import org.example.userinterface.UserOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;
@RestController
@RequestMapping(value="/users" ,headers="Accept= '*/*'")
public class UserServlet  {
    @Autowired
    UserOperations userOperations;
    @GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(){
        return "testing api";
    }
    @RequestMapping(value="/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        return userOperations.getUserService();
    }
    @GetMapping(value="/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public User searchUser(@PathVariable String name){
        try {
            return userOperations.searchUserByNameService(name);
        } catch (EnterValidInputError e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        try {
            userOperations.addUserService(user);
        } catch (EnterValidInputError e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping
    public void updateUser(@RequestBody User user, @RequestParam BigInteger phnno){
        try {
            userOperations.updateUserService(user,phnno);
        } catch (EnterValidInputError e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping
    public void deleteUser(@RequestBody User user){
        try {
            userOperations.deleteUserService(user);
        } catch (EnterValidInputError e) {
            throw new RuntimeException(e);
        }
    }
}
