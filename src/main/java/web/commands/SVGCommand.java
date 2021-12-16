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

        int carportWidth = 5300;
        int carportLength = 6900;

        int shedWidth = 5000;
        int shedLength = 2100;

        int boxWidth = (carportLength/10);
        int boxHeight = (carportWidth/10);

        int viewBoxWidth = boxWidth+110;
        int viewBoxHeight = boxWidth+50;

        String viewbox = "0 -55 " + viewBoxWidth + " " + viewBoxHeight;

        SVG svg = new SVG(0,0,viewbox,100,100);

        svg.addLine(0,0,carportLength/10,0);
        svg.addLine(carportLength/10,0,carportLength/10,carportWidth/10);
        svg.addLine(carportLength/10,carportWidth/10,0,carportWidth/10);
        svg.addLine(0,carportWidth/10,0,0);

        //Remme
        svg.addRect(0,30, 3,boxWidth);
        svg.addRect(0,boxHeight-30, 3,boxWidth);


        //carports  tolper
        if (carportLength < 4200){

            //bagerste
            svg.addRect(boxWidth-30-3,30-3,10,10);
            svg.addRect(boxWidth-30-3,boxHeight-30-3,10,10);

            //forreste
            svg.addRect(100-3,30-3,10,10);
            svg.addRect(100-3,boxHeight-30-3,10,10);


        } else {
            //bagerste
            svg.addRect(boxWidth-30-3,30-3,10,10);
            svg.addRect(boxWidth-30-3,boxHeight-30-3,10,10);

            int postDist = carportLength/24;

            //øverste
            svg.addRect((boxWidth-30-3)-postDist,30-3,10,10);
            svg.addRect((boxWidth-30-3)-postDist*2,30-3,10,10);

            //nederste
            svg.addRect((boxWidth-30-3)-postDist,boxHeight-30-3,10,10);
            svg.addRect((boxWidth-30-3)-postDist*2,boxHeight-30-3,10,10);
        }


        //redskabsskurs stolper
        if (shedWidth > 0 || shedLength > 0) {

            int udhaengSum = 300;


            if (shedWidth < (carportWidth - udhaengSum)) {

                //øverste højre
                svg.addRect(boxWidth-30-3, (boxHeight-3)-shedWidth/10, 10,10);

                //øverste venstre
                svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-3)-shedWidth/10, 10,10);

                //nederste venstre
                svg.addRect((boxWidth-30-3)-shedLength/10, boxHeight-30-3, 10,10);

            } else if (shedWidth == carportWidth - udhaengSum) {

                //øverste venstre
                svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-3)-shedWidth/10, 10,10);

                //nederste venstre
                svg.addRect((boxWidth-30-3)-shedLength/10, boxHeight-30-3, 10,10);
            }

            if (shedWidth > 4200) {
                //miderste
                svg.addRect(boxWidth-30-3, (boxHeight-30)-(shedWidth/10)/2, 10,10);
                svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-30)-(shedWidth/10)/2, 10,10);
            }


            /*if (shedWidth > 4200) {

                if (shedWidth < (carportWidth - udhaengSum)) {

                    //øverste højre
                    svg.addRect(boxWidth-30-3, (boxHeight-35)-shedWidth/10, 10,10);

                    //øverste venstre
                    svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-35)-shedWidth/10, 10,10);

                    //nederste venstre
                    svg.addRect((boxWidth-30-3)-shedLength/10, boxHeight-35-3, 10,10);

                    //miderste
                    svg.addRect(boxWidth-30-3, (boxHeight-35)-(shedWidth/10)/2, 10,10);
                    svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-35)-(shedWidth/10)/2, 10,10);

                } else if (shedWidth == carportWidth - udhaengSum) {

                    //øverste venstre
                    svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight+2)-shedWidth/10, 10,10);

                    //nederste venstre
                    svg.addRect((boxWidth-30-3)-shedLength/10, boxHeight-35-3, 10,10);

                    //miderste
                    svg.addRect(boxWidth-30-3, (boxHeight-35)-(shedWidth/10)/2, 10,10);
                    svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-35)-(shedWidth/10)/2, 10,10);

                }

            } else {

                if (shedWidth < (carportWidth - udhaengSum)) {

                    //øverste højre
                    svg.addRect(boxWidth-30-3, (boxHeight-35)-shedWidth/10, 10,10);

                    //øverste venstre
                    svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-35)-shedWidth/10, 10,10);

                    //nederste venstre
                    svg.addRect((boxWidth-30-3)-shedLength/10, boxHeight-35-3, 10,10);

                } else if (shedWidth == carportWidth - udhaengSum) {

                    //øverste venstre
                    svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight+2)-shedWidth/10, 10,10);

                    //nederste venstre
                    svg.addRect((boxWidth-30-3)-shedLength/10, boxHeight-35-3, 10,10);

                }

            }*/
        }




        //Spær
        svg.addRect(0,0,boxHeight,3);
        svg.addRect(boxWidth-3,0,boxHeight,3);

        double interval = 300;
        int intervalInt = (int) interval/10;

        double length = carportLength-interval;

        double amount = length/interval;

        double x = interval/10;

        double prevX = 0;
        double lineY = -25;

        svg.addLine(0,lineY+15,0,lineY-15);
        svg.addLine(boxWidth,lineY+15,boxWidth,lineY-15);

        svg.addText((interval/10)/5,lineY-15, String.valueOf(intervalInt));

        for (int i = 0; i < amount; i++) {
            svg.addRect(x,0,boxHeight,3);

            svg.addLine(x,lineY+15,x,lineY-15);

            svg.addText(x+((interval/10)/5),lineY-15, String.valueOf(intervalInt));

            prevX = x;

            x += interval/10;
        }

        svg.addLine(0,lineY,boxWidth,lineY);


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
