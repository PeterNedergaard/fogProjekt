package business.services;

import business.entities.Order;
import business.entities.StandardProduct;
import business.persistence.Database;
import business.persistence.ProductMapper;
import business.persistence.UserMapper;

import java.util.*;


public class ProductFacade {

    ProductMapper productMapper;

    public static Set<StandardProduct> standardProductsList = new LinkedHashSet<>();

    public static Set<StandardProduct> filteredStandardProductsList = new LinkedHashSet<>();
    public static ArrayList<Integer> widthFilterList = new ArrayList<>();
    public static ArrayList<Integer> lengthFilterList = new ArrayList<>();

    public static ArrayList<Integer> widthDropdownList = new ArrayList<>();
    public static ArrayList<Integer> lengthDropdownList = new ArrayList<>();

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

    public void addStandardProductToDb(Order order){
        productMapper.addStandardProductToDb(order);
    }

    public void initWidthAndLengthLists(){
        productMapper.initWidthAndLengthLists();
    }

}
