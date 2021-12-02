package web.commands;

import business.entities.StandardProduct;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class BuyOrDeleteCommand extends CommandProtectedPage{

    public BuyOrDeleteCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String deleteId = request.getParameter("delete");

        if (deleteId != null){

            UserFacade.currentUser.getMyBasketList().remove(Integer.parseInt(deleteId));

            request.getServletContext().setAttribute("basketlist",UserFacade.currentUser.getMyBasketList());
        }

        return REDIRECT_INDICATOR + "basketpage";
    }
}
