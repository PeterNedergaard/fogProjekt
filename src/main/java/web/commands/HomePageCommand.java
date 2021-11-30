package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageCommand extends CommandUnprotectedPage {

    public HomePageCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int viewCarPort = Integer.parseInt(request.getParameter("viewcarport"));
        String image = "";
        String paragraph = "";
        String title = "";
        String price = "";

        if (viewCarPort > 0) {
            switch (viewCarPort) {
                case 1:
                    image = "carport1.png";
                    price = "25.000,-";
                    title = "CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING";
                    paragraph = "3,60 x 5,40 mtr.\n" +
                            "Uden redskabsrum\n" +
                            "Trykimprægnerede stolper & stern.\n" +
                            "Leveres med: Søm, skruer, beslag og betontagstenstag.\n" +
                            "Udførlig byggevejledning til carport og spær medfølger.\n" +
                            "Betontagsten i sort med 30 års garanti.\n" +
                            "NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!";
                    break;
                case 2:
                    image = "carport2.png";
                    price = "31.000,-";
                    title = "CARPORT ENKELT 3,60X7,20M CAR01HR MED REDSKABSRUM 3,20X2,20M";
                    paragraph = "Enkelt carport med høj rejsning. 3,60 x 7,20 m. m/Byg-selv spær. Inkl. 3,20 x 2,25 m. redskabsrum. Højde; 3,05 mtr.\n" +
                            "Trykimprægnerede stolper, stern og beklædning.\n" +
                            "Leveres med: søm, skruer beslag og betontagstens tag.\n" +
                            "Udførlig byggevejledning til carport og spær medfølger.\n" +
                            "Betontagsten i sort med 30 års garanti.\n" +
                            "NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!\n" +
                            "Varen kan ses udstillet i følgende afdelinger:\n" +
                            "Værebro";
                    break;
                case 3:
                    image = "carport3.png";
                    price = "33.500,-";
                    title = "CARPORT ENKELT 3,60X8,10M CARL01HR MED REDSKABSRUM\n" +
                            "3,05X3,20M";
                    paragraph = "Enkelt carport med høj rejsning. 3,60 x 8,10 m. Inkl. stort redskabsrum på 3,20 x 3,05 m. . Højde: 3,05 mtr.\n" +
                            "Trykimprægnerede stolper, stern og beklædning.\n" +
                            "Leveres med: Søm, skruer, beslag og betontagstenstag.\n" +
                            "Udførlig byggevejledning til carport og spær medfølger.\n" +
                            "Betontagsten i sort med 30 års garanti.\n" +
                            "NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!";
                    break;
                case 4:
                    image = "carport4.png";
                    price = "36.000,-";
                    title = "CARPORT ENKELT 3,90X7,80M CPO01HR MED REDSKABSRUM 2,40X3,30M";
                    paragraph = "Enkelt carport med høj rejsning. 3,90 x 7,80 m.\n" +
                            "Extra bred model.\n" +
                            "3,30 x 2,40 mtr redskabsrum. Højde; 3,10 mtr.\n" +
                            "Trykimprægnerede stolper, stern og beklædning.\n" +
                            "Leveres med: Søm, skruer, beslag og betontagstenstag.\n" +
                            "Udførlig byggevejledning til carport og spær medfølger.\n" +
                            "Betontagsten i sort med 30 års garanti.\n" +
                            "NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!";
                    break;

            }

            request.getServletContext().setAttribute("image",image);
            request.getServletContext().setAttribute("price",price);
            request.getServletContext().setAttribute("title",title);
            request.getServletContext().setAttribute("paragraph",paragraph);

            return REDIRECT_INDICATOR + "showcarportpage";
        }





        return REDIRECT_INDICATOR + "filteredcarports";
    }
}
