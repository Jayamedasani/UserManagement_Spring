package org.example.userinterface;
import org.example.exceptions.EnterValidInputError;
import org.example.models.User;
import java.math.BigInteger;
import java.util.List;
public interface UserOperations {

    public void addUserService(User user) throws EnterValidInputError;

    public void deleteUserService(User user) throws EnterValidInputError;

    public void updateUserService(User user, BigInteger phnno) throws EnterValidInputError;

    public User searchUserByNameService(String name) throws EnterValidInputError;
    public List<User> getUserService();
}
