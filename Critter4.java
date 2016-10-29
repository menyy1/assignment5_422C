package assignment5;
/* CRITTERS Critter4.java
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

/**A.K.A Jeff This critter will only reproduce in the dotimestep method
 * besides that it only fight algae. Any other it runs away
 * 
 * */
public class Critter4 extends Critter{
	
	private int dir;
	
	
	public Critter4() {	
		dir = Critter.getRandomInt(8);
	}
	
	
	public String toString() { return "4"; }
	
	public boolean fight(String used){
		if (used.equals("@"))
		{
			return true;
		}
		else 
		{
			walk(dir);
			return false;
		}
	}
	
	@Override
	public void doTimeStep() {
		
		if (getEnergy() > Params.min_reproduce_energy)
		{
			Critter4 child = new Critter4();
			//setting random 
			reproduce(child, Critter.getRandomInt(8));
		}
		
		dir = Critter.getRandomInt(8);
	}
	
	public static void runStats(java.util.List<Critter> Critter4)
	{
		System.out.println("" + Critter4.size() + " total Critter4    ");
	}


	@Override
	public CritterShape viewShape() {
		// TODO Auto-generated method stub
		return null;
	}
}
