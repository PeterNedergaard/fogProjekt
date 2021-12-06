package business.persistence;

import business.entities.WorkableMaterial;
import business.services.CalculatorFacade;
import business.services.MaterialFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorMapperTest {

    private final static String DATABASE = "fog_projekt";
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static CalculatorFacade calculatorFacade;
    private static MaterialFacade materialFacade;
    private static ArrayList<WorkableMaterial> workableMaterialList;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            calculatorFacade = new CalculatorFacade(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }



    }

    @Test
    public void calcCarport() {
    }

    @Test
    public void calcPostsTest(){

        ////////////////////////////////////////
        workableMaterialList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM workable_materials";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("idworkable_materials");
                    String materialName = rs.getString("material_name");
                    String materialType = rs.getString("material_type");
                    int materialLength = rs.getInt("material_length");
                    int materialWidth = rs.getInt("material_width");
                    int materialHeight = rs.getInt("material_height");

                    WorkableMaterial workableMaterial = new WorkableMaterial(materialName,materialType,materialLength,materialWidth,materialHeight);
                    workableMaterial.setId(id);
                    workableMaterialList.add(workableMaterial);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ////////////////////////////////////////

        ArrayList<Integer> listOfMaterialIds;

        ArrayList<Integer> listOfMaterialIdsTest = new ArrayList<>();

        listOfMaterialIdsTest.add(workableMaterialList.get(10-1).getId());
        listOfMaterialIdsTest.add(workableMaterialList.get(10-1).getId());
        listOfMaterialIdsTest.add(workableMaterialList.get(10-1).getId());
        listOfMaterialIdsTest.add(workableMaterialList.get(10-1).getId());


        //listOfMaterialIds = calculatorFacade.calcPosts(450, 300, workableMaterialList);

        //assertSame(listOfMaterialIds, listOfMaterialIdsTest);
    }
}