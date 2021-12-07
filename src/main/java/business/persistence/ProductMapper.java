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

        int startValue = 240;

        for (int i = startValue; i <= 600; i+=30) {
            ProductFacade.widthDropdownList.add(i);
            System.out.println(i);
        }

        for (int i = startValue; i <= 780; i+=30) {
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

        Order order = new Order(getLatestCustomId(), "custom", UserFacade.currentUser.getId(), UserFacade.currentUser.getOrderId(), "Awaits offer");

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

}
