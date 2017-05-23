package animals;

import diet.Herbivore;
import diet.IDiet;
import graphics.ZooPanel;
import mobility.Point;

/**
 * Giraffe class, extends AnimalThatChews class
 * @author Elon Avisror
 *
 */

public class Giraffe extends AnimalThatChews
{
	private double neckLength;
	
	/**
	 * 
	 * @param size
	 * @param HSpeed
	 * @param VSpeed
	 * @param color
	 * @param panel
	 * @param location
	 */
	public Giraffe(int size, int HSpeed, int VSpeed, String color, ZooPanel panel, Point location)
	{
		 super(size, HSpeed, VSpeed, color, panel, location);
		 this.setWeight(size * 2.2);
		 this.loadImages("grf"); 
		 IDiet diet = new Herbivore();
		 this.setDiet(diet);
	 	 this.setName("Giraffe");
	}
	
	/**
	 * setNeckLength boolean function, sets the new neck length of giraffe
	 * @param newNeckLen
	 * @return res = result
	 */
	public boolean setNeckLength(double newNeckLen)
	{
		boolean res = false;
		if(newNeckLen >= 1 && newNeckLen <= 2.5)
		{
			this.neckLength = newNeckLen;
			res = true;
		}
		return res;
		
	}
}//class Giraffe extends AnimalThatChews