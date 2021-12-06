package business.services;

import business.entities.DoneMaterial;
import business.entities.WorkableMaterial;
import business.persistence.Database;
import business.persistence.MaterialMapper;

import java.util.ArrayList;

public class MaterialFacade {

    MaterialMapper materialMapper;

    public static ArrayList<DoneMaterial> doneMaterialList = new ArrayList<>();
    public static ArrayList<WorkableMaterial> workableMaterialList = new ArrayList<>();

    public MaterialFacade(Database database){
        materialMapper = new MaterialMapper(database);
    }

    public void initDoneMaterialLists(){
        materialMapper.initDoneMaterialLists();
    }

    public void initWorkableMaterialLists(){
        materialMapper.initWorkableMaterialLists();
    }

}
