package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ViewOrdersCommand extends CommandProtectedPage{

    ProductFacade productFacade;

    public ViewOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
        productFacade = new ProductFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ArrayList<Order> ordersList = productFacade.orderList();

        request.getServletContext().setAttribute("orderslist", ordersList);

        return REDIRECT_INDICATOR + "vieworderspage";
    }

}
