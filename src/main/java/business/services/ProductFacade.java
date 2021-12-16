package business.services;

import business.entities.CustomProduct;
import business.entities.Order;
import business.entities.StandardProduct;
import business.persistence.Database;
import business.persistence.ProductMapper;

import java.util.*;


public class ProductFacade {

    ProductMapper productMapper;

    public static Set<StandardProduct> standardProductsList = new LinkedHashSet<>();

    public static Set<StandardProduct> filteredStandardProductsList = new LinkedHashSet<>();
    public static ArrayList<Integer> widthFilterList = new ArrayList<>();
    public static ArrayList<Integer> lengthFilterList = new ArrayList<>();

    public static ArrayList<Integer> widthDropdownList = new ArrayList<>();
    public static ArrayList<Integer> lengthDropdownList = new ArrayList<>();

    public static ArrayList<Integer> shedWidthDropdownList = new ArrayList<>();
    public static ArrayList<Integer> shedLengthDropdownList = new ArrayList<>();

    public ProductFacade(Database database)
    {
        productMapper = new ProductMapper(database);
    }

    public void initStandardProducts(){
        productMapper.initStandardProducts();
    }

    public void initFilterLists(){
        productMapper.initFilterLists();
        //filteredStandardProductsList = standardProductsList;
    }

    public void addProductToDb(Order order){
        productMapper.addProductToDb(order);
    }

    public void initWidthAndLengthLists(){
        productMapper.initWidthAndLengthLists();
    }

    public int getLatestCustomId(){
        return productMapper.getLatestCustomId();
    }

    public void sendCustomRequest(CustomProduct customproduct){
        productMapper.sendCustomRequest(customproduct);
    }

    public ArrayList<Order> orderList(){
        return productMapper.orderList();
    }

    public String getEmailById(int id){
        return productMapper.getEmailById(id);
    }

    public CustomProduct getCustomProductById(int productId){
        return productMapper.getCustomProductById(productId);
    }

    public void updateCustomPrice(int productId, double price){
        productMapper.updateCustomPrice(productId,price);
    }

    public void updateOrderStatus(Order order){
        productMapper.updateOrderStatus(order);
    }

    public ArrayList<Order> myOrderList(int userId){
        return productMapper.myOrderList(userId);
    }

    public void deleteOrder(int orderId){
        productMapper.deleteOrder(orderId);
    }

}
