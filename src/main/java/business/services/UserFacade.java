package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserFacade
{
    UserMapper userMapper;

    public static User currentUser;
    public static ArrayList<User> userList = new ArrayList<>();

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String email, String password, int telephone, int zipcode, String city, String street, String houseNumber) throws UserException
    {
        User user = new User(email, password, "customer", telephone, zipcode, city, street, houseNumber);
        userMapper.createUser(user);
        return user;
    }

    public void updateUserToDb(User user){
        userMapper.updateUserToDb(user);
    }


    public ArrayList<User> getUserList() throws SQLException {
        return userMapper.getUserList();
    }

}
