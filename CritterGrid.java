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
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class CritterGrid {
	
	public static void gridmaker(GridPane grid){
		
		List<Critter> population= new ArrayList<Critter>(TestCritter.getPopulation());
		
		List<Shape> crittershape = new java.util.ArrayList<Shape>();
		
		grid.getChildren().clear();
		
		for(int i=0; i<population.size(); i++)
		{
			Critter temp = population.get(i);
			int y[] = TestCritter.getposition(temp);
			crittershape.add(Shapemaker.giveshapecolor(temp,y[0],y[1], temp.viewShape()));
//			GridPane.setConstraints(crittershape.get(i), y[0],y[1],0,0,1,1);
			//GridPane.setConstraints(crittershape.get(i), y[0],y[1],1,1);
			grid.add(crittershape.get(i), y[0],y[1]);
		}
		
	}
	
	public static void intializegrid(GridPane grid){
		
		Shape dtshape = null;
		grid.setPadding(new Insets(30,10,10,10));
		grid.getRowConstraints().add(new RowConstraints(5));
		
		for (int i=0; i<Params.world_width; i++)
		{
		grid.getColumnConstraints().add(new ColumnConstraints(5));
		}
		for (int i=0; i<Params.world_height; i++)
		{
		grid.getRowConstraints().add(new RowConstraints(5));
		}
		for (int i=0; i<Params.world_width; i++)
		{
			for (int j=0; j<Params.world_height; j++)
				{
					dtshape = new Rectangle(10,10);
					dtshape.setFill(Color.WHITE);
					grid.add(dtshape,i, j);
				}
			}
		//grid.setGridLinesVisible(true);
		
	}
	
	public static void removercritter(Critter index)
	{
		Main.grid.getChildren().remove(index);
	}
	

}
