package web.commands;

import business.entities.CustomProduct;
import business.entities.Order;
import business.entities.User;
import business.entities.WorkableMaterial;
import business.services.CalculatorFacade;
import business.services.ProductFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ViewInfoCommand extends CommandProtectedPage{

    CalculatorFacade calculatorFacade;
    ProductFacade productFacade;

    public ViewInfoCommand(String pageToShow, String role) {
        super(pageToShow, role);
        calculatorFacade = new CalculatorFacade(database);
        productFacade = new ProductFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int selectedId = Integer.parseInt(request.getParameter("vieworder"));

        ArrayList<Order> orderList = (ArrayList<Order>) request.getServletContext().getAttribute("orderslist");


        Order orderToShow = orderList.get(selectedId);
        CustomProduct customProduct = productFacade.getCustomProductById(orderToShow.getProductId());
        User orderUser = null;

        for (User u : UserFacade.userList) {
            if (u.getId() == orderToShow.getUserId()){
                orderUser = u;
            }
        }

        ArrayList<WorkableMaterial> materialList = calculatorFacade.calcCarport(customProduct.getWidth(), customProduct.getLength());

        request.getServletContext().setAttribute("materiallist", materialList);
        request.getServletContext().setAttribute("customer", orderUser);
        request.getServletContext().setAttribute("customproduct", customProduct);





        return REDIRECT_INDICATOR + "viewinfopage";
    }
}
