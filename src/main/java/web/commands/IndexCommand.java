package web.commands;

import business.entities.CustomProduct;
import business.entities.DoneMaterial;
import business.entities.StandardProduct;
import business.entities.WorkableMaterial;
import business.exceptions.UserException;
import business.services.CalculatorFacade;
import business.services.MaterialFacade;
import business.services.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class IndexCommand extends CommandUnprotectedPage{

    ProductFacade productFacade;
    MaterialFacade materialFacade;
    CalculatorFacade calculatorFacade;

    public IndexCommand(String pageToShow) {
        super(pageToShow);

        productFacade = new ProductFacade(database);
        materialFacade = new MaterialFacade(database);
        calculatorFacade = new CalculatorFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        materialFacade.initDoneMaterialLists();
        materialFacade.initWorkableMaterialLists();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /*for (WorkableMaterial wm : calculatorFacade.calcCarport(6000,7800, 5300, 2100)) {
            System.out.println(wm.getId() + " " + wm.getAmount() + " " + wm.getLength() + " " + wm.getDescription() + " " + wm.getPrice() + " " + wm.getTotalPrice());
        }*/

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        productFacade.initStandardProducts();
        productFacade.initFilterLists();
        ProductFacade.filteredStandardProductsList.clear();

        request.getServletContext().setAttribute("standardproductlist", ProductFacade.standardProductsList);
        request.getServletContext().setAttribute("widthfilterlist", ProductFacade.widthFilterList);
        request.getServletContext().setAttribute("lengthfilterlist", ProductFacade.lengthFilterList);

        return REDIRECT_INDICATOR + "homepage";
    }
}
