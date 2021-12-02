package business.entities;

import java.util.ArrayList;

public class User
{

    public User(String email, String password, String role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;

    private ArrayList<StandardProduct> myBasketList = new ArrayList<>();

    public String getEmail()
    {
        return email;
    }

    public ArrayList<StandardProduct> getMyBasketList() {
        return myBasketList;
    }

    public void setMyBasketList(ArrayList<StandardProduct> myBasketList) {
        this.myBasketList = myBasketList;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
