package web.commands;

import business.entities.Order;
import business.services.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SendOfferCommand extends CommandProtectedPage{

    ProductFacade productFacade;

    public SendOfferCommand(String pageToShow, String role) {
        super(pageToShow, role);
        productFacade = new ProductFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int productId = Integer.parseInt(request.getParameter("productid"));
        double offerPrice = Double.parseDouble(String.format("%.2f", Double.parseDouble(request.getParameter("offerprice"))));

        Order currentOrder = (Order) request.getServletContext().getAttribute("currentorder");

        currentOrder.setStatus("Awaits payment");

        productFacade.updateOrderStatus(currentOrder);

        productFacade.updateCustomPrice(productId,offerPrice);


        return REDIRECT_INDICATOR + "viewinfopage";
    }

}
