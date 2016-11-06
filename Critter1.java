package assignment5;

import java.lang.reflect.InvocationTargetException;

/* CRITTERS Critter1.java
 * EE422C Project 4 submission by
 * Manuel Lopez
 * ml36724
 * 16480
 * Rodolfo Gonzalez
 * rg36763
 * 16480
 * Slip days used: <0>
 * Fall 2016
 */
/**A.K.A Canival this critter only fights the algae and itself 
 * any other critter it decides to run away
 * it randomly decides to move,run, or reproduce
 * */
public class Critter1 extends Critter{
	
	private int dir;
	
	public Critter1(){
		dir = Critter.getRandomInt(8);
	}
	
	public String toString() { return "1"; }
	
	public boolean fight(String used ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		if (used.equals("1") || used.equals("@"))
			return true;
		else 
		{
			String compare =look(dir,false);
			if (compare==null)
				return false;
			if (!compare.equals("1")&& !compare.equals("@"))
				walk(dir);
			return  false;
		}
	}
	
	public void doTimeStep(){
		
		int x = Critter.getRandomInt(100)%3;
		
		if (x==0)
		{
			walk(dir);
		}
		else if (x==1)
		{
			run(dir);
		}
		else
		{
			if (getEnergy()>Params.min_reproduce_energy)
			{
				Critter1 child = new Critter1();
				reproduce(child, Critter.getRandomInt(8));
			}
		}
		dir =  Critter.getRandomInt(8);
	}
	
	public static void runStats(java.util.List<Critter> Critter1)
	{
		System.out.println("" + Critter1.size() + " total Critter1    ");
	}

	@Override
	public CritterShape viewShape() { return CritterShape.TRIANGLE; }
	
	@Override
	public javafx.scene.paint.Color viewOutlineColor() {return javafx.scene.paint.Color.RED;}
}
