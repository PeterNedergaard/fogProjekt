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

        int carportWidth = 2700;
        int carportLength = 5700;

        int shedWidth = 2400;
        int shedLength = 2700;

        int boxWidth = (carportLength/10);
        int boxHeight = (carportWidth/10);

        int viewBoxWidth = (boxWidth*3)+200;
        int viewBoxHeight = boxHeight+170;

        String viewBox = "-2 -55 " + viewBoxWidth + " " + viewBoxHeight;

        SVG svg = new SVG(0,0,viewBox,100,100);

        svg.addLine(0,0,carportLength/10,0);
        svg.addLine(carportLength/10,0,carportLength/10,carportWidth/10);
        svg.addLine(carportLength/10,carportWidth/10,0,carportWidth/10);
        svg.addLine(0,carportWidth/10,0,0);

        //Remme
        svg.addRect(0,30, 3,boxWidth);
        svg.addRect(0,boxHeight-30, 3,boxWidth);


        //redskabsskurs vægge
        svg.addRect(boxWidth-30-3, (boxHeight+5)-shedWidth/10, (shedWidth/10)-30,10);

        svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-3)-shedWidth/10, 10,(shedLength)/10);

        svg.addRect((boxWidth-30-3)-shedLength/10, (boxHeight-3)-shedWidth/10, (shedWidth/10)-30,10);

        svg.addRect((boxWidth-30-3)-shedLength/10, boxHeight-30-3, 10,(shedLength)/10);


        //carports stolper
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


        //Mål

            //vertikale linjer i bunden
        svg.addLine(0,boxHeight+10,0,boxHeight+40);
        svg.addLine(boxWidth,boxHeight+10,boxWidth,boxHeight+40);

            //horisontale linjer i siden
        svg.addLine(boxWidth+10,35,boxWidth+40,35); //closest
        svg.addLine(boxWidth+10,boxHeight-35,boxWidth+40,boxHeight-35); //closest

        svg.addLine(boxWidth+80,0,boxWidth+110,0); //farthest
        svg.addLine(boxWidth+80,boxHeight,boxWidth+110,boxHeight); //farthest


            //horisontale linjer i bunden
        svg.addLine(0,boxHeight+25,boxWidth,boxHeight+25);


            //vertikale linjer i siden
        svg.addLine(boxWidth+25,35,boxWidth+25,boxHeight-35); //closest

        svg.addLine(boxWidth+95,0,boxWidth+95,boxHeight); //farthest



        //tekst

            //nederst
        svg.addText((boxWidth)/2,boxHeight+45, String.valueOf(boxWidth) + " cm");

            //siden
        svg.addText(boxWidth+35,boxHeight/2, String.valueOf(boxHeight - 30) + " cm"); //closest
        svg.addText(boxWidth+100,boxHeight/2, String.valueOf(boxHeight) + " cm"); //farthest






        ////SVG fra siden////

        double offsetX;
        int offsetY = boxHeight/3;


        if (carportLength < 3900){
            offsetX = boxWidth * 2.5;
        } else if(carportLength >= 3900 && carportLength <= 5400){
            offsetX = boxWidth * 2;
        } else {
            offsetX = boxWidth * 1.5;
        }

        //carport

        //stolper
        if (carportLength < 4200){

            //bagerste
            svg.addRect(offsetX+boxWidth-30-3,offsetY,210,10);

            //forreste
            svg.addRect(offsetX+100-3,offsetY,210,10);


        } else {

            //bagerste
            svg.addRect(offsetX+boxWidth-30-3,offsetY,210,10);

            int postDist = carportLength/24;

            //midterste
            svg.addRect(offsetX+(boxWidth-30-3)-postDist,offsetY,210,10);

            //forreste
            svg.addRect(offsetX+(boxWidth-30-3)-postDist*2,offsetY,210,10);
        }



        //rem
        svg.addRect(offsetX,(offsetY)-20,20,boxWidth);

        //understern
        svg.addRect(offsetX,(offsetY)-40,20,boxWidth);

        //overstern
        svg.addRect(offsetX,(offsetY)-40,13,boxWidth);



        //mål

        //korte horisontale inderste
        svg.addLine(offsetX-10,offsetY,offsetX-40,offsetY); //øverste venstre
        svg.addLine(offsetX-10,(offsetY)+210,offsetX-40,(offsetY)+210); //nederste venstre

        //lang vertikal inderste
        svg.addLine(offsetX-25,offsetY,offsetX-25,(offsetY)+210);

        //tekst inderste
        svg.addText(offsetX-85,(offsetY)+105, "210 cm");



        //korte horisontale yderste
        svg.addLine((offsetX-90)-10,offsetY-40,(offsetX-120)-10,offsetY-40); //øverste venstre
        svg.addLine((offsetX-90)-10,(offsetY)+210,(offsetX-120)-10,(offsetY)+210); //nederste venstre

        //lang vertikal yderste
        svg.addLine(offsetX-115,offsetY-40,offsetX-115,(offsetY)+210);

        //tekst yderste
        svg.addText(offsetX-175,(offsetY)+105, "250 cm");



        //skur

        svg.addRect((offsetX+boxWidth-30)+5,(offsetY),210,10);


        //tallet 174mm kommer fra at der skal være 7,4 cm mellemrum mellem hver planke for at overlappe. Hver planke er 10 cm bred
        int amountCladding = shedLength/174;

        double shedX = (offsetX+boxWidth-30)+5;

        for (int i = 0; i < amountCladding; i++) {

            //yderste lag planker
            svg.addRect(shedX,(offsetY),210,10);

            //inderste lag planker
            svg.addRect(shedX-7,(offsetY),210,10);

            shedX -= 17.4;
        }



        //mål

        //vertikale linjer

        //højre
        svg.addLine(((offsetX+boxWidth)-30)+15,(offsetY+210)+10,(offsetX+boxWidth-30)+15,(offsetY+210)+40);

        //venstre
        svg.addLine((offsetX+boxWidth-5)-shedLength/10,(offsetY+210)+10,(offsetX+boxWidth-5)-shedLength/10,(offsetY+210)+40);


        //horisontal linje
        svg.addLine((offsetX+boxWidth-5)-shedLength/10,(offsetY+210)+25,(offsetX+boxWidth-30)+15,(offsetY+210)+25);


        //tekst
        svg.addText((offsetX+boxWidth)-(shedLength/10)/2,(offsetY+210)+45, shedLength/10 + " cm");




        request.getServletContext().setAttribute("svgdrawing", svg.toString());
        return REDIRECT_INDICATOR + "svgpage";
    }

}
