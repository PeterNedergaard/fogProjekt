package business.persistence;

import business.entities.DoneMaterial;
import business.entities.WorkableMaterial;
import business.services.MaterialFacade;
import business.services.ProductFacade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialMapper {

    private Database database;

    public MaterialMapper(Database database)
    {
        this.database = database;
    }

    public void initDoneMaterialLists(){

        if(MaterialFacade.doneMaterialList.size() < 1){
            ArrayList<DoneMaterial> doneMaterialList = new ArrayList<>();

            try (Connection connection = database.connect()) {
                String sql = "SELECT * FROM done_materials";

                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        int id = rs.getInt("idmaterials");
                        String materialName = rs.getString("material_name");
                        int unitAmount = rs.getInt("unit_amount");
                        String unitType = rs.getString("unit_type");

                        DoneMaterial doneMaterial = new DoneMaterial(materialName,unitAmount,unitType);
                        doneMaterial.setId(id);
                        doneMaterialList.add(doneMaterial);

                    }
                    MaterialFacade.doneMaterialList = doneMaterialList;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public void initWorkableMaterialLists(){

        if(MaterialFacade.workableMaterialList.size() < 1){
            ArrayList<WorkableMaterial> workableMaterialList = new ArrayList<>();

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
                        double materialPrice = rs.getInt("material_price") * 2.85723;

                        WorkableMaterial workableMaterial = new WorkableMaterial(materialName,materialType,materialLength,materialWidth,materialHeight,materialPrice);
                        workableMaterial.setId(id);
                        workableMaterialList.add(workableMaterial);

                    }
                    MaterialFacade.workableMaterialList = workableMaterialList;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }

}
