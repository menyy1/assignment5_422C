package assignment5;

import java.lang.reflect.InvocationTargetException;

import assignment5.Critter.TestCritter;
import assignment5.Critter;
import assignment5.InvalidCritterException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Circle; 
import javafx.scene.shape.Rectangle; 
import javafx.scene.shape.Shape;

public class Main extends Application { 
	static GridPane grid = new GridPane();
	final Label title = new Label("\t\t\tTeam 60 Controller");
	final Label makeLabel = new Label("Make:");
	final Label stepLabel = new Label("Step:");
	final Label seedLabel = new Label("Seed:");
	final Label statsLabel = new Label("Stats:");
	private boolean flag;
	@Override 
	public void start(Stage primaryStage) {
		try {
			 Pane root = new Pane();

		        StackPane holder = new StackPane();
		        Canvas canvas = new Canvas(350,  400);

		        holder.getChildren().add(canvas);
		        root.getChildren().add(holder);

		        holder.setStyle("-fx-background-color: blanchedalmond");
		        
			grid.setGridLinesVisible(true);
			Scene scene = new Scene(root); 
			primaryStage.setScene(scene);
			primaryStage.show(); // Paints the icons. Painter.paint();
			primaryStage.setWidth(350);
		    primaryStage.setHeight(400);
			VBox vb = new VBox();
			
			final ChoiceBox<String> make = new ChoiceBox<String>(FXCollections.observableArrayList("Craig", "Algae", "Algaephobic", "Critter1", "Critter2"));
			make.setTooltip(new Tooltip("Select the critter"));
			make.setValue("Craig");
			TextField numMakes = new TextField();
			numMakes.setPrefColumnCount(5);
			Button makeBtn = new Button("OK");
			HBox hb = new HBox();
		    hb.getChildren().addAll(makeLabel, make, numMakes, makeBtn);
		    hb.setSpacing(10);
		    hb.setAlignment(Pos.BASELINE_LEFT);
		    hb.setPadding(new Insets(1, 0, 0, 10));
		    
			TextField numSteps = new TextField();
			numSteps.setPrefColumnCount(5);
			Button stepsBtn = new Button("OK");
			HBox hb1 = new HBox();
		    hb1.getChildren().addAll(stepLabel, numSteps, stepsBtn);
		    hb1.setSpacing(10);
		    hb1.setAlignment(Pos.BASELINE_LEFT);
		    hb1.setPadding(new Insets(5, 0, 0, 10));
		    
		    TextField numSeed = new TextField();
			numSeed.setPrefColumnCount(5);
			Button seedBtn = new Button("OK");
			HBox hb2 = new HBox();
		    hb2.getChildren().addAll(seedLabel, numSeed, seedBtn);
		    hb2.setSpacing(10);
		    hb2.setAlignment(Pos.BASELINE_LEFT);
		    hb2.setPadding(new Insets(5, 0, 0, 10));
		    
		    final ChoiceBox<String> stats = new ChoiceBox<String>(FXCollections.observableArrayList("Craig", "Algae", "Algaephobic", "Critter1", "Critter2"));
			stats.setTooltip(new Tooltip("Select the critter"));
			stats.setValue("Craig");
			Button statsBtn = new Button("OK");
			HBox hb3 = new HBox();
		    hb3.getChildren().addAll(statsLabel, stats, statsBtn);
		    hb3.setSpacing(10);
		    hb3.setAlignment(Pos.BASELINE_LEFT);
		    hb3.setPadding(new Insets(5, 0, 0, 10));
		    
		    Button runAnimation = new Button("Run Animation");
		    Button stop = new Button("Stop!");
		    HBox hb4 = new HBox();
		    hb4.getChildren().addAll(runAnimation, stop);
		    hb4.setSpacing(40);
		    hb4.setAlignment(Pos.CENTER);
		    hb4.setPadding(new Insets(25, 0, 0, 10));
		    
		    vb.getChildren().addAll(title, new Separator(), hb, hb1, hb2, hb3, hb4);
		    vb.setSpacing(20);
		    vb.setAlignment(Pos.BASELINE_LEFT);
		    vb.setPadding(new Insets(10, 0, 0, 5));
		    
		    makeBtn.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e){
		    		if(numMakes.getText() != null && !numMakes.getText().isEmpty()){
		    			int x = 0;
        				try{
        					x= Integer.parseInt(numMakes.getText());
        				}catch(NumberFormatException e1){
        					System.out.println("Please insert a number");
        				}
        				for(int i = 0; i<x; i++)
							try {
								Critter.makeCritter(make.getValue());
							} catch (InstantiationException e1) {
								
							} catch (IllegalAccessException e1) {
								
							} catch (InvalidCritterException e1) {
								
							}
		    		}
		    		else
		    			System.out.println("Please insert a number");
		    	}
		    });
		    
		    statsBtn.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e2){
		    		try {
						Critter.runStats(Critter.getInstances(stats.getValue()));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| InstantiationException | InvalidCritterException e) {
					}
		    	}
		    });
		    
		    stepsBtn.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e3){
		    		if(numSteps.getText() != null && !numSteps.getText().isEmpty()){
		    			int x = 0;
        				try{
        					x= Integer.parseInt(numSteps.getText());
        				}catch(NumberFormatException e1){
        					System.out.println("Please insert a number");
        				}
        				for (int i=0; i<x; i++)
							TestCritter.worldTimeStep();
		    		}
		    		else
		    			System.out.println("Please insert a number");
		    	}
		    });
		    
		    seedBtn.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e4){
		    		if(numSeed.getText() != null && !numSeed.getText().isEmpty()){
		    			int x = 0;
        				try{
        					x= Integer.parseInt(numSeed.getText());
        				}catch(NumberFormatException e1){
        					System.out.println("Please insert a number");
        				}
        				Critter.setSeed(x);
		    		}
		    		else
		    			System.out.println("Please insert a number");
		    	}
		    });
		    
		    
		    runAnimation.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e5){
		    		flag = true;
		    	}
		    });

		    stop.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e6){
		    		flag = false;
		    	}
		    });
		   

		    ((Pane) scene.getRoot()).getChildren().addAll(vb);
		    
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
	} 
	
	public static void main(String[] args) {
		launch(args);
	}
	

	/*  * Returns a square or a circle, according to shapeIndex  */ 
	static Shape getIcon(int shapeIndex) {
		Shape s = null; int size = 100;
		switch(shapeIndex) { 
			case 0: 
				s = new Rectangle(size, size);
				s.setFill(javafx.scene.paint.Color.RED); 
				break;
			case 1: 
				s = new Circle(size/2);
				s.setFill(javafx.scene.paint.Color.GREEN); 
				break;
			} // set the outline of the shape 
		s.setStroke(javafx.scene.paint.Color.BLUE); // outline 
		return s;
		}
		/*  * Paints the shape on a grid.  */ 
	public static void paint() {
		Main.grid.getChildren().clear(); // clean up grid. 
		for (int i = 0; i <= 1; i++) {
			Shape s = getIcon(i); // convert the index to an icon. 
			Main.grid.add(s, i, i); // add the shape to the grid.
		}
	}
}
