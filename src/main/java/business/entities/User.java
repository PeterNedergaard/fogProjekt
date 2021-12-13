package business.entities;

import java.util.ArrayList;

public class User
{

    public User(String email, String password, String role, int telephone, int zipcode, String city, String street, String houseNumber)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.telephone = telephone;
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private int orderId;
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private int telephone;
    private int zipcode;
    private String city;
    private String street;
    private String houseNumber;

    private ArrayList<StandardProduct> myBasketList = new ArrayList<>();
    private ArrayList<Order> myOrderList = new ArrayList<>();

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<Order> getMyOrderList() {
        return myOrderList;
    }

    public void setMyOrderList(ArrayList<Order> myOrderList) {
        this.myOrderList = myOrderList;
    }

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
