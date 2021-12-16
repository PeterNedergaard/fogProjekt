package business.services;

public class SVG {


    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewbox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg height=\"%s%%\"" +
            "<svg width=\"%s%%\"" +
            "viewbox=\"%s\"" +
            "x=\"%s\" " +
            "y=\"%s\" " +
            "preserverAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%f\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; fill: #ffffff\"/>";
    private final String lineTemplate = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:rgb(0,0,0);stroke-width:2\" />";
    private final String textTemplate = "<text x=\"%f\" y=\"%f\" fill=\"black\">%s</text>";

    public SVG(int x, int y, String viewbox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewbox = viewbox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width,viewbox, x, y));
    }

    public void addRect(double x, int y, int height, int width){
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addLine(double x1, double y1, double x2, double y2){
        svg.append(String.format(lineTemplate, x1, y1, x2, y2));
    }

    public void addText(double x, double y, String text){
        svg.append(String.format(textTemplate,x,y,text));
    }

    public void addSvg(SVG innerSVG){
        svg.append(innerSVG.toString());
    }


    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }


}
