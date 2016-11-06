package assignment5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import assignment5.Algae;
import assignment5.Critter;
import assignment5.Params;

public abstract class Critter {
	/* NEW FOR PROJECT 5 */
	public enum CritterShape {
		CIRCLE,//0
		SQUARE,//1
		TRIANGLE,//2
		DIAMOND,//3
		STAR//4
	}
	
	/* the default color is white, which I hope makes critters invisible by default
	 * If you change the background color of your View component, then update the default
	 * color to be the same as you background 
	 * 
	 * critters must override at least one of the following three methods, it is not 
	 * proper for critters to remain invisible in the view
	 * 
	 * If a critter only overrides the outline color, then it will look like a non-filled 
	 * shape, at least, that's the intent. You can edit these default methods however you 
	 * need to, but please preserve that intent as you implement them. 
	 */
	public javafx.scene.paint.Color viewColor() { 
		return javafx.scene.paint.Color.WHITE; 
	}
	
	public javafx.scene.paint.Color viewOutlineColor() { return viewColor(); }
	public javafx.scene.paint.Color viewFillColor() { return viewColor(); }
	
	public abstract CritterShape viewShape(); 
	
	private static String myPackage;
	private	static List<Critter> population = new java.util.ArrayList<Critter>();
	private static List<Critter> babies = new java.util.ArrayList<Critter>();
	private static Critter occupied;
	private int cnt = 0;

	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}
	
	protected String look(int direction, boolean steps) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(steps){
			for(int i = 0; i <2; i++){
				switch (direction)
				{
				case 0 :
					if(i == 0 || checkPosition((x_coord+1)%Params.world_width, y_coord)){
						break;
					}
					else{
						int index = myPackage.length()+7;	
						String buche;
						buche = occupied.getClass().toString().substring(index);
						buche = "look " + buche;
						Method method = null;
							try{
								Class<?> c = occupied.getClass();
								method =  c.getDeclaredMethod("toString", String.class);
							}catch(NoSuchMethodException e){
								processing(buche);
							}
						this.energy -= Params.look_energy_cost;
						return ((String)method.invoke(null, "")); //return toString of Critter
					}
				case 1 :
					if(i == 0 || checkPosition((x_coord+1)%Params.world_width, (y_coord+1)%Params.world_height)){
						break;
					}
					else{
						int index = myPackage.length()+7;	
						String buche;
						buche = occupied.getClass().toString().substring(index);
						buche = "look " + buche;
						Method method = null;
							try{
								Class<?> c = occupied.getClass();
								method =  c.getDeclaredMethod("toString", String.class);
							}catch(NoSuchMethodException e){
								processing(buche);
							}
						this.energy -= Params.look_energy_cost;
						return ((String)method.invoke(null, ""));//return toString of Critter
					}
				case 2 :
					if(i == 0 || checkPosition(x_coord, (y_coord+1)%Params.world_height)){
						break;
					}
					else{
						int index = myPackage.length()+7;	
						String buche;
						buche = occupied.getClass().toString().substring(index);
						buche = "look " + buche;
						Method method = null;
							try{
								Class<?> c = occupied.getClass();
								method =  c.getDeclaredMethod("toString", String.class);
							}catch(NoSuchMethodException e){
								processing(buche);
							}
						this.energy -= Params.look_energy_cost;
						return ((String)method.invoke(null, "")); //return toString of Critter
					}
				case 3:
					if(i == 0 || checkPosition((Params.world_width+x_coord-1)%Params.world_width, (y_coord+1)%Params.world_height)){
						break;
					}
					else{
						int index = myPackage.length()+7;	
						String buche;
						buche = occupied.getClass().toString().substring(index);
						buche = "look " + buche;
						Method method = null;
							try{
								Class<?> c = occupied.getClass();
								method =  c.getDeclaredMethod("toString", String.class);
							}catch(NoSuchMethodException e){
								processing(buche);
							}
						this.energy -= Params.look_energy_cost;
						return ((String)method.invoke(null, "")); //return toString of Critter
					}
				case 4:
					if(i == 0 || checkPosition((Params.world_width+x_coord-1)%Params.world_width, y_coord)){
						break;
					}
					else{
						int index = myPackage.length()+7;	
						String buche;
						buche = occupied.getClass().toString().substring(index);
						buche = "look " + buche;
						Method method = null;
							try{
								Class<?> c = occupied.getClass();
								method =  c.getDeclaredMethod("toString", String.class);
							}catch(NoSuchMethodException e){
								processing(buche);
							}
						this.energy -= Params.look_energy_cost;
						return ((String)method.invoke(null, "")); //return toString of Critter
					}
				case 5:
					if(i == 0 || checkPosition((Params.world_width+x_coord-1)%Params.world_width, (Params.world_height+y_coord-1)%Params.world_height)){
						break;
					}
					else{
						int index = myPackage.length()+7;	
						String buche;
						buche = occupied.getClass().toString().substring(index);
						buche = "look " + buche;
						Method method = null;
							try{
								Class<?> c = occupied.getClass();
								method =  c.getDeclaredMethod("toString", String.class);
							}catch(NoSuchMethodException e){
								processing(buche);
							}
						this.energy -= Params.look_energy_cost;
						return ((String)method.invoke(null, "")); //return toString of Critter
					}
				case 6:
					if(i == 0 || checkPosition(x_coord, (Params.world_height+y_coord-1)%Params.world_height)){
						break;
					}
					else{
						int index = myPackage.length()+7;	
						String buche;
						buche = occupied.getClass().toString().substring(index);
						buche = "look " + buche;
						Method method = null;
							try{
								Class<?> c = occupied.getClass();
								method =  c.getDeclaredMethod("toString", String.class);
							}catch(NoSuchMethodException e){
								processing(buche);
							}
						this.energy -= Params.look_energy_cost;
						return ((String)method.invoke(null, "")); //return toString of Critter
					}
				case 7:
					if(i == 0 || checkPosition((x_coord+1)%Params.world_width, (Params.world_height+y_coord-1)%Params.world_height)){
						break;
					}
					else{
						int index = myPackage.length()+7;	
						String buche;
						buche = occupied.getClass().toString().substring(index);
						buche = "look " + buche;
						Method method = null;
							try{
								Class<?> c = occupied.getClass();
								method =  c.getDeclaredMethod("toString", String.class);
							}catch(NoSuchMethodException e){
								processing(buche);
							}
						this.energy -= Params.look_energy_cost;
						return ((String)method.invoke(null, ""));//return toString of Critter
					}
				}
			}
		}
		else{
			switch (direction)
			{
			case 0 :
				if(checkPosition((x_coord+1)%Params.world_width, y_coord)){
					break;
				}
				else{
					int index = myPackage.length()+7;	
					String buche;
					buche = occupied.getClass().toString().substring(index);
					buche = "look " + buche;
					Method method = null;
						try{
							Class<?> c = occupied.getClass();
							method =  c.getDeclaredMethod("toString", String.class);
						}catch(NoSuchMethodException e){
							processing(buche);
						}
					this.energy -= Params.look_energy_cost;
					return ((String)method.invoke(null, "")); //return toString of Critter
				}
			case 1 :
				if(checkPosition((x_coord+1)%Params.world_width, (y_coord+1)%Params.world_height)){
					break;
				}
				else{
					int index = myPackage.length()+7;	
					String buche;
					buche = occupied.getClass().toString().substring(index);
					buche = "look " + buche;
					Method method = null;
						try{
							Class<?> c = occupied.getClass();
							method =  c.getDeclaredMethod("toString", String.class);
						}catch(NoSuchMethodException e){
							processing(buche);
						}
					this.energy -= Params.look_energy_cost;
					return ((String)method.invoke(null, "")); //return toString of Critter
				}
			case 2 :
				if(checkPosition(x_coord, (y_coord+1)%Params.world_height)){
					break;
				}
				else{
					int index = myPackage.length()+7;	
					String buche;
					buche = occupied.getClass().toString().substring(index);
					buche = "look " + buche;
					Method method = null;
						try{
							Class<?> c = occupied.getClass();
							method =  c.getDeclaredMethod("toString", String.class);
						}catch(NoSuchMethodException e){
							processing(buche);
						}
					this.energy -= Params.look_energy_cost;
					return ((String)method.invoke(null, "")); //return toString of Critter
				}
			case 3:
				if(checkPosition((Params.world_width+x_coord-1)%Params.world_width, (y_coord+1)%Params.world_height)){
					break;
				}
				else{
					int index = myPackage.length()+7;	
					String buche;
					buche = occupied.getClass().toString().substring(index);
					buche = "look " + buche;
					Method method = null;
						try{
							Class<?> c = occupied.getClass();
							method =  c.getDeclaredMethod("toString", String.class);
						}catch(NoSuchMethodException e){
							processing(buche);
						}
					this.energy -= Params.look_energy_cost;
					return ((String)method.invoke(null, "")); //return toString of Critter
				}
			case 4:
				if(checkPosition((Params.world_width+x_coord-1)%Params.world_width, y_coord)){
					break;
				}
				else{
					int index = myPackage.length()+7;	
					String buche;
					buche = occupied.getClass().toString().substring(index);
					buche = "look " + buche;
					Method method = null;
						try{
							Class<?> c = occupied.getClass();
							method =  c.getDeclaredMethod("toString", String.class);
						}catch(NoSuchMethodException e){
							processing(buche);
						}
					this.energy -= Params.look_energy_cost;
					return ((String)method.invoke(null, "")); //return toString of Critter
				}
			case 5:
				if(checkPosition((Params.world_width+x_coord-1)%Params.world_width, (Params.world_height+y_coord-1)%Params.world_height)){
					break;
				}
				else{
					int index = myPackage.length()+7;	
					String buche;
					buche = occupied.getClass().toString().substring(index);
					buche = "look " + buche;
					Method method = null;
						try{
							Class<?> c = occupied.getClass();
							method =  c.getDeclaredMethod("toString", String.class);
						}catch(NoSuchMethodException e){
							processing(buche);
						}
					this.energy -= Params.look_energy_cost;
					return ((String)method.invoke(null, "")); //return toString of Critter
				}
			case 6:
				if(checkPosition(x_coord, (Params.world_height+y_coord-1)%Params.world_height)){
					break;
				}
				else{
					int index = myPackage.length()+7;	
					String buche;
					buche = occupied.getClass().toString().substring(index);
					buche = "look " + buche;
					Method method = null;
						try{
							Class<?> c = occupied.getClass();
							method =  c.getDeclaredMethod("toString", String.class);
						}catch(NoSuchMethodException e){
							processing(buche);
						}
					this.energy -= Params.look_energy_cost;
					return ((String)method.invoke(null, "")); //return toString of Critter
				}
			case 7:
				if(checkPosition((x_coord+1)%Params.world_width, (Params.world_height+y_coord-1)%Params.world_height)){
					break;
				}
				else{
					int index = myPackage.length()+7;	
					String buche;
					buche = occupied.getClass().toString().substring(index);
					buche = "look " + buche;
					Method method = null;
						try{
							Class<?> c = occupied.getClass();
							method =  c.getDeclaredMethod("toString", String.class);
						}catch(NoSuchMethodException e){
							processing(buche);
						}
					this.energy -= Params.look_energy_cost;
					return ((String)method.invoke(null, "")); //return toString of Critter
				}
			}
		}
		
		this.energy -= Params.look_energy_cost;
		return null;
		}
	
	/* rest is unchanged from Project 4 */
	
	
	private static java.util.Random rand = new java.util.Random();
	public static int getRandomInt(int max) {
		return rand.nextInt(max);
	}
	
	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}
	
	
	/* a one-character long string that visually depicts your critter in the ASCII interface */
	public String toString() { return ""; }
	
	private int energy = 0;
	protected int getEnergy() { return energy; }
	
	private int x_coord;
	private int y_coord;
	private boolean moved = false;
	
	/**
	 * This method determines whether a Critter can move to the desired position
	 * it also takes into account when the run() or walk() methods are
	 * called in the fight method.
	 * 
	 *@param direction specifies what direction the critter want to move to.
	 * */
	protected final void change(int direction) {	
		
		switch (direction)
		{
		case 0 :
			if(!moved || checkPosition((x_coord+1)%Params.world_width, y_coord) || cnt == 0){
				if(!checkPosition((x_coord+1)%Params.world_width, y_coord))
					moved = false;
				else
					moved = true;
				x_coord= (x_coord+1)%Params.world_width;
			}
			else{
				moved = false;
				change(4);
			}
			break;
		case 1 :
			if(!moved || checkPosition((x_coord+1)%Params.world_width, (y_coord+1)%Params.world_height) || cnt == 0){
				if(checkPosition((x_coord+1)%Params.world_width, (y_coord+1)%Params.world_height))
					moved = false;
				else
					moved = true;
				x_coord =(x_coord+1)%Params.world_width;
				y_coord = (y_coord+1)%Params.world_height;
			}
			else{
				moved = false;
				change(5);
			}
			break;
		case 2 :
			if(!moved || checkPosition(x_coord, (y_coord+1)%Params.world_height) || cnt == 0){
				if(checkPosition(x_coord, (y_coord+1)%Params.world_height))
					moved = false;
				else
					moved = true;
				y_coord = (y_coord+1)%Params.world_height;
			}
			else{
				moved = false;
				change(6);
			}
			break;
		case 3:
			if(!moved || checkPosition((Params.world_width+x_coord-1)%Params.world_width, (y_coord+1)%Params.world_height) || cnt == 0){
				if(checkPosition((Params.world_width+x_coord-1)%Params.world_width, (y_coord+1)%Params.world_height))
					moved = false;
				else
					moved = true;
				x_coord = (Params.world_width+x_coord-1)%Params.world_width;
				y_coord = (y_coord+1)%Params.world_height;
			}
			else{
				moved = false;
				change(7);
			}
			break;
		case 4:
			if(!moved || checkPosition((Params.world_width+x_coord-1)%Params.world_width, y_coord) || cnt == 0){
				if(checkPosition((Params.world_width+x_coord-1)%Params.world_width, y_coord))
					moved = false;
				else
					moved = true;
				x_coord = (Params.world_width+x_coord-1)%Params.world_width;
			}
			else{
				moved = false;
				change(0);
			}
			break;
		case 5:
			if(!moved || checkPosition((Params.world_width+x_coord-1)%Params.world_width, (Params.world_height+y_coord-1)%Params.world_height) || cnt == 0){
				if(checkPosition((Params.world_width+x_coord-1)%Params.world_width, (Params.world_height+y_coord-1)%Params.world_height))
					moved = false;
				else
					moved = true;
				x_coord = (Params.world_width+x_coord-1)%Params.world_width;
				y_coord = (Params.world_height+y_coord-1)%Params.world_height;
			}
			else{
				moved = false;
				change(1);
			}
			break;
		case 6:
			if(!moved || checkPosition(x_coord, (Params.world_height+y_coord-1)%Params.world_height) || cnt == 0){
				if(checkPosition(x_coord, (Params.world_height+y_coord-1)%Params.world_height))
					moved = false;
				else
					moved = true;
				y_coord=(Params.world_height+y_coord-1)%Params.world_height;
			}
			else{
				moved = false;
				change(2);
			}
			break;
		case 7:
			if(!moved || checkPosition((x_coord+1)%Params.world_width, (Params.world_height+y_coord-1)%Params.world_height) || cnt == 0){
				if(checkPosition((x_coord+1)%Params.world_width, (Params.world_height+y_coord-1)%Params.world_height))
					moved = false;
				else
					moved = true;
				x_coord = (x_coord+1)%Params.world_width;
				y_coord = (Params.world_height+y_coord-1)%Params.world_height;
			}
			else{
				moved = false;
				change(3);
			}
			break;
		}
		
	}
	
	protected final void walk(int direction) {
		if (!moved){
			moved = true;
			change(direction);
			if(cnt == 1 && !moved){
				change(direction);
			}
		}
		moved=true;
		energy= energy-Params.walk_energy_cost;
	}
	
	protected final void run(int direction) {
		if (!moved) {
			change(direction);
			moved = true;
			change(direction);
		}
		moved = true;
		energy = energy - Params.run_energy_cost;
	}
	
	protected final void reproduce(Critter offspring, int direction) {
		if (this.energy<Params.min_reproduce_energy) return;
		
		int[] x = directiontomove(direction);
		offspring.energy= this.energy/2;//rounding down the energy of the child
		this.energy= this.energy/2 + this.energy%2; //rounding up the energy of parent
		offspring.x_coord= x[0];
		offspring.y_coord = x[1];
		
		babies.add(offspring);
	}
	
	/**
	 * This method moves returns the offspring desired new location
	 * 
	 * @param direction desired direction to move
	 *  
	 * @return returns a 2 dimensional array with the direction of the 
	 * offspring
	 * */
	protected final int[] directiontomove(int direction) 
	{
		int[] x = new int[2];
				switch (direction) 
				{
					case 0 :
						x[0]= (this.x_coord+1)%Params.world_width;
						x[1] = this.y_coord;
						break;
					case 1 :
						x[0] =(this.x_coord+1)%Params.world_width;
						x[1]= (this.y_coord+1)%Params.world_height;
						break;
					case 2 :
						x[0] = this.x_coord;
						x[1]= (this.y_coord+1)%Params.world_height;
						break;
					case 3:
						x[0]= (Params.world_width+this.x_coord-1)%Params.world_width;
						x[1]= (this.y_coord+1)%Params.world_height;
						break;
					case 4:
						x[0]= (Params.world_width+this.x_coord-1)%Params.world_width;
						x[1] = this.y_coord;
						break;
					case 5:
						x[0]= (Params.world_width+this.x_coord-1)%Params.world_width;
						x[1]=(Params.world_height+this.y_coord-1)%Params.world_height;
						break;
					case 6:
						x[0] = this.x_coord;
						x[1]=(Params.world_height+this.y_coord-1)%Params.world_height;
						break;
					case 7:
						x[0]= (this.x_coord+1)%Params.world_width;
						x[1]=(Params.world_height+this.y_coord-1)%Params.world_height;
						break;
				}
				return x;
	}

	public abstract void doTimeStep() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public abstract boolean fight(String oponent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	
	public static void worldTimeStep() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//adding babies first since the first time it will be empty
				//therefore new babies will be added at the second time
				for (int i=0; i< population.size(); i++)
				{
					Critter x = population.get(i);
					x.doTimeStep();		//we can make them fight here
					x.cnt++;	//increasing count to 1
				}
				for (int i=0; i<population.size(); i++)
				{
					Critter x = population.get(i);
					x.moved=false; 
					if (x.energy<1){
						population.remove(i);
					}
			
				}
				//do the fights
				for (int i=0; i<population.size()-1; i++)
				{
					for (int j=i+1; j<population.size(); j++)
					{
						Critter x = population.get(i);
						Critter y = population.get(j);
						//checking if critters are at the same position
						if (x.x_coord==y.x_coord && x.y_coord==y.y_coord && x.energy > 0 && y.energy > 0) //otherwise opponent is dead
						{
							int fight_number_1 = Critter.getRandomInt(x.energy);
							int fight_number_2 = Critter.getRandomInt(y.energy);
							//seeing if both want to fight
							if (x.fight(y.toString())==true){
								if (y.fight(x.toString())==true)
								{
									fightdecision(fight_number_1,fight_number_2,x,y);
								}
								else//y failed to move(run away)
								{
									if (x.x_coord==y.x_coord && x.y_coord==y.y_coord && x.energy > 0 && y.energy > 0){ //otherwise opponent is dead
										fight_number_2 = 0;
										fightdecision(fight_number_1,fight_number_2,x,y);
									}
								}
							}
							else //both failed to move (run away)
							{
								if (x.x_coord==y.x_coord && x.y_coord==y.y_coord && x.energy > 0 && y.energy > 0){ //otherwise opponent is dead
									fight_number_1 = 0;
									fightdecision(fight_number_1,fight_number_2,x,y);
								}
							}
							
						}
					}
				}
				 //substracting resting energy of critters
				for (int i=0; i<population.size(); i++)
				{					
					Critter x = population.get(i);
					x.energy= x.energy-Params.rest_energy_cost;
					x.cnt = 0;		//setting count back to 0
				}
				// deleting Critter
				for (int i=0; i<population.size(); i++)
				{
					Critter x = population.get(i);
					x.moved=false; 
					if (x.energy<1){
						population.remove(i);
					}
			
				}
				//generating algae
				for (int i=0; i<Params.refresh_algae_count; i++)
				{
					Critter x = new Algae();
					x.energy= Params.start_energy;
					x.x_coord= Critter.getRandomInt(Params.world_width-1);
					x.y_coord= Critter.getRandomInt(Params.world_height-1);
					population.add(x);
				}
				
				//new to see the encounter
				for (int i=0; i<babies.size();i++)
				{
					population.add(babies.get(i));
				}
				babies.clear();
	}
	
	public static void displayWorld() {
		List<Critter> copy_population= new java.util.ArrayList<Critter>();
		List<Critter> copy_babies= new java.util.ArrayList<Critter>();
		for(Critter e : population)
			copy_population.add(e);
		for(Critter m: babies)
			copy_babies.add(m);
		
		for(int i=0; i<Params.world_width+2; i++)
		{
			for(int j=0; j<Params.world_height+2; j++)
			{
				if ((i==0 &&j==0)||(i==0 && j==Params.world_height+1)|| (i==Params.world_width+1 && j==0)|| (i==Params.world_width+1 && j==Params.world_height+1))
					System.out.print("+");
				else if (i==0 || i==Params.world_width+1)
					System.out.print("-");
				else if (j==0 || j==Params.world_height+1)
					System.out.print("|");
				else 
				{
					boolean flag=false;
					for (int k=0; k<copy_population.size(); k++)
					{
						Critter to_check = copy_population.get(k);
						if (to_check.x_coord==i-1 && to_check.y_coord==j-1)
						{
							System.out.print(to_check);
							copy_population.remove(k);
							flag=true;
							break;
						}
					}//not sure if we have to print babies
					if (flag==false)
						for (int l=0; l<copy_babies.size(); l++)
						{
							Critter to_check = copy_babies.get(l);
							if (to_check.x_coord==i-1 && to_check.y_coord==j-1)
							{
								System.out.print(to_check);
								copy_babies.remove(l);
								flag=true;
								break;
							}
						}
					if (flag==false) System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	/* create and initialize a Critter subclass
	 * critter_class_name must be the name of a concrete subclass of Critter, if not
	 * an InvalidCritterException must be thrown
	 */
	@SuppressWarnings("unused")
	public static void makeCritter(String critter_class_name) throws InvalidCritterException, IllegalAccessException, InstantiationException {
		String critter_class_name1 = myPackage + "." + critter_class_name;
		Class<?> c = "foo".getClass();
		try {
			Class<?> x = Class.forName(critter_class_name1);
			c=x;
			Critter check = (Critter)x.newInstance();
		} catch(NoClassDefFoundError e){
			return;
		}catch (ClassNotFoundException e1) {
			return;
		}catch (InstantiationException e2) {
			return;
		}catch(ClassCastException e3){
			return;
		}
		//System.out.println(c);
		Critter z = (Critter) c.newInstance();
		z.x_coord= getRandomInt(Params.world_width-1);
		z.y_coord =  getRandomInt(Params.world_height-1);
		z.energy = Params.start_energy;
		population.add(z);
	}
	
	@SuppressWarnings("unused")
	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException, IllegalAccessException, InstantiationException {
		List<Critter> result = new java.util.ArrayList<Critter>();
		String critter_class_name1 = myPackage + "." + critter_class_name;
		Class<?> c = "foo".getClass();
		try {
			Class<?> x = Class.forName(critter_class_name1);
			c=x;
			Critter check = (Critter)x.newInstance();
		}catch(NoClassDefFoundError e){
			return result;//thinking...
		}catch (ClassNotFoundException e1) {
			return result;//thinking....
		}catch (InstantiationException e2) {
			return result;//thinking....
		}
		Critter check1 = (Critter)c.newInstance();
		result.add(check1);
		for(Critter e : population){
			if(e.getClass().isInstance(check1))
				result.add(e);
		}
		return result;
	}
	
	public static void runStats(List<Critter> critters) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int index = myPackage.length()+7;	
		String buche;
		buche = critters.get(0).getClass().toString().substring(index);
		buche = "stats " + buche;
			try{
				Class<?> c = critters.get(0).getClass();
				Method method =  c.getDeclaredMethod("runStats", List.class);
				critters.remove(0);
				method.invoke(null, critters);
			}catch(NoSuchMethodException e){
				processing(buche);
			}
	}
	
	/* the TestCritter class allows some critters to "cheat". If you want to 
	 * create tests of your Critter model, you can create subclasses of this class
	 * and then use the setter functions contained here. 
	 * 
	 * NOTE: you must make sure thath the setter functions work with your implementation
	 * of Critter. That means, if you're recording the positions of your critters
	 * using some sort of external grid or some other data structure in addition
	 * to the x_coord and y_coord functions, then you MUST update these setter functions
	 * so that they correctup update your grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}
		
		protected void setX_coord(int new_x_coord) {
			super.x_coord = new_x_coord;
		}
		
		protected void setY_coord(int new_y_coord) {
			super.y_coord = new_y_coord;
		}
		
		protected int getX_coord() {
			return super.x_coord;
		}
		
		protected int getY_coord() {
			return super.y_coord;
		}
		

		/*
		 * This method getPopulation has to be modified by you if you are not using the population
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.
		 */
		protected static List<Critter> getPopulation() {
			return population;
		}
		
		/*
		 * This method getBabies has to be modified by you if you are not using the babies
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.  Babies should be added to the general population 
		 * at either the beginning OR the end of every timestep.
		 */
		protected static List<Critter> getBabies() {
			return babies;
		}
		
		public static int[] getposition(Critter x)
		{
			int[] y= new int[2];
			
			y[0]=x.x_coord;
			y[1]=x.y_coord;
			return y;
			
		}
	}
	
	/**
	 * Clear the world of all critters, dead and alive
	 */
	public static void clearWorld() {
		for(Critter e: population){
			population.remove(e);
		}
	}
	/**
	 * decides which critter wins in the fight and rewards and kills the respective one
	 * 
	 * @param fight_number_1 roll dice number obtained for critter x
	 * @param fight_number_2 roll dice number obtained for critter y
	 * @param x one of the critter to fight
	 * @param y one of the critter to fight
	 * */
	public static void fightdecision(int fight_number_1,int fight_number_2,Critter x, Critter y)
	{
		if (fight_number_1<fight_number_2)
		{
			y.energy+=x.energy/2;
			population.remove(x);
		}
		else if (fight_number_2<fight_number_1)
		{
			x.energy+=y.energy/2;
			population.remove(y);
		}
		else 
		{
			x.energy+=y.energy/2;
			population.remove(y);
		}
	}
	public static void processing(String input){
		System.out.println("error processing: " + input);
	}
	public static void invalid(String input){
		System.out.println("invalid command: " + input);
	}
	public static boolean checkPosition(int x, int y){
		for(Critter e : population){
			if(e.x_coord == x && e.y_coord == y){
				occupied = e;
				return false;
			}
		}
		return true;
	}
	
}
