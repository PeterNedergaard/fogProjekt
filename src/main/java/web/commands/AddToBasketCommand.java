package web.commands;

import business.entities.StandardProduct;
import business.persistence.UserMapper;
import business.services.ProductFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddToBasketCommand extends CommandProtectedPage {

    public AddToBasketCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String id = (String) request.getServletContext().getAttribute("idtoaddbasket");
        int amount = Integer.parseInt(String.valueOf(request.getServletContext().getAttribute("amount")));

        for (StandardProduct sp : ProductFacade.standardProductsList) {

            if (sp.getId() == Integer.parseInt(id)) {
                for (int i = 0; i < amount; i++) {
                    UserFacade.currentUser.getMyBasketList().add(sp);
                }
                break;
            }
        }

        return REDIRECT_INDICATOR + "homepage";
    }
}
