package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public LoginCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userFacade.login(email, password);

            UserFacade.currentUser = user;

            if (UserFacade.userList.size() < 1){
                UserFacade.userList = userFacade.getUserList();
            }

            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", email);

            String pageToShow = "";

            if (user.getRole().equals("customer")) {
                pageToShow = "index";
            } else if (user.getRole().equals("employee")) {
                pageToShow = "employeepage";
            }

            return REDIRECT_INDICATOR + pageToShow;
        } catch (UserException | SQLException ex) {
            request.setAttribute("error", "Wrong username or password!");
            return "loginpage";
        }
    }

}
