package web.commands;

import business.entities.CustomProduct;
import business.entities.Order;
import business.entities.User;
import business.entities.WorkableMaterial;
import business.services.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ViewInfoCommand extends CommandProtectedPage {

    CalculatorFacade calculatorFacade;
    ProductFacade productFacade;
    SVGFacade svgFacade;

    public ViewInfoCommand(String pageToShow, String role) {
        super(pageToShow, role);
        calculatorFacade = new CalculatorFacade(database);
        productFacade = new ProductFacade(database);
        svgFacade = new SVGFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int selectedId = Integer.parseInt(request.getParameter("selectedid"));
        String strSumPrice;
        double totalSum = 0;
        User orderUser = null;
        ArrayList<WorkableMaterial> materialList;
        CustomProduct customProduct;
        SVG svg;
        String coveragePercentage = request.getParameter("coverage");

        if (coveragePercentage == null){
            coveragePercentage = "80";
        }


        ArrayList<Order> orderList = (ArrayList<Order>) request.getServletContext().getAttribute("orderslist");
        Order orderToShow = orderList.get(selectedId);

        customProduct = productFacade.getCustomProductById(orderToShow.getProductId());

        for (User u : UserFacade.userList) {
            if (u.getId() == orderToShow.getUserId()) {
                orderUser = u;
            }
        }

        materialList = calculatorFacade.calcCarport(customProduct.getWidth(), customProduct.getLength());


        for (WorkableMaterial wm : materialList) {
            totalSum += wm.getTotalPrice();
        }

        strSumPrice = String.format("%.2f", totalSum);

        svg = svgFacade.getSVGdrawing(customProduct.getWidth(), customProduct.getLength());

        request.getServletContext().setAttribute("productprice", customProduct.getPrice());
        request.getServletContext().setAttribute("orderstatus", orderToShow.getStatus());
        request.getServletContext().setAttribute("coveragepercentage", coveragePercentage);
        request.getServletContext().setAttribute("selectedid",selectedId);
        request.getServletContext().setAttribute("productid",customProduct.getId());
        request.getServletContext().setAttribute("currentorder",orderToShow);

        request.getServletContext().setAttribute("materiallist", materialList);
        request.getServletContext().setAttribute("customer", orderUser);
        request.getServletContext().setAttribute("customproduct", customProduct);
        request.getServletContext().setAttribute("strsumprice", strSumPrice);

        request.getServletContext().setAttribute("svgdrawing", svg.toString());


        return REDIRECT_INDICATOR + "viewinfopage";
    }
}
