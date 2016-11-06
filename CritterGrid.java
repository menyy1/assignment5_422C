package assignment5;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


import assignment5.Critter.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class CritterGrid {
	
	public static void gridmaker(GridPane grid){
		
		
		List<Critter> population= new ArrayList<Critter>(TestCritter.getPopulation());
		//Label label1[];
		List<Shape> crittershape = new java.util.ArrayList<Shape>();
		
		for(int i=0; i<population.size(); i++)
		{
			Critter temp = population.get(i);
			int y[] = TestCritter.getposition(temp);
			crittershape.add(Shapemaker.giveshapecolor(temp,y[0],y[1], temp.viewShape()));
			grid.add(crittershape.get(i), y[0],y[1]);
		}
		
	}
	

}
