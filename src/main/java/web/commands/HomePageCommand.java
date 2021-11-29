package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageCommand extends CommandUnprotectedPage{

    public HomePageCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {

        String viewCarPort = request.getParameter("viewcarport");
        System.out.println(viewCarPort);


        return REDIRECT_INDICATOR + "showcarport";
        //return REDIRECT_INDICATOR + "filteredcarports";
    }
}
