package web.commands;

import business.entities.Order;
import business.entities.StandardProduct;
import business.services.ProductFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class BuyOrDeleteCommand extends CommandProtectedPage{

    UserFacade userFacade;
    ProductFacade productFacade;

    public BuyOrDeleteCommand(String pageToShow, String role) {
        super(pageToShow, role);
        userFacade = new UserFacade(database);
        productFacade = new ProductFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String deleteId = request.getParameter("delete");
        String buy = request.getParameter("buy");

        if (deleteId != null){

            UserFacade.currentUser.getMyBasketList().remove(Integer.parseInt(deleteId));

            request.getServletContext().setAttribute("basketlist",UserFacade.currentUser.getMyBasketList());
        } else if(buy != null){

            for (StandardProduct sp : UserFacade.currentUser.getMyBasketList()) {
                Order order = new Order(sp.getId(),"done",UserFacade.currentUser.getId(), UserFacade.currentUser.getOrderId(),"paid");
                productFacade.addStandardProductToDb(order);
            }

            UserFacade.currentUser.setOrderId(UserFacade.currentUser.getOrderId()+1);
            UserFacade.currentUser.getMyBasketList().clear();
            userFacade.updateUserToDb(UserFacade.currentUser);

        }

        return REDIRECT_INDICATOR + "basketpage";
    }
}
