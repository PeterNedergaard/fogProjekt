package business.services;

import business.entities.WorkableMaterial;
import business.persistence.CalculatorMapper;
import business.persistence.Database;

import java.util.ArrayList;

public class CalculatorFacade {

    CalculatorMapper calculatorMapper;

    public CalculatorFacade(Database database){
        calculatorMapper = new CalculatorMapper(database);
    }

    public ArrayList<WorkableMaterial> calcCarport(int carportWidth, int carportLength, int shedWidth, int shedLength) {
        return calculatorMapper.calcCarport(carportWidth,carportLength,shedWidth,shedLength);
    }

}
