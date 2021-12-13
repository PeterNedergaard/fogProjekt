package business.persistence;

import business.entities.CustomProduct;
import business.entities.Order;
import business.entities.StandardProduct;
import business.entities.StandardProduct;
import business.services.ProductFacade;
import business.services.UserFacade;

import java.sql.*;
import java.util.*;

public class ProductMapper {

    private Database database;

    public ProductMapper(Database database)
    {
        this.database = database;
    }


    public void initStandardProducts(){

        if(ProductFacade.standardProductsList.size() < 1){
            Set<StandardProduct> productList = new LinkedHashSet<>();

            try (Connection connection = database.connect()) {
                String sql = "SELECT * FROM done_products";

                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();

                    int i = 1;

                    while (rs.next()) {
                        int id = rs.getInt("iddone_products");
                        int length = rs.getInt("product_length");
                        int width = rs.getInt("product_width");
                        int price = rs.getInt("product_price");
                        String title = rs.getString("product_title");
                        String description = rs.getString("product_description");

                        StandardProduct product = new StandardProduct(id,length,width,price,title,description);
                        productList.add(product);

                        product.setImage("carport" + i + ".png");

                        i++;
                    }
                    ProductFacade.standardProductsList = productList;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }


    public void initFilterLists(){
        if (ProductFacade.widthFilterList.size() < 1) {

            ProductFacade.widthFilterList.add(300);
            ProductFacade.widthFilterList.add(360);
            ProductFacade.widthFilterList.add(390);

            ProductFacade.lengthFilterList.add(480);
            ProductFacade.lengthFilterList.add(540);
            ProductFacade.lengthFilterList.add(600);
            ProductFacade.lengthFilterList.add(720);
            ProductFacade.lengthFilterList.add(780);
            ProductFacade.lengthFilterList.add(810);
            ProductFacade.lengthFilterList.add(910);
        }

    }


    public void addProductToDb(Order order){
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orders (product_id,product_type,user_id,user_orderid,status) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getProductId());
                ps.setString(2, order.getProductType());
                ps.setInt(3, order.getUserId());
                ps.setInt(4, order.getUserOrderId());
                ps.setString(5, order.getStatus());

                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void initWidthAndLengthLists(){

        int startValue = 2400;

        for (int i = startValue; i <= 6000; i+=300) {
            ProductFacade.widthDropdownList.add(i);
            System.out.println(i);
        }

        for (int i = startValue; i <= 7800; i+=300) {
            ProductFacade.lengthDropdownList.add(i);
        }

    }


    public void sendCustomRequest(CustomProduct customproduct){

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO custom_products (product_length, product_width, roof_type, roof_material) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, customproduct.getLength());
                ps.setInt(2, customproduct.getWidth());
                ps.setString(3, customproduct.getRoofType());
                ps.setString(4, customproduct.getRoofMaterial());

                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int hej = getLatestCustomId();

        Order order = new Order(hej, "custom", UserFacade.currentUser.getId(), UserFacade.currentUser.getOrderId(), "Awaits offer");

        addProductToDb(order);

    }


    public int getLatestCustomId(){
        int gottenId = 0;

        try (Connection connection = database.connect()) {
            String sql = "SELECT idcustom_products FROM custom_products WHERE idcustom_products=(SELECT max(idcustom_products) FROM custom_products)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    gottenId = rs.getInt("idcustom_products");
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return gottenId;
    }


    public ArrayList<Order> orderList(){
        ArrayList<Order> orderList = new ArrayList<>();


        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE product_type='custom'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("idorders");
                    int productId = rs.getInt("product_id");
                    String productType = rs.getString("product_type");
                    int userId = rs.getInt("user_id");
                    int orderId = rs.getInt("user_orderid");
                    String status = rs.getString("status");

                    Order order = new Order(productId,productType,userId,orderId,status);

                    String email = getEmailById(userId);

                    order.setId(id);
                    order.setEmail(email);

                    orderList.add(order);

                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return orderList;
    }


    public String getEmailById(int id){
        String gottenEmail = "";

        try (Connection connection = database.connect()) {
            String sql = "SELECT email FROM users WHERE id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,id);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    gottenEmail = rs.getString("email");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return gottenEmail;
    }


    public CustomProduct getCustomProductById(int productId){
        CustomProduct customProduct = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM custom_products WHERE idcustom_products=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,productId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("idcustom_products");
                    int productLength = rs.getInt("product_length");
                    int productWidth = rs.getInt("product_width");
                    String roofType = rs.getString("roof_type");
                    String roofMaterial = rs.getString("roof_material");
                    int price = rs.getInt("product_price");

                    CustomProduct tempProduct = new CustomProduct(productLength, productWidth,roofType,roofMaterial);
                    tempProduct.setId(id);
                    tempProduct.setPrice(price);

                    customProduct = tempProduct;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customProduct;
    }


    public void updateCustomPrice(int productId, double price){

        try (Connection connection = database.connect()) {
            String sql = "UPDATE custom_products SET product_price=? WHERE idcustom_products=?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDouble(1, price);
                ps.setInt(2, productId);

                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void updateOrderStatus(Order order){

        try (Connection connection = database.connect()) {
            String sql = "UPDATE orders SET status=? WHERE idorders=?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, order.getStatus());
                ps.setInt(2, order.getId());

                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public ArrayList<Order> myOrderList(int userId){
        ArrayList<Order> orderList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE user_id=? AND product_type='custom'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,userId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("idorders");
                    int productId = rs.getInt("product_id");
                    String productType = rs.getString("product_type");
                    int orderId = rs.getInt("user_orderid");
                    String status = rs.getString("status");

                    Order order = new Order(productId,productType,userId,orderId,status);

                    String email = getEmailById(userId);

                    order.setId(id);
                    order.setEmail(email);

                    orderList.add(order);
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orderList;
    }


}
