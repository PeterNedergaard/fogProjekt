package web.commands;

import business.entities.User;
import business.persistence.Database;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;

    public RegisterCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        int telephone = Integer.parseInt(request.getParameter("tlf"));
        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String houseNum = request.getParameter("housenum");


        if (password1.equals(password2))
        {
            User user = userFacade.createUser(email, password1, telephone, zipcode, city, street, houseNum);
            /*HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());*/
            return "loginpage";
        }
        else
        {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }
    }

}
