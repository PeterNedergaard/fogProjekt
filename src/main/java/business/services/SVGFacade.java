package business.services;

import business.persistence.Database;
import business.persistence.MaterialMapper;
import business.persistence.SVGMapper;

public class SVGFacade {

    SVGMapper svgMapper;

    public SVGFacade(Database database){
        svgMapper = new SVGMapper(database);
    }

    public SVG getSVGdrawing(int carportWidth, int carportLength){
        return svgMapper.getSVGdrawing(carportWidth,carportLength);
    }

}
