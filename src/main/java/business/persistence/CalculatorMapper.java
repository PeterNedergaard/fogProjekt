package business.persistence;

import business.entities.WorkableMaterial;
import business.services.MaterialFacade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalculatorMapper {

    private Database database;
    MaterialFacade materialFacade;

    public CalculatorMapper(Database database) {
        this.database = database;
        materialFacade = new MaterialFacade(database);
    }

    public ArrayList<WorkableMaterial> calcCarport(int carportWidth, int carportLength, int shedWidth, int shedLength) {

        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        ArrayList<WorkableMaterial> sortedListOfMaterials = MaterialFacade.workableMaterialList;

        //Sorting largest first
        sortedListOfMaterials.sort(Comparator.comparingInt(WorkableMaterial::getLength));


        listOfMaterials.addAll(calcPosts(carportWidth,carportLength, shedWidth, shedLength, sortedListOfMaterials));

        listOfMaterials.addAll(calcSpaer(carportWidth,carportLength,sortedListOfMaterials));

        listOfMaterials.addAll(calcRem(carportWidth, carportLength, sortedListOfMaterials));

        listOfMaterials.addAll(calcRoof(carportWidth,carportLength,sortedListOfMaterials));

        listOfMaterials.addAll(calcUnderStern(carportWidth,carportLength,sortedListOfMaterials));

        listOfMaterials.addAll(calcOverStern(carportWidth,carportLength,sortedListOfMaterials));

        listOfMaterials.addAll(calcShedCladding(shedWidth,shedLength,sortedListOfMaterials));

        MaterialFacade.workableMaterialList.clear();
        materialFacade.initWorkableMaterialLists();

        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcPosts(int carportWidth, int carportLength, int shedWidth, int shedLength, ArrayList<WorkableMaterial> sortedListOfMaterials) {

        int numbOfPosts;
        int udhaengSum = 300;

        WorkableMaterial materialToAdd = null;

        for (WorkableMaterial wm : sortedListOfMaterials) {
            if (wm.getName().equals("trykimp. stolpe")) {
                materialToAdd = new WorkableMaterial(wm.getName(),wm.getType(),wm.getLength(),wm.getWidth(),wm.getHeight(), wm.getPrice());
                materialToAdd.setId(wm.getId());
            }
        }


        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        //Stolper til carporten
        if (carportLength < 4200) {
            numbOfPosts = 4;
        } else {
            numbOfPosts = 6;
        }


        //Stolper til redsskabsskuret
        if (shedWidth > 0 || shedLength > 0) {

            if (shedWidth > 4200) {

                if (shedWidth < (carportWidth - udhaengSum)) {
                    numbOfPosts += 5;
                } else if (shedWidth == carportWidth - udhaengSum) {
                    numbOfPosts += 4;
                }

            } else {

                if (shedWidth < (carportWidth - udhaengSum)) {
                    numbOfPosts += 3;
                } else if (shedWidth == carportWidth - udhaengSum) {
                    numbOfPosts += 2;
                }

            }
        }


        for (int i = 0; i < numbOfPosts; i++) {

            //If list already contains the material to add. Add to amount
            if (listOfMaterials.contains(materialToAdd)){
                for (WorkableMaterial wm : listOfMaterials) {
                    if (wm.equals(materialToAdd)){
                        wm.setAmount(wm.getAmount()+1);
                        wm.setTotalPrice(wm.getTotalPrice()+wm.getPrice());
                    }
                }
            } else {
                materialToAdd.setDescription("Stolper nedgraves 90 cm. i jord");
                materialToAdd.setAmount(materialToAdd.getAmount() + 1);
                materialToAdd.setTotalPrice(materialToAdd.getPrice());
                listOfMaterials.add(materialToAdd);
            }

        }

        return listOfMaterials;
    }


    public ArrayList<WorkableMaterial> calcRem(int carportWidth, int carportLength, ArrayList<WorkableMaterial> sortedListOfMaterials) {

        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();
        ArrayList<WorkableMaterial> sortedListOfSpaerTrae = new ArrayList<>();

        for (WorkableMaterial wm : sortedListOfMaterials) {
            if (wm.getName().equals("spaertrae ubh.")) {
                WorkableMaterial workableMaterial = new WorkableMaterial(wm.getName(),wm.getType(),wm.getLength(),wm.getWidth(),wm.getHeight(), wm.getPrice());
                workableMaterial.setId(wm.getId());
                sortedListOfSpaerTrae.add(workableMaterial);
            }
        }

        int maxLength = sortedListOfSpaerTrae.get(sortedListOfSpaerTrae.size() - 1).getLength();

        int length = carportLength * 2;
        int lengthSum = 0;
        WorkableMaterial materialToadd;

        while (lengthSum < length) {


            //If it is possible to add the longest piece of wood
            if (lengthSum + maxLength <= length) {

                materialToadd = sortedListOfSpaerTrae.get(sortedListOfSpaerTrae.size() - 1);

                //If list already contains material to add. Add to amount
                if (listOfMaterials.contains(materialToadd)){
                    for (WorkableMaterial wm : listOfMaterials) {
                        if (wm.equals(materialToadd)){
                            wm.setAmount(wm.getAmount()+1);
                            wm.setTotalPrice(wm.getTotalPrice()+wm.getPrice());
                        }
                    }
                } else {
                    materialToadd.setDescription("Remme i sider, sadles ned i stolper");
                    materialToadd.setAmount(materialToadd.getAmount()+1);
                    materialToadd.setTotalPrice(materialToadd.getPrice());
                    listOfMaterials.add(materialToadd);
                }

                lengthSum += maxLength;

            } else {

                for (WorkableMaterial wm : sortedListOfSpaerTrae) {

                    if (lengthSum + wm.getLength() >= length) {

                        //If list already contains material to add. Add to amount
                        if (listOfMaterials.contains(wm)){
                            for (WorkableMaterial lwm : listOfMaterials) {
                                if (lwm.equals(wm)){
                                    lwm.setAmount(lwm.getAmount()+1);
                                    lwm.setTotalPrice(lwm.getTotalPrice()+lwm.getPrice());
                                }
                            }
                        } else {
                            wm.setDescription("Remme i sider, sadles ned i stolper");
                            wm.setAmount(wm.getAmount()+1);
                            wm.setTotalPrice(wm.getPrice());
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


    public ArrayList<WorkableMaterial> calcSpaer(int carportWidth, int carportLength, ArrayList<WorkableMaterial> sortedListOfMaterials){
        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();
        ArrayList<WorkableMaterial> sortedListOfSpaerTrae = new ArrayList<>();

        for (WorkableMaterial wm : sortedListOfMaterials) {
            if (wm.getName().equals("spaertrae ubh.")) {
                WorkableMaterial workableMaterial = new WorkableMaterial(wm.getName(),wm.getType(),wm.getLength(),wm.getWidth(),wm.getHeight(), wm.getPrice());
                workableMaterial.setId(wm.getId());
                sortedListOfSpaerTrae.add(workableMaterial);
            }
        }

        int interval = 300;

        int length = carportLength-interval;

        int amountSpear = (length/interval) + 2;

        for (WorkableMaterial wm : sortedListOfSpaerTrae) {

            //Find piece of wood as close to carport width as possible, but always longer.
            if (wm.getLength() >= carportWidth) {

                for (int i = 0; i < amountSpear; i++) {

                    //If list already contains material to add
                    if (listOfMaterials.contains(wm)){
                        for (WorkableMaterial lwm : listOfMaterials) {
                            if (lwm.equals(wm)){
                                lwm.setAmount(lwm.getAmount()+1);
                                lwm.setTotalPrice(lwm.getTotalPrice()+lwm.getPrice());
                            }
                        }
                    } else {
                        wm.setDescription("Spær, monteres på rem");
                        wm.setAmount(wm.getAmount() + 1);
                        wm.setTotalPrice(wm.getPrice());
                        listOfMaterials.add(wm);
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
                            wm.setTotalPrice(wm.getTotalPrice() + wm.getPrice());
                        }
                    }
                } else {
                    materialToadd.setDescription("tagplader monteres på spær");
                    materialToadd.setAmount(materialToadd.getAmount()+1);
                    materialToadd.setTotalPrice(materialToadd.getPrice());
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
                                    wml.setTotalPrice(wml.getTotalPrice()+ wml.getPrice());
                                }
                            }
                        } else {
                            wm.setDescription("tagplader monteres på spær");
                            wm.setAmount(wm.getAmount()+1);
                            wm.setTotalPrice(wm.getPrice());
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

            //If it is possible to add the longest piece of wood
            if (lengthSum + maxLength <= length) {
                WorkableMaterial materialToAdd = sortedListOfUnderStern.get(sortedListOfUnderStern.size() - 1);

                //If the list contains the material. Add to amount
                if (listOfMaterials.contains(materialToAdd)){
                    for (WorkableMaterial wm : listOfMaterials) {
                        if (wm.equals(materialToAdd)){
                            wm.setAmount(wm.getAmount()+1);
                            wm.setTotalPrice(wm.getTotalPrice()+wm.getPrice());
                        }
                    }
                } else {
                    materialToAdd.setDescription("understernbrædder");
                    materialToAdd.setAmount(materialToAdd.getAmount()+1);
                    materialToAdd.setTotalPrice(materialToAdd.getPrice());
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
                                    wml.setTotalPrice(wml.getTotalPrice()+wml.getPrice());
                                }
                            }
                        } else {
                            wm.setDescription("understernbrædder");
                            wm.setAmount(wm.getAmount()+1);
                            wm.setTotalPrice(wm.getPrice());
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
                            wm.setTotalPrice(wm.getTotalPrice()+wm.getPrice());
                        }
                    }
                } else {
                    materialToAdd.setDescription("oversternbrædder");
                    materialToAdd.setAmount(materialToAdd.getAmount()+1);
                    materialToAdd.setTotalPrice(materialToAdd.getPrice());
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
                                    wml.setTotalPrice(wml.getTotalPrice()+wml.getPrice());
                                }
                            }
                        } else {
                            wm.setDescription("oversternbrædder");
                            wm.setAmount(wm.getAmount()+1);
                            wm.setTotalPrice(wm.getPrice());
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


    public ArrayList<WorkableMaterial> calcShedCladding(int shedWidth, int shedLength, ArrayList<WorkableMaterial> sortedListOfMaterials){

        ArrayList<WorkableMaterial> listOfMaterials = new ArrayList<>();

        if (shedWidth > 0 || shedLength > 0) {

            WorkableMaterial materialToAdd = null;

            int amount;
            int surfacePercent = 74;
            int surfaceLength = ((shedWidth * 2) + (shedLength * 2));

            for (WorkableMaterial wm : sortedListOfMaterials) {
                if (wm.getName().equals("trykimp.braet") && wm.getHeight() == 19 && wm.getWidth() == 100 && wm.getLength() == 2100) {
                    materialToAdd = wm;
                }
            }

            amount = surfaceLength / surfacePercent;


            for (int i = 0; i < amount; i++) {

                //If list already contains the material to add. Add to amount
                if (listOfMaterials.contains(materialToAdd)) {
                    for (WorkableMaterial wm : listOfMaterials) {
                        if (wm.equals(materialToAdd)) {
                            wm.setAmount(wm.getAmount() + 1);
                            wm.setTotalPrice(wm.getTotalPrice() + wm.getPrice());
                        }
                    }
                } else {
                    materialToAdd.setDescription("Til beklædning af skur");
                    materialToAdd.setAmount(materialToAdd.getAmount() + 1);
                    materialToAdd.setTotalPrice(materialToAdd.getPrice());
                    listOfMaterials.add(materialToAdd);
                }

            }
        }

        return listOfMaterials;
    }

}
