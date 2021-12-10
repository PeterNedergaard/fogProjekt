package business.entities;

import java.text.DecimalFormat;
import java.util.Comparator;

public class WorkableMaterial{

    private int id;
    private String name;
    private String type;
    private int length;
    private int width;
    private int height;
    private String description;
    private int amount;
    private double price;
    private double totalPrice;
    private String strPrice;
    private String strTotalPrice;

    public WorkableMaterial(String name, String type, int length, int width, int height, double price) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
        this.strPrice = String.format("%.2f",price);
    }

    public String getStrPrice() {
        return strPrice;
    }

    public void setStrPrice(String strPrice) {
        this.strPrice = strPrice;
    }

    public String getStrTotalPrice() {
        return strTotalPrice;
    }

    public void setStrTotalPrice(String strTotalPrice) {
        this.strTotalPrice = strTotalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.strTotalPrice = String.format("%.2f",totalPrice);
        this.totalPrice = totalPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
