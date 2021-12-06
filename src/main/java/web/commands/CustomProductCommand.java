package web.commands;

import business.exceptions.UserException;
import business.services.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomProductCommand extends CommandProtectedPage {

    ProductFacade productFacade;

    public CustomProductCommand(String pageToShow, String role) {
        super(pageToShow, role);
        productFacade = new ProductFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String roofType = (String) request.getServletContext().getAttribute("rooftype");

        productFacade.initWidthAndLengthLists();

        request.getServletContext().setAttribute("widthlist", ProductFacade.widthDropdownList);
        request.getServletContext().setAttribute("lengthlist", ProductFacade.lengthDropdownList);


        if (roofType.equals("flat")) {

            return REDIRECT_INDICATOR + "customflatroof";

        } else if (roofType.equals("raised")) {

            return REDIRECT_INDICATOR + "customraisedroof";
        }

        return REDIRECT_INDICATOR + "homepage";

    }
}
