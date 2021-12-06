package business.persistence;

import business.entities.WorkableMaterial;
import business.services.MaterialFacade;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CalculatorMapper {

    private Database database;

    public CalculatorMapper(Database database) {
        this.database = database;
    }

    public ArrayList<WorkableMaterial> calcCarport(int carportWidth, int carportLength) {

        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        ArrayList<WorkableMaterial> sortedListOfMaterials = MaterialFacade.workableMaterialList;
        ArrayList<WorkableMaterial> sortedListOfSpaertrae = new ArrayList<>();

        //Sorting largest first
        sortedListOfMaterials.sort(Comparator.comparingInt(WorkableMaterial::getLength));

        for (WorkableMaterial wm : sortedListOfMaterials) {
            if (wm.getName().equals("spaertrae ubh.")) {
                sortedListOfSpaertrae.add(wm);
            }
        }

        //listOfMaterials.addAll(calcPosts(carportWidth,carportLength));

        //listOfMaterials.addAll(calcRem(carportWidth, carportLength, sortedListOfSpaertrae));

        listOfMaterials.addAll(calcSpear(carportWidth,carportLength,sortedListOfSpaertrae));


        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcPosts(int caportWidth, int caportLength) {
        int numbOfPosts = 0;
        int idOfMaterial = 10;
        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        if (caportLength < 4200) {
            numbOfPosts = 4;
        } else {
            numbOfPosts = 6;
        }

        for (int i = 0; i < numbOfPosts; i++) {
            listOfMaterials.add(MaterialFacade.workableMaterialList.get(idOfMaterial - 1));
        }

        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcRem(int caportWidth, int carportLength, ArrayList<WorkableMaterial> sortedListOfSpaertrae) {

        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        int maxLength = sortedListOfSpaertrae.get(sortedListOfSpaertrae.size() - 1).getLength();

        int length = carportLength * 2;
        int lengthSum = 0;

        while (lengthSum < length) {

            if (lengthSum + maxLength <= length) {
                System.out.println("Adding longest");
                listOfMaterials.add(sortedListOfSpaertrae.get(sortedListOfSpaertrae.size() - 1));
                lengthSum += maxLength;
            } else {
                System.out.println("Searching for best match");
                for (WorkableMaterial wm : sortedListOfSpaertrae) {
                    if (lengthSum + wm.getLength() >= length) {
                        listOfMaterials.add(wm);
                        lengthSum += wm.getLength();
                        break;
                    }
                }
            }

        }

        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcSpear(int carportWidth, int carportLength, ArrayList<WorkableMaterial> sortedListOfSpaertrae){
        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        int amountSpear = carportLength/300;

        for (WorkableMaterial wm : sortedListOfSpaertrae) {
            if (wm.getLength() >= carportWidth) {

                for (int i = 0; i < amountSpear; i++) {
                    listOfMaterials.add(wm);
                }

                break;
            }
        }

        return listOfMaterials;
    }


}
