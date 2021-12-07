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

        listOfMaterials.addAll(calcPosts(carportWidth,carportLength));

        listOfMaterials.addAll(calcRem(carportWidth, carportLength, sortedListOfSpaertrae));

        listOfMaterials.addAll(calcSpear(carportWidth,carportLength,sortedListOfSpaertrae));

        listOfMaterials.addAll(calcRoof(carportWidth,carportLength,sortedListOfMaterials));

        listOfMaterials.addAll(calcUnderStern(carportWidth,carportLength,sortedListOfMaterials));

        listOfMaterials.addAll(calcOverStern(carportWidth,carportLength,sortedListOfMaterials));



        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcPosts(int carportWidth, int carportLength) {
        int numbOfPosts = 0;
        int idOfMaterial = 10;
        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        if (carportLength < 4200) {
            numbOfPosts = 4;
        } else {
            numbOfPosts = 6;
        }

        for (int i = 0; i < numbOfPosts; i++) {

            WorkableMaterial materialToAdd = MaterialFacade.workableMaterialList.get(idOfMaterial - 1);

            //If list already contains the material to add. Add to amount
            if (listOfMaterials.contains(materialToAdd)){
                for (WorkableMaterial wm : listOfMaterials) {
                    if (wm.equals(materialToAdd)){
                        wm.setAmount(wm.getAmount()+1);
                    }
                }
            } else {
                materialToAdd.setDescription("Stolper nedgraves 90 cm. i jord");
                materialToAdd.setAmount(materialToAdd.getAmount() + 1);
                listOfMaterials.add(materialToAdd);
            }

        }

        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcRem(int carportWidth, int carportLength, ArrayList<WorkableMaterial> sortedListOfSpaertrae) {

        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        int maxLength = sortedListOfSpaertrae.get(sortedListOfSpaertrae.size() - 1).getLength();

        int length = carportLength * 2;
        int lengthSum = 0;

        while (lengthSum < length) {
            WorkableMaterial materialToadd;

            //If it is possible to add the longest piece of wood
            if (lengthSum + maxLength <= length) {

                materialToadd = sortedListOfSpaertrae.get(sortedListOfSpaertrae.size() - 1);

                //If list already contains material to add. Add to amount
                if (listOfMaterials.contains(materialToadd)){
                    for (WorkableMaterial wm : listOfMaterials) {
                        if (wm.equals(materialToadd)){
                            wm.setAmount(wm.getAmount()+1);
                        }
                    }
                } else {
                    materialToadd.setDescription("Remme i sider, sadles ned i stolper");
                    materialToadd.setAmount(materialToadd.getAmount()+1);
                    listOfMaterials.add(materialToadd);
                }

                lengthSum += maxLength;

            } else {

                for (WorkableMaterial wm : sortedListOfSpaertrae) {
                    if (lengthSum + wm.getLength() >= length) {

                        //If list already contains material to add. Add to amount
                        if (listOfMaterials.contains(wm)){
                            for (WorkableMaterial wml : listOfMaterials) {
                                if (wml.equals(wm)){
                                    wml.setAmount(wml.getAmount()+1);
                                }
                            }
                        } else {
                            wm.setDescription("Remme i sider, sadles ned i stolper");
                            wm.setAmount(wm.getAmount()+1);
                            listOfMaterials.add(wm);
                        }

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

            //Find piece of wood as close to carport width as possible, but always longer.
            if (wm.getLength() >= carportWidth) {

                for (int i = 0; i < amountSpear; i++) {

                    WorkableMaterial materialToAdd = wm;

                    //If list already contains material to add
                    if (listOfMaterials.contains(materialToAdd)){
                        for (WorkableMaterial wml : listOfMaterials) {
                            if (wml.equals(materialToAdd)){
                                wml.setAmount(wm.getAmount()+1);
                            }
                        }
                    } else {
                        materialToAdd.setDescription("Spær, monteres på rem");
                        materialToAdd.setAmount(materialToAdd.getAmount() + 1);
                        listOfMaterials.add(materialToAdd);
                    }
                }

                break;
            }
        }

        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcRoof(int carportWidth, int carportLength, ArrayList<WorkableMaterial> sortedListOfMaterials){
        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();
        ArrayList<WorkableMaterial> sortedListOfRoof = new ArrayList<>();

        for (WorkableMaterial wm : sortedListOfMaterials) {
            if (wm.getType().equals("tagplader")){
                sortedListOfRoof.add(wm);
            }
        }

        int maxLength = sortedListOfRoof.get(sortedListOfRoof.size()-1).getLength();
        int roofPlateWidth = 1090;

        int amount = (int)Math.ceil((double)carportWidth/(double)roofPlateWidth);
        int roofLength = amount * carportLength;
        int lengthSum = 0;

        while (lengthSum < roofLength){

            //If it is possible to add the longest roof
            if (lengthSum + maxLength < roofLength){
                WorkableMaterial materialToadd = sortedListOfRoof.get(sortedListOfRoof.size()-1);

                //If the list contains the material. Add to amount
                if (listOfMaterials.contains(materialToadd)){
                    for (WorkableMaterial wm : listOfMaterials) {
                        if (wm.equals(materialToadd)){
                            wm.setAmount(wm.getAmount()+1);
                        }
                    }
                } else {
                    materialToadd.setDescription("tagplader monteres på spær");
                    materialToadd.setAmount(materialToadd.getAmount()+1);
                    listOfMaterials.add(materialToadd);
                }

                lengthSum += maxLength;

            } else {

                //Find roofplate as close to carportWidth as possible, but always longer.
                for (WorkableMaterial wm : sortedListOfRoof) {

                    if (lengthSum + wm.getLength() >= roofLength){

                        //If the list contains the material. Add to amount
                        if (listOfMaterials.contains(wm)){
                            for (WorkableMaterial wml : listOfMaterials) {
                                if (wml.equals(wm)){
                                    wml.setAmount(wml.getAmount()+1);
                                }
                            }
                        } else {
                            wm.setDescription("tagplader monteres på spær");
                            wm.setAmount(wm.getAmount()+1);
                            listOfMaterials.add(wm);
                        }

                        lengthSum += wm.getLength();
                        break;
                    }

                }
            }
        }


        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcUnderStern(int carportWidth, int carportLength, ArrayList<WorkableMaterial> sortedListOfMaterials){
        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();
        ArrayList<WorkableMaterial> sortedListOfUnderStern = new ArrayList<>();

        for (WorkableMaterial wm : sortedListOfMaterials) {
            if (wm.getName().equals("trykimp.braet") && wm.getHeight() == 25 && wm.getWidth() == 200){
                sortedListOfUnderStern.add(wm);
            }
        }

        int maxLength = 6000;
        int length = (carportWidth*2) + (carportLength*2);
        int lengthSum = 0;


        while (lengthSum < length) {

            //If it is possible to add the longest piece of woowd
            if (lengthSum + maxLength <= length) {
                WorkableMaterial materialToAdd = sortedListOfUnderStern.get(sortedListOfUnderStern.size() - 1);

                //If the list contains the material. Add to amount
                if (listOfMaterials.contains(materialToAdd)){
                    for (WorkableMaterial wm : listOfMaterials) {
                        if (wm.equals(materialToAdd)){
                            wm.setAmount(wm.getAmount()+1);
                        }
                    }
                } else {
                    materialToAdd.setDescription("understernbrædder");
                    materialToAdd.setAmount(materialToAdd.getAmount()+1);
                    listOfMaterials.add(materialToAdd);
                }

                lengthSum += maxLength;

            } else {

                //Find piece of wood as close to carport width as possible, but always longer.
                for (WorkableMaterial wm : sortedListOfUnderStern) {
                    if (lengthSum + wm.getLength() >= length) {

                        //If the list contains the material. Add to amount
                        if (listOfMaterials.contains(wm)){
                            for (WorkableMaterial wml : listOfMaterials) {
                                if (wml.equals(wm)){
                                    wml.setAmount(wml.getAmount()+1);
                                }
                            }
                        } else {
                            wm.setDescription("understernbrædder");
                            wm.setAmount(wm.getAmount()+1);
                            listOfMaterials.add(wm);
                        }

                        lengthSum += wm.getLength();
                        break;
                    }
                }
            }

        }


        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcOverStern(int carportWidth, int carportLength, ArrayList<WorkableMaterial> sortedListOfMaterials){
        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        ArrayList<WorkableMaterial> sortedListOfOverStern = new ArrayList<>();

        for (WorkableMaterial wm : sortedListOfMaterials) {
            if (wm.getName().equals("trykimp.braet") && wm.getHeight() == 25 && wm.getWidth() == 125){
                sortedListOfOverStern.add(wm);
            }
        }

        int maxLength = 6000;
        int length = carportWidth + (carportLength*2);
        int lengthSum = 0;

        while (lengthSum < length) {

            //If it is possible to add the longest piece of woowd
            if (lengthSum + maxLength <= length) {

                WorkableMaterial materialToAdd = sortedListOfOverStern.get(sortedListOfOverStern.size() - 1);

                //If the list contains the material. Add to amount
                if (listOfMaterials.contains(materialToAdd)){
                    for (WorkableMaterial wm : listOfMaterials) {
                        if (wm.equals(materialToAdd)){
                            wm.setAmount(wm.getAmount()+1);
                        }
                    }
                } else {
                    materialToAdd.setDescription("oversternbrædder");
                    materialToAdd.setAmount(materialToAdd.getAmount()+1);
                    listOfMaterials.add(materialToAdd);
                }

                lengthSum += maxLength;

            } else {

                //Find piece of wood as close to carport width as possible, but always longer.
                for (WorkableMaterial wm : sortedListOfOverStern) {
                    if (lengthSum + wm.getLength() >= length) {

                        //If the list contains the material. Add to amount
                        if (listOfMaterials.contains(wm)){
                            for (WorkableMaterial wml : listOfMaterials) {
                                if (wml.equals(wm)){
                                    wml.setAmount(wml.getAmount()+1);
                                }
                            }
                        } else {
                            wm.setDescription("oversternbrædder");
                            wm.setAmount(wm.getAmount()+1);
                            listOfMaterials.add(wm);
                        }

                        lengthSum += wm.getLength();

                        break;
                    }
                }
            }

        }


        return listOfMaterials;
    }


}
