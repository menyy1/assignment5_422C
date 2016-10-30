package assignment5;
/* CRITTERS Critter2.java
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

import java.lang.reflect.InvocationTargetException;

import assignment5.Critter.CritterShape;

/**
 * A.K.A Uknown critter it randomly makes its decision.
 * It is the wild card critter
 * */
public class Critter2 extends Critter{

	private int dir; 
	
	public String toString() {return "2";}
	
	public Critter2(){
		dir = Critter.getRandomInt(8);
	}
	
	@Override
	public boolean fight(String not_used)
	{
		int x =Critter.getRandomInt(100)%2;
		if (x==0)
			return true;
		else 
		{
			walk(dir);
			return false;
		}
	}
	
	public void doTimeStep() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		int x = Critter.getRandomInt(100)%3;
		
		if (x==0)
		{
			if (look(dir,false).isEmpty())
				walk(dir);
		}
		else if (x==1)
		{
			if (look(dir,false).isEmpty())
				run(dir);
		}
		else
		{
			if (getEnergy()>Params.min_reproduce_energy)
			{
				Critter2 child = new Critter2();
				reproduce(child, Critter.getRandomInt(7));
			}
		}
		dir =  Critter.getRandomInt(8);
	}
	
	public static void runStats(java.util.List<Critter> Critter2)
	{
		System.out.println("" + Critter2.size() + " total Critter2    ");
	}

	@Override
	public CritterShape viewShape() { return CritterShape.CIRCLE; }
	
	@Override
	public javafx.scene.paint.Color viewOutlineColor() {return javafx.scene.paint.Color.BLACK;}
}
