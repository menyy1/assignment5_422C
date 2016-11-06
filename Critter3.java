package assignment5;
/* CRITTERS Critter3.java
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

/** A.K.A Maximux it is the warrior critter it always fights critter
 * that are not of its kind. It will only reproduce after it was won
 * a battle and it randomly decides to walk in the doTimeStep function
 **/
public class Critter3 extends Critter{
	
	private int dir;
	private boolean wonfight=false;
	
	public String toString(){return "3";}
	
	public Critter3(){

		dir = Critter.getRandomInt(8);
	}
	
	public boolean fight (String used)
	{
		if (used.equals("3")){
			walk(dir);
			return false;
		}
		else 
		{
			wonfight=true;
			return true;
		}
	}
	
	@Override
	public void doTimeStep(){
		if (wonfight==true )
		{
			if (getEnergy()>Params.min_reproduce_energy)
			{
				Critter3 child = new Critter3();
				reproduce(child , Critter.getRandomInt(8));
			}
			else//means he is to tired to move so he has to conserve energy
				return;
		}
		if (Critter.getRandomInt(20)%2 ==1) {run(dir);}
			dir = Critter.getRandomInt(8);
	}
	
	public static void runStats(java.util.List<Critter> Critter3)
	{
		System.out.println("" + Critter3.size() + " total Critter3    ");
	}

	@Override
	public CritterShape viewShape() { return CritterShape.STAR; }
	
	@Override
	public javafx.scene.paint.Color viewOutlineColor() {return javafx.scene.paint.Color.GOLD;}
}
