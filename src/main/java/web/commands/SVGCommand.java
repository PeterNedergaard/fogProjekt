package web.commands;

import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SVGCommand extends CommandUnprotectedPage{

    public SVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        int carportWidth = 2400;
        int carportLength = 3900;

        int boxWidth = carportLength/10;
        int boxHeight = carportWidth/10;

        String viewbox = "0 0 " + boxWidth + boxHeight;

        SVG svg = new SVG(0,0,viewbox,100,100);

        svg.addLine(0,0,carportLength/10,0);
        svg.addLine(carportLength/10,0,carportLength/10,carportWidth/10);
        svg.addLine(carportLength/10,carportWidth/10,0,carportWidth/10);
        svg.addLine(0,carportWidth/10,0,0);

        //Remme
        svg.addRect(0,35, 3,boxWidth);
        svg.addRect(0,boxHeight-35, 3,boxWidth);


        //Stolper
        if (carportLength < 4200){
            //bagerste
            svg.addRect(boxWidth-30-3,35-3,10,10);
            svg.addRect(boxWidth-30-3,boxHeight-35-3,10,10);

            //forreste
            svg.addRect(100-3,35-3,10,10);
            svg.addRect(100-3,boxHeight-35-3,10,10);


        } else {
            //bagerste
            svg.addRect(boxWidth-30-3,35-3,10,10);
            svg.addRect(boxWidth-30-3,boxHeight-35-3,10,10);

            int postDist = carportLength/24;

            //øverste
            svg.addRect((boxWidth-30-3)-postDist,35-3,10,10);
            svg.addRect((boxWidth-30-3)-postDist*2,35-3,10,10);

            //nederste
            svg.addRect((boxWidth-30-3)-postDist,boxHeight-35-3,10,10);
            svg.addRect((boxWidth-30-3)-postDist*2,boxHeight-35-3,10,10);
        }




        //Spær
        svg.addRect(0,0,boxHeight,3);
        svg.addRect(boxWidth-3,0,boxHeight,3);

        double interval = 300;

        double length = carportLength-interval;

        double amount = length/interval;

        double x = interval/10;

        for (int i = 0; i < amount; i++) {
            svg.addRect(x,0,boxHeight,3);
            x += interval/10;
        }

        //Mållinjer

            //vertical lines bottom
        svg.addLine(0,boxHeight+10,0,boxHeight+40);
        svg.addLine(boxWidth,boxHeight+10,boxWidth,boxHeight+40);

            //vertical lines side
        svg.addLine(boxWidth+10,35,boxWidth+40,35); //closest
        svg.addLine(boxWidth+10,boxHeight-35,boxWidth+40,boxHeight-35); //closest

        svg.addLine(boxWidth+80,0,boxWidth+110,0); //farthest
        svg.addLine(boxWidth+80,boxHeight,boxWidth+110,boxHeight); //farthest


            //horizontal line bottom
        svg.addLine(0,boxHeight+25,boxWidth,boxHeight+25);


            //horizontal line side
        svg.addLine(boxWidth+25,35,boxWidth+25,boxHeight-35); //closest

        svg.addLine(boxWidth+95,0,boxWidth+95,boxHeight); //farthest



        //text

            //bottom
        svg.addText((boxWidth)/2,boxHeight+45, String.valueOf(boxWidth) + " cm");

            //side
        svg.addText(boxWidth+35,boxHeight/2, String.valueOf(boxHeight - 70) + " cm"); //closest
        svg.addText(boxWidth+100,boxHeight/2, String.valueOf(boxHeight) + " cm"); //farthest





        request.getServletContext().setAttribute("svgdrawing", svg.toString());
        return REDIRECT_INDICATOR + "svgpage";
    }

}
