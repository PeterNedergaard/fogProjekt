package web.commands;

import business.entities.CustomProduct;
import business.exceptions.UserException;
import business.services.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRequestCommand extends CommandProtectedPage{

    ProductFacade productFacade;

    public SendRequestCommand(String pageToShow, String role) {
        super(pageToShow, role);

        productFacade = new ProductFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int selectedWidth = Integer.parseInt(request.getParameter("width"));
        int selectedLength = Integer.parseInt(request.getParameter("length"));
        String selectedRoof = request.getParameter("roof");

        CustomProduct customProduct = new CustomProduct(selectedLength,selectedWidth,"flat",selectedRoof);

        productFacade.sendCustomRequest(customProduct);

        return REDIRECT_INDICATOR + "customflatroof";
    }
}
