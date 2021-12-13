package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.ProductFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ViewOrdersCommand extends CommandUnprotectedPage{

    ProductFacade productFacade;

    public ViewOrdersCommand(String pageToShow) {
        super(pageToShow);
        productFacade = new ProductFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {


        if (UserFacade.currentUser.getRole().equals("employee")) {

            ArrayList<Order> ordersList = productFacade.orderList();
            request.getServletContext().setAttribute("orderslist", ordersList);

            return REDIRECT_INDICATOR + "vieworderspage";
        } else {
            ArrayList<Order> myOrderList = productFacade.myOrderList(UserFacade.currentUser.getId());

            request.getServletContext().setAttribute("myorderlist", myOrderList);

            return REDIRECT_INDICATOR + "myorderspage";
        }

    }
}
