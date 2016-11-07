package assignment5;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import assignment5.Critter.TestCritter;
import assignment5.Critter;
import assignment5.InvalidCritterException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Circle; 
import javafx.scene.shape.Rectangle; 
import javafx.scene.shape.Shape;

public class Main extends Application { 
	static GridPane grid = new GridPane();
	private static String myPackage;
	final Label title = new Label("\t\t\tTeam 60 Controller");
	final Label makeLabel = new Label("Make:");
	final Label stepLabel = new Label("Step:");
	final Label seedLabel = new Label("Seed:");
	final Label statsLabel = new Label("Stats:");
	final Label entryError = new Label("Please insert a number");
	private boolean flag;
	static Label ranimation = new Label("Running Animation...");
	static Pane root = new Pane();
	static List<String> meco = new ArrayList<String>();
	static PrintStream old = System.out;	// if you want to restore output to console
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    static Label console = new Label("Console: ");
    static Timeline beat = new Timeline();
    static VBox vb2 = new VBox();
    static StackPane dummy = new StackPane();
	Console cnsl = null;
	
	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
		static {
			myPackage = Critter.class.getPackage().toString().split(" ")[1];
		}
		
	@Override 
	public void start(Stage primaryStage) {
		try {
			BorderPane rootPane = new BorderPane();

            grid.setPrefSize(50, 50);
            grid.setMaxHeight(50);
            grid.setMaxWidth(50);
            
            //////////////////////////////
			File folder = new File("src/" + myPackage);
			File[] listOfFiles = folder.listFiles();
			String[] pedo = new String[listOfFiles.length];
			int cnt = 0;
			for(int i = 0; i<listOfFiles.length; i++){
				String equis = listOfFiles[i].getName().replace(".java", "");
				Critter check = null;
				try{
					check = (Critter) Class.forName(new String(myPackage+"."+equis)).newInstance();
				}catch(ClassNotFoundException e){
					continue;
				}
				catch(InstantiationException e){
					continue;
				}
				catch(ClassCastException e){
					continue;
				}
				if(check instanceof Critter)
					pedo[cnt] = equis;
				cnt++;
			}
			String[] loco = new String[cnt];
			for(int j = 0; j< cnt; j++){
				loco[j] = pedo[j];
			}
			/////////////////////////////////////////////
			ScrollPane root2 = new ScrollPane();
			vb2.getChildren().add(console);
			vb2.setAlignment(Pos.BASELINE_LEFT);
			vb2.setPadding(new Insets(3, 0 , 0, 10));
			root2.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			
			root2.setPrefSize(200, 100);

		        StackPane holder = new StackPane();
		        Canvas canvas = new Canvas(375,  500);

		        holder.getChildren().add(canvas);
		        root.getChildren().add(holder);

		        holder.setStyle("-fx-background-color: blanchedalmond");
		        
			
			//////////////////////////////////////////////////
			testOutputString = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(testOutputString);
            // Save the old System.out.
            old = System.out;
            // Tell Java to use the special stream; all console output will be redirected here from now
            System.setOut(ps);
			////////////////////////////////////////
			Scene scene = new Scene(root); 
			
		    
           Stage stage1 = new Stage();
           
          Scene scene1 = new Scene(root2);
           /* for(int i = 0; i<grid.getMaxWidth(); i++){
			    ColumnConstraints cc = new ColumnConstraints(6);
			    cc.setHgrow(Priority.ALWAYS);
			    grid.getColumnConstraints().add(cc);
            }
			for(int j = 0; j<grid.getMaxHeight(); j++){
			    RowConstraints rc = new RowConstraints(6);
			    rc.setVgrow(Priority.ALWAYS);
			    grid.getRowConstraints().add(rc);
			}*/
            
			
			Scene scene2 = new Scene(grid);//this scene is for animation
		    
			
			
			VBox vb = new VBox();
			
			
			
			final ChoiceBox<String> make = new ChoiceBox<String>(FXCollections.observableArrayList(loco));
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
		    
		    final ChoiceBox<String> stats = new ChoiceBox<String>(FXCollections.observableArrayList(loco));
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
	    			vb.getChildren().remove(entryError);
		    		if(numMakes.getText() != null && !numMakes.getText().isEmpty()){
		    			int x = 0;
        				try{
        					x= Integer.parseInt(numMakes.getText());
        				}catch(NumberFormatException e1){
        					vb.getChildren().addAll(entryError);
        				}
        				for(int i = 0; i<x; i++)
							try {
								Critter.makeCritter(make.getValue());
							} catch (InstantiationException e1) {
								
							} catch (IllegalAccessException e1) {
								
							} catch (InvalidCritterException e1) {
								
							}
        				makegrid();
		    		}
		    		else{
		    			vb.getChildren().addAll(entryError);
		    		}
		    		numMakes.clear();
		    	}
		    });
		    
		    statsBtn.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e2){
		    		try {
		    			vb2.getChildren().clear();
						Critter.runStats(Critter.getInstances(stats.getValue()));
		    			Label lbl = new Label(testOutputString.toString());
			    		//vb2.getChildren().removeAll(lbl);
						vb2.getChildren().addAll(console, lbl);
		    			vb2.setSpacing(10);
		    			vb2.setAlignment(Pos.BASELINE_LEFT);
		    			vb2.setPadding(new Insets(3, 0 , 0, 10));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| InstantiationException | InvalidCritterException e) {
					}

		    		testOutputString.reset();
		    	}
		    });
		    
		    stepsBtn.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e3){
		    		vb.getChildren().remove(entryError);
		    		if(numSteps.getText() != null && !numSteps.getText().isEmpty()){
		    			int x = 0;
        				try{
        					x= Integer.parseInt(numSteps.getText());
        				}catch(NumberFormatException e1){
        					vb.getChildren().addAll(entryError);
        				}
        				for (int i=0; i<x; i++)
							TestCritter.worldTimeStep();
        				makegrid();
		    		}
		    		else{
		    			vb.getChildren().addAll(entryError);
		    		}
		    		numSteps.clear();
		    	}
		    });
		    
		    seedBtn.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e4){
		    		vb.getChildren().remove(entryError);
		    		if(numSeed.getText() != null && !numSeed.getText().isEmpty()){
		    			int x = 0;
        				try{
        					x= Integer.parseInt(numSeed.getText());
        				}catch(NumberFormatException e1){
        					vb.getChildren().addAll(entryError);
        				}
        				Critter.setSeed(x);
		    		}
		    		else{
		    			vb.getChildren().addAll(entryError);
		    		}
		    		numSeed.clear();
		    	}
		    });
		    
		    
		    runAnimation.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e5){
		    		animateUsingTimeline(grid, loco);
		    	}
		    });

		    stop.setOnAction(new EventHandler<ActionEvent>(){
		    	@Override
		    	public void handle(ActionEvent e6){
		    		try{
		    			vb2.getChildren().clear();
			    		vb2.getChildren().add(new Label("Animation paused..."));
		    			//vb2.setSpacing(10);
		    			vb2.setAlignment(Pos.BASELINE_LEFT);
		    			vb2.setPadding(new Insets(30, 0 , 0, 5));
		    			beat.pause();
		    		}catch(Exception e){
		    			
		    		}
		    	}
		    });
		    
		  /* javafx.application.Platform.runLater(new Runnable() {

		        @Override
		        public void run() {
		            stage1.setScene(scene1);
		            stage1.show();
		            stage1.setWidth(400);
		            stage1.setHeight(200);
		        }
		    });
		    */
		   ((Pane) scene.getRoot()).getChildren().addAll(vb);
		   ((ScrollPane) scene1.getRoot()).setContent(vb2);
		   
		   //Stage stage2 = new Stage();
	       
		   /*javafx.application.Platform.runLater(new Runnable(){
		    
		    @Override
		    public void run(){
		    stage2.setScene(scene2);
		    stage2.show();
		    stage2.setWidth(300);
		    stage2.setHeight(300);
		    stage2.setMaxHeight(300);
		    stage2.setMaxWidth(300);
		    stage2.setResizable(false);
		    }
		   });*/
		   
		   
		   
		   grid.setPrefSize(800, 500);
           grid.setMaxHeight(500);
           grid.setMaxWidth(1335);
           
           dummy.getChildren().addAll(root2);
           dummy.setAlignment(Pos.TOP_LEFT);
		  //root2.getChildren().add(dummy);
		   
		   Scene sceneFinal = new Scene(rootPane);
		 //  Stage stage3 = new Stage();
		   /*
		   javafx.application.Platform.runLater(new Runnable(){
			    
			    @Override
			    public void run(){
			    stage3.setScene(sceneFinal);
			    stage3.show();
			    stage3.setWidth(1335);
			    stage3.setHeight(600);
			    stage3.setResizable(false);
			    }
			   });*/
		   
		   rootPane.setLeft(root);
		   rootPane.setBottom(dummy);
		   rootPane.setCenter(grid);
		   rootPane.setStyle("-fx-background-color: aliceblue");
		   rootPane.getCenter().setStyle("-fx-background-color: aliceblue");
		  // grid.setGridLinesVisible(true);
		   
           
           primaryStage.setScene(sceneFinal);
			primaryStage.show(); // Paints the icons. Painter.paint();
			primaryStage.setTitle("Grid World");
			primaryStage.sizeToScene();
			//primaryStage.setWidth(1000);
		    //primaryStage.setHeight(600);
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(700);
		    primaryStage.setMaxHeight(600);
		    primaryStage.setMaxWidth(1335);
		    
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
	} 
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void makegrid(){        
		CritterGrid.gridmaker(grid);
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
	
public static void animateUsingTimeline(GridPane grid, String[] loco) {
	
					beat = new Timeline(
							new KeyFrame(Duration.ZERO,         event -> Critter.worldTimeStep()),
							new KeyFrame(Duration.ZERO,         event -> givemethestats(loco)),
					        new KeyFrame(Duration.ZERO,         event -> CritterGrid.gridmaker(grid)),
					        new KeyFrame(Duration.seconds(1.0), event -> Critter.worldTimeStep()),
					        new KeyFrame(Duration.seconds(1.0), event -> CritterGrid.gridmaker(grid)),
					        new KeyFrame(Duration.seconds(1.0), event -> givemethestats(loco))
					    );
		
			
	        beat.setAutoReverse(true);
	        beat.setCycleCount(Timeline.INDEFINITE);
	        beat.play();
	}
	public static void givemethestats(String[] x){
		try {
			
			vb2.getChildren().clear();
			vb2.getChildren().add(console);
			vb2.setSpacing(5);
			vb2.setAlignment(Pos.BASELINE_LEFT);
			vb2.setPadding(new Insets(3, 0 , 0, 5));
			vb2.getChildren().add(ranimation);
			vb2.setSpacing(5);
			vb2.setAlignment(Pos.BASELINE_LEFT);
			vb2.setPadding(new Insets(3, 0 , 0, 5));
			for(int j =0; j<x.length; j++){
				if(x[j].equals("Algae"))
					continue;
				Critter.everyStat(x[j]);
				Label lbl = new Label(testOutputString.toString());
				vb2.getChildren().add(lbl);
    			vb2.setSpacing(1);
    			vb2.setAlignment(Pos.BASELINE_LEFT);
    			vb2.setPadding(new Insets(0, 0 , 0, 3));
	    		testOutputString.reset();
				
			}
		} catch (IllegalAccessException | InstantiationException | InvalidCritterException e) {
			
		}
	}
	
}
