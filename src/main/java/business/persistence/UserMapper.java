package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }


    public void createUser(User user) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }


    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT id, role, order_id, telephone, zipcode, city, street, house_number FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int id = rs.getInt("id");
                    String role = rs.getString("role");
                    int orderId = rs.getInt("order_id");
                    int telephone = rs.getInt("telephone");
                    int zipcode = rs.getInt("zipcode");
                    String city = rs.getString("city");
                    String street = rs.getString("street");
                    String houseNumber = rs.getString("house_number");

                    User user = new User(email, password, role);

                    user.setOrderId(orderId);
                    user.setId(id);
                    user.setTelephone(telephone);
                    user.setZipcode(zipcode);
                    user.setCity(city);
                    user.setStreet(street);
                    user.setHouseNumber(houseNumber);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }


    public void updateUserToDb(User user){

        try (Connection connection = database.connect()) {
            String sql = "UPDATE users SET order_id=? WHERE id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, user.getOrderId());
                ps.setInt(2, user.getId());

                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public ArrayList<User> getUserList() throws SQLException {
        ArrayList<User> userList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM users";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    int orderId = rs.getInt("order_id");
                    int telephone = rs.getInt("telephone");
                    int zipcode = rs.getInt("zipcode");
                    String city = rs.getString("city");
                    String street = rs.getString("street");
                    String houseNumber = rs.getString("house_number");

                    User user = new User(email, password, role);

                    user.setId(id);
                    user.setOrderId(orderId);
                    user.setTelephone(telephone);
                    user.setZipcode(zipcode);
                    user.setCity(city);
                    user.setStreet(street);
                    user.setHouseNumber(houseNumber);

                    userList.add(user);

                }
            }
        }

        return userList;
    }

}
