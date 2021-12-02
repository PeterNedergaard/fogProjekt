package web.commands;

import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasketCommand extends CommandProtectedPage{

    public BasketCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        request.getServletContext().setAttribute("basketlist", UserFacade.currentUser.getMyBasketList());

        return REDIRECT_INDICATOR + "basketpage";
    }
}
