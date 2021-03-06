package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database)
    {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("homepagecommand", new HomePageCommand(""));
        commands.put("showcarportpage", new CommandUnprotectedPage("showcarportpage"));
        commands.put("indexcommand", new IndexCommand(""));
        commands.put("homepage", new CommandUnprotectedPage("homepage"));
        commands.put("basketcommand", new BasketCommand("","customer"));
        commands.put("basketpage", new CommandProtectedPage("basketpage","customer"));
        commands.put("addtobasketcommand", new AddToBasketCommand("","customer"));
        commands.put("buyordeletecommand", new BuyOrDeleteCommand("","customer"));
        commands.put("customproductcommand", new CustomProductCommand("","customer"));
        commands.put("customflatroof", new CommandProtectedPage("customflatroof","customer"));
        commands.put("customangleroof", new CommandProtectedPage("customangleroof","customer"));
        commands.put("sendrequestcommand", new SendRequestCommand("","customer"));
        commands.put("vieworderscommand", new ViewOrdersCommand(""));
        commands.put("vieworderspage", new CommandProtectedPage("vieworderspage","employee"));
        commands.put("viewinfocommand", new ViewInfoCommand("","employee"));
        commands.put("viewinfopage", new CommandProtectedPage("viewinfopage","employee"));
        commands.put("svgpage", new CommandUnprotectedPage("svgpage"));
        commands.put("svgcommand", new SVGCommand(""));
        commands.put("sendoffercommand", new SendOfferCommand("","employee"));
        commands.put("myorderspage", new CommandProtectedPage("myorderspage","customer"));
        commands.put("viewmyordercommand", new ViewMyOrderCommand("","customer"));
        commands.put("viewmyorderpage", new CommandProtectedPage("viewmyorderpage","customer"));
    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;

}
