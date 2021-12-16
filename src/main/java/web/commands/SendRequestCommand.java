package web.commands;

import business.entities.CustomProduct;
import business.exceptions.UserException;
import business.services.ProductFacade;
import business.services.UserFacade;

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
        int selectedShedWidth = Integer.parseInt(request.getParameter("shedwidth"));
        int selectedShedLength = Integer.parseInt(request.getParameter("shedlength"));

        CustomProduct customProduct = new CustomProduct(selectedLength,selectedWidth,"flat",selectedRoof);
        customProduct.setShedLength(selectedShedLength);
        customProduct.setShedWidth(selectedShedWidth);

        UserFacade.currentUser.setOrderId(UserFacade.currentUser.getOrderId()+1);

        productFacade.sendCustomRequest(customProduct);


        return REDIRECT_INDICATOR + "customflatroof";
    }
}
