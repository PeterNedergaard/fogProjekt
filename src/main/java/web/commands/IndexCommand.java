package web.commands;

import business.entities.StandardProduct;
import business.exceptions.UserException;
import business.services.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class IndexCommand extends CommandUnprotectedPage{

    ProductFacade productFacade;

    public IndexCommand(String pageToShow) {
        super(pageToShow);

        productFacade = new ProductFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        productFacade.initStandardProducts();
        productFacade.initFilterLists();
        ProductFacade.filteredStandardProductsList.clear();

        System.out.println(ProductFacade.standardProductsList);

        request.getServletContext().setAttribute("standardproductlist", ProductFacade.standardProductsList);
        request.getServletContext().setAttribute("widthfilterlist", ProductFacade.widthFilterList);
        request.getServletContext().setAttribute("lengthfilterlist", ProductFacade.lengthFilterList);

        return REDIRECT_INDICATOR + "homepage";
    }
}
