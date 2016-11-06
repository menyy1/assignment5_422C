package assignment5;

import assignment5.Critter.TestCritter;
import javafx.scene.shape.*;

public class Shapemaker extends CritterGrid{

	public static Shape giveshapecolor(Critter critter,double x1, double y, Critter.CritterShape x){
		
		Shape dtshape = null;
		Polygon polygon = new Polygon();
		
		switch (x)
		{
		case CIRCLE://Initializing in position & size.
			dtshape = new Circle( x1,y,2.5);
			break;
		case SQUARE://Initializing in position & size.
			dtshape =  new Rectangle(x1,y,5,5);
			break;
		case TRIANGLE:
			polygon.getPoints().addAll(new Double[]{
			     x1, y-3,
			    x1-3, y,
			    x1+3, y});
			dtshape =  polygon;
			break;
		case DIAMOND:
			polygon.getPoints().addAll(new Double[]{
			     x1, y-3,
			     x1-3, y,
			     x1, y+3,
			     x1+3, y,
			    });
			dtshape =  polygon;
			break;
		case STAR:
			polygon.getPoints().addAll(new Double[]{
				     x1-3, y,
				     x1+3, y-2,
				     x1-3, y-2,
				     x1+3, y,
				     x1,y-4
				    });
			dtshape =  polygon;
			break;
		}
		dtshape.setStroke(critter.viewOutlineColor());
		return dtshape;
	}
}
