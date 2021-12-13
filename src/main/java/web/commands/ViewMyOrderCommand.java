package web.commands;

import business.entities.CustomProduct;
import business.entities.Order;
import business.entities.WorkableMaterial;
import business.services.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ViewMyOrderCommand extends CommandProtectedPage{

    CalculatorFacade calculatorFacade;
    ProductFacade productFacade;
    SVGFacade svgFacade;

    public ViewMyOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        calculatorFacade = new CalculatorFacade(database);
        productFacade = new ProductFacade(database);
        svgFacade = new SVGFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int selectedId = Integer.parseInt(request.getParameter("selectedid"));
        ArrayList<WorkableMaterial> materialList;
        CustomProduct customProduct = null;
        String strSumPrice;
        double totalSum = 0;
        SVG svg;

        ArrayList<Order> myOrderList = (ArrayList<Order>) request.getServletContext().getAttribute("myorderlist");
        Order selectedOrder = myOrderList.get(selectedId);

        customProduct = productFacade.getCustomProductById(selectedOrder.getProductId());

        materialList = calculatorFacade.calcCarport(customProduct.getWidth(), customProduct.getLength());

        for (WorkableMaterial wm : materialList) {
            totalSum += wm.getTotalPrice();
        }

        strSumPrice = String.format("%.2f", totalSum);

        svg = svgFacade.getSVGdrawing(customProduct.getWidth(), customProduct.getLength());



        if (request.getParameter("denyoffer") != null){
            selectedOrder.setStatus("Awaits offer");
        } else if (request.getParameter("acceptoffer") != null){
            selectedOrder.setStatus("Paid");
        }
        productFacade.updateOrderStatus(selectedOrder);


        request.getServletContext().setAttribute("selectedid",selectedId);
        request.getServletContext().setAttribute("customproduct",customProduct);
        request.getServletContext().setAttribute("customer", UserFacade.currentUser);
        request.getServletContext().setAttribute("strsumprice", strSumPrice);
        request.getServletContext().setAttribute("materiallist",materialList);
        request.getServletContext().setAttribute("orderstatus",selectedOrder.getStatus());

        request.getServletContext().setAttribute("svgdrawing", svg.toString());

        return REDIRECT_INDICATOR + "viewmyorderpage";
    }

}
