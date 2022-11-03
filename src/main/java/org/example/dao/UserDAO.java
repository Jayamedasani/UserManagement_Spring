package org.example.dao;
import org.example.connection.MySQLConnection;
import org.example.models.User;
import org.example.userinterface.UserOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDAO implements UserOperations {
    private Logger logger=LoggerFactory.getLogger(UserDAO.class);
    @Override
    public void addUser(User user) {
        Connection connection= MySQLConnection.getConnection();
        String sql="insert into person(name,phnno,city,dob) values(?,?,?,?)";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setBigDecimal(2,new BigDecimal(user.getPhnno()));
            statement.setString(3, user.getCity());
            statement.setDate(4,Date.valueOf(user.getDob()));
            int result=statement.executeUpdate();
            if(result==1){
                logger.info("User Added");
            }
        } catch (SQLException e) {
            logger.info("User is not added");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(User user) {
        Connection connection=MySQLConnection.getConnection();
        String sql="delete from person where phnno=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setBigDecimal(1,new BigDecimal(user.getPhnno()));
            int result=statement.executeUpdate();
            if(result==1){
                logger.info("User Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user, BigInteger phnno) {
        Connection connection=MySQLConnection.getConnection();
        String sql="update person set name=? ,city=? ,phnno=?, dob=? where phnno=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getCity());
            statement.setBigDecimal(3,new BigDecimal(user.getPhnno()));
            statement.setDate(4,Date.valueOf(user.getDob()));
            statement.setBigDecimal(5,new BigDecimal(phnno));
            int result=statement.executeUpdate();
            if(result==1){
                logger.info("User Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User searchUser(String name) {
        Connection connection=MySQLConnection.getConnection();
        String sql="select * from person where name=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                String username=resultSet.getString("name");
                String city=resultSet.getString("city");
                LocalDate dob=LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate("dob")));
                BigInteger phnno=resultSet.getBigDecimal("phnno").toBigInteger();
                return new User(username,city,phnno,dob);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        Connection connection=MySQLConnection.getConnection();
        String sql="select * from person";
        List<User> userList=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                String username=resultSet.getString("name");
                String city=resultSet.getString("city");
                LocalDate dob=LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate("dob")) );
                BigInteger phnno=resultSet.getBigDecimal("phnno").toBigInteger();
                userList.add(new User(username,city,phnno,dob));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
