package business.persistence;

import business.entities.StandardProduct;
import business.entities.StandardProduct;
import business.services.ProductFacade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


}
