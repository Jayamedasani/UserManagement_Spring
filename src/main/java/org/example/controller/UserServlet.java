package org.example.controller;
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
        return userOperations.getUsers();
    }
    @GetMapping(value="/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public User searchUser(@PathVariable String name){
        return userOperations.searchUser(name);
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        userOperations.addUser(user);
    }
    @PutMapping
    public void updateUser(@RequestBody User user, @RequestParam BigInteger phnno){
        userOperations.updateUser(user,phnno);
    }
    @DeleteMapping
    public void deleteUser(@RequestBody User user){
        userOperations.deleteUser(user);
    }
}
