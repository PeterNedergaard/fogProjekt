package business.persistence;

import business.services.MaterialFacade;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SVGMapper {

    Database database;

    public SVGMapper(Database database) {
        this.database = database;
    }


    public SVG getSVGdrawing(int carportWidth, int carportLength){

        int boxWidth = carportLength/10;
        int boxHeight = carportWidth/10;

        int viewboxWidth = boxWidth+154;
        int viewboxHeight = boxHeight+105;

        String viewbox = "-2 -55 " + viewboxWidth + " " + viewboxHeight;

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
        int intervalInt = (int) interval/10;

        double length = carportLength-interval;

        double amount = length/interval;

        double x = interval/10;

        double prevX = 0;
        double lineY = -25;


        //Statiske lodrette linjer i start og slut
        svg.addLine(1.5,lineY+15,1.5,lineY-15);
        svg.addLine(boxWidth-1.5,lineY+15,boxWidth-1.5,lineY-15);

        svg.addText((interval/10)/4,lineY-15, String.valueOf(intervalInt));

        for (int i = 0; i < amount; i++) {
            //Spær
            svg.addRect(x,0,boxHeight,3);

            //Lodret linje
            svg.addLine(x+1.5,lineY+15,x+1.5,lineY-15);

            svg.addText(x+((interval/10)/4),lineY-15, String.valueOf(intervalInt));

            prevX = x;

            x += interval/10;
        }

        //Vandret linje fra start til slut
        svg.addLine(1.5,lineY,boxWidth-1.5,lineY);



        //Mållinjer

        //small lines bottom
        svg.addLine(0,boxHeight+10,0,boxHeight+40);
        svg.addLine(boxWidth,boxHeight+10,boxWidth,boxHeight+40);

        //small lines side
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

        return svg;
    }

}
